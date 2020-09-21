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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int iuC;
    private Handler mHandler;
    private i mJZ;
    private AnimatorSet mLR;
    private AnimatorSet mLS;
    private ImageView mMC;
    private RelativeLayout mMD;
    private VideoRecordButton mME;
    private ImageView mMF;
    private long mMG;
    private boolean mMH;
    private List<ObjectAnimator> mMI;
    private a mMJ;
    private boolean mMK;
    private boolean mML;
    private List<e> mMM;
    private List<e> mMN;
    private List<StickerItem> mMO;
    private List<e> mMP;
    private VideoEffectLayout mMQ;

    /* loaded from: classes22.dex */
    public interface a {
        void dHA();

        void dHL();

        void dHM();

        void dHN();

        void dHO();

        void dHP();

        void dHQ();

        void dHR();

        void dHS();

        void dHT();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mMG = 0L;
        this.mMH = false;
        this.mMK = true;
        this.mMM = new ArrayList();
        this.mMN = new ArrayList();
        this.mMO = new ArrayList();
        this.mMP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMG = 0L;
        this.mMH = false;
        this.mMK = true;
        this.mMM = new ArrayList();
        this.mMN = new ArrayList();
        this.mMO = new ArrayList();
        this.mMP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMG = 0L;
        this.mMH = false;
        this.mMK = true;
        this.mMM = new ArrayList();
        this.mMN = new ArrayList();
        this.mMO = new ArrayList();
        this.mMP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mMQ = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mMD = (RelativeLayout) findViewById(R.id.layout_record);
        this.mMC = (ImageView) findViewById(R.id.delete_video);
        this.mMC.setOnClickListener(this);
        this.mME = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mME.setOnTouchListener(this);
        this.mMF = (ImageView) findViewById(R.id.confirm_video);
        this.mMF.setOnClickListener(this);
        this.mMP.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mMP.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mJZ = iVar;
        JL(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mMQ != null) {
            this.mMQ.setListener(aVar);
        }
    }

    public void JL(int i) {
        this.mJZ.setStatus(i);
        if (this.mMJ != null) {
            this.mMJ.dHT();
        }
        if (i == 1) {
            this.mMC.setVisibility(8);
            this.mMF.setVisibility(8);
        } else if (i == 3) {
            this.mMC.setImageResource(R.drawable.video_back_selector);
            this.mMF.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mMC.setImageResource(R.drawable.video_back_selector);
            this.mMF.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mMC.setImageResource(R.drawable.video_delete_selector);
            if (this.mJZ != null && this.mJZ.getVideoDuration() >= 3000.0f) {
                this.mMF.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mMF.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mMC) {
            if (this.mMJ != null) {
                this.mMJ.dHS();
            }
            int status = this.mJZ.getStatus();
            if (this.mJZ != null && this.mJZ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mJZ.dHv();
                    fB(this.mMM);
                    fB(this.mMN);
                    fB(this.mMO);
                    if (this.mJZ.getVideoDuration() >= 3000.0f) {
                        JL(4);
                        return;
                    } else {
                        JL(this.mJZ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mJZ.dHu();
                JL(5);
            }
        } else if (view == this.mMF) {
            TiebaStatic.log("c12300");
            if (this.mJZ != null && this.mJZ.getStatus() > 2 && this.mMJ != null) {
                if (this.mJZ.getVideoDuration() >= 3000.0f) {
                    this.mMJ.dHQ();
                } else {
                    this.mMJ.dHR();
                }
            }
        }
    }

    private void fB(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(final boolean z) {
        if (this.mJZ.getProgress() >= 100) {
            if (this.mMJ != null) {
                this.mMJ.dHQ();
                return;
            }
            return;
        }
        if (this.mMQ.getCurrentBeautyItem() != null) {
            this.mMM.add(this.mMQ.getCurrentBeautyItem());
        }
        if (this.mMQ.getCurrentFilterItem() != null) {
            this.mMN.add(this.mMQ.getCurrentFilterItem());
        }
        if (this.mMQ.getCurrentStickItem() != null) {
            this.mMO.add(this.mMQ.getCurrentStickItem());
        }
        JL(2);
        if (this.mMQ.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mJZ.getStatus() == 6 || VideoControllerLayout.this.mJZ.bmW()) {
                        VideoControllerLayout.this.wY(z);
                    }
                }
            });
        } else {
            wY(z);
        }
        if (this.mJZ != null) {
            this.mJZ.startRecord();
        }
        if (this.mMJ != null) {
            this.mMJ.dHL();
        }
    }

    public void stopRecord() {
        dHX();
        int status = this.mJZ.getStatus();
        if (this.mJZ != null) {
            if (!this.mJZ.bJX() && this.mJZ.bmW()) {
                this.mJZ.stopRecord();
            }
            dHW();
        }
        if (this.mMJ != null) {
            this.mMJ.dHA();
            if (status == 6) {
                this.mMJ.dHN();
            }
        }
    }

    public void dHW() {
        if (this.mJZ != null) {
            if (this.mJZ.getVideoDuration() >= 3000.0f) {
                JL(4);
            } else if (this.mJZ.getVideoDuration() > 0) {
                JL(3);
            } else {
                JL(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(boolean z) {
        if (this.mLS != null && this.mLS.isRunning()) {
            this.mLS.cancel();
        }
        if (this.mLR == null) {
            this.mLR = new AnimatorSet();
            this.mLR.playTogether(ObjectAnimator.ofFloat(this.mMC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mMF, "alpha", 1.0f, 0.0f));
            this.mLR.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mND) {
                        VideoControllerLayout.this.mMC.setVisibility(8);
                        VideoControllerLayout.this.mMF.setVisibility(8);
                    }
                }
            });
            this.mLR.setDuration(300L);
        }
        this.mLR.start();
        if (this.mJZ.getStatus() != 6) {
            this.mME.wY(z);
        }
    }

    public void dHX() {
        if (this.mJZ == null || this.mJZ.bmW() || this.mJZ.getStatus() == 6) {
            if (this.mLR != null && this.mLR.isRunning()) {
                this.mLR.cancel();
            }
            if (this.mLS == null) {
                this.mLS = new AnimatorSet();
                this.mLS.playTogether(ObjectAnimator.ofFloat(this.mMC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mMF, "alpha", 0.0f, 1.0f));
                this.mLS.setDuration(300L);
            }
            this.mMC.setVisibility(0);
            this.mMF.setVisibility(0);
            this.mLS.start();
            if (this.mJZ.getStatus() != 7 && this.mJZ.getStatus() != 6) {
                this.mME.dHX();
                return;
            }
            this.mME.getTvTip().setVisibility(8);
            if (this.iuC == 2) {
                this.mME.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.iuC) {
            case 1:
                e(view, motionEvent);
                return true;
            case 2:
                d(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void d(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mMJ != null) {
                    this.mMJ.dHS();
                }
                if (this.mJZ.getStatus() != 7 && this.mJZ.getStatus() != 6) {
                    if (this.mJZ != null && this.mJZ.dHt()) {
                        this.mML = true;
                        com.baidu.tbadk.core.util.e.bjn().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mMG = currentTimeMillis;
                    this.mMH = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mMH && VideoControllerLayout.this.mMG == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.eN(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.mML) {
                    this.mML = false;
                    return;
                }
                this.mMH = false;
                if (this.mJZ.bmW() || this.mJZ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mJZ.getStatus() != 8) {
                    eN(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void e(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mJZ.getStatus() == 6) {
                    this.mJZ.setStatus(1);
                    if (this.mMJ != null) {
                        this.mMJ.dHN();
                        this.mMJ.dHA();
                    }
                    this.mME.getTvTip().setText("");
                    this.mME.getTvTip().setVisibility(8);
                    return;
                } else if (this.mMQ.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mMJ != null) {
                    this.mMJ.dHM();
                    this.mME.dIi();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mME.dIj();
                return;
            default:
                return;
        }
    }

    public void dHG() {
        if (this.mMQ.getVisibility() == 0) {
            a((m) null);
        }
        wY(false);
        this.mME.getLayer1().setVisibility(8);
        this.mME.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mME.getTvTip().setVisibility(0);
        if (this.mMJ != null) {
            this.mMJ.dHL();
        }
    }

    public void dHY() {
        if (this.mJZ.getStatus() == 6) {
            if (this.iuC == 2) {
                JL(7);
                this.mME.setAlpha(1.0f);
                this.mMC.setVisibility(8);
                this.mMF.setVisibility(8);
                this.mME.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mJZ != null) {
                    this.mJZ.startRecord();
                    return;
                }
                return;
            }
            this.mME.getTvTip().setVisibility(8);
            if (this.mMJ != null) {
                this.mMJ.dHM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHH() {
        if (dIb() && this.mMQ.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dIb()) {
            dIa();
        }
        this.mMQ.dHH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHI() {
        if (dIb() && this.mMQ.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dIb()) {
            dIa();
        }
        this.mMQ.dHI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHJ() {
        if (dIb() && this.mMQ.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dIb()) {
            dIa();
        }
        this.mMQ.dHJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHK() {
        if (dIb() && this.mMQ.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dIb()) {
            dIa();
        }
        this.mMQ.dHK();
    }

    private void dHZ() {
        if (y.isEmpty(this.mMI)) {
            this.mMI = new ArrayList();
            this.mMI.add(ObjectAnimator.ofFloat(this.mMQ, "translationY", 1000.0f, 0.0f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMD, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mMI.add(ObjectAnimator.ofFloat(this.mME.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mME.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mME.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mME.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMF, "scaleX", 1.0f, 0.7f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMF, "scaleY", 1.0f, 0.7f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMC, "scaleX", 1.0f, 0.7f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMC, "scaleY", 1.0f, 0.7f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMF, "alpha", 1.0f, 0.0f));
            this.mMI.add(ObjectAnimator.ofFloat(this.mMC, "alpha", 1.0f, 0.0f));
        }
    }

    private void dIa() {
        int i = 0;
        if (this.mMQ.getVisibility() != 0) {
            this.mMQ.setVisibility(0);
            dHZ();
            this.mMF.setEnabled(false);
            this.mMC.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mMI.size()) {
                    ObjectAnimator objectAnimator = this.mMI.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mMI.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mMJ != null) {
                                        VideoControllerLayout.this.mMJ.dHO();
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
        if (this.mMQ.getVisibility() != 8) {
            dHZ();
            this.mMF.setEnabled(true);
            this.mMC.setEnabled(true);
            if (this.mJZ.getStatus() == 6 || this.mJZ.bmW()) {
                this.mMC.setVisibility(8);
                this.mMF.setVisibility(8);
            } else {
                JL(this.mJZ.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mMI.size()) {
                    ObjectAnimator objectAnimator = this.mMI.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mMI.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mND) {
                                        VideoControllerLayout.this.mMQ.setVisibility(8);
                                        if (VideoControllerLayout.this.mMJ != null) {
                                            VideoControllerLayout.this.mMJ.dHP();
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
        this.mMJ = aVar;
    }

    public void setCurrentTab(int i) {
        this.iuC = i;
        switch (this.iuC) {
            case 1:
                this.mMC.setVisibility(4);
                this.mMF.setVisibility(4);
                this.mME.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mJZ.getStatus() != 1) {
                    this.mMC.setVisibility(0);
                    this.mMF.setVisibility(0);
                }
                this.mME.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dIb() {
        return this.mMQ.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mMQ != null) {
            this.mMQ.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mMQ != null) {
            this.mMQ.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mMQ != null) {
            this.mMQ.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dIc() {
        if (this.mMQ != null) {
            return this.mMQ.dIc();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mMK = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mMM;
    }

    public List<e> getChoosedFilterList() {
        return this.mMN;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mMO;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mMP.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mMQ != null) {
            this.mMQ.setMusicList(this.mMP);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
    }

    public void dId() {
        if (this.mMQ != null) {
            this.mMQ.dId();
        }
    }

    public void dGR() {
        if (this.mMQ != null) {
            this.mMQ.dGR();
        }
    }
}
