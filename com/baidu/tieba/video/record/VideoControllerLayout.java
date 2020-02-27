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
    private i kAK;
    private AnimatorSet kCB;
    private AnimatorSet kCC;
    private VideoEffectLayout kDA;
    private ImageView kDm;
    private RelativeLayout kDn;
    private VideoRecordButton kDo;
    private ImageView kDp;
    private long kDq;
    private boolean kDr;
    private List<ObjectAnimator> kDs;
    private a kDt;
    private boolean kDu;
    private boolean kDv;
    private List<e> kDw;
    private List<e> kDx;
    private List<StickerItem> kDy;
    private List<e> kDz;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void cRD();

        void cRO();

        void cRP();

        void cRQ();

        void cRR();

        void cRS();

        void cRT();

        void cRU();

        void cRV();

        void cRW();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kDq = 0L;
        this.kDr = false;
        this.kDu = true;
        this.kDw = new ArrayList();
        this.kDx = new ArrayList();
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kDq = 0L;
        this.kDr = false;
        this.kDu = true;
        this.kDw = new ArrayList();
        this.kDx = new ArrayList();
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kDq = 0L;
        this.kDr = false;
        this.kDu = true;
        this.kDw = new ArrayList();
        this.kDx = new ArrayList();
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kDA = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kDn = (RelativeLayout) findViewById(R.id.layout_record);
        this.kDm = (ImageView) findViewById(R.id.delete_video);
        this.kDm.setOnClickListener(this);
        this.kDo = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kDo.setOnTouchListener(this);
        this.kDp = (ImageView) findViewById(R.id.confirm_video);
        this.kDp.setOnClickListener(this);
        this.kDz.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kDz.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kAK = iVar;
        DM(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kDA != null) {
            this.kDA.setListener(aVar);
        }
    }

    public void DM(int i) {
        this.kAK.setStatus(i);
        if (this.kDt != null) {
            this.kDt.cRW();
        }
        if (i == 1) {
            this.kDm.setVisibility(8);
            this.kDp.setVisibility(8);
        } else if (i == 3) {
            this.kDm.setImageResource(R.drawable.video_back_selector);
            this.kDp.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kDm.setImageResource(R.drawable.video_back_selector);
            this.kDp.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kDm.setImageResource(R.drawable.video_delete_selector);
            if (this.kAK != null && this.kAK.getVideoDuration() >= 3000.0f) {
                this.kDp.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kDp.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kDm) {
            if (this.kDt != null) {
                this.kDt.cRV();
            }
            int status = this.kAK.getStatus();
            if (this.kAK != null && this.kAK.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kAK.cRz();
                    et(this.kDw);
                    et(this.kDx);
                    et(this.kDy);
                    if (this.kAK.getVideoDuration() >= 3000.0f) {
                        DM(4);
                        return;
                    } else {
                        DM(this.kAK.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kAK.cRy();
                DM(5);
            }
        } else if (view == this.kDp) {
            TiebaStatic.log("c12300");
            if (this.kAK != null && this.kAK.getStatus() > 2 && this.kDt != null) {
                if (this.kAK.getVideoDuration() >= 3000.0f) {
                    this.kDt.cRT();
                } else {
                    this.kDt.cRU();
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
    public void cX(final boolean z) {
        if (this.kAK.getProgress() >= 100) {
            if (this.kDt != null) {
                this.kDt.cRT();
                return;
            }
            return;
        }
        if (this.kDA.getCurrentBeautyItem() != null) {
            this.kDw.add(this.kDA.getCurrentBeautyItem());
        }
        if (this.kDA.getCurrentFilterItem() != null) {
            this.kDx.add(this.kDA.getCurrentFilterItem());
        }
        if (this.kDA.getCurrentStickItem() != null) {
            this.kDy.add(this.kDA.getCurrentStickItem());
        }
        DM(2);
        if (this.kDA.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kAK.getStatus() == 6 || VideoControllerLayout.this.kAK.isRecording()) {
                        VideoControllerLayout.this.tw(z);
                    }
                }
            });
        } else {
            tw(z);
        }
        if (this.kAK != null) {
            this.kAK.startRecord();
        }
        if (this.kDt != null) {
            this.kDt.cRO();
        }
    }

    public void stopRecord() {
        cSa();
        int status = this.kAK.getStatus();
        if (this.kAK != null) {
            if (!this.kAK.bei() && this.kAK.isRecording()) {
                this.kAK.stopRecord();
            }
            cRZ();
        }
        if (this.kDt != null) {
            this.kDt.cRD();
            if (status == 6) {
                this.kDt.cRQ();
            }
        }
    }

    public void cRZ() {
        if (this.kAK != null) {
            if (this.kAK.getVideoDuration() >= 3000.0f) {
                DM(4);
            } else if (this.kAK.getVideoDuration() > 0) {
                DM(3);
            } else {
                DM(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (this.kCC != null && this.kCC.isRunning()) {
            this.kCC.cancel();
        }
        if (this.kCB == null) {
            this.kCB = new AnimatorSet();
            this.kCB.playTogether(ObjectAnimator.ofFloat(this.kDm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kDp, "alpha", 1.0f, 0.0f));
            this.kCB.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEn) {
                        VideoControllerLayout.this.kDm.setVisibility(8);
                        VideoControllerLayout.this.kDp.setVisibility(8);
                    }
                }
            });
            this.kCB.setDuration(300L);
        }
        this.kCB.start();
        if (this.kAK.getStatus() != 6) {
            this.kDo.tw(z);
        }
    }

    public void cSa() {
        if (this.kAK == null || this.kAK.isRecording() || this.kAK.getStatus() == 6) {
            if (this.kCB != null && this.kCB.isRunning()) {
                this.kCB.cancel();
            }
            if (this.kCC == null) {
                this.kCC = new AnimatorSet();
                this.kCC.playTogether(ObjectAnimator.ofFloat(this.kDm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kDp, "alpha", 0.0f, 1.0f));
                this.kCC.setDuration(300L);
            }
            this.kDm.setVisibility(0);
            this.kDp.setVisibility(0);
            this.kCC.start();
            if (this.kAK.getStatus() != 7 && this.kAK.getStatus() != 6) {
                this.kDo.cSa();
                return;
            }
            this.kDo.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kDo.getLayer1().setVisibility(0);
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
                if (this.kDt != null) {
                    this.kDt.cRV();
                }
                if (this.kAK.getStatus() != 7 && this.kAK.getStatus() != 6) {
                    if (this.kAK != null && this.kAK.cRx()) {
                        this.kDv = true;
                        com.baidu.tbadk.core.util.e.aFJ().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kDq = currentTimeMillis;
                    this.kDr = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kDr && VideoControllerLayout.this.kDq == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.cX(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.kDv) {
                    this.kDv = false;
                    return;
                }
                this.kDr = false;
                if (this.kAK.isRecording() || this.kAK.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kAK.getStatus() != 8) {
                    cX(false);
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
                if (this.kAK.getStatus() == 6) {
                    this.kAK.setStatus(1);
                    if (this.kDt != null) {
                        this.kDt.cRQ();
                        this.kDt.cRD();
                    }
                    this.kDo.getTvTip().setText("");
                    this.kDo.getTvTip().setVisibility(8);
                    return;
                } else if (this.kDA.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kDt != null) {
                    this.kDt.cRP();
                    this.kDo.cSl();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kDo.cSm();
                return;
            default:
                return;
        }
    }

    public void cRJ() {
        if (this.kDA.getVisibility() == 0) {
            a((m) null);
        }
        tw(false);
        this.kDo.getLayer1().setVisibility(8);
        this.kDo.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kDo.getTvTip().setVisibility(0);
        if (this.kDt != null) {
            this.kDt.cRO();
        }
    }

    public void cSb() {
        if (this.kAK.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DM(7);
                this.kDo.setAlpha(1.0f);
                this.kDm.setVisibility(8);
                this.kDp.setVisibility(8);
                this.kDo.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kAK != null) {
                    this.kAK.startRecord();
                    return;
                }
                return;
            }
            this.kDo.getTvTip().setVisibility(8);
            if (this.kDt != null) {
                this.kDt.cRP();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRK() {
        if (cSe() && this.kDA.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cSe()) {
            cSd();
        }
        this.kDA.cRK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRL() {
        if (cSe() && this.kDA.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cSe()) {
            cSd();
        }
        this.kDA.cRL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        if (cSe() && this.kDA.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cSe()) {
            cSd();
        }
        this.kDA.cRM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        if (cSe() && this.kDA.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cSe()) {
            cSd();
        }
        this.kDA.cRN();
    }

    private void cSc() {
        if (v.isEmpty(this.kDs)) {
            this.kDs = new ArrayList();
            this.kDs.add(ObjectAnimator.ofFloat(this.kDA, "translationY", 1000.0f, 0.0f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDn, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDo.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDo.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDo.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDo.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDp, "scaleX", 1.0f, 0.7f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDp, "scaleY", 1.0f, 0.7f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDm, "scaleX", 1.0f, 0.7f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDm, "scaleY", 1.0f, 0.7f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDp, "alpha", 1.0f, 0.0f));
            this.kDs.add(ObjectAnimator.ofFloat(this.kDm, "alpha", 1.0f, 0.0f));
        }
    }

    private void cSd() {
        int i = 0;
        if (this.kDA.getVisibility() != 0) {
            this.kDA.setVisibility(0);
            cSc();
            this.kDp.setEnabled(false);
            this.kDm.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kDs.size()) {
                    ObjectAnimator objectAnimator = this.kDs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kDt != null) {
                                        VideoControllerLayout.this.kDt.cRR();
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
        if (this.kDA.getVisibility() != 8) {
            cSc();
            this.kDp.setEnabled(true);
            this.kDm.setEnabled(true);
            if (this.kAK.getStatus() == 6 || this.kAK.isRecording()) {
                this.kDm.setVisibility(8);
                this.kDp.setVisibility(8);
            } else {
                DM(this.kAK.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kDs.size()) {
                    ObjectAnimator objectAnimator = this.kDs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kEn) {
                                        VideoControllerLayout.this.kDA.setVisibility(8);
                                        if (VideoControllerLayout.this.kDt != null) {
                                            VideoControllerLayout.this.kDt.cRS();
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
        this.kDt = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kDm.setVisibility(4);
                this.kDp.setVisibility(4);
                this.kDo.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kAK.getStatus() != 1) {
                    this.kDm.setVisibility(0);
                    this.kDp.setVisibility(0);
                }
                this.kDo.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cSe() {
        return this.kDA.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kDA != null) {
            this.kDA.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kDA != null) {
            this.kDA.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kDA != null) {
            this.kDA.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cSf() {
        if (this.kDA != null) {
            return this.kDA.cSf();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kDu = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kDw;
    }

    public List<e> getChoosedFilterList() {
        return this.kDx;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kDy;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kDz.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kDA != null) {
            this.kDA.setMusicList(this.kDz);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void cSg() {
        if (this.kDA != null) {
            this.kDA.cSg();
        }
    }

    public void cQX() {
        if (this.kDA != null) {
            this.kDA.cQX();
        }
    }
}
