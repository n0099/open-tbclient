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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int hYV;
    private Handler mHandler;
    private i mig;
    private AnimatorSet mjZ;
    private ImageView mkK;
    private RelativeLayout mkL;
    private VideoRecordButton mkM;
    private ImageView mkN;
    private long mkO;
    private boolean mkP;
    private List<ObjectAnimator> mkQ;
    private a mkR;
    private boolean mkS;
    private boolean mkT;
    private List<e> mkU;
    private List<e> mkV;
    private List<StickerItem> mkW;
    private List<e> mkX;
    private VideoEffectLayout mkY;
    private AnimatorSet mka;

    /* loaded from: classes17.dex */
    public interface a {
        void dsb();

        void dsm();

        void dsn();

        void dso();

        void dsp();

        void dsq();

        void dsr();

        void dss();

        void dst();

        void dsu();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mkO = 0L;
        this.mkP = false;
        this.mkS = true;
        this.mkU = new ArrayList();
        this.mkV = new ArrayList();
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mkO = 0L;
        this.mkP = false;
        this.mkS = true;
        this.mkU = new ArrayList();
        this.mkV = new ArrayList();
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mkO = 0L;
        this.mkP = false;
        this.mkS = true;
        this.mkU = new ArrayList();
        this.mkV = new ArrayList();
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mkY = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mkL = (RelativeLayout) findViewById(R.id.layout_record);
        this.mkK = (ImageView) findViewById(R.id.delete_video);
        this.mkK.setOnClickListener(this);
        this.mkM = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mkM.setOnTouchListener(this);
        this.mkN = (ImageView) findViewById(R.id.confirm_video);
        this.mkN.setOnClickListener(this);
        this.mkX.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mkX.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mig = iVar;
        GL(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mkY != null) {
            this.mkY.setListener(aVar);
        }
    }

    public void GL(int i) {
        this.mig.setStatus(i);
        if (this.mkR != null) {
            this.mkR.dsu();
        }
        if (i == 1) {
            this.mkK.setVisibility(8);
            this.mkN.setVisibility(8);
        } else if (i == 3) {
            this.mkK.setImageResource(R.drawable.video_back_selector);
            this.mkN.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mkK.setImageResource(R.drawable.video_back_selector);
            this.mkN.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mkK.setImageResource(R.drawable.video_delete_selector);
            if (this.mig != null && this.mig.getVideoDuration() >= 3000.0f) {
                this.mkN.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mkN.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mkK) {
            if (this.mkR != null) {
                this.mkR.dst();
            }
            int status = this.mig.getStatus();
            if (this.mig != null && this.mig.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mig.drW();
                    fk(this.mkU);
                    fk(this.mkV);
                    fk(this.mkW);
                    if (this.mig.getVideoDuration() >= 3000.0f) {
                        GL(4);
                        return;
                    } else {
                        GL(this.mig.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mig.drV();
                GL(5);
            }
        } else if (view == this.mkN) {
            TiebaStatic.log("c12300");
            if (this.mig != null && this.mig.getStatus() > 2 && this.mkR != null) {
                if (this.mig.getVideoDuration() >= 3000.0f) {
                    this.mkR.dsr();
                } else {
                    this.mkR.dss();
                }
            }
        }
    }

    private void fk(List list) {
        if (!x.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ey(final boolean z) {
        if (this.mig.getProgress() >= 100) {
            if (this.mkR != null) {
                this.mkR.dsr();
                return;
            }
            return;
        }
        if (this.mkY.getCurrentBeautyItem() != null) {
            this.mkU.add(this.mkY.getCurrentBeautyItem());
        }
        if (this.mkY.getCurrentFilterItem() != null) {
            this.mkV.add(this.mkY.getCurrentFilterItem());
        }
        if (this.mkY.getCurrentStickItem() != null) {
            this.mkW.add(this.mkY.getCurrentStickItem());
        }
        GL(2);
        if (this.mkY.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mig.getStatus() == 6 || VideoControllerLayout.this.mig.bdw()) {
                        VideoControllerLayout.this.vY(z);
                    }
                }
            });
        } else {
            vY(z);
        }
        if (this.mig != null) {
            this.mig.startRecord();
        }
        if (this.mkR != null) {
            this.mkR.dsm();
        }
    }

    public void stopRecord() {
        dsy();
        int status = this.mig.getStatus();
        if (this.mig != null) {
            if (!this.mig.bzK() && this.mig.bdw()) {
                this.mig.stopRecord();
            }
            dsx();
        }
        if (this.mkR != null) {
            this.mkR.dsb();
            if (status == 6) {
                this.mkR.dso();
            }
        }
    }

    public void dsx() {
        if (this.mig != null) {
            if (this.mig.getVideoDuration() >= 3000.0f) {
                GL(4);
            } else if (this.mig.getVideoDuration() > 0) {
                GL(3);
            } else {
                GL(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(boolean z) {
        if (this.mka != null && this.mka.isRunning()) {
            this.mka.cancel();
        }
        if (this.mjZ == null) {
            this.mjZ = new AnimatorSet();
            this.mjZ.playTogether(ObjectAnimator.ofFloat(this.mkK, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mkN, "alpha", 1.0f, 0.0f));
            this.mjZ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlL) {
                        VideoControllerLayout.this.mkK.setVisibility(8);
                        VideoControllerLayout.this.mkN.setVisibility(8);
                    }
                }
            });
            this.mjZ.setDuration(300L);
        }
        this.mjZ.start();
        if (this.mig.getStatus() != 6) {
            this.mkM.vY(z);
        }
    }

    public void dsy() {
        if (this.mig == null || this.mig.bdw() || this.mig.getStatus() == 6) {
            if (this.mjZ != null && this.mjZ.isRunning()) {
                this.mjZ.cancel();
            }
            if (this.mka == null) {
                this.mka = new AnimatorSet();
                this.mka.playTogether(ObjectAnimator.ofFloat(this.mkK, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mkN, "alpha", 0.0f, 1.0f));
                this.mka.setDuration(300L);
            }
            this.mkK.setVisibility(0);
            this.mkN.setVisibility(0);
            this.mka.start();
            if (this.mig.getStatus() != 7 && this.mig.getStatus() != 6) {
                this.mkM.dsy();
                return;
            }
            this.mkM.getTvTip().setVisibility(8);
            if (this.hYV == 2) {
                this.mkM.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hYV) {
            case 1:
                e(view, motionEvent);
                return true;
            case 2:
                d(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void d(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mkR != null) {
                    this.mkR.dst();
                }
                if (this.mig.getStatus() != 7 && this.mig.getStatus() != 6) {
                    if (this.mig != null && this.mig.drU()) {
                        this.mkT = true;
                        com.baidu.tbadk.core.util.e.aZX().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mkO = currentTimeMillis;
                    this.mkP = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mkP && VideoControllerLayout.this.mkO == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.ey(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.mkT) {
                    this.mkT = false;
                    return;
                }
                this.mkP = false;
                if (this.mig.bdw() || this.mig.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mig.getStatus() != 8) {
                    ey(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void e(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.mig.getStatus() == 6) {
                    this.mig.setStatus(1);
                    if (this.mkR != null) {
                        this.mkR.dso();
                        this.mkR.dsb();
                    }
                    this.mkM.getTvTip().setText("");
                    this.mkM.getTvTip().setVisibility(8);
                    return;
                } else if (this.mkY.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mkR != null) {
                    this.mkR.dsn();
                    this.mkM.dsJ();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mkM.dsK();
                return;
            default:
                return;
        }
    }

    public void dsh() {
        if (this.mkY.getVisibility() == 0) {
            a((m) null);
        }
        vY(false);
        this.mkM.getLayer1().setVisibility(8);
        this.mkM.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mkM.getTvTip().setVisibility(0);
        if (this.mkR != null) {
            this.mkR.dsm();
        }
    }

    public void dsz() {
        if (this.mig.getStatus() == 6) {
            if (this.hYV == 2) {
                GL(7);
                this.mkM.setAlpha(1.0f);
                this.mkK.setVisibility(8);
                this.mkN.setVisibility(8);
                this.mkM.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mig != null) {
                    this.mig.startRecord();
                    return;
                }
                return;
            }
            this.mkM.getTvTip().setVisibility(8);
            if (this.mkR != null) {
                this.mkR.dsn();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsi() {
        if (dsC() && this.mkY.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dsC()) {
            dsB();
        }
        this.mkY.dsi();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsj() {
        if (dsC() && this.mkY.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dsC()) {
            dsB();
        }
        this.mkY.dsj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsk() {
        if (dsC() && this.mkY.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dsC()) {
            dsB();
        }
        this.mkY.dsk();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsl() {
        if (dsC() && this.mkY.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dsC()) {
            dsB();
        }
        this.mkY.dsl();
    }

    private void dsA() {
        if (x.isEmpty(this.mkQ)) {
            this.mkQ = new ArrayList();
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkY, "translationY", 1000.0f, 0.0f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkL, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkM.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkM.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkM.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkM.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkN, "scaleX", 1.0f, 0.7f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkN, "scaleY", 1.0f, 0.7f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkK, "scaleX", 1.0f, 0.7f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkK, "scaleY", 1.0f, 0.7f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkN, "alpha", 1.0f, 0.0f));
            this.mkQ.add(ObjectAnimator.ofFloat(this.mkK, "alpha", 1.0f, 0.0f));
        }
    }

    private void dsB() {
        int i = 0;
        if (this.mkY.getVisibility() != 0) {
            this.mkY.setVisibility(0);
            dsA();
            this.mkN.setEnabled(false);
            this.mkK.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mkQ.size()) {
                    ObjectAnimator objectAnimator = this.mkQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mkQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mkR != null) {
                                        VideoControllerLayout.this.mkR.dsp();
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
        if (this.mkY.getVisibility() != 8) {
            dsA();
            this.mkN.setEnabled(true);
            this.mkK.setEnabled(true);
            if (this.mig.getStatus() == 6 || this.mig.bdw()) {
                this.mkK.setVisibility(8);
                this.mkN.setVisibility(8);
            } else {
                GL(this.mig.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mkQ.size()) {
                    ObjectAnimator objectAnimator = this.mkQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mkQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mlL) {
                                        VideoControllerLayout.this.mkY.setVisibility(8);
                                        if (VideoControllerLayout.this.mkR != null) {
                                            VideoControllerLayout.this.mkR.dsq();
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
        this.mkR = aVar;
    }

    public void setCurrentTab(int i) {
        this.hYV = i;
        switch (this.hYV) {
            case 1:
                this.mkK.setVisibility(4);
                this.mkN.setVisibility(4);
                this.mkM.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mig.getStatus() != 1) {
                    this.mkK.setVisibility(0);
                    this.mkN.setVisibility(0);
                }
                this.mkM.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dsC() {
        return this.mkY.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mkY != null) {
            this.mkY.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mkY != null) {
            this.mkY.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mkY != null) {
            this.mkY.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dsD() {
        if (this.mkY != null) {
            return this.mkY.dsD();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mkS = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mkU;
    }

    public List<e> getChoosedFilterList() {
        return this.mkV;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mkW;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mkX.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mkY != null) {
            this.mkY.setMusicList(this.mkX);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dsE() {
        if (this.mkY != null) {
            this.mkY.dsE();
        }
    }

    public void drs() {
        if (this.mkY != null) {
            this.mkY.drs();
        }
    }
}
