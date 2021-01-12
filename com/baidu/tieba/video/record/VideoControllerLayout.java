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
/* loaded from: classes7.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jxW;
    private Handler mHandler;
    private i nFZ;
    private AnimatorSet nHR;
    private AnimatorSet nHS;
    private ImageView nIE;
    private RelativeLayout nIF;
    private VideoRecordButton nIG;
    private ImageView nIH;
    private long nII;
    private boolean nIJ;
    private List<ObjectAnimator> nIK;
    private a nIL;
    private boolean nIM;
    private boolean nIN;
    private List<e> nIO;
    private List<e> nIP;
    private List<StickerItem> nIQ;
    private List<e> nIR;
    private VideoEffectLayout nIS;

    /* loaded from: classes7.dex */
    public interface a {
        void dSb();

        void dSn();

        void dSo();

        void dSp();

        void dSq();

        void dSr();

        void dSs();

        void dSt();

        void dSu();

        void dSv();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nII = 0L;
        this.nIJ = false;
        this.nIM = true;
        this.nIO = new ArrayList();
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nII = 0L;
        this.nIJ = false;
        this.nIM = true;
        this.nIO = new ArrayList();
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nII = 0L;
        this.nIJ = false;
        this.nIM = true;
        this.nIO = new ArrayList();
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nIS = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nIF = (RelativeLayout) findViewById(R.id.layout_record);
        this.nIE = (ImageView) findViewById(R.id.delete_video);
        this.nIE.setOnClickListener(this);
        this.nIG = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nIG.setOnTouchListener(this);
        this.nIH = (ImageView) findViewById(R.id.confirm_video);
        this.nIH.setOnClickListener(this);
        this.nIR.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nIR.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nFZ = iVar;
        Kx(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nIS != null) {
            this.nIS.setListener(aVar);
        }
    }

    public void Kx(int i) {
        this.nFZ.setStatus(i);
        if (this.nIL != null) {
            this.nIL.dSv();
        }
        if (i == 1) {
            this.nIE.setVisibility(8);
            this.nIH.setVisibility(8);
        } else if (i == 3) {
            this.nIE.setImageResource(R.drawable.video_back_selector);
            this.nIH.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nIE.setImageResource(R.drawable.video_back_selector);
            this.nIH.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nIE.setImageResource(R.drawable.video_delete_selector);
            if (this.nFZ != null && this.nFZ.getVideoDuration() >= 3000.0f) {
                this.nIH.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nIH.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nIE) {
            if (this.nIL != null) {
                this.nIL.dSu();
            }
            int status = this.nFZ.getStatus();
            if (this.nFZ != null && this.nFZ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nFZ.dRW();
                    gd(this.nIO);
                    gd(this.nIP);
                    gd(this.nIQ);
                    if (this.nFZ.getVideoDuration() >= 3000.0f) {
                        Kx(4);
                        return;
                    } else {
                        Kx(this.nFZ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nFZ.dRV();
                Kx(5);
            }
        } else if (view == this.nIH) {
            TiebaStatic.log("c12300");
            if (this.nFZ != null && this.nFZ.getStatus() > 2 && this.nIL != null) {
                if (this.nFZ.getVideoDuration() >= 3000.0f) {
                    this.nIL.dSs();
                } else {
                    this.nIL.dSt();
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
    public void gc(final boolean z) {
        if (this.nFZ.getProgress() >= 100) {
            if (this.nIL != null) {
                this.nIL.dSs();
                return;
            }
            return;
        }
        if (this.nIS.getCurrentBeautyItem() != null) {
            this.nIO.add(this.nIS.getCurrentBeautyItem());
        }
        if (this.nIS.getCurrentFilterItem() != null) {
            this.nIP.add(this.nIS.getCurrentFilterItem());
        }
        if (this.nIS.getCurrentStickItem() != null) {
            this.nIQ.add(this.nIS.getCurrentStickItem());
        }
        Kx(2);
        if (this.nIS.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nFZ.getStatus() == 6 || VideoControllerLayout.this.nFZ.bvp()) {
                        VideoControllerLayout.this.yN(z);
                    }
                }
            });
        } else {
            yN(z);
        }
        if (this.nFZ != null) {
            this.nFZ.startRecord();
        }
        if (this.nIL != null) {
            this.nIL.dSn();
        }
    }

    public void stopRecord() {
        dSz();
        int status = this.nFZ.getStatus();
        if (this.nFZ != null) {
            if (!this.nFZ.bTy() && this.nFZ.bvp()) {
                this.nFZ.stopRecord();
            }
            dSy();
        }
        if (this.nIL != null) {
            this.nIL.dSb();
            if (status == 6) {
                this.nIL.dSp();
            }
        }
    }

    public void dSy() {
        if (this.nFZ != null) {
            if (this.nFZ.getVideoDuration() >= 3000.0f) {
                Kx(4);
            } else if (this.nFZ.getVideoDuration() > 0) {
                Kx(3);
            } else {
                Kx(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(boolean z) {
        if (this.nHS != null && this.nHS.isRunning()) {
            this.nHS.cancel();
        }
        if (this.nHR == null) {
            this.nHR = new AnimatorSet();
            this.nHR.playTogether(ObjectAnimator.ofFloat(this.nIE, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nIH, "alpha", 1.0f, 0.0f));
            this.nHR.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nJF) {
                        VideoControllerLayout.this.nIE.setVisibility(8);
                        VideoControllerLayout.this.nIH.setVisibility(8);
                    }
                }
            });
            this.nHR.setDuration(300L);
        }
        this.nHR.start();
        if (this.nFZ.getStatus() != 6) {
            this.nIG.yN(z);
        }
    }

    public void dSz() {
        if (this.nFZ == null || this.nFZ.bvp() || this.nFZ.getStatus() == 6) {
            if (this.nHR != null && this.nHR.isRunning()) {
                this.nHR.cancel();
            }
            if (this.nHS == null) {
                this.nHS = new AnimatorSet();
                this.nHS.playTogether(ObjectAnimator.ofFloat(this.nIE, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nIH, "alpha", 0.0f, 1.0f));
                this.nHS.setDuration(300L);
            }
            this.nIE.setVisibility(0);
            this.nIH.setVisibility(0);
            this.nHS.start();
            if (this.nFZ.getStatus() != 7 && this.nFZ.getStatus() != 6) {
                this.nIG.dSz();
                return;
            }
            this.nIG.getTvTip().setVisibility(8);
            if (this.jxW == 2) {
                this.nIG.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jxW) {
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
                if (this.nIL != null) {
                    this.nIL.dSu();
                }
                if (this.nFZ.getStatus() != 7 && this.nFZ.getStatus() != 6) {
                    if (this.nFZ != null && this.nFZ.dRU()) {
                        this.nIN = true;
                        com.baidu.tbadk.core.util.e.brF().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nII = currentTimeMillis;
                    this.nIJ = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nIJ && VideoControllerLayout.this.nII == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.gc(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nIN) {
                    this.nIN = false;
                    return;
                }
                this.nIJ = false;
                if (this.nFZ.bvp() || this.nFZ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nFZ.getStatus() != 8) {
                    gc(false);
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
                if (this.nFZ.getStatus() == 6) {
                    this.nFZ.setStatus(1);
                    if (this.nIL != null) {
                        this.nIL.dSp();
                        this.nIL.dSb();
                    }
                    this.nIG.getTvTip().setText("");
                    this.nIG.getTvTip().setVisibility(8);
                    return;
                } else if (this.nIS.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nIL != null) {
                    this.nIL.dSo();
                    this.nIG.dSK();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nIG.dSL();
                return;
            default:
                return;
        }
    }

    public void dSi() {
        if (this.nIS.getVisibility() == 0) {
            a((m) null);
        }
        yN(false);
        this.nIG.getLayer1().setVisibility(8);
        this.nIG.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nIG.getTvTip().setVisibility(0);
        if (this.nIL != null) {
            this.nIL.dSn();
        }
    }

    public void dSA() {
        if (this.nFZ.getStatus() == 6) {
            if (this.jxW == 2) {
                Kx(7);
                this.nIG.setAlpha(1.0f);
                this.nIE.setVisibility(8);
                this.nIH.setVisibility(8);
                this.nIG.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nFZ != null) {
                    this.nFZ.startRecord();
                    return;
                }
                return;
            }
            this.nIG.getTvTip().setVisibility(8);
            if (this.nIL != null) {
                this.nIL.dSo();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSj() {
        if (dSD() && this.nIS.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIS.dSj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSk() {
        if (dSD() && this.nIS.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIS.dSk();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSl() {
        if (dSD() && this.nIS.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIS.dSl();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSm() {
        if (dSD() && this.nIS.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIS.dSm();
    }

    private void dSB() {
        if (x.isEmpty(this.nIK)) {
            this.nIK = new ArrayList();
            this.nIK.add(ObjectAnimator.ofFloat(this.nIS, "translationY", 1000.0f, 0.0f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIF, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIG.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIG.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIG.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIG.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIH, "scaleX", 1.0f, 0.7f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIH, "scaleY", 1.0f, 0.7f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIE, "scaleX", 1.0f, 0.7f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIE, "scaleY", 1.0f, 0.7f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIH, "alpha", 1.0f, 0.0f));
            this.nIK.add(ObjectAnimator.ofFloat(this.nIE, "alpha", 1.0f, 0.0f));
        }
    }

    private void dSC() {
        int i = 0;
        if (this.nIS.getVisibility() != 0) {
            this.nIS.setVisibility(0);
            dSB();
            this.nIH.setEnabled(false);
            this.nIE.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nIK.size()) {
                    ObjectAnimator objectAnimator = this.nIK.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nIK.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nIL != null) {
                                        VideoControllerLayout.this.nIL.dSq();
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
        if (this.nIS.getVisibility() != 8) {
            dSB();
            this.nIH.setEnabled(true);
            this.nIE.setEnabled(true);
            if (this.nFZ.getStatus() == 6 || this.nFZ.bvp()) {
                this.nIE.setVisibility(8);
                this.nIH.setVisibility(8);
            } else {
                Kx(this.nFZ.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nIK.size()) {
                    ObjectAnimator objectAnimator = this.nIK.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nIK.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nJF) {
                                        VideoControllerLayout.this.nIS.setVisibility(8);
                                        if (VideoControllerLayout.this.nIL != null) {
                                            VideoControllerLayout.this.nIL.dSr();
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
        this.nIL = aVar;
    }

    public void setCurrentTab(int i) {
        this.jxW = i;
        switch (this.jxW) {
            case 1:
                this.nIE.setVisibility(4);
                this.nIH.setVisibility(4);
                this.nIG.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nFZ.getStatus() != 1) {
                    this.nIE.setVisibility(0);
                    this.nIH.setVisibility(0);
                }
                this.nIG.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dSD() {
        return this.nIS.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nIS != null) {
            this.nIS.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nIS != null) {
            this.nIS.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nIS != null) {
            this.nIS.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dSE() {
        if (this.nIS != null) {
            return this.nIS.dSE();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nIM = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nIO;
    }

    public List<e> getChoosedFilterList() {
        return this.nIP;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nIQ;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nIR.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nIS != null) {
            this.nIS.setMusicList(this.nIR);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dSF() {
        if (this.nIS != null) {
            this.nIS.dSF();
        }
    }

    public void dRs() {
        if (this.nIS != null) {
            this.nIS.dRs();
        }
    }
}
