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
    private j gTI;
    private AnimatorSet gVH;
    private AnimatorSet gVI;
    private a gWA;
    private boolean gWB;
    private List<e> gWC;
    private List<e> gWD;
    private List<StickerItem> gWE;
    private List<e> gWF;
    private VideoEffectLayout gWG;
    private ImageView gWt;
    private RelativeLayout gWu;
    private VideoRecordButton gWv;
    private ImageView gWw;
    private long gWx;
    private boolean gWy;
    private List<ObjectAnimator> gWz;
    private int glX;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDB();

        void bDC();

        void bDD();

        void bDE();

        void bDF();

        void bDG();

        void bDH();

        void bDI();

        void bDq();

        void bDr();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gWx = 0L;
        this.gWy = false;
        this.gWB = true;
        this.gWC = new ArrayList();
        this.gWD = new ArrayList();
        this.gWE = new ArrayList();
        this.gWF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWx = 0L;
        this.gWy = false;
        this.gWB = true;
        this.gWC = new ArrayList();
        this.gWD = new ArrayList();
        this.gWE = new ArrayList();
        this.gWF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWx = 0L;
        this.gWy = false;
        this.gWB = true;
        this.gWC = new ArrayList();
        this.gWD = new ArrayList();
        this.gWE = new ArrayList();
        this.gWF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.gWG = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gWu = (RelativeLayout) findViewById(d.g.layout_record);
        this.gWt = (ImageView) findViewById(d.g.delete_video);
        this.gWt.setOnClickListener(this);
        this.gWv = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gWv.setOnTouchListener(this);
        this.gWw = (ImageView) findViewById(d.g.confirm_video);
        this.gWw.setOnClickListener(this);
        this.gWF.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.gWF.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.gTI = jVar;
        vv(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gWG != null) {
            this.gWG.setListener(aVar);
        }
    }

    public void vv(int i) {
        this.gTI.setStatus(i);
        if (this.gWA != null) {
            this.gWA.bDI();
        }
        if (i == 1) {
            this.gWt.setVisibility(8);
            this.gWw.setVisibility(8);
        } else if (i == 3) {
            this.gWt.setImageResource(d.f.video_back_selector);
            this.gWw.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gWt.setImageResource(d.f.video_back_selector);
            this.gWw.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gWt.setImageResource(d.f.video_delete_selector);
            if (this.gTI != null && this.gTI.getVideoDuration() >= 3000.0f) {
                this.gWw.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gWw.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gWt) {
            if (this.gWA != null) {
                this.gWA.bDH();
            }
            int status = this.gTI.getStatus();
            if (this.gTI != null && this.gTI.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gTI.bDm();
                    dT(this.gWC);
                    dT(this.gWD);
                    dT(this.gWE);
                    if (this.gTI.getVideoDuration() >= 3000.0f) {
                        vv(4);
                        return;
                    } else {
                        vv(this.gTI.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gTI.bDl();
                vv(5);
            }
        } else if (view == this.gWw) {
            TiebaStatic.log("c12300");
            if (this.gTI != null && this.gTI.getStatus() > 2 && this.gWA != null) {
                if (this.gTI.getVideoDuration() >= 3000.0f) {
                    this.gWA.bDr();
                } else {
                    this.gWA.bDG();
                }
            }
        }
    }

    private void dT(List list) {
        if (!v.w(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL(final boolean z) {
        if (this.gTI.getProgress() >= 100) {
            if (this.gWA != null) {
                this.gWA.bDr();
                return;
            }
            return;
        }
        if (this.gWG.getCurrentBeautyItem() != null) {
            this.gWC.add(this.gWG.getCurrentBeautyItem());
        }
        if (this.gWG.getCurrentFilterItem() != null) {
            this.gWD.add(this.gWG.getCurrentFilterItem());
        }
        if (this.gWG.getCurrentStickItem() != null) {
            this.gWE.add(this.gWG.getCurrentStickItem());
        }
        vv(2);
        if (this.gWG.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gTI.getStatus() == 6 || VideoControllerLayout.this.gTI.isRecording()) {
                        VideoControllerLayout.this.nM(z);
                    }
                }
            });
        } else {
            nM(z);
        }
        if (this.gTI != null) {
            this.gTI.startRecord();
        }
        if (this.gWA != null) {
            this.gWA.bDB();
        }
    }

    public void stopRecord() {
        bDL();
        int status = this.gTI.getStatus();
        if (this.gTI != null) {
            if (this.gTI.getStatus() != 6 && this.gTI.isRecording()) {
                this.gTI.stopRecord();
            }
            if (this.gTI.getVideoDuration() >= 3000.0f) {
                vv(4);
            } else if (this.gTI.getVideoDuration() > 0) {
                vv(3);
            } else {
                vv(1);
            }
        }
        if (this.gWA != null) {
            this.gWA.bDq();
            if (status == 6) {
                this.gWA.bDD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(boolean z) {
        if (this.gVI != null && this.gVI.isRunning()) {
            this.gVI.cancel();
        }
        if (this.gVH == null) {
            this.gVH = new AnimatorSet();
            this.gVH.playTogether(ObjectAnimator.ofFloat(this.gWt, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gWw, "alpha", 1.0f, 0.0f));
            this.gVH.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gXu) {
                        VideoControllerLayout.this.gWt.setVisibility(8);
                        VideoControllerLayout.this.gWw.setVisibility(8);
                    }
                }
            });
            this.gVH.setDuration(300L);
        }
        this.gVH.start();
        if (this.gTI.getStatus() != 6) {
            this.gWv.nM(z);
        }
    }

    public void bDL() {
        if (this.gTI == null || this.gTI.isRecording() || this.gTI.getStatus() == 6) {
            if (this.gVH != null && this.gVH.isRunning()) {
                this.gVH.cancel();
            }
            if (this.gVI == null) {
                this.gVI = new AnimatorSet();
                this.gVI.playTogether(ObjectAnimator.ofFloat(this.gWt, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gWw, "alpha", 0.0f, 1.0f));
                this.gVI.setDuration(300L);
            }
            this.gWt.setVisibility(0);
            this.gWw.setVisibility(0);
            this.gVI.start();
            if (this.gTI.getStatus() != 7 && this.gTI.getStatus() != 6) {
                this.gWv.bDL();
                return;
            }
            this.gWv.getTvTip().setVisibility(8);
            if (this.glX == 2) {
                this.gWv.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.glX) {
            case 1:
                h(view, motionEvent);
                return true;
            case 2:
                g(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void g(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gWA != null) {
                    this.gWA.bDH();
                }
                if (this.gTI.getStatus() != 7 && this.gTI.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gWx = currentTimeMillis;
                    this.gWy = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gWy && VideoControllerLayout.this.gWx == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nL(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                this.gWy = false;
                if (this.gTI.isRecording() || this.gTI.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.gWG.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.gTI.getStatus() != 8) {
                    nL(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gTI.getStatus() == 6) {
                    this.gTI.setStatus(1);
                    if (this.gWA != null) {
                        this.gWA.bDD();
                        this.gWA.bDq();
                    }
                    this.gWv.getTvTip().setText("");
                    this.gWv.getTvTip().setVisibility(8);
                    return;
                } else if (this.gWG.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.gWA != null) {
                    this.gWA.bDC();
                    this.gWv.bDV();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gWv.bDW();
                return;
            default:
                return;
        }
    }

    public void bDw() {
        if (this.gWG.getVisibility() == 0) {
            a((o) null);
        }
        nM(false);
        this.gWv.getLayer1().setVisibility(8);
        this.gWv.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.gWv.getTvTip().setVisibility(0);
        if (this.gWA != null) {
            this.gWA.bDB();
        }
    }

    public void bDM() {
        if (this.gTI.getStatus() == 6) {
            if (this.glX == 2) {
                vv(7);
                this.gWv.setAlpha(1.0f);
                this.gWt.setVisibility(8);
                this.gWw.setVisibility(8);
                this.gWv.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.gTI != null) {
                    this.gTI.startRecord();
                    return;
                }
                return;
            }
            this.gWv.getTvTip().setVisibility(8);
            if (this.gWA != null) {
                this.gWA.bDC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDx() {
        if (bDP() && this.gWG.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bDP()) {
            bDO();
        }
        this.gWG.bDx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDy() {
        if (bDP() && this.gWG.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bDP()) {
            bDO();
        }
        this.gWG.bDy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDz() {
        if (bDP() && this.gWG.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bDP()) {
            bDO();
        }
        this.gWG.bDz();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDA() {
        if (bDP() && this.gWG.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bDP()) {
            bDO();
        }
        this.gWG.bDA();
    }

    private void bDN() {
        if (v.w(this.gWz)) {
            this.gWz = new ArrayList();
            this.gWz.add(ObjectAnimator.ofFloat(this.gWG, "translationY", 1000.0f, 0.0f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWu, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWv.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWv.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWv.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWv.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWw, "scaleX", 1.0f, 0.7f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWw, "scaleY", 1.0f, 0.7f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWt, "scaleX", 1.0f, 0.7f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWt, "scaleY", 1.0f, 0.7f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWw, "alpha", 1.0f, 0.0f));
            this.gWz.add(ObjectAnimator.ofFloat(this.gWt, "alpha", 1.0f, 0.0f));
        }
    }

    private void bDO() {
        int i = 0;
        if (this.gWG.getVisibility() != 0) {
            this.gWG.setVisibility(0);
            bDN();
            this.gWw.setEnabled(false);
            this.gWt.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gWz.size()) {
                    ObjectAnimator objectAnimator = this.gWz.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gWz.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gWA != null) {
                                        VideoControllerLayout.this.gWA.bDE();
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

    public void a(final o oVar) {
        if (this.gWG.getVisibility() != 8) {
            bDN();
            this.gWw.setEnabled(true);
            this.gWt.setEnabled(true);
            if (this.gTI.getStatus() == 6 || this.gTI.isRecording()) {
                this.gWt.setVisibility(8);
                this.gWw.setVisibility(8);
            } else {
                vv(this.gTI.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gWz.size()) {
                    ObjectAnimator objectAnimator = this.gWz.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gWz.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.gXu) {
                                        VideoControllerLayout.this.gWG.setVisibility(8);
                                        if (VideoControllerLayout.this.gWA != null) {
                                            VideoControllerLayout.this.gWA.bDF();
                                        }
                                        if (oVar != null) {
                                            oVar.onAnimationEnd(animator);
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
        this.gWA = aVar;
    }

    public void setCurrentTab(int i) {
        this.glX = i;
        switch (this.glX) {
            case 1:
                this.gWt.setVisibility(4);
                this.gWw.setVisibility(4);
                this.gWv.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gTI.getStatus() != 1) {
                    this.gWt.setVisibility(0);
                    this.gWw.setVisibility(0);
                }
                this.gWv.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bDP() {
        return this.gWG.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gWG != null) {
            this.gWG.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gWG != null) {
            this.gWG.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gWG != null) {
            this.gWG.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bDQ() {
        if (this.gWG != null) {
            return this.gWG.bDQ();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gWB = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gWC;
    }

    public List<e> getChoosedFilterList() {
        return this.gWD;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gWE;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gWF.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gWG != null) {
            this.gWG.setMusicList(this.gWF);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDR() {
        if (this.gWG != null) {
            this.gWG.bDR();
        }
    }

    public void bCK() {
        if (this.gWG != null) {
            this.gWG.bCK();
        }
    }
}
