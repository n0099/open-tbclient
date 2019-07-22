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
/* loaded from: classes5.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int fKV;
    private AnimatorSet jBN;
    private AnimatorSet jBO;
    private RelativeLayout jCA;
    private VideoRecordButton jCB;
    private ImageView jCC;
    private long jCD;
    private boolean jCE;
    private List<ObjectAnimator> jCF;
    private a jCG;
    private boolean jCH;
    private boolean jCI;
    private List<e> jCJ;
    private List<e> jCK;
    private List<StickerItem> jCL;
    private List<e> jCM;
    private VideoEffectLayout jCN;
    private ImageView jCz;
    private i jzP;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void cwB();

        void cwC();

        void cwD();

        void cwE();

        void cwF();

        void cwG();

        void cwH();

        void cwI();

        void cwJ();

        void cwq();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jCD = 0L;
        this.jCE = false;
        this.jCH = true;
        this.jCJ = new ArrayList();
        this.jCK = new ArrayList();
        this.jCL = new ArrayList();
        this.jCM = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCD = 0L;
        this.jCE = false;
        this.jCH = true;
        this.jCJ = new ArrayList();
        this.jCK = new ArrayList();
        this.jCL = new ArrayList();
        this.jCM = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCD = 0L;
        this.jCE = false;
        this.jCH = true;
        this.jCJ = new ArrayList();
        this.jCK = new ArrayList();
        this.jCL = new ArrayList();
        this.jCM = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jCN = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jCA = (RelativeLayout) findViewById(R.id.layout_record);
        this.jCz = (ImageView) findViewById(R.id.delete_video);
        this.jCz.setOnClickListener(this);
        this.jCB = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jCB.setOnTouchListener(this);
        this.jCC = (ImageView) findViewById(R.id.confirm_video);
        this.jCC.setOnClickListener(this);
        this.jCM.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jCM.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jzP = iVar;
        Cu(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jCN != null) {
            this.jCN.setListener(aVar);
        }
    }

    public void Cu(int i) {
        this.jzP.setStatus(i);
        if (this.jCG != null) {
            this.jCG.cwJ();
        }
        if (i == 1) {
            this.jCz.setVisibility(8);
            this.jCC.setVisibility(8);
        } else if (i == 3) {
            this.jCz.setImageResource(R.drawable.video_back_selector);
            this.jCC.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jCz.setImageResource(R.drawable.video_back_selector);
            this.jCC.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jCz.setImageResource(R.drawable.video_delete_selector);
            if (this.jzP != null && this.jzP.getVideoDuration() >= 3000.0f) {
                this.jCC.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jCC.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jCz) {
            if (this.jCG != null) {
                this.jCG.cwI();
            }
            int status = this.jzP.getStatus();
            if (this.jzP != null && this.jzP.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jzP.cwj();
                    eu(this.jCJ);
                    eu(this.jCK);
                    eu(this.jCL);
                    if (this.jzP.getVideoDuration() >= 3000.0f) {
                        Cu(4);
                        return;
                    } else {
                        Cu(this.jzP.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jzP.cwi();
                Cu(5);
            }
        } else if (view == this.jCC) {
            TiebaStatic.log("c12300");
            if (this.jzP != null && this.jzP.getStatus() > 2 && this.jCG != null) {
                if (this.jzP.getVideoDuration() >= 3000.0f) {
                    this.jCG.cwG();
                } else {
                    this.jCG.cwH();
                }
            }
        }
    }

    private void eu(List list) {
        if (!v.aa(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(final boolean z) {
        if (this.jzP.getProgress() >= 100) {
            if (this.jCG != null) {
                this.jCG.cwG();
                return;
            }
            return;
        }
        if (this.jCN.getCurrentBeautyItem() != null) {
            this.jCJ.add(this.jCN.getCurrentBeautyItem());
        }
        if (this.jCN.getCurrentFilterItem() != null) {
            this.jCK.add(this.jCN.getCurrentFilterItem());
        }
        if (this.jCN.getCurrentStickItem() != null) {
            this.jCL.add(this.jCN.getCurrentStickItem());
        }
        Cu(2);
        if (this.jCN.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jzP.getStatus() == 6 || VideoControllerLayout.this.jzP.alA()) {
                        VideoControllerLayout.this.rN(z);
                    }
                }
            });
        } else {
            rN(z);
        }
        if (this.jzP != null) {
            this.jzP.startRecord();
        }
        if (this.jCG != null) {
            this.jCG.cwB();
        }
    }

    public void stopRecord() {
        cwN();
        int status = this.jzP.getStatus();
        if (this.jzP != null) {
            if (!this.jzP.cwk() && this.jzP.alA()) {
                this.jzP.stopRecord();
            }
            cwM();
        }
        if (this.jCG != null) {
            this.jCG.cwq();
            if (status == 6) {
                this.jCG.cwD();
            }
        }
    }

    public void cwM() {
        if (this.jzP != null) {
            if (this.jzP.getVideoDuration() >= 3000.0f) {
                Cu(4);
            } else if (this.jzP.getVideoDuration() > 0) {
                Cu(3);
            } else {
                Cu(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(boolean z) {
        if (this.jBO != null && this.jBO.isRunning()) {
            this.jBO.cancel();
        }
        if (this.jBN == null) {
            this.jBN = new AnimatorSet();
            this.jBN.playTogether(ObjectAnimator.ofFloat(this.jCz, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jCC, "alpha", 1.0f, 0.0f));
            this.jBN.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jDA) {
                        VideoControllerLayout.this.jCz.setVisibility(8);
                        VideoControllerLayout.this.jCC.setVisibility(8);
                    }
                }
            });
            this.jBN.setDuration(300L);
        }
        this.jBN.start();
        if (this.jzP.getStatus() != 6) {
            this.jCB.rN(z);
        }
    }

    public void cwN() {
        if (this.jzP == null || this.jzP.alA() || this.jzP.getStatus() == 6) {
            if (this.jBN != null && this.jBN.isRunning()) {
                this.jBN.cancel();
            }
            if (this.jBO == null) {
                this.jBO = new AnimatorSet();
                this.jBO.playTogether(ObjectAnimator.ofFloat(this.jCz, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jCC, "alpha", 0.0f, 1.0f));
                this.jBO.setDuration(300L);
            }
            this.jCz.setVisibility(0);
            this.jCC.setVisibility(0);
            this.jBO.start();
            if (this.jzP.getStatus() != 7 && this.jzP.getStatus() != 6) {
                this.jCB.cwN();
                return;
            }
            this.jCB.getTvTip().setVisibility(8);
            if (this.fKV == 2) {
                this.jCB.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fKV) {
            case 1:
                i(view, motionEvent);
                return true;
            case 2:
                h(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void h(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jCG != null) {
                    this.jCG.cwI();
                }
                if (this.jzP.getStatus() != 7 && this.jzP.getStatus() != 6) {
                    if (this.jzP != null && this.jzP.cwh()) {
                        this.jCI = true;
                        com.baidu.tbadk.core.util.e.ahW().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jCD = currentTimeMillis;
                    this.jCE = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jCE && VideoControllerLayout.this.jCD == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.aG(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jCI) {
                    this.jCI = false;
                    return;
                }
                this.jCE = false;
                if (this.jzP.alA() || this.jzP.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jzP.getStatus() != 8) {
                    aG(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void i(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jzP.getStatus() == 6) {
                    this.jzP.setStatus(1);
                    if (this.jCG != null) {
                        this.jCG.cwD();
                        this.jCG.cwq();
                    }
                    this.jCB.getTvTip().setText("");
                    this.jCB.getTvTip().setVisibility(8);
                    return;
                } else if (this.jCN.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jCG != null) {
                    this.jCG.cwC();
                    this.jCB.cwY();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jCB.cwZ();
                return;
            default:
                return;
        }
    }

    public void cww() {
        if (this.jCN.getVisibility() == 0) {
            a((m) null);
        }
        rN(false);
        this.jCB.getLayer1().setVisibility(8);
        this.jCB.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jCB.getTvTip().setVisibility(0);
        if (this.jCG != null) {
            this.jCG.cwB();
        }
    }

    public void cwO() {
        if (this.jzP.getStatus() == 6) {
            if (this.fKV == 2) {
                Cu(7);
                this.jCB.setAlpha(1.0f);
                this.jCz.setVisibility(8);
                this.jCC.setVisibility(8);
                this.jCB.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jzP != null) {
                    this.jzP.startRecord();
                    return;
                }
                return;
            }
            this.jCB.getTvTip().setVisibility(8);
            if (this.jCG != null) {
                this.jCG.cwC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwx() {
        if (cwR() && this.jCN.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cwR()) {
            cwQ();
        }
        this.jCN.cwx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwy() {
        if (cwR() && this.jCN.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cwR()) {
            cwQ();
        }
        this.jCN.cwy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwz() {
        if (cwR() && this.jCN.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cwR()) {
            cwQ();
        }
        this.jCN.cwz();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwA() {
        if (cwR() && this.jCN.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cwR()) {
            cwQ();
        }
        this.jCN.cwA();
    }

    private void cwP() {
        if (v.aa(this.jCF)) {
            this.jCF = new ArrayList();
            this.jCF.add(ObjectAnimator.ofFloat(this.jCN, "translationY", 1000.0f, 0.0f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCA, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCB.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCB.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCB.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCB.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCC, "scaleX", 1.0f, 0.7f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCC, "scaleY", 1.0f, 0.7f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCz, "scaleX", 1.0f, 0.7f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCz, "scaleY", 1.0f, 0.7f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCC, "alpha", 1.0f, 0.0f));
            this.jCF.add(ObjectAnimator.ofFloat(this.jCz, "alpha", 1.0f, 0.0f));
        }
    }

    private void cwQ() {
        int i = 0;
        if (this.jCN.getVisibility() != 0) {
            this.jCN.setVisibility(0);
            cwP();
            this.jCC.setEnabled(false);
            this.jCz.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jCF.size()) {
                    ObjectAnimator objectAnimator = this.jCF.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jCF.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jCG != null) {
                                        VideoControllerLayout.this.jCG.cwE();
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
        if (this.jCN.getVisibility() != 8) {
            cwP();
            this.jCC.setEnabled(true);
            this.jCz.setEnabled(true);
            if (this.jzP.getStatus() == 6 || this.jzP.alA()) {
                this.jCz.setVisibility(8);
                this.jCC.setVisibility(8);
            } else {
                Cu(this.jzP.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jCF.size()) {
                    ObjectAnimator objectAnimator = this.jCF.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jCF.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jDA) {
                                        VideoControllerLayout.this.jCN.setVisibility(8);
                                        if (VideoControllerLayout.this.jCG != null) {
                                            VideoControllerLayout.this.jCG.cwF();
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
        this.jCG = aVar;
    }

    public void setCurrentTab(int i) {
        this.fKV = i;
        switch (this.fKV) {
            case 1:
                this.jCz.setVisibility(4);
                this.jCC.setVisibility(4);
                this.jCB.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jzP.getStatus() != 1) {
                    this.jCz.setVisibility(0);
                    this.jCC.setVisibility(0);
                }
                this.jCB.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cwR() {
        return this.jCN.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jCN != null) {
            this.jCN.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jCN != null) {
            this.jCN.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jCN != null) {
            this.jCN.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cwS() {
        if (this.jCN != null) {
            return this.jCN.cwS();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jCH = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jCJ;
    }

    public List<e> getChoosedFilterList() {
        return this.jCK;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jCL;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jCM.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jCN != null) {
            this.jCN.setMusicList(this.jCM);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cwT() {
        if (this.jCN != null) {
            this.jCN.cwT();
        }
    }

    public void cvH() {
        if (this.jCN != null) {
            this.jCN.cvH();
        }
    }
}
