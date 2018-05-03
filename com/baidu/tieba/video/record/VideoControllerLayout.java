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
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dlW;
    private i gQe;
    private ImageView gSO;
    private RelativeLayout gSP;
    private VideoRecordButton gSQ;
    private ImageView gSR;
    private long gSS;
    private boolean gST;
    private List<ObjectAnimator> gSU;
    private a gSV;
    private boolean gSW;
    private boolean gSX;
    private List<e> gSY;
    private List<e> gSZ;
    private AnimatorSet gSc;
    private AnimatorSet gSd;
    private List<StickerItem> gTa;
    private List<e> gTb;
    private VideoEffectLayout gTc;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void byE();

        void byP();

        void byQ();

        void byR();

        void byS();

        void byT();

        void byU();

        void byV();

        void byW();

        void byX();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gSS = 0L;
        this.gST = false;
        this.gSW = true;
        this.gSY = new ArrayList();
        this.gSZ = new ArrayList();
        this.gTa = new ArrayList();
        this.gTb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSS = 0L;
        this.gST = false;
        this.gSW = true;
        this.gSY = new ArrayList();
        this.gSZ = new ArrayList();
        this.gTa = new ArrayList();
        this.gTb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSS = 0L;
        this.gST = false;
        this.gSW = true;
        this.gSY = new ArrayList();
        this.gSZ = new ArrayList();
        this.gTa = new ArrayList();
        this.gTb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.record_controller_layout, this);
        this.gTc = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gSP = (RelativeLayout) findViewById(d.g.layout_record);
        this.gSO = (ImageView) findViewById(d.g.delete_video);
        this.gSO.setOnClickListener(this);
        this.gSQ = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gSQ.setOnTouchListener(this);
        this.gSR = (ImageView) findViewById(d.g.confirm_video);
        this.gSR.setOnClickListener(this);
        this.gTb.add(0, new e(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute));
        this.gTb.add(1, new e(3, getResources().getString(d.k.music_cloud), new MusicData("-200", 2, getResources().getString(d.k.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.gQe = iVar;
        uB(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gTc != null) {
            this.gTc.setListener(aVar);
        }
    }

    public void uB(int i) {
        this.gQe.setStatus(i);
        if (this.gSV != null) {
            this.gSV.byX();
        }
        if (i == 1) {
            this.gSO.setVisibility(8);
            this.gSR.setVisibility(8);
        } else if (i == 3) {
            this.gSO.setImageResource(d.f.video_back_selector);
            this.gSR.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gSO.setImageResource(d.f.video_back_selector);
            this.gSR.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gSO.setImageResource(d.f.video_delete_selector);
            if (this.gQe != null && this.gQe.getVideoDuration() >= 3000.0f) {
                this.gSR.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gSR.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.gSO) {
            if (this.gSV != null) {
                this.gSV.byW();
            }
            int status = this.gQe.getStatus();
            if (this.gQe != null && this.gQe.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gQe.byx();
                    dE(this.gSY);
                    dE(this.gSZ);
                    dE(this.gTa);
                    if (this.gQe.getVideoDuration() >= 3000.0f) {
                        uB(4);
                        return;
                    } else {
                        uB(this.gQe.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gQe.byw();
                uB(5);
            }
        } else if (view2 == this.gSR) {
            TiebaStatic.log("c12300");
            if (this.gQe != null && this.gQe.getStatus() > 2 && this.gSV != null) {
                if (this.gQe.getVideoDuration() >= 3000.0f) {
                    this.gSV.byU();
                } else {
                    this.gSV.byV();
                }
            }
        }
    }

    private void dE(List list) {
        if (!v.w(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.gQe.getProgress() >= 100) {
            if (this.gSV != null) {
                this.gSV.byU();
                return;
            }
            return;
        }
        if (this.gTc.getCurrentBeautyItem() != null) {
            this.gSY.add(this.gTc.getCurrentBeautyItem());
        }
        if (this.gTc.getCurrentFilterItem() != null) {
            this.gSZ.add(this.gTc.getCurrentFilterItem());
        }
        if (this.gTc.getCurrentStickItem() != null) {
            this.gTa.add(this.gTc.getCurrentStickItem());
        }
        uB(2);
        if (this.gTc.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gQe.getStatus() == 6 || VideoControllerLayout.this.gQe.isRecording()) {
                        VideoControllerLayout.this.nb(z);
                    }
                }
            });
        } else {
            nb(z);
        }
        if (this.gQe != null) {
            this.gQe.startRecord();
        }
        if (this.gSV != null) {
            this.gSV.byP();
        }
    }

    public void stopRecord() {
        bzb();
        int status = this.gQe.getStatus();
        if (this.gQe != null) {
            if (!this.gQe.byy() && this.gQe.isRecording()) {
                this.gQe.stopRecord();
            }
            bza();
        }
        if (this.gSV != null) {
            this.gSV.byE();
            if (status == 6) {
                this.gSV.byR();
            }
        }
    }

    public void bza() {
        if (this.gQe != null) {
            if (this.gQe.getVideoDuration() >= 3000.0f) {
                uB(4);
            } else if (this.gQe.getVideoDuration() > 0) {
                uB(3);
            } else {
                uB(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(boolean z) {
        if (this.gSd != null && this.gSd.isRunning()) {
            this.gSd.cancel();
        }
        if (this.gSc == null) {
            this.gSc = new AnimatorSet();
            this.gSc.playTogether(ObjectAnimator.ofFloat(this.gSO, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gSR, "alpha", 1.0f, 0.0f));
            this.gSc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTR) {
                        VideoControllerLayout.this.gSO.setVisibility(8);
                        VideoControllerLayout.this.gSR.setVisibility(8);
                    }
                }
            });
            this.gSc.setDuration(300L);
        }
        this.gSc.start();
        if (this.gQe.getStatus() != 6) {
            this.gSQ.nb(z);
        }
    }

    public void bzb() {
        if (this.gQe == null || this.gQe.isRecording() || this.gQe.getStatus() == 6) {
            if (this.gSc != null && this.gSc.isRunning()) {
                this.gSc.cancel();
            }
            if (this.gSd == null) {
                this.gSd = new AnimatorSet();
                this.gSd.playTogether(ObjectAnimator.ofFloat(this.gSO, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gSR, "alpha", 0.0f, 1.0f));
                this.gSd.setDuration(300L);
            }
            this.gSO.setVisibility(0);
            this.gSR.setVisibility(0);
            this.gSd.start();
            if (this.gQe.getStatus() != 7 && this.gQe.getStatus() != 6) {
                this.gSQ.bzb();
                return;
            }
            this.gSQ.getTvTip().setVisibility(8);
            if (this.dlW == 2) {
                this.gSQ.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        switch (this.dlW) {
            case 1:
                g(view2, motionEvent);
                return true;
            case 2:
                f(view2, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void f(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gSV != null) {
                    this.gSV.byW();
                }
                if (this.gQe.getStatus() != 7 && this.gQe.getStatus() != 6) {
                    if (this.gQe != null && this.gQe.byv()) {
                        this.gSX = true;
                        com.baidu.tbadk.core.util.e.uB().showToast(d.k.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gSS = currentTimeMillis;
                    this.gST = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gST && VideoControllerLayout.this.gSS == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.na(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.gSX) {
                    this.gSX = false;
                    return;
                }
                this.gST = false;
                if (this.gQe.isRecording() || this.gQe.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.gQe.getStatus() != 8) {
                    na(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void g(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gQe.getStatus() == 6) {
                    this.gQe.setStatus(1);
                    if (this.gSV != null) {
                        this.gSV.byR();
                        this.gSV.byE();
                    }
                    this.gSQ.getTvTip().setText("");
                    this.gSQ.getTvTip().setVisibility(8);
                    return;
                } else if (this.gTc.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.gSV != null) {
                    this.gSV.byQ();
                    this.gSQ.bzm();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gSQ.bzn();
                return;
            default:
                return;
        }
    }

    public void byK() {
        if (this.gTc.getVisibility() == 0) {
            a((m) null);
        }
        nb(false);
        this.gSQ.getLayer1().setVisibility(8);
        this.gSQ.getTvTip().setText(getResources().getText(d.k.video_record_button_cancel));
        this.gSQ.getTvTip().setVisibility(0);
        if (this.gSV != null) {
            this.gSV.byP();
        }
    }

    public void bzc() {
        if (this.gQe.getStatus() == 6) {
            if (this.dlW == 2) {
                uB(7);
                this.gSQ.setAlpha(1.0f);
                this.gSO.setVisibility(8);
                this.gSR.setVisibility(8);
                this.gSQ.getTvTip().setText(getResources().getString(d.k.video_record_button_pasue));
                if (this.gQe != null) {
                    this.gQe.startRecord();
                    return;
                }
                return;
            }
            this.gSQ.getTvTip().setVisibility(8);
            if (this.gSV != null) {
                this.gSV.byQ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        if (bzf() && this.gTc.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTc.byL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        if (bzf() && this.gTc.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTc.byM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        if (bzf() && this.gTc.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTc.byN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        if (bzf() && this.gTc.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTc.byO();
    }

    private void bzd() {
        if (v.w(this.gSU)) {
            this.gSU = new ArrayList();
            this.gSU.add(ObjectAnimator.ofFloat(this.gTc, "translationY", 1000.0f, 0.0f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSP, "translationY", 0.0f, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds100)));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSQ.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSQ.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSQ.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSQ.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSR, "scaleX", 1.0f, 0.7f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSR, "scaleY", 1.0f, 0.7f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSO, "scaleX", 1.0f, 0.7f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSO, "scaleY", 1.0f, 0.7f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSR, "alpha", 1.0f, 0.0f));
            this.gSU.add(ObjectAnimator.ofFloat(this.gSO, "alpha", 1.0f, 0.0f));
        }
    }

    private void bze() {
        int i = 0;
        if (this.gTc.getVisibility() != 0) {
            this.gTc.setVisibility(0);
            bzd();
            this.gSR.setEnabled(false);
            this.gSO.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gSU.size()) {
                    ObjectAnimator objectAnimator = this.gSU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gSU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gSV != null) {
                                        VideoControllerLayout.this.gSV.byS();
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
        if (this.gTc.getVisibility() != 8) {
            bzd();
            this.gSR.setEnabled(true);
            this.gSO.setEnabled(true);
            if (this.gQe.getStatus() == 6 || this.gQe.isRecording()) {
                this.gSO.setVisibility(8);
                this.gSR.setVisibility(8);
            } else {
                uB(this.gQe.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gSU.size()) {
                    ObjectAnimator objectAnimator = this.gSU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gSU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.gTR) {
                                        VideoControllerLayout.this.gTc.setVisibility(8);
                                        if (VideoControllerLayout.this.gSV != null) {
                                            VideoControllerLayout.this.gSV.byT();
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
        this.gSV = aVar;
    }

    public void setCurrentTab(int i) {
        this.dlW = i;
        switch (this.dlW) {
            case 1:
                this.gSO.setVisibility(4);
                this.gSR.setVisibility(4);
                this.gSQ.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gQe.getStatus() != 1) {
                    this.gSO.setVisibility(0);
                    this.gSR.setVisibility(0);
                }
                this.gSQ.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bzf() {
        return this.gTc.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gTc != null) {
            this.gTc.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gTc != null) {
            this.gTc.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gTc != null) {
            this.gTc.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bzg() {
        if (this.gTc != null) {
            return this.gTc.bzg();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gSW = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gSY;
    }

    public List<e> getChoosedFilterList() {
        return this.gSZ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gTa;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gTb.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gTc != null) {
            this.gTc.setMusicList(this.gTb);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
    }

    public void bzh() {
        if (this.gTc != null) {
            this.gTc.bzh();
        }
    }

    public void bxU() {
        if (this.gTc != null) {
            this.gTc.bxU();
        }
    }
}
