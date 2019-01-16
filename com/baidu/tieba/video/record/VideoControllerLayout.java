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
    private int eci;
    private i hKu;
    private AnimatorSet hMu;
    private AnimatorSet hMv;
    private ImageView hNg;
    private RelativeLayout hNh;
    private VideoRecordButton hNi;
    private ImageView hNj;
    private long hNk;
    private boolean hNl;
    private List<ObjectAnimator> hNm;
    private a hNn;
    private boolean hNo;
    private boolean hNp;
    private List<e> hNq;
    private List<e> hNr;
    private List<StickerItem> hNs;
    private List<e> hNt;
    private VideoEffectLayout hNu;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void bLY();

        void bMj();

        void bMk();

        void bMl();

        void bMm();

        void bMn();

        void bMo();

        void bMp();

        void bMq();

        void bMr();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hNk = 0L;
        this.hNl = false;
        this.hNo = true;
        this.hNq = new ArrayList();
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNk = 0L;
        this.hNl = false;
        this.hNo = true;
        this.hNq = new ArrayList();
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNk = 0L;
        this.hNl = false;
        this.hNo = true;
        this.hNq = new ArrayList();
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hNu = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hNh = (RelativeLayout) findViewById(e.g.layout_record);
        this.hNg = (ImageView) findViewById(e.g.delete_video);
        this.hNg.setOnClickListener(this);
        this.hNi = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hNi.setOnTouchListener(this);
        this.hNj = (ImageView) findViewById(e.g.confirm_video);
        this.hNj.setOnClickListener(this);
        this.hNt.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hNt.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hKu = iVar;
        wX(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hNu != null) {
            this.hNu.setListener(aVar);
        }
    }

    public void wX(int i) {
        this.hKu.setStatus(i);
        if (this.hNn != null) {
            this.hNn.bMr();
        }
        if (i == 1) {
            this.hNg.setVisibility(8);
            this.hNj.setVisibility(8);
        } else if (i == 3) {
            this.hNg.setImageResource(e.f.video_back_selector);
            this.hNj.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hNg.setImageResource(e.f.video_back_selector);
            this.hNj.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hNg.setImageResource(e.f.video_delete_selector);
            if (this.hKu != null && this.hKu.getVideoDuration() >= 3000.0f) {
                this.hNj.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hNj.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hNg) {
            if (this.hNn != null) {
                this.hNn.bMq();
            }
            int status = this.hKu.getStatus();
            if (this.hKu != null && this.hKu.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hKu.bLR();
                    ee(this.hNq);
                    ee(this.hNr);
                    ee(this.hNs);
                    if (this.hKu.getVideoDuration() >= 3000.0f) {
                        wX(4);
                        return;
                    } else {
                        wX(this.hKu.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hKu.bLQ();
                wX(5);
            }
        } else if (view == this.hNj) {
            TiebaStatic.log("c12300");
            if (this.hKu != null && this.hKu.getStatus() > 2 && this.hNn != null) {
                if (this.hKu.getVideoDuration() >= 3000.0f) {
                    this.hNn.bMo();
                } else {
                    this.hNn.bMp();
                }
            }
        }
    }

    private void ee(List list) {
        if (!v.I(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final boolean z) {
        if (this.hKu.getProgress() >= 100) {
            if (this.hNn != null) {
                this.hNn.bMo();
                return;
            }
            return;
        }
        if (this.hNu.getCurrentBeautyItem() != null) {
            this.hNq.add(this.hNu.getCurrentBeautyItem());
        }
        if (this.hNu.getCurrentFilterItem() != null) {
            this.hNr.add(this.hNu.getCurrentFilterItem());
        }
        if (this.hNu.getCurrentStickItem() != null) {
            this.hNs.add(this.hNu.getCurrentStickItem());
        }
        wX(2);
        if (this.hNu.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hKu.getStatus() == 6 || VideoControllerLayout.this.hKu.Gf()) {
                        VideoControllerLayout.this.ok(z);
                    }
                }
            });
        } else {
            ok(z);
        }
        if (this.hKu != null) {
            this.hKu.startRecord();
        }
        if (this.hNn != null) {
            this.hNn.bMj();
        }
    }

    public void stopRecord() {
        bMv();
        int status = this.hKu.getStatus();
        if (this.hKu != null) {
            if (!this.hKu.bLS() && this.hKu.Gf()) {
                this.hKu.stopRecord();
            }
            bMu();
        }
        if (this.hNn != null) {
            this.hNn.bLY();
            if (status == 6) {
                this.hNn.bMl();
            }
        }
    }

    public void bMu() {
        if (this.hKu != null) {
            if (this.hKu.getVideoDuration() >= 3000.0f) {
                wX(4);
            } else if (this.hKu.getVideoDuration() > 0) {
                wX(3);
            } else {
                wX(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(boolean z) {
        if (this.hMv != null && this.hMv.isRunning()) {
            this.hMv.cancel();
        }
        if (this.hMu == null) {
            this.hMu = new AnimatorSet();
            this.hMu.playTogether(ObjectAnimator.ofFloat(this.hNg, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hNj, "alpha", 1.0f, 0.0f));
            this.hMu.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOi) {
                        VideoControllerLayout.this.hNg.setVisibility(8);
                        VideoControllerLayout.this.hNj.setVisibility(8);
                    }
                }
            });
            this.hMu.setDuration(300L);
        }
        this.hMu.start();
        if (this.hKu.getStatus() != 6) {
            this.hNi.ok(z);
        }
    }

    public void bMv() {
        if (this.hKu == null || this.hKu.Gf() || this.hKu.getStatus() == 6) {
            if (this.hMu != null && this.hMu.isRunning()) {
                this.hMu.cancel();
            }
            if (this.hMv == null) {
                this.hMv = new AnimatorSet();
                this.hMv.playTogether(ObjectAnimator.ofFloat(this.hNg, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hNj, "alpha", 0.0f, 1.0f));
                this.hMv.setDuration(300L);
            }
            this.hNg.setVisibility(0);
            this.hNj.setVisibility(0);
            this.hMv.start();
            if (this.hKu.getStatus() != 7 && this.hKu.getStatus() != 6) {
                this.hNi.bMv();
                return;
            }
            this.hNi.getTvTip().setVisibility(8);
            if (this.eci == 2) {
                this.hNi.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.eci) {
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
                if (this.hNn != null) {
                    this.hNn.bMq();
                }
                if (this.hKu.getStatus() != 7 && this.hKu.getStatus() != 6) {
                    if (this.hKu != null && this.hKu.bLP()) {
                        this.hNp = true;
                        com.baidu.tbadk.core.util.e.CQ().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hNk = currentTimeMillis;
                    this.hNl = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hNl && VideoControllerLayout.this.hNk == currentTimeMillis) {
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
                if (this.hNp) {
                    this.hNp = false;
                    return;
                }
                this.hNl = false;
                if (this.hKu.Gf() || this.hKu.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hKu.getStatus() != 8) {
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
                if (this.hKu.getStatus() == 6) {
                    this.hKu.setStatus(1);
                    if (this.hNn != null) {
                        this.hNn.bMl();
                        this.hNn.bLY();
                    }
                    this.hNi.getTvTip().setText("");
                    this.hNi.getTvTip().setVisibility(8);
                    return;
                } else if (this.hNu.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hNn != null) {
                    this.hNn.bMk();
                    this.hNi.bMG();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hNi.bMH();
                return;
            default:
                return;
        }
    }

    public void bMe() {
        if (this.hNu.getVisibility() == 0) {
            a((m) null);
        }
        ok(false);
        this.hNi.getLayer1().setVisibility(8);
        this.hNi.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hNi.getTvTip().setVisibility(0);
        if (this.hNn != null) {
            this.hNn.bMj();
        }
    }

    public void bMw() {
        if (this.hKu.getStatus() == 6) {
            if (this.eci == 2) {
                wX(7);
                this.hNi.setAlpha(1.0f);
                this.hNg.setVisibility(8);
                this.hNj.setVisibility(8);
                this.hNi.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hKu != null) {
                    this.hKu.startRecord();
                    return;
                }
                return;
            }
            this.hNi.getTvTip().setVisibility(8);
            if (this.hNn != null) {
                this.hNn.bMk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMf() {
        if (bMz() && this.hNu.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNu.bMf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMg() {
        if (bMz() && this.hNu.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNu.bMg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMh() {
        if (bMz() && this.hNu.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNu.bMh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMi() {
        if (bMz() && this.hNu.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNu.bMi();
    }

    private void bMx() {
        if (v.I(this.hNm)) {
            this.hNm = new ArrayList();
            this.hNm.add(ObjectAnimator.ofFloat(this.hNu, "translationY", 1000.0f, 0.0f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNh, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds100)));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNi.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNi.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNi.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNi.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNj, "scaleX", 1.0f, 0.7f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNj, "scaleY", 1.0f, 0.7f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNg, "scaleX", 1.0f, 0.7f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNg, "scaleY", 1.0f, 0.7f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNj, "alpha", 1.0f, 0.0f));
            this.hNm.add(ObjectAnimator.ofFloat(this.hNg, "alpha", 1.0f, 0.0f));
        }
    }

    private void bMy() {
        int i = 0;
        if (this.hNu.getVisibility() != 0) {
            this.hNu.setVisibility(0);
            bMx();
            this.hNj.setEnabled(false);
            this.hNg.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hNm.size()) {
                    ObjectAnimator objectAnimator = this.hNm.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hNm.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hNn != null) {
                                        VideoControllerLayout.this.hNn.bMm();
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
        if (this.hNu.getVisibility() != 8) {
            bMx();
            this.hNj.setEnabled(true);
            this.hNg.setEnabled(true);
            if (this.hKu.getStatus() == 6 || this.hKu.Gf()) {
                this.hNg.setVisibility(8);
                this.hNj.setVisibility(8);
            } else {
                wX(this.hKu.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hNm.size()) {
                    ObjectAnimator objectAnimator = this.hNm.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hNm.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hOi) {
                                        VideoControllerLayout.this.hNu.setVisibility(8);
                                        if (VideoControllerLayout.this.hNn != null) {
                                            VideoControllerLayout.this.hNn.bMn();
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
        this.hNn = aVar;
    }

    public void setCurrentTab(int i) {
        this.eci = i;
        switch (this.eci) {
            case 1:
                this.hNg.setVisibility(4);
                this.hNj.setVisibility(4);
                this.hNi.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hKu.getStatus() != 1) {
                    this.hNg.setVisibility(0);
                    this.hNj.setVisibility(0);
                }
                this.hNi.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bMz() {
        return this.hNu.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hNu != null) {
            this.hNu.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hNu != null) {
            this.hNu.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hNu != null) {
            this.hNu.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bMA() {
        if (this.hNu != null) {
            return this.hNu.bMA();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hNo = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hNq;
    }

    public List<e> getChoosedFilterList() {
        return this.hNr;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hNs;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hNt.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hNu != null) {
            this.hNu.setMusicList(this.hNt);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bMB() {
        if (this.hNu != null) {
            this.hNu.bMB();
        }
    }

    public void bLp() {
        if (this.hNu != null) {
            this.hNu.bLp();
        }
    }
}
