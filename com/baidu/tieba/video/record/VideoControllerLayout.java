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
    private int dYL;
    private i hGc;
    private ImageView hIO;
    private RelativeLayout hIP;
    private VideoRecordButton hIQ;
    private ImageView hIR;
    private long hIS;
    private boolean hIT;
    private List<ObjectAnimator> hIU;
    private a hIV;
    private boolean hIW;
    private boolean hIX;
    private List<e> hIY;
    private List<e> hIZ;
    private AnimatorSet hIc;
    private AnimatorSet hId;
    private List<StickerItem> hJa;
    private List<e> hJb;
    private VideoEffectLayout hJc;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void bKK();

        void bKL();

        void bKM();

        void bKN();

        void bKO();

        void bKP();

        void bKQ();

        void bKR();

        void bKS();

        void bKz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hIS = 0L;
        this.hIT = false;
        this.hIW = true;
        this.hIY = new ArrayList();
        this.hIZ = new ArrayList();
        this.hJa = new ArrayList();
        this.hJb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hIS = 0L;
        this.hIT = false;
        this.hIW = true;
        this.hIY = new ArrayList();
        this.hIZ = new ArrayList();
        this.hJa = new ArrayList();
        this.hJb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hIS = 0L;
        this.hIT = false;
        this.hIW = true;
        this.hIY = new ArrayList();
        this.hIZ = new ArrayList();
        this.hJa = new ArrayList();
        this.hJb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hJc = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hIP = (RelativeLayout) findViewById(e.g.layout_record);
        this.hIO = (ImageView) findViewById(e.g.delete_video);
        this.hIO.setOnClickListener(this);
        this.hIQ = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hIQ.setOnTouchListener(this);
        this.hIR = (ImageView) findViewById(e.g.confirm_video);
        this.hIR.setOnClickListener(this);
        this.hJb.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hJb.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hGc = iVar;
        wH(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hJc != null) {
            this.hJc.setListener(aVar);
        }
    }

    public void wH(int i) {
        this.hGc.setStatus(i);
        if (this.hIV != null) {
            this.hIV.bKS();
        }
        if (i == 1) {
            this.hIO.setVisibility(8);
            this.hIR.setVisibility(8);
        } else if (i == 3) {
            this.hIO.setImageResource(e.f.video_back_selector);
            this.hIR.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hIO.setImageResource(e.f.video_back_selector);
            this.hIR.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hIO.setImageResource(e.f.video_delete_selector);
            if (this.hGc != null && this.hGc.getVideoDuration() >= 3000.0f) {
                this.hIR.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hIR.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hIO) {
            if (this.hIV != null) {
                this.hIV.bKR();
            }
            int status = this.hGc.getStatus();
            if (this.hGc != null && this.hGc.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hGc.bKs();
                    ec(this.hIY);
                    ec(this.hIZ);
                    ec(this.hJa);
                    if (this.hGc.getVideoDuration() >= 3000.0f) {
                        wH(4);
                        return;
                    } else {
                        wH(this.hGc.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hGc.bKr();
                wH(5);
            }
        } else if (view == this.hIR) {
            TiebaStatic.log("c12300");
            if (this.hGc != null && this.hGc.getStatus() > 2 && this.hIV != null) {
                if (this.hGc.getVideoDuration() >= 3000.0f) {
                    this.hIV.bKP();
                } else {
                    this.hIV.bKQ();
                }
            }
        }
    }

    private void ec(List list) {
        if (!v.I(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final boolean z) {
        if (this.hGc.getProgress() >= 100) {
            if (this.hIV != null) {
                this.hIV.bKP();
                return;
            }
            return;
        }
        if (this.hJc.getCurrentBeautyItem() != null) {
            this.hIY.add(this.hJc.getCurrentBeautyItem());
        }
        if (this.hJc.getCurrentFilterItem() != null) {
            this.hIZ.add(this.hJc.getCurrentFilterItem());
        }
        if (this.hJc.getCurrentStickItem() != null) {
            this.hJa.add(this.hJc.getCurrentStickItem());
        }
        wH(2);
        if (this.hJc.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hGc.getStatus() == 6 || VideoControllerLayout.this.hGc.FR()) {
                        VideoControllerLayout.this.og(z);
                    }
                }
            });
        } else {
            og(z);
        }
        if (this.hGc != null) {
            this.hGc.startRecord();
        }
        if (this.hIV != null) {
            this.hIV.bKK();
        }
    }

    public void stopRecord() {
        bKW();
        int status = this.hGc.getStatus();
        if (this.hGc != null) {
            if (!this.hGc.bKt() && this.hGc.FR()) {
                this.hGc.stopRecord();
            }
            bKV();
        }
        if (this.hIV != null) {
            this.hIV.bKz();
            if (status == 6) {
                this.hIV.bKM();
            }
        }
    }

    public void bKV() {
        if (this.hGc != null) {
            if (this.hGc.getVideoDuration() >= 3000.0f) {
                wH(4);
            } else if (this.hGc.getVideoDuration() > 0) {
                wH(3);
            } else {
                wH(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void og(boolean z) {
        if (this.hId != null && this.hId.isRunning()) {
            this.hId.cancel();
        }
        if (this.hIc == null) {
            this.hIc = new AnimatorSet();
            this.hIc.playTogether(ObjectAnimator.ofFloat(this.hIO, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hIR, "alpha", 1.0f, 0.0f));
            this.hIc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hJQ) {
                        VideoControllerLayout.this.hIO.setVisibility(8);
                        VideoControllerLayout.this.hIR.setVisibility(8);
                    }
                }
            });
            this.hIc.setDuration(300L);
        }
        this.hIc.start();
        if (this.hGc.getStatus() != 6) {
            this.hIQ.og(z);
        }
    }

    public void bKW() {
        if (this.hGc == null || this.hGc.FR() || this.hGc.getStatus() == 6) {
            if (this.hIc != null && this.hIc.isRunning()) {
                this.hIc.cancel();
            }
            if (this.hId == null) {
                this.hId = new AnimatorSet();
                this.hId.playTogether(ObjectAnimator.ofFloat(this.hIO, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hIR, "alpha", 0.0f, 1.0f));
                this.hId.setDuration(300L);
            }
            this.hIO.setVisibility(0);
            this.hIR.setVisibility(0);
            this.hId.start();
            if (this.hGc.getStatus() != 7 && this.hGc.getStatus() != 6) {
                this.hIQ.bKW();
                return;
            }
            this.hIQ.getTvTip().setVisibility(8);
            if (this.dYL == 2) {
                this.hIQ.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dYL) {
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
                if (this.hIV != null) {
                    this.hIV.bKR();
                }
                if (this.hGc.getStatus() != 7 && this.hGc.getStatus() != 6) {
                    if (this.hGc != null && this.hGc.bKq()) {
                        this.hIX = true;
                        com.baidu.tbadk.core.util.e.CD().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hIS = currentTimeMillis;
                    this.hIT = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hIT && VideoControllerLayout.this.hIS == currentTimeMillis) {
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
                if (this.hIX) {
                    this.hIX = false;
                    return;
                }
                this.hIT = false;
                if (this.hGc.FR() || this.hGc.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hGc.getStatus() != 8) {
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
                if (this.hGc.getStatus() == 6) {
                    this.hGc.setStatus(1);
                    if (this.hIV != null) {
                        this.hIV.bKM();
                        this.hIV.bKz();
                    }
                    this.hIQ.getTvTip().setText("");
                    this.hIQ.getTvTip().setVisibility(8);
                    return;
                } else if (this.hJc.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hIV != null) {
                    this.hIV.bKL();
                    this.hIQ.bLh();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hIQ.bLi();
                return;
            default:
                return;
        }
    }

    public void bKF() {
        if (this.hJc.getVisibility() == 0) {
            a((m) null);
        }
        og(false);
        this.hIQ.getLayer1().setVisibility(8);
        this.hIQ.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hIQ.getTvTip().setVisibility(0);
        if (this.hIV != null) {
            this.hIV.bKK();
        }
    }

    public void bKX() {
        if (this.hGc.getStatus() == 6) {
            if (this.dYL == 2) {
                wH(7);
                this.hIQ.setAlpha(1.0f);
                this.hIO.setVisibility(8);
                this.hIR.setVisibility(8);
                this.hIQ.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hGc != null) {
                    this.hGc.startRecord();
                    return;
                }
                return;
            }
            this.hIQ.getTvTip().setVisibility(8);
            if (this.hIV != null) {
                this.hIV.bKL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKG() {
        if (bLa() && this.hJc.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bLa()) {
            bKZ();
        }
        this.hJc.bKG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKH() {
        if (bLa() && this.hJc.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bLa()) {
            bKZ();
        }
        this.hJc.bKH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKI() {
        if (bLa() && this.hJc.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bLa()) {
            bKZ();
        }
        this.hJc.bKI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKJ() {
        if (bLa() && this.hJc.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bLa()) {
            bKZ();
        }
        this.hJc.bKJ();
    }

    private void bKY() {
        if (v.I(this.hIU)) {
            this.hIU = new ArrayList();
            this.hIU.add(ObjectAnimator.ofFloat(this.hJc, "translationY", 1000.0f, 0.0f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIP, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds100)));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIQ.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIQ.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIQ.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIQ.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIR, "scaleX", 1.0f, 0.7f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIR, "scaleY", 1.0f, 0.7f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIO, "scaleX", 1.0f, 0.7f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIO, "scaleY", 1.0f, 0.7f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIR, "alpha", 1.0f, 0.0f));
            this.hIU.add(ObjectAnimator.ofFloat(this.hIO, "alpha", 1.0f, 0.0f));
        }
    }

    private void bKZ() {
        int i = 0;
        if (this.hJc.getVisibility() != 0) {
            this.hJc.setVisibility(0);
            bKY();
            this.hIR.setEnabled(false);
            this.hIO.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hIU.size()) {
                    ObjectAnimator objectAnimator = this.hIU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hIU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hIV != null) {
                                        VideoControllerLayout.this.hIV.bKN();
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
        if (this.hJc.getVisibility() != 8) {
            bKY();
            this.hIR.setEnabled(true);
            this.hIO.setEnabled(true);
            if (this.hGc.getStatus() == 6 || this.hGc.FR()) {
                this.hIO.setVisibility(8);
                this.hIR.setVisibility(8);
            } else {
                wH(this.hGc.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hIU.size()) {
                    ObjectAnimator objectAnimator = this.hIU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hIU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hJQ) {
                                        VideoControllerLayout.this.hJc.setVisibility(8);
                                        if (VideoControllerLayout.this.hIV != null) {
                                            VideoControllerLayout.this.hIV.bKO();
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
        this.hIV = aVar;
    }

    public void setCurrentTab(int i) {
        this.dYL = i;
        switch (this.dYL) {
            case 1:
                this.hIO.setVisibility(4);
                this.hIR.setVisibility(4);
                this.hIQ.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hGc.getStatus() != 1) {
                    this.hIO.setVisibility(0);
                    this.hIR.setVisibility(0);
                }
                this.hIQ.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bLa() {
        return this.hJc.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hJc != null) {
            this.hJc.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hJc != null) {
            this.hJc.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hJc != null) {
            this.hJc.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bLb() {
        if (this.hJc != null) {
            return this.hJc.bLb();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hIW = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hIY;
    }

    public List<e> getChoosedFilterList() {
        return this.hIZ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hJa;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hJb.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hJc != null) {
            this.hJc.setMusicList(this.hJb);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bLc() {
        if (this.hJc != null) {
            this.hJc.bLc();
        }
    }

    public void bJQ() {
        if (this.hJc != null) {
            this.hJc.bJQ();
        }
    }
}
