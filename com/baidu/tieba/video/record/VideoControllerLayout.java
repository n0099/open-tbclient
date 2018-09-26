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
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dJg;
    private i hpU;
    private AnimatorSet hrS;
    private AnimatorSet hrT;
    private ImageView hsE;
    private RelativeLayout hsF;
    private VideoRecordButton hsG;
    private ImageView hsH;
    private long hsI;
    private boolean hsJ;
    private List<ObjectAnimator> hsK;
    private a hsL;
    private boolean hsM;
    private boolean hsN;
    private List<e> hsO;
    private List<e> hsP;
    private List<StickerItem> hsQ;
    private List<e> hsR;
    private VideoEffectLayout hsS;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bFJ();

        void bFU();

        void bFV();

        void bFW();

        void bFX();

        void bFY();

        void bFZ();

        void bGa();

        void bGb();

        void bGc();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hsI = 0L;
        this.hsJ = false;
        this.hsM = true;
        this.hsO = new ArrayList();
        this.hsP = new ArrayList();
        this.hsQ = new ArrayList();
        this.hsR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsI = 0L;
        this.hsJ = false;
        this.hsM = true;
        this.hsO = new ArrayList();
        this.hsP = new ArrayList();
        this.hsQ = new ArrayList();
        this.hsR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hsI = 0L;
        this.hsJ = false;
        this.hsM = true;
        this.hsO = new ArrayList();
        this.hsP = new ArrayList();
        this.hsQ = new ArrayList();
        this.hsR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hsS = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hsF = (RelativeLayout) findViewById(e.g.layout_record);
        this.hsE = (ImageView) findViewById(e.g.delete_video);
        this.hsE.setOnClickListener(this);
        this.hsG = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hsG.setOnTouchListener(this);
        this.hsH = (ImageView) findViewById(e.g.confirm_video);
        this.hsH.setOnClickListener(this);
        this.hsR.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hsR.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hpU = iVar;
        vu(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hsS != null) {
            this.hsS.setListener(aVar);
        }
    }

    public void vu(int i) {
        this.hpU.setStatus(i);
        if (this.hsL != null) {
            this.hsL.bGc();
        }
        if (i == 1) {
            this.hsE.setVisibility(8);
            this.hsH.setVisibility(8);
        } else if (i == 3) {
            this.hsE.setImageResource(e.f.video_back_selector);
            this.hsH.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hsE.setImageResource(e.f.video_back_selector);
            this.hsH.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hsE.setImageResource(e.f.video_delete_selector);
            if (this.hpU != null && this.hpU.getVideoDuration() >= 3000.0f) {
                this.hsH.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hsH.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hsE) {
            if (this.hsL != null) {
                this.hsL.bGb();
            }
            int status = this.hpU.getStatus();
            if (this.hpU != null && this.hpU.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hpU.bFC();
                    dM(this.hsO);
                    dM(this.hsP);
                    dM(this.hsQ);
                    if (this.hpU.getVideoDuration() >= 3000.0f) {
                        vu(4);
                        return;
                    } else {
                        vu(this.hpU.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hpU.bFB();
                vu(5);
            }
        } else if (view == this.hsH) {
            TiebaStatic.log("c12300");
            if (this.hpU != null && this.hpU.getStatus() > 2 && this.hsL != null) {
                if (this.hpU.getVideoDuration() >= 3000.0f) {
                    this.hsL.bFZ();
                } else {
                    this.hsL.bGa();
                }
            }
        }
    }

    private void dM(List list) {
        if (!v.z(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(final boolean z) {
        if (this.hpU.getProgress() >= 100) {
            if (this.hsL != null) {
                this.hsL.bFZ();
                return;
            }
            return;
        }
        if (this.hsS.getCurrentBeautyItem() != null) {
            this.hsO.add(this.hsS.getCurrentBeautyItem());
        }
        if (this.hsS.getCurrentFilterItem() != null) {
            this.hsP.add(this.hsS.getCurrentFilterItem());
        }
        if (this.hsS.getCurrentStickItem() != null) {
            this.hsQ.add(this.hsS.getCurrentStickItem());
        }
        vu(2);
        if (this.hsS.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hpU.getStatus() == 6 || VideoControllerLayout.this.hpU.isRecording()) {
                        VideoControllerLayout.this.nA(z);
                    }
                }
            });
        } else {
            nA(z);
        }
        if (this.hpU != null) {
            this.hpU.startRecord();
        }
        if (this.hsL != null) {
            this.hsL.bFU();
        }
    }

    public void stopRecord() {
        bGg();
        int status = this.hpU.getStatus();
        if (this.hpU != null) {
            if (!this.hpU.bFD() && this.hpU.isRecording()) {
                this.hpU.stopRecord();
            }
            bGf();
        }
        if (this.hsL != null) {
            this.hsL.bFJ();
            if (status == 6) {
                this.hsL.bFW();
            }
        }
    }

    public void bGf() {
        if (this.hpU != null) {
            if (this.hpU.getVideoDuration() >= 3000.0f) {
                vu(4);
            } else if (this.hpU.getVideoDuration() > 0) {
                vu(3);
            } else {
                vu(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nA(boolean z) {
        if (this.hrT != null && this.hrT.isRunning()) {
            this.hrT.cancel();
        }
        if (this.hrS == null) {
            this.hrS = new AnimatorSet();
            this.hrS.playTogether(ObjectAnimator.ofFloat(this.hsE, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hsH, "alpha", 1.0f, 0.0f));
            this.hrS.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.htH) {
                        VideoControllerLayout.this.hsE.setVisibility(8);
                        VideoControllerLayout.this.hsH.setVisibility(8);
                    }
                }
            });
            this.hrS.setDuration(300L);
        }
        this.hrS.start();
        if (this.hpU.getStatus() != 6) {
            this.hsG.nA(z);
        }
    }

    public void bGg() {
        if (this.hpU == null || this.hpU.isRecording() || this.hpU.getStatus() == 6) {
            if (this.hrS != null && this.hrS.isRunning()) {
                this.hrS.cancel();
            }
            if (this.hrT == null) {
                this.hrT = new AnimatorSet();
                this.hrT.playTogether(ObjectAnimator.ofFloat(this.hsE, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hsH, "alpha", 0.0f, 1.0f));
                this.hrT.setDuration(300L);
            }
            this.hsE.setVisibility(0);
            this.hsH.setVisibility(0);
            this.hrT.start();
            if (this.hpU.getStatus() != 7 && this.hpU.getStatus() != 6) {
                this.hsG.bGg();
                return;
            }
            this.hsG.getTvTip().setVisibility(8);
            if (this.dJg == 2) {
                this.hsG.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dJg) {
            case 1:
                g(view, motionEvent);
                return true;
            case 2:
                f(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void f(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hsL != null) {
                    this.hsL.bGb();
                }
                if (this.hpU.getStatus() != 7 && this.hpU.getStatus() != 6) {
                    if (this.hpU != null && this.hpU.bFA()) {
                        this.hsN = true;
                        com.baidu.tbadk.core.util.e.zk().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hsI = currentTimeMillis;
                    this.hsJ = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hsJ && VideoControllerLayout.this.hsI == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nz(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hsN) {
                    this.hsN = false;
                    return;
                }
                this.hsJ = false;
                if (this.hpU.isRecording() || this.hpU.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hpU.getStatus() != 8) {
                    nz(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void g(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hpU.getStatus() == 6) {
                    this.hpU.setStatus(1);
                    if (this.hsL != null) {
                        this.hsL.bFW();
                        this.hsL.bFJ();
                    }
                    this.hsG.getTvTip().setText("");
                    this.hsG.getTvTip().setVisibility(8);
                    return;
                } else if (this.hsS.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hsL != null) {
                    this.hsL.bFV();
                    this.hsG.bGr();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hsG.bGs();
                return;
            default:
                return;
        }
    }

    public void bFP() {
        if (this.hsS.getVisibility() == 0) {
            a((m) null);
        }
        nA(false);
        this.hsG.getLayer1().setVisibility(8);
        this.hsG.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hsG.getTvTip().setVisibility(0);
        if (this.hsL != null) {
            this.hsL.bFU();
        }
    }

    public void bGh() {
        if (this.hpU.getStatus() == 6) {
            if (this.dJg == 2) {
                vu(7);
                this.hsG.setAlpha(1.0f);
                this.hsE.setVisibility(8);
                this.hsH.setVisibility(8);
                this.hsG.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hpU != null) {
                    this.hpU.startRecord();
                    return;
                }
                return;
            }
            this.hsG.getTvTip().setVisibility(8);
            if (this.hsL != null) {
                this.hsL.bFV();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFQ() {
        if (bGk() && this.hsS.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bGk()) {
            bGj();
        }
        this.hsS.bFQ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFR() {
        if (bGk() && this.hsS.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bGk()) {
            bGj();
        }
        this.hsS.bFR();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFS() {
        if (bGk() && this.hsS.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bGk()) {
            bGj();
        }
        this.hsS.bFS();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFT() {
        if (bGk() && this.hsS.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bGk()) {
            bGj();
        }
        this.hsS.bFT();
    }

    private void bGi() {
        if (v.z(this.hsK)) {
            this.hsK = new ArrayList();
            this.hsK.add(ObjectAnimator.ofFloat(this.hsS, "translationY", 1000.0f, 0.0f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsF, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds100)));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsG.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsG.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsG.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsG.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsH, "scaleX", 1.0f, 0.7f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsH, "scaleY", 1.0f, 0.7f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsE, "scaleX", 1.0f, 0.7f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsE, "scaleY", 1.0f, 0.7f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsH, "alpha", 1.0f, 0.0f));
            this.hsK.add(ObjectAnimator.ofFloat(this.hsE, "alpha", 1.0f, 0.0f));
        }
    }

    private void bGj() {
        int i = 0;
        if (this.hsS.getVisibility() != 0) {
            this.hsS.setVisibility(0);
            bGi();
            this.hsH.setEnabled(false);
            this.hsE.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hsK.size()) {
                    ObjectAnimator objectAnimator = this.hsK.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hsK.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hsL != null) {
                                        VideoControllerLayout.this.hsL.bFX();
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
        if (this.hsS.getVisibility() != 8) {
            bGi();
            this.hsH.setEnabled(true);
            this.hsE.setEnabled(true);
            if (this.hpU.getStatus() == 6 || this.hpU.isRecording()) {
                this.hsE.setVisibility(8);
                this.hsH.setVisibility(8);
            } else {
                vu(this.hpU.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hsK.size()) {
                    ObjectAnimator objectAnimator = this.hsK.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hsK.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.htH) {
                                        VideoControllerLayout.this.hsS.setVisibility(8);
                                        if (VideoControllerLayout.this.hsL != null) {
                                            VideoControllerLayout.this.hsL.bFY();
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
        this.hsL = aVar;
    }

    public void setCurrentTab(int i) {
        this.dJg = i;
        switch (this.dJg) {
            case 1:
                this.hsE.setVisibility(4);
                this.hsH.setVisibility(4);
                this.hsG.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hpU.getStatus() != 1) {
                    this.hsE.setVisibility(0);
                    this.hsH.setVisibility(0);
                }
                this.hsG.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bGk() {
        return this.hsS.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hsS != null) {
            this.hsS.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hsS != null) {
            this.hsS.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hsS != null) {
            this.hsS.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bGl() {
        if (this.hsS != null) {
            return this.hsS.bGl();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hsM = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hsO;
    }

    public List<e> getChoosedFilterList() {
        return this.hsP;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hsQ;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hsR.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hsS != null) {
            this.hsS.setMusicList(this.hsR);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bGm() {
        if (this.hsS != null) {
            this.hsS.bGm();
        }
    }

    public void bFa() {
        if (this.hsS != null) {
            this.hsS.bFa();
        }
    }
}
