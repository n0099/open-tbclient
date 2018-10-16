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
    private int dRd;
    private boolean hAa;
    private List<e> hAb;
    private List<e> hAc;
    private List<StickerItem> hAd;
    private List<e> hAe;
    private VideoEffectLayout hAf;
    private i hxh;
    private ImageView hzR;
    private RelativeLayout hzS;
    private VideoRecordButton hzT;
    private ImageView hzU;
    private long hzV;
    private boolean hzW;
    private List<ObjectAnimator> hzX;
    private a hzY;
    private boolean hzZ;
    private AnimatorSet hzf;
    private AnimatorSet hzg;
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
        this.hzV = 0L;
        this.hzW = false;
        this.hzZ = true;
        this.hAb = new ArrayList();
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hzV = 0L;
        this.hzW = false;
        this.hzZ = true;
        this.hAb = new ArrayList();
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hzV = 0L;
        this.hzW = false;
        this.hzZ = true;
        this.hAb = new ArrayList();
        this.hAc = new ArrayList();
        this.hAd = new ArrayList();
        this.hAe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hAf = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hzS = (RelativeLayout) findViewById(e.g.layout_record);
        this.hzR = (ImageView) findViewById(e.g.delete_video);
        this.hzR.setOnClickListener(this);
        this.hzT = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hzT.setOnTouchListener(this);
        this.hzU = (ImageView) findViewById(e.g.confirm_video);
        this.hzU.setOnClickListener(this);
        this.hAe.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hAe.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hxh = iVar;
        vR(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hAf != null) {
            this.hAf.setListener(aVar);
        }
    }

    public void vR(int i) {
        this.hxh.setStatus(i);
        if (this.hzY != null) {
            this.hzY.bJp();
        }
        if (i == 1) {
            this.hzR.setVisibility(8);
            this.hzU.setVisibility(8);
        } else if (i == 3) {
            this.hzR.setImageResource(e.f.video_back_selector);
            this.hzU.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hzR.setImageResource(e.f.video_back_selector);
            this.hzU.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hzR.setImageResource(e.f.video_delete_selector);
            if (this.hxh != null && this.hxh.getVideoDuration() >= 3000.0f) {
                this.hzU.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hzU.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hzR) {
            if (this.hzY != null) {
                this.hzY.bJo();
            }
            int status = this.hxh.getStatus();
            if (this.hxh != null && this.hxh.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hxh.bIP();
                    ea(this.hAb);
                    ea(this.hAc);
                    ea(this.hAd);
                    if (this.hxh.getVideoDuration() >= 3000.0f) {
                        vR(4);
                        return;
                    } else {
                        vR(this.hxh.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hxh.bIO();
                vR(5);
            }
        } else if (view == this.hzU) {
            TiebaStatic.log("c12300");
            if (this.hxh != null && this.hxh.getStatus() > 2 && this.hzY != null) {
                if (this.hxh.getVideoDuration() >= 3000.0f) {
                    this.hzY.bJm();
                } else {
                    this.hzY.bJn();
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
        if (this.hxh.getProgress() >= 100) {
            if (this.hzY != null) {
                this.hzY.bJm();
                return;
            }
            return;
        }
        if (this.hAf.getCurrentBeautyItem() != null) {
            this.hAb.add(this.hAf.getCurrentBeautyItem());
        }
        if (this.hAf.getCurrentFilterItem() != null) {
            this.hAc.add(this.hAf.getCurrentFilterItem());
        }
        if (this.hAf.getCurrentStickItem() != null) {
            this.hAd.add(this.hAf.getCurrentStickItem());
        }
        vR(2);
        if (this.hAf.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hxh.getStatus() == 6 || VideoControllerLayout.this.hxh.isRecording()) {
                        VideoControllerLayout.this.nQ(z);
                    }
                }
            });
        } else {
            nQ(z);
        }
        if (this.hxh != null) {
            this.hxh.startRecord();
        }
        if (this.hzY != null) {
            this.hzY.bJh();
        }
    }

    public void stopRecord() {
        bJt();
        int status = this.hxh.getStatus();
        if (this.hxh != null) {
            if (!this.hxh.bIQ() && this.hxh.isRecording()) {
                this.hxh.stopRecord();
            }
            bJs();
        }
        if (this.hzY != null) {
            this.hzY.bIW();
            if (status == 6) {
                this.hzY.bJj();
            }
        }
    }

    public void bJs() {
        if (this.hxh != null) {
            if (this.hxh.getVideoDuration() >= 3000.0f) {
                vR(4);
            } else if (this.hxh.getVideoDuration() > 0) {
                vR(3);
            } else {
                vR(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(boolean z) {
        if (this.hzg != null && this.hzg.isRunning()) {
            this.hzg.cancel();
        }
        if (this.hzf == null) {
            this.hzf = new AnimatorSet();
            this.hzf.playTogether(ObjectAnimator.ofFloat(this.hzR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hzU, "alpha", 1.0f, 0.0f));
            this.hzf.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAT) {
                        VideoControllerLayout.this.hzR.setVisibility(8);
                        VideoControllerLayout.this.hzU.setVisibility(8);
                    }
                }
            });
            this.hzf.setDuration(300L);
        }
        this.hzf.start();
        if (this.hxh.getStatus() != 6) {
            this.hzT.nQ(z);
        }
    }

    public void bJt() {
        if (this.hxh == null || this.hxh.isRecording() || this.hxh.getStatus() == 6) {
            if (this.hzf != null && this.hzf.isRunning()) {
                this.hzf.cancel();
            }
            if (this.hzg == null) {
                this.hzg = new AnimatorSet();
                this.hzg.playTogether(ObjectAnimator.ofFloat(this.hzR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hzU, "alpha", 0.0f, 1.0f));
                this.hzg.setDuration(300L);
            }
            this.hzR.setVisibility(0);
            this.hzU.setVisibility(0);
            this.hzg.start();
            if (this.hxh.getStatus() != 7 && this.hxh.getStatus() != 6) {
                this.hzT.bJt();
                return;
            }
            this.hzT.getTvTip().setVisibility(8);
            if (this.dRd == 2) {
                this.hzT.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dRd) {
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
                if (this.hzY != null) {
                    this.hzY.bJo();
                }
                if (this.hxh.getStatus() != 7 && this.hxh.getStatus() != 6) {
                    if (this.hxh != null && this.hxh.bIN()) {
                        this.hAa = true;
                        com.baidu.tbadk.core.util.e.Bs().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hzV = currentTimeMillis;
                    this.hzW = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hzW && VideoControllerLayout.this.hzV == currentTimeMillis) {
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
                if (this.hAa) {
                    this.hAa = false;
                    return;
                }
                this.hzW = false;
                if (this.hxh.isRecording() || this.hxh.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hxh.getStatus() != 8) {
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
                if (this.hxh.getStatus() == 6) {
                    this.hxh.setStatus(1);
                    if (this.hzY != null) {
                        this.hzY.bJj();
                        this.hzY.bIW();
                    }
                    this.hzT.getTvTip().setText("");
                    this.hzT.getTvTip().setVisibility(8);
                    return;
                } else if (this.hAf.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hzY != null) {
                    this.hzY.bJi();
                    this.hzT.bJE();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hzT.bJF();
                return;
            default:
                return;
        }
    }

    public void bJc() {
        if (this.hAf.getVisibility() == 0) {
            a((m) null);
        }
        nQ(false);
        this.hzT.getLayer1().setVisibility(8);
        this.hzT.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hzT.getTvTip().setVisibility(0);
        if (this.hzY != null) {
            this.hzY.bJh();
        }
    }

    public void bJu() {
        if (this.hxh.getStatus() == 6) {
            if (this.dRd == 2) {
                vR(7);
                this.hzT.setAlpha(1.0f);
                this.hzR.setVisibility(8);
                this.hzU.setVisibility(8);
                this.hzT.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hxh != null) {
                    this.hxh.startRecord();
                    return;
                }
                return;
            }
            this.hzT.getTvTip().setVisibility(8);
            if (this.hzY != null) {
                this.hzY.bJi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJd() {
        if (bJx() && this.hAf.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAf.bJd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJe() {
        if (bJx() && this.hAf.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAf.bJe();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJf() {
        if (bJx() && this.hAf.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAf.bJf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJg() {
        if (bJx() && this.hAf.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bJx()) {
            bJw();
        }
        this.hAf.bJg();
    }

    private void bJv() {
        if (v.J(this.hzX)) {
            this.hzX = new ArrayList();
            this.hzX.add(ObjectAnimator.ofFloat(this.hAf, "translationY", 1000.0f, 0.0f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzS, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds100)));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzT.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzT.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzT.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzT.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzU, "scaleX", 1.0f, 0.7f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzU, "scaleY", 1.0f, 0.7f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzR, "scaleX", 1.0f, 0.7f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzR, "scaleY", 1.0f, 0.7f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzU, "alpha", 1.0f, 0.0f));
            this.hzX.add(ObjectAnimator.ofFloat(this.hzR, "alpha", 1.0f, 0.0f));
        }
    }

    private void bJw() {
        int i = 0;
        if (this.hAf.getVisibility() != 0) {
            this.hAf.setVisibility(0);
            bJv();
            this.hzU.setEnabled(false);
            this.hzR.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hzX.size()) {
                    ObjectAnimator objectAnimator = this.hzX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hzX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hzY != null) {
                                        VideoControllerLayout.this.hzY.bJk();
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
        if (this.hAf.getVisibility() != 8) {
            bJv();
            this.hzU.setEnabled(true);
            this.hzR.setEnabled(true);
            if (this.hxh.getStatus() == 6 || this.hxh.isRecording()) {
                this.hzR.setVisibility(8);
                this.hzU.setVisibility(8);
            } else {
                vR(this.hxh.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hzX.size()) {
                    ObjectAnimator objectAnimator = this.hzX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hzX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hAT) {
                                        VideoControllerLayout.this.hAf.setVisibility(8);
                                        if (VideoControllerLayout.this.hzY != null) {
                                            VideoControllerLayout.this.hzY.bJl();
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
        this.hzY = aVar;
    }

    public void setCurrentTab(int i) {
        this.dRd = i;
        switch (this.dRd) {
            case 1:
                this.hzR.setVisibility(4);
                this.hzU.setVisibility(4);
                this.hzT.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hxh.getStatus() != 1) {
                    this.hzR.setVisibility(0);
                    this.hzU.setVisibility(0);
                }
                this.hzT.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bJx() {
        return this.hAf.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hAf != null) {
            this.hAf.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hAf != null) {
            this.hAf.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hAf != null) {
            this.hAf.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bJy() {
        if (this.hAf != null) {
            return this.hAf.bJy();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hzZ = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hAb;
    }

    public List<e> getChoosedFilterList() {
        return this.hAc;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hAd;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hAe.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hAf != null) {
            this.hAf.setMusicList(this.hAe);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bJz() {
        if (this.hAf != null) {
            this.hAf.bJz();
        }
    }

    public void bIn() {
        if (this.hAf != null) {
            this.hAf.bIn();
        }
    }
}
