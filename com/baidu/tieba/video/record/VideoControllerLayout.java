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
    private j gWr;
    private AnimatorSet gYt;
    private AnimatorSet gYu;
    private ImageView gZf;
    private RelativeLayout gZg;
    private VideoRecordButton gZh;
    private ImageView gZi;
    private long gZj;
    private boolean gZk;
    private List<ObjectAnimator> gZl;
    private a gZm;
    private boolean gZn;
    private List<e> gZo;
    private List<e> gZp;
    private List<StickerItem> gZq;
    private List<e> gZr;
    private VideoEffectLayout gZs;
    private int goF;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDY();

        void bDZ();

        void bEj();

        void bEk();

        void bEl();

        void bEm();

        void bEn();

        void bEo();

        void bEp();

        void bEq();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gZj = 0L;
        this.gZk = false;
        this.gZn = true;
        this.gZo = new ArrayList();
        this.gZp = new ArrayList();
        this.gZq = new ArrayList();
        this.gZr = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZj = 0L;
        this.gZk = false;
        this.gZn = true;
        this.gZo = new ArrayList();
        this.gZp = new ArrayList();
        this.gZq = new ArrayList();
        this.gZr = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZj = 0L;
        this.gZk = false;
        this.gZn = true;
        this.gZo = new ArrayList();
        this.gZp = new ArrayList();
        this.gZq = new ArrayList();
        this.gZr = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.gZs = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gZg = (RelativeLayout) findViewById(d.g.layout_record);
        this.gZf = (ImageView) findViewById(d.g.delete_video);
        this.gZf.setOnClickListener(this);
        this.gZh = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gZh.setOnTouchListener(this);
        this.gZi = (ImageView) findViewById(d.g.confirm_video);
        this.gZi.setOnClickListener(this);
        this.gZr.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.gZr.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.gWr = jVar;
        vH(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gZs != null) {
            this.gZs.setListener(aVar);
        }
    }

    public void vH(int i) {
        this.gWr.setStatus(i);
        if (this.gZm != null) {
            this.gZm.bEq();
        }
        if (i == 1) {
            this.gZf.setVisibility(8);
            this.gZi.setVisibility(8);
        } else if (i == 3) {
            this.gZf.setImageResource(d.f.video_back_selector);
            this.gZi.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gZf.setImageResource(d.f.video_back_selector);
            this.gZi.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gZf.setImageResource(d.f.video_delete_selector);
            if (this.gWr != null && this.gWr.getVideoDuration() >= 3000.0f) {
                this.gZi.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gZi.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZf) {
            if (this.gZm != null) {
                this.gZm.bEp();
            }
            int status = this.gWr.getStatus();
            if (this.gWr != null && this.gWr.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gWr.bDS();
                    dS(this.gZo);
                    dS(this.gZp);
                    dS(this.gZq);
                    if (this.gWr.getVideoDuration() >= 3000.0f) {
                        vH(4);
                        return;
                    } else {
                        vH(this.gWr.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gWr.bDR();
                vH(5);
            }
        } else if (view == this.gZi) {
            TiebaStatic.log("c12300");
            if (this.gWr != null && this.gWr.getStatus() > 2 && this.gZm != null) {
                if (this.gWr.getVideoDuration() >= 3000.0f) {
                    this.gZm.bDZ();
                } else {
                    this.gZm.bEo();
                }
            }
        }
    }

    private void dS(List list) {
        if (!v.w(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(final boolean z) {
        if (this.gWr.getProgress() >= 100) {
            if (this.gZm != null) {
                this.gZm.bDZ();
                return;
            }
            return;
        }
        if (this.gZs.getCurrentBeautyItem() != null) {
            this.gZo.add(this.gZs.getCurrentBeautyItem());
        }
        if (this.gZs.getCurrentFilterItem() != null) {
            this.gZp.add(this.gZs.getCurrentFilterItem());
        }
        if (this.gZs.getCurrentStickItem() != null) {
            this.gZq.add(this.gZs.getCurrentStickItem());
        }
        vH(2);
        if (this.gZs.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gWr.getStatus() == 6 || VideoControllerLayout.this.gWr.isRecording()) {
                        VideoControllerLayout.this.nN(z);
                    }
                }
            });
        } else {
            nN(z);
        }
        if (this.gWr != null) {
            this.gWr.startRecord();
        }
        if (this.gZm != null) {
            this.gZm.bEj();
        }
    }

    public void stopRecord() {
        bEt();
        int status = this.gWr.getStatus();
        if (this.gWr != null) {
            if (this.gWr.getStatus() != 6 && this.gWr.isRecording()) {
                this.gWr.stopRecord();
            }
            if (this.gWr.getVideoDuration() >= 3000.0f) {
                vH(4);
            } else if (this.gWr.getVideoDuration() > 0) {
                vH(3);
            } else {
                vH(1);
            }
        }
        if (this.gZm != null) {
            this.gZm.bDY();
            if (status == 6) {
                this.gZm.bEl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (this.gYu != null && this.gYu.isRunning()) {
            this.gYu.cancel();
        }
        if (this.gYt == null) {
            this.gYt = new AnimatorSet();
            this.gYt.playTogether(ObjectAnimator.ofFloat(this.gZf, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gZi, "alpha", 1.0f, 0.0f));
            this.gYt.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hag) {
                        VideoControllerLayout.this.gZf.setVisibility(8);
                        VideoControllerLayout.this.gZi.setVisibility(8);
                    }
                }
            });
            this.gYt.setDuration(300L);
        }
        this.gYt.start();
        if (this.gWr.getStatus() != 6) {
            this.gZh.nN(z);
        }
    }

    public void bEt() {
        if (this.gWr == null || this.gWr.isRecording() || this.gWr.getStatus() == 6) {
            if (this.gYt != null && this.gYt.isRunning()) {
                this.gYt.cancel();
            }
            if (this.gYu == null) {
                this.gYu = new AnimatorSet();
                this.gYu.playTogether(ObjectAnimator.ofFloat(this.gZf, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gZi, "alpha", 0.0f, 1.0f));
                this.gYu.setDuration(300L);
            }
            this.gZf.setVisibility(0);
            this.gZi.setVisibility(0);
            this.gYu.start();
            if (this.gWr.getStatus() != 7 && this.gWr.getStatus() != 6) {
                this.gZh.bEt();
                return;
            }
            this.gZh.getTvTip().setVisibility(8);
            if (this.goF == 2) {
                this.gZh.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.goF) {
            case 1:
                h(view, motionEvent);
                return true;
            case 2:
                g(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void g(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gZm != null) {
                    this.gZm.bEp();
                }
                if (this.gWr.getStatus() != 7 && this.gWr.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gZj = currentTimeMillis;
                    this.gZk = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gZk && VideoControllerLayout.this.gZj == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nM(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                this.gZk = false;
                if (this.gWr.isRecording() || this.gWr.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                }
                if (this.gZs.getVisibility() == 0) {
                    a((o) null);
                }
                if (this.gWr.getStatus() != 8) {
                    nM(false);
                    return;
                }
                return;
            case 2:
            default:
                return;
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gWr.getStatus() == 6) {
                    this.gWr.setStatus(1);
                    if (this.gZm != null) {
                        this.gZm.bEl();
                        this.gZm.bDY();
                    }
                    this.gZh.getTvTip().setText("");
                    this.gZh.getTvTip().setVisibility(8);
                    return;
                } else if (this.gZs.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.gZm != null) {
                    this.gZm.bEk();
                    this.gZh.bED();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gZh.bEE();
                return;
            default:
                return;
        }
    }

    public void bEe() {
        if (this.gZs.getVisibility() == 0) {
            a((o) null);
        }
        nN(false);
        this.gZh.getLayer1().setVisibility(8);
        this.gZh.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.gZh.getTvTip().setVisibility(0);
        if (this.gZm != null) {
            this.gZm.bEj();
        }
    }

    public void bEu() {
        if (this.gWr.getStatus() == 6) {
            if (this.goF == 2) {
                vH(7);
                this.gZh.setAlpha(1.0f);
                this.gZf.setVisibility(8);
                this.gZi.setVisibility(8);
                this.gZh.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.gWr != null) {
                    this.gWr.startRecord();
                    return;
                }
                return;
            }
            this.gZh.getTvTip().setVisibility(8);
            if (this.gZm != null) {
                this.gZm.bEk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEf() {
        if (bEx() && this.gZs.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bEx()) {
            bEw();
        }
        this.gZs.bEf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEg() {
        if (bEx() && this.gZs.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bEx()) {
            bEw();
        }
        this.gZs.bEg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEh() {
        if (bEx() && this.gZs.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bEx()) {
            bEw();
        }
        this.gZs.bEh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEi() {
        if (bEx() && this.gZs.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bEx()) {
            bEw();
        }
        this.gZs.bEi();
    }

    private void bEv() {
        if (v.w(this.gZl)) {
            this.gZl = new ArrayList();
            this.gZl.add(ObjectAnimator.ofFloat(this.gZs, "translationY", 1000.0f, 0.0f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZg, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZh.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZh.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZh.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZh.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZi, "scaleX", 1.0f, 0.7f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZi, "scaleY", 1.0f, 0.7f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZf, "scaleX", 1.0f, 0.7f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZf, "scaleY", 1.0f, 0.7f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZi, "alpha", 1.0f, 0.0f));
            this.gZl.add(ObjectAnimator.ofFloat(this.gZf, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEw() {
        int i = 0;
        if (this.gZs.getVisibility() != 0) {
            this.gZs.setVisibility(0);
            bEv();
            this.gZi.setEnabled(false);
            this.gZf.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gZl.size()) {
                    ObjectAnimator objectAnimator = this.gZl.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gZl.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gZm != null) {
                                        VideoControllerLayout.this.gZm.bEm();
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
        if (this.gZs.getVisibility() != 8) {
            bEv();
            this.gZi.setEnabled(true);
            this.gZf.setEnabled(true);
            if (this.gWr.getStatus() == 6 || this.gWr.isRecording()) {
                this.gZf.setVisibility(8);
                this.gZi.setVisibility(8);
            } else {
                vH(this.gWr.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gZl.size()) {
                    ObjectAnimator objectAnimator = this.gZl.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gZl.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hag) {
                                        VideoControllerLayout.this.gZs.setVisibility(8);
                                        if (VideoControllerLayout.this.gZm != null) {
                                            VideoControllerLayout.this.gZm.bEn();
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
        this.gZm = aVar;
    }

    public void setCurrentTab(int i) {
        this.goF = i;
        switch (this.goF) {
            case 1:
                this.gZf.setVisibility(4);
                this.gZi.setVisibility(4);
                this.gZh.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gWr.getStatus() != 1) {
                    this.gZf.setVisibility(0);
                    this.gZi.setVisibility(0);
                }
                this.gZh.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEx() {
        return this.gZs.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gZs != null) {
            this.gZs.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gZs != null) {
            this.gZs.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gZs != null) {
            this.gZs.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEy() {
        if (this.gZs != null) {
            return this.gZs.bEy();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gZn = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gZo;
    }

    public List<e> getChoosedFilterList() {
        return this.gZp;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gZq;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gZr.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gZs != null) {
            this.gZs.setMusicList(this.gZr);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bEz() {
        if (this.gZs != null) {
            this.gZs.bEz();
        }
    }

    public void bDp() {
        if (this.gZs != null) {
            this.gZs.bDp();
        }
    }
}
