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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int fFW;
    private i jtD;
    private AnimatorSet jvA;
    private AnimatorSet jvB;
    private VideoEffectLayout jwA;
    private ImageView jwm;
    private RelativeLayout jwn;
    private VideoRecordButton jwo;
    private ImageView jwp;
    private long jwq;
    private boolean jwr;
    private List<ObjectAnimator> jws;
    private a jwt;
    private boolean jwu;
    private boolean jwv;
    private List<e> jww;
    private List<e> jwx;
    private List<StickerItem> jwy;
    private List<e> jwz;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void ctA();

        void ctL();

        void ctM();

        void ctN();

        void ctO();

        void ctP();

        void ctQ();

        void ctR();

        void ctS();

        void ctT();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jwq = 0L;
        this.jwr = false;
        this.jwu = true;
        this.jww = new ArrayList();
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwq = 0L;
        this.jwr = false;
        this.jwu = true;
        this.jww = new ArrayList();
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwq = 0L;
        this.jwr = false;
        this.jwu = true;
        this.jww = new ArrayList();
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jwA = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jwn = (RelativeLayout) findViewById(R.id.layout_record);
        this.jwm = (ImageView) findViewById(R.id.delete_video);
        this.jwm.setOnClickListener(this);
        this.jwo = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jwo.setOnTouchListener(this);
        this.jwp = (ImageView) findViewById(R.id.confirm_video);
        this.jwp.setOnClickListener(this);
        this.jwz.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jwz.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jtD = iVar;
        BN(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jwA != null) {
            this.jwA.setListener(aVar);
        }
    }

    public void BN(int i) {
        this.jtD.setStatus(i);
        if (this.jwt != null) {
            this.jwt.ctT();
        }
        if (i == 1) {
            this.jwm.setVisibility(8);
            this.jwp.setVisibility(8);
        } else if (i == 3) {
            this.jwm.setImageResource(R.drawable.video_back_selector);
            this.jwp.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jwm.setImageResource(R.drawable.video_back_selector);
            this.jwp.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jwm.setImageResource(R.drawable.video_delete_selector);
            if (this.jtD != null && this.jtD.getVideoDuration() >= 3000.0f) {
                this.jwp.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jwp.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jwm) {
            if (this.jwt != null) {
                this.jwt.ctS();
            }
            int status = this.jtD.getStatus();
            if (this.jtD != null && this.jtD.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jtD.ctt();
                    er(this.jww);
                    er(this.jwx);
                    er(this.jwy);
                    if (this.jtD.getVideoDuration() >= 3000.0f) {
                        BN(4);
                        return;
                    } else {
                        BN(this.jtD.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jtD.cts();
                BN(5);
            }
        } else if (view == this.jwp) {
            TiebaStatic.log("c12300");
            if (this.jtD != null && this.jtD.getStatus() > 2 && this.jwt != null) {
                if (this.jtD.getVideoDuration() >= 3000.0f) {
                    this.jwt.ctQ();
                } else {
                    this.jwt.ctR();
                }
            }
        }
    }

    private void er(List list) {
        if (!v.aa(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(final boolean z) {
        if (this.jtD.getProgress() >= 100) {
            if (this.jwt != null) {
                this.jwt.ctQ();
                return;
            }
            return;
        }
        if (this.jwA.getCurrentBeautyItem() != null) {
            this.jww.add(this.jwA.getCurrentBeautyItem());
        }
        if (this.jwA.getCurrentFilterItem() != null) {
            this.jwx.add(this.jwA.getCurrentFilterItem());
        }
        if (this.jwA.getCurrentStickItem() != null) {
            this.jwy.add(this.jwA.getCurrentStickItem());
        }
        BN(2);
        if (this.jwA.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jtD.getStatus() == 6 || VideoControllerLayout.this.jtD.akv()) {
                        VideoControllerLayout.this.rz(z);
                    }
                }
            });
        } else {
            rz(z);
        }
        if (this.jtD != null) {
            this.jtD.startRecord();
        }
        if (this.jwt != null) {
            this.jwt.ctL();
        }
    }

    public void stopRecord() {
        ctX();
        int status = this.jtD.getStatus();
        if (this.jtD != null) {
            if (!this.jtD.ctu() && this.jtD.akv()) {
                this.jtD.stopRecord();
            }
            ctW();
        }
        if (this.jwt != null) {
            this.jwt.ctA();
            if (status == 6) {
                this.jwt.ctN();
            }
        }
    }

    public void ctW() {
        if (this.jtD != null) {
            if (this.jtD.getVideoDuration() >= 3000.0f) {
                BN(4);
            } else if (this.jtD.getVideoDuration() > 0) {
                BN(3);
            } else {
                BN(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(boolean z) {
        if (this.jvB != null && this.jvB.isRunning()) {
            this.jvB.cancel();
        }
        if (this.jvA == null) {
            this.jvA = new AnimatorSet();
            this.jvA.playTogether(ObjectAnimator.ofFloat(this.jwm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jwp, "alpha", 1.0f, 0.0f));
            this.jvA.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxn) {
                        VideoControllerLayout.this.jwm.setVisibility(8);
                        VideoControllerLayout.this.jwp.setVisibility(8);
                    }
                }
            });
            this.jvA.setDuration(300L);
        }
        this.jvA.start();
        if (this.jtD.getStatus() != 6) {
            this.jwo.rz(z);
        }
    }

    public void ctX() {
        if (this.jtD == null || this.jtD.akv() || this.jtD.getStatus() == 6) {
            if (this.jvA != null && this.jvA.isRunning()) {
                this.jvA.cancel();
            }
            if (this.jvB == null) {
                this.jvB = new AnimatorSet();
                this.jvB.playTogether(ObjectAnimator.ofFloat(this.jwm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jwp, "alpha", 0.0f, 1.0f));
                this.jvB.setDuration(300L);
            }
            this.jwm.setVisibility(0);
            this.jwp.setVisibility(0);
            this.jvB.start();
            if (this.jtD.getStatus() != 7 && this.jtD.getStatus() != 6) {
                this.jwo.ctX();
                return;
            }
            this.jwo.getTvTip().setVisibility(8);
            if (this.fFW == 2) {
                this.jwo.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fFW) {
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
                if (this.jwt != null) {
                    this.jwt.ctS();
                }
                if (this.jtD.getStatus() != 7 && this.jtD.getStatus() != 6) {
                    if (this.jtD != null && this.jtD.ctr()) {
                        this.jwv = true;
                        com.baidu.tbadk.core.util.e.agU().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jwq = currentTimeMillis;
                    this.jwr = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jwr && VideoControllerLayout.this.jwq == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.aD(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jwv) {
                    this.jwv = false;
                    return;
                }
                this.jwr = false;
                if (this.jtD.akv() || this.jtD.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jtD.getStatus() != 8) {
                    aD(false);
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
                if (this.jtD.getStatus() == 6) {
                    this.jtD.setStatus(1);
                    if (this.jwt != null) {
                        this.jwt.ctN();
                        this.jwt.ctA();
                    }
                    this.jwo.getTvTip().setText("");
                    this.jwo.getTvTip().setVisibility(8);
                    return;
                } else if (this.jwA.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jwt != null) {
                    this.jwt.ctM();
                    this.jwo.cui();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jwo.cuj();
                return;
            default:
                return;
        }
    }

    public void ctG() {
        if (this.jwA.getVisibility() == 0) {
            a((m) null);
        }
        rz(false);
        this.jwo.getLayer1().setVisibility(8);
        this.jwo.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jwo.getTvTip().setVisibility(0);
        if (this.jwt != null) {
            this.jwt.ctL();
        }
    }

    public void ctY() {
        if (this.jtD.getStatus() == 6) {
            if (this.fFW == 2) {
                BN(7);
                this.jwo.setAlpha(1.0f);
                this.jwm.setVisibility(8);
                this.jwp.setVisibility(8);
                this.jwo.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jtD != null) {
                    this.jtD.startRecord();
                    return;
                }
                return;
            }
            this.jwo.getTvTip().setVisibility(8);
            if (this.jwt != null) {
                this.jwt.ctM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctH() {
        if (cub() && this.jwA.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cub()) {
            cua();
        }
        this.jwA.ctH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        if (cub() && this.jwA.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cub()) {
            cua();
        }
        this.jwA.ctI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        if (cub() && this.jwA.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cub()) {
            cua();
        }
        this.jwA.ctJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        if (cub() && this.jwA.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cub()) {
            cua();
        }
        this.jwA.ctK();
    }

    private void ctZ() {
        if (v.aa(this.jws)) {
            this.jws = new ArrayList();
            this.jws.add(ObjectAnimator.ofFloat(this.jwA, "translationY", 1000.0f, 0.0f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwn, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jws.add(ObjectAnimator.ofFloat(this.jwo.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwo.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwo.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwo.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwp, "scaleX", 1.0f, 0.7f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwp, "scaleY", 1.0f, 0.7f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwm, "scaleX", 1.0f, 0.7f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwm, "scaleY", 1.0f, 0.7f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwp, "alpha", 1.0f, 0.0f));
            this.jws.add(ObjectAnimator.ofFloat(this.jwm, "alpha", 1.0f, 0.0f));
        }
    }

    private void cua() {
        int i = 0;
        if (this.jwA.getVisibility() != 0) {
            this.jwA.setVisibility(0);
            ctZ();
            this.jwp.setEnabled(false);
            this.jwm.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jws.size()) {
                    ObjectAnimator objectAnimator = this.jws.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jws.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jwt != null) {
                                        VideoControllerLayout.this.jwt.ctO();
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
        if (this.jwA.getVisibility() != 8) {
            ctZ();
            this.jwp.setEnabled(true);
            this.jwm.setEnabled(true);
            if (this.jtD.getStatus() == 6 || this.jtD.akv()) {
                this.jwm.setVisibility(8);
                this.jwp.setVisibility(8);
            } else {
                BN(this.jtD.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jws.size()) {
                    ObjectAnimator objectAnimator = this.jws.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jws.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jxn) {
                                        VideoControllerLayout.this.jwA.setVisibility(8);
                                        if (VideoControllerLayout.this.jwt != null) {
                                            VideoControllerLayout.this.jwt.ctP();
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
        this.jwt = aVar;
    }

    public void setCurrentTab(int i) {
        this.fFW = i;
        switch (this.fFW) {
            case 1:
                this.jwm.setVisibility(4);
                this.jwp.setVisibility(4);
                this.jwo.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jtD.getStatus() != 1) {
                    this.jwm.setVisibility(0);
                    this.jwp.setVisibility(0);
                }
                this.jwo.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cub() {
        return this.jwA.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jwA != null) {
            this.jwA.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jwA != null) {
            this.jwA.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jwA != null) {
            this.jwA.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cuc() {
        if (this.jwA != null) {
            return this.jwA.cuc();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jwu = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jww;
    }

    public List<e> getChoosedFilterList() {
        return this.jwx;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jwy;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jwz.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jwA != null) {
            this.jwA.setMusicList(this.jwz);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cud() {
        if (this.jwA != null) {
            this.jwA.cud();
        }
    }

    public void csR() {
        if (this.jwA != null) {
            this.jwA.csR();
        }
    }
}
