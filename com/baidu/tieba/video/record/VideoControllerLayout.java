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
    private i jaI;
    private AnimatorSet jcG;
    private AnimatorSet jcH;
    private boolean jdA;
    private boolean jdB;
    private List<e> jdC;
    private List<e> jdD;
    private List<StickerItem> jdE;
    private List<e> jdF;
    private VideoEffectLayout jdG;
    private ImageView jds;
    private RelativeLayout jdt;
    private VideoRecordButton jdu;
    private ImageView jdv;
    private long jdw;
    private boolean jdx;
    private List<ObjectAnimator> jdy;
    private a jdz;
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
        this.jdw = 0L;
        this.jdx = false;
        this.jdA = true;
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.jdF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jdw = 0L;
        this.jdx = false;
        this.jdA = true;
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.jdF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdw = 0L;
        this.jdx = false;
        this.jdA = true;
        this.jdC = new ArrayList();
        this.jdD = new ArrayList();
        this.jdE = new ArrayList();
        this.jdF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.jdG = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.jdt = (RelativeLayout) findViewById(d.g.layout_record);
        this.jds = (ImageView) findViewById(d.g.delete_video);
        this.jds.setOnClickListener(this);
        this.jdu = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.jdu.setOnTouchListener(this);
        this.jdv = (ImageView) findViewById(d.g.confirm_video);
        this.jdv.setOnClickListener(this);
        this.jdF.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.jdF.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jaI = iVar;
        AF(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jdG != null) {
            this.jdG.setListener(aVar);
        }
    }

    public void AF(int i) {
        this.jaI.setStatus(i);
        if (this.jdz != null) {
            this.jdz.clQ();
        }
        if (i == 1) {
            this.jds.setVisibility(8);
            this.jdv.setVisibility(8);
        } else if (i == 3) {
            this.jds.setImageResource(d.f.video_back_selector);
            this.jdv.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.jds.setImageResource(d.f.video_back_selector);
            this.jdv.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.jds.setImageResource(d.f.video_delete_selector);
            if (this.jaI != null && this.jaI.getVideoDuration() >= 3000.0f) {
                this.jdv.setImageResource(d.f.video_confirm_selector);
            } else {
                this.jdv.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jds) {
            if (this.jdz != null) {
                this.jdz.clP();
            }
            int status = this.jaI.getStatus();
            if (this.jaI != null && this.jaI.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jaI.clq();
                    eh(this.jdC);
                    eh(this.jdD);
                    eh(this.jdE);
                    if (this.jaI.getVideoDuration() >= 3000.0f) {
                        AF(4);
                        return;
                    } else {
                        AF(this.jaI.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jaI.clp();
                AF(5);
            }
        } else if (view == this.jdv) {
            TiebaStatic.log("c12300");
            if (this.jaI != null && this.jaI.getStatus() > 2 && this.jdz != null) {
                if (this.jaI.getVideoDuration() >= 3000.0f) {
                    this.jdz.clN();
                } else {
                    this.jdz.clO();
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
        if (this.jaI.getProgress() >= 100) {
            if (this.jdz != null) {
                this.jdz.clN();
                return;
            }
            return;
        }
        if (this.jdG.getCurrentBeautyItem() != null) {
            this.jdC.add(this.jdG.getCurrentBeautyItem());
        }
        if (this.jdG.getCurrentFilterItem() != null) {
            this.jdD.add(this.jdG.getCurrentFilterItem());
        }
        if (this.jdG.getCurrentStickItem() != null) {
            this.jdE.add(this.jdG.getCurrentStickItem());
        }
        AF(2);
        if (this.jdG.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jaI.getStatus() == 6 || VideoControllerLayout.this.jaI.afw()) {
                        VideoControllerLayout.this.qK(z);
                    }
                }
            });
        } else {
            qK(z);
        }
        if (this.jaI != null) {
            this.jaI.startRecord();
        }
        if (this.jdz != null) {
            this.jdz.clI();
        }
    }

    public void stopRecord() {
        clU();
        int status = this.jaI.getStatus();
        if (this.jaI != null) {
            if (!this.jaI.clr() && this.jaI.afw()) {
                this.jaI.stopRecord();
            }
            clT();
        }
        if (this.jdz != null) {
            this.jdz.clx();
            if (status == 6) {
                this.jdz.clK();
            }
        }
    }

    public void clT() {
        if (this.jaI != null) {
            if (this.jaI.getVideoDuration() >= 3000.0f) {
                AF(4);
            } else if (this.jaI.getVideoDuration() > 0) {
                AF(3);
            } else {
                AF(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(boolean z) {
        if (this.jcH != null && this.jcH.isRunning()) {
            this.jcH.cancel();
        }
        if (this.jcG == null) {
            this.jcG = new AnimatorSet();
            this.jcG.playTogether(ObjectAnimator.ofFloat(this.jds, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jdv, "alpha", 1.0f, 0.0f));
            this.jcG.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jet) {
                        VideoControllerLayout.this.jds.setVisibility(8);
                        VideoControllerLayout.this.jdv.setVisibility(8);
                    }
                }
            });
            this.jcG.setDuration(300L);
        }
        this.jcG.start();
        if (this.jaI.getStatus() != 6) {
            this.jdu.qK(z);
        }
    }

    public void clU() {
        if (this.jaI == null || this.jaI.afw() || this.jaI.getStatus() == 6) {
            if (this.jcG != null && this.jcG.isRunning()) {
                this.jcG.cancel();
            }
            if (this.jcH == null) {
                this.jcH = new AnimatorSet();
                this.jcH.playTogether(ObjectAnimator.ofFloat(this.jds, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jdv, "alpha", 0.0f, 1.0f));
                this.jcH.setDuration(300L);
            }
            this.jds.setVisibility(0);
            this.jdv.setVisibility(0);
            this.jcH.start();
            if (this.jaI.getStatus() != 7 && this.jaI.getStatus() != 6) {
                this.jdu.clU();
                return;
            }
            this.jdu.getTvTip().setVisibility(8);
            if (this.fpA == 2) {
                this.jdu.getLayer1().setVisibility(0);
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
                if (this.jdz != null) {
                    this.jdz.clP();
                }
                if (this.jaI.getStatus() != 7 && this.jaI.getStatus() != 6) {
                    if (this.jaI != null && this.jaI.clo()) {
                        this.jdB = true;
                        com.baidu.tbadk.core.util.e.abX().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jdw = currentTimeMillis;
                    this.jdx = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jdx && VideoControllerLayout.this.jdw == currentTimeMillis) {
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
                if (this.jdB) {
                    this.jdB = false;
                    return;
                }
                this.jdx = false;
                if (this.jaI.afw() || this.jaI.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jaI.getStatus() != 8) {
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
                if (this.jaI.getStatus() == 6) {
                    this.jaI.setStatus(1);
                    if (this.jdz != null) {
                        this.jdz.clK();
                        this.jdz.clx();
                    }
                    this.jdu.getTvTip().setText("");
                    this.jdu.getTvTip().setVisibility(8);
                    return;
                } else if (this.jdG.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jdz != null) {
                    this.jdz.clJ();
                    this.jdu.cmf();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jdu.cmg();
                return;
            default:
                return;
        }
    }

    public void clD() {
        if (this.jdG.getVisibility() == 0) {
            a((m) null);
        }
        qK(false);
        this.jdu.getLayer1().setVisibility(8);
        this.jdu.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.jdu.getTvTip().setVisibility(0);
        if (this.jdz != null) {
            this.jdz.clI();
        }
    }

    public void clV() {
        if (this.jaI.getStatus() == 6) {
            if (this.fpA == 2) {
                AF(7);
                this.jdu.setAlpha(1.0f);
                this.jds.setVisibility(8);
                this.jdv.setVisibility(8);
                this.jdu.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.jaI != null) {
                    this.jaI.startRecord();
                    return;
                }
                return;
            }
            this.jdu.getTvTip().setVisibility(8);
            if (this.jdz != null) {
                this.jdz.clJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        if (clY() && this.jdG.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdG.clE();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        if (clY() && this.jdG.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdG.clF();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        if (clY() && this.jdG.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdG.clG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        if (clY() && this.jdG.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!clY()) {
            clX();
        }
        this.jdG.clH();
    }

    private void clW() {
        if (v.T(this.jdy)) {
            this.jdy = new ArrayList();
            this.jdy.add(ObjectAnimator.ofFloat(this.jdG, "translationY", 1000.0f, 0.0f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdt, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds100)));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdu.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdu.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdu.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdu.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdv, "scaleX", 1.0f, 0.7f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdv, "scaleY", 1.0f, 0.7f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jds, "scaleX", 1.0f, 0.7f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jds, "scaleY", 1.0f, 0.7f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jdv, "alpha", 1.0f, 0.0f));
            this.jdy.add(ObjectAnimator.ofFloat(this.jds, "alpha", 1.0f, 0.0f));
        }
    }

    private void clX() {
        int i = 0;
        if (this.jdG.getVisibility() != 0) {
            this.jdG.setVisibility(0);
            clW();
            this.jdv.setEnabled(false);
            this.jds.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jdy.size()) {
                    ObjectAnimator objectAnimator = this.jdy.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdy.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jdz != null) {
                                        VideoControllerLayout.this.jdz.clL();
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
        if (this.jdG.getVisibility() != 8) {
            clW();
            this.jdv.setEnabled(true);
            this.jds.setEnabled(true);
            if (this.jaI.getStatus() == 6 || this.jaI.afw()) {
                this.jds.setVisibility(8);
                this.jdv.setVisibility(8);
            } else {
                AF(this.jaI.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jdy.size()) {
                    ObjectAnimator objectAnimator = this.jdy.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jdy.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jet) {
                                        VideoControllerLayout.this.jdG.setVisibility(8);
                                        if (VideoControllerLayout.this.jdz != null) {
                                            VideoControllerLayout.this.jdz.clM();
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
        this.jdz = aVar;
    }

    public void setCurrentTab(int i) {
        this.fpA = i;
        switch (this.fpA) {
            case 1:
                this.jds.setVisibility(4);
                this.jdv.setVisibility(4);
                this.jdu.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jaI.getStatus() != 1) {
                    this.jds.setVisibility(0);
                    this.jdv.setVisibility(0);
                }
                this.jdu.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean clY() {
        return this.jdG.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jdG != null) {
            this.jdG.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jdG != null) {
            this.jdG.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jdG != null) {
            this.jdG.setDownLoadStrick(stickerItem);
        }
    }

    public boolean clZ() {
        if (this.jdG != null) {
            return this.jdG.clZ();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jdA = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jdC;
    }

    public List<e> getChoosedFilterList() {
        return this.jdD;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jdE;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jdF.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jdG != null) {
            this.jdG.setMusicList(this.jdF);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void p(String str, int i, String str2) {
    }

    public void cma() {
        if (this.jdG != null) {
            this.jdG.cma();
        }
    }

    public void ckO() {
        if (this.jdG != null) {
            this.jdG.ckO();
        }
    }
}
