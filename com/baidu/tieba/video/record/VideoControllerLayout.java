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
    private int dnd;
    private i gRi;
    private ImageView gTS;
    private RelativeLayout gTT;
    private VideoRecordButton gTU;
    private ImageView gTV;
    private long gTW;
    private boolean gTX;
    private List<ObjectAnimator> gTY;
    private a gTZ;
    private AnimatorSet gTg;
    private AnimatorSet gTh;
    private boolean gUa;
    private boolean gUb;
    private List<e> gUc;
    private List<e> gUd;
    private List<StickerItem> gUe;
    private List<e> gUf;
    private VideoEffectLayout gUg;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void byC();

        void byN();

        void byO();

        void byP();

        void byQ();

        void byR();

        void byS();

        void byT();

        void byU();

        void byV();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gTW = 0L;
        this.gTX = false;
        this.gUa = true;
        this.gUc = new ArrayList();
        this.gUd = new ArrayList();
        this.gUe = new ArrayList();
        this.gUf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTW = 0L;
        this.gTX = false;
        this.gUa = true;
        this.gUc = new ArrayList();
        this.gUd = new ArrayList();
        this.gUe = new ArrayList();
        this.gUf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTW = 0L;
        this.gTX = false;
        this.gUa = true;
        this.gUc = new ArrayList();
        this.gUd = new ArrayList();
        this.gUe = new ArrayList();
        this.gUf = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.record_controller_layout, this);
        this.gUg = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gTT = (RelativeLayout) findViewById(d.g.layout_record);
        this.gTS = (ImageView) findViewById(d.g.delete_video);
        this.gTS.setOnClickListener(this);
        this.gTU = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gTU.setOnTouchListener(this);
        this.gTV = (ImageView) findViewById(d.g.confirm_video);
        this.gTV.setOnClickListener(this);
        this.gUf.add(0, new e(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute));
        this.gUf.add(1, new e(3, getResources().getString(d.k.music_cloud), new MusicData("-200", 2, getResources().getString(d.k.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.gRi = iVar;
        uA(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gUg != null) {
            this.gUg.setListener(aVar);
        }
    }

    public void uA(int i) {
        this.gRi.setStatus(i);
        if (this.gTZ != null) {
            this.gTZ.byV();
        }
        if (i == 1) {
            this.gTS.setVisibility(8);
            this.gTV.setVisibility(8);
        } else if (i == 3) {
            this.gTS.setImageResource(d.f.video_back_selector);
            this.gTV.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gTS.setImageResource(d.f.video_back_selector);
            this.gTV.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gTS.setImageResource(d.f.video_delete_selector);
            if (this.gRi != null && this.gRi.getVideoDuration() >= 3000.0f) {
                this.gTV.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gTV.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.gTS) {
            if (this.gTZ != null) {
                this.gTZ.byU();
            }
            int status = this.gRi.getStatus();
            if (this.gRi != null && this.gRi.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gRi.byv();
                    dH(this.gUc);
                    dH(this.gUd);
                    dH(this.gUe);
                    if (this.gRi.getVideoDuration() >= 3000.0f) {
                        uA(4);
                        return;
                    } else {
                        uA(this.gRi.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gRi.byu();
                uA(5);
            }
        } else if (view2 == this.gTV) {
            TiebaStatic.log("c12300");
            if (this.gRi != null && this.gRi.getStatus() > 2 && this.gTZ != null) {
                if (this.gRi.getVideoDuration() >= 3000.0f) {
                    this.gTZ.byS();
                } else {
                    this.gTZ.byT();
                }
            }
        }
    }

    private void dH(List list) {
        if (!v.w(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb(final boolean z) {
        if (this.gRi.getProgress() >= 100) {
            if (this.gTZ != null) {
                this.gTZ.byS();
                return;
            }
            return;
        }
        if (this.gUg.getCurrentBeautyItem() != null) {
            this.gUc.add(this.gUg.getCurrentBeautyItem());
        }
        if (this.gUg.getCurrentFilterItem() != null) {
            this.gUd.add(this.gUg.getCurrentFilterItem());
        }
        if (this.gUg.getCurrentStickItem() != null) {
            this.gUe.add(this.gUg.getCurrentStickItem());
        }
        uA(2);
        if (this.gUg.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gRi.getStatus() == 6 || VideoControllerLayout.this.gRi.isRecording()) {
                        VideoControllerLayout.this.nc(z);
                    }
                }
            });
        } else {
            nc(z);
        }
        if (this.gRi != null) {
            this.gRi.startRecord();
        }
        if (this.gTZ != null) {
            this.gTZ.byN();
        }
    }

    public void stopRecord() {
        byZ();
        int status = this.gRi.getStatus();
        if (this.gRi != null) {
            if (!this.gRi.byw() && this.gRi.isRecording()) {
                this.gRi.stopRecord();
            }
            byY();
        }
        if (this.gTZ != null) {
            this.gTZ.byC();
            if (status == 6) {
                this.gTZ.byP();
            }
        }
    }

    public void byY() {
        if (this.gRi != null) {
            if (this.gRi.getVideoDuration() >= 3000.0f) {
                uA(4);
            } else if (this.gRi.getVideoDuration() > 0) {
                uA(3);
            } else {
                uA(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        if (this.gTh != null && this.gTh.isRunning()) {
            this.gTh.cancel();
        }
        if (this.gTg == null) {
            this.gTg = new AnimatorSet();
            this.gTg.playTogether(ObjectAnimator.ofFloat(this.gTS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gTV, "alpha", 1.0f, 0.0f));
            this.gTg.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gUV) {
                        VideoControllerLayout.this.gTS.setVisibility(8);
                        VideoControllerLayout.this.gTV.setVisibility(8);
                    }
                }
            });
            this.gTg.setDuration(300L);
        }
        this.gTg.start();
        if (this.gRi.getStatus() != 6) {
            this.gTU.nc(z);
        }
    }

    public void byZ() {
        if (this.gRi == null || this.gRi.isRecording() || this.gRi.getStatus() == 6) {
            if (this.gTg != null && this.gTg.isRunning()) {
                this.gTg.cancel();
            }
            if (this.gTh == null) {
                this.gTh = new AnimatorSet();
                this.gTh.playTogether(ObjectAnimator.ofFloat(this.gTS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gTV, "alpha", 0.0f, 1.0f));
                this.gTh.setDuration(300L);
            }
            this.gTS.setVisibility(0);
            this.gTV.setVisibility(0);
            this.gTh.start();
            if (this.gRi.getStatus() != 7 && this.gRi.getStatus() != 6) {
                this.gTU.byZ();
                return;
            }
            this.gTU.getTvTip().setVisibility(8);
            if (this.dnd == 2) {
                this.gTU.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        switch (this.dnd) {
            case 1:
                g(view2, motionEvent);
                return true;
            case 2:
                f(view2, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void f(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gTZ != null) {
                    this.gTZ.byU();
                }
                if (this.gRi.getStatus() != 7 && this.gRi.getStatus() != 6) {
                    if (this.gRi != null && this.gRi.byt()) {
                        this.gUb = true;
                        com.baidu.tbadk.core.util.e.uA().showToast(d.k.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gTW = currentTimeMillis;
                    this.gTX = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gTX && VideoControllerLayout.this.gTW == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nb(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.gUb) {
                    this.gUb = false;
                    return;
                }
                this.gTX = false;
                if (this.gRi.isRecording() || this.gRi.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.gRi.getStatus() != 8) {
                    nb(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void g(View view2, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gRi.getStatus() == 6) {
                    this.gRi.setStatus(1);
                    if (this.gTZ != null) {
                        this.gTZ.byP();
                        this.gTZ.byC();
                    }
                    this.gTU.getTvTip().setText("");
                    this.gTU.getTvTip().setVisibility(8);
                    return;
                } else if (this.gUg.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.gTZ != null) {
                    this.gTZ.byO();
                    this.gTU.bzk();
                    return;
                } else {
                    return;
                }
            case 1:
                this.gTU.bzl();
                return;
            default:
                return;
        }
    }

    public void byI() {
        if (this.gUg.getVisibility() == 0) {
            a((m) null);
        }
        nc(false);
        this.gTU.getLayer1().setVisibility(8);
        this.gTU.getTvTip().setText(getResources().getText(d.k.video_record_button_cancel));
        this.gTU.getTvTip().setVisibility(0);
        if (this.gTZ != null) {
            this.gTZ.byN();
        }
    }

    public void bza() {
        if (this.gRi.getStatus() == 6) {
            if (this.dnd == 2) {
                uA(7);
                this.gTU.setAlpha(1.0f);
                this.gTS.setVisibility(8);
                this.gTV.setVisibility(8);
                this.gTU.getTvTip().setText(getResources().getString(d.k.video_record_button_pasue));
                if (this.gRi != null) {
                    this.gRi.startRecord();
                    return;
                }
                return;
            }
            this.gTU.getTvTip().setVisibility(8);
            if (this.gTZ != null) {
                this.gTZ.byO();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byJ() {
        if (bzd() && this.gUg.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bzd()) {
            bzc();
        }
        this.gUg.byJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byK() {
        if (bzd() && this.gUg.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bzd()) {
            bzc();
        }
        this.gUg.byK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        if (bzd() && this.gUg.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bzd()) {
            bzc();
        }
        this.gUg.byL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        if (bzd() && this.gUg.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bzd()) {
            bzc();
        }
        this.gUg.byM();
    }

    private void bzb() {
        if (v.w(this.gTY)) {
            this.gTY = new ArrayList();
            this.gTY.add(ObjectAnimator.ofFloat(this.gUg, "translationY", 1000.0f, 0.0f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTT, "translationY", 0.0f, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds100)));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTU.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTU.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTU.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTU.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTV, "scaleX", 1.0f, 0.7f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTV, "scaleY", 1.0f, 0.7f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTS, "scaleX", 1.0f, 0.7f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTS, "scaleY", 1.0f, 0.7f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTV, "alpha", 1.0f, 0.0f));
            this.gTY.add(ObjectAnimator.ofFloat(this.gTS, "alpha", 1.0f, 0.0f));
        }
    }

    private void bzc() {
        int i = 0;
        if (this.gUg.getVisibility() != 0) {
            this.gUg.setVisibility(0);
            bzb();
            this.gTV.setEnabled(false);
            this.gTS.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gTY.size()) {
                    ObjectAnimator objectAnimator = this.gTY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gTY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.gTZ != null) {
                                        VideoControllerLayout.this.gTZ.byQ();
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
        if (this.gUg.getVisibility() != 8) {
            bzb();
            this.gTV.setEnabled(true);
            this.gTS.setEnabled(true);
            if (this.gRi.getStatus() == 6 || this.gRi.isRecording()) {
                this.gTS.setVisibility(8);
                this.gTV.setVisibility(8);
            } else {
                uA(this.gRi.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gTY.size()) {
                    ObjectAnimator objectAnimator = this.gTY.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gTY.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.gUV) {
                                        VideoControllerLayout.this.gUg.setVisibility(8);
                                        if (VideoControllerLayout.this.gTZ != null) {
                                            VideoControllerLayout.this.gTZ.byR();
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
        this.gTZ = aVar;
    }

    public void setCurrentTab(int i) {
        this.dnd = i;
        switch (this.dnd) {
            case 1:
                this.gTS.setVisibility(4);
                this.gTV.setVisibility(4);
                this.gTU.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.gRi.getStatus() != 1) {
                    this.gTS.setVisibility(0);
                    this.gTV.setVisibility(0);
                }
                this.gTU.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bzd() {
        return this.gUg.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gUg != null) {
            this.gUg.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gUg != null) {
            this.gUg.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gUg != null) {
            this.gUg.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bze() {
        if (this.gUg != null) {
            return this.gUg.bze();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gUa = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.gUc;
    }

    public List<e> getChoosedFilterList() {
        return this.gUd;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gUe;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gUf.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.gUg != null) {
            this.gUg.setMusicList(this.gUf);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void o(String str, int i, String str2) {
    }

    public void bzf() {
        if (this.gUg != null) {
            this.gUg.bzf();
        }
    }

    public void bxS() {
        if (this.gUg != null) {
            this.gUg.bxS();
        }
    }
}
