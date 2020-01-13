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
    private AnimatorSet kBB;
    private AnimatorSet kBC;
    private VideoEffectLayout kCA;
    private ImageView kCm;
    private RelativeLayout kCn;
    private VideoRecordButton kCo;
    private ImageView kCp;
    private long kCq;
    private boolean kCr;
    private List<ObjectAnimator> kCs;
    private a kCt;
    private boolean kCu;
    private boolean kCv;
    private List<e> kCw;
    private List<e> kCx;
    private List<StickerItem> kCy;
    private List<e> kCz;
    private i kzK;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes8.dex */
    public interface a {
        void cQA();

        void cQB();

        void cQi();

        void cQt();

        void cQu();

        void cQv();

        void cQw();

        void cQx();

        void cQy();

        void cQz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kCq = 0L;
        this.kCr = false;
        this.kCu = true;
        this.kCw = new ArrayList();
        this.kCx = new ArrayList();
        this.kCy = new ArrayList();
        this.kCz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCq = 0L;
        this.kCr = false;
        this.kCu = true;
        this.kCw = new ArrayList();
        this.kCx = new ArrayList();
        this.kCy = new ArrayList();
        this.kCz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kCq = 0L;
        this.kCr = false;
        this.kCu = true;
        this.kCw = new ArrayList();
        this.kCx = new ArrayList();
        this.kCy = new ArrayList();
        this.kCz = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kCA = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kCn = (RelativeLayout) findViewById(R.id.layout_record);
        this.kCm = (ImageView) findViewById(R.id.delete_video);
        this.kCm.setOnClickListener(this);
        this.kCo = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kCo.setOnTouchListener(this);
        this.kCp = (ImageView) findViewById(R.id.confirm_video);
        this.kCp.setOnClickListener(this);
        this.kCz.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kCz.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kzK = iVar;
        DG(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kCA != null) {
            this.kCA.setListener(aVar);
        }
    }

    public void DG(int i) {
        this.kzK.setStatus(i);
        if (this.kCt != null) {
            this.kCt.cQB();
        }
        if (i == 1) {
            this.kCm.setVisibility(8);
            this.kCp.setVisibility(8);
        } else if (i == 3) {
            this.kCm.setImageResource(R.drawable.video_back_selector);
            this.kCp.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kCm.setImageResource(R.drawable.video_back_selector);
            this.kCp.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kCm.setImageResource(R.drawable.video_delete_selector);
            if (this.kzK != null && this.kzK.getVideoDuration() >= 3000.0f) {
                this.kCp.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kCp.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kCm) {
            if (this.kCt != null) {
                this.kCt.cQA();
            }
            int status = this.kzK.getStatus();
            if (this.kzK != null && this.kzK.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kzK.cQe();
                    ey(this.kCw);
                    ey(this.kCx);
                    ey(this.kCy);
                    if (this.kzK.getVideoDuration() >= 3000.0f) {
                        DG(4);
                        return;
                    } else {
                        DG(this.kzK.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kzK.cQd();
                DG(5);
            }
        } else if (view == this.kCp) {
            TiebaStatic.log("c12300");
            if (this.kzK != null && this.kzK.getStatus() > 2 && this.kCt != null) {
                if (this.kzK.getVideoDuration() >= 3000.0f) {
                    this.kCt.cQy();
                } else {
                    this.kCt.cQz();
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
        if (this.kzK.getProgress() >= 100) {
            if (this.kCt != null) {
                this.kCt.cQy();
                return;
            }
            return;
        }
        if (this.kCA.getCurrentBeautyItem() != null) {
            this.kCw.add(this.kCA.getCurrentBeautyItem());
        }
        if (this.kCA.getCurrentFilterItem() != null) {
            this.kCx.add(this.kCA.getCurrentFilterItem());
        }
        if (this.kCA.getCurrentStickItem() != null) {
            this.kCy.add(this.kCA.getCurrentStickItem());
        }
        DG(2);
        if (this.kCA.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kzK.getStatus() == 6 || VideoControllerLayout.this.kzK.isRecording()) {
                        VideoControllerLayout.this.ts(z);
                    }
                }
            });
        } else {
            ts(z);
        }
        if (this.kzK != null) {
            this.kzK.startRecord();
        }
        if (this.kCt != null) {
            this.kCt.cQt();
        }
    }

    public void stopRecord() {
        cQF();
        int status = this.kzK.getStatus();
        if (this.kzK != null) {
            if (!this.kzK.bbT() && this.kzK.isRecording()) {
                this.kzK.stopRecord();
            }
            cQE();
        }
        if (this.kCt != null) {
            this.kCt.cQi();
            if (status == 6) {
                this.kCt.cQv();
            }
        }
    }

    public void cQE() {
        if (this.kzK != null) {
            if (this.kzK.getVideoDuration() >= 3000.0f) {
                DG(4);
            } else if (this.kzK.getVideoDuration() > 0) {
                DG(3);
            } else {
                DG(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        if (this.kBC != null && this.kBC.isRunning()) {
            this.kBC.cancel();
        }
        if (this.kBB == null) {
            this.kBB = new AnimatorSet();
            this.kBB.playTogether(ObjectAnimator.ofFloat(this.kCm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCp, "alpha", 1.0f, 0.0f));
            this.kBB.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDn) {
                        VideoControllerLayout.this.kCm.setVisibility(8);
                        VideoControllerLayout.this.kCp.setVisibility(8);
                    }
                }
            });
            this.kBB.setDuration(300L);
        }
        this.kBB.start();
        if (this.kzK.getStatus() != 6) {
            this.kCo.ts(z);
        }
    }

    public void cQF() {
        if (this.kzK == null || this.kzK.isRecording() || this.kzK.getStatus() == 6) {
            if (this.kBB != null && this.kBB.isRunning()) {
                this.kBB.cancel();
            }
            if (this.kBC == null) {
                this.kBC = new AnimatorSet();
                this.kBC.playTogether(ObjectAnimator.ofFloat(this.kCm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCp, "alpha", 0.0f, 1.0f));
                this.kBC.setDuration(300L);
            }
            this.kCm.setVisibility(0);
            this.kCp.setVisibility(0);
            this.kBC.start();
            if (this.kzK.getStatus() != 7 && this.kzK.getStatus() != 6) {
                this.kCo.cQF();
                return;
            }
            this.kCo.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kCo.getLayer1().setVisibility(0);
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
                if (this.kCt != null) {
                    this.kCt.cQA();
                }
                if (this.kzK.getStatus() != 7 && this.kzK.getStatus() != 6) {
                    if (this.kzK != null && this.kzK.cQc()) {
                        this.kCv = true;
                        com.baidu.tbadk.core.util.e.aDz().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kCq = currentTimeMillis;
                    this.kCr = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kCr && VideoControllerLayout.this.kCq == currentTimeMillis) {
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
                if (this.kCv) {
                    this.kCv = false;
                    return;
                }
                this.kCr = false;
                if (this.kzK.isRecording() || this.kzK.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kzK.getStatus() != 8) {
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
                if (this.kzK.getStatus() == 6) {
                    this.kzK.setStatus(1);
                    if (this.kCt != null) {
                        this.kCt.cQv();
                        this.kCt.cQi();
                    }
                    this.kCo.getTvTip().setText("");
                    this.kCo.getTvTip().setVisibility(8);
                    return;
                } else if (this.kCA.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kCt != null) {
                    this.kCt.cQu();
                    this.kCo.cQQ();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kCo.cQR();
                return;
            default:
                return;
        }
    }

    public void cQo() {
        if (this.kCA.getVisibility() == 0) {
            a((m) null);
        }
        ts(false);
        this.kCo.getLayer1().setVisibility(8);
        this.kCo.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kCo.getTvTip().setVisibility(0);
        if (this.kCt != null) {
            this.kCt.cQt();
        }
    }

    public void cQG() {
        if (this.kzK.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DG(7);
                this.kCo.setAlpha(1.0f);
                this.kCm.setVisibility(8);
                this.kCp.setVisibility(8);
                this.kCo.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kzK != null) {
                    this.kzK.startRecord();
                    return;
                }
                return;
            }
            this.kCo.getTvTip().setVisibility(8);
            if (this.kCt != null) {
                this.kCt.cQu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQp() {
        if (cQJ() && this.kCA.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cQJ()) {
            cQI();
        }
        this.kCA.cQp();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQq() {
        if (cQJ() && this.kCA.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cQJ()) {
            cQI();
        }
        this.kCA.cQq();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        if (cQJ() && this.kCA.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cQJ()) {
            cQI();
        }
        this.kCA.cQr();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        if (cQJ() && this.kCA.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cQJ()) {
            cQI();
        }
        this.kCA.cQs();
    }

    private void cQH() {
        if (v.isEmpty(this.kCs)) {
            this.kCs = new ArrayList();
            this.kCs.add(ObjectAnimator.ofFloat(this.kCA, "translationY", 1000.0f, 0.0f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCn, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCo.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCo.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCo.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCo.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCp, "scaleX", 1.0f, 0.7f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCp, "scaleY", 1.0f, 0.7f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCm, "scaleX", 1.0f, 0.7f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCm, "scaleY", 1.0f, 0.7f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCp, "alpha", 1.0f, 0.0f));
            this.kCs.add(ObjectAnimator.ofFloat(this.kCm, "alpha", 1.0f, 0.0f));
        }
    }

    private void cQI() {
        int i = 0;
        if (this.kCA.getVisibility() != 0) {
            this.kCA.setVisibility(0);
            cQH();
            this.kCp.setEnabled(false);
            this.kCm.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kCs.size()) {
                    ObjectAnimator objectAnimator = this.kCs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kCs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kCt != null) {
                                        VideoControllerLayout.this.kCt.cQw();
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
        if (this.kCA.getVisibility() != 8) {
            cQH();
            this.kCp.setEnabled(true);
            this.kCm.setEnabled(true);
            if (this.kzK.getStatus() == 6 || this.kzK.isRecording()) {
                this.kCm.setVisibility(8);
                this.kCp.setVisibility(8);
            } else {
                DG(this.kzK.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kCs.size()) {
                    ObjectAnimator objectAnimator = this.kCs.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kCs.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kDn) {
                                        VideoControllerLayout.this.kCA.setVisibility(8);
                                        if (VideoControllerLayout.this.kCt != null) {
                                            VideoControllerLayout.this.kCt.cQx();
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
        this.kCt = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kCm.setVisibility(4);
                this.kCp.setVisibility(4);
                this.kCo.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kzK.getStatus() != 1) {
                    this.kCm.setVisibility(0);
                    this.kCp.setVisibility(0);
                }
                this.kCo.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cQJ() {
        return this.kCA.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kCA != null) {
            this.kCA.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kCA != null) {
            this.kCA.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kCA != null) {
            this.kCA.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cQK() {
        if (this.kCA != null) {
            return this.kCA.cQK();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kCu = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kCw;
    }

    public List<e> getChoosedFilterList() {
        return this.kCx;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kCy;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kCz.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kCA != null) {
            this.kCA.setMusicList(this.kCz);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void cQL() {
        if (this.kCA != null) {
            this.kCA.cQL();
        }
    }

    public void cPC() {
        if (this.kCA != null) {
            this.kCA.cPC();
        }
    }
}
