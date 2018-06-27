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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dzH;
    private i hgP;
    private AnimatorSet hiO;
    private AnimatorSet hiP;
    private ImageView hjA;
    private RelativeLayout hjB;
    private VideoRecordButton hjC;
    private ImageView hjD;
    private long hjE;
    private boolean hjF;
    private List<ObjectAnimator> hjG;
    private a hjH;
    private boolean hjI;
    private boolean hjJ;
    private List<e> hjK;
    private List<e> hjL;
    private List<StickerItem> hjM;
    private List<e> hjN;
    private VideoEffectLayout hjO;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bEA();

        void bEB();

        void bEi();

        void bEt();

        void bEu();

        void bEv();

        void bEw();

        void bEx();

        void bEy();

        void bEz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hjE = 0L;
        this.hjF = false;
        this.hjI = true;
        this.hjK = new ArrayList();
        this.hjL = new ArrayList();
        this.hjM = new ArrayList();
        this.hjN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjE = 0L;
        this.hjF = false;
        this.hjI = true;
        this.hjK = new ArrayList();
        this.hjL = new ArrayList();
        this.hjM = new ArrayList();
        this.hjN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjE = 0L;
        this.hjF = false;
        this.hjI = true;
        this.hjK = new ArrayList();
        this.hjL = new ArrayList();
        this.hjM = new ArrayList();
        this.hjN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.record_controller_layout, this);
        this.hjO = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hjB = (RelativeLayout) findViewById(d.g.layout_record);
        this.hjA = (ImageView) findViewById(d.g.delete_video);
        this.hjA.setOnClickListener(this);
        this.hjC = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hjC.setOnTouchListener(this);
        this.hjD = (ImageView) findViewById(d.g.confirm_video);
        this.hjD.setOnClickListener(this);
        this.hjN.add(0, new e(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute));
        this.hjN.add(1, new e(3, getResources().getString(d.k.music_cloud), new MusicData("-200", 2, getResources().getString(d.k.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hgP = iVar;
        uV(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hjO != null) {
            this.hjO.setListener(aVar);
        }
    }

    public void uV(int i) {
        this.hgP.setStatus(i);
        if (this.hjH != null) {
            this.hjH.bEB();
        }
        if (i == 1) {
            this.hjA.setVisibility(8);
            this.hjD.setVisibility(8);
        } else if (i == 3) {
            this.hjA.setImageResource(d.f.video_back_selector);
            this.hjD.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hjA.setImageResource(d.f.video_back_selector);
            this.hjD.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hjA.setImageResource(d.f.video_delete_selector);
            if (this.hgP != null && this.hgP.getVideoDuration() >= 3000.0f) {
                this.hjD.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hjD.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hjA) {
            if (this.hjH != null) {
                this.hjH.bEA();
            }
            int status = this.hgP.getStatus();
            if (this.hgP != null && this.hgP.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hgP.bEb();
                    dP(this.hjK);
                    dP(this.hjL);
                    dP(this.hjM);
                    if (this.hgP.getVideoDuration() >= 3000.0f) {
                        uV(4);
                        return;
                    } else {
                        uV(this.hgP.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hgP.bEa();
                uV(5);
            }
        } else if (view == this.hjD) {
            TiebaStatic.log("c12300");
            if (this.hgP != null && this.hgP.getStatus() > 2 && this.hjH != null) {
                if (this.hgP.getVideoDuration() >= 3000.0f) {
                    this.hjH.bEy();
                } else {
                    this.hjH.bEz();
                }
            }
        }
    }

    private void dP(List list) {
        if (!w.A(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np(final boolean z) {
        if (this.hgP.getProgress() >= 100) {
            if (this.hjH != null) {
                this.hjH.bEy();
                return;
            }
            return;
        }
        if (this.hjO.getCurrentBeautyItem() != null) {
            this.hjK.add(this.hjO.getCurrentBeautyItem());
        }
        if (this.hjO.getCurrentFilterItem() != null) {
            this.hjL.add(this.hjO.getCurrentFilterItem());
        }
        if (this.hjO.getCurrentStickItem() != null) {
            this.hjM.add(this.hjO.getCurrentStickItem());
        }
        uV(2);
        if (this.hjO.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hgP.getStatus() == 6 || VideoControllerLayout.this.hgP.isRecording()) {
                        VideoControllerLayout.this.nq(z);
                    }
                }
            });
        } else {
            nq(z);
        }
        if (this.hgP != null) {
            this.hgP.startRecord();
        }
        if (this.hjH != null) {
            this.hjH.bEt();
        }
    }

    public void stopRecord() {
        bEF();
        int status = this.hgP.getStatus();
        if (this.hgP != null) {
            if (!this.hgP.bEc() && this.hgP.isRecording()) {
                this.hgP.stopRecord();
            }
            bEE();
        }
        if (this.hjH != null) {
            this.hjH.bEi();
            if (status == 6) {
                this.hjH.bEv();
            }
        }
    }

    public void bEE() {
        if (this.hgP != null) {
            if (this.hgP.getVideoDuration() >= 3000.0f) {
                uV(4);
            } else if (this.hgP.getVideoDuration() > 0) {
                uV(3);
            } else {
                uV(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nq(boolean z) {
        if (this.hiP != null && this.hiP.isRunning()) {
            this.hiP.cancel();
        }
        if (this.hiO == null) {
            this.hiO = new AnimatorSet();
            this.hiO.playTogether(ObjectAnimator.ofFloat(this.hjA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hjD, "alpha", 1.0f, 0.0f));
            this.hiO.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hkD) {
                        VideoControllerLayout.this.hjA.setVisibility(8);
                        VideoControllerLayout.this.hjD.setVisibility(8);
                    }
                }
            });
            this.hiO.setDuration(300L);
        }
        this.hiO.start();
        if (this.hgP.getStatus() != 6) {
            this.hjC.nq(z);
        }
    }

    public void bEF() {
        if (this.hgP == null || this.hgP.isRecording() || this.hgP.getStatus() == 6) {
            if (this.hiO != null && this.hiO.isRunning()) {
                this.hiO.cancel();
            }
            if (this.hiP == null) {
                this.hiP = new AnimatorSet();
                this.hiP.playTogether(ObjectAnimator.ofFloat(this.hjA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hjD, "alpha", 0.0f, 1.0f));
                this.hiP.setDuration(300L);
            }
            this.hjA.setVisibility(0);
            this.hjD.setVisibility(0);
            this.hiP.start();
            if (this.hgP.getStatus() != 7 && this.hgP.getStatus() != 6) {
                this.hjC.bEF();
                return;
            }
            this.hjC.getTvTip().setVisibility(8);
            if (this.dzH == 2) {
                this.hjC.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dzH) {
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
                if (this.hjH != null) {
                    this.hjH.bEA();
                }
                if (this.hgP.getStatus() != 7 && this.hgP.getStatus() != 6) {
                    if (this.hgP != null && this.hgP.bDZ()) {
                        this.hjJ = true;
                        com.baidu.tbadk.core.util.e.ym().showToast(d.k.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hjE = currentTimeMillis;
                    this.hjF = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hjF && VideoControllerLayout.this.hjE == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.np(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hjJ) {
                    this.hjJ = false;
                    return;
                }
                this.hjF = false;
                if (this.hgP.isRecording() || this.hgP.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hgP.getStatus() != 8) {
                    np(false);
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
                if (this.hgP.getStatus() == 6) {
                    this.hgP.setStatus(1);
                    if (this.hjH != null) {
                        this.hjH.bEv();
                        this.hjH.bEi();
                    }
                    this.hjC.getTvTip().setText("");
                    this.hjC.getTvTip().setVisibility(8);
                    return;
                } else if (this.hjO.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hjH != null) {
                    this.hjH.bEu();
                    this.hjC.bEQ();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hjC.bER();
                return;
            default:
                return;
        }
    }

    public void bEo() {
        if (this.hjO.getVisibility() == 0) {
            a((m) null);
        }
        nq(false);
        this.hjC.getLayer1().setVisibility(8);
        this.hjC.getTvTip().setText(getResources().getText(d.k.video_record_button_cancel));
        this.hjC.getTvTip().setVisibility(0);
        if (this.hjH != null) {
            this.hjH.bEt();
        }
    }

    public void bEG() {
        if (this.hgP.getStatus() == 6) {
            if (this.dzH == 2) {
                uV(7);
                this.hjC.setAlpha(1.0f);
                this.hjA.setVisibility(8);
                this.hjD.setVisibility(8);
                this.hjC.getTvTip().setText(getResources().getString(d.k.video_record_button_pasue));
                if (this.hgP != null) {
                    this.hgP.startRecord();
                    return;
                }
                return;
            }
            this.hjC.getTvTip().setVisibility(8);
            if (this.hjH != null) {
                this.hjH.bEu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEp() {
        if (bEJ() && this.hjO.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bEJ()) {
            bEI();
        }
        this.hjO.bEp();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEq() {
        if (bEJ() && this.hjO.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bEJ()) {
            bEI();
        }
        this.hjO.bEq();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEr() {
        if (bEJ() && this.hjO.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bEJ()) {
            bEI();
        }
        this.hjO.bEr();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEs() {
        if (bEJ() && this.hjO.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bEJ()) {
            bEI();
        }
        this.hjO.bEs();
    }

    private void bEH() {
        if (w.A(this.hjG)) {
            this.hjG = new ArrayList();
            this.hjG.add(ObjectAnimator.ofFloat(this.hjO, "translationY", 1000.0f, 0.0f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjB, "translationY", 0.0f, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds100)));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjC.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjC.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjC.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjC.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjD, "scaleX", 1.0f, 0.7f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjD, "scaleY", 1.0f, 0.7f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjA, "scaleX", 1.0f, 0.7f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjA, "scaleY", 1.0f, 0.7f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjD, "alpha", 1.0f, 0.0f));
            this.hjG.add(ObjectAnimator.ofFloat(this.hjA, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEI() {
        int i = 0;
        if (this.hjO.getVisibility() != 0) {
            this.hjO.setVisibility(0);
            bEH();
            this.hjD.setEnabled(false);
            this.hjA.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hjG.size()) {
                    ObjectAnimator objectAnimator = this.hjG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hjG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hjH != null) {
                                        VideoControllerLayout.this.hjH.bEw();
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
        if (this.hjO.getVisibility() != 8) {
            bEH();
            this.hjD.setEnabled(true);
            this.hjA.setEnabled(true);
            if (this.hgP.getStatus() == 6 || this.hgP.isRecording()) {
                this.hjA.setVisibility(8);
                this.hjD.setVisibility(8);
            } else {
                uV(this.hgP.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hjG.size()) {
                    ObjectAnimator objectAnimator = this.hjG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hjG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hkD) {
                                        VideoControllerLayout.this.hjO.setVisibility(8);
                                        if (VideoControllerLayout.this.hjH != null) {
                                            VideoControllerLayout.this.hjH.bEx();
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
        this.hjH = aVar;
    }

    public void setCurrentTab(int i) {
        this.dzH = i;
        switch (this.dzH) {
            case 1:
                this.hjA.setVisibility(4);
                this.hjD.setVisibility(4);
                this.hjC.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hgP.getStatus() != 1) {
                    this.hjA.setVisibility(0);
                    this.hjD.setVisibility(0);
                }
                this.hjC.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEJ() {
        return this.hjO.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hjO != null) {
            this.hjO.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hjO != null) {
            this.hjO.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hjO != null) {
            this.hjO.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEK() {
        if (this.hjO != null) {
            return this.hjO.bEK();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hjI = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hjK;
    }

    public List<e> getChoosedFilterList() {
        return this.hjL;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hjM;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hjN.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hjO != null) {
            this.hjO.setMusicList(this.hjN);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bEL() {
        if (this.hjO != null) {
            this.hjO.bEL();
        }
    }

    public void bDy() {
        if (this.hjO != null) {
            this.hjO.bDy();
        }
    }
}
