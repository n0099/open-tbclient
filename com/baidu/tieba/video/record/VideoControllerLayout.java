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
    private int ecj;
    private i hKv;
    private AnimatorSet hMv;
    private AnimatorSet hMw;
    private ImageView hNh;
    private RelativeLayout hNi;
    private VideoRecordButton hNj;
    private ImageView hNk;
    private long hNl;
    private boolean hNm;
    private List<ObjectAnimator> hNn;
    private a hNo;
    private boolean hNp;
    private boolean hNq;
    private List<e> hNr;
    private List<e> hNs;
    private List<StickerItem> hNt;
    private List<e> hNu;
    private VideoEffectLayout hNv;
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
        this.hNl = 0L;
        this.hNm = false;
        this.hNp = true;
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.hNu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hNl = 0L;
        this.hNm = false;
        this.hNp = true;
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.hNu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hNl = 0L;
        this.hNm = false;
        this.hNp = true;
        this.hNr = new ArrayList();
        this.hNs = new ArrayList();
        this.hNt = new ArrayList();
        this.hNu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hNv = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hNi = (RelativeLayout) findViewById(e.g.layout_record);
        this.hNh = (ImageView) findViewById(e.g.delete_video);
        this.hNh.setOnClickListener(this);
        this.hNj = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hNj.setOnTouchListener(this);
        this.hNk = (ImageView) findViewById(e.g.confirm_video);
        this.hNk.setOnClickListener(this);
        this.hNu.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hNu.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hKv = iVar;
        wX(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hNv != null) {
            this.hNv.setListener(aVar);
        }
    }

    public void wX(int i) {
        this.hKv.setStatus(i);
        if (this.hNo != null) {
            this.hNo.bMr();
        }
        if (i == 1) {
            this.hNh.setVisibility(8);
            this.hNk.setVisibility(8);
        } else if (i == 3) {
            this.hNh.setImageResource(e.f.video_back_selector);
            this.hNk.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hNh.setImageResource(e.f.video_back_selector);
            this.hNk.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hNh.setImageResource(e.f.video_delete_selector);
            if (this.hKv != null && this.hKv.getVideoDuration() >= 3000.0f) {
                this.hNk.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hNk.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hNh) {
            if (this.hNo != null) {
                this.hNo.bMq();
            }
            int status = this.hKv.getStatus();
            if (this.hKv != null && this.hKv.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hKv.bLR();
                    ee(this.hNr);
                    ee(this.hNs);
                    ee(this.hNt);
                    if (this.hKv.getVideoDuration() >= 3000.0f) {
                        wX(4);
                        return;
                    } else {
                        wX(this.hKv.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hKv.bLQ();
                wX(5);
            }
        } else if (view == this.hNk) {
            TiebaStatic.log("c12300");
            if (this.hKv != null && this.hKv.getStatus() > 2 && this.hNo != null) {
                if (this.hKv.getVideoDuration() >= 3000.0f) {
                    this.hNo.bMo();
                } else {
                    this.hNo.bMp();
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
        if (this.hKv.getProgress() >= 100) {
            if (this.hNo != null) {
                this.hNo.bMo();
                return;
            }
            return;
        }
        if (this.hNv.getCurrentBeautyItem() != null) {
            this.hNr.add(this.hNv.getCurrentBeautyItem());
        }
        if (this.hNv.getCurrentFilterItem() != null) {
            this.hNs.add(this.hNv.getCurrentFilterItem());
        }
        if (this.hNv.getCurrentStickItem() != null) {
            this.hNt.add(this.hNv.getCurrentStickItem());
        }
        wX(2);
        if (this.hNv.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hKv.getStatus() == 6 || VideoControllerLayout.this.hKv.Gf()) {
                        VideoControllerLayout.this.ok(z);
                    }
                }
            });
        } else {
            ok(z);
        }
        if (this.hKv != null) {
            this.hKv.startRecord();
        }
        if (this.hNo != null) {
            this.hNo.bMj();
        }
    }

    public void stopRecord() {
        bMv();
        int status = this.hKv.getStatus();
        if (this.hKv != null) {
            if (!this.hKv.bLS() && this.hKv.Gf()) {
                this.hKv.stopRecord();
            }
            bMu();
        }
        if (this.hNo != null) {
            this.hNo.bLY();
            if (status == 6) {
                this.hNo.bMl();
            }
        }
    }

    public void bMu() {
        if (this.hKv != null) {
            if (this.hKv.getVideoDuration() >= 3000.0f) {
                wX(4);
            } else if (this.hKv.getVideoDuration() > 0) {
                wX(3);
            } else {
                wX(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(boolean z) {
        if (this.hMw != null && this.hMw.isRunning()) {
            this.hMw.cancel();
        }
        if (this.hMv == null) {
            this.hMv = new AnimatorSet();
            this.hMv.playTogether(ObjectAnimator.ofFloat(this.hNh, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hNk, "alpha", 1.0f, 0.0f));
            this.hMv.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOj) {
                        VideoControllerLayout.this.hNh.setVisibility(8);
                        VideoControllerLayout.this.hNk.setVisibility(8);
                    }
                }
            });
            this.hMv.setDuration(300L);
        }
        this.hMv.start();
        if (this.hKv.getStatus() != 6) {
            this.hNj.ok(z);
        }
    }

    public void bMv() {
        if (this.hKv == null || this.hKv.Gf() || this.hKv.getStatus() == 6) {
            if (this.hMv != null && this.hMv.isRunning()) {
                this.hMv.cancel();
            }
            if (this.hMw == null) {
                this.hMw = new AnimatorSet();
                this.hMw.playTogether(ObjectAnimator.ofFloat(this.hNh, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hNk, "alpha", 0.0f, 1.0f));
                this.hMw.setDuration(300L);
            }
            this.hNh.setVisibility(0);
            this.hNk.setVisibility(0);
            this.hMw.start();
            if (this.hKv.getStatus() != 7 && this.hKv.getStatus() != 6) {
                this.hNj.bMv();
                return;
            }
            this.hNj.getTvTip().setVisibility(8);
            if (this.ecj == 2) {
                this.hNj.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.ecj) {
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
                if (this.hNo != null) {
                    this.hNo.bMq();
                }
                if (this.hKv.getStatus() != 7 && this.hKv.getStatus() != 6) {
                    if (this.hKv != null && this.hKv.bLP()) {
                        this.hNq = true;
                        com.baidu.tbadk.core.util.e.CQ().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hNl = currentTimeMillis;
                    this.hNm = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hNm && VideoControllerLayout.this.hNl == currentTimeMillis) {
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
                if (this.hNq) {
                    this.hNq = false;
                    return;
                }
                this.hNm = false;
                if (this.hKv.Gf() || this.hKv.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hKv.getStatus() != 8) {
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
                if (this.hKv.getStatus() == 6) {
                    this.hKv.setStatus(1);
                    if (this.hNo != null) {
                        this.hNo.bMl();
                        this.hNo.bLY();
                    }
                    this.hNj.getTvTip().setText("");
                    this.hNj.getTvTip().setVisibility(8);
                    return;
                } else if (this.hNv.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hNo != null) {
                    this.hNo.bMk();
                    this.hNj.bMG();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hNj.bMH();
                return;
            default:
                return;
        }
    }

    public void bMe() {
        if (this.hNv.getVisibility() == 0) {
            a((m) null);
        }
        ok(false);
        this.hNj.getLayer1().setVisibility(8);
        this.hNj.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hNj.getTvTip().setVisibility(0);
        if (this.hNo != null) {
            this.hNo.bMj();
        }
    }

    public void bMw() {
        if (this.hKv.getStatus() == 6) {
            if (this.ecj == 2) {
                wX(7);
                this.hNj.setAlpha(1.0f);
                this.hNh.setVisibility(8);
                this.hNk.setVisibility(8);
                this.hNj.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hKv != null) {
                    this.hKv.startRecord();
                    return;
                }
                return;
            }
            this.hNj.getTvTip().setVisibility(8);
            if (this.hNo != null) {
                this.hNo.bMk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMf() {
        if (bMz() && this.hNv.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNv.bMf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMg() {
        if (bMz() && this.hNv.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNv.bMg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMh() {
        if (bMz() && this.hNv.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNv.bMh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMi() {
        if (bMz() && this.hNv.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bMz()) {
            bMy();
        }
        this.hNv.bMi();
    }

    private void bMx() {
        if (v.I(this.hNn)) {
            this.hNn = new ArrayList();
            this.hNn.add(ObjectAnimator.ofFloat(this.hNv, "translationY", 1000.0f, 0.0f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNi, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds100)));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNj.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNj.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNj.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNj.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNk, "scaleX", 1.0f, 0.7f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNk, "scaleY", 1.0f, 0.7f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNh, "scaleX", 1.0f, 0.7f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNh, "scaleY", 1.0f, 0.7f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNk, "alpha", 1.0f, 0.0f));
            this.hNn.add(ObjectAnimator.ofFloat(this.hNh, "alpha", 1.0f, 0.0f));
        }
    }

    private void bMy() {
        int i = 0;
        if (this.hNv.getVisibility() != 0) {
            this.hNv.setVisibility(0);
            bMx();
            this.hNk.setEnabled(false);
            this.hNh.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hNn.size()) {
                    ObjectAnimator objectAnimator = this.hNn.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hNn.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hNo != null) {
                                        VideoControllerLayout.this.hNo.bMm();
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
        if (this.hNv.getVisibility() != 8) {
            bMx();
            this.hNk.setEnabled(true);
            this.hNh.setEnabled(true);
            if (this.hKv.getStatus() == 6 || this.hKv.Gf()) {
                this.hNh.setVisibility(8);
                this.hNk.setVisibility(8);
            } else {
                wX(this.hKv.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hNn.size()) {
                    ObjectAnimator objectAnimator = this.hNn.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hNn.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hOj) {
                                        VideoControllerLayout.this.hNv.setVisibility(8);
                                        if (VideoControllerLayout.this.hNo != null) {
                                            VideoControllerLayout.this.hNo.bMn();
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
        this.hNo = aVar;
    }

    public void setCurrentTab(int i) {
        this.ecj = i;
        switch (this.ecj) {
            case 1:
                this.hNh.setVisibility(4);
                this.hNk.setVisibility(4);
                this.hNj.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hKv.getStatus() != 1) {
                    this.hNh.setVisibility(0);
                    this.hNk.setVisibility(0);
                }
                this.hNj.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bMz() {
        return this.hNv.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hNv != null) {
            this.hNv.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hNv != null) {
            this.hNv.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hNv != null) {
            this.hNv.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bMA() {
        if (this.hNv != null) {
            return this.hNv.bMA();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hNp = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hNr;
    }

    public List<e> getChoosedFilterList() {
        return this.hNs;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hNt;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hNu.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hNv != null) {
            this.hNv.setMusicList(this.hNu);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bMB() {
        if (this.hNv != null) {
            this.hNv.bMB();
        }
    }

    public void bLp() {
        if (this.hNv != null) {
            this.hNv.bLp();
        }
    }
}
