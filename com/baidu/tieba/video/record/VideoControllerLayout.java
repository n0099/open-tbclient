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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jFy;
    private Handler mHandler;
    private i nSo;
    private ImageView nUR;
    private RelativeLayout nUS;
    private VideoRecordButton nUT;
    private ImageView nUU;
    private long nUV;
    private boolean nUW;
    private List<ObjectAnimator> nUX;
    private a nUY;
    private boolean nUZ;
    private AnimatorSet nUe;
    private AnimatorSet nUf;
    private boolean nVa;
    private List<e> nVb;
    private List<e> nVc;
    private List<StickerItem> nVd;
    private List<e> nVe;
    private VideoEffectLayout nVf;

    /* loaded from: classes7.dex */
    public interface a {
        void dUC();

        void dUO();

        void dUP();

        void dUQ();

        void dUR();

        void dUS();

        void dUT();

        void dUU();

        void dUV();

        void dUW();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nUV = 0L;
        this.nUW = false;
        this.nUZ = true;
        this.nVb = new ArrayList();
        this.nVc = new ArrayList();
        this.nVd = new ArrayList();
        this.nVe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nUV = 0L;
        this.nUW = false;
        this.nUZ = true;
        this.nVb = new ArrayList();
        this.nVc = new ArrayList();
        this.nVd = new ArrayList();
        this.nVe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUV = 0L;
        this.nUW = false;
        this.nUZ = true;
        this.nVb = new ArrayList();
        this.nVc = new ArrayList();
        this.nVd = new ArrayList();
        this.nVe = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nVf = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nUS = (RelativeLayout) findViewById(R.id.layout_record);
        this.nUR = (ImageView) findViewById(R.id.delete_video);
        this.nUR.setOnClickListener(this);
        this.nUT = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nUT.setOnTouchListener(this);
        this.nUU = (ImageView) findViewById(R.id.confirm_video);
        this.nUU.setOnClickListener(this);
        this.nVe.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nVe.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nSo = iVar;
        KW(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nVf != null) {
            this.nVf.setListener(aVar);
        }
    }

    public void KW(int i) {
        this.nSo.setStatus(i);
        if (this.nUY != null) {
            this.nUY.dUW();
        }
        if (i == 1) {
            this.nUR.setVisibility(8);
            this.nUU.setVisibility(8);
        } else if (i == 3) {
            this.nUR.setImageResource(R.drawable.video_back_selector);
            this.nUU.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nUR.setImageResource(R.drawable.video_back_selector);
            this.nUU.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nUR.setImageResource(R.drawable.video_delete_selector);
            if (this.nSo != null && this.nSo.getVideoDuration() >= 3000.0f) {
                this.nUU.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nUU.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nUR) {
            if (this.nUY != null) {
                this.nUY.dUV();
            }
            int status = this.nSo.getStatus();
            if (this.nSo != null && this.nSo.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nSo.dUx();
                    gb(this.nVb);
                    gb(this.nVc);
                    gb(this.nVd);
                    if (this.nSo.getVideoDuration() >= 3000.0f) {
                        KW(4);
                        return;
                    } else {
                        KW(this.nSo.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nSo.dUw();
                KW(5);
            }
        } else if (view == this.nUU) {
            TiebaStatic.log("c12300");
            if (this.nSo != null && this.nSo.getStatus() > 2 && this.nUY != null) {
                if (this.nSo.getVideoDuration() >= 3000.0f) {
                    this.nUY.dUT();
                } else {
                    this.nUY.dUU();
                }
            }
        }
    }

    private void gb(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ge(final boolean z) {
        if (this.nSo.getProgress() >= 100) {
            if (this.nUY != null) {
                this.nUY.dUT();
                return;
            }
            return;
        }
        if (this.nVf.getCurrentBeautyItem() != null) {
            this.nVb.add(this.nVf.getCurrentBeautyItem());
        }
        if (this.nVf.getCurrentFilterItem() != null) {
            this.nVc.add(this.nVf.getCurrentFilterItem());
        }
        if (this.nVf.getCurrentStickItem() != null) {
            this.nVd.add(this.nVf.getCurrentStickItem());
        }
        KW(2);
        if (this.nVf.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nSo.getStatus() == 6 || VideoControllerLayout.this.nSo.isRecording()) {
                        VideoControllerLayout.this.zf(z);
                    }
                }
            });
        } else {
            zf(z);
        }
        if (this.nSo != null) {
            this.nSo.startRecord();
        }
        if (this.nUY != null) {
            this.nUY.dUO();
        }
    }

    public void stopRecord() {
        dVa();
        int status = this.nSo.getStatus();
        if (this.nSo != null) {
            if (!this.nSo.bUq() && this.nSo.isRecording()) {
                this.nSo.stopRecord();
            }
            dUZ();
        }
        if (this.nUY != null) {
            this.nUY.dUC();
            if (status == 6) {
                this.nUY.dUQ();
            }
        }
    }

    public void dUZ() {
        if (this.nSo != null) {
            if (this.nSo.getVideoDuration() >= 3000.0f) {
                KW(4);
            } else if (this.nSo.getVideoDuration() > 0) {
                KW(3);
            } else {
                KW(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf(boolean z) {
        if (this.nUf != null && this.nUf.isRunning()) {
            this.nUf.cancel();
        }
        if (this.nUe == null) {
            this.nUe = new AnimatorSet();
            this.nUe.playTogether(ObjectAnimator.ofFloat(this.nUR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nUU, "alpha", 1.0f, 0.0f));
            this.nUe.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nVS) {
                        VideoControllerLayout.this.nUR.setVisibility(8);
                        VideoControllerLayout.this.nUU.setVisibility(8);
                    }
                }
            });
            this.nUe.setDuration(300L);
        }
        this.nUe.start();
        if (this.nSo.getStatus() != 6) {
            this.nUT.zf(z);
        }
    }

    public void dVa() {
        if (this.nSo == null || this.nSo.isRecording() || this.nSo.getStatus() == 6) {
            if (this.nUe != null && this.nUe.isRunning()) {
                this.nUe.cancel();
            }
            if (this.nUf == null) {
                this.nUf = new AnimatorSet();
                this.nUf.playTogether(ObjectAnimator.ofFloat(this.nUR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nUU, "alpha", 0.0f, 1.0f));
                this.nUf.setDuration(300L);
            }
            this.nUR.setVisibility(0);
            this.nUU.setVisibility(0);
            this.nUf.start();
            if (this.nSo.getStatus() != 7 && this.nSo.getStatus() != 6) {
                this.nUT.dVa();
                return;
            }
            this.nUT.getTvTip().setVisibility(8);
            if (this.jFy == 2) {
                this.nUT.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jFy) {
            case 1:
                l(view, motionEvent);
                return true;
            case 2:
                k(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void k(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nUY != null) {
                    this.nUY.dUV();
                }
                if (this.nSo.getStatus() != 7 && this.nSo.getStatus() != 6) {
                    if (this.nSo != null && this.nSo.dUv()) {
                        this.nVa = true;
                        com.baidu.tbadk.core.util.e.brZ().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nUV = currentTimeMillis;
                    this.nUW = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nUW && VideoControllerLayout.this.nUV == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.ge(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nVa) {
                    this.nVa = false;
                    return;
                }
                this.nUW = false;
                if (this.nSo.isRecording() || this.nSo.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nSo.getStatus() != 8) {
                    ge(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void l(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nSo.getStatus() == 6) {
                    this.nSo.setStatus(1);
                    if (this.nUY != null) {
                        this.nUY.dUQ();
                        this.nUY.dUC();
                    }
                    this.nUT.getTvTip().setText("");
                    this.nUT.getTvTip().setVisibility(8);
                    return;
                } else if (this.nVf.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nUY != null) {
                    this.nUY.dUP();
                    this.nUT.dVl();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nUT.dVm();
                return;
            default:
                return;
        }
    }

    public void dUJ() {
        if (this.nVf.getVisibility() == 0) {
            a((m) null);
        }
        zf(false);
        this.nUT.getLayer1().setVisibility(8);
        this.nUT.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nUT.getTvTip().setVisibility(0);
        if (this.nUY != null) {
            this.nUY.dUO();
        }
    }

    public void dVb() {
        if (this.nSo.getStatus() == 6) {
            if (this.jFy == 2) {
                KW(7);
                this.nUT.setAlpha(1.0f);
                this.nUR.setVisibility(8);
                this.nUU.setVisibility(8);
                this.nUT.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nSo != null) {
                    this.nSo.startRecord();
                    return;
                }
                return;
            }
            this.nUT.getTvTip().setVisibility(8);
            if (this.nUY != null) {
                this.nUY.dUP();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUK() {
        if (dVe() && this.nVf.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dVe()) {
            dVd();
        }
        this.nVf.dUK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUL() {
        if (dVe() && this.nVf.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dVe()) {
            dVd();
        }
        this.nVf.dUL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUM() {
        if (dVe() && this.nVf.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dVe()) {
            dVd();
        }
        this.nVf.dUM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUN() {
        if (dVe() && this.nVf.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dVe()) {
            dVd();
        }
        this.nVf.dUN();
    }

    private void dVc() {
        if (y.isEmpty(this.nUX)) {
            this.nUX = new ArrayList();
            this.nUX.add(ObjectAnimator.ofFloat(this.nVf, "translationY", 1000.0f, 0.0f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUS, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUT.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUT.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUT.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUT.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUU, "scaleX", 1.0f, 0.7f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUU, "scaleY", 1.0f, 0.7f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUR, "scaleX", 1.0f, 0.7f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUR, "scaleY", 1.0f, 0.7f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUU, "alpha", 1.0f, 0.0f));
            this.nUX.add(ObjectAnimator.ofFloat(this.nUR, "alpha", 1.0f, 0.0f));
        }
    }

    private void dVd() {
        int i = 0;
        if (this.nVf.getVisibility() != 0) {
            this.nVf.setVisibility(0);
            dVc();
            this.nUU.setEnabled(false);
            this.nUR.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nUX.size()) {
                    ObjectAnimator objectAnimator = this.nUX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nUX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nUY != null) {
                                        VideoControllerLayout.this.nUY.dUR();
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
        if (this.nVf.getVisibility() != 8) {
            dVc();
            this.nUU.setEnabled(true);
            this.nUR.setEnabled(true);
            if (this.nSo.getStatus() == 6 || this.nSo.isRecording()) {
                this.nUR.setVisibility(8);
                this.nUU.setVisibility(8);
            } else {
                KW(this.nSo.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nUX.size()) {
                    ObjectAnimator objectAnimator = this.nUX.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nUX.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nVS) {
                                        VideoControllerLayout.this.nVf.setVisibility(8);
                                        if (VideoControllerLayout.this.nUY != null) {
                                            VideoControllerLayout.this.nUY.dUS();
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
        this.nUY = aVar;
    }

    public void setCurrentTab(int i) {
        this.jFy = i;
        switch (this.jFy) {
            case 1:
                this.nUR.setVisibility(4);
                this.nUU.setVisibility(4);
                this.nUT.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nSo.getStatus() != 1) {
                    this.nUR.setVisibility(0);
                    this.nUU.setVisibility(0);
                }
                this.nUT.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dVe() {
        return this.nVf.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nVf != null) {
            this.nVf.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nVf != null) {
            this.nVf.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nVf != null) {
            this.nVf.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dVf() {
        if (this.nVf != null) {
            return this.nVf.dVf();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nUZ = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nVb;
    }

    public List<e> getChoosedFilterList() {
        return this.nVc;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nVd;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nVe.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nVf != null) {
            this.nVf.setMusicList(this.nVe);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void dVg() {
        if (this.nVf != null) {
            this.nVf.dVg();
        }
    }

    public void dTT() {
        if (this.nVf != null) {
            this.nVf.dTT();
        }
    }
}
