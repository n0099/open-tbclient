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
    private i kAM;
    private AnimatorSet kCD;
    private AnimatorSet kCE;
    private List<StickerItem> kDA;
    private List<e> kDB;
    private VideoEffectLayout kDC;
    private ImageView kDo;
    private RelativeLayout kDp;
    private VideoRecordButton kDq;
    private ImageView kDr;
    private long kDs;
    private boolean kDt;
    private List<ObjectAnimator> kDu;
    private a kDv;
    private boolean kDw;
    private boolean kDx;
    private List<e> kDy;
    private List<e> kDz;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void cRF();

        void cRQ();

        void cRR();

        void cRS();

        void cRT();

        void cRU();

        void cRV();

        void cRW();

        void cRX();

        void cRY();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kDs = 0L;
        this.kDt = false;
        this.kDw = true;
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.kDA = new ArrayList();
        this.kDB = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kDs = 0L;
        this.kDt = false;
        this.kDw = true;
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.kDA = new ArrayList();
        this.kDB = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kDs = 0L;
        this.kDt = false;
        this.kDw = true;
        this.kDy = new ArrayList();
        this.kDz = new ArrayList();
        this.kDA = new ArrayList();
        this.kDB = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kDC = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kDp = (RelativeLayout) findViewById(R.id.layout_record);
        this.kDo = (ImageView) findViewById(R.id.delete_video);
        this.kDo.setOnClickListener(this);
        this.kDq = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kDq.setOnTouchListener(this);
        this.kDr = (ImageView) findViewById(R.id.confirm_video);
        this.kDr.setOnClickListener(this);
        this.kDB.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kDB.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kAM = iVar;
        DM(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kDC != null) {
            this.kDC.setListener(aVar);
        }
    }

    public void DM(int i) {
        this.kAM.setStatus(i);
        if (this.kDv != null) {
            this.kDv.cRY();
        }
        if (i == 1) {
            this.kDo.setVisibility(8);
            this.kDr.setVisibility(8);
        } else if (i == 3) {
            this.kDo.setImageResource(R.drawable.video_back_selector);
            this.kDr.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kDo.setImageResource(R.drawable.video_back_selector);
            this.kDr.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kDo.setImageResource(R.drawable.video_delete_selector);
            if (this.kAM != null && this.kAM.getVideoDuration() >= 3000.0f) {
                this.kDr.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kDr.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kDo) {
            if (this.kDv != null) {
                this.kDv.cRX();
            }
            int status = this.kAM.getStatus();
            if (this.kAM != null && this.kAM.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kAM.cRB();
                    et(this.kDy);
                    et(this.kDz);
                    et(this.kDA);
                    if (this.kAM.getVideoDuration() >= 3000.0f) {
                        DM(4);
                        return;
                    } else {
                        DM(this.kAM.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kAM.cRA();
                DM(5);
            }
        } else if (view == this.kDr) {
            TiebaStatic.log("c12300");
            if (this.kAM != null && this.kAM.getStatus() > 2 && this.kDv != null) {
                if (this.kAM.getVideoDuration() >= 3000.0f) {
                    this.kDv.cRV();
                } else {
                    this.kDv.cRW();
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
        if (this.kAM.getProgress() >= 100) {
            if (this.kDv != null) {
                this.kDv.cRV();
                return;
            }
            return;
        }
        if (this.kDC.getCurrentBeautyItem() != null) {
            this.kDy.add(this.kDC.getCurrentBeautyItem());
        }
        if (this.kDC.getCurrentFilterItem() != null) {
            this.kDz.add(this.kDC.getCurrentFilterItem());
        }
        if (this.kDC.getCurrentStickItem() != null) {
            this.kDA.add(this.kDC.getCurrentStickItem());
        }
        DM(2);
        if (this.kDC.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kAM.getStatus() == 6 || VideoControllerLayout.this.kAM.isRecording()) {
                        VideoControllerLayout.this.tw(z);
                    }
                }
            });
        } else {
            tw(z);
        }
        if (this.kAM != null) {
            this.kAM.startRecord();
        }
        if (this.kDv != null) {
            this.kDv.cRQ();
        }
    }

    public void stopRecord() {
        cSc();
        int status = this.kAM.getStatus();
        if (this.kAM != null) {
            if (!this.kAM.bek() && this.kAM.isRecording()) {
                this.kAM.stopRecord();
            }
            cSb();
        }
        if (this.kDv != null) {
            this.kDv.cRF();
            if (status == 6) {
                this.kDv.cRS();
            }
        }
    }

    public void cSb() {
        if (this.kAM != null) {
            if (this.kAM.getVideoDuration() >= 3000.0f) {
                DM(4);
            } else if (this.kAM.getVideoDuration() > 0) {
                DM(3);
            } else {
                DM(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (this.kCE != null && this.kCE.isRunning()) {
            this.kCE.cancel();
        }
        if (this.kCD == null) {
            this.kCD = new AnimatorSet();
            this.kCD.playTogether(ObjectAnimator.ofFloat(this.kDo, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kDr, "alpha", 1.0f, 0.0f));
            this.kCD.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEp) {
                        VideoControllerLayout.this.kDo.setVisibility(8);
                        VideoControllerLayout.this.kDr.setVisibility(8);
                    }
                }
            });
            this.kCD.setDuration(300L);
        }
        this.kCD.start();
        if (this.kAM.getStatus() != 6) {
            this.kDq.tw(z);
        }
    }

    public void cSc() {
        if (this.kAM == null || this.kAM.isRecording() || this.kAM.getStatus() == 6) {
            if (this.kCD != null && this.kCD.isRunning()) {
                this.kCD.cancel();
            }
            if (this.kCE == null) {
                this.kCE = new AnimatorSet();
                this.kCE.playTogether(ObjectAnimator.ofFloat(this.kDo, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kDr, "alpha", 0.0f, 1.0f));
                this.kCE.setDuration(300L);
            }
            this.kDo.setVisibility(0);
            this.kDr.setVisibility(0);
            this.kCE.start();
            if (this.kAM.getStatus() != 7 && this.kAM.getStatus() != 6) {
                this.kDq.cSc();
                return;
            }
            this.kDq.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kDq.getLayer1().setVisibility(0);
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
                if (this.kDv != null) {
                    this.kDv.cRX();
                }
                if (this.kAM.getStatus() != 7 && this.kAM.getStatus() != 6) {
                    if (this.kAM != null && this.kAM.cRz()) {
                        this.kDx = true;
                        com.baidu.tbadk.core.util.e.aFL().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kDs = currentTimeMillis;
                    this.kDt = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kDt && VideoControllerLayout.this.kDs == currentTimeMillis) {
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
                if (this.kDx) {
                    this.kDx = false;
                    return;
                }
                this.kDt = false;
                if (this.kAM.isRecording() || this.kAM.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kAM.getStatus() != 8) {
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
                if (this.kAM.getStatus() == 6) {
                    this.kAM.setStatus(1);
                    if (this.kDv != null) {
                        this.kDv.cRS();
                        this.kDv.cRF();
                    }
                    this.kDq.getTvTip().setText("");
                    this.kDq.getTvTip().setVisibility(8);
                    return;
                } else if (this.kDC.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kDv != null) {
                    this.kDv.cRR();
                    this.kDq.cSn();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kDq.cSo();
                return;
            default:
                return;
        }
    }

    public void cRL() {
        if (this.kDC.getVisibility() == 0) {
            a((m) null);
        }
        tw(false);
        this.kDq.getLayer1().setVisibility(8);
        this.kDq.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kDq.getTvTip().setVisibility(0);
        if (this.kDv != null) {
            this.kDv.cRQ();
        }
    }

    public void cSd() {
        if (this.kAM.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DM(7);
                this.kDq.setAlpha(1.0f);
                this.kDo.setVisibility(8);
                this.kDr.setVisibility(8);
                this.kDq.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kAM != null) {
                    this.kAM.startRecord();
                    return;
                }
                return;
            }
            this.kDq.getTvTip().setVisibility(8);
            if (this.kDv != null) {
                this.kDv.cRR();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        if (cSg() && this.kDC.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cSg()) {
            cSf();
        }
        this.kDC.cRM();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        if (cSg() && this.kDC.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cSg()) {
            cSf();
        }
        this.kDC.cRN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        if (cSg() && this.kDC.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cSg()) {
            cSf();
        }
        this.kDC.cRO();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        if (cSg() && this.kDC.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cSg()) {
            cSf();
        }
        this.kDC.cRP();
    }

    private void cSe() {
        if (v.isEmpty(this.kDu)) {
            this.kDu = new ArrayList();
            this.kDu.add(ObjectAnimator.ofFloat(this.kDC, "translationY", 1000.0f, 0.0f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDp, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDq.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDq.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDq.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDq.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDr, "scaleX", 1.0f, 0.7f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDr, "scaleY", 1.0f, 0.7f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDo, "scaleX", 1.0f, 0.7f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDo, "scaleY", 1.0f, 0.7f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDr, "alpha", 1.0f, 0.0f));
            this.kDu.add(ObjectAnimator.ofFloat(this.kDo, "alpha", 1.0f, 0.0f));
        }
    }

    private void cSf() {
        int i = 0;
        if (this.kDC.getVisibility() != 0) {
            this.kDC.setVisibility(0);
            cSe();
            this.kDr.setEnabled(false);
            this.kDo.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kDu.size()) {
                    ObjectAnimator objectAnimator = this.kDu.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDu.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kDv != null) {
                                        VideoControllerLayout.this.kDv.cRT();
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
        if (this.kDC.getVisibility() != 8) {
            cSe();
            this.kDr.setEnabled(true);
            this.kDo.setEnabled(true);
            if (this.kAM.getStatus() == 6 || this.kAM.isRecording()) {
                this.kDo.setVisibility(8);
                this.kDr.setVisibility(8);
            } else {
                DM(this.kAM.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kDu.size()) {
                    ObjectAnimator objectAnimator = this.kDu.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDu.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kEp) {
                                        VideoControllerLayout.this.kDC.setVisibility(8);
                                        if (VideoControllerLayout.this.kDv != null) {
                                            VideoControllerLayout.this.kDv.cRU();
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
        this.kDv = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kDo.setVisibility(4);
                this.kDr.setVisibility(4);
                this.kDq.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kAM.getStatus() != 1) {
                    this.kDo.setVisibility(0);
                    this.kDr.setVisibility(0);
                }
                this.kDq.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cSg() {
        return this.kDC.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kDC != null) {
            this.kDC.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kDC != null) {
            this.kDC.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kDC != null) {
            this.kDC.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cSh() {
        if (this.kDC != null) {
            return this.kDC.cSh();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kDw = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kDy;
    }

    public List<e> getChoosedFilterList() {
        return this.kDz;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kDA;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kDB.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kDC != null) {
            this.kDC.setMusicList(this.kDB);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void cSi() {
        if (this.kDC != null) {
            this.kDC.cSi();
        }
    }

    public void cQZ() {
        if (this.kDC != null) {
            this.kDC.cQZ();
        }
    }
}
