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
    private i kAY;
    private AnimatorSet kCP;
    private AnimatorSet kCQ;
    private ImageView kDA;
    private RelativeLayout kDB;
    private VideoRecordButton kDC;
    private ImageView kDD;
    private long kDE;
    private boolean kDF;
    private List<ObjectAnimator> kDG;
    private a kDH;
    private boolean kDI;
    private boolean kDJ;
    private List<e> kDK;
    private List<e> kDL;
    private List<StickerItem> kDM;
    private List<e> kDN;
    private VideoEffectLayout kDO;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void cRG();

        void cRR();

        void cRS();

        void cRT();

        void cRU();

        void cRV();

        void cRW();

        void cRX();

        void cRY();

        void cRZ();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kDE = 0L;
        this.kDF = false;
        this.kDI = true;
        this.kDK = new ArrayList();
        this.kDL = new ArrayList();
        this.kDM = new ArrayList();
        this.kDN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kDE = 0L;
        this.kDF = false;
        this.kDI = true;
        this.kDK = new ArrayList();
        this.kDL = new ArrayList();
        this.kDM = new ArrayList();
        this.kDN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kDE = 0L;
        this.kDF = false;
        this.kDI = true;
        this.kDK = new ArrayList();
        this.kDL = new ArrayList();
        this.kDM = new ArrayList();
        this.kDN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kDO = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kDB = (RelativeLayout) findViewById(R.id.layout_record);
        this.kDA = (ImageView) findViewById(R.id.delete_video);
        this.kDA.setOnClickListener(this);
        this.kDC = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kDC.setOnTouchListener(this);
        this.kDD = (ImageView) findViewById(R.id.confirm_video);
        this.kDD.setOnClickListener(this);
        this.kDN.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kDN.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kAY = iVar;
        DM(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kDO != null) {
            this.kDO.setListener(aVar);
        }
    }

    public void DM(int i) {
        this.kAY.setStatus(i);
        if (this.kDH != null) {
            this.kDH.cRZ();
        }
        if (i == 1) {
            this.kDA.setVisibility(8);
            this.kDD.setVisibility(8);
        } else if (i == 3) {
            this.kDA.setImageResource(R.drawable.video_back_selector);
            this.kDD.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kDA.setImageResource(R.drawable.video_back_selector);
            this.kDD.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kDA.setImageResource(R.drawable.video_delete_selector);
            if (this.kAY != null && this.kAY.getVideoDuration() >= 3000.0f) {
                this.kDD.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kDD.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kDA) {
            if (this.kDH != null) {
                this.kDH.cRY();
            }
            int status = this.kAY.getStatus();
            if (this.kAY != null && this.kAY.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kAY.cRC();
                    et(this.kDK);
                    et(this.kDL);
                    et(this.kDM);
                    if (this.kAY.getVideoDuration() >= 3000.0f) {
                        DM(4);
                        return;
                    } else {
                        DM(this.kAY.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kAY.cRB();
                DM(5);
            }
        } else if (view == this.kDD) {
            TiebaStatic.log("c12300");
            if (this.kAY != null && this.kAY.getStatus() > 2 && this.kDH != null) {
                if (this.kAY.getVideoDuration() >= 3000.0f) {
                    this.kDH.cRW();
                } else {
                    this.kDH.cRX();
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
        if (this.kAY.getProgress() >= 100) {
            if (this.kDH != null) {
                this.kDH.cRW();
                return;
            }
            return;
        }
        if (this.kDO.getCurrentBeautyItem() != null) {
            this.kDK.add(this.kDO.getCurrentBeautyItem());
        }
        if (this.kDO.getCurrentFilterItem() != null) {
            this.kDL.add(this.kDO.getCurrentFilterItem());
        }
        if (this.kDO.getCurrentStickItem() != null) {
            this.kDM.add(this.kDO.getCurrentStickItem());
        }
        DM(2);
        if (this.kDO.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kAY.getStatus() == 6 || VideoControllerLayout.this.kAY.isRecording()) {
                        VideoControllerLayout.this.tw(z);
                    }
                }
            });
        } else {
            tw(z);
        }
        if (this.kAY != null) {
            this.kAY.startRecord();
        }
        if (this.kDH != null) {
            this.kDH.cRR();
        }
    }

    public void stopRecord() {
        cSd();
        int status = this.kAY.getStatus();
        if (this.kAY != null) {
            if (!this.kAY.bel() && this.kAY.isRecording()) {
                this.kAY.stopRecord();
            }
            cSc();
        }
        if (this.kDH != null) {
            this.kDH.cRG();
            if (status == 6) {
                this.kDH.cRT();
            }
        }
    }

    public void cSc() {
        if (this.kAY != null) {
            if (this.kAY.getVideoDuration() >= 3000.0f) {
                DM(4);
            } else if (this.kAY.getVideoDuration() > 0) {
                DM(3);
            } else {
                DM(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(boolean z) {
        if (this.kCQ != null && this.kCQ.isRunning()) {
            this.kCQ.cancel();
        }
        if (this.kCP == null) {
            this.kCP = new AnimatorSet();
            this.kCP.playTogether(ObjectAnimator.ofFloat(this.kDA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kDD, "alpha", 1.0f, 0.0f));
            this.kCP.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEB) {
                        VideoControllerLayout.this.kDA.setVisibility(8);
                        VideoControllerLayout.this.kDD.setVisibility(8);
                    }
                }
            });
            this.kCP.setDuration(300L);
        }
        this.kCP.start();
        if (this.kAY.getStatus() != 6) {
            this.kDC.tw(z);
        }
    }

    public void cSd() {
        if (this.kAY == null || this.kAY.isRecording() || this.kAY.getStatus() == 6) {
            if (this.kCP != null && this.kCP.isRunning()) {
                this.kCP.cancel();
            }
            if (this.kCQ == null) {
                this.kCQ = new AnimatorSet();
                this.kCQ.playTogether(ObjectAnimator.ofFloat(this.kDA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kDD, "alpha", 0.0f, 1.0f));
                this.kCQ.setDuration(300L);
            }
            this.kDA.setVisibility(0);
            this.kDD.setVisibility(0);
            this.kCQ.start();
            if (this.kAY.getStatus() != 7 && this.kAY.getStatus() != 6) {
                this.kDC.cSd();
                return;
            }
            this.kDC.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kDC.getLayer1().setVisibility(0);
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
                if (this.kDH != null) {
                    this.kDH.cRY();
                }
                if (this.kAY.getStatus() != 7 && this.kAY.getStatus() != 6) {
                    if (this.kAY != null && this.kAY.cRA()) {
                        this.kDJ = true;
                        com.baidu.tbadk.core.util.e.aFL().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kDE = currentTimeMillis;
                    this.kDF = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kDF && VideoControllerLayout.this.kDE == currentTimeMillis) {
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
                if (this.kDJ) {
                    this.kDJ = false;
                    return;
                }
                this.kDF = false;
                if (this.kAY.isRecording() || this.kAY.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kAY.getStatus() != 8) {
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
                if (this.kAY.getStatus() == 6) {
                    this.kAY.setStatus(1);
                    if (this.kDH != null) {
                        this.kDH.cRT();
                        this.kDH.cRG();
                    }
                    this.kDC.getTvTip().setText("");
                    this.kDC.getTvTip().setVisibility(8);
                    return;
                } else if (this.kDO.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kDH != null) {
                    this.kDH.cRS();
                    this.kDC.cSo();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kDC.cSp();
                return;
            default:
                return;
        }
    }

    public void cRM() {
        if (this.kDO.getVisibility() == 0) {
            a((m) null);
        }
        tw(false);
        this.kDC.getLayer1().setVisibility(8);
        this.kDC.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kDC.getTvTip().setVisibility(0);
        if (this.kDH != null) {
            this.kDH.cRR();
        }
    }

    public void cSe() {
        if (this.kAY.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DM(7);
                this.kDC.setAlpha(1.0f);
                this.kDA.setVisibility(8);
                this.kDD.setVisibility(8);
                this.kDC.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kAY != null) {
                    this.kAY.startRecord();
                    return;
                }
                return;
            }
            this.kDC.getTvTip().setVisibility(8);
            if (this.kDH != null) {
                this.kDH.cRS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        if (cSh() && this.kDO.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cSh()) {
            cSg();
        }
        this.kDO.cRN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        if (cSh() && this.kDO.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cSh()) {
            cSg();
        }
        this.kDO.cRO();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        if (cSh() && this.kDO.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cSh()) {
            cSg();
        }
        this.kDO.cRP();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRQ() {
        if (cSh() && this.kDO.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cSh()) {
            cSg();
        }
        this.kDO.cRQ();
    }

    private void cSf() {
        if (v.isEmpty(this.kDG)) {
            this.kDG = new ArrayList();
            this.kDG.add(ObjectAnimator.ofFloat(this.kDO, "translationY", 1000.0f, 0.0f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDB, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDC.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDC.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDC.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDC.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDD, "scaleX", 1.0f, 0.7f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDD, "scaleY", 1.0f, 0.7f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDA, "scaleX", 1.0f, 0.7f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDA, "scaleY", 1.0f, 0.7f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDD, "alpha", 1.0f, 0.0f));
            this.kDG.add(ObjectAnimator.ofFloat(this.kDA, "alpha", 1.0f, 0.0f));
        }
    }

    private void cSg() {
        int i = 0;
        if (this.kDO.getVisibility() != 0) {
            this.kDO.setVisibility(0);
            cSf();
            this.kDD.setEnabled(false);
            this.kDA.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kDG.size()) {
                    ObjectAnimator objectAnimator = this.kDG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kDH != null) {
                                        VideoControllerLayout.this.kDH.cRU();
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
        if (this.kDO.getVisibility() != 8) {
            cSf();
            this.kDD.setEnabled(true);
            this.kDA.setEnabled(true);
            if (this.kAY.getStatus() == 6 || this.kAY.isRecording()) {
                this.kDA.setVisibility(8);
                this.kDD.setVisibility(8);
            } else {
                DM(this.kAY.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kDG.size()) {
                    ObjectAnimator objectAnimator = this.kDG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kDG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kEB) {
                                        VideoControllerLayout.this.kDO.setVisibility(8);
                                        if (VideoControllerLayout.this.kDH != null) {
                                            VideoControllerLayout.this.kDH.cRV();
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
        this.kDH = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kDA.setVisibility(4);
                this.kDD.setVisibility(4);
                this.kDC.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kAY.getStatus() != 1) {
                    this.kDA.setVisibility(0);
                    this.kDD.setVisibility(0);
                }
                this.kDC.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cSh() {
        return this.kDO.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kDO != null) {
            this.kDO.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kDO != null) {
            this.kDO.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kDO != null) {
            this.kDO.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cSi() {
        if (this.kDO != null) {
            return this.kDO.cSi();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kDI = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kDK;
    }

    public List<e> getChoosedFilterList() {
        return this.kDL;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kDM;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kDN.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kDO != null) {
            this.kDO.setMusicList(this.kDN);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void cSj() {
        if (this.kDO != null) {
            this.kDO.cSj();
        }
    }

    public void cRa() {
        if (this.kDO != null) {
            this.kDO.cRa();
        }
    }
}
