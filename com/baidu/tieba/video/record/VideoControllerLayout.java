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
    private int jqd;
    private Handler mHandler;
    private i nHm;
    private ImageView nJN;
    private RelativeLayout nJO;
    private VideoRecordButton nJP;
    private ImageView nJQ;
    private long nJR;
    private boolean nJS;
    private List<ObjectAnimator> nJT;
    private a nJU;
    private boolean nJV;
    private boolean nJW;
    private List<e> nJX;
    private List<e> nJY;
    private List<StickerItem> nJZ;
    private AnimatorSet nJc;
    private AnimatorSet nJd;
    private List<e> nKa;
    private VideoEffectLayout nKb;

    /* loaded from: classes23.dex */
    public interface a {
        void dWA();

        void dWB();

        void dWC();

        void dWD();

        void dWE();

        void dWF();

        void dWG();

        void dWH();

        void dWI();

        void dWp();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nJR = 0L;
        this.nJS = false;
        this.nJV = true;
        this.nJX = new ArrayList();
        this.nJY = new ArrayList();
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nJR = 0L;
        this.nJS = false;
        this.nJV = true;
        this.nJX = new ArrayList();
        this.nJY = new ArrayList();
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nJR = 0L;
        this.nJS = false;
        this.nJV = true;
        this.nJX = new ArrayList();
        this.nJY = new ArrayList();
        this.nJZ = new ArrayList();
        this.nKa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nKb = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nJO = (RelativeLayout) findViewById(R.id.layout_record);
        this.nJN = (ImageView) findViewById(R.id.delete_video);
        this.nJN.setOnClickListener(this);
        this.nJP = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nJP.setOnTouchListener(this);
        this.nJQ = (ImageView) findViewById(R.id.confirm_video);
        this.nJQ.setOnClickListener(this);
        this.nKa.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nKa.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nHm = iVar;
        Mr(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nKb != null) {
            this.nKb.setListener(aVar);
        }
    }

    public void Mr(int i) {
        this.nHm.setStatus(i);
        if (this.nJU != null) {
            this.nJU.dWI();
        }
        if (i == 1) {
            this.nJN.setVisibility(8);
            this.nJQ.setVisibility(8);
        } else if (i == 3) {
            this.nJN.setImageResource(R.drawable.video_back_selector);
            this.nJQ.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nJN.setImageResource(R.drawable.video_back_selector);
            this.nJQ.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nJN.setImageResource(R.drawable.video_delete_selector);
            if (this.nHm != null && this.nHm.getVideoDuration() >= 3000.0f) {
                this.nJQ.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nJQ.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nJN) {
            if (this.nJU != null) {
                this.nJU.dWH();
            }
            int status = this.nHm.getStatus();
            if (this.nHm != null && this.nHm.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nHm.dWk();
                    gj(this.nJX);
                    gj(this.nJY);
                    gj(this.nJZ);
                    if (this.nHm.getVideoDuration() >= 3000.0f) {
                        Mr(4);
                        return;
                    } else {
                        Mr(this.nHm.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nHm.dWj();
                Mr(5);
            }
        } else if (view == this.nJQ) {
            TiebaStatic.log("c12300");
            if (this.nHm != null && this.nHm.getStatus() > 2 && this.nJU != null) {
                if (this.nHm.getVideoDuration() >= 3000.0f) {
                    this.nJU.dWF();
                } else {
                    this.nJU.dWG();
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
        if (this.nHm.getProgress() >= 100) {
            if (this.nJU != null) {
                this.nJU.dWF();
                return;
            }
            return;
        }
        if (this.nKb.getCurrentBeautyItem() != null) {
            this.nJX.add(this.nKb.getCurrentBeautyItem());
        }
        if (this.nKb.getCurrentFilterItem() != null) {
            this.nJY.add(this.nKb.getCurrentFilterItem());
        }
        if (this.nKb.getCurrentStickItem() != null) {
            this.nJZ.add(this.nKb.getCurrentStickItem());
        }
        Mr(2);
        if (this.nKb.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nHm.getStatus() == 6 || VideoControllerLayout.this.nHm.bwP()) {
                        VideoControllerLayout.this.yR(z);
                    }
                }
            });
        } else {
            yR(z);
        }
        if (this.nHm != null) {
            this.nHm.startRecord();
        }
        if (this.nJU != null) {
            this.nJU.dWA();
        }
    }

    public void stopRecord() {
        dWM();
        int status = this.nHm.getStatus();
        if (this.nHm != null) {
            if (!this.nHm.bUK() && this.nHm.bwP()) {
                this.nHm.stopRecord();
            }
            dWL();
        }
        if (this.nJU != null) {
            this.nJU.dWp();
            if (status == 6) {
                this.nJU.dWC();
            }
        }
    }

    public void dWL() {
        if (this.nHm != null) {
            if (this.nHm.getVideoDuration() >= 3000.0f) {
                Mr(4);
            } else if (this.nHm.getVideoDuration() > 0) {
                Mr(3);
            } else {
                Mr(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(boolean z) {
        if (this.nJd != null && this.nJd.isRunning()) {
            this.nJd.cancel();
        }
        if (this.nJc == null) {
            this.nJc = new AnimatorSet();
            this.nJc.playTogether(ObjectAnimator.ofFloat(this.nJN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nJQ, "alpha", 1.0f, 0.0f));
            this.nJc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKO) {
                        VideoControllerLayout.this.nJN.setVisibility(8);
                        VideoControllerLayout.this.nJQ.setVisibility(8);
                    }
                }
            });
            this.nJc.setDuration(300L);
        }
        this.nJc.start();
        if (this.nHm.getStatus() != 6) {
            this.nJP.yR(z);
        }
    }

    public void dWM() {
        if (this.nHm == null || this.nHm.bwP() || this.nHm.getStatus() == 6) {
            if (this.nJc != null && this.nJc.isRunning()) {
                this.nJc.cancel();
            }
            if (this.nJd == null) {
                this.nJd = new AnimatorSet();
                this.nJd.playTogether(ObjectAnimator.ofFloat(this.nJN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nJQ, "alpha", 0.0f, 1.0f));
                this.nJd.setDuration(300L);
            }
            this.nJN.setVisibility(0);
            this.nJQ.setVisibility(0);
            this.nJd.start();
            if (this.nHm.getStatus() != 7 && this.nHm.getStatus() != 6) {
                this.nJP.dWM();
                return;
            }
            this.nJP.getTvTip().setVisibility(8);
            if (this.jqd == 2) {
                this.nJP.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jqd) {
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
                if (this.nJU != null) {
                    this.nJU.dWH();
                }
                if (this.nHm.getStatus() != 7 && this.nHm.getStatus() != 6) {
                    if (this.nHm != null && this.nHm.dWi()) {
                        this.nJW = true;
                        com.baidu.tbadk.core.util.e.bsW().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nJR = currentTimeMillis;
                    this.nJS = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nJS && VideoControllerLayout.this.nJR == currentTimeMillis) {
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
                if (this.nJW) {
                    this.nJW = false;
                    return;
                }
                this.nJS = false;
                if (this.nHm.bwP() || this.nHm.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nHm.getStatus() != 8) {
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
                if (this.nHm.getStatus() == 6) {
                    this.nHm.setStatus(1);
                    if (this.nJU != null) {
                        this.nJU.dWC();
                        this.nJU.dWp();
                    }
                    this.nJP.getTvTip().setText("");
                    this.nJP.getTvTip().setVisibility(8);
                    return;
                } else if (this.nKb.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nJU != null) {
                    this.nJU.dWB();
                    this.nJP.dWX();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nJP.dWY();
                return;
            default:
                return;
        }
    }

    public void dWv() {
        if (this.nKb.getVisibility() == 0) {
            a((m) null);
        }
        yR(false);
        this.nJP.getLayer1().setVisibility(8);
        this.nJP.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nJP.getTvTip().setVisibility(0);
        if (this.nJU != null) {
            this.nJU.dWA();
        }
    }

    public void dWN() {
        if (this.nHm.getStatus() == 6) {
            if (this.jqd == 2) {
                Mr(7);
                this.nJP.setAlpha(1.0f);
                this.nJN.setVisibility(8);
                this.nJQ.setVisibility(8);
                this.nJP.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nHm != null) {
                    this.nHm.startRecord();
                    return;
                }
                return;
            }
            this.nJP.getTvTip().setVisibility(8);
            if (this.nJU != null) {
                this.nJU.dWB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWw() {
        if (dWQ() && this.nKb.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dWQ()) {
            dWP();
        }
        this.nKb.dWw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWx() {
        if (dWQ() && this.nKb.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dWQ()) {
            dWP();
        }
        this.nKb.dWx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWy() {
        if (dWQ() && this.nKb.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dWQ()) {
            dWP();
        }
        this.nKb.dWy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWz() {
        if (dWQ() && this.nKb.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dWQ()) {
            dWP();
        }
        this.nKb.dWz();
    }

    private void dWO() {
        if (y.isEmpty(this.nJT)) {
            this.nJT = new ArrayList();
            this.nJT.add(ObjectAnimator.ofFloat(this.nKb, "translationY", 1000.0f, 0.0f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJO, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJP.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJP.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJP.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJP.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJQ, "scaleX", 1.0f, 0.7f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJQ, "scaleY", 1.0f, 0.7f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJN, "scaleX", 1.0f, 0.7f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJN, "scaleY", 1.0f, 0.7f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJQ, "alpha", 1.0f, 0.0f));
            this.nJT.add(ObjectAnimator.ofFloat(this.nJN, "alpha", 1.0f, 0.0f));
        }
    }

    private void dWP() {
        int i = 0;
        if (this.nKb.getVisibility() != 0) {
            this.nKb.setVisibility(0);
            dWO();
            this.nJQ.setEnabled(false);
            this.nJN.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nJT.size()) {
                    ObjectAnimator objectAnimator = this.nJT.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nJT.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nJU != null) {
                                        VideoControllerLayout.this.nJU.dWD();
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
        if (this.nKb.getVisibility() != 8) {
            dWO();
            this.nJQ.setEnabled(true);
            this.nJN.setEnabled(true);
            if (this.nHm.getStatus() == 6 || this.nHm.bwP()) {
                this.nJN.setVisibility(8);
                this.nJQ.setVisibility(8);
            } else {
                Mr(this.nHm.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nJT.size()) {
                    ObjectAnimator objectAnimator = this.nJT.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nJT.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nKO) {
                                        VideoControllerLayout.this.nKb.setVisibility(8);
                                        if (VideoControllerLayout.this.nJU != null) {
                                            VideoControllerLayout.this.nJU.dWE();
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
        this.nJU = aVar;
    }

    public void setCurrentTab(int i) {
        this.jqd = i;
        switch (this.jqd) {
            case 1:
                this.nJN.setVisibility(4);
                this.nJQ.setVisibility(4);
                this.nJP.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nHm.getStatus() != 1) {
                    this.nJN.setVisibility(0);
                    this.nJQ.setVisibility(0);
                }
                this.nJP.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dWQ() {
        return this.nKb.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nKb != null) {
            this.nKb.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nKb != null) {
            this.nKb.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nKb != null) {
            this.nKb.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dWR() {
        if (this.nKb != null) {
            return this.nKb.dWR();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nJV = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nJX;
    }

    public List<e> getChoosedFilterList() {
        return this.nJY;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nJZ;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nKa.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nKb != null) {
            this.nKb.setMusicList(this.nKa);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void dWS() {
        if (this.nKb != null) {
            this.nKb.dWS();
        }
    }

    public void dVG() {
        if (this.nKb != null) {
            this.nKb.dVG();
        }
    }
}
