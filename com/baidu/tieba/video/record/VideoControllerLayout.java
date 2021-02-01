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
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jDB;
    private Handler mHandler;
    private i nPJ;
    private AnimatorSet nRA;
    private AnimatorSet nRz;
    private VideoEffectLayout nSA;
    private ImageView nSm;
    private RelativeLayout nSn;
    private VideoRecordButton nSo;
    private ImageView nSp;
    private long nSq;
    private boolean nSr;
    private List<ObjectAnimator> nSs;
    private a nSt;
    private boolean nSu;
    private boolean nSv;
    private List<e> nSw;
    private List<e> nSx;
    private List<StickerItem> nSy;
    private List<e> nSz;

    /* loaded from: classes8.dex */
    public interface a {
        void dUA();

        void dUB();

        void dUC();

        void dUD();

        void dUE();

        void dUF();

        void dUG();

        void dUm();

        void dUy();

        void dUz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nSq = 0L;
        this.nSr = false;
        this.nSu = true;
        this.nSw = new ArrayList();
        this.nSx = new ArrayList();
        this.nSy = new ArrayList();
        this.nSz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nSq = 0L;
        this.nSr = false;
        this.nSu = true;
        this.nSw = new ArrayList();
        this.nSx = new ArrayList();
        this.nSy = new ArrayList();
        this.nSz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nSq = 0L;
        this.nSr = false;
        this.nSu = true;
        this.nSw = new ArrayList();
        this.nSx = new ArrayList();
        this.nSy = new ArrayList();
        this.nSz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nSA = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nSn = (RelativeLayout) findViewById(R.id.layout_record);
        this.nSm = (ImageView) findViewById(R.id.delete_video);
        this.nSm.setOnClickListener(this);
        this.nSo = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nSo.setOnTouchListener(this);
        this.nSp = (ImageView) findViewById(R.id.confirm_video);
        this.nSp.setOnClickListener(this);
        this.nSz.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nSz.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nPJ = iVar;
        KR(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nSA != null) {
            this.nSA.setListener(aVar);
        }
    }

    public void KR(int i) {
        this.nPJ.setStatus(i);
        if (this.nSt != null) {
            this.nSt.dUG();
        }
        if (i == 1) {
            this.nSm.setVisibility(8);
            this.nSp.setVisibility(8);
        } else if (i == 3) {
            this.nSm.setImageResource(R.drawable.video_back_selector);
            this.nSp.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nSm.setImageResource(R.drawable.video_back_selector);
            this.nSp.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nSm.setImageResource(R.drawable.video_delete_selector);
            if (this.nPJ != null && this.nPJ.getVideoDuration() >= 3000.0f) {
                this.nSp.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nSp.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nSm) {
            if (this.nSt != null) {
                this.nSt.dUF();
            }
            int status = this.nPJ.getStatus();
            if (this.nPJ != null && this.nPJ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nPJ.dUh();
                    gb(this.nSw);
                    gb(this.nSx);
                    gb(this.nSy);
                    if (this.nPJ.getVideoDuration() >= 3000.0f) {
                        KR(4);
                        return;
                    } else {
                        KR(this.nPJ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nPJ.dUg();
                KR(5);
            }
        } else if (view == this.nSp) {
            TiebaStatic.log("c12300");
            if (this.nPJ != null && this.nPJ.getStatus() > 2 && this.nSt != null) {
                if (this.nPJ.getVideoDuration() >= 3000.0f) {
                    this.nSt.dUD();
                } else {
                    this.nSt.dUE();
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
        if (this.nPJ.getProgress() >= 100) {
            if (this.nSt != null) {
                this.nSt.dUD();
                return;
            }
            return;
        }
        if (this.nSA.getCurrentBeautyItem() != null) {
            this.nSw.add(this.nSA.getCurrentBeautyItem());
        }
        if (this.nSA.getCurrentFilterItem() != null) {
            this.nSx.add(this.nSA.getCurrentFilterItem());
        }
        if (this.nSA.getCurrentStickItem() != null) {
            this.nSy.add(this.nSA.getCurrentStickItem());
        }
        KR(2);
        if (this.nSA.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nPJ.getStatus() == 6 || VideoControllerLayout.this.nPJ.isRecording()) {
                        VideoControllerLayout.this.zg(z);
                    }
                }
            });
        } else {
            zg(z);
        }
        if (this.nPJ != null) {
            this.nPJ.startRecord();
        }
        if (this.nSt != null) {
            this.nSt.dUy();
        }
    }

    public void stopRecord() {
        dUK();
        int status = this.nPJ.getStatus();
        if (this.nPJ != null) {
            if (!this.nPJ.bUd() && this.nPJ.isRecording()) {
                this.nPJ.stopRecord();
            }
            dUJ();
        }
        if (this.nSt != null) {
            this.nSt.dUm();
            if (status == 6) {
                this.nSt.dUA();
            }
        }
    }

    public void dUJ() {
        if (this.nPJ != null) {
            if (this.nPJ.getVideoDuration() >= 3000.0f) {
                KR(4);
            } else if (this.nPJ.getVideoDuration() > 0) {
                KR(3);
            } else {
                KR(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg(boolean z) {
        if (this.nRA != null && this.nRA.isRunning()) {
            this.nRA.cancel();
        }
        if (this.nRz == null) {
            this.nRz = new AnimatorSet();
            this.nRz.playTogether(ObjectAnimator.ofFloat(this.nSm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nSp, "alpha", 1.0f, 0.0f));
            this.nRz.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTn) {
                        VideoControllerLayout.this.nSm.setVisibility(8);
                        VideoControllerLayout.this.nSp.setVisibility(8);
                    }
                }
            });
            this.nRz.setDuration(300L);
        }
        this.nRz.start();
        if (this.nPJ.getStatus() != 6) {
            this.nSo.zg(z);
        }
    }

    public void dUK() {
        if (this.nPJ == null || this.nPJ.isRecording() || this.nPJ.getStatus() == 6) {
            if (this.nRz != null && this.nRz.isRunning()) {
                this.nRz.cancel();
            }
            if (this.nRA == null) {
                this.nRA = new AnimatorSet();
                this.nRA.playTogether(ObjectAnimator.ofFloat(this.nSm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nSp, "alpha", 0.0f, 1.0f));
                this.nRA.setDuration(300L);
            }
            this.nSm.setVisibility(0);
            this.nSp.setVisibility(0);
            this.nRA.start();
            if (this.nPJ.getStatus() != 7 && this.nPJ.getStatus() != 6) {
                this.nSo.dUK();
                return;
            }
            this.nSo.getTvTip().setVisibility(8);
            if (this.jDB == 2) {
                this.nSo.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jDB) {
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
                if (this.nSt != null) {
                    this.nSt.dUF();
                }
                if (this.nPJ.getStatus() != 7 && this.nPJ.getStatus() != 6) {
                    if (this.nPJ != null && this.nPJ.dUf()) {
                        this.nSv = true;
                        com.baidu.tbadk.core.util.e.brY().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nSq = currentTimeMillis;
                    this.nSr = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nSr && VideoControllerLayout.this.nSq == currentTimeMillis) {
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
                if (this.nSv) {
                    this.nSv = false;
                    return;
                }
                this.nSr = false;
                if (this.nPJ.isRecording() || this.nPJ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nPJ.getStatus() != 8) {
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
                if (this.nPJ.getStatus() == 6) {
                    this.nPJ.setStatus(1);
                    if (this.nSt != null) {
                        this.nSt.dUA();
                        this.nSt.dUm();
                    }
                    this.nSo.getTvTip().setText("");
                    this.nSo.getTvTip().setVisibility(8);
                    return;
                } else if (this.nSA.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nSt != null) {
                    this.nSt.dUz();
                    this.nSo.dUV();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nSo.dUW();
                return;
            default:
                return;
        }
    }

    public void dUt() {
        if (this.nSA.getVisibility() == 0) {
            a((m) null);
        }
        zg(false);
        this.nSo.getLayer1().setVisibility(8);
        this.nSo.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nSo.getTvTip().setVisibility(0);
        if (this.nSt != null) {
            this.nSt.dUy();
        }
    }

    public void dUL() {
        if (this.nPJ.getStatus() == 6) {
            if (this.jDB == 2) {
                KR(7);
                this.nSo.setAlpha(1.0f);
                this.nSm.setVisibility(8);
                this.nSp.setVisibility(8);
                this.nSo.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nPJ != null) {
                    this.nPJ.startRecord();
                    return;
                }
                return;
            }
            this.nSo.getTvTip().setVisibility(8);
            if (this.nSt != null) {
                this.nSt.dUz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUu() {
        if (dUO() && this.nSA.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dUO()) {
            dUN();
        }
        this.nSA.dUu();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUv() {
        if (dUO() && this.nSA.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dUO()) {
            dUN();
        }
        this.nSA.dUv();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUw() {
        if (dUO() && this.nSA.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dUO()) {
            dUN();
        }
        this.nSA.dUw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUx() {
        if (dUO() && this.nSA.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dUO()) {
            dUN();
        }
        this.nSA.dUx();
    }

    private void dUM() {
        if (y.isEmpty(this.nSs)) {
            this.nSs = new ArrayList();
            this.nSs.add(ObjectAnimator.ofFloat(this.nSA, "translationY", 1000.0f, 0.0f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSn, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSo.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSo.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSo.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSo.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSp, "scaleX", 1.0f, 0.7f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSp, "scaleY", 1.0f, 0.7f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSm, "scaleX", 1.0f, 0.7f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSm, "scaleY", 1.0f, 0.7f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSp, "alpha", 1.0f, 0.0f));
            this.nSs.add(ObjectAnimator.ofFloat(this.nSm, "alpha", 1.0f, 0.0f));
        }
    }

    private void dUN() {
        int i = 0;
        if (this.nSA.getVisibility() != 0) {
            this.nSA.setVisibility(0);
            dUM();
            this.nSp.setEnabled(false);
            this.nSm.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nSs.size()) {
                    ObjectAnimator objectAnimator = this.nSs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nSs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nSt != null) {
                                        VideoControllerLayout.this.nSt.dUB();
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
        if (this.nSA.getVisibility() != 8) {
            dUM();
            this.nSp.setEnabled(true);
            this.nSm.setEnabled(true);
            if (this.nPJ.getStatus() == 6 || this.nPJ.isRecording()) {
                this.nSm.setVisibility(8);
                this.nSp.setVisibility(8);
            } else {
                KR(this.nPJ.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nSs.size()) {
                    ObjectAnimator objectAnimator = this.nSs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nSs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nTn) {
                                        VideoControllerLayout.this.nSA.setVisibility(8);
                                        if (VideoControllerLayout.this.nSt != null) {
                                            VideoControllerLayout.this.nSt.dUC();
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
        this.nSt = aVar;
    }

    public void setCurrentTab(int i) {
        this.jDB = i;
        switch (this.jDB) {
            case 1:
                this.nSm.setVisibility(4);
                this.nSp.setVisibility(4);
                this.nSo.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nPJ.getStatus() != 1) {
                    this.nSm.setVisibility(0);
                    this.nSp.setVisibility(0);
                }
                this.nSo.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dUO() {
        return this.nSA.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nSA != null) {
            this.nSA.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nSA != null) {
            this.nSA.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nSA != null) {
            this.nSA.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dUP() {
        if (this.nSA != null) {
            return this.nSA.dUP();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nSu = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nSw;
    }

    public List<e> getChoosedFilterList() {
        return this.nSx;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nSy;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nSz.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nSA != null) {
            this.nSA.setMusicList(this.nSz);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dUQ() {
        if (this.nSA != null) {
            this.nSA.dUQ();
        }
    }

    public void dTD() {
        if (this.nSA != null) {
            this.nSA.dTD();
        }
    }
}
