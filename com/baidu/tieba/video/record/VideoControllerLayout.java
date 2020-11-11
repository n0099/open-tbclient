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
    private int jbO;
    private Handler mHandler;
    private i nsd;
    private AnimatorSet ntT;
    private AnimatorSet ntU;
    private ImageView nuF;
    private RelativeLayout nuG;
    private VideoRecordButton nuH;
    private ImageView nuI;
    private long nuJ;
    private boolean nuK;
    private List<ObjectAnimator> nuL;
    private a nuM;
    private boolean nuN;
    private boolean nuO;
    private List<e> nuP;
    private List<e> nuQ;
    private List<StickerItem> nuR;
    private List<e> nuS;
    private VideoEffectLayout nuT;

    /* loaded from: classes23.dex */
    public interface a {
        void dQW();

        void dRh();

        void dRi();

        void dRj();

        void dRk();

        void dRl();

        void dRm();

        void dRn();

        void dRo();

        void dRp();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nuJ = 0L;
        this.nuK = false;
        this.nuN = true;
        this.nuP = new ArrayList();
        this.nuQ = new ArrayList();
        this.nuR = new ArrayList();
        this.nuS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nuJ = 0L;
        this.nuK = false;
        this.nuN = true;
        this.nuP = new ArrayList();
        this.nuQ = new ArrayList();
        this.nuR = new ArrayList();
        this.nuS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nuJ = 0L;
        this.nuK = false;
        this.nuN = true;
        this.nuP = new ArrayList();
        this.nuQ = new ArrayList();
        this.nuR = new ArrayList();
        this.nuS = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nuT = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nuG = (RelativeLayout) findViewById(R.id.layout_record);
        this.nuF = (ImageView) findViewById(R.id.delete_video);
        this.nuF.setOnClickListener(this);
        this.nuH = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nuH.setOnTouchListener(this);
        this.nuI = (ImageView) findViewById(R.id.confirm_video);
        this.nuI.setOnClickListener(this);
        this.nuS.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nuS.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nsd = iVar;
        KW(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nuT != null) {
            this.nuT.setListener(aVar);
        }
    }

    public void KW(int i) {
        this.nsd.setStatus(i);
        if (this.nuM != null) {
            this.nuM.dRp();
        }
        if (i == 1) {
            this.nuF.setVisibility(8);
            this.nuI.setVisibility(8);
        } else if (i == 3) {
            this.nuF.setImageResource(R.drawable.video_back_selector);
            this.nuI.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nuF.setImageResource(R.drawable.video_back_selector);
            this.nuI.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nuF.setImageResource(R.drawable.video_delete_selector);
            if (this.nsd != null && this.nsd.getVideoDuration() >= 3000.0f) {
                this.nuI.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nuI.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nuF) {
            if (this.nuM != null) {
                this.nuM.dRo();
            }
            int status = this.nsd.getStatus();
            if (this.nsd != null && this.nsd.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nsd.dQR();
                    fV(this.nuP);
                    fV(this.nuQ);
                    fV(this.nuR);
                    if (this.nsd.getVideoDuration() >= 3000.0f) {
                        KW(4);
                        return;
                    } else {
                        KW(this.nsd.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nsd.dQQ();
                KW(5);
            }
        } else if (view == this.nuI) {
            TiebaStatic.log("c12300");
            if (this.nsd != null && this.nsd.getStatus() > 2 && this.nuM != null) {
                if (this.nsd.getVideoDuration() >= 3000.0f) {
                    this.nuM.dRm();
                } else {
                    this.nuM.dRn();
                }
            }
        }
    }

    private void fV(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(final boolean z) {
        if (this.nsd.getProgress() >= 100) {
            if (this.nuM != null) {
                this.nuM.dRm();
                return;
            }
            return;
        }
        if (this.nuT.getCurrentBeautyItem() != null) {
            this.nuP.add(this.nuT.getCurrentBeautyItem());
        }
        if (this.nuT.getCurrentFilterItem() != null) {
            this.nuQ.add(this.nuT.getCurrentFilterItem());
        }
        if (this.nuT.getCurrentStickItem() != null) {
            this.nuR.add(this.nuT.getCurrentStickItem());
        }
        KW(2);
        if (this.nuT.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nsd.getStatus() == 6 || VideoControllerLayout.this.nsd.btZ()) {
                        VideoControllerLayout.this.yf(z);
                    }
                }
            });
        } else {
            yf(z);
        }
        if (this.nsd != null) {
            this.nsd.startRecord();
        }
        if (this.nuM != null) {
            this.nuM.dRh();
        }
    }

    public void stopRecord() {
        dRt();
        int status = this.nsd.getStatus();
        if (this.nsd != null) {
            if (!this.nsd.bRH() && this.nsd.btZ()) {
                this.nsd.stopRecord();
            }
            dRs();
        }
        if (this.nuM != null) {
            this.nuM.dQW();
            if (status == 6) {
                this.nuM.dRj();
            }
        }
    }

    public void dRs() {
        if (this.nsd != null) {
            if (this.nsd.getVideoDuration() >= 3000.0f) {
                KW(4);
            } else if (this.nsd.getVideoDuration() > 0) {
                KW(3);
            } else {
                KW(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf(boolean z) {
        if (this.ntU != null && this.ntU.isRunning()) {
            this.ntU.cancel();
        }
        if (this.ntT == null) {
            this.ntT = new AnimatorSet();
            this.ntT.playTogether(ObjectAnimator.ofFloat(this.nuF, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nuI, "alpha", 1.0f, 0.0f));
            this.ntT.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nvG) {
                        VideoControllerLayout.this.nuF.setVisibility(8);
                        VideoControllerLayout.this.nuI.setVisibility(8);
                    }
                }
            });
            this.ntT.setDuration(300L);
        }
        this.ntT.start();
        if (this.nsd.getStatus() != 6) {
            this.nuH.yf(z);
        }
    }

    public void dRt() {
        if (this.nsd == null || this.nsd.btZ() || this.nsd.getStatus() == 6) {
            if (this.ntT != null && this.ntT.isRunning()) {
                this.ntT.cancel();
            }
            if (this.ntU == null) {
                this.ntU = new AnimatorSet();
                this.ntU.playTogether(ObjectAnimator.ofFloat(this.nuF, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nuI, "alpha", 0.0f, 1.0f));
                this.ntU.setDuration(300L);
            }
            this.nuF.setVisibility(0);
            this.nuI.setVisibility(0);
            this.ntU.start();
            if (this.nsd.getStatus() != 7 && this.nsd.getStatus() != 6) {
                this.nuH.dRt();
                return;
            }
            this.nuH.getTvTip().setVisibility(8);
            if (this.jbO == 2) {
                this.nuH.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jbO) {
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
                if (this.nuM != null) {
                    this.nuM.dRo();
                }
                if (this.nsd.getStatus() != 7 && this.nsd.getStatus() != 6) {
                    if (this.nsd != null && this.nsd.dQP()) {
                        this.nuO = true;
                        com.baidu.tbadk.core.util.e.bqp().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nuJ = currentTimeMillis;
                    this.nuK = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nuK && VideoControllerLayout.this.nuJ == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.fF(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nuO) {
                    this.nuO = false;
                    return;
                }
                this.nuK = false;
                if (this.nsd.btZ() || this.nsd.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nsd.getStatus() != 8) {
                    fF(false);
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
                if (this.nsd.getStatus() == 6) {
                    this.nsd.setStatus(1);
                    if (this.nuM != null) {
                        this.nuM.dRj();
                        this.nuM.dQW();
                    }
                    this.nuH.getTvTip().setText("");
                    this.nuH.getTvTip().setVisibility(8);
                    return;
                } else if (this.nuT.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nuM != null) {
                    this.nuM.dRi();
                    this.nuH.dRE();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nuH.dRF();
                return;
            default:
                return;
        }
    }

    public void dRc() {
        if (this.nuT.getVisibility() == 0) {
            a((m) null);
        }
        yf(false);
        this.nuH.getLayer1().setVisibility(8);
        this.nuH.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nuH.getTvTip().setVisibility(0);
        if (this.nuM != null) {
            this.nuM.dRh();
        }
    }

    public void dRu() {
        if (this.nsd.getStatus() == 6) {
            if (this.jbO == 2) {
                KW(7);
                this.nuH.setAlpha(1.0f);
                this.nuF.setVisibility(8);
                this.nuI.setVisibility(8);
                this.nuH.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nsd != null) {
                    this.nsd.startRecord();
                    return;
                }
                return;
            }
            this.nuH.getTvTip().setVisibility(8);
            if (this.nuM != null) {
                this.nuM.dRi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRd() {
        if (dRx() && this.nuT.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dRx()) {
            dRw();
        }
        this.nuT.dRd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRe() {
        if (dRx() && this.nuT.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dRx()) {
            dRw();
        }
        this.nuT.dRe();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRf() {
        if (dRx() && this.nuT.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dRx()) {
            dRw();
        }
        this.nuT.dRf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRg() {
        if (dRx() && this.nuT.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dRx()) {
            dRw();
        }
        this.nuT.dRg();
    }

    private void dRv() {
        if (y.isEmpty(this.nuL)) {
            this.nuL = new ArrayList();
            this.nuL.add(ObjectAnimator.ofFloat(this.nuT, "translationY", 1000.0f, 0.0f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuG, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuH.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuH.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuH.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuH.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuI, "scaleX", 1.0f, 0.7f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuI, "scaleY", 1.0f, 0.7f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuF, "scaleX", 1.0f, 0.7f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuF, "scaleY", 1.0f, 0.7f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuI, "alpha", 1.0f, 0.0f));
            this.nuL.add(ObjectAnimator.ofFloat(this.nuF, "alpha", 1.0f, 0.0f));
        }
    }

    private void dRw() {
        int i = 0;
        if (this.nuT.getVisibility() != 0) {
            this.nuT.setVisibility(0);
            dRv();
            this.nuI.setEnabled(false);
            this.nuF.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nuL.size()) {
                    ObjectAnimator objectAnimator = this.nuL.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nuL.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nuM != null) {
                                        VideoControllerLayout.this.nuM.dRk();
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
        if (this.nuT.getVisibility() != 8) {
            dRv();
            this.nuI.setEnabled(true);
            this.nuF.setEnabled(true);
            if (this.nsd.getStatus() == 6 || this.nsd.btZ()) {
                this.nuF.setVisibility(8);
                this.nuI.setVisibility(8);
            } else {
                KW(this.nsd.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nuL.size()) {
                    ObjectAnimator objectAnimator = this.nuL.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nuL.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nvG) {
                                        VideoControllerLayout.this.nuT.setVisibility(8);
                                        if (VideoControllerLayout.this.nuM != null) {
                                            VideoControllerLayout.this.nuM.dRl();
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
        this.nuM = aVar;
    }

    public void setCurrentTab(int i) {
        this.jbO = i;
        switch (this.jbO) {
            case 1:
                this.nuF.setVisibility(4);
                this.nuI.setVisibility(4);
                this.nuH.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nsd.getStatus() != 1) {
                    this.nuF.setVisibility(0);
                    this.nuI.setVisibility(0);
                }
                this.nuH.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dRx() {
        return this.nuT.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nuT != null) {
            this.nuT.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nuT != null) {
            this.nuT.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nuT != null) {
            this.nuT.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dRy() {
        if (this.nuT != null) {
            return this.nuT.dRy();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nuN = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nuP;
    }

    public List<e> getChoosedFilterList() {
        return this.nuQ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nuR;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nuS.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nuT != null) {
            this.nuT.setMusicList(this.nuS);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void dRz() {
        if (this.nuT != null) {
            this.nuT.dRz();
        }
    }

    public void dQn() {
        if (this.nuT != null) {
            this.nuT.dQn();
        }
    }
}
