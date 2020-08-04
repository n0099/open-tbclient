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
    private int hYX;
    private Handler mHandler;
    private i mii;
    private ImageView mkM;
    private RelativeLayout mkN;
    private VideoRecordButton mkO;
    private ImageView mkP;
    private long mkQ;
    private boolean mkR;
    private List<ObjectAnimator> mkS;
    private a mkT;
    private boolean mkU;
    private boolean mkV;
    private List<e> mkW;
    private List<e> mkX;
    private List<StickerItem> mkY;
    private List<e> mkZ;
    private AnimatorSet mkb;
    private AnimatorSet mkc;
    private VideoEffectLayout mla;

    /* loaded from: classes17.dex */
    public interface a {
        void dsc();

        void dsn();

        void dso();

        void dsp();

        void dsq();

        void dsr();

        void dss();

        void dst();

        void dsu();

        void dsv();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mkQ = 0L;
        this.mkR = false;
        this.mkU = true;
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mkY = new ArrayList();
        this.mkZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mkQ = 0L;
        this.mkR = false;
        this.mkU = true;
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mkY = new ArrayList();
        this.mkZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mkQ = 0L;
        this.mkR = false;
        this.mkU = true;
        this.mkW = new ArrayList();
        this.mkX = new ArrayList();
        this.mkY = new ArrayList();
        this.mkZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mla = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mkN = (RelativeLayout) findViewById(R.id.layout_record);
        this.mkM = (ImageView) findViewById(R.id.delete_video);
        this.mkM.setOnClickListener(this);
        this.mkO = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mkO.setOnTouchListener(this);
        this.mkP = (ImageView) findViewById(R.id.confirm_video);
        this.mkP.setOnClickListener(this);
        this.mkZ.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mkZ.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mii = iVar;
        GL(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mla != null) {
            this.mla.setListener(aVar);
        }
    }

    public void GL(int i) {
        this.mii.setStatus(i);
        if (this.mkT != null) {
            this.mkT.dsv();
        }
        if (i == 1) {
            this.mkM.setVisibility(8);
            this.mkP.setVisibility(8);
        } else if (i == 3) {
            this.mkM.setImageResource(R.drawable.video_back_selector);
            this.mkP.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mkM.setImageResource(R.drawable.video_back_selector);
            this.mkP.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mkM.setImageResource(R.drawable.video_delete_selector);
            if (this.mii != null && this.mii.getVideoDuration() >= 3000.0f) {
                this.mkP.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mkP.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mkM) {
            if (this.mkT != null) {
                this.mkT.dsu();
            }
            int status = this.mii.getStatus();
            if (this.mii != null && this.mii.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mii.drX();
                    fk(this.mkW);
                    fk(this.mkX);
                    fk(this.mkY);
                    if (this.mii.getVideoDuration() >= 3000.0f) {
                        GL(4);
                        return;
                    } else {
                        GL(this.mii.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mii.drW();
                GL(5);
            }
        } else if (view == this.mkP) {
            TiebaStatic.log("c12300");
            if (this.mii != null && this.mii.getStatus() > 2 && this.mkT != null) {
                if (this.mii.getVideoDuration() >= 3000.0f) {
                    this.mkT.dss();
                } else {
                    this.mkT.dst();
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
        if (this.mii.getProgress() >= 100) {
            if (this.mkT != null) {
                this.mkT.dss();
                return;
            }
            return;
        }
        if (this.mla.getCurrentBeautyItem() != null) {
            this.mkW.add(this.mla.getCurrentBeautyItem());
        }
        if (this.mla.getCurrentFilterItem() != null) {
            this.mkX.add(this.mla.getCurrentFilterItem());
        }
        if (this.mla.getCurrentStickItem() != null) {
            this.mkY.add(this.mla.getCurrentStickItem());
        }
        GL(2);
        if (this.mla.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mii.getStatus() == 6 || VideoControllerLayout.this.mii.bdw()) {
                        VideoControllerLayout.this.vY(z);
                    }
                }
            });
        } else {
            vY(z);
        }
        if (this.mii != null) {
            this.mii.startRecord();
        }
        if (this.mkT != null) {
            this.mkT.dsn();
        }
    }

    public void stopRecord() {
        dsz();
        int status = this.mii.getStatus();
        if (this.mii != null) {
            if (!this.mii.bzK() && this.mii.bdw()) {
                this.mii.stopRecord();
            }
            dsy();
        }
        if (this.mkT != null) {
            this.mkT.dsc();
            if (status == 6) {
                this.mkT.dsp();
            }
        }
    }

    public void dsy() {
        if (this.mii != null) {
            if (this.mii.getVideoDuration() >= 3000.0f) {
                GL(4);
            } else if (this.mii.getVideoDuration() > 0) {
                GL(3);
            } else {
                GL(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(boolean z) {
        if (this.mkc != null && this.mkc.isRunning()) {
            this.mkc.cancel();
        }
        if (this.mkb == null) {
            this.mkb = new AnimatorSet();
            this.mkb.playTogether(ObjectAnimator.ofFloat(this.mkM, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mkP, "alpha", 1.0f, 0.0f));
            this.mkb.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlN) {
                        VideoControllerLayout.this.mkM.setVisibility(8);
                        VideoControllerLayout.this.mkP.setVisibility(8);
                    }
                }
            });
            this.mkb.setDuration(300L);
        }
        this.mkb.start();
        if (this.mii.getStatus() != 6) {
            this.mkO.vY(z);
        }
    }

    public void dsz() {
        if (this.mii == null || this.mii.bdw() || this.mii.getStatus() == 6) {
            if (this.mkb != null && this.mkb.isRunning()) {
                this.mkb.cancel();
            }
            if (this.mkc == null) {
                this.mkc = new AnimatorSet();
                this.mkc.playTogether(ObjectAnimator.ofFloat(this.mkM, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mkP, "alpha", 0.0f, 1.0f));
                this.mkc.setDuration(300L);
            }
            this.mkM.setVisibility(0);
            this.mkP.setVisibility(0);
            this.mkc.start();
            if (this.mii.getStatus() != 7 && this.mii.getStatus() != 6) {
                this.mkO.dsz();
                return;
            }
            this.mkO.getTvTip().setVisibility(8);
            if (this.hYX == 2) {
                this.mkO.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hYX) {
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
                if (this.mkT != null) {
                    this.mkT.dsu();
                }
                if (this.mii.getStatus() != 7 && this.mii.getStatus() != 6) {
                    if (this.mii != null && this.mii.drV()) {
                        this.mkV = true;
                        com.baidu.tbadk.core.util.e.aZX().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mkQ = currentTimeMillis;
                    this.mkR = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mkR && VideoControllerLayout.this.mkQ == currentTimeMillis) {
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
                if (this.mkV) {
                    this.mkV = false;
                    return;
                }
                this.mkR = false;
                if (this.mii.bdw() || this.mii.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mii.getStatus() != 8) {
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
                if (this.mii.getStatus() == 6) {
                    this.mii.setStatus(1);
                    if (this.mkT != null) {
                        this.mkT.dsp();
                        this.mkT.dsc();
                    }
                    this.mkO.getTvTip().setText("");
                    this.mkO.getTvTip().setVisibility(8);
                    return;
                } else if (this.mla.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mkT != null) {
                    this.mkT.dso();
                    this.mkO.dsK();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mkO.dsL();
                return;
            default:
                return;
        }
    }

    public void dsi() {
        if (this.mla.getVisibility() == 0) {
            a((m) null);
        }
        vY(false);
        this.mkO.getLayer1().setVisibility(8);
        this.mkO.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mkO.getTvTip().setVisibility(0);
        if (this.mkT != null) {
            this.mkT.dsn();
        }
    }

    public void dsA() {
        if (this.mii.getStatus() == 6) {
            if (this.hYX == 2) {
                GL(7);
                this.mkO.setAlpha(1.0f);
                this.mkM.setVisibility(8);
                this.mkP.setVisibility(8);
                this.mkO.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mii != null) {
                    this.mii.startRecord();
                    return;
                }
                return;
            }
            this.mkO.getTvTip().setVisibility(8);
            if (this.mkT != null) {
                this.mkT.dso();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsj() {
        if (dsD() && this.mla.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dsD()) {
            dsC();
        }
        this.mla.dsj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsk() {
        if (dsD() && this.mla.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dsD()) {
            dsC();
        }
        this.mla.dsk();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsl() {
        if (dsD() && this.mla.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dsD()) {
            dsC();
        }
        this.mla.dsl();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsm() {
        if (dsD() && this.mla.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dsD()) {
            dsC();
        }
        this.mla.dsm();
    }

    private void dsB() {
        if (x.isEmpty(this.mkS)) {
            this.mkS = new ArrayList();
            this.mkS.add(ObjectAnimator.ofFloat(this.mla, "translationY", 1000.0f, 0.0f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkN, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkO.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkO.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkO.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkO.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkP, "scaleX", 1.0f, 0.7f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkP, "scaleY", 1.0f, 0.7f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkM, "scaleX", 1.0f, 0.7f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkM, "scaleY", 1.0f, 0.7f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkP, "alpha", 1.0f, 0.0f));
            this.mkS.add(ObjectAnimator.ofFloat(this.mkM, "alpha", 1.0f, 0.0f));
        }
    }

    private void dsC() {
        int i = 0;
        if (this.mla.getVisibility() != 0) {
            this.mla.setVisibility(0);
            dsB();
            this.mkP.setEnabled(false);
            this.mkM.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mkS.size()) {
                    ObjectAnimator objectAnimator = this.mkS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mkS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mkT != null) {
                                        VideoControllerLayout.this.mkT.dsq();
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
        if (this.mla.getVisibility() != 8) {
            dsB();
            this.mkP.setEnabled(true);
            this.mkM.setEnabled(true);
            if (this.mii.getStatus() == 6 || this.mii.bdw()) {
                this.mkM.setVisibility(8);
                this.mkP.setVisibility(8);
            } else {
                GL(this.mii.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mkS.size()) {
                    ObjectAnimator objectAnimator = this.mkS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mkS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mlN) {
                                        VideoControllerLayout.this.mla.setVisibility(8);
                                        if (VideoControllerLayout.this.mkT != null) {
                                            VideoControllerLayout.this.mkT.dsr();
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
        this.mkT = aVar;
    }

    public void setCurrentTab(int i) {
        this.hYX = i;
        switch (this.hYX) {
            case 1:
                this.mkM.setVisibility(4);
                this.mkP.setVisibility(4);
                this.mkO.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mii.getStatus() != 1) {
                    this.mkM.setVisibility(0);
                    this.mkP.setVisibility(0);
                }
                this.mkO.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dsD() {
        return this.mla.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mla != null) {
            this.mla.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mla != null) {
            this.mla.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mla != null) {
            this.mla.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dsE() {
        if (this.mla != null) {
            return this.mla.dsE();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mkU = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mkW;
    }

    public List<e> getChoosedFilterList() {
        return this.mkX;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mkY;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mkZ.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mla != null) {
            this.mla.setMusicList(this.mkZ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dsF() {
        if (this.mla != null) {
            this.mla.dsF();
        }
    }

    public void drt() {
        if (this.mla != null) {
            this.mla.drt();
        }
    }
}
