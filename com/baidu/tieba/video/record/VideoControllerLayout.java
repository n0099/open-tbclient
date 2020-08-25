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
/* loaded from: classes17.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int inf;
    private AnimatorSet mBK;
    private AnimatorSet mBL;
    private long mCA;
    private boolean mCB;
    private List<ObjectAnimator> mCC;
    private a mCD;
    private boolean mCE;
    private boolean mCF;
    private List<e> mCG;
    private List<e> mCH;
    private List<StickerItem> mCI;
    private List<e> mCJ;
    private VideoEffectLayout mCK;
    private ImageView mCw;
    private RelativeLayout mCx;
    private VideoRecordButton mCy;
    private ImageView mCz;
    private Handler mHandler;
    private i mzR;

    /* loaded from: classes17.dex */
    public interface a {
        void dDI();

        void dDJ();

        void dDK();

        void dDL();

        void dDM();

        void dDN();

        void dDO();

        void dDP();

        void dDQ();

        void dDx();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mCA = 0L;
        this.mCB = false;
        this.mCE = true;
        this.mCG = new ArrayList();
        this.mCH = new ArrayList();
        this.mCI = new ArrayList();
        this.mCJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCA = 0L;
        this.mCB = false;
        this.mCE = true;
        this.mCG = new ArrayList();
        this.mCH = new ArrayList();
        this.mCI = new ArrayList();
        this.mCJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCA = 0L;
        this.mCB = false;
        this.mCE = true;
        this.mCG = new ArrayList();
        this.mCH = new ArrayList();
        this.mCI = new ArrayList();
        this.mCJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mCK = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mCx = (RelativeLayout) findViewById(R.id.layout_record);
        this.mCw = (ImageView) findViewById(R.id.delete_video);
        this.mCw.setOnClickListener(this);
        this.mCy = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mCy.setOnTouchListener(this);
        this.mCz = (ImageView) findViewById(R.id.confirm_video);
        this.mCz.setOnClickListener(this);
        this.mCJ.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mCJ.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mzR = iVar;
        Jh(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mCK != null) {
            this.mCK.setListener(aVar);
        }
    }

    public void Jh(int i) {
        this.mzR.setStatus(i);
        if (this.mCD != null) {
            this.mCD.dDQ();
        }
        if (i == 1) {
            this.mCw.setVisibility(8);
            this.mCz.setVisibility(8);
        } else if (i == 3) {
            this.mCw.setImageResource(R.drawable.video_back_selector);
            this.mCz.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mCw.setImageResource(R.drawable.video_back_selector);
            this.mCz.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mCw.setImageResource(R.drawable.video_delete_selector);
            if (this.mzR != null && this.mzR.getVideoDuration() >= 3000.0f) {
                this.mCz.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mCz.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCw) {
            if (this.mCD != null) {
                this.mCD.dDP();
            }
            int status = this.mzR.getStatus();
            if (this.mzR != null && this.mzR.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mzR.dDs();
                    fs(this.mCG);
                    fs(this.mCH);
                    fs(this.mCI);
                    if (this.mzR.getVideoDuration() >= 3000.0f) {
                        Jh(4);
                        return;
                    } else {
                        Jh(this.mzR.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mzR.dDr();
                Jh(5);
            }
        } else if (view == this.mCz) {
            TiebaStatic.log("c12300");
            if (this.mzR != null && this.mzR.getStatus() > 2 && this.mCD != null) {
                if (this.mzR.getVideoDuration() >= 3000.0f) {
                    this.mCD.dDN();
                } else {
                    this.mCD.dDO();
                }
            }
        }
    }

    private void fs(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(final boolean z) {
        if (this.mzR.getProgress() >= 100) {
            if (this.mCD != null) {
                this.mCD.dDN();
                return;
            }
            return;
        }
        if (this.mCK.getCurrentBeautyItem() != null) {
            this.mCG.add(this.mCK.getCurrentBeautyItem());
        }
        if (this.mCK.getCurrentFilterItem() != null) {
            this.mCH.add(this.mCK.getCurrentFilterItem());
        }
        if (this.mCK.getCurrentStickItem() != null) {
            this.mCI.add(this.mCK.getCurrentStickItem());
        }
        Jh(2);
        if (this.mCK.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mzR.getStatus() == 6 || VideoControllerLayout.this.mzR.bmc()) {
                        VideoControllerLayout.this.wN(z);
                    }
                }
            });
        } else {
            wN(z);
        }
        if (this.mzR != null) {
            this.mzR.startRecord();
        }
        if (this.mCD != null) {
            this.mCD.dDI();
        }
    }

    public void stopRecord() {
        dDU();
        int status = this.mzR.getStatus();
        if (this.mzR != null) {
            if (!this.mzR.bIN() && this.mzR.bmc()) {
                this.mzR.stopRecord();
            }
            dDT();
        }
        if (this.mCD != null) {
            this.mCD.dDx();
            if (status == 6) {
                this.mCD.dDK();
            }
        }
    }

    public void dDT() {
        if (this.mzR != null) {
            if (this.mzR.getVideoDuration() >= 3000.0f) {
                Jh(4);
            } else if (this.mzR.getVideoDuration() > 0) {
                Jh(3);
            } else {
                Jh(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN(boolean z) {
        if (this.mBL != null && this.mBL.isRunning()) {
            this.mBL.cancel();
        }
        if (this.mBK == null) {
            this.mBK = new AnimatorSet();
            this.mBK.playTogether(ObjectAnimator.ofFloat(this.mCw, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mCz, "alpha", 1.0f, 0.0f));
            this.mBK.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDA) {
                        VideoControllerLayout.this.mCw.setVisibility(8);
                        VideoControllerLayout.this.mCz.setVisibility(8);
                    }
                }
            });
            this.mBK.setDuration(300L);
        }
        this.mBK.start();
        if (this.mzR.getStatus() != 6) {
            this.mCy.wN(z);
        }
    }

    public void dDU() {
        if (this.mzR == null || this.mzR.bmc() || this.mzR.getStatus() == 6) {
            if (this.mBK != null && this.mBK.isRunning()) {
                this.mBK.cancel();
            }
            if (this.mBL == null) {
                this.mBL = new AnimatorSet();
                this.mBL.playTogether(ObjectAnimator.ofFloat(this.mCw, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mCz, "alpha", 0.0f, 1.0f));
                this.mBL.setDuration(300L);
            }
            this.mCw.setVisibility(0);
            this.mCz.setVisibility(0);
            this.mBL.start();
            if (this.mzR.getStatus() != 7 && this.mzR.getStatus() != 6) {
                this.mCy.dDU();
                return;
            }
            this.mCy.getTvTip().setVisibility(8);
            if (this.inf == 2) {
                this.mCy.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.inf) {
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
                if (this.mCD != null) {
                    this.mCD.dDP();
                }
                if (this.mzR.getStatus() != 7 && this.mzR.getStatus() != 6) {
                    if (this.mzR != null && this.mzR.dDq()) {
                        this.mCF = true;
                        com.baidu.tbadk.core.util.e.bis().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mCA = currentTimeMillis;
                    this.mCB = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mCB && VideoControllerLayout.this.mCA == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.eO(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.mCF) {
                    this.mCF = false;
                    return;
                }
                this.mCB = false;
                if (this.mzR.bmc() || this.mzR.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mzR.getStatus() != 8) {
                    eO(false);
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
                if (this.mzR.getStatus() == 6) {
                    this.mzR.setStatus(1);
                    if (this.mCD != null) {
                        this.mCD.dDK();
                        this.mCD.dDx();
                    }
                    this.mCy.getTvTip().setText("");
                    this.mCy.getTvTip().setVisibility(8);
                    return;
                } else if (this.mCK.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mCD != null) {
                    this.mCD.dDJ();
                    this.mCy.dEf();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mCy.dEg();
                return;
            default:
                return;
        }
    }

    public void dDD() {
        if (this.mCK.getVisibility() == 0) {
            a((m) null);
        }
        wN(false);
        this.mCy.getLayer1().setVisibility(8);
        this.mCy.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mCy.getTvTip().setVisibility(0);
        if (this.mCD != null) {
            this.mCD.dDI();
        }
    }

    public void dDV() {
        if (this.mzR.getStatus() == 6) {
            if (this.inf == 2) {
                Jh(7);
                this.mCy.setAlpha(1.0f);
                this.mCw.setVisibility(8);
                this.mCz.setVisibility(8);
                this.mCy.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mzR != null) {
                    this.mzR.startRecord();
                    return;
                }
                return;
            }
            this.mCy.getTvTip().setVisibility(8);
            if (this.mCD != null) {
                this.mCD.dDJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDE() {
        if (dDY() && this.mCK.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dDY()) {
            dDX();
        }
        this.mCK.dDE();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDF() {
        if (dDY() && this.mCK.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dDY()) {
            dDX();
        }
        this.mCK.dDF();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDG() {
        if (dDY() && this.mCK.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dDY()) {
            dDX();
        }
        this.mCK.dDG();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDH() {
        if (dDY() && this.mCK.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dDY()) {
            dDX();
        }
        this.mCK.dDH();
    }

    private void dDW() {
        if (y.isEmpty(this.mCC)) {
            this.mCC = new ArrayList();
            this.mCC.add(ObjectAnimator.ofFloat(this.mCK, "translationY", 1000.0f, 0.0f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCx, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCy.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCy.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCy.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCy.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCz, "scaleX", 1.0f, 0.7f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCz, "scaleY", 1.0f, 0.7f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCw, "scaleX", 1.0f, 0.7f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCw, "scaleY", 1.0f, 0.7f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCz, "alpha", 1.0f, 0.0f));
            this.mCC.add(ObjectAnimator.ofFloat(this.mCw, "alpha", 1.0f, 0.0f));
        }
    }

    private void dDX() {
        int i = 0;
        if (this.mCK.getVisibility() != 0) {
            this.mCK.setVisibility(0);
            dDW();
            this.mCz.setEnabled(false);
            this.mCw.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mCC.size()) {
                    ObjectAnimator objectAnimator = this.mCC.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mCC.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mCD != null) {
                                        VideoControllerLayout.this.mCD.dDL();
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
        if (this.mCK.getVisibility() != 8) {
            dDW();
            this.mCz.setEnabled(true);
            this.mCw.setEnabled(true);
            if (this.mzR.getStatus() == 6 || this.mzR.bmc()) {
                this.mCw.setVisibility(8);
                this.mCz.setVisibility(8);
            } else {
                Jh(this.mzR.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mCC.size()) {
                    ObjectAnimator objectAnimator = this.mCC.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mCC.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mDA) {
                                        VideoControllerLayout.this.mCK.setVisibility(8);
                                        if (VideoControllerLayout.this.mCD != null) {
                                            VideoControllerLayout.this.mCD.dDM();
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
        this.mCD = aVar;
    }

    public void setCurrentTab(int i) {
        this.inf = i;
        switch (this.inf) {
            case 1:
                this.mCw.setVisibility(4);
                this.mCz.setVisibility(4);
                this.mCy.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mzR.getStatus() != 1) {
                    this.mCw.setVisibility(0);
                    this.mCz.setVisibility(0);
                }
                this.mCy.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dDY() {
        return this.mCK.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mCK != null) {
            this.mCK.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mCK != null) {
            this.mCK.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mCK != null) {
            this.mCK.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dDZ() {
        if (this.mCK != null) {
            return this.mCK.dDZ();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mCE = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mCG;
    }

    public List<e> getChoosedFilterList() {
        return this.mCH;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mCI;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mCJ.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mCK != null) {
            this.mCK.setMusicList(this.mCJ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dEa() {
        if (this.mCK != null) {
            this.mCK.dEa();
        }
    }

    public void dCO() {
        if (this.mCK != null) {
            this.mCK.dCO();
        }
    }
}
