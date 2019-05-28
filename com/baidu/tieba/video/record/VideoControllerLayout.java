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
    private int fFX;
    private i jtE;
    private AnimatorSet jvB;
    private AnimatorSet jvC;
    private List<e> jwA;
    private VideoEffectLayout jwB;
    private ImageView jwn;
    private RelativeLayout jwo;
    private VideoRecordButton jwp;
    private ImageView jwq;
    private long jwr;
    private boolean jws;
    private List<ObjectAnimator> jwt;
    private a jwu;
    private boolean jwv;
    private boolean jww;
    private List<e> jwx;
    private List<e> jwy;
    private List<StickerItem> jwz;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void ctC();

        void ctN();

        void ctO();

        void ctP();

        void ctQ();

        void ctR();

        void ctS();

        void ctT();

        void ctU();

        void ctV();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jwr = 0L;
        this.jws = false;
        this.jwv = true;
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.jwA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwr = 0L;
        this.jws = false;
        this.jwv = true;
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.jwA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwr = 0L;
        this.jws = false;
        this.jwv = true;
        this.jwx = new ArrayList();
        this.jwy = new ArrayList();
        this.jwz = new ArrayList();
        this.jwA = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jwB = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jwo = (RelativeLayout) findViewById(R.id.layout_record);
        this.jwn = (ImageView) findViewById(R.id.delete_video);
        this.jwn.setOnClickListener(this);
        this.jwp = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jwp.setOnTouchListener(this);
        this.jwq = (ImageView) findViewById(R.id.confirm_video);
        this.jwq.setOnClickListener(this);
        this.jwA.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jwA.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jtE = iVar;
        BN(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jwB != null) {
            this.jwB.setListener(aVar);
        }
    }

    public void BN(int i) {
        this.jtE.setStatus(i);
        if (this.jwu != null) {
            this.jwu.ctV();
        }
        if (i == 1) {
            this.jwn.setVisibility(8);
            this.jwq.setVisibility(8);
        } else if (i == 3) {
            this.jwn.setImageResource(R.drawable.video_back_selector);
            this.jwq.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jwn.setImageResource(R.drawable.video_back_selector);
            this.jwq.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jwn.setImageResource(R.drawable.video_delete_selector);
            if (this.jtE != null && this.jtE.getVideoDuration() >= 3000.0f) {
                this.jwq.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jwq.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jwn) {
            if (this.jwu != null) {
                this.jwu.ctU();
            }
            int status = this.jtE.getStatus();
            if (this.jtE != null && this.jtE.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jtE.ctv();
                    er(this.jwx);
                    er(this.jwy);
                    er(this.jwz);
                    if (this.jtE.getVideoDuration() >= 3000.0f) {
                        BN(4);
                        return;
                    } else {
                        BN(this.jtE.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jtE.ctu();
                BN(5);
            }
        } else if (view == this.jwq) {
            TiebaStatic.log("c12300");
            if (this.jtE != null && this.jtE.getStatus() > 2 && this.jwu != null) {
                if (this.jtE.getVideoDuration() >= 3000.0f) {
                    this.jwu.ctS();
                } else {
                    this.jwu.ctT();
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
        if (this.jtE.getProgress() >= 100) {
            if (this.jwu != null) {
                this.jwu.ctS();
                return;
            }
            return;
        }
        if (this.jwB.getCurrentBeautyItem() != null) {
            this.jwx.add(this.jwB.getCurrentBeautyItem());
        }
        if (this.jwB.getCurrentFilterItem() != null) {
            this.jwy.add(this.jwB.getCurrentFilterItem());
        }
        if (this.jwB.getCurrentStickItem() != null) {
            this.jwz.add(this.jwB.getCurrentStickItem());
        }
        BN(2);
        if (this.jwB.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jtE.getStatus() == 6 || VideoControllerLayout.this.jtE.akv()) {
                        VideoControllerLayout.this.rz(z);
                    }
                }
            });
        } else {
            rz(z);
        }
        if (this.jtE != null) {
            this.jtE.startRecord();
        }
        if (this.jwu != null) {
            this.jwu.ctN();
        }
    }

    public void stopRecord() {
        ctZ();
        int status = this.jtE.getStatus();
        if (this.jtE != null) {
            if (!this.jtE.ctw() && this.jtE.akv()) {
                this.jtE.stopRecord();
            }
            ctY();
        }
        if (this.jwu != null) {
            this.jwu.ctC();
            if (status == 6) {
                this.jwu.ctP();
            }
        }
    }

    public void ctY() {
        if (this.jtE != null) {
            if (this.jtE.getVideoDuration() >= 3000.0f) {
                BN(4);
            } else if (this.jtE.getVideoDuration() > 0) {
                BN(3);
            } else {
                BN(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(boolean z) {
        if (this.jvC != null && this.jvC.isRunning()) {
            this.jvC.cancel();
        }
        if (this.jvB == null) {
            this.jvB = new AnimatorSet();
            this.jvB.playTogether(ObjectAnimator.ofFloat(this.jwn, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jwq, "alpha", 1.0f, 0.0f));
            this.jvB.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxo) {
                        VideoControllerLayout.this.jwn.setVisibility(8);
                        VideoControllerLayout.this.jwq.setVisibility(8);
                    }
                }
            });
            this.jvB.setDuration(300L);
        }
        this.jvB.start();
        if (this.jtE.getStatus() != 6) {
            this.jwp.rz(z);
        }
    }

    public void ctZ() {
        if (this.jtE == null || this.jtE.akv() || this.jtE.getStatus() == 6) {
            if (this.jvB != null && this.jvB.isRunning()) {
                this.jvB.cancel();
            }
            if (this.jvC == null) {
                this.jvC = new AnimatorSet();
                this.jvC.playTogether(ObjectAnimator.ofFloat(this.jwn, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jwq, "alpha", 0.0f, 1.0f));
                this.jvC.setDuration(300L);
            }
            this.jwn.setVisibility(0);
            this.jwq.setVisibility(0);
            this.jvC.start();
            if (this.jtE.getStatus() != 7 && this.jtE.getStatus() != 6) {
                this.jwp.ctZ();
                return;
            }
            this.jwp.getTvTip().setVisibility(8);
            if (this.fFX == 2) {
                this.jwp.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fFX) {
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
                if (this.jwu != null) {
                    this.jwu.ctU();
                }
                if (this.jtE.getStatus() != 7 && this.jtE.getStatus() != 6) {
                    if (this.jtE != null && this.jtE.ctt()) {
                        this.jww = true;
                        com.baidu.tbadk.core.util.e.agU().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jwr = currentTimeMillis;
                    this.jws = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jws && VideoControllerLayout.this.jwr == currentTimeMillis) {
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
                if (this.jww) {
                    this.jww = false;
                    return;
                }
                this.jws = false;
                if (this.jtE.akv() || this.jtE.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jtE.getStatus() != 8) {
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
                if (this.jtE.getStatus() == 6) {
                    this.jtE.setStatus(1);
                    if (this.jwu != null) {
                        this.jwu.ctP();
                        this.jwu.ctC();
                    }
                    this.jwp.getTvTip().setText("");
                    this.jwp.getTvTip().setVisibility(8);
                    return;
                } else if (this.jwB.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jwu != null) {
                    this.jwu.ctO();
                    this.jwp.cuk();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jwp.cul();
                return;
            default:
                return;
        }
    }

    public void ctI() {
        if (this.jwB.getVisibility() == 0) {
            a((m) null);
        }
        rz(false);
        this.jwp.getLayer1().setVisibility(8);
        this.jwp.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jwp.getTvTip().setVisibility(0);
        if (this.jwu != null) {
            this.jwu.ctN();
        }
    }

    public void cua() {
        if (this.jtE.getStatus() == 6) {
            if (this.fFX == 2) {
                BN(7);
                this.jwp.setAlpha(1.0f);
                this.jwn.setVisibility(8);
                this.jwq.setVisibility(8);
                this.jwp.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jtE != null) {
                    this.jtE.startRecord();
                    return;
                }
                return;
            }
            this.jwp.getTvTip().setVisibility(8);
            if (this.jwu != null) {
                this.jwu.ctO();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        if (cud() && this.jwB.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cud()) {
            cuc();
        }
        this.jwB.ctJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        if (cud() && this.jwB.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cud()) {
            cuc();
        }
        this.jwB.ctK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        if (cud() && this.jwB.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cud()) {
            cuc();
        }
        this.jwB.ctL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctM() {
        if (cud() && this.jwB.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cud()) {
            cuc();
        }
        this.jwB.ctM();
    }

    private void cub() {
        if (v.aa(this.jwt)) {
            this.jwt = new ArrayList();
            this.jwt.add(ObjectAnimator.ofFloat(this.jwB, "translationY", 1000.0f, 0.0f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwo, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwp.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwp.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwp.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwp.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwq, "scaleX", 1.0f, 0.7f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwq, "scaleY", 1.0f, 0.7f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwn, "scaleX", 1.0f, 0.7f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwn, "scaleY", 1.0f, 0.7f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwq, "alpha", 1.0f, 0.0f));
            this.jwt.add(ObjectAnimator.ofFloat(this.jwn, "alpha", 1.0f, 0.0f));
        }
    }

    private void cuc() {
        int i = 0;
        if (this.jwB.getVisibility() != 0) {
            this.jwB.setVisibility(0);
            cub();
            this.jwq.setEnabled(false);
            this.jwn.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jwt.size()) {
                    ObjectAnimator objectAnimator = this.jwt.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jwt.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jwu != null) {
                                        VideoControllerLayout.this.jwu.ctQ();
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
        if (this.jwB.getVisibility() != 8) {
            cub();
            this.jwq.setEnabled(true);
            this.jwn.setEnabled(true);
            if (this.jtE.getStatus() == 6 || this.jtE.akv()) {
                this.jwn.setVisibility(8);
                this.jwq.setVisibility(8);
            } else {
                BN(this.jtE.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jwt.size()) {
                    ObjectAnimator objectAnimator = this.jwt.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jwt.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jxo) {
                                        VideoControllerLayout.this.jwB.setVisibility(8);
                                        if (VideoControllerLayout.this.jwu != null) {
                                            VideoControllerLayout.this.jwu.ctR();
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
        this.jwu = aVar;
    }

    public void setCurrentTab(int i) {
        this.fFX = i;
        switch (this.fFX) {
            case 1:
                this.jwn.setVisibility(4);
                this.jwq.setVisibility(4);
                this.jwp.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jtE.getStatus() != 1) {
                    this.jwn.setVisibility(0);
                    this.jwq.setVisibility(0);
                }
                this.jwp.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cud() {
        return this.jwB.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jwB != null) {
            this.jwB.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jwB != null) {
            this.jwB.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jwB != null) {
            this.jwB.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cue() {
        if (this.jwB != null) {
            return this.jwB.cue();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jwv = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jwx;
    }

    public List<e> getChoosedFilterList() {
        return this.jwy;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jwz;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jwA.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jwB != null) {
            this.jwB.setMusicList(this.jwA);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cuf() {
        if (this.jwB != null) {
            this.jwB.cuf();
        }
    }

    public void csT() {
        if (this.jwB != null) {
            this.jwB.csT();
        }
    }
}
