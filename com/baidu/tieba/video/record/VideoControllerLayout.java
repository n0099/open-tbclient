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
    private j gWw;
    private AnimatorSet gYy;
    private AnimatorSet gYz;
    private ImageView gZk;
    private RelativeLayout gZl;
    private VideoRecordButton gZm;
    private ImageView gZn;
    private long gZo;
    private boolean gZp;
    private List<ObjectAnimator> gZq;
    private a gZr;
    private boolean gZs;
    private List<e> gZt;
    private List<e> gZu;
    private List<StickerItem> gZv;
    private List<e> gZw;
    private VideoEffectLayout gZx;
    private int goK;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDZ();

        void bEa();

        void bEk();

        void bEl();

        void bEm();

        void bEn();

        void bEo();

        void bEp();

        void bEq();

        void bEr();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gZo = 0L;
        this.gZp = false;
        this.gZs = true;
        this.gZt = new ArrayList();
        this.gZu = new ArrayList();
        this.gZv = new ArrayList();
        this.gZw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZo = 0L;
        this.gZp = false;
        this.gZs = true;
        this.gZt = new ArrayList();
        this.gZu = new ArrayList();
        this.gZv = new ArrayList();
        this.gZw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZo = 0L;
        this.gZp = false;
        this.gZs = true;
        this.gZt = new ArrayList();
        this.gZu = new ArrayList();
        this.gZv = new ArrayList();
        this.gZw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.gZx = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gZl = (RelativeLayout) findViewById(d.g.layout_record);
        this.gZk = (ImageView) findViewById(d.g.delete_video);
        this.gZk.setOnClickListener(this);
        this.gZm = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gZm.setOnTouchListener(this);
        this.gZn = (ImageView) findViewById(d.g.confirm_video);
        this.gZn.setOnClickListener(this);
        this.gZw.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.gZw.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.gWw = jVar;
        vH(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gZx != null) {
            this.gZx.setListener(aVar);
        }
    }

    public void vH(int i) {
        this.gWw.setStatus(i);
        if (this.gZr != null) {
            this.gZr.bEr();
        }
        if (i == 1) {
            this.gZk.setVisibility(8);
            this.gZn.setVisibility(8);
        } else if (i == 3) {
            this.gZk.setImageResource(d.f.video_back_selector);
            this.gZn.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gZk.setImageResource(d.f.video_back_selector);
            this.gZn.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gZk.setImageResource(d.f.video_delete_selector);
            if (this.gWw != null && this.gWw.getVideoDuration() >= 3000.0f) {
                this.gZn.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gZn.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gZk) {
            if (this.gZr != null) {
                this.gZr.bEq();
            }
            int status = this.gWw.getStatus();
            if (this.gWw != null && this.gWw.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gWw.bDT();
                    dS(this.gZt);
                    dS(this.gZu);
                    dS(this.gZv);
                    if (this.gWw.getVideoDuration() >= 3000.0f) {
                        vH(4);
                        return;
                    } else {
                        vH(this.gWw.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gWw.bDS();
                vH(5);
            }
        } else if (view == this.gZn) {
            TiebaStatic.log("c12300");
            if (this.gWw != null && this.gWw.getStatus() > 2 && this.gZr != null) {
                if (this.gWw.getVideoDuration() >= 3000.0f) {
                    this.gZr.bEa();
                } else {
                    this.gZr.bEp();
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
        if (this.gWw.getProgress() >= 100) {
            if (this.gZr != null) {
                this.gZr.bEa();
                return;
            }
            return;
        }
        if (this.gZx.getCurrentBeautyItem() != null) {
            this.gZt.add(this.gZx.getCurrentBeautyItem());
        }
        if (this.gZx.getCurrentFilterItem() != null) {
            this.gZu.add(this.gZx.getCurrentFilterItem());
        }
        if (this.gZx.getCurrentStickItem() != null) {
            this.gZv.add(this.gZx.getCurrentStickItem());
        }
        vH(2);
        if (this.gZx.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gWw.getStatus() == 6 || VideoControllerLayout.this.gWw.isRecording()) {
                        VideoControllerLayout.this.nN(z);
                    }
                }
            });
        } else {
            nN(z);
        }
        if (this.gWw != null) {
            this.gWw.startRecord();
        }
        if (this.gZr != null) {
            this.gZr.bEk();
        }
    }

    public void stopRecord() {
        bEu();
        int status = this.gWw.getStatus();
        if (this.gWw != null) {
            if (this.gWw.getStatus() != 6 && this.gWw.isRecording()) {
                this.gWw.stopRecord();
            }
            if (this.gWw.getVideoDuration() >= 3000.0f) {
                vH(4);
            } else if (this.gWw.getVideoDuration() > 0) {
                vH(3);
            } else {
                vH(1);
            }
        }
        if (this.gZr != null) {
            this.gZr.bDZ();
            if (status == 6) {
                this.gZr.bEm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (this.gYz != null && this.gYz.isRunning()) {
            this.gYz.cancel();
        }
        if (this.gYy == null) {
            this.gYy = new AnimatorSet();
            this.gYy.playTogether(ObjectAnimator.ofFloat(this.gZk, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gZn, "alpha", 1.0f, 0.0f));
            this.gYy.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hal) {
                        VideoControllerLayout.this.gZk.setVisibility(8);
                        VideoControllerLayout.this.gZn.setVisibility(8);
                    }
                }
            });
            this.gYy.setDuration(300L);
        }
        this.gYy.start();
        if (this.gWw.getStatus() != 6) {
            this.gZm.nN(z);
        }
    }

    public void bEu() {
        if (this.gWw == null || this.gWw.isRecording() || this.gWw.getStatus() == 6) {
            if (this.gYy != null && this.gYy.isRunning()) {
                this.gYy.cancel();
            }
            if (this.gYz == null) {
                this.gYz = new AnimatorSet();
                this.gYz.playTogether(ObjectAnimator.ofFloat(this.gZk, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gZn, "alpha", 0.0f, 1.0f));
                this.gYz.setDuration(300L);
            }
            this.gZk.setVisibility(0);
            this.gZn.setVisibility(0);
            this.gYz.start();
            if (this.gWw.getStatus() != 7 && this.gWw.getStatus() != 6) {
                this.gZm.bEu();
                return;
            }
            this.gZm.getTvTip().setVisibility(8);
            if (this.goK == 2) {
                this.gZm.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.goK) {
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
                if (this.gZr != null) {
                    this.gZr.bEq();
                }
                if (this.gWw.getStatus() != 7 && this.gWw.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gZo = currentTimeMillis;
                    this.gZp = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gZp && VideoControllerLayout.this.gZo == currentTimeMillis) {
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
                this.gZp = false;
                if (this.gWw.isRecording() || this.gWw.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                }
                if (this.gZx.getVisibility() == 0) {
                    a((o) null);
                }
                if (this.gWw.getStatus() != 8) {
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
                if (this.gWw.getStatus() == 6) {
                    this.gWw.setStatus(1);
                    if (this.gZr != null) {
                        this.gZr.bEm();
                        this.gZr.bDZ();
                    }
                    this.gZm.getTvTip().setText("");
                    this.gZm.getTvTip().setVisibility(8);
                    return;
                } else if (this.gZx.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.gZr != null) {
                    this.gZr.bEl();
                    this.gZm.bEE();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gZm.bEF();
                return;
            default:
                return;
        }
    }

    public void bEf() {
        if (this.gZx.getVisibility() == 0) {
            a((o) null);
        }
        nN(false);
        this.gZm.getLayer1().setVisibility(8);
        this.gZm.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.gZm.getTvTip().setVisibility(0);
        if (this.gZr != null) {
            this.gZr.bEk();
        }
    }

    public void bEv() {
        if (this.gWw.getStatus() == 6) {
            if (this.goK == 2) {
                vH(7);
                this.gZm.setAlpha(1.0f);
                this.gZk.setVisibility(8);
                this.gZn.setVisibility(8);
                this.gZm.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.gWw != null) {
                    this.gWw.startRecord();
                    return;
                }
                return;
            }
            this.gZm.getTvTip().setVisibility(8);
            if (this.gZr != null) {
                this.gZr.bEl();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEg() {
        if (bEy() && this.gZx.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bEy()) {
            bEx();
        }
        this.gZx.bEg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEh() {
        if (bEy() && this.gZx.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bEy()) {
            bEx();
        }
        this.gZx.bEh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEi() {
        if (bEy() && this.gZx.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bEy()) {
            bEx();
        }
        this.gZx.bEi();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEj() {
        if (bEy() && this.gZx.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bEy()) {
            bEx();
        }
        this.gZx.bEj();
    }

    private void bEw() {
        if (v.w(this.gZq)) {
            this.gZq = new ArrayList();
            this.gZq.add(ObjectAnimator.ofFloat(this.gZx, "translationY", 1000.0f, 0.0f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZl, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZm.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZm.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZm.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZm.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZn, "scaleX", 1.0f, 0.7f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZn, "scaleY", 1.0f, 0.7f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZk, "scaleX", 1.0f, 0.7f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZk, "scaleY", 1.0f, 0.7f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZn, "alpha", 1.0f, 0.0f));
            this.gZq.add(ObjectAnimator.ofFloat(this.gZk, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEx() {
        int i = 0;
        if (this.gZx.getVisibility() != 0) {
            this.gZx.setVisibility(0);
            bEw();
            this.gZn.setEnabled(false);
            this.gZk.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gZq.size()) {
                    ObjectAnimator objectAnimator = this.gZq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gZq.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gZr != null) {
                                        VideoControllerLayout.this.gZr.bEn();
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
        if (this.gZx.getVisibility() != 8) {
            bEw();
            this.gZn.setEnabled(true);
            this.gZk.setEnabled(true);
            if (this.gWw.getStatus() == 6 || this.gWw.isRecording()) {
                this.gZk.setVisibility(8);
                this.gZn.setVisibility(8);
            } else {
                vH(this.gWw.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gZq.size()) {
                    ObjectAnimator objectAnimator = this.gZq.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gZq.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hal) {
                                        VideoControllerLayout.this.gZx.setVisibility(8);
                                        if (VideoControllerLayout.this.gZr != null) {
                                            VideoControllerLayout.this.gZr.bEo();
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
        this.gZr = aVar;
    }

    public void setCurrentTab(int i) {
        this.goK = i;
        switch (this.goK) {
            case 1:
                this.gZk.setVisibility(4);
                this.gZn.setVisibility(4);
                this.gZm.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gWw.getStatus() != 1) {
                    this.gZk.setVisibility(0);
                    this.gZn.setVisibility(0);
                }
                this.gZm.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEy() {
        return this.gZx.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gZx != null) {
            this.gZx.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gZx != null) {
            this.gZx.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gZx != null) {
            this.gZx.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEz() {
        if (this.gZx != null) {
            return this.gZx.bEz();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gZs = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gZt;
    }

    public List<e> getChoosedFilterList() {
        return this.gZu;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gZv;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gZw.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gZx != null) {
            this.gZx.setMusicList(this.gZw);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bEA() {
        if (this.gZx != null) {
            this.gZx.bEA();
        }
    }

    public void bDq() {
        if (this.gZx != null) {
            this.gZx.bDq();
        }
    }
}
