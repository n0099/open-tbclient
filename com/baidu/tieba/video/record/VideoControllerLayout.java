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
    private int dOV;
    private j hty;
    private AnimatorSet hvy;
    private AnimatorSet hvz;
    private ImageView hwk;
    private RelativeLayout hwl;
    private VideoRecordButton hwm;
    private ImageView hwn;
    private long hwo;
    private boolean hwp;
    private List<ObjectAnimator> hwq;
    private a hwr;
    private boolean hws;
    private boolean hwt;
    private List<e> hwu;
    private List<e> hwv;
    private List<StickerItem> hww;
    private List<e> hwx;
    private VideoEffectLayout hwy;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bCY();

        void bCZ();

        void bDj();

        void bDk();

        void bDl();

        void bDm();

        void bDn();

        void bDo();

        void bDp();

        void bDq();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hwo = 0L;
        this.hwp = false;
        this.hws = true;
        this.hwu = new ArrayList();
        this.hwv = new ArrayList();
        this.hww = new ArrayList();
        this.hwx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwo = 0L;
        this.hwp = false;
        this.hws = true;
        this.hwu = new ArrayList();
        this.hwv = new ArrayList();
        this.hww = new ArrayList();
        this.hwx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwo = 0L;
        this.hwp = false;
        this.hws = true;
        this.hwu = new ArrayList();
        this.hwv = new ArrayList();
        this.hww = new ArrayList();
        this.hwx = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hwy = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hwl = (RelativeLayout) findViewById(d.g.layout_record);
        this.hwk = (ImageView) findViewById(d.g.delete_video);
        this.hwk.setOnClickListener(this);
        this.hwm = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hwm.setOnTouchListener(this);
        this.hwn = (ImageView) findViewById(d.g.confirm_video);
        this.hwn.setOnClickListener(this);
        this.hwx.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hwx.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.hty = jVar;
        wZ(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hwy != null) {
            this.hwy.setListener(aVar);
        }
    }

    public void wZ(int i) {
        this.hty.setStatus(i);
        if (this.hwr != null) {
            this.hwr.bDq();
        }
        if (i == 1) {
            this.hwk.setVisibility(8);
            this.hwn.setVisibility(8);
        } else if (i == 3) {
            this.hwk.setImageResource(d.f.video_back_selector);
            this.hwn.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hwk.setImageResource(d.f.video_back_selector);
            this.hwn.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hwk.setImageResource(d.f.video_delete_selector);
            if (this.hty != null && this.hty.getVideoDuration() >= 3000.0f) {
                this.hwn.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hwn.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hwk) {
            if (this.hwr != null) {
                this.hwr.bDp();
            }
            int status = this.hty.getStatus();
            if (this.hty != null && this.hty.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hty.bCS();
                    dH(this.hwu);
                    dH(this.hwv);
                    dH(this.hww);
                    if (this.hty.getVideoDuration() >= 3000.0f) {
                        wZ(4);
                        return;
                    } else {
                        wZ(this.hty.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hty.bCR();
                wZ(5);
            }
        } else if (view == this.hwn) {
            TiebaStatic.log("c12300");
            if (this.hty != null && this.hty.getStatus() > 2 && this.hwr != null) {
                if (this.hty.getVideoDuration() >= 3000.0f) {
                    this.hwr.bCZ();
                } else {
                    this.hwr.bDo();
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
    public void nl(final boolean z) {
        if (this.hty.getProgress() >= 100) {
            if (this.hwr != null) {
                this.hwr.bCZ();
                return;
            }
            return;
        }
        if (this.hwy.getCurrentBeautyItem() != null) {
            this.hwu.add(this.hwy.getCurrentBeautyItem());
        }
        if (this.hwy.getCurrentFilterItem() != null) {
            this.hwv.add(this.hwy.getCurrentFilterItem());
        }
        if (this.hwy.getCurrentStickItem() != null) {
            this.hww.add(this.hwy.getCurrentStickItem());
        }
        wZ(2);
        if (this.hwy.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hty.getStatus() == 6 || VideoControllerLayout.this.hty.isRecording()) {
                        VideoControllerLayout.this.nm(z);
                    }
                }
            });
        } else {
            nm(z);
        }
        if (this.hty != null) {
            this.hty.startRecord();
        }
        if (this.hwr != null) {
            this.hwr.bDj();
        }
    }

    public void stopRecord() {
        bDv();
        int status = this.hty.getStatus();
        if (this.hty != null) {
            if (this.hty.getStatus() != 6 && this.hty.isRecording()) {
                this.hty.stopRecord();
            }
            if (this.hty.getVideoDuration() >= 3000.0f) {
                wZ(4);
            } else if (this.hty.getVideoDuration() > 0) {
                wZ(3);
            } else {
                wZ(1);
            }
        }
        if (this.hwr != null) {
            this.hwr.bCY();
            if (status == 6) {
                this.hwr.bDl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(boolean z) {
        if (this.hvz != null && this.hvz.isRunning()) {
            this.hvz.cancel();
        }
        if (this.hvy == null) {
            this.hvy = new AnimatorSet();
            this.hvy.playTogether(ObjectAnimator.ofFloat(this.hwk, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwn, "alpha", 1.0f, 0.0f));
            this.hvy.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hxn) {
                        VideoControllerLayout.this.hwk.setVisibility(8);
                        VideoControllerLayout.this.hwn.setVisibility(8);
                    }
                }
            });
            this.hvy.setDuration(300L);
        }
        this.hvy.start();
        if (this.hty.getStatus() != 6) {
            this.hwm.nm(z);
        }
    }

    public void bDv() {
        if (this.hty == null || this.hty.isRecording() || this.hty.getStatus() == 6) {
            if (this.hvy != null && this.hvy.isRunning()) {
                this.hvy.cancel();
            }
            if (this.hvz == null) {
                this.hvz = new AnimatorSet();
                this.hvz.playTogether(ObjectAnimator.ofFloat(this.hwk, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwn, "alpha", 0.0f, 1.0f));
                this.hvz.setDuration(300L);
            }
            this.hwk.setVisibility(0);
            this.hwn.setVisibility(0);
            this.hvz.start();
            if (this.hty.getStatus() != 7 && this.hty.getStatus() != 6) {
                this.hwm.bDv();
                return;
            }
            this.hwm.getTvTip().setVisibility(8);
            if (this.dOV == 2) {
                this.hwm.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dOV) {
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
                if (this.hwr != null) {
                    this.hwr.bDp();
                }
                if (this.hty.getStatus() != 7 && this.hty.getStatus() != 6) {
                    if (this.hty != null && this.hty.bCQ()) {
                        this.hwt = true;
                        com.baidu.tbadk.core.util.e.By().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hwo = currentTimeMillis;
                    this.hwp = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hwp && VideoControllerLayout.this.hwo == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nl(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hwt) {
                    this.hwt = false;
                    return;
                }
                this.hwp = false;
                if (this.hty.isRecording() || this.hty.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hty.getStatus() != 8) {
                    nl(false);
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
                if (this.hty.getStatus() == 6) {
                    this.hty.setStatus(1);
                    if (this.hwr != null) {
                        this.hwr.bDl();
                        this.hwr.bCY();
                    }
                    this.hwm.getTvTip().setText("");
                    this.hwm.getTvTip().setVisibility(8);
                    return;
                } else if (this.hwy.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hwr != null) {
                    this.hwr.bDk();
                    this.hwm.bDG();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hwm.bDH();
                return;
            default:
                return;
        }
    }

    public void bDe() {
        if (this.hwy.getVisibility() == 0) {
            a((o) null);
        }
        nm(false);
        this.hwm.getLayer1().setVisibility(8);
        this.hwm.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hwm.getTvTip().setVisibility(0);
        if (this.hwr != null) {
            this.hwr.bDj();
        }
    }

    public void bDw() {
        if (this.hty.getStatus() == 6) {
            if (this.dOV == 2) {
                wZ(7);
                this.hwm.setAlpha(1.0f);
                this.hwk.setVisibility(8);
                this.hwn.setVisibility(8);
                this.hwm.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.hty != null) {
                    this.hty.startRecord();
                    return;
                }
                return;
            }
            this.hwm.getTvTip().setVisibility(8);
            if (this.hwr != null) {
                this.hwr.bDk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        if (bDz() && this.hwy.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bDz()) {
            bDy();
        }
        this.hwy.bDf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        if (bDz() && this.hwy.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bDz()) {
            bDy();
        }
        this.hwy.bDg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDh() {
        if (bDz() && this.hwy.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bDz()) {
            bDy();
        }
        this.hwy.bDh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDi() {
        if (bDz() && this.hwy.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bDz()) {
            bDy();
        }
        this.hwy.bDi();
    }

    private void bDx() {
        if (v.E(this.hwq)) {
            this.hwq = new ArrayList();
            this.hwq.add(ObjectAnimator.ofFloat(this.hwy, "translationY", 1000.0f, 0.0f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwl, "translationY", 0.0f, com.baidu.adp.lib.util.l.s(getContext(), d.e.ds100)));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwm.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwm.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwm.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwm.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwn, "scaleX", 1.0f, 0.7f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwn, "scaleY", 1.0f, 0.7f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwk, "scaleX", 1.0f, 0.7f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwk, "scaleY", 1.0f, 0.7f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwn, "alpha", 1.0f, 0.0f));
            this.hwq.add(ObjectAnimator.ofFloat(this.hwk, "alpha", 1.0f, 0.0f));
        }
    }

    private void bDy() {
        int i = 0;
        if (this.hwy.getVisibility() != 0) {
            this.hwy.setVisibility(0);
            bDx();
            this.hwn.setEnabled(false);
            this.hwk.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hwq.size()) {
                    ObjectAnimator objectAnimator = this.hwq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hwq.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hwr != null) {
                                        VideoControllerLayout.this.hwr.bDm();
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
        if (this.hwy.getVisibility() != 8) {
            bDx();
            this.hwn.setEnabled(true);
            this.hwk.setEnabled(true);
            if (this.hty.getStatus() == 6 || this.hty.isRecording()) {
                this.hwk.setVisibility(8);
                this.hwn.setVisibility(8);
            } else {
                wZ(this.hty.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hwq.size()) {
                    ObjectAnimator objectAnimator = this.hwq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hwq.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hxn) {
                                        VideoControllerLayout.this.hwy.setVisibility(8);
                                        if (VideoControllerLayout.this.hwr != null) {
                                            VideoControllerLayout.this.hwr.bDn();
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
        this.hwr = aVar;
    }

    public void setCurrentTab(int i) {
        this.dOV = i;
        switch (this.dOV) {
            case 1:
                this.hwk.setVisibility(4);
                this.hwn.setVisibility(4);
                this.hwm.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hty.getStatus() != 1) {
                    this.hwk.setVisibility(0);
                    this.hwn.setVisibility(0);
                }
                this.hwm.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bDz() {
        return this.hwy.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hwy != null) {
            this.hwy.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hwy != null) {
            this.hwy.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hwy != null) {
            this.hwy.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bDA() {
        if (this.hwy != null) {
            return this.hwy.bDA();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hws = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hwu;
    }

    public List<e> getChoosedFilterList() {
        return this.hwv;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hww;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hwx.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hwy != null) {
            this.hwy.setMusicList(this.hwx);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDr() {
        if (this.hwy != null) {
            this.hwy.bDr();
        }
    }

    public void bDB() {
        if (this.hwy != null) {
            this.hwy.bDB();
        }
    }

    public void bCo() {
        if (this.hwy != null) {
            this.hwy.bCo();
        }
    }
}
