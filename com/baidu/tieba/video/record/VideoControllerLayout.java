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
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dRe;
    private boolean hAa;
    private boolean hAb;
    private List<e> hAc;
    private List<e> hAd;
    private List<StickerItem> hAe;
    private List<e> hAf;
    private VideoEffectLayout hAg;
    private i hxi;
    private ImageView hzS;
    private RelativeLayout hzT;
    private VideoRecordButton hzU;
    private ImageView hzV;
    private long hzW;
    private boolean hzX;
    private List<ObjectAnimator> hzY;
    private a hzZ;
    private AnimatorSet hzg;
    private AnimatorSet hzh;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void bIW();

        void bJh();

        void bJi();

        void bJj();

        void bJk();

        void bJl();

        void bJm();

        void bJn();

        void bJo();

        void bJp();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hzW = 0L;
        this.hzX = false;
        this.hAa = true;
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.hAf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzW = 0L;
        this.hzX = false;
        this.hAa = true;
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.hAf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hzW = 0L;
        this.hzX = false;
        this.hAa = true;
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.hAf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hAg = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hzT = (RelativeLayout) findViewById(e.g.layout_record);
        this.hzS = (ImageView) findViewById(e.g.delete_video);
        this.hzS.setOnClickListener(this);
        this.hzU = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hzU.setOnTouchListener(this);
        this.hzV = (ImageView) findViewById(e.g.confirm_video);
        this.hzV.setOnClickListener(this);
        this.hAf.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hAf.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hxi = iVar;
        vR(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hAg != null) {
            this.hAg.setListener(aVar);
        }
    }

    public void vR(int i) {
        this.hxi.setStatus(i);
        if (this.hzZ != null) {
            this.hzZ.bJp();
        }
        if (i == 1) {
            this.hzS.setVisibility(8);
            this.hzV.setVisibility(8);
        } else if (i == 3) {
            this.hzS.setImageResource(e.f.video_back_selector);
            this.hzV.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hzS.setImageResource(e.f.video_back_selector);
            this.hzV.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hzS.setImageResource(e.f.video_delete_selector);
            if (this.hxi != null && this.hxi.getVideoDuration() >= 3000.0f) {
                this.hzV.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hzV.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hzS) {
            if (this.hzZ != null) {
                this.hzZ.bJo();
            }
            int status = this.hxi.getStatus();
            if (this.hxi != null && this.hxi.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hxi.bIP();
                    ea(this.hAc);
                    ea(this.hAd);
                    ea(this.hAe);
                    if (this.hxi.getVideoDuration() >= 3000.0f) {
                        vR(4);
                        return;
                    } else {
                        vR(this.hxi.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hxi.bIO();
                vR(5);
            }
        } else if (view == this.hzV) {
            TiebaStatic.log("c12300");
            if (this.hxi != null && this.hxi.getStatus() > 2 && this.hzZ != null) {
                if (this.hxi.getVideoDuration() >= 3000.0f) {
                    this.hzZ.bJm();
                } else {
                    this.hzZ.bJn();
                }
            }
        }
    }

    private void ea(List list) {
        if (!v.J(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final boolean z) {
        if (this.hxi.getProgress() >= 100) {
            if (this.hzZ != null) {
                this.hzZ.bJm();
                return;
            }
            return;
        }
        if (this.hAg.getCurrentBeautyItem() != null) {
            this.hAc.add(this.hAg.getCurrentBeautyItem());
        }
        if (this.hAg.getCurrentFilterItem() != null) {
            this.hAd.add(this.hAg.getCurrentFilterItem());
        }
        if (this.hAg.getCurrentStickItem() != null) {
            this.hAe.add(this.hAg.getCurrentStickItem());
        }
        vR(2);
        if (this.hAg.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hxi.getStatus() == 6 || VideoControllerLayout.this.hxi.isRecording()) {
                        VideoControllerLayout.this.nQ(z);
                    }
                }
            });
        } else {
            nQ(z);
        }
        if (this.hxi != null) {
            this.hxi.startRecord();
        }
        if (this.hzZ != null) {
            this.hzZ.bJh();
        }
    }

    public void stopRecord() {
        bJt();
        int status = this.hxi.getStatus();
        if (this.hxi != null) {
            if (!this.hxi.bIQ() && this.hxi.isRecording()) {
                this.hxi.stopRecord();
            }
            bJs();
        }
        if (this.hzZ != null) {
            this.hzZ.bIW();
            if (status == 6) {
                this.hzZ.bJj();
            }
        }
    }

    public void bJs() {
        if (this.hxi != null) {
            if (this.hxi.getVideoDuration() >= 3000.0f) {
                vR(4);
            } else if (this.hxi.getVideoDuration() > 0) {
                vR(3);
            } else {
                vR(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(boolean z) {
        if (this.hzh != null && this.hzh.isRunning()) {
            this.hzh.cancel();
        }
        if (this.hzg == null) {
            this.hzg = new AnimatorSet();
            this.hzg.playTogether(ObjectAnimator.ofFloat(this.hzS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hzV, "alpha", 1.0f, 0.0f));
            this.hzg.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAU) {
                        VideoControllerLayout.this.hzS.setVisibility(8);
                        VideoControllerLayout.this.hzV.setVisibility(8);
                    }
                }
            });
            this.hzg.setDuration(300L);
        }
        this.hzg.start();
        if (this.hxi.getStatus() != 6) {
            this.hzU.nQ(z);
        }
    }

    public void bJt() {
        if (this.hxi == null || this.hxi.isRecording() || this.hxi.getStatus() == 6) {
            if (this.hzg != null && this.hzg.isRunning()) {
                this.hzg.cancel();
            }
            if (this.hzh == null) {
                this.hzh = new AnimatorSet();
                this.hzh.playTogether(ObjectAnimator.ofFloat(this.hzS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hzV, "alpha", 0.0f, 1.0f));
                this.hzh.setDuration(300L);
            }
            this.hzS.setVisibility(0);
            this.hzV.setVisibility(0);
            this.hzh.start();
            if (this.hxi.getStatus() != 7 && this.hxi.getStatus() != 6) {
                this.hzU.bJt();
                return;
            }
            this.hzU.getTvTip().setVisibility(8);
            if (this.dRe == 2) {
                this.hzU.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dRe) {
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
                if (this.hzZ != null) {
                    this.hzZ.bJo();
                }
                if (this.hxi.getStatus() != 7 && this.hxi.getStatus() != 6) {
                    if (this.hxi != null && this.hxi.bIN()) {
                        this.hAb = true;
                        com.baidu.tbadk.core.util.e.Bs().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hzW = currentTimeMillis;
                    this.hzX = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hzX && VideoControllerLayout.this.hzW == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.startRecord(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hAb) {
                    this.hAb = false;
                    return;
                }
                this.hzX = false;
                if (this.hxi.isRecording() || this.hxi.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hxi.getStatus() != 8) {
                    startRecord(false);
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
                if (this.hxi.getStatus() == 6) {
                    this.hxi.setStatus(1);
                    if (this.hzZ != null) {
                        this.hzZ.bJj();
                        this.hzZ.bIW();
                    }
                    this.hzU.getTvTip().setText("");
                    this.hzU.getTvTip().setVisibility(8);
                    return;
                } else if (this.hAg.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hzZ != null) {
                    this.hzZ.bJi();
                    this.hzU.bJE();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hzU.bJF();
                return;
            default:
                return;
        }
    }

    public void bJc() {
        if (this.hAg.getVisibility() == 0) {
            a((m) null);
        }
        nQ(false);
        this.hzU.getLayer1().setVisibility(8);
        this.hzU.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hzU.getTvTip().setVisibility(0);
        if (this.hzZ != null) {
            this.hzZ.bJh();
        }
    }

    public void bJu() {
        if (this.hxi.getStatus() == 6) {
            if (this.dRe == 2) {
                vR(7);
                this.hzU.setAlpha(1.0f);
                this.hzS.setVisibility(8);
                this.hzV.setVisibility(8);
                this.hzU.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hxi != null) {
                    this.hxi.startRecord();
                    return;
                }
                return;
            }
            this.hzU.getTvTip().setVisibility(8);
            if (this.hzZ != null) {
                this.hzZ.bJi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJd() {
        if (bJx() && this.hAg.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAg.bJd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJe() {
        if (bJx() && this.hAg.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAg.bJe();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJf() {
        if (bJx() && this.hAg.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAg.bJf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJg() {
        if (bJx() && this.hAg.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAg.bJg();
    }

    private void bJv() {
        if (v.J(this.hzY)) {
            this.hzY = new ArrayList();
            this.hzY.add(ObjectAnimator.ofFloat(this.hAg, "translationY", 1000.0f, 0.0f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzT, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds100)));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzU.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzU.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzU.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzU.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzV, "scaleX", 1.0f, 0.7f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzV, "scaleY", 1.0f, 0.7f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzS, "scaleX", 1.0f, 0.7f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzS, "scaleY", 1.0f, 0.7f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzV, "alpha", 1.0f, 0.0f));
            this.hzY.add(ObjectAnimator.ofFloat(this.hzS, "alpha", 1.0f, 0.0f));
        }
    }

    private void bJw() {
        int i = 0;
        if (this.hAg.getVisibility() != 0) {
            this.hAg.setVisibility(0);
            bJv();
            this.hzV.setEnabled(false);
            this.hzS.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hzY.size()) {
                    ObjectAnimator objectAnimator = this.hzY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hzY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hzZ != null) {
                                        VideoControllerLayout.this.hzZ.bJk();
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
        if (this.hAg.getVisibility() != 8) {
            bJv();
            this.hzV.setEnabled(true);
            this.hzS.setEnabled(true);
            if (this.hxi.getStatus() == 6 || this.hxi.isRecording()) {
                this.hzS.setVisibility(8);
                this.hzV.setVisibility(8);
            } else {
                vR(this.hxi.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hzY.size()) {
                    ObjectAnimator objectAnimator = this.hzY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hzY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hAU) {
                                        VideoControllerLayout.this.hAg.setVisibility(8);
                                        if (VideoControllerLayout.this.hzZ != null) {
                                            VideoControllerLayout.this.hzZ.bJl();
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
        this.hzZ = aVar;
    }

    public void setCurrentTab(int i) {
        this.dRe = i;
        switch (this.dRe) {
            case 1:
                this.hzS.setVisibility(4);
                this.hzV.setVisibility(4);
                this.hzU.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hxi.getStatus() != 1) {
                    this.hzS.setVisibility(0);
                    this.hzV.setVisibility(0);
                }
                this.hzU.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bJx() {
        return this.hAg.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hAg != null) {
            this.hAg.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hAg != null) {
            this.hAg.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hAg != null) {
            this.hAg.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bJy() {
        if (this.hAg != null) {
            return this.hAg.bJy();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hAa = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hAc;
    }

    public List<e> getChoosedFilterList() {
        return this.hAd;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hAe;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hAf.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hAg != null) {
            this.hAg.setMusicList(this.hAf);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bJz() {
        if (this.hAg != null) {
            this.hAg.bJz();
        }
    }

    public void bIn() {
        if (this.hAg != null) {
            this.hAg.bIn();
        }
    }
}
