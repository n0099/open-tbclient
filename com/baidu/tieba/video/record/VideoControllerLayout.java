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
    private i jtH;
    private AnimatorSet jvE;
    private AnimatorSet jvF;
    private List<e> jwA;
    private List<e> jwB;
    private List<StickerItem> jwC;
    private List<e> jwD;
    private VideoEffectLayout jwE;
    private ImageView jwq;
    private RelativeLayout jwr;
    private VideoRecordButton jws;
    private ImageView jwt;
    private long jwu;
    private boolean jwv;
    private List<ObjectAnimator> jww;
    private a jwx;
    private boolean jwy;
    private boolean jwz;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void ctB();

        void ctM();

        void ctN();

        void ctO();

        void ctP();

        void ctQ();

        void ctR();

        void ctS();

        void ctT();

        void ctU();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jwu = 0L;
        this.jwv = false;
        this.jwy = true;
        this.jwA = new ArrayList();
        this.jwB = new ArrayList();
        this.jwC = new ArrayList();
        this.jwD = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwu = 0L;
        this.jwv = false;
        this.jwy = true;
        this.jwA = new ArrayList();
        this.jwB = new ArrayList();
        this.jwC = new ArrayList();
        this.jwD = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jwu = 0L;
        this.jwv = false;
        this.jwy = true;
        this.jwA = new ArrayList();
        this.jwB = new ArrayList();
        this.jwC = new ArrayList();
        this.jwD = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jwE = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jwr = (RelativeLayout) findViewById(R.id.layout_record);
        this.jwq = (ImageView) findViewById(R.id.delete_video);
        this.jwq.setOnClickListener(this);
        this.jws = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jws.setOnTouchListener(this);
        this.jwt = (ImageView) findViewById(R.id.confirm_video);
        this.jwt.setOnClickListener(this);
        this.jwD.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jwD.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jtH = iVar;
        BN(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jwE != null) {
            this.jwE.setListener(aVar);
        }
    }

    public void BN(int i) {
        this.jtH.setStatus(i);
        if (this.jwx != null) {
            this.jwx.ctU();
        }
        if (i == 1) {
            this.jwq.setVisibility(8);
            this.jwt.setVisibility(8);
        } else if (i == 3) {
            this.jwq.setImageResource(R.drawable.video_back_selector);
            this.jwt.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jwq.setImageResource(R.drawable.video_back_selector);
            this.jwt.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jwq.setImageResource(R.drawable.video_delete_selector);
            if (this.jtH != null && this.jtH.getVideoDuration() >= 3000.0f) {
                this.jwt.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jwt.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jwq) {
            if (this.jwx != null) {
                this.jwx.ctT();
            }
            int status = this.jtH.getStatus();
            if (this.jtH != null && this.jtH.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jtH.ctu();
                    er(this.jwA);
                    er(this.jwB);
                    er(this.jwC);
                    if (this.jtH.getVideoDuration() >= 3000.0f) {
                        BN(4);
                        return;
                    } else {
                        BN(this.jtH.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jtH.ctt();
                BN(5);
            }
        } else if (view == this.jwt) {
            TiebaStatic.log("c12300");
            if (this.jtH != null && this.jtH.getStatus() > 2 && this.jwx != null) {
                if (this.jtH.getVideoDuration() >= 3000.0f) {
                    this.jwx.ctR();
                } else {
                    this.jwx.ctS();
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
        if (this.jtH.getProgress() >= 100) {
            if (this.jwx != null) {
                this.jwx.ctR();
                return;
            }
            return;
        }
        if (this.jwE.getCurrentBeautyItem() != null) {
            this.jwA.add(this.jwE.getCurrentBeautyItem());
        }
        if (this.jwE.getCurrentFilterItem() != null) {
            this.jwB.add(this.jwE.getCurrentFilterItem());
        }
        if (this.jwE.getCurrentStickItem() != null) {
            this.jwC.add(this.jwE.getCurrentStickItem());
        }
        BN(2);
        if (this.jwE.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jtH.getStatus() == 6 || VideoControllerLayout.this.jtH.akv()) {
                        VideoControllerLayout.this.rA(z);
                    }
                }
            });
        } else {
            rA(z);
        }
        if (this.jtH != null) {
            this.jtH.startRecord();
        }
        if (this.jwx != null) {
            this.jwx.ctM();
        }
    }

    public void stopRecord() {
        ctY();
        int status = this.jtH.getStatus();
        if (this.jtH != null) {
            if (!this.jtH.ctv() && this.jtH.akv()) {
                this.jtH.stopRecord();
            }
            ctX();
        }
        if (this.jwx != null) {
            this.jwx.ctB();
            if (status == 6) {
                this.jwx.ctO();
            }
        }
    }

    public void ctX() {
        if (this.jtH != null) {
            if (this.jtH.getVideoDuration() >= 3000.0f) {
                BN(4);
            } else if (this.jtH.getVideoDuration() > 0) {
                BN(3);
            } else {
                BN(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(boolean z) {
        if (this.jvF != null && this.jvF.isRunning()) {
            this.jvF.cancel();
        }
        if (this.jvE == null) {
            this.jvE = new AnimatorSet();
            this.jvE.playTogether(ObjectAnimator.ofFloat(this.jwq, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jwt, "alpha", 1.0f, 0.0f));
            this.jvE.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxr) {
                        VideoControllerLayout.this.jwq.setVisibility(8);
                        VideoControllerLayout.this.jwt.setVisibility(8);
                    }
                }
            });
            this.jvE.setDuration(300L);
        }
        this.jvE.start();
        if (this.jtH.getStatus() != 6) {
            this.jws.rA(z);
        }
    }

    public void ctY() {
        if (this.jtH == null || this.jtH.akv() || this.jtH.getStatus() == 6) {
            if (this.jvE != null && this.jvE.isRunning()) {
                this.jvE.cancel();
            }
            if (this.jvF == null) {
                this.jvF = new AnimatorSet();
                this.jvF.playTogether(ObjectAnimator.ofFloat(this.jwq, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jwt, "alpha", 0.0f, 1.0f));
                this.jvF.setDuration(300L);
            }
            this.jwq.setVisibility(0);
            this.jwt.setVisibility(0);
            this.jvF.start();
            if (this.jtH.getStatus() != 7 && this.jtH.getStatus() != 6) {
                this.jws.ctY();
                return;
            }
            this.jws.getTvTip().setVisibility(8);
            if (this.fFX == 2) {
                this.jws.getLayer1().setVisibility(0);
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
                if (this.jwx != null) {
                    this.jwx.ctT();
                }
                if (this.jtH.getStatus() != 7 && this.jtH.getStatus() != 6) {
                    if (this.jtH != null && this.jtH.cts()) {
                        this.jwz = true;
                        com.baidu.tbadk.core.util.e.agU().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jwu = currentTimeMillis;
                    this.jwv = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jwv && VideoControllerLayout.this.jwu == currentTimeMillis) {
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
                if (this.jwz) {
                    this.jwz = false;
                    return;
                }
                this.jwv = false;
                if (this.jtH.akv() || this.jtH.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jtH.getStatus() != 8) {
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
                if (this.jtH.getStatus() == 6) {
                    this.jtH.setStatus(1);
                    if (this.jwx != null) {
                        this.jwx.ctO();
                        this.jwx.ctB();
                    }
                    this.jws.getTvTip().setText("");
                    this.jws.getTvTip().setVisibility(8);
                    return;
                } else if (this.jwE.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jwx != null) {
                    this.jwx.ctN();
                    this.jws.cuj();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jws.cuk();
                return;
            default:
                return;
        }
    }

    public void ctH() {
        if (this.jwE.getVisibility() == 0) {
            a((m) null);
        }
        rA(false);
        this.jws.getLayer1().setVisibility(8);
        this.jws.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jws.getTvTip().setVisibility(0);
        if (this.jwx != null) {
            this.jwx.ctM();
        }
    }

    public void ctZ() {
        if (this.jtH.getStatus() == 6) {
            if (this.fFX == 2) {
                BN(7);
                this.jws.setAlpha(1.0f);
                this.jwq.setVisibility(8);
                this.jwt.setVisibility(8);
                this.jws.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jtH != null) {
                    this.jtH.startRecord();
                    return;
                }
                return;
            }
            this.jws.getTvTip().setVisibility(8);
            if (this.jwx != null) {
                this.jwx.ctN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        if (cuc() && this.jwE.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cuc()) {
            cub();
        }
        this.jwE.ctI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        if (cuc() && this.jwE.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cuc()) {
            cub();
        }
        this.jwE.ctJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        if (cuc() && this.jwE.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cuc()) {
            cub();
        }
        this.jwE.ctK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        if (cuc() && this.jwE.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cuc()) {
            cub();
        }
        this.jwE.ctL();
    }

    private void cua() {
        if (v.aa(this.jww)) {
            this.jww = new ArrayList();
            this.jww.add(ObjectAnimator.ofFloat(this.jwE, "translationY", 1000.0f, 0.0f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwr, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jww.add(ObjectAnimator.ofFloat(this.jws.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jww.add(ObjectAnimator.ofFloat(this.jws.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jww.add(ObjectAnimator.ofFloat(this.jws.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jww.add(ObjectAnimator.ofFloat(this.jws.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwt, "scaleX", 1.0f, 0.7f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwt, "scaleY", 1.0f, 0.7f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwq, "scaleX", 1.0f, 0.7f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwq, "scaleY", 1.0f, 0.7f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwt, "alpha", 1.0f, 0.0f));
            this.jww.add(ObjectAnimator.ofFloat(this.jwq, "alpha", 1.0f, 0.0f));
        }
    }

    private void cub() {
        int i = 0;
        if (this.jwE.getVisibility() != 0) {
            this.jwE.setVisibility(0);
            cua();
            this.jwt.setEnabled(false);
            this.jwq.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jww.size()) {
                    ObjectAnimator objectAnimator = this.jww.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jww.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jwx != null) {
                                        VideoControllerLayout.this.jwx.ctP();
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
        if (this.jwE.getVisibility() != 8) {
            cua();
            this.jwt.setEnabled(true);
            this.jwq.setEnabled(true);
            if (this.jtH.getStatus() == 6 || this.jtH.akv()) {
                this.jwq.setVisibility(8);
                this.jwt.setVisibility(8);
            } else {
                BN(this.jtH.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jww.size()) {
                    ObjectAnimator objectAnimator = this.jww.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jww.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jxr) {
                                        VideoControllerLayout.this.jwE.setVisibility(8);
                                        if (VideoControllerLayout.this.jwx != null) {
                                            VideoControllerLayout.this.jwx.ctQ();
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
        this.jwx = aVar;
    }

    public void setCurrentTab(int i) {
        this.fFX = i;
        switch (this.fFX) {
            case 1:
                this.jwq.setVisibility(4);
                this.jwt.setVisibility(4);
                this.jws.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jtH.getStatus() != 1) {
                    this.jwq.setVisibility(0);
                    this.jwt.setVisibility(0);
                }
                this.jws.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cuc() {
        return this.jwE.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jwE != null) {
            this.jwE.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jwE != null) {
            this.jwE.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jwE != null) {
            this.jwE.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cud() {
        if (this.jwE != null) {
            return this.jwE.cud();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jwy = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jwA;
    }

    public List<e> getChoosedFilterList() {
        return this.jwB;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jwC;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jwD.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jwE != null) {
            this.jwE.setMusicList(this.jwD);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cue() {
        if (this.jwE != null) {
            this.jwE.cue();
        }
    }

    public void csS() {
        if (this.jwE != null) {
            this.jwE.csS();
        }
    }
}
