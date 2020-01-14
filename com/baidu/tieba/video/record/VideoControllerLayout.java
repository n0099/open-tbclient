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
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private AnimatorSet kBG;
    private AnimatorSet kBH;
    private boolean kCA;
    private List<e> kCB;
    private List<e> kCC;
    private List<StickerItem> kCD;
    private List<e> kCE;
    private VideoEffectLayout kCF;
    private ImageView kCr;
    private RelativeLayout kCs;
    private VideoRecordButton kCt;
    private ImageView kCu;
    private long kCv;
    private boolean kCw;
    private List<ObjectAnimator> kCx;
    private a kCy;
    private boolean kCz;
    private i kzP;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes8.dex */
    public interface a {
        void cQA();

        void cQB();

        void cQC();

        void cQD();

        void cQk();

        void cQv();

        void cQw();

        void cQx();

        void cQy();

        void cQz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kCv = 0L;
        this.kCw = false;
        this.kCz = true;
        this.kCB = new ArrayList();
        this.kCC = new ArrayList();
        this.kCD = new ArrayList();
        this.kCE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCv = 0L;
        this.kCw = false;
        this.kCz = true;
        this.kCB = new ArrayList();
        this.kCC = new ArrayList();
        this.kCD = new ArrayList();
        this.kCE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kCv = 0L;
        this.kCw = false;
        this.kCz = true;
        this.kCB = new ArrayList();
        this.kCC = new ArrayList();
        this.kCD = new ArrayList();
        this.kCE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kCF = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kCs = (RelativeLayout) findViewById(R.id.layout_record);
        this.kCr = (ImageView) findViewById(R.id.delete_video);
        this.kCr.setOnClickListener(this);
        this.kCt = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kCt.setOnTouchListener(this);
        this.kCu = (ImageView) findViewById(R.id.confirm_video);
        this.kCu.setOnClickListener(this);
        this.kCE.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kCE.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kzP = iVar;
        DG(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kCF != null) {
            this.kCF.setListener(aVar);
        }
    }

    public void DG(int i) {
        this.kzP.setStatus(i);
        if (this.kCy != null) {
            this.kCy.cQD();
        }
        if (i == 1) {
            this.kCr.setVisibility(8);
            this.kCu.setVisibility(8);
        } else if (i == 3) {
            this.kCr.setImageResource(R.drawable.video_back_selector);
            this.kCu.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kCr.setImageResource(R.drawable.video_back_selector);
            this.kCu.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kCr.setImageResource(R.drawable.video_delete_selector);
            if (this.kzP != null && this.kzP.getVideoDuration() >= 3000.0f) {
                this.kCu.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kCu.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kCr) {
            if (this.kCy != null) {
                this.kCy.cQC();
            }
            int status = this.kzP.getStatus();
            if (this.kzP != null && this.kzP.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kzP.cQg();
                    ey(this.kCB);
                    ey(this.kCC);
                    ey(this.kCD);
                    if (this.kzP.getVideoDuration() >= 3000.0f) {
                        DG(4);
                        return;
                    } else {
                        DG(this.kzP.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kzP.cQf();
                DG(5);
            }
        } else if (view == this.kCu) {
            TiebaStatic.log("c12300");
            if (this.kzP != null && this.kzP.getStatus() > 2 && this.kCy != null) {
                if (this.kzP.getVideoDuration() >= 3000.0f) {
                    this.kCy.cQA();
                } else {
                    this.kCy.cQB();
                }
            }
        }
    }

    private void ey(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(final boolean z) {
        if (this.kzP.getProgress() >= 100) {
            if (this.kCy != null) {
                this.kCy.cQA();
                return;
            }
            return;
        }
        if (this.kCF.getCurrentBeautyItem() != null) {
            this.kCB.add(this.kCF.getCurrentBeautyItem());
        }
        if (this.kCF.getCurrentFilterItem() != null) {
            this.kCC.add(this.kCF.getCurrentFilterItem());
        }
        if (this.kCF.getCurrentStickItem() != null) {
            this.kCD.add(this.kCF.getCurrentStickItem());
        }
        DG(2);
        if (this.kCF.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kzP.getStatus() == 6 || VideoControllerLayout.this.kzP.isRecording()) {
                        VideoControllerLayout.this.ts(z);
                    }
                }
            });
        } else {
            ts(z);
        }
        if (this.kzP != null) {
            this.kzP.startRecord();
        }
        if (this.kCy != null) {
            this.kCy.cQv();
        }
    }

    public void stopRecord() {
        cQH();
        int status = this.kzP.getStatus();
        if (this.kzP != null) {
            if (!this.kzP.bbT() && this.kzP.isRecording()) {
                this.kzP.stopRecord();
            }
            cQG();
        }
        if (this.kCy != null) {
            this.kCy.cQk();
            if (status == 6) {
                this.kCy.cQx();
            }
        }
    }

    public void cQG() {
        if (this.kzP != null) {
            if (this.kzP.getVideoDuration() >= 3000.0f) {
                DG(4);
            } else if (this.kzP.getVideoDuration() > 0) {
                DG(3);
            } else {
                DG(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        if (this.kBH != null && this.kBH.isRunning()) {
            this.kBH.cancel();
        }
        if (this.kBG == null) {
            this.kBG = new AnimatorSet();
            this.kBG.playTogether(ObjectAnimator.ofFloat(this.kCr, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCu, "alpha", 1.0f, 0.0f));
            this.kBG.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDs) {
                        VideoControllerLayout.this.kCr.setVisibility(8);
                        VideoControllerLayout.this.kCu.setVisibility(8);
                    }
                }
            });
            this.kBG.setDuration(300L);
        }
        this.kBG.start();
        if (this.kzP.getStatus() != 6) {
            this.kCt.ts(z);
        }
    }

    public void cQH() {
        if (this.kzP == null || this.kzP.isRecording() || this.kzP.getStatus() == 6) {
            if (this.kBG != null && this.kBG.isRunning()) {
                this.kBG.cancel();
            }
            if (this.kBH == null) {
                this.kBH = new AnimatorSet();
                this.kBH.playTogether(ObjectAnimator.ofFloat(this.kCr, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCu, "alpha", 0.0f, 1.0f));
                this.kBH.setDuration(300L);
            }
            this.kCr.setVisibility(0);
            this.kCu.setVisibility(0);
            this.kBH.start();
            if (this.kzP.getStatus() != 7 && this.kzP.getStatus() != 6) {
                this.kCt.cQH();
                return;
            }
            this.kCt.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kCt.getLayer1().setVisibility(0);
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
                if (this.kCy != null) {
                    this.kCy.cQC();
                }
                if (this.kzP.getStatus() != 7 && this.kzP.getStatus() != 6) {
                    if (this.kzP != null && this.kzP.cQe()) {
                        this.kCA = true;
                        com.baidu.tbadk.core.util.e.aDz().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kCv = currentTimeMillis;
                    this.kCw = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kCw && VideoControllerLayout.this.kCv == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.cQ(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.kCA) {
                    this.kCA = false;
                    return;
                }
                this.kCw = false;
                if (this.kzP.isRecording() || this.kzP.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kzP.getStatus() != 8) {
                    cQ(false);
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
                if (this.kzP.getStatus() == 6) {
                    this.kzP.setStatus(1);
                    if (this.kCy != null) {
                        this.kCy.cQx();
                        this.kCy.cQk();
                    }
                    this.kCt.getTvTip().setText("");
                    this.kCt.getTvTip().setVisibility(8);
                    return;
                } else if (this.kCF.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kCy != null) {
                    this.kCy.cQw();
                    this.kCt.cQS();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kCt.cQT();
                return;
            default:
                return;
        }
    }

    public void cQq() {
        if (this.kCF.getVisibility() == 0) {
            a((m) null);
        }
        ts(false);
        this.kCt.getLayer1().setVisibility(8);
        this.kCt.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kCt.getTvTip().setVisibility(0);
        if (this.kCy != null) {
            this.kCy.cQv();
        }
    }

    public void cQI() {
        if (this.kzP.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DG(7);
                this.kCt.setAlpha(1.0f);
                this.kCr.setVisibility(8);
                this.kCu.setVisibility(8);
                this.kCt.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kzP != null) {
                    this.kzP.startRecord();
                    return;
                }
                return;
            }
            this.kCt.getTvTip().setVisibility(8);
            if (this.kCy != null) {
                this.kCy.cQw();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        if (cQL() && this.kCF.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cQL()) {
            cQK();
        }
        this.kCF.cQr();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        if (cQL() && this.kCF.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cQL()) {
            cQK();
        }
        this.kCF.cQs();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQt() {
        if (cQL() && this.kCF.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cQL()) {
            cQK();
        }
        this.kCF.cQt();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQu() {
        if (cQL() && this.kCF.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cQL()) {
            cQK();
        }
        this.kCF.cQu();
    }

    private void cQJ() {
        if (v.isEmpty(this.kCx)) {
            this.kCx = new ArrayList();
            this.kCx.add(ObjectAnimator.ofFloat(this.kCF, "translationY", 1000.0f, 0.0f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCs, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCt.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCt.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCt.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCt.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCu, "scaleX", 1.0f, 0.7f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCu, "scaleY", 1.0f, 0.7f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCr, "scaleX", 1.0f, 0.7f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCr, "scaleY", 1.0f, 0.7f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCu, "alpha", 1.0f, 0.0f));
            this.kCx.add(ObjectAnimator.ofFloat(this.kCr, "alpha", 1.0f, 0.0f));
        }
    }

    private void cQK() {
        int i = 0;
        if (this.kCF.getVisibility() != 0) {
            this.kCF.setVisibility(0);
            cQJ();
            this.kCu.setEnabled(false);
            this.kCr.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kCx.size()) {
                    ObjectAnimator objectAnimator = this.kCx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kCx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kCy != null) {
                                        VideoControllerLayout.this.kCy.cQy();
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
        if (this.kCF.getVisibility() != 8) {
            cQJ();
            this.kCu.setEnabled(true);
            this.kCr.setEnabled(true);
            if (this.kzP.getStatus() == 6 || this.kzP.isRecording()) {
                this.kCr.setVisibility(8);
                this.kCu.setVisibility(8);
            } else {
                DG(this.kzP.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kCx.size()) {
                    ObjectAnimator objectAnimator = this.kCx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kCx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kDs) {
                                        VideoControllerLayout.this.kCF.setVisibility(8);
                                        if (VideoControllerLayout.this.kCy != null) {
                                            VideoControllerLayout.this.kCy.cQz();
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
        this.kCy = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kCr.setVisibility(4);
                this.kCu.setVisibility(4);
                this.kCt.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kzP.getStatus() != 1) {
                    this.kCr.setVisibility(0);
                    this.kCu.setVisibility(0);
                }
                this.kCt.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cQL() {
        return this.kCF.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kCF != null) {
            this.kCF.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kCF != null) {
            this.kCF.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kCF != null) {
            this.kCF.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cQM() {
        if (this.kCF != null) {
            return this.kCF.cQM();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kCz = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kCB;
    }

    public List<e> getChoosedFilterList() {
        return this.kCC;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kCD;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kCE.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kCF != null) {
            this.kCF.setMusicList(this.kCE);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void cQN() {
        if (this.kCF != null) {
            this.kCF.cQN();
        }
    }

    public void cPE() {
        if (this.kCF != null) {
            this.kCF.cPE();
        }
    }
}
