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
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jDP;
    private Handler mHandler;
    private i nQj;
    private AnimatorSet nRZ;
    private ImageView nSM;
    private RelativeLayout nSN;
    private VideoRecordButton nSO;
    private ImageView nSP;
    private long nSQ;
    private boolean nSR;
    private List<ObjectAnimator> nSS;
    private a nST;
    private boolean nSU;
    private boolean nSV;
    private List<e> nSW;
    private List<e> nSX;
    private List<StickerItem> nSY;
    private List<e> nSZ;
    private AnimatorSet nSa;
    private VideoEffectLayout nTa;

    /* loaded from: classes8.dex */
    public interface a {
        void dUG();

        void dUH();

        void dUI();

        void dUJ();

        void dUK();

        void dUL();

        void dUM();

        void dUN();

        void dUO();

        void dUu();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nSQ = 0L;
        this.nSR = false;
        this.nSU = true;
        this.nSW = new ArrayList();
        this.nSX = new ArrayList();
        this.nSY = new ArrayList();
        this.nSZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nSQ = 0L;
        this.nSR = false;
        this.nSU = true;
        this.nSW = new ArrayList();
        this.nSX = new ArrayList();
        this.nSY = new ArrayList();
        this.nSZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nSQ = 0L;
        this.nSR = false;
        this.nSU = true;
        this.nSW = new ArrayList();
        this.nSX = new ArrayList();
        this.nSY = new ArrayList();
        this.nSZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nTa = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nSN = (RelativeLayout) findViewById(R.id.layout_record);
        this.nSM = (ImageView) findViewById(R.id.delete_video);
        this.nSM.setOnClickListener(this);
        this.nSO = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nSO.setOnTouchListener(this);
        this.nSP = (ImageView) findViewById(R.id.confirm_video);
        this.nSP.setOnClickListener(this);
        this.nSZ.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nSZ.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nQj = iVar;
        KR(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nTa != null) {
            this.nTa.setListener(aVar);
        }
    }

    public void KR(int i) {
        this.nQj.setStatus(i);
        if (this.nST != null) {
            this.nST.dUO();
        }
        if (i == 1) {
            this.nSM.setVisibility(8);
            this.nSP.setVisibility(8);
        } else if (i == 3) {
            this.nSM.setImageResource(R.drawable.video_back_selector);
            this.nSP.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nSM.setImageResource(R.drawable.video_back_selector);
            this.nSP.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nSM.setImageResource(R.drawable.video_delete_selector);
            if (this.nQj != null && this.nQj.getVideoDuration() >= 3000.0f) {
                this.nSP.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nSP.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nSM) {
            if (this.nST != null) {
                this.nST.dUN();
            }
            int status = this.nQj.getStatus();
            if (this.nQj != null && this.nQj.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nQj.dUp();
                    gb(this.nSW);
                    gb(this.nSX);
                    gb(this.nSY);
                    if (this.nQj.getVideoDuration() >= 3000.0f) {
                        KR(4);
                        return;
                    } else {
                        KR(this.nQj.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nQj.dUo();
                KR(5);
            }
        } else if (view == this.nSP) {
            TiebaStatic.log("c12300");
            if (this.nQj != null && this.nQj.getStatus() > 2 && this.nST != null) {
                if (this.nQj.getVideoDuration() >= 3000.0f) {
                    this.nST.dUL();
                } else {
                    this.nST.dUM();
                }
            }
        }
    }

    private void gb(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge(final boolean z) {
        if (this.nQj.getProgress() >= 100) {
            if (this.nST != null) {
                this.nST.dUL();
                return;
            }
            return;
        }
        if (this.nTa.getCurrentBeautyItem() != null) {
            this.nSW.add(this.nTa.getCurrentBeautyItem());
        }
        if (this.nTa.getCurrentFilterItem() != null) {
            this.nSX.add(this.nTa.getCurrentFilterItem());
        }
        if (this.nTa.getCurrentStickItem() != null) {
            this.nSY.add(this.nTa.getCurrentStickItem());
        }
        KR(2);
        if (this.nTa.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nQj.getStatus() == 6 || VideoControllerLayout.this.nQj.isRecording()) {
                        VideoControllerLayout.this.zg(z);
                    }
                }
            });
        } else {
            zg(z);
        }
        if (this.nQj != null) {
            this.nQj.startRecord();
        }
        if (this.nST != null) {
            this.nST.dUG();
        }
    }

    public void stopRecord() {
        dUS();
        int status = this.nQj.getStatus();
        if (this.nQj != null) {
            if (!this.nQj.bUk() && this.nQj.isRecording()) {
                this.nQj.stopRecord();
            }
            dUR();
        }
        if (this.nST != null) {
            this.nST.dUu();
            if (status == 6) {
                this.nST.dUI();
            }
        }
    }

    public void dUR() {
        if (this.nQj != null) {
            if (this.nQj.getVideoDuration() >= 3000.0f) {
                KR(4);
            } else if (this.nQj.getVideoDuration() > 0) {
                KR(3);
            } else {
                KR(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg(boolean z) {
        if (this.nSa != null && this.nSa.isRunning()) {
            this.nSa.cancel();
        }
        if (this.nRZ == null) {
            this.nRZ = new AnimatorSet();
            this.nRZ.playTogether(ObjectAnimator.ofFloat(this.nSM, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nSP, "alpha", 1.0f, 0.0f));
            this.nRZ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTN) {
                        VideoControllerLayout.this.nSM.setVisibility(8);
                        VideoControllerLayout.this.nSP.setVisibility(8);
                    }
                }
            });
            this.nRZ.setDuration(300L);
        }
        this.nRZ.start();
        if (this.nQj.getStatus() != 6) {
            this.nSO.zg(z);
        }
    }

    public void dUS() {
        if (this.nQj == null || this.nQj.isRecording() || this.nQj.getStatus() == 6) {
            if (this.nRZ != null && this.nRZ.isRunning()) {
                this.nRZ.cancel();
            }
            if (this.nSa == null) {
                this.nSa = new AnimatorSet();
                this.nSa.playTogether(ObjectAnimator.ofFloat(this.nSM, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nSP, "alpha", 0.0f, 1.0f));
                this.nSa.setDuration(300L);
            }
            this.nSM.setVisibility(0);
            this.nSP.setVisibility(0);
            this.nSa.start();
            if (this.nQj.getStatus() != 7 && this.nQj.getStatus() != 6) {
                this.nSO.dUS();
                return;
            }
            this.nSO.getTvTip().setVisibility(8);
            if (this.jDP == 2) {
                this.nSO.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jDP) {
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
                if (this.nST != null) {
                    this.nST.dUN();
                }
                if (this.nQj.getStatus() != 7 && this.nQj.getStatus() != 6) {
                    if (this.nQj != null && this.nQj.dUn()) {
                        this.nSV = true;
                        com.baidu.tbadk.core.util.e.brY().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nSQ = currentTimeMillis;
                    this.nSR = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nSR && VideoControllerLayout.this.nSQ == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.ge(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nSV) {
                    this.nSV = false;
                    return;
                }
                this.nSR = false;
                if (this.nQj.isRecording() || this.nQj.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nQj.getStatus() != 8) {
                    ge(false);
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
                if (this.nQj.getStatus() == 6) {
                    this.nQj.setStatus(1);
                    if (this.nST != null) {
                        this.nST.dUI();
                        this.nST.dUu();
                    }
                    this.nSO.getTvTip().setText("");
                    this.nSO.getTvTip().setVisibility(8);
                    return;
                } else if (this.nTa.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nST != null) {
                    this.nST.dUH();
                    this.nSO.dVd();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nSO.dVe();
                return;
            default:
                return;
        }
    }

    public void dUB() {
        if (this.nTa.getVisibility() == 0) {
            a((m) null);
        }
        zg(false);
        this.nSO.getLayer1().setVisibility(8);
        this.nSO.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nSO.getTvTip().setVisibility(0);
        if (this.nST != null) {
            this.nST.dUG();
        }
    }

    public void dUT() {
        if (this.nQj.getStatus() == 6) {
            if (this.jDP == 2) {
                KR(7);
                this.nSO.setAlpha(1.0f);
                this.nSM.setVisibility(8);
                this.nSP.setVisibility(8);
                this.nSO.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nQj != null) {
                    this.nQj.startRecord();
                    return;
                }
                return;
            }
            this.nSO.getTvTip().setVisibility(8);
            if (this.nST != null) {
                this.nST.dUH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUC() {
        if (dUW() && this.nTa.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dUW()) {
            dUV();
        }
        this.nTa.dUC();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUD() {
        if (dUW() && this.nTa.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dUW()) {
            dUV();
        }
        this.nTa.dUD();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUE() {
        if (dUW() && this.nTa.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dUW()) {
            dUV();
        }
        this.nTa.dUE();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUF() {
        if (dUW() && this.nTa.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dUW()) {
            dUV();
        }
        this.nTa.dUF();
    }

    private void dUU() {
        if (y.isEmpty(this.nSS)) {
            this.nSS = new ArrayList();
            this.nSS.add(ObjectAnimator.ofFloat(this.nTa, "translationY", 1000.0f, 0.0f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSN, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSO.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSO.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSO.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSO.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSP, "scaleX", 1.0f, 0.7f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSP, "scaleY", 1.0f, 0.7f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSM, "scaleX", 1.0f, 0.7f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSM, "scaleY", 1.0f, 0.7f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSP, "alpha", 1.0f, 0.0f));
            this.nSS.add(ObjectAnimator.ofFloat(this.nSM, "alpha", 1.0f, 0.0f));
        }
    }

    private void dUV() {
        int i = 0;
        if (this.nTa.getVisibility() != 0) {
            this.nTa.setVisibility(0);
            dUU();
            this.nSP.setEnabled(false);
            this.nSM.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nSS.size()) {
                    ObjectAnimator objectAnimator = this.nSS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nSS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nST != null) {
                                        VideoControllerLayout.this.nST.dUJ();
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
        if (this.nTa.getVisibility() != 8) {
            dUU();
            this.nSP.setEnabled(true);
            this.nSM.setEnabled(true);
            if (this.nQj.getStatus() == 6 || this.nQj.isRecording()) {
                this.nSM.setVisibility(8);
                this.nSP.setVisibility(8);
            } else {
                KR(this.nQj.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nSS.size()) {
                    ObjectAnimator objectAnimator = this.nSS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nSS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nTN) {
                                        VideoControllerLayout.this.nTa.setVisibility(8);
                                        if (VideoControllerLayout.this.nST != null) {
                                            VideoControllerLayout.this.nST.dUK();
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
        this.nST = aVar;
    }

    public void setCurrentTab(int i) {
        this.jDP = i;
        switch (this.jDP) {
            case 1:
                this.nSM.setVisibility(4);
                this.nSP.setVisibility(4);
                this.nSO.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nQj.getStatus() != 1) {
                    this.nSM.setVisibility(0);
                    this.nSP.setVisibility(0);
                }
                this.nSO.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dUW() {
        return this.nTa.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nTa != null) {
            this.nTa.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nTa != null) {
            this.nTa.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nTa != null) {
            this.nTa.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dUX() {
        if (this.nTa != null) {
            return this.nTa.dUX();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nSU = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nSW;
    }

    public List<e> getChoosedFilterList() {
        return this.nSX;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nSY;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nSZ.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nTa != null) {
            this.nTa.setMusicList(this.nSZ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dUY() {
        if (this.nTa != null) {
            this.nTa.dUY();
        }
    }

    public void dTL() {
        if (this.nTa != null) {
            this.nTa.dTL();
        }
    }
}
