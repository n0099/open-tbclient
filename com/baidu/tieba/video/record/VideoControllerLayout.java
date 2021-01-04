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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jCC;
    private Handler mHandler;
    private i nKF;
    private AnimatorSet nMx;
    private AnimatorSet nMy;
    private ImageView nNk;
    private RelativeLayout nNl;
    private VideoRecordButton nNm;
    private ImageView nNn;
    private long nNo;
    private boolean nNp;
    private List<ObjectAnimator> nNq;
    private a nNr;
    private boolean nNs;
    private boolean nNt;
    private List<e> nNu;
    private List<e> nNv;
    private List<StickerItem> nNw;
    private List<e> nNx;
    private VideoEffectLayout nNy;

    /* loaded from: classes8.dex */
    public interface a {
        void dVS();

        void dWe();

        void dWf();

        void dWg();

        void dWh();

        void dWi();

        void dWj();

        void dWk();

        void dWl();

        void dWm();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nNo = 0L;
        this.nNp = false;
        this.nNs = true;
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.nNx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nNo = 0L;
        this.nNp = false;
        this.nNs = true;
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.nNx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nNo = 0L;
        this.nNp = false;
        this.nNs = true;
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.nNx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nNy = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nNl = (RelativeLayout) findViewById(R.id.layout_record);
        this.nNk = (ImageView) findViewById(R.id.delete_video);
        this.nNk.setOnClickListener(this);
        this.nNm = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nNm.setOnTouchListener(this);
        this.nNn = (ImageView) findViewById(R.id.confirm_video);
        this.nNn.setOnClickListener(this);
        this.nNx.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nNx.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nKF = iVar;
        Me(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nNy != null) {
            this.nNy.setListener(aVar);
        }
    }

    public void Me(int i) {
        this.nKF.setStatus(i);
        if (this.nNr != null) {
            this.nNr.dWm();
        }
        if (i == 1) {
            this.nNk.setVisibility(8);
            this.nNn.setVisibility(8);
        } else if (i == 3) {
            this.nNk.setImageResource(R.drawable.video_back_selector);
            this.nNn.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nNk.setImageResource(R.drawable.video_back_selector);
            this.nNn.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nNk.setImageResource(R.drawable.video_delete_selector);
            if (this.nKF != null && this.nKF.getVideoDuration() >= 3000.0f) {
                this.nNn.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nNn.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nNk) {
            if (this.nNr != null) {
                this.nNr.dWl();
            }
            int status = this.nKF.getStatus();
            if (this.nKF != null && this.nKF.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nKF.dVN();
                    gd(this.nNu);
                    gd(this.nNv);
                    gd(this.nNw);
                    if (this.nKF.getVideoDuration() >= 3000.0f) {
                        Me(4);
                        return;
                    } else {
                        Me(this.nKF.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nKF.dVM();
                Me(5);
            }
        } else if (view == this.nNn) {
            TiebaStatic.log("c12300");
            if (this.nKF != null && this.nKF.getStatus() > 2 && this.nNr != null) {
                if (this.nKF.getVideoDuration() >= 3000.0f) {
                    this.nNr.dWj();
                } else {
                    this.nNr.dWk();
                }
            }
        }
    }

    private void gd(List list) {
        if (!x.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(final boolean z) {
        if (this.nKF.getProgress() >= 100) {
            if (this.nNr != null) {
                this.nNr.dWj();
                return;
            }
            return;
        }
        if (this.nNy.getCurrentBeautyItem() != null) {
            this.nNu.add(this.nNy.getCurrentBeautyItem());
        }
        if (this.nNy.getCurrentFilterItem() != null) {
            this.nNv.add(this.nNy.getCurrentFilterItem());
        }
        if (this.nNy.getCurrentStickItem() != null) {
            this.nNw.add(this.nNy.getCurrentStickItem());
        }
        Me(2);
        if (this.nNy.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nKF.getStatus() == 6 || VideoControllerLayout.this.nKF.bzi()) {
                        VideoControllerLayout.this.yR(z);
                    }
                }
            });
        } else {
            yR(z);
        }
        if (this.nKF != null) {
            this.nKF.startRecord();
        }
        if (this.nNr != null) {
            this.nNr.dWe();
        }
    }

    public void stopRecord() {
        dWq();
        int status = this.nKF.getStatus();
        if (this.nKF != null) {
            if (!this.nKF.bXp() && this.nKF.bzi()) {
                this.nKF.stopRecord();
            }
            dWp();
        }
        if (this.nNr != null) {
            this.nNr.dVS();
            if (status == 6) {
                this.nNr.dWg();
            }
        }
    }

    public void dWp() {
        if (this.nKF != null) {
            if (this.nKF.getVideoDuration() >= 3000.0f) {
                Me(4);
            } else if (this.nKF.getVideoDuration() > 0) {
                Me(3);
            } else {
                Me(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(boolean z) {
        if (this.nMy != null && this.nMy.isRunning()) {
            this.nMy.cancel();
        }
        if (this.nMx == null) {
            this.nMx = new AnimatorSet();
            this.nMx.playTogether(ObjectAnimator.ofFloat(this.nNk, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nNn, "alpha", 1.0f, 0.0f));
            this.nMx.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOl) {
                        VideoControllerLayout.this.nNk.setVisibility(8);
                        VideoControllerLayout.this.nNn.setVisibility(8);
                    }
                }
            });
            this.nMx.setDuration(300L);
        }
        this.nMx.start();
        if (this.nKF.getStatus() != 6) {
            this.nNm.yR(z);
        }
    }

    public void dWq() {
        if (this.nKF == null || this.nKF.bzi() || this.nKF.getStatus() == 6) {
            if (this.nMx != null && this.nMx.isRunning()) {
                this.nMx.cancel();
            }
            if (this.nMy == null) {
                this.nMy = new AnimatorSet();
                this.nMy.playTogether(ObjectAnimator.ofFloat(this.nNk, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nNn, "alpha", 0.0f, 1.0f));
                this.nMy.setDuration(300L);
            }
            this.nNk.setVisibility(0);
            this.nNn.setVisibility(0);
            this.nMy.start();
            if (this.nKF.getStatus() != 7 && this.nKF.getStatus() != 6) {
                this.nNm.dWq();
                return;
            }
            this.nNm.getTvTip().setVisibility(8);
            if (this.jCC == 2) {
                this.nNm.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jCC) {
            case 1:
                l(view, motionEvent);
                return true;
            case 2:
                k(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void k(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nNr != null) {
                    this.nNr.dWl();
                }
                if (this.nKF.getStatus() != 7 && this.nKF.getStatus() != 6) {
                    if (this.nKF != null && this.nKF.dVL()) {
                        this.nNt = true;
                        com.baidu.tbadk.core.util.e.bvy().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nNo = currentTimeMillis;
                    this.nNp = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nNp && VideoControllerLayout.this.nNo == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.gg(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nNt) {
                    this.nNt = false;
                    return;
                }
                this.nNp = false;
                if (this.nKF.bzi() || this.nKF.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nKF.getStatus() != 8) {
                    gg(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void l(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nKF.getStatus() == 6) {
                    this.nKF.setStatus(1);
                    if (this.nNr != null) {
                        this.nNr.dWg();
                        this.nNr.dVS();
                    }
                    this.nNm.getTvTip().setText("");
                    this.nNm.getTvTip().setVisibility(8);
                    return;
                } else if (this.nNy.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nNr != null) {
                    this.nNr.dWf();
                    this.nNm.dWB();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nNm.dWC();
                return;
            default:
                return;
        }
    }

    public void dVZ() {
        if (this.nNy.getVisibility() == 0) {
            a((m) null);
        }
        yR(false);
        this.nNm.getLayer1().setVisibility(8);
        this.nNm.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nNm.getTvTip().setVisibility(0);
        if (this.nNr != null) {
            this.nNr.dWe();
        }
    }

    public void dWr() {
        if (this.nKF.getStatus() == 6) {
            if (this.jCC == 2) {
                Me(7);
                this.nNm.setAlpha(1.0f);
                this.nNk.setVisibility(8);
                this.nNn.setVisibility(8);
                this.nNm.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nKF != null) {
                    this.nKF.startRecord();
                    return;
                }
                return;
            }
            this.nNm.getTvTip().setVisibility(8);
            if (this.nNr != null) {
                this.nNr.dWf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWa() {
        if (dWu() && this.nNy.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dWu()) {
            dWt();
        }
        this.nNy.dWa();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        if (dWu() && this.nNy.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dWu()) {
            dWt();
        }
        this.nNy.dWb();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        if (dWu() && this.nNy.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dWu()) {
            dWt();
        }
        this.nNy.dWc();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        if (dWu() && this.nNy.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dWu()) {
            dWt();
        }
        this.nNy.dWd();
    }

    private void dWs() {
        if (x.isEmpty(this.nNq)) {
            this.nNq = new ArrayList();
            this.nNq.add(ObjectAnimator.ofFloat(this.nNy, "translationY", 1000.0f, 0.0f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNl, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNm.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNm.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNm.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNm.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNn, "scaleX", 1.0f, 0.7f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNn, "scaleY", 1.0f, 0.7f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNk, "scaleX", 1.0f, 0.7f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNk, "scaleY", 1.0f, 0.7f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNn, "alpha", 1.0f, 0.0f));
            this.nNq.add(ObjectAnimator.ofFloat(this.nNk, "alpha", 1.0f, 0.0f));
        }
    }

    private void dWt() {
        int i = 0;
        if (this.nNy.getVisibility() != 0) {
            this.nNy.setVisibility(0);
            dWs();
            this.nNn.setEnabled(false);
            this.nNk.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nNq.size()) {
                    ObjectAnimator objectAnimator = this.nNq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nNq.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nNr != null) {
                                        VideoControllerLayout.this.nNr.dWh();
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
        if (this.nNy.getVisibility() != 8) {
            dWs();
            this.nNn.setEnabled(true);
            this.nNk.setEnabled(true);
            if (this.nKF.getStatus() == 6 || this.nKF.bzi()) {
                this.nNk.setVisibility(8);
                this.nNn.setVisibility(8);
            } else {
                Me(this.nKF.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nNq.size()) {
                    ObjectAnimator objectAnimator = this.nNq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nNq.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nOl) {
                                        VideoControllerLayout.this.nNy.setVisibility(8);
                                        if (VideoControllerLayout.this.nNr != null) {
                                            VideoControllerLayout.this.nNr.dWi();
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
        this.nNr = aVar;
    }

    public void setCurrentTab(int i) {
        this.jCC = i;
        switch (this.jCC) {
            case 1:
                this.nNk.setVisibility(4);
                this.nNn.setVisibility(4);
                this.nNm.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nKF.getStatus() != 1) {
                    this.nNk.setVisibility(0);
                    this.nNn.setVisibility(0);
                }
                this.nNm.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dWu() {
        return this.nNy.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nNy != null) {
            this.nNy.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nNy != null) {
            this.nNy.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nNy != null) {
            this.nNy.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dWv() {
        if (this.nNy != null) {
            return this.nNy.dWv();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nNs = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nNu;
    }

    public List<e> getChoosedFilterList() {
        return this.nNv;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nNw;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nNx.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nNy != null) {
            this.nNy.setMusicList(this.nNx);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dWw() {
        if (this.nNy != null) {
            this.nNy.dWw();
        }
    }

    public void dVj() {
        if (this.nNy != null) {
            this.nNy.dVj();
        }
    }
}
