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
/* loaded from: classes10.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private i kCF;
    private AnimatorSet kEw;
    private AnimatorSet kEx;
    private ImageView kFh;
    private RelativeLayout kFi;
    private VideoRecordButton kFj;
    private ImageView kFk;
    private long kFl;
    private boolean kFm;
    private List<ObjectAnimator> kFn;
    private a kFo;
    private boolean kFp;
    private boolean kFq;
    private List<e> kFr;
    private List<e> kFs;
    private List<StickerItem> kFt;
    private List<e> kFu;
    private VideoEffectLayout kFv;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void cSa();

        void cSl();

        void cSm();

        void cSn();

        void cSo();

        void cSp();

        void cSq();

        void cSr();

        void cSs();

        void cSt();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kFl = 0L;
        this.kFm = false;
        this.kFp = true;
        this.kFr = new ArrayList();
        this.kFs = new ArrayList();
        this.kFt = new ArrayList();
        this.kFu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kFl = 0L;
        this.kFm = false;
        this.kFp = true;
        this.kFr = new ArrayList();
        this.kFs = new ArrayList();
        this.kFt = new ArrayList();
        this.kFu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kFl = 0L;
        this.kFm = false;
        this.kFp = true;
        this.kFr = new ArrayList();
        this.kFs = new ArrayList();
        this.kFt = new ArrayList();
        this.kFu = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kFv = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kFi = (RelativeLayout) findViewById(R.id.layout_record);
        this.kFh = (ImageView) findViewById(R.id.delete_video);
        this.kFh.setOnClickListener(this);
        this.kFj = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kFj.setOnTouchListener(this);
        this.kFk = (ImageView) findViewById(R.id.confirm_video);
        this.kFk.setOnClickListener(this);
        this.kFu.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kFu.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kCF = iVar;
        DU(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kFv != null) {
            this.kFv.setListener(aVar);
        }
    }

    public void DU(int i) {
        this.kCF.setStatus(i);
        if (this.kFo != null) {
            this.kFo.cSt();
        }
        if (i == 1) {
            this.kFh.setVisibility(8);
            this.kFk.setVisibility(8);
        } else if (i == 3) {
            this.kFh.setImageResource(R.drawable.video_back_selector);
            this.kFk.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kFh.setImageResource(R.drawable.video_back_selector);
            this.kFk.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kFh.setImageResource(R.drawable.video_delete_selector);
            if (this.kCF != null && this.kCF.getVideoDuration() >= 3000.0f) {
                this.kFk.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kFk.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kFh) {
            if (this.kFo != null) {
                this.kFo.cSs();
            }
            int status = this.kCF.getStatus();
            if (this.kCF != null && this.kCF.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kCF.cRW();
                    et(this.kFr);
                    et(this.kFs);
                    et(this.kFt);
                    if (this.kCF.getVideoDuration() >= 3000.0f) {
                        DU(4);
                        return;
                    } else {
                        DU(this.kCF.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kCF.cRV();
                DU(5);
            }
        } else if (view == this.kFk) {
            TiebaStatic.log("c12300");
            if (this.kCF != null && this.kCF.getStatus() > 2 && this.kFo != null) {
                if (this.kCF.getVideoDuration() >= 3000.0f) {
                    this.kFo.cSq();
                } else {
                    this.kFo.cSr();
                }
            }
        }
    }

    private void et(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY(final boolean z) {
        if (this.kCF.getProgress() >= 100) {
            if (this.kFo != null) {
                this.kFo.cSq();
                return;
            }
            return;
        }
        if (this.kFv.getCurrentBeautyItem() != null) {
            this.kFr.add(this.kFv.getCurrentBeautyItem());
        }
        if (this.kFv.getCurrentFilterItem() != null) {
            this.kFs.add(this.kFv.getCurrentFilterItem());
        }
        if (this.kFv.getCurrentStickItem() != null) {
            this.kFt.add(this.kFv.getCurrentStickItem());
        }
        DU(2);
        if (this.kFv.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kCF.getStatus() == 6 || VideoControllerLayout.this.kCF.isRecording()) {
                        VideoControllerLayout.this.tC(z);
                    }
                }
            });
        } else {
            tC(z);
        }
        if (this.kCF != null) {
            this.kCF.startRecord();
        }
        if (this.kFo != null) {
            this.kFo.cSl();
        }
    }

    public void stopRecord() {
        cSx();
        int status = this.kCF.getStatus();
        if (this.kCF != null) {
            if (!this.kCF.beq() && this.kCF.isRecording()) {
                this.kCF.stopRecord();
            }
            cSw();
        }
        if (this.kFo != null) {
            this.kFo.cSa();
            if (status == 6) {
                this.kFo.cSn();
            }
        }
    }

    public void cSw() {
        if (this.kCF != null) {
            if (this.kCF.getVideoDuration() >= 3000.0f) {
                DU(4);
            } else if (this.kCF.getVideoDuration() > 0) {
                DU(3);
            } else {
                DU(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tC(boolean z) {
        if (this.kEx != null && this.kEx.isRunning()) {
            this.kEx.cancel();
        }
        if (this.kEw == null) {
            this.kEw = new AnimatorSet();
            this.kEw.playTogether(ObjectAnimator.ofFloat(this.kFh, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kFk, "alpha", 1.0f, 0.0f));
            this.kEw.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kGi) {
                        VideoControllerLayout.this.kFh.setVisibility(8);
                        VideoControllerLayout.this.kFk.setVisibility(8);
                    }
                }
            });
            this.kEw.setDuration(300L);
        }
        this.kEw.start();
        if (this.kCF.getStatus() != 6) {
            this.kFj.tC(z);
        }
    }

    public void cSx() {
        if (this.kCF == null || this.kCF.isRecording() || this.kCF.getStatus() == 6) {
            if (this.kEw != null && this.kEw.isRunning()) {
                this.kEw.cancel();
            }
            if (this.kEx == null) {
                this.kEx = new AnimatorSet();
                this.kEx.playTogether(ObjectAnimator.ofFloat(this.kFh, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kFk, "alpha", 0.0f, 1.0f));
                this.kEx.setDuration(300L);
            }
            this.kFh.setVisibility(0);
            this.kFk.setVisibility(0);
            this.kEx.start();
            if (this.kCF.getStatus() != 7 && this.kCF.getStatus() != 6) {
                this.kFj.cSx();
                return;
            }
            this.kFj.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kFj.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.mCurrentTab) {
            case 1:
                f(view, motionEvent);
                return true;
            case 2:
                e(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void e(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kFo != null) {
                    this.kFo.cSs();
                }
                if (this.kCF.getStatus() != 7 && this.kCF.getStatus() != 6) {
                    if (this.kCF != null && this.kCF.cRU()) {
                        this.kFq = true;
                        com.baidu.tbadk.core.util.e.aFP().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kFl = currentTimeMillis;
                    this.kFm = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kFm && VideoControllerLayout.this.kFl == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.cY(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.kFq) {
                    this.kFq = false;
                    return;
                }
                this.kFm = false;
                if (this.kCF.isRecording() || this.kCF.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kCF.getStatus() != 8) {
                    cY(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void f(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kCF.getStatus() == 6) {
                    this.kCF.setStatus(1);
                    if (this.kFo != null) {
                        this.kFo.cSn();
                        this.kFo.cSa();
                    }
                    this.kFj.getTvTip().setText("");
                    this.kFj.getTvTip().setVisibility(8);
                    return;
                } else if (this.kFv.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kFo != null) {
                    this.kFo.cSm();
                    this.kFj.cSI();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kFj.cSJ();
                return;
            default:
                return;
        }
    }

    public void cSg() {
        if (this.kFv.getVisibility() == 0) {
            a((m) null);
        }
        tC(false);
        this.kFj.getLayer1().setVisibility(8);
        this.kFj.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kFj.getTvTip().setVisibility(0);
        if (this.kFo != null) {
            this.kFo.cSl();
        }
    }

    public void cSy() {
        if (this.kCF.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DU(7);
                this.kFj.setAlpha(1.0f);
                this.kFh.setVisibility(8);
                this.kFk.setVisibility(8);
                this.kFj.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kCF != null) {
                    this.kCF.startRecord();
                    return;
                }
                return;
            }
            this.kFj.getTvTip().setVisibility(8);
            if (this.kFo != null) {
                this.kFo.cSm();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSh() {
        if (cSB() && this.kFv.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cSB()) {
            cSA();
        }
        this.kFv.cSh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSi() {
        if (cSB() && this.kFv.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cSB()) {
            cSA();
        }
        this.kFv.cSi();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSj() {
        if (cSB() && this.kFv.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cSB()) {
            cSA();
        }
        this.kFv.cSj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSk() {
        if (cSB() && this.kFv.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cSB()) {
            cSA();
        }
        this.kFv.cSk();
    }

    private void cSz() {
        if (v.isEmpty(this.kFn)) {
            this.kFn = new ArrayList();
            this.kFn.add(ObjectAnimator.ofFloat(this.kFv, "translationY", 1000.0f, 0.0f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFi, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFj.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFj.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFj.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFj.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFk, "scaleX", 1.0f, 0.7f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFk, "scaleY", 1.0f, 0.7f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFh, "scaleX", 1.0f, 0.7f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFh, "scaleY", 1.0f, 0.7f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFk, "alpha", 1.0f, 0.0f));
            this.kFn.add(ObjectAnimator.ofFloat(this.kFh, "alpha", 1.0f, 0.0f));
        }
    }

    private void cSA() {
        int i = 0;
        if (this.kFv.getVisibility() != 0) {
            this.kFv.setVisibility(0);
            cSz();
            this.kFk.setEnabled(false);
            this.kFh.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kFn.size()) {
                    ObjectAnimator objectAnimator = this.kFn.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kFn.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kFo != null) {
                                        VideoControllerLayout.this.kFo.cSo();
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
        if (this.kFv.getVisibility() != 8) {
            cSz();
            this.kFk.setEnabled(true);
            this.kFh.setEnabled(true);
            if (this.kCF.getStatus() == 6 || this.kCF.isRecording()) {
                this.kFh.setVisibility(8);
                this.kFk.setVisibility(8);
            } else {
                DU(this.kCF.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kFn.size()) {
                    ObjectAnimator objectAnimator = this.kFn.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kFn.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kGi) {
                                        VideoControllerLayout.this.kFv.setVisibility(8);
                                        if (VideoControllerLayout.this.kFo != null) {
                                            VideoControllerLayout.this.kFo.cSp();
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
        this.kFo = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kFh.setVisibility(4);
                this.kFk.setVisibility(4);
                this.kFj.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kCF.getStatus() != 1) {
                    this.kFh.setVisibility(0);
                    this.kFk.setVisibility(0);
                }
                this.kFj.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cSB() {
        return this.kFv.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kFv != null) {
            this.kFv.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kFv != null) {
            this.kFv.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kFv != null) {
            this.kFv.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cSC() {
        if (this.kFv != null) {
            return this.kFv.cSC();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kFp = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kFr;
    }

    public List<e> getChoosedFilterList() {
        return this.kFs;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kFt;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kFu.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kFv != null) {
            this.kFv.setMusicList(this.kFu);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void cSD() {
        if (this.kFv != null) {
            this.kFv.cSD();
        }
    }

    public void cRu() {
        if (this.kFv != null) {
            this.kFv.cRu();
        }
    }
}
