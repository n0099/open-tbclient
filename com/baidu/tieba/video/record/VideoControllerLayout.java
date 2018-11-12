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
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dSj;
    private AnimatorSet hAQ;
    private AnimatorSet hAR;
    private ImageView hBC;
    private RelativeLayout hBD;
    private VideoRecordButton hBE;
    private ImageView hBF;
    private long hBG;
    private boolean hBH;
    private List<ObjectAnimator> hBI;
    private a hBJ;
    private boolean hBK;
    private boolean hBL;
    private List<e> hBM;
    private List<e> hBN;
    private List<StickerItem> hBO;
    private List<e> hBP;
    private VideoEffectLayout hBQ;
    private i hyQ;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void bIG();

        void bIH();

        void bII();

        void bIJ();

        void bIK();

        void bIL();

        void bIM();

        void bIN();

        void bIO();

        void bIv();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hBG = 0L;
        this.hBH = false;
        this.hBK = true;
        this.hBM = new ArrayList();
        this.hBN = new ArrayList();
        this.hBO = new ArrayList();
        this.hBP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hBG = 0L;
        this.hBH = false;
        this.hBK = true;
        this.hBM = new ArrayList();
        this.hBN = new ArrayList();
        this.hBO = new ArrayList();
        this.hBP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hBG = 0L;
        this.hBH = false;
        this.hBK = true;
        this.hBM = new ArrayList();
        this.hBN = new ArrayList();
        this.hBO = new ArrayList();
        this.hBP = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(e.h.record_controller_layout, this);
        this.hBQ = (VideoEffectLayout) findViewById(e.g.layout_effect);
        this.hBD = (RelativeLayout) findViewById(e.g.layout_record);
        this.hBC = (ImageView) findViewById(e.g.delete_video);
        this.hBC.setOnClickListener(this);
        this.hBE = (VideoRecordButton) findViewById(e.g.layout_record_button);
        this.hBE.setOnTouchListener(this);
        this.hBF = (ImageView) findViewById(e.g.confirm_video);
        this.hBF.setOnClickListener(this);
        this.hBP.add(0, new e(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute));
        this.hBP.add(1, new e(3, getResources().getString(e.j.music_cloud), new MusicData("-200", 2, getResources().getString(e.j.music_cloud)), e.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hyQ = iVar;
        wk(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hBQ != null) {
            this.hBQ.setListener(aVar);
        }
    }

    public void wk(int i) {
        this.hyQ.setStatus(i);
        if (this.hBJ != null) {
            this.hBJ.bIO();
        }
        if (i == 1) {
            this.hBC.setVisibility(8);
            this.hBF.setVisibility(8);
        } else if (i == 3) {
            this.hBC.setImageResource(e.f.video_back_selector);
            this.hBF.setImageResource(e.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hBC.setImageResource(e.f.video_back_selector);
            this.hBF.setImageResource(e.f.video_confirm_selector);
        } else if (i == 5) {
            this.hBC.setImageResource(e.f.video_delete_selector);
            if (this.hyQ != null && this.hyQ.getVideoDuration() >= 3000.0f) {
                this.hBF.setImageResource(e.f.video_confirm_selector);
            } else {
                this.hBF.setImageResource(e.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hBC) {
            if (this.hBJ != null) {
                this.hBJ.bIN();
            }
            int status = this.hyQ.getStatus();
            if (this.hyQ != null && this.hyQ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hyQ.bIo();
                    dY(this.hBM);
                    dY(this.hBN);
                    dY(this.hBO);
                    if (this.hyQ.getVideoDuration() >= 3000.0f) {
                        wk(4);
                        return;
                    } else {
                        wk(this.hyQ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hyQ.bIn();
                wk(5);
            }
        } else if (view == this.hBF) {
            TiebaStatic.log("c12300");
            if (this.hyQ != null && this.hyQ.getStatus() > 2 && this.hBJ != null) {
                if (this.hyQ.getVideoDuration() >= 3000.0f) {
                    this.hBJ.bIL();
                } else {
                    this.hBJ.bIM();
                }
            }
        }
    }

    private void dY(List list) {
        if (!v.I(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord(final boolean z) {
        if (this.hyQ.getProgress() >= 100) {
            if (this.hBJ != null) {
                this.hBJ.bIL();
                return;
            }
            return;
        }
        if (this.hBQ.getCurrentBeautyItem() != null) {
            this.hBM.add(this.hBQ.getCurrentBeautyItem());
        }
        if (this.hBQ.getCurrentFilterItem() != null) {
            this.hBN.add(this.hBQ.getCurrentFilterItem());
        }
        if (this.hBQ.getCurrentStickItem() != null) {
            this.hBO.add(this.hBQ.getCurrentStickItem());
        }
        wk(2);
        if (this.hBQ.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hyQ.getStatus() == 6 || VideoControllerLayout.this.hyQ.EN()) {
                        VideoControllerLayout.this.oe(z);
                    }
                }
            });
        } else {
            oe(z);
        }
        if (this.hyQ != null) {
            this.hyQ.startRecord();
        }
        if (this.hBJ != null) {
            this.hBJ.bIG();
        }
    }

    public void stopRecord() {
        bIS();
        int status = this.hyQ.getStatus();
        if (this.hyQ != null) {
            if (!this.hyQ.bIp() && this.hyQ.EN()) {
                this.hyQ.stopRecord();
            }
            bIR();
        }
        if (this.hBJ != null) {
            this.hBJ.bIv();
            if (status == 6) {
                this.hBJ.bII();
            }
        }
    }

    public void bIR() {
        if (this.hyQ != null) {
            if (this.hyQ.getVideoDuration() >= 3000.0f) {
                wk(4);
            } else if (this.hyQ.getVideoDuration() > 0) {
                wk(3);
            } else {
                wk(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(boolean z) {
        if (this.hAR != null && this.hAR.isRunning()) {
            this.hAR.cancel();
        }
        if (this.hAQ == null) {
            this.hAQ = new AnimatorSet();
            this.hAQ.playTogether(ObjectAnimator.ofFloat(this.hBC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hBF, "alpha", 1.0f, 0.0f));
            this.hAQ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hCE) {
                        VideoControllerLayout.this.hBC.setVisibility(8);
                        VideoControllerLayout.this.hBF.setVisibility(8);
                    }
                }
            });
            this.hAQ.setDuration(300L);
        }
        this.hAQ.start();
        if (this.hyQ.getStatus() != 6) {
            this.hBE.oe(z);
        }
    }

    public void bIS() {
        if (this.hyQ == null || this.hyQ.EN() || this.hyQ.getStatus() == 6) {
            if (this.hAQ != null && this.hAQ.isRunning()) {
                this.hAQ.cancel();
            }
            if (this.hAR == null) {
                this.hAR = new AnimatorSet();
                this.hAR.playTogether(ObjectAnimator.ofFloat(this.hBC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hBF, "alpha", 0.0f, 1.0f));
                this.hAR.setDuration(300L);
            }
            this.hBC.setVisibility(0);
            this.hBF.setVisibility(0);
            this.hAR.start();
            if (this.hyQ.getStatus() != 7 && this.hyQ.getStatus() != 6) {
                this.hBE.bIS();
                return;
            }
            this.hBE.getTvTip().setVisibility(8);
            if (this.dSj == 2) {
                this.hBE.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dSj) {
            case 1:
                g(view, motionEvent);
                return true;
            case 2:
                f(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void f(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hBJ != null) {
                    this.hBJ.bIN();
                }
                if (this.hyQ.getStatus() != 7 && this.hyQ.getStatus() != 6) {
                    if (this.hyQ != null && this.hyQ.bIm()) {
                        this.hBL = true;
                        com.baidu.tbadk.core.util.e.Bz().showToast(e.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hBG = currentTimeMillis;
                    this.hBH = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hBH && VideoControllerLayout.this.hBG == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.startRecord(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hBL) {
                    this.hBL = false;
                    return;
                }
                this.hBH = false;
                if (this.hyQ.EN() || this.hyQ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hyQ.getStatus() != 8) {
                    startRecord(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void g(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.hyQ.getStatus() == 6) {
                    this.hyQ.setStatus(1);
                    if (this.hBJ != null) {
                        this.hBJ.bII();
                        this.hBJ.bIv();
                    }
                    this.hBE.getTvTip().setText("");
                    this.hBE.getTvTip().setVisibility(8);
                    return;
                } else if (this.hBQ.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hBJ != null) {
                    this.hBJ.bIH();
                    this.hBE.bJd();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hBE.bJe();
                return;
            default:
                return;
        }
    }

    public void bIB() {
        if (this.hBQ.getVisibility() == 0) {
            a((m) null);
        }
        oe(false);
        this.hBE.getLayer1().setVisibility(8);
        this.hBE.getTvTip().setText(getResources().getText(e.j.video_record_button_cancel));
        this.hBE.getTvTip().setVisibility(0);
        if (this.hBJ != null) {
            this.hBJ.bIG();
        }
    }

    public void bIT() {
        if (this.hyQ.getStatus() == 6) {
            if (this.dSj == 2) {
                wk(7);
                this.hBE.setAlpha(1.0f);
                this.hBC.setVisibility(8);
                this.hBF.setVisibility(8);
                this.hBE.getTvTip().setText(getResources().getString(e.j.video_record_button_pasue));
                if (this.hyQ != null) {
                    this.hyQ.startRecord();
                    return;
                }
                return;
            }
            this.hBE.getTvTip().setVisibility(8);
            if (this.hBJ != null) {
                this.hBJ.bIH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIC() {
        if (bIW() && this.hBQ.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bIW()) {
            bIV();
        }
        this.hBQ.bIC();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bID() {
        if (bIW() && this.hBQ.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bIW()) {
            bIV();
        }
        this.hBQ.bID();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIE() {
        if (bIW() && this.hBQ.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bIW()) {
            bIV();
        }
        this.hBQ.bIE();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIF() {
        if (bIW() && this.hBQ.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bIW()) {
            bIV();
        }
        this.hBQ.bIF();
    }

    private void bIU() {
        if (v.I(this.hBI)) {
            this.hBI = new ArrayList();
            this.hBI.add(ObjectAnimator.ofFloat(this.hBQ, "translationY", 1000.0f, 0.0f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBD, "translationY", 0.0f, com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds100)));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBE.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBE.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBE.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBE.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBF, "scaleX", 1.0f, 0.7f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBF, "scaleY", 1.0f, 0.7f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBC, "scaleX", 1.0f, 0.7f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBC, "scaleY", 1.0f, 0.7f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBF, "alpha", 1.0f, 0.0f));
            this.hBI.add(ObjectAnimator.ofFloat(this.hBC, "alpha", 1.0f, 0.0f));
        }
    }

    private void bIV() {
        int i = 0;
        if (this.hBQ.getVisibility() != 0) {
            this.hBQ.setVisibility(0);
            bIU();
            this.hBF.setEnabled(false);
            this.hBC.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hBI.size()) {
                    ObjectAnimator objectAnimator = this.hBI.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hBI.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hBJ != null) {
                                        VideoControllerLayout.this.hBJ.bIJ();
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
        if (this.hBQ.getVisibility() != 8) {
            bIU();
            this.hBF.setEnabled(true);
            this.hBC.setEnabled(true);
            if (this.hyQ.getStatus() == 6 || this.hyQ.EN()) {
                this.hBC.setVisibility(8);
                this.hBF.setVisibility(8);
            } else {
                wk(this.hyQ.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hBI.size()) {
                    ObjectAnimator objectAnimator = this.hBI.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hBI.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hCE) {
                                        VideoControllerLayout.this.hBQ.setVisibility(8);
                                        if (VideoControllerLayout.this.hBJ != null) {
                                            VideoControllerLayout.this.hBJ.bIK();
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
        this.hBJ = aVar;
    }

    public void setCurrentTab(int i) {
        this.dSj = i;
        switch (this.dSj) {
            case 1:
                this.hBC.setVisibility(4);
                this.hBF.setVisibility(4);
                this.hBE.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hyQ.getStatus() != 1) {
                    this.hBC.setVisibility(0);
                    this.hBF.setVisibility(0);
                }
                this.hBE.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bIW() {
        return this.hBQ.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hBQ != null) {
            this.hBQ.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hBQ != null) {
            this.hBQ.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hBQ != null) {
            this.hBQ.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bIX() {
        if (this.hBQ != null) {
            return this.hBQ.bIX();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hBK = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hBM;
    }

    public List<e> getChoosedFilterList() {
        return this.hBN;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hBO;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hBP.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hBQ != null) {
            this.hBQ.setMusicList(this.hBP);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bIY() {
        if (this.hBQ != null) {
            this.hBQ.bIY();
        }
    }

    public void bHM() {
        if (this.hBQ != null) {
            this.hBQ.bHM();
        }
    }
}
