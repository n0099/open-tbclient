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
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int fpO;
    private i jaT;
    private AnimatorSet jcR;
    private AnimatorSet jcS;
    private ImageView jdD;
    private RelativeLayout jdE;
    private VideoRecordButton jdF;
    private ImageView jdG;
    private long jdH;
    private boolean jdI;
    private List<ObjectAnimator> jdJ;
    private a jdK;
    private boolean jdL;
    private boolean jdM;
    private List<e> jdN;
    private List<e> jdO;
    private List<StickerItem> jdP;
    private List<e> jdQ;
    private VideoEffectLayout jdR;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void clK();

        void clL();

        void clM();

        void clN();

        void clO();

        void clP();

        void clQ();

        void clR();

        void clS();

        void clz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jdH = 0L;
        this.jdI = false;
        this.jdL = true;
        this.jdN = new ArrayList();
        this.jdO = new ArrayList();
        this.jdP = new ArrayList();
        this.jdQ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdH = 0L;
        this.jdI = false;
        this.jdL = true;
        this.jdN = new ArrayList();
        this.jdO = new ArrayList();
        this.jdP = new ArrayList();
        this.jdQ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdH = 0L;
        this.jdI = false;
        this.jdL = true;
        this.jdN = new ArrayList();
        this.jdO = new ArrayList();
        this.jdP = new ArrayList();
        this.jdQ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.jdR = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.jdE = (RelativeLayout) findViewById(d.g.layout_record);
        this.jdD = (ImageView) findViewById(d.g.delete_video);
        this.jdD.setOnClickListener(this);
        this.jdF = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.jdF.setOnTouchListener(this);
        this.jdG = (ImageView) findViewById(d.g.confirm_video);
        this.jdG.setOnClickListener(this);
        this.jdQ.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.jdQ.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jaT = iVar;
        AJ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jdR != null) {
            this.jdR.setListener(aVar);
        }
    }

    public void AJ(int i) {
        this.jaT.setStatus(i);
        if (this.jdK != null) {
            this.jdK.clS();
        }
        if (i == 1) {
            this.jdD.setVisibility(8);
            this.jdG.setVisibility(8);
        } else if (i == 3) {
            this.jdD.setImageResource(d.f.video_back_selector);
            this.jdG.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.jdD.setImageResource(d.f.video_back_selector);
            this.jdG.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.jdD.setImageResource(d.f.video_delete_selector);
            if (this.jaT != null && this.jaT.getVideoDuration() >= 3000.0f) {
                this.jdG.setImageResource(d.f.video_confirm_selector);
            } else {
                this.jdG.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdD) {
            if (this.jdK != null) {
                this.jdK.clR();
            }
            int status = this.jaT.getStatus();
            if (this.jaT != null && this.jaT.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jaT.cls();
                    ek(this.jdN);
                    ek(this.jdO);
                    ek(this.jdP);
                    if (this.jaT.getVideoDuration() >= 3000.0f) {
                        AJ(4);
                        return;
                    } else {
                        AJ(this.jaT.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jaT.clr();
                AJ(5);
            }
        } else if (view == this.jdG) {
            TiebaStatic.log("c12300");
            if (this.jaT != null && this.jaT.getStatus() > 2 && this.jdK != null) {
                if (this.jaT.getVideoDuration() >= 3000.0f) {
                    this.jdK.clP();
                } else {
                    this.jdK.clQ();
                }
            }
        }
    }

    private void ek(List list) {
        if (!v.T(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(final boolean z) {
        if (this.jaT.getProgress() >= 100) {
            if (this.jdK != null) {
                this.jdK.clP();
                return;
            }
            return;
        }
        if (this.jdR.getCurrentBeautyItem() != null) {
            this.jdN.add(this.jdR.getCurrentBeautyItem());
        }
        if (this.jdR.getCurrentFilterItem() != null) {
            this.jdO.add(this.jdR.getCurrentFilterItem());
        }
        if (this.jdR.getCurrentStickItem() != null) {
            this.jdP.add(this.jdR.getCurrentStickItem());
        }
        AJ(2);
        if (this.jdR.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jaT.getStatus() == 6 || VideoControllerLayout.this.jaT.afz()) {
                        VideoControllerLayout.this.qK(z);
                    }
                }
            });
        } else {
            qK(z);
        }
        if (this.jaT != null) {
            this.jaT.startRecord();
        }
        if (this.jdK != null) {
            this.jdK.clK();
        }
    }

    public void stopRecord() {
        clW();
        int status = this.jaT.getStatus();
        if (this.jaT != null) {
            if (!this.jaT.clt() && this.jaT.afz()) {
                this.jaT.stopRecord();
            }
            clV();
        }
        if (this.jdK != null) {
            this.jdK.clz();
            if (status == 6) {
                this.jdK.clM();
            }
        }
    }

    public void clV() {
        if (this.jaT != null) {
            if (this.jaT.getVideoDuration() >= 3000.0f) {
                AJ(4);
            } else if (this.jaT.getVideoDuration() > 0) {
                AJ(3);
            } else {
                AJ(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(boolean z) {
        if (this.jcS != null && this.jcS.isRunning()) {
            this.jcS.cancel();
        }
        if (this.jcR == null) {
            this.jcR = new AnimatorSet();
            this.jcR.playTogether(ObjectAnimator.ofFloat(this.jdD, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jdG, "alpha", 1.0f, 0.0f));
            this.jcR.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jeE) {
                        VideoControllerLayout.this.jdD.setVisibility(8);
                        VideoControllerLayout.this.jdG.setVisibility(8);
                    }
                }
            });
            this.jcR.setDuration(300L);
        }
        this.jcR.start();
        if (this.jaT.getStatus() != 6) {
            this.jdF.qK(z);
        }
    }

    public void clW() {
        if (this.jaT == null || this.jaT.afz() || this.jaT.getStatus() == 6) {
            if (this.jcR != null && this.jcR.isRunning()) {
                this.jcR.cancel();
            }
            if (this.jcS == null) {
                this.jcS = new AnimatorSet();
                this.jcS.playTogether(ObjectAnimator.ofFloat(this.jdD, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jdG, "alpha", 0.0f, 1.0f));
                this.jcS.setDuration(300L);
            }
            this.jdD.setVisibility(0);
            this.jdG.setVisibility(0);
            this.jcS.start();
            if (this.jaT.getStatus() != 7 && this.jaT.getStatus() != 6) {
                this.jdF.clW();
                return;
            }
            this.jdF.getTvTip().setVisibility(8);
            if (this.fpO == 2) {
                this.jdF.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fpO) {
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
                if (this.jdK != null) {
                    this.jdK.clR();
                }
                if (this.jaT.getStatus() != 7 && this.jaT.getStatus() != 6) {
                    if (this.jaT != null && this.jaT.clq()) {
                        this.jdM = true;
                        com.baidu.tbadk.core.util.e.aca().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jdH = currentTimeMillis;
                    this.jdI = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jdI && VideoControllerLayout.this.jdH == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.bn(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jdM) {
                    this.jdM = false;
                    return;
                }
                this.jdI = false;
                if (this.jaT.afz() || this.jaT.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jaT.getStatus() != 8) {
                    bn(false);
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
                if (this.jaT.getStatus() == 6) {
                    this.jaT.setStatus(1);
                    if (this.jdK != null) {
                        this.jdK.clM();
                        this.jdK.clz();
                    }
                    this.jdF.getTvTip().setText("");
                    this.jdF.getTvTip().setVisibility(8);
                    return;
                } else if (this.jdR.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jdK != null) {
                    this.jdK.clL();
                    this.jdF.cmh();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jdF.cmi();
                return;
            default:
                return;
        }
    }

    public void clF() {
        if (this.jdR.getVisibility() == 0) {
            a((m) null);
        }
        qK(false);
        this.jdF.getLayer1().setVisibility(8);
        this.jdF.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.jdF.getTvTip().setVisibility(0);
        if (this.jdK != null) {
            this.jdK.clK();
        }
    }

    public void clX() {
        if (this.jaT.getStatus() == 6) {
            if (this.fpO == 2) {
                AJ(7);
                this.jdF.setAlpha(1.0f);
                this.jdD.setVisibility(8);
                this.jdG.setVisibility(8);
                this.jdF.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.jaT != null) {
                    this.jaT.startRecord();
                    return;
                }
                return;
            }
            this.jdF.getTvTip().setVisibility(8);
            if (this.jdK != null) {
                this.jdK.clL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        if (cma() && this.jdR.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cma()) {
            clZ();
        }
        this.jdR.clG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        if (cma() && this.jdR.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cma()) {
            clZ();
        }
        this.jdR.clH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clI() {
        if (cma() && this.jdR.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cma()) {
            clZ();
        }
        this.jdR.clI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clJ() {
        if (cma() && this.jdR.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cma()) {
            clZ();
        }
        this.jdR.clJ();
    }

    private void clY() {
        if (v.T(this.jdJ)) {
            this.jdJ = new ArrayList();
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdR, "translationY", 1000.0f, 0.0f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdE, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds100)));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdF.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdF.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdF.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdF.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdG, "scaleX", 1.0f, 0.7f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdG, "scaleY", 1.0f, 0.7f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdD, "scaleX", 1.0f, 0.7f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdD, "scaleY", 1.0f, 0.7f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdG, "alpha", 1.0f, 0.0f));
            this.jdJ.add(ObjectAnimator.ofFloat(this.jdD, "alpha", 1.0f, 0.0f));
        }
    }

    private void clZ() {
        int i = 0;
        if (this.jdR.getVisibility() != 0) {
            this.jdR.setVisibility(0);
            clY();
            this.jdG.setEnabled(false);
            this.jdD.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jdJ.size()) {
                    ObjectAnimator objectAnimator = this.jdJ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdJ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jdK != null) {
                                        VideoControllerLayout.this.jdK.clN();
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
        if (this.jdR.getVisibility() != 8) {
            clY();
            this.jdG.setEnabled(true);
            this.jdD.setEnabled(true);
            if (this.jaT.getStatus() == 6 || this.jaT.afz()) {
                this.jdD.setVisibility(8);
                this.jdG.setVisibility(8);
            } else {
                AJ(this.jaT.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jdJ.size()) {
                    ObjectAnimator objectAnimator = this.jdJ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdJ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jeE) {
                                        VideoControllerLayout.this.jdR.setVisibility(8);
                                        if (VideoControllerLayout.this.jdK != null) {
                                            VideoControllerLayout.this.jdK.clO();
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
        this.jdK = aVar;
    }

    public void setCurrentTab(int i) {
        this.fpO = i;
        switch (this.fpO) {
            case 1:
                this.jdD.setVisibility(4);
                this.jdG.setVisibility(4);
                this.jdF.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jaT.getStatus() != 1) {
                    this.jdD.setVisibility(0);
                    this.jdG.setVisibility(0);
                }
                this.jdF.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cma() {
        return this.jdR.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jdR != null) {
            this.jdR.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jdR != null) {
            this.jdR.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jdR != null) {
            this.jdR.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cmb() {
        if (this.jdR != null) {
            return this.jdR.cmb();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jdL = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jdN;
    }

    public List<e> getChoosedFilterList() {
        return this.jdO;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jdP;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jdQ.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jdR != null) {
            this.jdR.setMusicList(this.jdQ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
    }

    public void cmc() {
        if (this.jdR != null) {
            this.jdR.cmc();
        }
    }

    public void ckQ() {
        if (this.jdR != null) {
            this.jdR.ckQ();
        }
    }
}
