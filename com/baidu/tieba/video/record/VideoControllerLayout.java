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
/* loaded from: classes23.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jqf;
    private Handler mHandler;
    private i nHo;
    private ImageView nJP;
    private RelativeLayout nJQ;
    private VideoRecordButton nJR;
    private ImageView nJS;
    private long nJT;
    private boolean nJU;
    private List<ObjectAnimator> nJV;
    private a nJW;
    private boolean nJX;
    private boolean nJY;
    private List<e> nJZ;
    private AnimatorSet nJe;
    private AnimatorSet nJf;
    private List<e> nKa;
    private List<StickerItem> nKb;
    private List<e> nKc;
    private VideoEffectLayout nKd;

    /* loaded from: classes23.dex */
    public interface a {
        void dWB();

        void dWC();

        void dWD();

        void dWE();

        void dWF();

        void dWG();

        void dWH();

        void dWI();

        void dWJ();

        void dWq();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nJT = 0L;
        this.nJU = false;
        this.nJX = true;
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.nKb = new ArrayList();
        this.nKc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJT = 0L;
        this.nJU = false;
        this.nJX = true;
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.nKb = new ArrayList();
        this.nKc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJT = 0L;
        this.nJU = false;
        this.nJX = true;
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.nKb = new ArrayList();
        this.nKc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nKd = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nJQ = (RelativeLayout) findViewById(R.id.layout_record);
        this.nJP = (ImageView) findViewById(R.id.delete_video);
        this.nJP.setOnClickListener(this);
        this.nJR = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nJR.setOnTouchListener(this);
        this.nJS = (ImageView) findViewById(R.id.confirm_video);
        this.nJS.setOnClickListener(this);
        this.nKc.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nKc.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nHo = iVar;
        Mr(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nKd != null) {
            this.nKd.setListener(aVar);
        }
    }

    public void Mr(int i) {
        this.nHo.setStatus(i);
        if (this.nJW != null) {
            this.nJW.dWJ();
        }
        if (i == 1) {
            this.nJP.setVisibility(8);
            this.nJS.setVisibility(8);
        } else if (i == 3) {
            this.nJP.setImageResource(R.drawable.video_back_selector);
            this.nJS.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nJP.setImageResource(R.drawable.video_back_selector);
            this.nJS.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nJP.setImageResource(R.drawable.video_delete_selector);
            if (this.nHo != null && this.nHo.getVideoDuration() >= 3000.0f) {
                this.nJS.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nJS.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nJP) {
            if (this.nJW != null) {
                this.nJW.dWI();
            }
            int status = this.nHo.getStatus();
            if (this.nHo != null && this.nHo.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nHo.dWl();
                    gj(this.nJZ);
                    gj(this.nKa);
                    gj(this.nKb);
                    if (this.nHo.getVideoDuration() >= 3000.0f) {
                        Mr(4);
                        return;
                    } else {
                        Mr(this.nHo.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nHo.dWk();
                Mr(5);
            }
        } else if (view == this.nJS) {
            TiebaStatic.log("c12300");
            if (this.nHo != null && this.nHo.getStatus() > 2 && this.nJW != null) {
                if (this.nHo.getVideoDuration() >= 3000.0f) {
                    this.nJW.dWG();
                } else {
                    this.nJW.dWH();
                }
            }
        }
    }

    private void gj(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(final boolean z) {
        if (this.nHo.getProgress() >= 100) {
            if (this.nJW != null) {
                this.nJW.dWG();
                return;
            }
            return;
        }
        if (this.nKd.getCurrentBeautyItem() != null) {
            this.nJZ.add(this.nKd.getCurrentBeautyItem());
        }
        if (this.nKd.getCurrentFilterItem() != null) {
            this.nKa.add(this.nKd.getCurrentFilterItem());
        }
        if (this.nKd.getCurrentStickItem() != null) {
            this.nKb.add(this.nKd.getCurrentStickItem());
        }
        Mr(2);
        if (this.nKd.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nHo.getStatus() == 6 || VideoControllerLayout.this.nHo.bwP()) {
                        VideoControllerLayout.this.yR(z);
                    }
                }
            });
        } else {
            yR(z);
        }
        if (this.nHo != null) {
            this.nHo.startRecord();
        }
        if (this.nJW != null) {
            this.nJW.dWB();
        }
    }

    public void stopRecord() {
        dWN();
        int status = this.nHo.getStatus();
        if (this.nHo != null) {
            if (!this.nHo.bUL() && this.nHo.bwP()) {
                this.nHo.stopRecord();
            }
            dWM();
        }
        if (this.nJW != null) {
            this.nJW.dWq();
            if (status == 6) {
                this.nJW.dWD();
            }
        }
    }

    public void dWM() {
        if (this.nHo != null) {
            if (this.nHo.getVideoDuration() >= 3000.0f) {
                Mr(4);
            } else if (this.nHo.getVideoDuration() > 0) {
                Mr(3);
            } else {
                Mr(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(boolean z) {
        if (this.nJf != null && this.nJf.isRunning()) {
            this.nJf.cancel();
        }
        if (this.nJe == null) {
            this.nJe = new AnimatorSet();
            this.nJe.playTogether(ObjectAnimator.ofFloat(this.nJP, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nJS, "alpha", 1.0f, 0.0f));
            this.nJe.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKQ) {
                        VideoControllerLayout.this.nJP.setVisibility(8);
                        VideoControllerLayout.this.nJS.setVisibility(8);
                    }
                }
            });
            this.nJe.setDuration(300L);
        }
        this.nJe.start();
        if (this.nHo.getStatus() != 6) {
            this.nJR.yR(z);
        }
    }

    public void dWN() {
        if (this.nHo == null || this.nHo.bwP() || this.nHo.getStatus() == 6) {
            if (this.nJe != null && this.nJe.isRunning()) {
                this.nJe.cancel();
            }
            if (this.nJf == null) {
                this.nJf = new AnimatorSet();
                this.nJf.playTogether(ObjectAnimator.ofFloat(this.nJP, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nJS, "alpha", 0.0f, 1.0f));
                this.nJf.setDuration(300L);
            }
            this.nJP.setVisibility(0);
            this.nJS.setVisibility(0);
            this.nJf.start();
            if (this.nHo.getStatus() != 7 && this.nHo.getStatus() != 6) {
                this.nJR.dWN();
                return;
            }
            this.nJR.getTvTip().setVisibility(8);
            if (this.jqf == 2) {
                this.nJR.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jqf) {
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
                if (this.nJW != null) {
                    this.nJW.dWI();
                }
                if (this.nHo.getStatus() != 7 && this.nHo.getStatus() != 6) {
                    if (this.nHo != null && this.nHo.dWj()) {
                        this.nJY = true;
                        com.baidu.tbadk.core.util.e.bsW().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nJT = currentTimeMillis;
                    this.nJU = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nJU && VideoControllerLayout.this.nJT == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.fX(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nJY) {
                    this.nJY = false;
                    return;
                }
                this.nJU = false;
                if (this.nHo.bwP() || this.nHo.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nHo.getStatus() != 8) {
                    fX(false);
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
                if (this.nHo.getStatus() == 6) {
                    this.nHo.setStatus(1);
                    if (this.nJW != null) {
                        this.nJW.dWD();
                        this.nJW.dWq();
                    }
                    this.nJR.getTvTip().setText("");
                    this.nJR.getTvTip().setVisibility(8);
                    return;
                } else if (this.nKd.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nJW != null) {
                    this.nJW.dWC();
                    this.nJR.dWY();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nJR.dWZ();
                return;
            default:
                return;
        }
    }

    public void dWw() {
        if (this.nKd.getVisibility() == 0) {
            a((m) null);
        }
        yR(false);
        this.nJR.getLayer1().setVisibility(8);
        this.nJR.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nJR.getTvTip().setVisibility(0);
        if (this.nJW != null) {
            this.nJW.dWB();
        }
    }

    public void dWO() {
        if (this.nHo.getStatus() == 6) {
            if (this.jqf == 2) {
                Mr(7);
                this.nJR.setAlpha(1.0f);
                this.nJP.setVisibility(8);
                this.nJS.setVisibility(8);
                this.nJR.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nHo != null) {
                    this.nHo.startRecord();
                    return;
                }
                return;
            }
            this.nJR.getTvTip().setVisibility(8);
            if (this.nJW != null) {
                this.nJW.dWC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWx() {
        if (dWR() && this.nKd.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dWR()) {
            dWQ();
        }
        this.nKd.dWx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWy() {
        if (dWR() && this.nKd.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dWR()) {
            dWQ();
        }
        this.nKd.dWy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWz() {
        if (dWR() && this.nKd.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dWR()) {
            dWQ();
        }
        this.nKd.dWz();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWA() {
        if (dWR() && this.nKd.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dWR()) {
            dWQ();
        }
        this.nKd.dWA();
    }

    private void dWP() {
        if (y.isEmpty(this.nJV)) {
            this.nJV = new ArrayList();
            this.nJV.add(ObjectAnimator.ofFloat(this.nKd, "translationY", 1000.0f, 0.0f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJQ, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJR.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJR.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJR.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJR.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJS, "scaleX", 1.0f, 0.7f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJS, "scaleY", 1.0f, 0.7f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJP, "scaleX", 1.0f, 0.7f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJP, "scaleY", 1.0f, 0.7f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJS, "alpha", 1.0f, 0.0f));
            this.nJV.add(ObjectAnimator.ofFloat(this.nJP, "alpha", 1.0f, 0.0f));
        }
    }

    private void dWQ() {
        int i = 0;
        if (this.nKd.getVisibility() != 0) {
            this.nKd.setVisibility(0);
            dWP();
            this.nJS.setEnabled(false);
            this.nJP.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nJV.size()) {
                    ObjectAnimator objectAnimator = this.nJV.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nJV.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nJW != null) {
                                        VideoControllerLayout.this.nJW.dWE();
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
        if (this.nKd.getVisibility() != 8) {
            dWP();
            this.nJS.setEnabled(true);
            this.nJP.setEnabled(true);
            if (this.nHo.getStatus() == 6 || this.nHo.bwP()) {
                this.nJP.setVisibility(8);
                this.nJS.setVisibility(8);
            } else {
                Mr(this.nHo.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nJV.size()) {
                    ObjectAnimator objectAnimator = this.nJV.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nJV.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nKQ) {
                                        VideoControllerLayout.this.nKd.setVisibility(8);
                                        if (VideoControllerLayout.this.nJW != null) {
                                            VideoControllerLayout.this.nJW.dWF();
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
        this.nJW = aVar;
    }

    public void setCurrentTab(int i) {
        this.jqf = i;
        switch (this.jqf) {
            case 1:
                this.nJP.setVisibility(4);
                this.nJS.setVisibility(4);
                this.nJR.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nHo.getStatus() != 1) {
                    this.nJP.setVisibility(0);
                    this.nJS.setVisibility(0);
                }
                this.nJR.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dWR() {
        return this.nKd.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nKd != null) {
            this.nKd.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nKd != null) {
            this.nKd.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nKd != null) {
            this.nKd.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dWS() {
        if (this.nKd != null) {
            return this.nKd.dWS();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nJX = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nJZ;
    }

    public List<e> getChoosedFilterList() {
        return this.nKa;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nKb;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nKc.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nKd != null) {
            this.nKd.setMusicList(this.nKc);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void dWT() {
        if (this.nKd != null) {
            this.nKd.dWT();
        }
    }

    public void dVH() {
        if (this.nKd != null) {
            this.nKd.dVH();
        }
    }
}
