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
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int fpA;
    private i jaH;
    private AnimatorSet jcF;
    private AnimatorSet jcG;
    private boolean jdA;
    private List<e> jdB;
    private List<e> jdC;
    private List<StickerItem> jdD;
    private List<e> jdE;
    private VideoEffectLayout jdF;
    private ImageView jdr;
    private RelativeLayout jds;
    private VideoRecordButton jdt;
    private ImageView jdu;
    private long jdv;
    private boolean jdw;
    private List<ObjectAnimator> jdx;
    private a jdy;
    private boolean jdz;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void clI();

        void clJ();

        void clK();

        void clL();

        void clM();

        void clN();

        void clO();

        void clP();

        void clQ();

        void clx();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jdv = 0L;
        this.jdw = false;
        this.jdz = true;
        this.jdB = new ArrayList();
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdv = 0L;
        this.jdw = false;
        this.jdz = true;
        this.jdB = new ArrayList();
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdv = 0L;
        this.jdw = false;
        this.jdz = true;
        this.jdB = new ArrayList();
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.jdF = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.jds = (RelativeLayout) findViewById(d.g.layout_record);
        this.jdr = (ImageView) findViewById(d.g.delete_video);
        this.jdr.setOnClickListener(this);
        this.jdt = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.jdt.setOnTouchListener(this);
        this.jdu = (ImageView) findViewById(d.g.confirm_video);
        this.jdu.setOnClickListener(this);
        this.jdE.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.jdE.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jaH = iVar;
        AF(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jdF != null) {
            this.jdF.setListener(aVar);
        }
    }

    public void AF(int i) {
        this.jaH.setStatus(i);
        if (this.jdy != null) {
            this.jdy.clQ();
        }
        if (i == 1) {
            this.jdr.setVisibility(8);
            this.jdu.setVisibility(8);
        } else if (i == 3) {
            this.jdr.setImageResource(d.f.video_back_selector);
            this.jdu.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.jdr.setImageResource(d.f.video_back_selector);
            this.jdu.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.jdr.setImageResource(d.f.video_delete_selector);
            if (this.jaH != null && this.jaH.getVideoDuration() >= 3000.0f) {
                this.jdu.setImageResource(d.f.video_confirm_selector);
            } else {
                this.jdu.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdr) {
            if (this.jdy != null) {
                this.jdy.clP();
            }
            int status = this.jaH.getStatus();
            if (this.jaH != null && this.jaH.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jaH.clq();
                    eh(this.jdB);
                    eh(this.jdC);
                    eh(this.jdD);
                    if (this.jaH.getVideoDuration() >= 3000.0f) {
                        AF(4);
                        return;
                    } else {
                        AF(this.jaH.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jaH.clp();
                AF(5);
            }
        } else if (view == this.jdu) {
            TiebaStatic.log("c12300");
            if (this.jaH != null && this.jaH.getStatus() > 2 && this.jdy != null) {
                if (this.jaH.getVideoDuration() >= 3000.0f) {
                    this.jdy.clN();
                } else {
                    this.jdy.clO();
                }
            }
        }
    }

    private void eh(List list) {
        if (!v.T(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(final boolean z) {
        if (this.jaH.getProgress() >= 100) {
            if (this.jdy != null) {
                this.jdy.clN();
                return;
            }
            return;
        }
        if (this.jdF.getCurrentBeautyItem() != null) {
            this.jdB.add(this.jdF.getCurrentBeautyItem());
        }
        if (this.jdF.getCurrentFilterItem() != null) {
            this.jdC.add(this.jdF.getCurrentFilterItem());
        }
        if (this.jdF.getCurrentStickItem() != null) {
            this.jdD.add(this.jdF.getCurrentStickItem());
        }
        AF(2);
        if (this.jdF.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jaH.getStatus() == 6 || VideoControllerLayout.this.jaH.afw()) {
                        VideoControllerLayout.this.qK(z);
                    }
                }
            });
        } else {
            qK(z);
        }
        if (this.jaH != null) {
            this.jaH.startRecord();
        }
        if (this.jdy != null) {
            this.jdy.clI();
        }
    }

    public void stopRecord() {
        clU();
        int status = this.jaH.getStatus();
        if (this.jaH != null) {
            if (!this.jaH.clr() && this.jaH.afw()) {
                this.jaH.stopRecord();
            }
            clT();
        }
        if (this.jdy != null) {
            this.jdy.clx();
            if (status == 6) {
                this.jdy.clK();
            }
        }
    }

    public void clT() {
        if (this.jaH != null) {
            if (this.jaH.getVideoDuration() >= 3000.0f) {
                AF(4);
            } else if (this.jaH.getVideoDuration() > 0) {
                AF(3);
            } else {
                AF(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(boolean z) {
        if (this.jcG != null && this.jcG.isRunning()) {
            this.jcG.cancel();
        }
        if (this.jcF == null) {
            this.jcF = new AnimatorSet();
            this.jcF.playTogether(ObjectAnimator.ofFloat(this.jdr, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jdu, "alpha", 1.0f, 0.0f));
            this.jcF.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jes) {
                        VideoControllerLayout.this.jdr.setVisibility(8);
                        VideoControllerLayout.this.jdu.setVisibility(8);
                    }
                }
            });
            this.jcF.setDuration(300L);
        }
        this.jcF.start();
        if (this.jaH.getStatus() != 6) {
            this.jdt.qK(z);
        }
    }

    public void clU() {
        if (this.jaH == null || this.jaH.afw() || this.jaH.getStatus() == 6) {
            if (this.jcF != null && this.jcF.isRunning()) {
                this.jcF.cancel();
            }
            if (this.jcG == null) {
                this.jcG = new AnimatorSet();
                this.jcG.playTogether(ObjectAnimator.ofFloat(this.jdr, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jdu, "alpha", 0.0f, 1.0f));
                this.jcG.setDuration(300L);
            }
            this.jdr.setVisibility(0);
            this.jdu.setVisibility(0);
            this.jcG.start();
            if (this.jaH.getStatus() != 7 && this.jaH.getStatus() != 6) {
                this.jdt.clU();
                return;
            }
            this.jdt.getTvTip().setVisibility(8);
            if (this.fpA == 2) {
                this.jdt.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fpA) {
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
                if (this.jdy != null) {
                    this.jdy.clP();
                }
                if (this.jaH.getStatus() != 7 && this.jaH.getStatus() != 6) {
                    if (this.jaH != null && this.jaH.clo()) {
                        this.jdA = true;
                        com.baidu.tbadk.core.util.e.abX().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jdv = currentTimeMillis;
                    this.jdw = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jdw && VideoControllerLayout.this.jdv == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.bn(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jdA) {
                    this.jdA = false;
                    return;
                }
                this.jdw = false;
                if (this.jaH.afw() || this.jaH.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jaH.getStatus() != 8) {
                    bn(false);
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
                if (this.jaH.getStatus() == 6) {
                    this.jaH.setStatus(1);
                    if (this.jdy != null) {
                        this.jdy.clK();
                        this.jdy.clx();
                    }
                    this.jdt.getTvTip().setText("");
                    this.jdt.getTvTip().setVisibility(8);
                    return;
                } else if (this.jdF.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jdy != null) {
                    this.jdy.clJ();
                    this.jdt.cmf();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jdt.cmg();
                return;
            default:
                return;
        }
    }

    public void clD() {
        if (this.jdF.getVisibility() == 0) {
            a((m) null);
        }
        qK(false);
        this.jdt.getLayer1().setVisibility(8);
        this.jdt.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.jdt.getTvTip().setVisibility(0);
        if (this.jdy != null) {
            this.jdy.clI();
        }
    }

    public void clV() {
        if (this.jaH.getStatus() == 6) {
            if (this.fpA == 2) {
                AF(7);
                this.jdt.setAlpha(1.0f);
                this.jdr.setVisibility(8);
                this.jdu.setVisibility(8);
                this.jdt.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.jaH != null) {
                    this.jaH.startRecord();
                    return;
                }
                return;
            }
            this.jdt.getTvTip().setVisibility(8);
            if (this.jdy != null) {
                this.jdy.clJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        if (clY() && this.jdF.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdF.clE();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        if (clY() && this.jdF.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdF.clF();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        if (clY() && this.jdF.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdF.clG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        if (clY() && this.jdF.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdF.clH();
    }

    private void clW() {
        if (v.T(this.jdx)) {
            this.jdx = new ArrayList();
            this.jdx.add(ObjectAnimator.ofFloat(this.jdF, "translationY", 1000.0f, 0.0f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jds, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds100)));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdt.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdt.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdt.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdt.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdu, "scaleX", 1.0f, 0.7f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdu, "scaleY", 1.0f, 0.7f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdr, "scaleX", 1.0f, 0.7f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdr, "scaleY", 1.0f, 0.7f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdu, "alpha", 1.0f, 0.0f));
            this.jdx.add(ObjectAnimator.ofFloat(this.jdr, "alpha", 1.0f, 0.0f));
        }
    }

    private void clX() {
        int i = 0;
        if (this.jdF.getVisibility() != 0) {
            this.jdF.setVisibility(0);
            clW();
            this.jdu.setEnabled(false);
            this.jdr.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jdx.size()) {
                    ObjectAnimator objectAnimator = this.jdx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jdy != null) {
                                        VideoControllerLayout.this.jdy.clL();
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
        if (this.jdF.getVisibility() != 8) {
            clW();
            this.jdu.setEnabled(true);
            this.jdr.setEnabled(true);
            if (this.jaH.getStatus() == 6 || this.jaH.afw()) {
                this.jdr.setVisibility(8);
                this.jdu.setVisibility(8);
            } else {
                AF(this.jaH.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jdx.size()) {
                    ObjectAnimator objectAnimator = this.jdx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jes) {
                                        VideoControllerLayout.this.jdF.setVisibility(8);
                                        if (VideoControllerLayout.this.jdy != null) {
                                            VideoControllerLayout.this.jdy.clM();
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
        this.jdy = aVar;
    }

    public void setCurrentTab(int i) {
        this.fpA = i;
        switch (this.fpA) {
            case 1:
                this.jdr.setVisibility(4);
                this.jdu.setVisibility(4);
                this.jdt.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jaH.getStatus() != 1) {
                    this.jdr.setVisibility(0);
                    this.jdu.setVisibility(0);
                }
                this.jdt.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean clY() {
        return this.jdF.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jdF != null) {
            this.jdF.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jdF != null) {
            this.jdF.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jdF != null) {
            this.jdF.setDownLoadStrick(stickerItem);
        }
    }

    public boolean clZ() {
        if (this.jdF != null) {
            return this.jdF.clZ();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jdz = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jdB;
    }

    public List<e> getChoosedFilterList() {
        return this.jdC;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jdD;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jdE.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jdF != null) {
            this.jdF.setMusicList(this.jdE);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
    }

    public void cma() {
        if (this.jdF != null) {
            this.jdF.cma();
        }
    }

    public void ckO() {
        if (this.jdF != null) {
            this.jdF.ckO();
        }
    }
}
