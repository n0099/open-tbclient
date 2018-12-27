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
    private int ebC;
    private i hJn;
    private ImageView hLZ;
    private AnimatorSet hLn;
    private AnimatorSet hLo;
    private RelativeLayout hMa;
    private VideoRecordButton hMb;
    private ImageView hMc;
    private long hMd;
    private boolean hMe;
    private List<ObjectAnimator> hMf;
    private a hMg;
    private boolean hMh;
    private boolean hMi;
    private List<e> hMj;
    private List<e> hMk;
    private List<StickerItem> hMl;
    private List<e> hMm;
    private VideoEffectLayout hMn;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void bLA();

        void bLB();

        void bLC();

        void bLD();

        void bLE();

        void bLF();

        void bLG();

        void bLH();

        void bLI();

        void bLp();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hMd = 0L;
        this.hMe = false;
        this.hMh = true;
        this.hMj = new ArrayList();
        this.hMk = new ArrayList();
        this.hMl = new ArrayList();
        this.hMm = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hMd = 0L;
        this.hMe = false;
        this.hMh = true;
        this.hMj = new ArrayList();
        this.hMk = new ArrayList();
        this.hMl = new ArrayList();
        this.hMm = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMd = 0L;
        this.hMe = false;
        this.hMh = true;
        this.hMj = new ArrayList();
        this.hMk = new ArrayList();
        this.hMl = new ArrayList();
        this.hMm = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hMn = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hMa = (RelativeLayout) findViewById(e.g.layout_record);
        this.hLZ = (ImageView) findViewById(e.g.delete_video);
        this.hLZ.setOnClickListener(this);
        this.hMb = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hMb.setOnTouchListener(this);
        this.hMc = (ImageView) findViewById(e.g.confirm_video);
        this.hMc.setOnClickListener(this);
        this.hMm.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hMm.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hJn = iVar;
        wU(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hMn != null) {
            this.hMn.setListener(aVar);
        }
    }

    public void wU(int i) {
        this.hJn.setStatus(i);
        if (this.hMg != null) {
            this.hMg.bLI();
        }
        if (i == 1) {
            this.hLZ.setVisibility(8);
            this.hMc.setVisibility(8);
        } else if (i == 3) {
            this.hLZ.setImageResource(e.f.video_back_selector);
            this.hMc.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hLZ.setImageResource(e.f.video_back_selector);
            this.hMc.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hLZ.setImageResource(e.f.video_delete_selector);
            if (this.hJn != null && this.hJn.getVideoDuration() >= 3000.0f) {
                this.hMc.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hMc.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hLZ) {
            if (this.hMg != null) {
                this.hMg.bLH();
            }
            int status = this.hJn.getStatus();
            if (this.hJn != null && this.hJn.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hJn.bLi();
                    ed(this.hMj);
                    ed(this.hMk);
                    ed(this.hMl);
                    if (this.hJn.getVideoDuration() >= 3000.0f) {
                        wU(4);
                        return;
                    } else {
                        wU(this.hJn.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hJn.bLh();
                wU(5);
            }
        } else if (view == this.hMc) {
            TiebaStatic.log("c12300");
            if (this.hJn != null && this.hJn.getStatus() > 2 && this.hMg != null) {
                if (this.hJn.getVideoDuration() >= 3000.0f) {
                    this.hMg.bLF();
                } else {
                    this.hMg.bLG();
                }
            }
        }
    }

    private void ed(List list) {
        if (!v.I(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final boolean z) {
        if (this.hJn.getProgress() >= 100) {
            if (this.hMg != null) {
                this.hMg.bLF();
                return;
            }
            return;
        }
        if (this.hMn.getCurrentBeautyItem() != null) {
            this.hMj.add(this.hMn.getCurrentBeautyItem());
        }
        if (this.hMn.getCurrentFilterItem() != null) {
            this.hMk.add(this.hMn.getCurrentFilterItem());
        }
        if (this.hMn.getCurrentStickItem() != null) {
            this.hMl.add(this.hMn.getCurrentStickItem());
        }
        wU(2);
        if (this.hMn.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hJn.getStatus() == 6 || VideoControllerLayout.this.hJn.FS()) {
                        VideoControllerLayout.this.oj(z);
                    }
                }
            });
        } else {
            oj(z);
        }
        if (this.hJn != null) {
            this.hJn.startRecord();
        }
        if (this.hMg != null) {
            this.hMg.bLA();
        }
    }

    public void stopRecord() {
        bLM();
        int status = this.hJn.getStatus();
        if (this.hJn != null) {
            if (!this.hJn.bLj() && this.hJn.FS()) {
                this.hJn.stopRecord();
            }
            bLL();
        }
        if (this.hMg != null) {
            this.hMg.bLp();
            if (status == 6) {
                this.hMg.bLC();
            }
        }
    }

    public void bLL() {
        if (this.hJn != null) {
            if (this.hJn.getVideoDuration() >= 3000.0f) {
                wU(4);
            } else if (this.hJn.getVideoDuration() > 0) {
                wU(3);
            } else {
                wU(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (this.hLo != null && this.hLo.isRunning()) {
            this.hLo.cancel();
        }
        if (this.hLn == null) {
            this.hLn = new AnimatorSet();
            this.hLn.playTogether(ObjectAnimator.ofFloat(this.hLZ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hMc, "alpha", 1.0f, 0.0f));
            this.hLn.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hNb) {
                        VideoControllerLayout.this.hLZ.setVisibility(8);
                        VideoControllerLayout.this.hMc.setVisibility(8);
                    }
                }
            });
            this.hLn.setDuration(300L);
        }
        this.hLn.start();
        if (this.hJn.getStatus() != 6) {
            this.hMb.oj(z);
        }
    }

    public void bLM() {
        if (this.hJn == null || this.hJn.FS() || this.hJn.getStatus() == 6) {
            if (this.hLn != null && this.hLn.isRunning()) {
                this.hLn.cancel();
            }
            if (this.hLo == null) {
                this.hLo = new AnimatorSet();
                this.hLo.playTogether(ObjectAnimator.ofFloat(this.hLZ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hMc, "alpha", 0.0f, 1.0f));
                this.hLo.setDuration(300L);
            }
            this.hLZ.setVisibility(0);
            this.hMc.setVisibility(0);
            this.hLo.start();
            if (this.hJn.getStatus() != 7 && this.hJn.getStatus() != 6) {
                this.hMb.bLM();
                return;
            }
            this.hMb.getTvTip().setVisibility(8);
            if (this.ebC == 2) {
                this.hMb.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.ebC) {
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
                if (this.hMg != null) {
                    this.hMg.bLH();
                }
                if (this.hJn.getStatus() != 7 && this.hJn.getStatus() != 6) {
                    if (this.hJn != null && this.hJn.bLg()) {
                        this.hMi = true;
                        com.baidu.tbadk.core.util.e.CD().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hMd = currentTimeMillis;
                    this.hMe = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hMe && VideoControllerLayout.this.hMd == currentTimeMillis) {
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
                if (this.hMi) {
                    this.hMi = false;
                    return;
                }
                this.hMe = false;
                if (this.hJn.FS() || this.hJn.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hJn.getStatus() != 8) {
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
                if (this.hJn.getStatus() == 6) {
                    this.hJn.setStatus(1);
                    if (this.hMg != null) {
                        this.hMg.bLC();
                        this.hMg.bLp();
                    }
                    this.hMb.getTvTip().setText("");
                    this.hMb.getTvTip().setVisibility(8);
                    return;
                } else if (this.hMn.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hMg != null) {
                    this.hMg.bLB();
                    this.hMb.bLX();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hMb.bLY();
                return;
            default:
                return;
        }
    }

    public void bLv() {
        if (this.hMn.getVisibility() == 0) {
            a((m) null);
        }
        oj(false);
        this.hMb.getLayer1().setVisibility(8);
        this.hMb.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hMb.getTvTip().setVisibility(0);
        if (this.hMg != null) {
            this.hMg.bLA();
        }
    }

    public void bLN() {
        if (this.hJn.getStatus() == 6) {
            if (this.ebC == 2) {
                wU(7);
                this.hMb.setAlpha(1.0f);
                this.hLZ.setVisibility(8);
                this.hMc.setVisibility(8);
                this.hMb.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hJn != null) {
                    this.hJn.startRecord();
                    return;
                }
                return;
            }
            this.hMb.getTvTip().setVisibility(8);
            if (this.hMg != null) {
                this.hMg.bLB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLw() {
        if (bLQ() && this.hMn.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bLQ()) {
            bLP();
        }
        this.hMn.bLw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLx() {
        if (bLQ() && this.hMn.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bLQ()) {
            bLP();
        }
        this.hMn.bLx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLy() {
        if (bLQ() && this.hMn.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bLQ()) {
            bLP();
        }
        this.hMn.bLy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLz() {
        if (bLQ() && this.hMn.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bLQ()) {
            bLP();
        }
        this.hMn.bLz();
    }

    private void bLO() {
        if (v.I(this.hMf)) {
            this.hMf = new ArrayList();
            this.hMf.add(ObjectAnimator.ofFloat(this.hMn, "translationY", 1000.0f, 0.0f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMa, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds100)));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMb.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMb.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMb.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMb.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMc, "scaleX", 1.0f, 0.7f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMc, "scaleY", 1.0f, 0.7f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hLZ, "scaleX", 1.0f, 0.7f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hLZ, "scaleY", 1.0f, 0.7f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hMc, "alpha", 1.0f, 0.0f));
            this.hMf.add(ObjectAnimator.ofFloat(this.hLZ, "alpha", 1.0f, 0.0f));
        }
    }

    private void bLP() {
        int i = 0;
        if (this.hMn.getVisibility() != 0) {
            this.hMn.setVisibility(0);
            bLO();
            this.hMc.setEnabled(false);
            this.hLZ.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hMf.size()) {
                    ObjectAnimator objectAnimator = this.hMf.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hMf.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hMg != null) {
                                        VideoControllerLayout.this.hMg.bLD();
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
        if (this.hMn.getVisibility() != 8) {
            bLO();
            this.hMc.setEnabled(true);
            this.hLZ.setEnabled(true);
            if (this.hJn.getStatus() == 6 || this.hJn.FS()) {
                this.hLZ.setVisibility(8);
                this.hMc.setVisibility(8);
            } else {
                wU(this.hJn.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hMf.size()) {
                    ObjectAnimator objectAnimator = this.hMf.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hMf.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hNb) {
                                        VideoControllerLayout.this.hMn.setVisibility(8);
                                        if (VideoControllerLayout.this.hMg != null) {
                                            VideoControllerLayout.this.hMg.bLE();
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
        this.hMg = aVar;
    }

    public void setCurrentTab(int i) {
        this.ebC = i;
        switch (this.ebC) {
            case 1:
                this.hLZ.setVisibility(4);
                this.hMc.setVisibility(4);
                this.hMb.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hJn.getStatus() != 1) {
                    this.hLZ.setVisibility(0);
                    this.hMc.setVisibility(0);
                }
                this.hMb.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bLQ() {
        return this.hMn.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hMn != null) {
            this.hMn.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hMn != null) {
            this.hMn.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hMn != null) {
            this.hMn.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bLR() {
        if (this.hMn != null) {
            return this.hMn.bLR();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hMh = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hMj;
    }

    public List<e> getChoosedFilterList() {
        return this.hMk;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hMl;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hMm.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hMn != null) {
            this.hMn.setMusicList(this.hMm);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bLS() {
        if (this.hMn != null) {
            this.hMn.bLS();
        }
    }

    public void bKG() {
        if (this.hMn != null) {
            this.hMn.bKG();
        }
    }
}
