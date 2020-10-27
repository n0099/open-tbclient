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
/* loaded from: classes23.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int iVR;
    private Handler mHandler;
    private i nmg;
    private AnimatorSet nnX;
    private AnimatorSet nnY;
    private ImageView noK;
    private RelativeLayout noL;
    private VideoRecordButton noM;
    private ImageView noN;
    private long noO;
    private boolean noP;
    private List<ObjectAnimator> noQ;
    private a noR;
    private boolean noS;
    private boolean noT;
    private List<e> noU;
    private List<e> noV;
    private List<StickerItem> noW;
    private List<e> noX;
    private VideoEffectLayout noY;

    /* loaded from: classes23.dex */
    public interface a {
        void dOF();

        void dOG();

        void dOH();

        void dOI();

        void dOJ();

        void dOK();

        void dOL();

        void dOM();

        void dON();

        void dOu();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.noO = 0L;
        this.noP = false;
        this.noS = true;
        this.noU = new ArrayList();
        this.noV = new ArrayList();
        this.noW = new ArrayList();
        this.noX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.noO = 0L;
        this.noP = false;
        this.noS = true;
        this.noU = new ArrayList();
        this.noV = new ArrayList();
        this.noW = new ArrayList();
        this.noX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.noO = 0L;
        this.noP = false;
        this.noS = true;
        this.noU = new ArrayList();
        this.noV = new ArrayList();
        this.noW = new ArrayList();
        this.noX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.noY = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.noL = (RelativeLayout) findViewById(R.id.layout_record);
        this.noK = (ImageView) findViewById(R.id.delete_video);
        this.noK.setOnClickListener(this);
        this.noM = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.noM.setOnTouchListener(this);
        this.noN = (ImageView) findViewById(R.id.confirm_video);
        this.noN.setOnClickListener(this);
        this.noX.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.noX.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nmg = iVar;
        KJ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.noY != null) {
            this.noY.setListener(aVar);
        }
    }

    public void KJ(int i) {
        this.nmg.setStatus(i);
        if (this.noR != null) {
            this.noR.dON();
        }
        if (i == 1) {
            this.noK.setVisibility(8);
            this.noN.setVisibility(8);
        } else if (i == 3) {
            this.noK.setImageResource(R.drawable.video_back_selector);
            this.noN.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.noK.setImageResource(R.drawable.video_back_selector);
            this.noN.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.noK.setImageResource(R.drawable.video_delete_selector);
            if (this.nmg != null && this.nmg.getVideoDuration() >= 3000.0f) {
                this.noN.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.noN.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.noK) {
            if (this.noR != null) {
                this.noR.dOM();
            }
            int status = this.nmg.getStatus();
            if (this.nmg != null && this.nmg.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nmg.dOp();
                    fN(this.noU);
                    fN(this.noV);
                    fN(this.noW);
                    if (this.nmg.getVideoDuration() >= 3000.0f) {
                        KJ(4);
                        return;
                    } else {
                        KJ(this.nmg.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nmg.dOo();
                KJ(5);
            }
        } else if (view == this.noN) {
            TiebaStatic.log("c12300");
            if (this.nmg != null && this.nmg.getStatus() > 2 && this.noR != null) {
                if (this.nmg.getVideoDuration() >= 3000.0f) {
                    this.noR.dOK();
                } else {
                    this.noR.dOL();
                }
            }
        }
    }

    private void fN(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw(final boolean z) {
        if (this.nmg.getProgress() >= 100) {
            if (this.noR != null) {
                this.noR.dOK();
                return;
            }
            return;
        }
        if (this.noY.getCurrentBeautyItem() != null) {
            this.noU.add(this.noY.getCurrentBeautyItem());
        }
        if (this.noY.getCurrentFilterItem() != null) {
            this.noV.add(this.noY.getCurrentFilterItem());
        }
        if (this.noY.getCurrentStickItem() != null) {
            this.noW.add(this.noY.getCurrentStickItem());
        }
        KJ(2);
        if (this.noY.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nmg.getStatus() == 6 || VideoControllerLayout.this.nmg.brz()) {
                        VideoControllerLayout.this.xW(z);
                    }
                }
            });
        } else {
            xW(z);
        }
        if (this.nmg != null) {
            this.nmg.startRecord();
        }
        if (this.noR != null) {
            this.noR.dOF();
        }
    }

    public void stopRecord() {
        dOR();
        int status = this.nmg.getStatus();
        if (this.nmg != null) {
            if (!this.nmg.bPh() && this.nmg.brz()) {
                this.nmg.stopRecord();
            }
            dOQ();
        }
        if (this.noR != null) {
            this.noR.dOu();
            if (status == 6) {
                this.noR.dOH();
            }
        }
    }

    public void dOQ() {
        if (this.nmg != null) {
            if (this.nmg.getVideoDuration() >= 3000.0f) {
                KJ(4);
            } else if (this.nmg.getVideoDuration() > 0) {
                KJ(3);
            } else {
                KJ(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xW(boolean z) {
        if (this.nnY != null && this.nnY.isRunning()) {
            this.nnY.cancel();
        }
        if (this.nnX == null) {
            this.nnX = new AnimatorSet();
            this.nnX.playTogether(ObjectAnimator.ofFloat(this.noK, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.noN, "alpha", 1.0f, 0.0f));
            this.nnX.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.npL) {
                        VideoControllerLayout.this.noK.setVisibility(8);
                        VideoControllerLayout.this.noN.setVisibility(8);
                    }
                }
            });
            this.nnX.setDuration(300L);
        }
        this.nnX.start();
        if (this.nmg.getStatus() != 6) {
            this.noM.xW(z);
        }
    }

    public void dOR() {
        if (this.nmg == null || this.nmg.brz() || this.nmg.getStatus() == 6) {
            if (this.nnX != null && this.nnX.isRunning()) {
                this.nnX.cancel();
            }
            if (this.nnY == null) {
                this.nnY = new AnimatorSet();
                this.nnY.playTogether(ObjectAnimator.ofFloat(this.noK, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.noN, "alpha", 0.0f, 1.0f));
                this.nnY.setDuration(300L);
            }
            this.noK.setVisibility(0);
            this.noN.setVisibility(0);
            this.nnY.start();
            if (this.nmg.getStatus() != 7 && this.nmg.getStatus() != 6) {
                this.noM.dOR();
                return;
            }
            this.noM.getTvTip().setVisibility(8);
            if (this.iVR == 2) {
                this.noM.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.iVR) {
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
                if (this.noR != null) {
                    this.noR.dOM();
                }
                if (this.nmg.getStatus() != 7 && this.nmg.getStatus() != 6) {
                    if (this.nmg != null && this.nmg.dOn()) {
                        this.noT = true;
                        com.baidu.tbadk.core.util.e.bnP().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.noO = currentTimeMillis;
                    this.noP = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.noP && VideoControllerLayout.this.noO == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.fw(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.noT) {
                    this.noT = false;
                    return;
                }
                this.noP = false;
                if (this.nmg.brz() || this.nmg.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nmg.getStatus() != 8) {
                    fw(false);
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
                if (this.nmg.getStatus() == 6) {
                    this.nmg.setStatus(1);
                    if (this.noR != null) {
                        this.noR.dOH();
                        this.noR.dOu();
                    }
                    this.noM.getTvTip().setText("");
                    this.noM.getTvTip().setVisibility(8);
                    return;
                } else if (this.noY.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.noR != null) {
                    this.noR.dOG();
                    this.noM.dPc();
                    return;
                } else {
                    return;
                }
            case 1:
                this.noM.dPd();
                return;
            default:
                return;
        }
    }

    public void dOA() {
        if (this.noY.getVisibility() == 0) {
            a((m) null);
        }
        xW(false);
        this.noM.getLayer1().setVisibility(8);
        this.noM.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.noM.getTvTip().setVisibility(0);
        if (this.noR != null) {
            this.noR.dOF();
        }
    }

    public void dOS() {
        if (this.nmg.getStatus() == 6) {
            if (this.iVR == 2) {
                KJ(7);
                this.noM.setAlpha(1.0f);
                this.noK.setVisibility(8);
                this.noN.setVisibility(8);
                this.noM.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nmg != null) {
                    this.nmg.startRecord();
                    return;
                }
                return;
            }
            this.noM.getTvTip().setVisibility(8);
            if (this.noR != null) {
                this.noR.dOG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOB() {
        if (dOV() && this.noY.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dOV()) {
            dOU();
        }
        this.noY.dOB();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOC() {
        if (dOV() && this.noY.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dOV()) {
            dOU();
        }
        this.noY.dOC();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOD() {
        if (dOV() && this.noY.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dOV()) {
            dOU();
        }
        this.noY.dOD();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOE() {
        if (dOV() && this.noY.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dOV()) {
            dOU();
        }
        this.noY.dOE();
    }

    private void dOT() {
        if (y.isEmpty(this.noQ)) {
            this.noQ = new ArrayList();
            this.noQ.add(ObjectAnimator.ofFloat(this.noY, "translationY", 1000.0f, 0.0f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noL, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.noQ.add(ObjectAnimator.ofFloat(this.noM.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noM.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noM.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noM.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noN, "scaleX", 1.0f, 0.7f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noN, "scaleY", 1.0f, 0.7f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noK, "scaleX", 1.0f, 0.7f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noK, "scaleY", 1.0f, 0.7f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noN, "alpha", 1.0f, 0.0f));
            this.noQ.add(ObjectAnimator.ofFloat(this.noK, "alpha", 1.0f, 0.0f));
        }
    }

    private void dOU() {
        int i = 0;
        if (this.noY.getVisibility() != 0) {
            this.noY.setVisibility(0);
            dOT();
            this.noN.setEnabled(false);
            this.noK.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.noQ.size()) {
                    ObjectAnimator objectAnimator = this.noQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.noQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.noR != null) {
                                        VideoControllerLayout.this.noR.dOI();
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
        if (this.noY.getVisibility() != 8) {
            dOT();
            this.noN.setEnabled(true);
            this.noK.setEnabled(true);
            if (this.nmg.getStatus() == 6 || this.nmg.brz()) {
                this.noK.setVisibility(8);
                this.noN.setVisibility(8);
            } else {
                KJ(this.nmg.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.noQ.size()) {
                    ObjectAnimator objectAnimator = this.noQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.noQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.npL) {
                                        VideoControllerLayout.this.noY.setVisibility(8);
                                        if (VideoControllerLayout.this.noR != null) {
                                            VideoControllerLayout.this.noR.dOJ();
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
        this.noR = aVar;
    }

    public void setCurrentTab(int i) {
        this.iVR = i;
        switch (this.iVR) {
            case 1:
                this.noK.setVisibility(4);
                this.noN.setVisibility(4);
                this.noM.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nmg.getStatus() != 1) {
                    this.noK.setVisibility(0);
                    this.noN.setVisibility(0);
                }
                this.noM.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dOV() {
        return this.noY.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.noY != null) {
            this.noY.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.noY != null) {
            this.noY.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.noY != null) {
            this.noY.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dOW() {
        if (this.noY != null) {
            return this.noY.dOW();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.noS = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.noU;
    }

    public List<e> getChoosedFilterList() {
        return this.noV;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.noW;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.noX.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.noY != null) {
            this.noY.setMusicList(this.noX);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dOX() {
        if (this.noY != null) {
            this.noY.dOX();
        }
    }

    public void dNL() {
        if (this.noY != null) {
            this.noY.dNL();
        }
    }
}
