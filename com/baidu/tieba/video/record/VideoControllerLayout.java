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
    private int dJY;
    private j hDA;
    private AnimatorSet hFB;
    private AnimatorSet hFC;
    private List<e> hGA;
    private VideoEffectLayout hGB;
    private ImageView hGn;
    private RelativeLayout hGo;
    private VideoRecordButton hGp;
    private ImageView hGq;
    private long hGr;
    private boolean hGs;
    private List<ObjectAnimator> hGt;
    private a hGu;
    private boolean hGv;
    private boolean hGw;
    private List<e> hGx;
    private List<e> hGy;
    private List<StickerItem> hGz;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bJA();

        void bJK();

        void bJL();

        void bJM();

        void bJN();

        void bJO();

        void bJP();

        void bJQ();

        void bJR();

        void bJz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hGr = 0L;
        this.hGs = false;
        this.hGv = true;
        this.hGx = new ArrayList();
        this.hGy = new ArrayList();
        this.hGz = new ArrayList();
        this.hGA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hGr = 0L;
        this.hGs = false;
        this.hGv = true;
        this.hGx = new ArrayList();
        this.hGy = new ArrayList();
        this.hGz = new ArrayList();
        this.hGA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hGr = 0L;
        this.hGs = false;
        this.hGv = true;
        this.hGx = new ArrayList();
        this.hGy = new ArrayList();
        this.hGz = new ArrayList();
        this.hGA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hGB = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hGo = (RelativeLayout) findViewById(d.g.layout_record);
        this.hGn = (ImageView) findViewById(d.g.delete_video);
        this.hGn.setOnClickListener(this);
        this.hGp = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hGp.setOnTouchListener(this);
        this.hGq = (ImageView) findViewById(d.g.confirm_video);
        this.hGq.setOnClickListener(this);
        this.hGA.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hGA.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.hDA = jVar;
        yx(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hGB != null) {
            this.hGB.setListener(aVar);
        }
    }

    public void yx(int i) {
        this.hDA.setStatus(i);
        if (this.hGu != null) {
            this.hGu.bJR();
        }
        if (i == 1) {
            this.hGn.setVisibility(8);
            this.hGq.setVisibility(8);
        } else if (i == 3) {
            this.hGn.setImageResource(d.f.video_back_selector);
            this.hGq.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hGn.setImageResource(d.f.video_back_selector);
            this.hGq.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hGn.setImageResource(d.f.video_delete_selector);
            if (this.hDA != null && this.hDA.getVideoDuration() >= 3000.0f) {
                this.hGq.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hGq.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hGn) {
            if (this.hGu != null) {
                this.hGu.bJQ();
            }
            int status = this.hDA.getStatus();
            if (this.hDA != null && this.hDA.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hDA.bJt();
                    dY(this.hGx);
                    dY(this.hGy);
                    dY(this.hGz);
                    if (this.hDA.getVideoDuration() >= 3000.0f) {
                        yx(4);
                        return;
                    } else {
                        yx(this.hDA.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hDA.bJs();
                yx(5);
            }
        } else if (view == this.hGq) {
            TiebaStatic.log("c12300");
            if (this.hDA != null && this.hDA.getStatus() > 2 && this.hGu != null) {
                if (this.hDA.getVideoDuration() >= 3000.0f) {
                    this.hGu.bJA();
                } else {
                    this.hGu.bJP();
                }
            }
        }
    }

    private void dY(List list) {
        if (!v.G(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(final boolean z) {
        if (this.hDA.getProgress() >= 100) {
            if (this.hGu != null) {
                this.hGu.bJA();
                return;
            }
            return;
        }
        if (this.hGB.getCurrentBeautyItem() != null) {
            this.hGx.add(this.hGB.getCurrentBeautyItem());
        }
        if (this.hGB.getCurrentFilterItem() != null) {
            this.hGy.add(this.hGB.getCurrentFilterItem());
        }
        if (this.hGB.getCurrentStickItem() != null) {
            this.hGz.add(this.hGB.getCurrentStickItem());
        }
        yx(2);
        if (this.hGB.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hDA.getStatus() == 6 || VideoControllerLayout.this.hDA.isRecording()) {
                        VideoControllerLayout.this.oh(z);
                    }
                }
            });
        } else {
            oh(z);
        }
        if (this.hDA != null) {
            this.hDA.startRecord();
        }
        if (this.hGu != null) {
            this.hGu.bJK();
        }
    }

    public void stopRecord() {
        bJW();
        int status = this.hDA.getStatus();
        if (this.hDA != null) {
            if (this.hDA.getStatus() != 6 && this.hDA.isRecording()) {
                this.hDA.stopRecord();
            }
            if (this.hDA.getVideoDuration() >= 3000.0f) {
                yx(4);
            } else if (this.hDA.getVideoDuration() > 0) {
                yx(3);
            } else {
                yx(1);
            }
        }
        if (this.hGu != null) {
            this.hGu.bJz();
            if (status == 6) {
                this.hGu.bJM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        if (this.hFC != null && this.hFC.isRunning()) {
            this.hFC.cancel();
        }
        if (this.hFB == null) {
            this.hFB = new AnimatorSet();
            this.hFB.playTogether(ObjectAnimator.ofFloat(this.hGn, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hGq, "alpha", 1.0f, 0.0f));
            this.hFB.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hHq) {
                        VideoControllerLayout.this.hGn.setVisibility(8);
                        VideoControllerLayout.this.hGq.setVisibility(8);
                    }
                }
            });
            this.hFB.setDuration(300L);
        }
        this.hFB.start();
        if (this.hDA.getStatus() != 6) {
            this.hGp.oh(z);
        }
    }

    public void bJW() {
        if (this.hDA == null || this.hDA.isRecording() || this.hDA.getStatus() == 6) {
            if (this.hFB != null && this.hFB.isRunning()) {
                this.hFB.cancel();
            }
            if (this.hFC == null) {
                this.hFC = new AnimatorSet();
                this.hFC.playTogether(ObjectAnimator.ofFloat(this.hGn, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hGq, "alpha", 0.0f, 1.0f));
                this.hFC.setDuration(300L);
            }
            this.hGn.setVisibility(0);
            this.hGq.setVisibility(0);
            this.hFC.start();
            if (this.hDA.getStatus() != 7 && this.hDA.getStatus() != 6) {
                this.hGp.bJW();
                return;
            }
            this.hGp.getTvTip().setVisibility(8);
            if (this.dJY == 2) {
                this.hGp.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dJY) {
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
                if (this.hGu != null) {
                    this.hGu.bJQ();
                }
                if (this.hDA.getStatus() != 7 && this.hDA.getStatus() != 6) {
                    if (this.hDA != null && this.hDA.bJr()) {
                        this.hGw = true;
                        com.baidu.tbadk.core.util.e.BF().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hGr = currentTimeMillis;
                    this.hGs = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hGs && VideoControllerLayout.this.hGr == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.og(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hGw) {
                    this.hGw = false;
                    return;
                }
                this.hGs = false;
                if (this.hDA.isRecording() || this.hDA.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hDA.getStatus() != 8) {
                    og(false);
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
                if (this.hDA.getStatus() == 6) {
                    this.hDA.setStatus(1);
                    if (this.hGu != null) {
                        this.hGu.bJM();
                        this.hGu.bJz();
                    }
                    this.hGp.getTvTip().setText("");
                    this.hGp.getTvTip().setVisibility(8);
                    return;
                } else if (this.hGB.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hGu != null) {
                    this.hGu.bJL();
                    this.hGp.bKh();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hGp.bKi();
                return;
            default:
                return;
        }
    }

    public void bJF() {
        if (this.hGB.getVisibility() == 0) {
            a((o) null);
        }
        oh(false);
        this.hGp.getLayer1().setVisibility(8);
        this.hGp.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hGp.getTvTip().setVisibility(0);
        if (this.hGu != null) {
            this.hGu.bJK();
        }
    }

    public void bJX() {
        if (this.hDA.getStatus() == 6) {
            if (this.dJY == 2) {
                yx(7);
                this.hGp.setAlpha(1.0f);
                this.hGn.setVisibility(8);
                this.hGq.setVisibility(8);
                this.hGp.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.hDA != null) {
                    this.hDA.startRecord();
                    return;
                }
                return;
            }
            this.hGp.getTvTip().setVisibility(8);
            if (this.hGu != null) {
                this.hGu.bJL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJG() {
        if (bKa() && this.hGB.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bKa()) {
            bJZ();
        }
        this.hGB.bJG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJH() {
        if (bKa() && this.hGB.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bKa()) {
            bJZ();
        }
        this.hGB.bJH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJI() {
        if (bKa() && this.hGB.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bKa()) {
            bJZ();
        }
        this.hGB.bJI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJJ() {
        if (bKa() && this.hGB.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bKa()) {
            bJZ();
        }
        this.hGB.bJJ();
    }

    private void bJY() {
        if (v.G(this.hGt)) {
            this.hGt = new ArrayList();
            this.hGt.add(ObjectAnimator.ofFloat(this.hGB, "translationY", 1000.0f, 0.0f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGo, "translationY", 0.0f, com.baidu.adp.lib.util.l.s(getContext(), d.e.ds100)));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGp.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGp.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGp.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGp.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGq, "scaleX", 1.0f, 0.7f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGq, "scaleY", 1.0f, 0.7f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGn, "scaleX", 1.0f, 0.7f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGn, "scaleY", 1.0f, 0.7f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGq, "alpha", 1.0f, 0.0f));
            this.hGt.add(ObjectAnimator.ofFloat(this.hGn, "alpha", 1.0f, 0.0f));
        }
    }

    private void bJZ() {
        int i = 0;
        if (this.hGB.getVisibility() != 0) {
            this.hGB.setVisibility(0);
            bJY();
            this.hGq.setEnabled(false);
            this.hGn.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hGt.size()) {
                    ObjectAnimator objectAnimator = this.hGt.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hGt.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hGu != null) {
                                        VideoControllerLayout.this.hGu.bJN();
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
        if (this.hGB.getVisibility() != 8) {
            bJY();
            this.hGq.setEnabled(true);
            this.hGn.setEnabled(true);
            if (this.hDA.getStatus() == 6 || this.hDA.isRecording()) {
                this.hGn.setVisibility(8);
                this.hGq.setVisibility(8);
            } else {
                yx(this.hDA.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hGt.size()) {
                    ObjectAnimator objectAnimator = this.hGt.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hGt.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hHq) {
                                        VideoControllerLayout.this.hGB.setVisibility(8);
                                        if (VideoControllerLayout.this.hGu != null) {
                                            VideoControllerLayout.this.hGu.bJO();
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
        this.hGu = aVar;
    }

    public void setCurrentTab(int i) {
        this.dJY = i;
        switch (this.dJY) {
            case 1:
                this.hGn.setVisibility(4);
                this.hGq.setVisibility(4);
                this.hGp.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hDA.getStatus() != 1) {
                    this.hGn.setVisibility(0);
                    this.hGq.setVisibility(0);
                }
                this.hGp.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bKa() {
        return this.hGB.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hGB != null) {
            this.hGB.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hGB != null) {
            this.hGB.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hGB != null) {
            this.hGB.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bKb() {
        if (this.hGB != null) {
            return this.hGB.bKb();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hGv = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hGx;
    }

    public List<e> getChoosedFilterList() {
        return this.hGy;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hGz;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hGA.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hGB != null) {
            this.hGB.setMusicList(this.hGA);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bJS() {
        if (this.hGB != null) {
            this.hGB.bJS();
        }
    }

    public void bKc() {
        if (this.hGB != null) {
            this.hGB.bKc();
        }
    }

    public void bIP() {
        if (this.hGB != null) {
            this.hGB.bIP();
        }
    }
}
