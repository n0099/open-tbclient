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
    private int dOA;
    private j hte;
    private ImageView hvQ;
    private RelativeLayout hvR;
    private VideoRecordButton hvS;
    private ImageView hvT;
    private long hvU;
    private boolean hvV;
    private List<ObjectAnimator> hvW;
    private a hvX;
    private boolean hvY;
    private boolean hvZ;
    private AnimatorSet hve;
    private AnimatorSet hvf;
    private List<e> hwa;
    private List<e> hwb;
    private List<StickerItem> hwc;
    private List<e> hwd;
    private VideoEffectLayout hwe;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bCW();

        void bCX();

        void bDh();

        void bDi();

        void bDj();

        void bDk();

        void bDl();

        void bDm();

        void bDn();

        void bDo();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hvU = 0L;
        this.hvV = false;
        this.hvY = true;
        this.hwa = new ArrayList();
        this.hwb = new ArrayList();
        this.hwc = new ArrayList();
        this.hwd = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvU = 0L;
        this.hvV = false;
        this.hvY = true;
        this.hwa = new ArrayList();
        this.hwb = new ArrayList();
        this.hwc = new ArrayList();
        this.hwd = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvU = 0L;
        this.hvV = false;
        this.hvY = true;
        this.hwa = new ArrayList();
        this.hwb = new ArrayList();
        this.hwc = new ArrayList();
        this.hwd = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hwe = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hvR = (RelativeLayout) findViewById(d.g.layout_record);
        this.hvQ = (ImageView) findViewById(d.g.delete_video);
        this.hvQ.setOnClickListener(this);
        this.hvS = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hvS.setOnTouchListener(this);
        this.hvT = (ImageView) findViewById(d.g.confirm_video);
        this.hvT.setOnClickListener(this);
        this.hwd.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hwd.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.hte = jVar;
        wZ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hwe != null) {
            this.hwe.setListener(aVar);
        }
    }

    public void wZ(int i) {
        this.hte.setStatus(i);
        if (this.hvX != null) {
            this.hvX.bDo();
        }
        if (i == 1) {
            this.hvQ.setVisibility(8);
            this.hvT.setVisibility(8);
        } else if (i == 3) {
            this.hvQ.setImageResource(d.f.video_back_selector);
            this.hvT.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hvQ.setImageResource(d.f.video_back_selector);
            this.hvT.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hvQ.setImageResource(d.f.video_delete_selector);
            if (this.hte != null && this.hte.getVideoDuration() >= 3000.0f) {
                this.hvT.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hvT.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hvQ) {
            if (this.hvX != null) {
                this.hvX.bDn();
            }
            int status = this.hte.getStatus();
            if (this.hte != null && this.hte.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hte.bCQ();
                    dH(this.hwa);
                    dH(this.hwb);
                    dH(this.hwc);
                    if (this.hte.getVideoDuration() >= 3000.0f) {
                        wZ(4);
                        return;
                    } else {
                        wZ(this.hte.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hte.bCP();
                wZ(5);
            }
        } else if (view == this.hvT) {
            TiebaStatic.log("c12300");
            if (this.hte != null && this.hte.getStatus() > 2 && this.hvX != null) {
                if (this.hte.getVideoDuration() >= 3000.0f) {
                    this.hvX.bCX();
                } else {
                    this.hvX.bDm();
                }
            }
        }
    }

    private void dH(List list) {
        if (!v.E(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(final boolean z) {
        if (this.hte.getProgress() >= 100) {
            if (this.hvX != null) {
                this.hvX.bCX();
                return;
            }
            return;
        }
        if (this.hwe.getCurrentBeautyItem() != null) {
            this.hwa.add(this.hwe.getCurrentBeautyItem());
        }
        if (this.hwe.getCurrentFilterItem() != null) {
            this.hwb.add(this.hwe.getCurrentFilterItem());
        }
        if (this.hwe.getCurrentStickItem() != null) {
            this.hwc.add(this.hwe.getCurrentStickItem());
        }
        wZ(2);
        if (this.hwe.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hte.getStatus() == 6 || VideoControllerLayout.this.hte.isRecording()) {
                        VideoControllerLayout.this.nk(z);
                    }
                }
            });
        } else {
            nk(z);
        }
        if (this.hte != null) {
            this.hte.startRecord();
        }
        if (this.hvX != null) {
            this.hvX.bDh();
        }
    }

    public void stopRecord() {
        bDt();
        int status = this.hte.getStatus();
        if (this.hte != null) {
            if (this.hte.getStatus() != 6 && this.hte.isRecording()) {
                this.hte.stopRecord();
            }
            if (this.hte.getVideoDuration() >= 3000.0f) {
                wZ(4);
            } else if (this.hte.getVideoDuration() > 0) {
                wZ(3);
            } else {
                wZ(1);
            }
        }
        if (this.hvX != null) {
            this.hvX.bCW();
            if (status == 6) {
                this.hvX.bDj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nk(boolean z) {
        if (this.hvf != null && this.hvf.isRunning()) {
            this.hvf.cancel();
        }
        if (this.hve == null) {
            this.hve = new AnimatorSet();
            this.hve.playTogether(ObjectAnimator.ofFloat(this.hvQ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hvT, "alpha", 1.0f, 0.0f));
            this.hve.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hwT) {
                        VideoControllerLayout.this.hvQ.setVisibility(8);
                        VideoControllerLayout.this.hvT.setVisibility(8);
                    }
                }
            });
            this.hve.setDuration(300L);
        }
        this.hve.start();
        if (this.hte.getStatus() != 6) {
            this.hvS.nk(z);
        }
    }

    public void bDt() {
        if (this.hte == null || this.hte.isRecording() || this.hte.getStatus() == 6) {
            if (this.hve != null && this.hve.isRunning()) {
                this.hve.cancel();
            }
            if (this.hvf == null) {
                this.hvf = new AnimatorSet();
                this.hvf.playTogether(ObjectAnimator.ofFloat(this.hvQ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hvT, "alpha", 0.0f, 1.0f));
                this.hvf.setDuration(300L);
            }
            this.hvQ.setVisibility(0);
            this.hvT.setVisibility(0);
            this.hvf.start();
            if (this.hte.getStatus() != 7 && this.hte.getStatus() != 6) {
                this.hvS.bDt();
                return;
            }
            this.hvS.getTvTip().setVisibility(8);
            if (this.dOA == 2) {
                this.hvS.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dOA) {
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
                if (this.hvX != null) {
                    this.hvX.bDn();
                }
                if (this.hte.getStatus() != 7 && this.hte.getStatus() != 6) {
                    if (this.hte != null && this.hte.bCO()) {
                        this.hvZ = true;
                        com.baidu.tbadk.core.util.e.Bx().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hvU = currentTimeMillis;
                    this.hvV = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hvV && VideoControllerLayout.this.hvU == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nj(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hvZ) {
                    this.hvZ = false;
                    return;
                }
                this.hvV = false;
                if (this.hte.isRecording() || this.hte.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hte.getStatus() != 8) {
                    nj(false);
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
                if (this.hte.getStatus() == 6) {
                    this.hte.setStatus(1);
                    if (this.hvX != null) {
                        this.hvX.bDj();
                        this.hvX.bCW();
                    }
                    this.hvS.getTvTip().setText("");
                    this.hvS.getTvTip().setVisibility(8);
                    return;
                } else if (this.hwe.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hvX != null) {
                    this.hvX.bDi();
                    this.hvS.bDE();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hvS.bDF();
                return;
            default:
                return;
        }
    }

    public void bDc() {
        if (this.hwe.getVisibility() == 0) {
            a((o) null);
        }
        nk(false);
        this.hvS.getLayer1().setVisibility(8);
        this.hvS.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hvS.getTvTip().setVisibility(0);
        if (this.hvX != null) {
            this.hvX.bDh();
        }
    }

    public void bDu() {
        if (this.hte.getStatus() == 6) {
            if (this.dOA == 2) {
                wZ(7);
                this.hvS.setAlpha(1.0f);
                this.hvQ.setVisibility(8);
                this.hvT.setVisibility(8);
                this.hvS.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.hte != null) {
                    this.hte.startRecord();
                    return;
                }
                return;
            }
            this.hvS.getTvTip().setVisibility(8);
            if (this.hvX != null) {
                this.hvX.bDi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        if (bDx() && this.hwe.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bDx()) {
            bDw();
        }
        this.hwe.bDd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        if (bDx() && this.hwe.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bDx()) {
            bDw();
        }
        this.hwe.bDe();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        if (bDx() && this.hwe.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bDx()) {
            bDw();
        }
        this.hwe.bDf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        if (bDx() && this.hwe.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bDx()) {
            bDw();
        }
        this.hwe.bDg();
    }

    private void bDv() {
        if (v.E(this.hvW)) {
            this.hvW = new ArrayList();
            this.hvW.add(ObjectAnimator.ofFloat(this.hwe, "translationY", 1000.0f, 0.0f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvR, "translationY", 0.0f, com.baidu.adp.lib.util.l.s(getContext(), d.e.ds100)));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvS.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvS.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvS.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvS.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvT, "scaleX", 1.0f, 0.7f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvT, "scaleY", 1.0f, 0.7f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvQ, "scaleX", 1.0f, 0.7f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvQ, "scaleY", 1.0f, 0.7f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvT, "alpha", 1.0f, 0.0f));
            this.hvW.add(ObjectAnimator.ofFloat(this.hvQ, "alpha", 1.0f, 0.0f));
        }
    }

    private void bDw() {
        int i = 0;
        if (this.hwe.getVisibility() != 0) {
            this.hwe.setVisibility(0);
            bDv();
            this.hvT.setEnabled(false);
            this.hvQ.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hvW.size()) {
                    ObjectAnimator objectAnimator = this.hvW.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hvW.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hvX != null) {
                                        VideoControllerLayout.this.hvX.bDk();
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
        if (this.hwe.getVisibility() != 8) {
            bDv();
            this.hvT.setEnabled(true);
            this.hvQ.setEnabled(true);
            if (this.hte.getStatus() == 6 || this.hte.isRecording()) {
                this.hvQ.setVisibility(8);
                this.hvT.setVisibility(8);
            } else {
                wZ(this.hte.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hvW.size()) {
                    ObjectAnimator objectAnimator = this.hvW.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hvW.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hwT) {
                                        VideoControllerLayout.this.hwe.setVisibility(8);
                                        if (VideoControllerLayout.this.hvX != null) {
                                            VideoControllerLayout.this.hvX.bDl();
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
        this.hvX = aVar;
    }

    public void setCurrentTab(int i) {
        this.dOA = i;
        switch (this.dOA) {
            case 1:
                this.hvQ.setVisibility(4);
                this.hvT.setVisibility(4);
                this.hvS.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hte.getStatus() != 1) {
                    this.hvQ.setVisibility(0);
                    this.hvT.setVisibility(0);
                }
                this.hvS.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bDx() {
        return this.hwe.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hwe != null) {
            this.hwe.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hwe != null) {
            this.hwe.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hwe != null) {
            this.hwe.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bDy() {
        if (this.hwe != null) {
            return this.hwe.bDy();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hvY = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hwa;
    }

    public List<e> getChoosedFilterList() {
        return this.hwb;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hwc;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hwd.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hwe != null) {
            this.hwe.setMusicList(this.hwd);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDp() {
        if (this.hwe != null) {
            this.hwe.bDp();
        }
    }

    public void bDz() {
        if (this.hwe != null) {
            this.hwe.bDz();
        }
    }

    public void bCm() {
        if (this.hwe != null) {
            this.hwe.bCm();
        }
    }
}
