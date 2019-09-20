package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int fNy;
    private i jDs;
    private AnimatorSet jFq;
    private AnimatorSet jFr;
    private ImageView jGc;
    private RelativeLayout jGd;
    private VideoRecordButton jGe;
    private ImageView jGf;
    private long jGg;
    private boolean jGh;
    private List<ObjectAnimator> jGi;
    private a jGj;
    private boolean jGk;
    private boolean jGl;
    private List<e> jGm;
    private List<e> jGn;
    private List<StickerItem> jGo;
    private List<e> jGp;
    private VideoEffectLayout jGq;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void cxA();

        void cxL();

        void cxM();

        void cxN();

        void cxO();

        void cxP();

        void cxQ();

        void cxR();

        void cxS();

        void cxT();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jGg = 0L;
        this.jGh = false;
        this.jGk = true;
        this.jGm = new ArrayList();
        this.jGn = new ArrayList();
        this.jGo = new ArrayList();
        this.jGp = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jGg = 0L;
        this.jGh = false;
        this.jGk = true;
        this.jGm = new ArrayList();
        this.jGn = new ArrayList();
        this.jGo = new ArrayList();
        this.jGp = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jGg = 0L;
        this.jGh = false;
        this.jGk = true;
        this.jGm = new ArrayList();
        this.jGn = new ArrayList();
        this.jGo = new ArrayList();
        this.jGp = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jGq = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jGd = (RelativeLayout) findViewById(R.id.layout_record);
        this.jGc = (ImageView) findViewById(R.id.delete_video);
        this.jGc.setOnClickListener(this);
        this.jGe = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jGe.setOnTouchListener(this);
        this.jGf = (ImageView) findViewById(R.id.confirm_video);
        this.jGf.setOnClickListener(this);
        this.jGp.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jGp.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jDs = iVar;
        CA(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jGq != null) {
            this.jGq.setListener(aVar);
        }
    }

    public void CA(int i) {
        this.jDs.setStatus(i);
        if (this.jGj != null) {
            this.jGj.cxT();
        }
        if (i == 1) {
            this.jGc.setVisibility(8);
            this.jGf.setVisibility(8);
        } else if (i == 3) {
            this.jGc.setImageResource(R.drawable.video_back_selector);
            this.jGf.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jGc.setImageResource(R.drawable.video_back_selector);
            this.jGf.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jGc.setImageResource(R.drawable.video_delete_selector);
            if (this.jDs != null && this.jDs.getVideoDuration() >= 3000.0f) {
                this.jGf.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jGf.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jGc) {
            if (this.jGj != null) {
                this.jGj.cxS();
            }
            int status = this.jDs.getStatus();
            if (this.jDs != null && this.jDs.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jDs.cxt();
                    et(this.jGm);
                    et(this.jGn);
                    et(this.jGo);
                    if (this.jDs.getVideoDuration() >= 3000.0f) {
                        CA(4);
                        return;
                    } else {
                        CA(this.jDs.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jDs.cxs();
                CA(5);
            }
        } else if (view == this.jGf) {
            TiebaStatic.log("c12300");
            if (this.jDs != null && this.jDs.getStatus() > 2 && this.jGj != null) {
                if (this.jDs.getVideoDuration() >= 3000.0f) {
                    this.jGj.cxQ();
                } else {
                    this.jGj.cxR();
                }
            }
        }
    }

    private void et(List list) {
        if (!v.aa(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(final boolean z) {
        if (this.jDs.getProgress() >= 100) {
            if (this.jGj != null) {
                this.jGj.cxQ();
                return;
            }
            return;
        }
        if (this.jGq.getCurrentBeautyItem() != null) {
            this.jGm.add(this.jGq.getCurrentBeautyItem());
        }
        if (this.jGq.getCurrentFilterItem() != null) {
            this.jGn.add(this.jGq.getCurrentFilterItem());
        }
        if (this.jGq.getCurrentStickItem() != null) {
            this.jGo.add(this.jGq.getCurrentStickItem());
        }
        CA(2);
        if (this.jGq.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jDs.getStatus() == 6 || VideoControllerLayout.this.jDs.alO()) {
                        VideoControllerLayout.this.rR(z);
                    }
                }
            });
        } else {
            rR(z);
        }
        if (this.jDs != null) {
            this.jDs.startRecord();
        }
        if (this.jGj != null) {
            this.jGj.cxL();
        }
    }

    public void stopRecord() {
        cxX();
        int status = this.jDs.getStatus();
        if (this.jDs != null) {
            if (!this.jDs.cxu() && this.jDs.alO()) {
                this.jDs.stopRecord();
            }
            cxW();
        }
        if (this.jGj != null) {
            this.jGj.cxA();
            if (status == 6) {
                this.jGj.cxN();
            }
        }
    }

    public void cxW() {
        if (this.jDs != null) {
            if (this.jDs.getVideoDuration() >= 3000.0f) {
                CA(4);
            } else if (this.jDs.getVideoDuration() > 0) {
                CA(3);
            } else {
                CA(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(boolean z) {
        if (this.jFr != null && this.jFr.isRunning()) {
            this.jFr.cancel();
        }
        if (this.jFq == null) {
            this.jFq = new AnimatorSet();
            this.jFq.playTogether(ObjectAnimator.ofFloat(this.jGc, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jGf, "alpha", 1.0f, 0.0f));
            this.jFq.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jHd) {
                        VideoControllerLayout.this.jGc.setVisibility(8);
                        VideoControllerLayout.this.jGf.setVisibility(8);
                    }
                }
            });
            this.jFq.setDuration(300L);
        }
        this.jFq.start();
        if (this.jDs.getStatus() != 6) {
            this.jGe.rR(z);
        }
    }

    public void cxX() {
        if (this.jDs == null || this.jDs.alO() || this.jDs.getStatus() == 6) {
            if (this.jFq != null && this.jFq.isRunning()) {
                this.jFq.cancel();
            }
            if (this.jFr == null) {
                this.jFr = new AnimatorSet();
                this.jFr.playTogether(ObjectAnimator.ofFloat(this.jGc, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jGf, "alpha", 0.0f, 1.0f));
                this.jFr.setDuration(300L);
            }
            this.jGc.setVisibility(0);
            this.jGf.setVisibility(0);
            this.jFr.start();
            if (this.jDs.getStatus() != 7 && this.jDs.getStatus() != 6) {
                this.jGe.cxX();
                return;
            }
            this.jGe.getTvTip().setVisibility(8);
            if (this.fNy == 2) {
                this.jGe.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fNy) {
            case 1:
                i(view, motionEvent);
                return true;
            case 2:
                h(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jGj != null) {
                    this.jGj.cxS();
                }
                if (this.jDs.getStatus() != 7 && this.jDs.getStatus() != 6) {
                    if (this.jDs != null && this.jDs.cxr()) {
                        this.jGl = true;
                        com.baidu.tbadk.core.util.e.aic().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jGg = currentTimeMillis;
                    this.jGh = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jGh && VideoControllerLayout.this.jGg == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.aG(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jGl) {
                    this.jGl = false;
                    return;
                }
                this.jGh = false;
                if (this.jDs.alO() || this.jDs.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jDs.getStatus() != 8) {
                    aG(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void i(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jDs.getStatus() == 6) {
                    this.jDs.setStatus(1);
                    if (this.jGj != null) {
                        this.jGj.cxN();
                        this.jGj.cxA();
                    }
                    this.jGe.getTvTip().setText("");
                    this.jGe.getTvTip().setVisibility(8);
                    return;
                } else if (this.jGq.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jGj != null) {
                    this.jGj.cxM();
                    this.jGe.cyi();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jGe.cyj();
                return;
            default:
                return;
        }
    }

    public void cxG() {
        if (this.jGq.getVisibility() == 0) {
            a((m) null);
        }
        rR(false);
        this.jGe.getLayer1().setVisibility(8);
        this.jGe.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jGe.getTvTip().setVisibility(0);
        if (this.jGj != null) {
            this.jGj.cxL();
        }
    }

    public void cxY() {
        if (this.jDs.getStatus() == 6) {
            if (this.fNy == 2) {
                CA(7);
                this.jGe.setAlpha(1.0f);
                this.jGc.setVisibility(8);
                this.jGf.setVisibility(8);
                this.jGe.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jDs != null) {
                    this.jDs.startRecord();
                    return;
                }
                return;
            }
            this.jGe.getTvTip().setVisibility(8);
            if (this.jGj != null) {
                this.jGj.cxM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxH() {
        if (cyb() && this.jGq.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cyb()) {
            cya();
        }
        this.jGq.cxH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxI() {
        if (cyb() && this.jGq.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cyb()) {
            cya();
        }
        this.jGq.cxI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxJ() {
        if (cyb() && this.jGq.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cyb()) {
            cya();
        }
        this.jGq.cxJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxK() {
        if (cyb() && this.jGq.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cyb()) {
            cya();
        }
        this.jGq.cxK();
    }

    private void cxZ() {
        if (v.aa(this.jGi)) {
            this.jGi = new ArrayList();
            this.jGi.add(ObjectAnimator.ofFloat(this.jGq, "translationY", 1000.0f, 0.0f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGd, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGe.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGe.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGe.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGe.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGf, "scaleX", 1.0f, 0.7f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGf, "scaleY", 1.0f, 0.7f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGc, "scaleX", 1.0f, 0.7f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGc, "scaleY", 1.0f, 0.7f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGf, "alpha", 1.0f, 0.0f));
            this.jGi.add(ObjectAnimator.ofFloat(this.jGc, "alpha", 1.0f, 0.0f));
        }
    }

    private void cya() {
        int i = 0;
        if (this.jGq.getVisibility() != 0) {
            this.jGq.setVisibility(0);
            cxZ();
            this.jGf.setEnabled(false);
            this.jGc.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jGi.size()) {
                    ObjectAnimator objectAnimator = this.jGi.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jGi.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jGj != null) {
                                        VideoControllerLayout.this.jGj.cxO();
                                    }
                                }
                            });
                        }
                        objectAnimator.start();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(final m mVar) {
        if (this.jGq.getVisibility() != 8) {
            cxZ();
            this.jGf.setEnabled(true);
            this.jGc.setEnabled(true);
            if (this.jDs.getStatus() == 6 || this.jDs.alO()) {
                this.jGc.setVisibility(8);
                this.jGf.setVisibility(8);
            } else {
                CA(this.jDs.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jGi.size()) {
                    ObjectAnimator objectAnimator = this.jGi.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jGi.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jHd) {
                                        VideoControllerLayout.this.jGq.setVisibility(8);
                                        if (VideoControllerLayout.this.jGj != null) {
                                            VideoControllerLayout.this.jGj.cxP();
                                        }
                                        if (mVar != null) {
                                            mVar.onAnimationEnd(animator);
                                        }
                                    }
                                }
                            });
                        }
                        objectAnimator.reverse();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void setRecordControlListener(a aVar) {
        this.jGj = aVar;
    }

    public void setCurrentTab(int i) {
        this.fNy = i;
        switch (this.fNy) {
            case 1:
                this.jGc.setVisibility(4);
                this.jGf.setVisibility(4);
                this.jGe.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jDs.getStatus() != 1) {
                    this.jGc.setVisibility(0);
                    this.jGf.setVisibility(0);
                }
                this.jGe.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cyb() {
        return this.jGq.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jGq != null) {
            this.jGq.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jGq != null) {
            this.jGq.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jGq != null) {
            this.jGq.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cyc() {
        if (this.jGq != null) {
            return this.jGq.cyc();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jGk = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jGm;
    }

    public List<e> getChoosedFilterList() {
        return this.jGn;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jGo;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jGp.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jGq != null) {
            this.jGq.setMusicList(this.jGp);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cyd() {
        if (this.jGq != null) {
            this.jGq.cyd();
        }
    }

    public void cwR() {
        if (this.jGq != null) {
            this.jGq.cwR();
        }
    }
}
