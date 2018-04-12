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
    private int dlZ;
    private i gQh;
    private ImageView gSR;
    private RelativeLayout gSS;
    private VideoRecordButton gST;
    private ImageView gSU;
    private long gSV;
    private boolean gSW;
    private List<ObjectAnimator> gSX;
    private a gSY;
    private boolean gSZ;
    private AnimatorSet gSf;
    private AnimatorSet gSg;
    private boolean gTa;
    private List<e> gTb;
    private List<e> gTc;
    private List<StickerItem> gTd;
    private List<e> gTe;
    private VideoEffectLayout gTf;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void byE();

        void byP();

        void byQ();

        void byR();

        void byS();

        void byT();

        void byU();

        void byV();

        void byW();

        void byX();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gSV = 0L;
        this.gSW = false;
        this.gSZ = true;
        this.gTb = new ArrayList();
        this.gTc = new ArrayList();
        this.gTd = new ArrayList();
        this.gTe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSV = 0L;
        this.gSW = false;
        this.gSZ = true;
        this.gTb = new ArrayList();
        this.gTc = new ArrayList();
        this.gTd = new ArrayList();
        this.gTe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSV = 0L;
        this.gSW = false;
        this.gSZ = true;
        this.gTb = new ArrayList();
        this.gTc = new ArrayList();
        this.gTd = new ArrayList();
        this.gTe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.record_controller_layout, this);
        this.gTf = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gSS = (RelativeLayout) findViewById(d.g.layout_record);
        this.gSR = (ImageView) findViewById(d.g.delete_video);
        this.gSR.setOnClickListener(this);
        this.gST = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gST.setOnTouchListener(this);
        this.gSU = (ImageView) findViewById(d.g.confirm_video);
        this.gSU.setOnClickListener(this);
        this.gTe.add(0, new e(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute));
        this.gTe.add(1, new e(3, getResources().getString(d.k.music_cloud), new MusicData("-200", 2, getResources().getString(d.k.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.gQh = iVar;
        uC(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gTf != null) {
            this.gTf.setListener(aVar);
        }
    }

    public void uC(int i) {
        this.gQh.setStatus(i);
        if (this.gSY != null) {
            this.gSY.byX();
        }
        if (i == 1) {
            this.gSR.setVisibility(8);
            this.gSU.setVisibility(8);
        } else if (i == 3) {
            this.gSR.setImageResource(d.f.video_back_selector);
            this.gSU.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gSR.setImageResource(d.f.video_back_selector);
            this.gSU.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gSR.setImageResource(d.f.video_delete_selector);
            if (this.gQh != null && this.gQh.getVideoDuration() >= 3000.0f) {
                this.gSU.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gSU.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.gSR) {
            if (this.gSY != null) {
                this.gSY.byW();
            }
            int status = this.gQh.getStatus();
            if (this.gQh != null && this.gQh.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gQh.byx();
                    dE(this.gTb);
                    dE(this.gTc);
                    dE(this.gTd);
                    if (this.gQh.getVideoDuration() >= 3000.0f) {
                        uC(4);
                        return;
                    } else {
                        uC(this.gQh.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gQh.byw();
                uC(5);
            }
        } else if (view2 == this.gSU) {
            TiebaStatic.log("c12300");
            if (this.gQh != null && this.gQh.getStatus() > 2 && this.gSY != null) {
                if (this.gQh.getVideoDuration() >= 3000.0f) {
                    this.gSY.byU();
                } else {
                    this.gSY.byV();
                }
            }
        }
    }

    private void dE(List list) {
        if (!v.w(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.gQh.getProgress() >= 100) {
            if (this.gSY != null) {
                this.gSY.byU();
                return;
            }
            return;
        }
        if (this.gTf.getCurrentBeautyItem() != null) {
            this.gTb.add(this.gTf.getCurrentBeautyItem());
        }
        if (this.gTf.getCurrentFilterItem() != null) {
            this.gTc.add(this.gTf.getCurrentFilterItem());
        }
        if (this.gTf.getCurrentStickItem() != null) {
            this.gTd.add(this.gTf.getCurrentStickItem());
        }
        uC(2);
        if (this.gTf.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gQh.getStatus() == 6 || VideoControllerLayout.this.gQh.isRecording()) {
                        VideoControllerLayout.this.nb(z);
                    }
                }
            });
        } else {
            nb(z);
        }
        if (this.gQh != null) {
            this.gQh.startRecord();
        }
        if (this.gSY != null) {
            this.gSY.byP();
        }
    }

    public void stopRecord() {
        bzb();
        int status = this.gQh.getStatus();
        if (this.gQh != null) {
            if (!this.gQh.byy() && this.gQh.isRecording()) {
                this.gQh.stopRecord();
            }
            bza();
        }
        if (this.gSY != null) {
            this.gSY.byE();
            if (status == 6) {
                this.gSY.byR();
            }
        }
    }

    public void bza() {
        if (this.gQh != null) {
            if (this.gQh.getVideoDuration() >= 3000.0f) {
                uC(4);
            } else if (this.gQh.getVideoDuration() > 0) {
                uC(3);
            } else {
                uC(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(boolean z) {
        if (this.gSg != null && this.gSg.isRunning()) {
            this.gSg.cancel();
        }
        if (this.gSf == null) {
            this.gSf = new AnimatorSet();
            this.gSf.playTogether(ObjectAnimator.ofFloat(this.gSR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gSU, "alpha", 1.0f, 0.0f));
            this.gSf.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTU) {
                        VideoControllerLayout.this.gSR.setVisibility(8);
                        VideoControllerLayout.this.gSU.setVisibility(8);
                    }
                }
            });
            this.gSf.setDuration(300L);
        }
        this.gSf.start();
        if (this.gQh.getStatus() != 6) {
            this.gST.nb(z);
        }
    }

    public void bzb() {
        if (this.gQh == null || this.gQh.isRecording() || this.gQh.getStatus() == 6) {
            if (this.gSf != null && this.gSf.isRunning()) {
                this.gSf.cancel();
            }
            if (this.gSg == null) {
                this.gSg = new AnimatorSet();
                this.gSg.playTogether(ObjectAnimator.ofFloat(this.gSR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gSU, "alpha", 0.0f, 1.0f));
                this.gSg.setDuration(300L);
            }
            this.gSR.setVisibility(0);
            this.gSU.setVisibility(0);
            this.gSg.start();
            if (this.gQh.getStatus() != 7 && this.gQh.getStatus() != 6) {
                this.gST.bzb();
                return;
            }
            this.gST.getTvTip().setVisibility(8);
            if (this.dlZ == 2) {
                this.gST.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        switch (this.dlZ) {
            case 1:
                g(view2, motionEvent);
                return true;
            case 2:
                f(view2, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void f(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gSY != null) {
                    this.gSY.byW();
                }
                if (this.gQh.getStatus() != 7 && this.gQh.getStatus() != 6) {
                    if (this.gQh != null && this.gQh.byv()) {
                        this.gTa = true;
                        com.baidu.tbadk.core.util.e.uB().showToast(d.k.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gSV = currentTimeMillis;
                    this.gSW = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gSW && VideoControllerLayout.this.gSV == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.na(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.gTa) {
                    this.gTa = false;
                    return;
                }
                this.gSW = false;
                if (this.gQh.isRecording() || this.gQh.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.gQh.getStatus() != 8) {
                    na(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void g(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gQh.getStatus() == 6) {
                    this.gQh.setStatus(1);
                    if (this.gSY != null) {
                        this.gSY.byR();
                        this.gSY.byE();
                    }
                    this.gST.getTvTip().setText("");
                    this.gST.getTvTip().setVisibility(8);
                    return;
                } else if (this.gTf.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.gSY != null) {
                    this.gSY.byQ();
                    this.gST.bzm();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gST.bzn();
                return;
            default:
                return;
        }
    }

    public void byK() {
        if (this.gTf.getVisibility() == 0) {
            a((m) null);
        }
        nb(false);
        this.gST.getLayer1().setVisibility(8);
        this.gST.getTvTip().setText(getResources().getText(d.k.video_record_button_cancel));
        this.gST.getTvTip().setVisibility(0);
        if (this.gSY != null) {
            this.gSY.byP();
        }
    }

    public void bzc() {
        if (this.gQh.getStatus() == 6) {
            if (this.dlZ == 2) {
                uC(7);
                this.gST.setAlpha(1.0f);
                this.gSR.setVisibility(8);
                this.gSU.setVisibility(8);
                this.gST.getTvTip().setText(getResources().getString(d.k.video_record_button_pasue));
                if (this.gQh != null) {
                    this.gQh.startRecord();
                    return;
                }
                return;
            }
            this.gST.getTvTip().setVisibility(8);
            if (this.gSY != null) {
                this.gSY.byQ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        if (bzf() && this.gTf.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTf.byL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        if (bzf() && this.gTf.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTf.byM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        if (bzf() && this.gTf.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTf.byN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        if (bzf() && this.gTf.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bzf()) {
            bze();
        }
        this.gTf.byO();
    }

    private void bzd() {
        if (v.w(this.gSX)) {
            this.gSX = new ArrayList();
            this.gSX.add(ObjectAnimator.ofFloat(this.gTf, "translationY", 1000.0f, 0.0f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSS, "translationY", 0.0f, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds100)));
            this.gSX.add(ObjectAnimator.ofFloat(this.gST.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gST.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gST.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gST.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSU, "scaleX", 1.0f, 0.7f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSU, "scaleY", 1.0f, 0.7f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSR, "scaleX", 1.0f, 0.7f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSR, "scaleY", 1.0f, 0.7f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSU, "alpha", 1.0f, 0.0f));
            this.gSX.add(ObjectAnimator.ofFloat(this.gSR, "alpha", 1.0f, 0.0f));
        }
    }

    private void bze() {
        int i = 0;
        if (this.gTf.getVisibility() != 0) {
            this.gTf.setVisibility(0);
            bzd();
            this.gSU.setEnabled(false);
            this.gSR.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gSX.size()) {
                    ObjectAnimator objectAnimator = this.gSX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gSX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gSY != null) {
                                        VideoControllerLayout.this.gSY.byS();
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
        if (this.gTf.getVisibility() != 8) {
            bzd();
            this.gSU.setEnabled(true);
            this.gSR.setEnabled(true);
            if (this.gQh.getStatus() == 6 || this.gQh.isRecording()) {
                this.gSR.setVisibility(8);
                this.gSU.setVisibility(8);
            } else {
                uC(this.gQh.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gSX.size()) {
                    ObjectAnimator objectAnimator = this.gSX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gSX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.gTU) {
                                        VideoControllerLayout.this.gTf.setVisibility(8);
                                        if (VideoControllerLayout.this.gSY != null) {
                                            VideoControllerLayout.this.gSY.byT();
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
        this.gSY = aVar;
    }

    public void setCurrentTab(int i) {
        this.dlZ = i;
        switch (this.dlZ) {
            case 1:
                this.gSR.setVisibility(4);
                this.gSU.setVisibility(4);
                this.gST.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gQh.getStatus() != 1) {
                    this.gSR.setVisibility(0);
                    this.gSU.setVisibility(0);
                }
                this.gST.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bzf() {
        return this.gTf.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gTf != null) {
            this.gTf.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gTf != null) {
            this.gTf.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gTf != null) {
            this.gTf.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bzg() {
        if (this.gTf != null) {
            return this.gTf.bzg();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gSZ = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gTb;
    }

    public List<e> getChoosedFilterList() {
        return this.gTc;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gTd;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gTe.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gTf != null) {
            this.gTf.setMusicList(this.gTe);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
    }

    public void bzh() {
        if (this.gTf != null) {
            this.gTf.bzh();
        }
    }

    public void bxU() {
        if (this.gTf != null) {
            this.gTf.bxU();
        }
    }
}
