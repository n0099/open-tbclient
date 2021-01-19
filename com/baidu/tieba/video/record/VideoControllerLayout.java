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
    private i nGa;
    private AnimatorSet nHS;
    private AnimatorSet nHT;
    private ImageView nIF;
    private RelativeLayout nIG;
    private VideoRecordButton nIH;
    private ImageView nII;
    private long nIJ;
    private boolean nIK;
    private List<ObjectAnimator> nIL;
    private a nIM;
    private boolean nIN;
    private boolean nIO;
    private List<e> nIP;
    private List<e> nIQ;
    private List<StickerItem> nIR;
    private List<e> nIS;
    private VideoEffectLayout nIT;

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
        this.nIJ = 0L;
        this.nIK = false;
        this.nIN = true;
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.nIS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIJ = 0L;
        this.nIK = false;
        this.nIN = true;
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.nIS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIJ = 0L;
        this.nIK = false;
        this.nIN = true;
        this.nIP = new ArrayList();
        this.nIQ = new ArrayList();
        this.nIR = new ArrayList();
        this.nIS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nIT = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nIG = (RelativeLayout) findViewById(R.id.layout_record);
        this.nIF = (ImageView) findViewById(R.id.delete_video);
        this.nIF.setOnClickListener(this);
        this.nIH = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nIH.setOnTouchListener(this);
        this.nII = (ImageView) findViewById(R.id.confirm_video);
        this.nII.setOnClickListener(this);
        this.nIS.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nIS.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nGa = iVar;
        Kx(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nIT != null) {
            this.nIT.setListener(aVar);
        }
    }

    public void Kx(int i) {
        this.nGa.setStatus(i);
        if (this.nIM != null) {
            this.nIM.dSv();
        }
        if (i == 1) {
            this.nIF.setVisibility(8);
            this.nII.setVisibility(8);
        } else if (i == 3) {
            this.nIF.setImageResource(R.drawable.video_back_selector);
            this.nII.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nIF.setImageResource(R.drawable.video_back_selector);
            this.nII.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nIF.setImageResource(R.drawable.video_delete_selector);
            if (this.nGa != null && this.nGa.getVideoDuration() >= 3000.0f) {
                this.nII.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nII.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nIF) {
            if (this.nIM != null) {
                this.nIM.dSu();
            }
            int status = this.nGa.getStatus();
            if (this.nGa != null && this.nGa.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nGa.dRW();
                    gd(this.nIP);
                    gd(this.nIQ);
                    gd(this.nIR);
                    if (this.nGa.getVideoDuration() >= 3000.0f) {
                        Kx(4);
                        return;
                    } else {
                        Kx(this.nGa.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nGa.dRV();
                Kx(5);
            }
        } else if (view == this.nII) {
            TiebaStatic.log("c12300");
            if (this.nGa != null && this.nGa.getStatus() > 2 && this.nIM != null) {
                if (this.nGa.getVideoDuration() >= 3000.0f) {
                    this.nIM.dSs();
                } else {
                    this.nIM.dSt();
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
        if (this.nGa.getProgress() >= 100) {
            if (this.nIM != null) {
                this.nIM.dSs();
                return;
            }
            return;
        }
        if (this.nIT.getCurrentBeautyItem() != null) {
            this.nIP.add(this.nIT.getCurrentBeautyItem());
        }
        if (this.nIT.getCurrentFilterItem() != null) {
            this.nIQ.add(this.nIT.getCurrentFilterItem());
        }
        if (this.nIT.getCurrentStickItem() != null) {
            this.nIR.add(this.nIT.getCurrentStickItem());
        }
        Kx(2);
        if (this.nIT.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nGa.getStatus() == 6 || VideoControllerLayout.this.nGa.bvp()) {
                        VideoControllerLayout.this.yN(z);
                    }
                }
            });
        } else {
            yN(z);
        }
        if (this.nGa != null) {
            this.nGa.startRecord();
        }
        if (this.nIM != null) {
            this.nIM.dSn();
        }
    }

    public void stopRecord() {
        dSz();
        int status = this.nGa.getStatus();
        if (this.nGa != null) {
            if (!this.nGa.bTy() && this.nGa.bvp()) {
                this.nGa.stopRecord();
            }
            dSy();
        }
        if (this.nIM != null) {
            this.nIM.dSb();
            if (status == 6) {
                this.nIM.dSp();
            }
        }
    }

    public void dSy() {
        if (this.nGa != null) {
            if (this.nGa.getVideoDuration() >= 3000.0f) {
                Kx(4);
            } else if (this.nGa.getVideoDuration() > 0) {
                Kx(3);
            } else {
                Kx(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(boolean z) {
        if (this.nHT != null && this.nHT.isRunning()) {
            this.nHT.cancel();
        }
        if (this.nHS == null) {
            this.nHS = new AnimatorSet();
            this.nHS.playTogether(ObjectAnimator.ofFloat(this.nIF, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nII, "alpha", 1.0f, 0.0f));
            this.nHS.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nJG) {
                        VideoControllerLayout.this.nIF.setVisibility(8);
                        VideoControllerLayout.this.nII.setVisibility(8);
                    }
                }
            });
            this.nHS.setDuration(300L);
        }
        this.nHS.start();
        if (this.nGa.getStatus() != 6) {
            this.nIH.yN(z);
        }
    }

    public void dSz() {
        if (this.nGa == null || this.nGa.bvp() || this.nGa.getStatus() == 6) {
            if (this.nHS != null && this.nHS.isRunning()) {
                this.nHS.cancel();
            }
            if (this.nHT == null) {
                this.nHT = new AnimatorSet();
                this.nHT.playTogether(ObjectAnimator.ofFloat(this.nIF, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nII, "alpha", 0.0f, 1.0f));
                this.nHT.setDuration(300L);
            }
            this.nIF.setVisibility(0);
            this.nII.setVisibility(0);
            this.nHT.start();
            if (this.nGa.getStatus() != 7 && this.nGa.getStatus() != 6) {
                this.nIH.dSz();
                return;
            }
            this.nIH.getTvTip().setVisibility(8);
            if (this.jxW == 2) {
                this.nIH.getLayer1().setVisibility(0);
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
                if (this.nIM != null) {
                    this.nIM.dSu();
                }
                if (this.nGa.getStatus() != 7 && this.nGa.getStatus() != 6) {
                    if (this.nGa != null && this.nGa.dRU()) {
                        this.nIO = true;
                        com.baidu.tbadk.core.util.e.brF().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nIJ = currentTimeMillis;
                    this.nIK = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nIK && VideoControllerLayout.this.nIJ == currentTimeMillis) {
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
                if (this.nIO) {
                    this.nIO = false;
                    return;
                }
                this.nIK = false;
                if (this.nGa.bvp() || this.nGa.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nGa.getStatus() != 8) {
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
                if (this.nGa.getStatus() == 6) {
                    this.nGa.setStatus(1);
                    if (this.nIM != null) {
                        this.nIM.dSp();
                        this.nIM.dSb();
                    }
                    this.nIH.getTvTip().setText("");
                    this.nIH.getTvTip().setVisibility(8);
                    return;
                } else if (this.nIT.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nIM != null) {
                    this.nIM.dSo();
                    this.nIH.dSK();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nIH.dSL();
                return;
            default:
                return;
        }
    }

    public void dSi() {
        if (this.nIT.getVisibility() == 0) {
            a((m) null);
        }
        yN(false);
        this.nIH.getLayer1().setVisibility(8);
        this.nIH.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nIH.getTvTip().setVisibility(0);
        if (this.nIM != null) {
            this.nIM.dSn();
        }
    }

    public void dSA() {
        if (this.nGa.getStatus() == 6) {
            if (this.jxW == 2) {
                Kx(7);
                this.nIH.setAlpha(1.0f);
                this.nIF.setVisibility(8);
                this.nII.setVisibility(8);
                this.nIH.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nGa != null) {
                    this.nGa.startRecord();
                    return;
                }
                return;
            }
            this.nIH.getTvTip().setVisibility(8);
            if (this.nIM != null) {
                this.nIM.dSo();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSj() {
        if (dSD() && this.nIT.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIT.dSj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSk() {
        if (dSD() && this.nIT.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIT.dSk();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSl() {
        if (dSD() && this.nIT.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIT.dSl();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSm() {
        if (dSD() && this.nIT.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dSD()) {
            dSC();
        }
        this.nIT.dSm();
    }

    private void dSB() {
        if (x.isEmpty(this.nIL)) {
            this.nIL = new ArrayList();
            this.nIL.add(ObjectAnimator.ofFloat(this.nIT, "translationY", 1000.0f, 0.0f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIG, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIH.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIH.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIH.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIH.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nII, "scaleX", 1.0f, 0.7f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nII, "scaleY", 1.0f, 0.7f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIF, "scaleX", 1.0f, 0.7f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIF, "scaleY", 1.0f, 0.7f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nII, "alpha", 1.0f, 0.0f));
            this.nIL.add(ObjectAnimator.ofFloat(this.nIF, "alpha", 1.0f, 0.0f));
        }
    }

    private void dSC() {
        int i = 0;
        if (this.nIT.getVisibility() != 0) {
            this.nIT.setVisibility(0);
            dSB();
            this.nII.setEnabled(false);
            this.nIF.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nIL.size()) {
                    ObjectAnimator objectAnimator = this.nIL.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nIL.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nIM != null) {
                                        VideoControllerLayout.this.nIM.dSq();
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
        if (this.nIT.getVisibility() != 8) {
            dSB();
            this.nII.setEnabled(true);
            this.nIF.setEnabled(true);
            if (this.nGa.getStatus() == 6 || this.nGa.bvp()) {
                this.nIF.setVisibility(8);
                this.nII.setVisibility(8);
            } else {
                Kx(this.nGa.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nIL.size()) {
                    ObjectAnimator objectAnimator = this.nIL.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nIL.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nJG) {
                                        VideoControllerLayout.this.nIT.setVisibility(8);
                                        if (VideoControllerLayout.this.nIM != null) {
                                            VideoControllerLayout.this.nIM.dSr();
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
        this.nIM = aVar;
    }

    public void setCurrentTab(int i) {
        this.jxW = i;
        switch (this.jxW) {
            case 1:
                this.nIF.setVisibility(4);
                this.nII.setVisibility(4);
                this.nIH.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nGa.getStatus() != 1) {
                    this.nIF.setVisibility(0);
                    this.nII.setVisibility(0);
                }
                this.nIH.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dSD() {
        return this.nIT.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nIT != null) {
            this.nIT.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nIT != null) {
            this.nIT.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nIT != null) {
            this.nIT.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dSE() {
        if (this.nIT != null) {
            return this.nIT.dSE();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nIN = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nIP;
    }

    public List<e> getChoosedFilterList() {
        return this.nIQ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nIR;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nIS.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nIT != null) {
            this.nIT.setMusicList(this.nIS);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dSF() {
        if (this.nIT != null) {
            this.nIT.dSF();
        }
    }

    public void dRs() {
        if (this.nIT != null) {
            this.nIT.dRs();
        }
    }
}
