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
    private int dRR;
    private j huY;
    private AnimatorSet hwX;
    private AnimatorSet hwY;
    private ImageView hxJ;
    private RelativeLayout hxK;
    private VideoRecordButton hxL;
    private ImageView hxM;
    private long hxN;
    private boolean hxO;
    private List<ObjectAnimator> hxP;
    private a hxQ;
    private boolean hxR;
    private boolean hxS;
    private List<e> hxT;
    private List<e> hxU;
    private List<StickerItem> hxV;
    private List<e> hxW;
    private VideoEffectLayout hxX;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDK();

        void bDL();

        void bDV();

        void bDW();

        void bDX();

        void bDY();

        void bDZ();

        void bEa();

        void bEb();

        void bEc();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hxN = 0L;
        this.hxO = false;
        this.hxR = true;
        this.hxT = new ArrayList();
        this.hxU = new ArrayList();
        this.hxV = new ArrayList();
        this.hxW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxN = 0L;
        this.hxO = false;
        this.hxR = true;
        this.hxT = new ArrayList();
        this.hxU = new ArrayList();
        this.hxV = new ArrayList();
        this.hxW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxN = 0L;
        this.hxO = false;
        this.hxR = true;
        this.hxT = new ArrayList();
        this.hxU = new ArrayList();
        this.hxV = new ArrayList();
        this.hxW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hxX = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hxK = (RelativeLayout) findViewById(d.g.layout_record);
        this.hxJ = (ImageView) findViewById(d.g.delete_video);
        this.hxJ.setOnClickListener(this);
        this.hxL = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hxL.setOnTouchListener(this);
        this.hxM = (ImageView) findViewById(d.g.confirm_video);
        this.hxM.setOnClickListener(this);
        this.hxW.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hxW.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.huY = jVar;
        wZ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hxX != null) {
            this.hxX.setListener(aVar);
        }
    }

    public void wZ(int i) {
        this.huY.setStatus(i);
        if (this.hxQ != null) {
            this.hxQ.bEc();
        }
        if (i == 1) {
            this.hxJ.setVisibility(8);
            this.hxM.setVisibility(8);
        } else if (i == 3) {
            this.hxJ.setImageResource(d.f.video_back_selector);
            this.hxM.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hxJ.setImageResource(d.f.video_back_selector);
            this.hxM.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hxJ.setImageResource(d.f.video_delete_selector);
            if (this.huY != null && this.huY.getVideoDuration() >= 3000.0f) {
                this.hxM.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hxM.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hxJ) {
            if (this.hxQ != null) {
                this.hxQ.bEb();
            }
            int status = this.huY.getStatus();
            if (this.huY != null && this.huY.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.huY.bDE();
                    dN(this.hxT);
                    dN(this.hxU);
                    dN(this.hxV);
                    if (this.huY.getVideoDuration() >= 3000.0f) {
                        wZ(4);
                        return;
                    } else {
                        wZ(this.huY.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.huY.bDD();
                wZ(5);
            }
        } else if (view == this.hxM) {
            TiebaStatic.log("c12300");
            if (this.huY != null && this.huY.getStatus() > 2 && this.hxQ != null) {
                if (this.huY.getVideoDuration() >= 3000.0f) {
                    this.hxQ.bDL();
                } else {
                    this.hxQ.bEa();
                }
            }
        }
    }

    private void dN(List list) {
        if (!v.E(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(final boolean z) {
        if (this.huY.getProgress() >= 100) {
            if (this.hxQ != null) {
                this.hxQ.bDL();
                return;
            }
            return;
        }
        if (this.hxX.getCurrentBeautyItem() != null) {
            this.hxT.add(this.hxX.getCurrentBeautyItem());
        }
        if (this.hxX.getCurrentFilterItem() != null) {
            this.hxU.add(this.hxX.getCurrentFilterItem());
        }
        if (this.hxX.getCurrentStickItem() != null) {
            this.hxV.add(this.hxX.getCurrentStickItem());
        }
        wZ(2);
        if (this.hxX.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.huY.getStatus() == 6 || VideoControllerLayout.this.huY.isRecording()) {
                        VideoControllerLayout.this.nz(z);
                    }
                }
            });
        } else {
            nz(z);
        }
        if (this.huY != null) {
            this.huY.startRecord();
        }
        if (this.hxQ != null) {
            this.hxQ.bDV();
        }
    }

    public void stopRecord() {
        bEh();
        int status = this.huY.getStatus();
        if (this.huY != null) {
            if (this.huY.getStatus() != 6 && this.huY.isRecording()) {
                this.huY.stopRecord();
            }
            if (this.huY.getVideoDuration() >= 3000.0f) {
                wZ(4);
            } else if (this.huY.getVideoDuration() > 0) {
                wZ(3);
            } else {
                wZ(1);
            }
        }
        if (this.hxQ != null) {
            this.hxQ.bDK();
            if (status == 6) {
                this.hxQ.bDX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nz(boolean z) {
        if (this.hwY != null && this.hwY.isRunning()) {
            this.hwY.cancel();
        }
        if (this.hwX == null) {
            this.hwX = new AnimatorSet();
            this.hwX.playTogether(ObjectAnimator.ofFloat(this.hxJ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hxM, "alpha", 1.0f, 0.0f));
            this.hwX.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyM) {
                        VideoControllerLayout.this.hxJ.setVisibility(8);
                        VideoControllerLayout.this.hxM.setVisibility(8);
                    }
                }
            });
            this.hwX.setDuration(300L);
        }
        this.hwX.start();
        if (this.huY.getStatus() != 6) {
            this.hxL.nz(z);
        }
    }

    public void bEh() {
        if (this.huY == null || this.huY.isRecording() || this.huY.getStatus() == 6) {
            if (this.hwX != null && this.hwX.isRunning()) {
                this.hwX.cancel();
            }
            if (this.hwY == null) {
                this.hwY = new AnimatorSet();
                this.hwY.playTogether(ObjectAnimator.ofFloat(this.hxJ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hxM, "alpha", 0.0f, 1.0f));
                this.hwY.setDuration(300L);
            }
            this.hxJ.setVisibility(0);
            this.hxM.setVisibility(0);
            this.hwY.start();
            if (this.huY.getStatus() != 7 && this.huY.getStatus() != 6) {
                this.hxL.bEh();
                return;
            }
            this.hxL.getTvTip().setVisibility(8);
            if (this.dRR == 2) {
                this.hxL.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dRR) {
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
                if (this.hxQ != null) {
                    this.hxQ.bEb();
                }
                if (this.huY.getStatus() != 7 && this.huY.getStatus() != 6) {
                    if (this.huY != null && this.huY.bDC()) {
                        this.hxS = true;
                        com.baidu.tbadk.core.util.e.BR().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hxN = currentTimeMillis;
                    this.hxO = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hxO && VideoControllerLayout.this.hxN == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.ny(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hxS) {
                    this.hxS = false;
                    return;
                }
                this.hxO = false;
                if (this.huY.isRecording() || this.huY.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.huY.getStatus() != 8) {
                    ny(false);
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
                if (this.huY.getStatus() == 6) {
                    this.huY.setStatus(1);
                    if (this.hxQ != null) {
                        this.hxQ.bDX();
                        this.hxQ.bDK();
                    }
                    this.hxL.getTvTip().setText("");
                    this.hxL.getTvTip().setVisibility(8);
                    return;
                } else if (this.hxX.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hxQ != null) {
                    this.hxQ.bDW();
                    this.hxL.bEs();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hxL.bEt();
                return;
            default:
                return;
        }
    }

    public void bDQ() {
        if (this.hxX.getVisibility() == 0) {
            a((o) null);
        }
        nz(false);
        this.hxL.getLayer1().setVisibility(8);
        this.hxL.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hxL.getTvTip().setVisibility(0);
        if (this.hxQ != null) {
            this.hxQ.bDV();
        }
    }

    public void bEi() {
        if (this.huY.getStatus() == 6) {
            if (this.dRR == 2) {
                wZ(7);
                this.hxL.setAlpha(1.0f);
                this.hxJ.setVisibility(8);
                this.hxM.setVisibility(8);
                this.hxL.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.huY != null) {
                    this.huY.startRecord();
                    return;
                }
                return;
            }
            this.hxL.getTvTip().setVisibility(8);
            if (this.hxQ != null) {
                this.hxQ.bDW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        if (bEl() && this.hxX.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bEl()) {
            bEk();
        }
        this.hxX.bDR();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        if (bEl() && this.hxX.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bEl()) {
            bEk();
        }
        this.hxX.bDS();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDT() {
        if (bEl() && this.hxX.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bEl()) {
            bEk();
        }
        this.hxX.bDT();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDU() {
        if (bEl() && this.hxX.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bEl()) {
            bEk();
        }
        this.hxX.bDU();
    }

    private void bEj() {
        if (v.E(this.hxP)) {
            this.hxP = new ArrayList();
            this.hxP.add(ObjectAnimator.ofFloat(this.hxX, "translationY", 1000.0f, 0.0f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxK, "translationY", 0.0f, com.baidu.adp.lib.util.l.t(getContext(), d.e.ds100)));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxL.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxL.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxL.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxL.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxM, "scaleX", 1.0f, 0.7f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxM, "scaleY", 1.0f, 0.7f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxJ, "scaleX", 1.0f, 0.7f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxJ, "scaleY", 1.0f, 0.7f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxM, "alpha", 1.0f, 0.0f));
            this.hxP.add(ObjectAnimator.ofFloat(this.hxJ, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEk() {
        int i = 0;
        if (this.hxX.getVisibility() != 0) {
            this.hxX.setVisibility(0);
            bEj();
            this.hxM.setEnabled(false);
            this.hxJ.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hxP.size()) {
                    ObjectAnimator objectAnimator = this.hxP.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxP.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hxQ != null) {
                                        VideoControllerLayout.this.hxQ.bDY();
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
        if (this.hxX.getVisibility() != 8) {
            bEj();
            this.hxM.setEnabled(true);
            this.hxJ.setEnabled(true);
            if (this.huY.getStatus() == 6 || this.huY.isRecording()) {
                this.hxJ.setVisibility(8);
                this.hxM.setVisibility(8);
            } else {
                wZ(this.huY.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hxP.size()) {
                    ObjectAnimator objectAnimator = this.hxP.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxP.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hyM) {
                                        VideoControllerLayout.this.hxX.setVisibility(8);
                                        if (VideoControllerLayout.this.hxQ != null) {
                                            VideoControllerLayout.this.hxQ.bDZ();
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
        this.hxQ = aVar;
    }

    public void setCurrentTab(int i) {
        this.dRR = i;
        switch (this.dRR) {
            case 1:
                this.hxJ.setVisibility(4);
                this.hxM.setVisibility(4);
                this.hxL.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.huY.getStatus() != 1) {
                    this.hxJ.setVisibility(0);
                    this.hxM.setVisibility(0);
                }
                this.hxL.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEl() {
        return this.hxX.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hxX != null) {
            this.hxX.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hxX != null) {
            this.hxX.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hxX != null) {
            this.hxX.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEm() {
        if (this.hxX != null) {
            return this.hxX.bEm();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hxR = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hxT;
    }

    public List<e> getChoosedFilterList() {
        return this.hxU;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hxV;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hxW.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hxX != null) {
            this.hxX.setMusicList(this.hxW);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bEd() {
        if (this.hxX != null) {
            this.hxX.bEd();
        }
    }

    public void bEn() {
        if (this.hxX != null) {
            this.hxX.bEn();
        }
    }

    public void bDb() {
        if (this.hxX != null) {
            this.hxX.bDb();
        }
    }
}
