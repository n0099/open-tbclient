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
    private int dRM;
    private j huA;
    private AnimatorSet hwA;
    private AnimatorSet hwz;
    private ImageView hxl;
    private RelativeLayout hxm;
    private VideoRecordButton hxn;
    private ImageView hxo;
    private long hxp;
    private boolean hxq;
    private List<ObjectAnimator> hxr;
    private a hxs;
    private boolean hxt;
    private boolean hxu;
    private List<e> hxv;
    private List<e> hxw;
    private List<StickerItem> hxx;
    private List<e> hxy;
    private VideoEffectLayout hxz;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDF();

        void bDG();

        void bDQ();

        void bDR();

        void bDS();

        void bDT();

        void bDU();

        void bDV();

        void bDW();

        void bDX();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hxp = 0L;
        this.hxq = false;
        this.hxt = true;
        this.hxv = new ArrayList();
        this.hxw = new ArrayList();
        this.hxx = new ArrayList();
        this.hxy = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxp = 0L;
        this.hxq = false;
        this.hxt = true;
        this.hxv = new ArrayList();
        this.hxw = new ArrayList();
        this.hxx = new ArrayList();
        this.hxy = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxp = 0L;
        this.hxq = false;
        this.hxt = true;
        this.hxv = new ArrayList();
        this.hxw = new ArrayList();
        this.hxx = new ArrayList();
        this.hxy = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hxz = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hxm = (RelativeLayout) findViewById(d.g.layout_record);
        this.hxl = (ImageView) findViewById(d.g.delete_video);
        this.hxl.setOnClickListener(this);
        this.hxn = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hxn.setOnTouchListener(this);
        this.hxo = (ImageView) findViewById(d.g.confirm_video);
        this.hxo.setOnClickListener(this);
        this.hxy.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hxy.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.huA = jVar;
        wZ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hxz != null) {
            this.hxz.setListener(aVar);
        }
    }

    public void wZ(int i) {
        this.huA.setStatus(i);
        if (this.hxs != null) {
            this.hxs.bDX();
        }
        if (i == 1) {
            this.hxl.setVisibility(8);
            this.hxo.setVisibility(8);
        } else if (i == 3) {
            this.hxl.setImageResource(d.f.video_back_selector);
            this.hxo.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hxl.setImageResource(d.f.video_back_selector);
            this.hxo.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hxl.setImageResource(d.f.video_delete_selector);
            if (this.huA != null && this.huA.getVideoDuration() >= 3000.0f) {
                this.hxo.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hxo.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hxl) {
            if (this.hxs != null) {
                this.hxs.bDW();
            }
            int status = this.huA.getStatus();
            if (this.huA != null && this.huA.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.huA.bDz();
                    dN(this.hxv);
                    dN(this.hxw);
                    dN(this.hxx);
                    if (this.huA.getVideoDuration() >= 3000.0f) {
                        wZ(4);
                        return;
                    } else {
                        wZ(this.huA.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.huA.bDy();
                wZ(5);
            }
        } else if (view == this.hxo) {
            TiebaStatic.log("c12300");
            if (this.huA != null && this.huA.getStatus() > 2 && this.hxs != null) {
                if (this.huA.getVideoDuration() >= 3000.0f) {
                    this.hxs.bDG();
                } else {
                    this.hxs.bDV();
                }
            }
        }
    }

    private void dN(List list) {
        if (!v.E(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(final boolean z) {
        if (this.huA.getProgress() >= 100) {
            if (this.hxs != null) {
                this.hxs.bDG();
                return;
            }
            return;
        }
        if (this.hxz.getCurrentBeautyItem() != null) {
            this.hxv.add(this.hxz.getCurrentBeautyItem());
        }
        if (this.hxz.getCurrentFilterItem() != null) {
            this.hxw.add(this.hxz.getCurrentFilterItem());
        }
        if (this.hxz.getCurrentStickItem() != null) {
            this.hxx.add(this.hxz.getCurrentStickItem());
        }
        wZ(2);
        if (this.hxz.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.huA.getStatus() == 6 || VideoControllerLayout.this.huA.isRecording()) {
                        VideoControllerLayout.this.nu(z);
                    }
                }
            });
        } else {
            nu(z);
        }
        if (this.huA != null) {
            this.huA.startRecord();
        }
        if (this.hxs != null) {
            this.hxs.bDQ();
        }
    }

    public void stopRecord() {
        bEc();
        int status = this.huA.getStatus();
        if (this.huA != null) {
            if (this.huA.getStatus() != 6 && this.huA.isRecording()) {
                this.huA.stopRecord();
            }
            if (this.huA.getVideoDuration() >= 3000.0f) {
                wZ(4);
            } else if (this.huA.getVideoDuration() > 0) {
                wZ(3);
            } else {
                wZ(1);
            }
        }
        if (this.hxs != null) {
            this.hxs.bDF();
            if (status == 6) {
                this.hxs.bDS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(boolean z) {
        if (this.hwA != null && this.hwA.isRunning()) {
            this.hwA.cancel();
        }
        if (this.hwz == null) {
            this.hwz = new AnimatorSet();
            this.hwz.playTogether(ObjectAnimator.ofFloat(this.hxl, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hxo, "alpha", 1.0f, 0.0f));
            this.hwz.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyo) {
                        VideoControllerLayout.this.hxl.setVisibility(8);
                        VideoControllerLayout.this.hxo.setVisibility(8);
                    }
                }
            });
            this.hwz.setDuration(300L);
        }
        this.hwz.start();
        if (this.huA.getStatus() != 6) {
            this.hxn.nu(z);
        }
    }

    public void bEc() {
        if (this.huA == null || this.huA.isRecording() || this.huA.getStatus() == 6) {
            if (this.hwz != null && this.hwz.isRunning()) {
                this.hwz.cancel();
            }
            if (this.hwA == null) {
                this.hwA = new AnimatorSet();
                this.hwA.playTogether(ObjectAnimator.ofFloat(this.hxl, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hxo, "alpha", 0.0f, 1.0f));
                this.hwA.setDuration(300L);
            }
            this.hxl.setVisibility(0);
            this.hxo.setVisibility(0);
            this.hwA.start();
            if (this.huA.getStatus() != 7 && this.huA.getStatus() != 6) {
                this.hxn.bEc();
                return;
            }
            this.hxn.getTvTip().setVisibility(8);
            if (this.dRM == 2) {
                this.hxn.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dRM) {
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
                if (this.hxs != null) {
                    this.hxs.bDW();
                }
                if (this.huA.getStatus() != 7 && this.huA.getStatus() != 6) {
                    if (this.huA != null && this.huA.bDx()) {
                        this.hxu = true;
                        com.baidu.tbadk.core.util.e.BQ().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hxp = currentTimeMillis;
                    this.hxq = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hxq && VideoControllerLayout.this.hxp == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nt(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hxu) {
                    this.hxu = false;
                    return;
                }
                this.hxq = false;
                if (this.huA.isRecording() || this.huA.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.huA.getStatus() != 8) {
                    nt(false);
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
                if (this.huA.getStatus() == 6) {
                    this.huA.setStatus(1);
                    if (this.hxs != null) {
                        this.hxs.bDS();
                        this.hxs.bDF();
                    }
                    this.hxn.getTvTip().setText("");
                    this.hxn.getTvTip().setVisibility(8);
                    return;
                } else if (this.hxz.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hxs != null) {
                    this.hxs.bDR();
                    this.hxn.bEn();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hxn.bEo();
                return;
            default:
                return;
        }
    }

    public void bDL() {
        if (this.hxz.getVisibility() == 0) {
            a((o) null);
        }
        nu(false);
        this.hxn.getLayer1().setVisibility(8);
        this.hxn.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hxn.getTvTip().setVisibility(0);
        if (this.hxs != null) {
            this.hxs.bDQ();
        }
    }

    public void bEd() {
        if (this.huA.getStatus() == 6) {
            if (this.dRM == 2) {
                wZ(7);
                this.hxn.setAlpha(1.0f);
                this.hxl.setVisibility(8);
                this.hxo.setVisibility(8);
                this.hxn.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.huA != null) {
                    this.huA.startRecord();
                    return;
                }
                return;
            }
            this.hxn.getTvTip().setVisibility(8);
            if (this.hxs != null) {
                this.hxs.bDR();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDM() {
        if (bEg() && this.hxz.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bEg()) {
            bEf();
        }
        this.hxz.bDM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        if (bEg() && this.hxz.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bEg()) {
            bEf();
        }
        this.hxz.bDN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        if (bEg() && this.hxz.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bEg()) {
            bEf();
        }
        this.hxz.bDO();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        if (bEg() && this.hxz.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bEg()) {
            bEf();
        }
        this.hxz.bDP();
    }

    private void bEe() {
        if (v.E(this.hxr)) {
            this.hxr = new ArrayList();
            this.hxr.add(ObjectAnimator.ofFloat(this.hxz, "translationY", 1000.0f, 0.0f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxm, "translationY", 0.0f, com.baidu.adp.lib.util.l.t(getContext(), d.e.ds100)));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxn.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxn.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxn.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxn.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxo, "scaleX", 1.0f, 0.7f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxo, "scaleY", 1.0f, 0.7f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxl, "scaleX", 1.0f, 0.7f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxl, "scaleY", 1.0f, 0.7f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxo, "alpha", 1.0f, 0.0f));
            this.hxr.add(ObjectAnimator.ofFloat(this.hxl, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEf() {
        int i = 0;
        if (this.hxz.getVisibility() != 0) {
            this.hxz.setVisibility(0);
            bEe();
            this.hxo.setEnabled(false);
            this.hxl.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hxr.size()) {
                    ObjectAnimator objectAnimator = this.hxr.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxr.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hxs != null) {
                                        VideoControllerLayout.this.hxs.bDT();
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
        if (this.hxz.getVisibility() != 8) {
            bEe();
            this.hxo.setEnabled(true);
            this.hxl.setEnabled(true);
            if (this.huA.getStatus() == 6 || this.huA.isRecording()) {
                this.hxl.setVisibility(8);
                this.hxo.setVisibility(8);
            } else {
                wZ(this.huA.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hxr.size()) {
                    ObjectAnimator objectAnimator = this.hxr.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxr.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hyo) {
                                        VideoControllerLayout.this.hxz.setVisibility(8);
                                        if (VideoControllerLayout.this.hxs != null) {
                                            VideoControllerLayout.this.hxs.bDU();
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
        this.hxs = aVar;
    }

    public void setCurrentTab(int i) {
        this.dRM = i;
        switch (this.dRM) {
            case 1:
                this.hxl.setVisibility(4);
                this.hxo.setVisibility(4);
                this.hxn.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.huA.getStatus() != 1) {
                    this.hxl.setVisibility(0);
                    this.hxo.setVisibility(0);
                }
                this.hxn.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEg() {
        return this.hxz.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hxz != null) {
            this.hxz.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hxz != null) {
            this.hxz.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hxz != null) {
            this.hxz.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEh() {
        if (this.hxz != null) {
            return this.hxz.bEh();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hxt = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hxv;
    }

    public List<e> getChoosedFilterList() {
        return this.hxw;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hxx;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hxy.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hxz != null) {
            this.hxz.setMusicList(this.hxy);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDY() {
        if (this.hxz != null) {
            this.hxz.bDY();
        }
    }

    public void bEi() {
        if (this.hxz != null) {
            this.hxz.bEi();
        }
    }

    public void bCW() {
        if (this.hxz != null) {
            this.hxz.bCW();
        }
    }
}
