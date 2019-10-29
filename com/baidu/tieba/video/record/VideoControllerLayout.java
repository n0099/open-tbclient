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
    private int fMR;
    private i jDk;
    private ImageView jFS;
    private RelativeLayout jFT;
    private VideoRecordButton jFU;
    private ImageView jFV;
    private long jFW;
    private boolean jFX;
    private List<ObjectAnimator> jFY;
    private a jFZ;
    private AnimatorSet jFg;
    private AnimatorSet jFh;
    private boolean jGa;
    private boolean jGb;
    private List<e> jGc;
    private List<e> jGd;
    private List<StickerItem> jGe;
    private List<e> jGf;
    private VideoEffectLayout jGg;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void cvB();

        void cvC();

        void cvD();

        void cvE();

        void cvF();

        void cvG();

        void cvH();

        void cvI();

        void cvJ();

        void cvq();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jFW = 0L;
        this.jFX = false;
        this.jGa = true;
        this.jGc = new ArrayList();
        this.jGd = new ArrayList();
        this.jGe = new ArrayList();
        this.jGf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFW = 0L;
        this.jFX = false;
        this.jGa = true;
        this.jGc = new ArrayList();
        this.jGd = new ArrayList();
        this.jGe = new ArrayList();
        this.jGf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFW = 0L;
        this.jFX = false;
        this.jGa = true;
        this.jGc = new ArrayList();
        this.jGd = new ArrayList();
        this.jGe = new ArrayList();
        this.jGf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jGg = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jFT = (RelativeLayout) findViewById(R.id.layout_record);
        this.jFS = (ImageView) findViewById(R.id.delete_video);
        this.jFS.setOnClickListener(this);
        this.jFU = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jFU.setOnTouchListener(this);
        this.jFV = (ImageView) findViewById(R.id.confirm_video);
        this.jFV.setOnClickListener(this);
        this.jGf.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jGf.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jDk = iVar;
        Bg(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jGg != null) {
            this.jGg.setListener(aVar);
        }
    }

    public void Bg(int i) {
        this.jDk.setStatus(i);
        if (this.jFZ != null) {
            this.jFZ.cvJ();
        }
        if (i == 1) {
            this.jFS.setVisibility(8);
            this.jFV.setVisibility(8);
        } else if (i == 3) {
            this.jFS.setImageResource(R.drawable.video_back_selector);
            this.jFV.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jFS.setImageResource(R.drawable.video_back_selector);
            this.jFV.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jFS.setImageResource(R.drawable.video_delete_selector);
            if (this.jDk != null && this.jDk.getVideoDuration() >= 3000.0f) {
                this.jFV.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jFV.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jFS) {
            if (this.jFZ != null) {
                this.jFZ.cvI();
            }
            int status = this.jDk.getStatus();
            if (this.jDk != null && this.jDk.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jDk.cvj();
                    eG(this.jGc);
                    eG(this.jGd);
                    eG(this.jGe);
                    if (this.jDk.getVideoDuration() >= 3000.0f) {
                        Bg(4);
                        return;
                    } else {
                        Bg(this.jDk.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jDk.cvi();
                Bg(5);
            }
        } else if (view == this.jFV) {
            TiebaStatic.log("c12300");
            if (this.jDk != null && this.jDk.getStatus() > 2 && this.jFZ != null) {
                if (this.jDk.getVideoDuration() >= 3000.0f) {
                    this.jFZ.cvG();
                } else {
                    this.jFZ.cvH();
                }
            }
        }
    }

    private void eG(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(final boolean z) {
        if (this.jDk.getProgress() >= 100) {
            if (this.jFZ != null) {
                this.jFZ.cvG();
                return;
            }
            return;
        }
        if (this.jGg.getCurrentBeautyItem() != null) {
            this.jGc.add(this.jGg.getCurrentBeautyItem());
        }
        if (this.jGg.getCurrentFilterItem() != null) {
            this.jGd.add(this.jGg.getCurrentFilterItem());
        }
        if (this.jGg.getCurrentStickItem() != null) {
            this.jGe.add(this.jGg.getCurrentStickItem());
        }
        Bg(2);
        if (this.jGg.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jDk.getStatus() == 6 || VideoControllerLayout.this.jDk.aoC()) {
                        VideoControllerLayout.this.rA(z);
                    }
                }
            });
        } else {
            rA(z);
        }
        if (this.jDk != null) {
            this.jDk.startRecord();
        }
        if (this.jFZ != null) {
            this.jFZ.cvB();
        }
    }

    public void stopRecord() {
        cvN();
        int status = this.jDk.getStatus();
        if (this.jDk != null) {
            if (!this.jDk.cvk() && this.jDk.aoC()) {
                this.jDk.stopRecord();
            }
            cvM();
        }
        if (this.jFZ != null) {
            this.jFZ.cvq();
            if (status == 6) {
                this.jFZ.cvD();
            }
        }
    }

    public void cvM() {
        if (this.jDk != null) {
            if (this.jDk.getVideoDuration() >= 3000.0f) {
                Bg(4);
            } else if (this.jDk.getVideoDuration() > 0) {
                Bg(3);
            } else {
                Bg(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(boolean z) {
        if (this.jFh != null && this.jFh.isRunning()) {
            this.jFh.cancel();
        }
        if (this.jFg == null) {
            this.jFg = new AnimatorSet();
            this.jFg.playTogether(ObjectAnimator.ofFloat(this.jFS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFV, "alpha", 1.0f, 0.0f));
            this.jFg.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGT) {
                        VideoControllerLayout.this.jFS.setVisibility(8);
                        VideoControllerLayout.this.jFV.setVisibility(8);
                    }
                }
            });
            this.jFg.setDuration(300L);
        }
        this.jFg.start();
        if (this.jDk.getStatus() != 6) {
            this.jFU.rA(z);
        }
    }

    public void cvN() {
        if (this.jDk == null || this.jDk.aoC() || this.jDk.getStatus() == 6) {
            if (this.jFg != null && this.jFg.isRunning()) {
                this.jFg.cancel();
            }
            if (this.jFh == null) {
                this.jFh = new AnimatorSet();
                this.jFh.playTogether(ObjectAnimator.ofFloat(this.jFS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFV, "alpha", 0.0f, 1.0f));
                this.jFh.setDuration(300L);
            }
            this.jFS.setVisibility(0);
            this.jFV.setVisibility(0);
            this.jFh.start();
            if (this.jDk.getStatus() != 7 && this.jDk.getStatus() != 6) {
                this.jFU.cvN();
                return;
            }
            this.jFU.getTvTip().setVisibility(8);
            if (this.fMR == 2) {
                this.jFU.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fMR) {
            case 1:
                f(view, motionEvent);
                return true;
            case 2:
                e(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void e(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jFZ != null) {
                    this.jFZ.cvI();
                }
                if (this.jDk.getStatus() != 7 && this.jDk.getStatus() != 6) {
                    if (this.jDk != null && this.jDk.cvh()) {
                        this.jGb = true;
                        com.baidu.tbadk.core.util.e.alW().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jFW = currentTimeMillis;
                    this.jFX = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jFX && VideoControllerLayout.this.jFW == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.aY(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jGb) {
                    this.jGb = false;
                    return;
                }
                this.jFX = false;
                if (this.jDk.aoC() || this.jDk.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jDk.getStatus() != 8) {
                    aY(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void f(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jDk.getStatus() == 6) {
                    this.jDk.setStatus(1);
                    if (this.jFZ != null) {
                        this.jFZ.cvD();
                        this.jFZ.cvq();
                    }
                    this.jFU.getTvTip().setText("");
                    this.jFU.getTvTip().setVisibility(8);
                    return;
                } else if (this.jGg.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jFZ != null) {
                    this.jFZ.cvC();
                    this.jFU.cvY();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jFU.cvZ();
                return;
            default:
                return;
        }
    }

    public void cvw() {
        if (this.jGg.getVisibility() == 0) {
            a((m) null);
        }
        rA(false);
        this.jFU.getLayer1().setVisibility(8);
        this.jFU.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jFU.getTvTip().setVisibility(0);
        if (this.jFZ != null) {
            this.jFZ.cvB();
        }
    }

    public void cvO() {
        if (this.jDk.getStatus() == 6) {
            if (this.fMR == 2) {
                Bg(7);
                this.jFU.setAlpha(1.0f);
                this.jFS.setVisibility(8);
                this.jFV.setVisibility(8);
                this.jFU.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jDk != null) {
                    this.jDk.startRecord();
                    return;
                }
                return;
            }
            this.jFU.getTvTip().setVisibility(8);
            if (this.jFZ != null) {
                this.jFZ.cvC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        if (cvR() && this.jGg.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cvR()) {
            cvQ();
        }
        this.jGg.cvx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        if (cvR() && this.jGg.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cvR()) {
            cvQ();
        }
        this.jGg.cvy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvz() {
        if (cvR() && this.jGg.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cvR()) {
            cvQ();
        }
        this.jGg.cvz();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvA() {
        if (cvR() && this.jGg.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cvR()) {
            cvQ();
        }
        this.jGg.cvA();
    }

    private void cvP() {
        if (v.isEmpty(this.jFY)) {
            this.jFY = new ArrayList();
            this.jFY.add(ObjectAnimator.ofFloat(this.jGg, "translationY", 1000.0f, 0.0f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFT, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFU.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFU.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFU.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFU.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFV, "scaleX", 1.0f, 0.7f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFV, "scaleY", 1.0f, 0.7f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFS, "scaleX", 1.0f, 0.7f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFS, "scaleY", 1.0f, 0.7f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFV, "alpha", 1.0f, 0.0f));
            this.jFY.add(ObjectAnimator.ofFloat(this.jFS, "alpha", 1.0f, 0.0f));
        }
    }

    private void cvQ() {
        int i = 0;
        if (this.jGg.getVisibility() != 0) {
            this.jGg.setVisibility(0);
            cvP();
            this.jFV.setEnabled(false);
            this.jFS.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jFY.size()) {
                    ObjectAnimator objectAnimator = this.jFY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jFY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jFZ != null) {
                                        VideoControllerLayout.this.jFZ.cvE();
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
        if (this.jGg.getVisibility() != 8) {
            cvP();
            this.jFV.setEnabled(true);
            this.jFS.setEnabled(true);
            if (this.jDk.getStatus() == 6 || this.jDk.aoC()) {
                this.jFS.setVisibility(8);
                this.jFV.setVisibility(8);
            } else {
                Bg(this.jDk.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jFY.size()) {
                    ObjectAnimator objectAnimator = this.jFY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jFY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jGT) {
                                        VideoControllerLayout.this.jGg.setVisibility(8);
                                        if (VideoControllerLayout.this.jFZ != null) {
                                            VideoControllerLayout.this.jFZ.cvF();
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
        this.jFZ = aVar;
    }

    public void setCurrentTab(int i) {
        this.fMR = i;
        switch (this.fMR) {
            case 1:
                this.jFS.setVisibility(4);
                this.jFV.setVisibility(4);
                this.jFU.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jDk.getStatus() != 1) {
                    this.jFS.setVisibility(0);
                    this.jFV.setVisibility(0);
                }
                this.jFU.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cvR() {
        return this.jGg.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jGg != null) {
            this.jGg.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jGg != null) {
            this.jGg.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jGg != null) {
            this.jGg.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cvS() {
        if (this.jGg != null) {
            return this.jGg.cvS();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jGa = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jGc;
    }

    public List<e> getChoosedFilterList() {
        return this.jGd;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jGe;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jGf.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jGg != null) {
            this.jGg.setMusicList(this.jGf);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void r(String str, int i, String str2) {
    }

    public void cvT() {
        if (this.jGg != null) {
            this.jGg.cvT();
        }
    }

    public void cuF() {
        if (this.jGg != null) {
            this.jGg.cuF();
        }
    }
}
