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
    private int hFJ;
    private i lGX;
    private AnimatorSet lIQ;
    private AnimatorSet lIR;
    private ImageView lJA;
    private RelativeLayout lJB;
    private VideoRecordButton lJC;
    private ImageView lJD;
    private long lJE;
    private boolean lJF;
    private List<ObjectAnimator> lJG;
    private a lJH;
    private boolean lJI;
    private boolean lJJ;
    private List<e> lJK;
    private List<e> lJL;
    private List<StickerItem> lJM;
    private List<e> lJN;
    private VideoEffectLayout lJO;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void dkC();

        void dkN();

        void dkO();

        void dkP();

        void dkQ();

        void dkR();

        void dkS();

        void dkT();

        void dkU();

        void dkV();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.lJE = 0L;
        this.lJF = false;
        this.lJI = true;
        this.lJK = new ArrayList();
        this.lJL = new ArrayList();
        this.lJM = new ArrayList();
        this.lJN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lJE = 0L;
        this.lJF = false;
        this.lJI = true;
        this.lJK = new ArrayList();
        this.lJL = new ArrayList();
        this.lJM = new ArrayList();
        this.lJN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJE = 0L;
        this.lJF = false;
        this.lJI = true;
        this.lJK = new ArrayList();
        this.lJL = new ArrayList();
        this.lJM = new ArrayList();
        this.lJN = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.lJO = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.lJB = (RelativeLayout) findViewById(R.id.layout_record);
        this.lJA = (ImageView) findViewById(R.id.delete_video);
        this.lJA.setOnClickListener(this);
        this.lJC = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.lJC.setOnTouchListener(this);
        this.lJD = (ImageView) findViewById(R.id.confirm_video);
        this.lJD.setOnClickListener(this);
        this.lJN.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.lJN.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.lGX = iVar;
        Fl(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.lJO != null) {
            this.lJO.setListener(aVar);
        }
    }

    public void Fl(int i) {
        this.lGX.setStatus(i);
        if (this.lJH != null) {
            this.lJH.dkV();
        }
        if (i == 1) {
            this.lJA.setVisibility(8);
            this.lJD.setVisibility(8);
        } else if (i == 3) {
            this.lJA.setImageResource(R.drawable.video_back_selector);
            this.lJD.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.lJA.setImageResource(R.drawable.video_back_selector);
            this.lJD.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.lJA.setImageResource(R.drawable.video_delete_selector);
            if (this.lGX != null && this.lGX.getVideoDuration() >= 3000.0f) {
                this.lJD.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.lJD.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lJA) {
            if (this.lJH != null) {
                this.lJH.dkU();
            }
            int status = this.lGX.getStatus();
            if (this.lGX != null && this.lGX.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.lGX.dkx();
                    eR(this.lJK);
                    eR(this.lJL);
                    eR(this.lJM);
                    if (this.lGX.getVideoDuration() >= 3000.0f) {
                        Fl(4);
                        return;
                    } else {
                        Fl(this.lGX.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.lGX.dkw();
                Fl(5);
            }
        } else if (view == this.lJD) {
            TiebaStatic.log("c12300");
            if (this.lGX != null && this.lGX.getStatus() > 2 && this.lJH != null) {
                if (this.lGX.getVideoDuration() >= 3000.0f) {
                    this.lJH.dkS();
                } else {
                    this.lJH.dkT();
                }
            }
        }
    }

    private void eR(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(final boolean z) {
        if (this.lGX.getProgress() >= 100) {
            if (this.lJH != null) {
                this.lJH.dkS();
                return;
            }
            return;
        }
        if (this.lJO.getCurrentBeautyItem() != null) {
            this.lJK.add(this.lJO.getCurrentBeautyItem());
        }
        if (this.lJO.getCurrentFilterItem() != null) {
            this.lJL.add(this.lJO.getCurrentFilterItem());
        }
        if (this.lJO.getCurrentStickItem() != null) {
            this.lJM.add(this.lJO.getCurrentStickItem());
        }
        Fl(2);
        if (this.lJO.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.lGX.getStatus() == 6 || VideoControllerLayout.this.lGX.aXt()) {
                        VideoControllerLayout.this.vc(z);
                    }
                }
            });
        } else {
            vc(z);
        }
        if (this.lGX != null) {
            this.lGX.startRecord();
        }
        if (this.lJH != null) {
            this.lJH.dkN();
        }
    }

    public void stopRecord() {
        dkZ();
        int status = this.lGX.getStatus();
        if (this.lGX != null) {
            if (!this.lGX.bty() && this.lGX.aXt()) {
                this.lGX.stopRecord();
            }
            dkY();
        }
        if (this.lJH != null) {
            this.lJH.dkC();
            if (status == 6) {
                this.lJH.dkP();
            }
        }
    }

    public void dkY() {
        if (this.lGX != null) {
            if (this.lGX.getVideoDuration() >= 3000.0f) {
                Fl(4);
            } else if (this.lGX.getVideoDuration() > 0) {
                Fl(3);
            } else {
                Fl(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(boolean z) {
        if (this.lIR != null && this.lIR.isRunning()) {
            this.lIR.cancel();
        }
        if (this.lIQ == null) {
            this.lIQ = new AnimatorSet();
            this.lIQ.playTogether(ObjectAnimator.ofFloat(this.lJA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lJD, "alpha", 1.0f, 0.0f));
            this.lIQ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lKB) {
                        VideoControllerLayout.this.lJA.setVisibility(8);
                        VideoControllerLayout.this.lJD.setVisibility(8);
                    }
                }
            });
            this.lIQ.setDuration(300L);
        }
        this.lIQ.start();
        if (this.lGX.getStatus() != 6) {
            this.lJC.vc(z);
        }
    }

    public void dkZ() {
        if (this.lGX == null || this.lGX.aXt() || this.lGX.getStatus() == 6) {
            if (this.lIQ != null && this.lIQ.isRunning()) {
                this.lIQ.cancel();
            }
            if (this.lIR == null) {
                this.lIR = new AnimatorSet();
                this.lIR.playTogether(ObjectAnimator.ofFloat(this.lJA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lJD, "alpha", 0.0f, 1.0f));
                this.lIR.setDuration(300L);
            }
            this.lJA.setVisibility(0);
            this.lJD.setVisibility(0);
            this.lIR.start();
            if (this.lGX.getStatus() != 7 && this.lGX.getStatus() != 6) {
                this.lJC.dkZ();
                return;
            }
            this.lJC.getTvTip().setVisibility(8);
            if (this.hFJ == 2) {
                this.lJC.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hFJ) {
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
                if (this.lJH != null) {
                    this.lJH.dkU();
                }
                if (this.lGX.getStatus() != 7 && this.lGX.getStatus() != 6) {
                    if (this.lGX != null && this.lGX.dkv()) {
                        this.lJJ = true;
                        com.baidu.tbadk.core.util.e.aUf().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.lJE = currentTimeMillis;
                    this.lJF = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.lJF && VideoControllerLayout.this.lJE == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.el(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.lJJ) {
                    this.lJJ = false;
                    return;
                }
                this.lJF = false;
                if (this.lGX.aXt() || this.lGX.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.lGX.getStatus() != 8) {
                    el(false);
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
                if (this.lGX.getStatus() == 6) {
                    this.lGX.setStatus(1);
                    if (this.lJH != null) {
                        this.lJH.dkP();
                        this.lJH.dkC();
                    }
                    this.lJC.getTvTip().setText("");
                    this.lJC.getTvTip().setVisibility(8);
                    return;
                } else if (this.lJO.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.lJH != null) {
                    this.lJH.dkO();
                    this.lJC.dlk();
                    return;
                } else {
                    return;
                }
            case 1:
                this.lJC.dll();
                return;
            default:
                return;
        }
    }

    public void dkI() {
        if (this.lJO.getVisibility() == 0) {
            a((m) null);
        }
        vc(false);
        this.lJC.getLayer1().setVisibility(8);
        this.lJC.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.lJC.getTvTip().setVisibility(0);
        if (this.lJH != null) {
            this.lJH.dkN();
        }
    }

    public void dla() {
        if (this.lGX.getStatus() == 6) {
            if (this.hFJ == 2) {
                Fl(7);
                this.lJC.setAlpha(1.0f);
                this.lJA.setVisibility(8);
                this.lJD.setVisibility(8);
                this.lJC.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.lGX != null) {
                    this.lGX.startRecord();
                    return;
                }
                return;
            }
            this.lJC.getTvTip().setVisibility(8);
            if (this.lJH != null) {
                this.lJH.dkO();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkJ() {
        if (dld() && this.lJO.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dld()) {
            dlc();
        }
        this.lJO.dkJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkK() {
        if (dld() && this.lJO.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dld()) {
            dlc();
        }
        this.lJO.dkK();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkL() {
        if (dld() && this.lJO.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dld()) {
            dlc();
        }
        this.lJO.dkL();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkM() {
        if (dld() && this.lJO.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dld()) {
            dlc();
        }
        this.lJO.dkM();
    }

    private void dlb() {
        if (v.isEmpty(this.lJG)) {
            this.lJG = new ArrayList();
            this.lJG.add(ObjectAnimator.ofFloat(this.lJO, "translationY", 1000.0f, 0.0f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJB, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJC.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJC.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJC.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJC.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJD, "scaleX", 1.0f, 0.7f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJD, "scaleY", 1.0f, 0.7f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJA, "scaleX", 1.0f, 0.7f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJA, "scaleY", 1.0f, 0.7f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJD, "alpha", 1.0f, 0.0f));
            this.lJG.add(ObjectAnimator.ofFloat(this.lJA, "alpha", 1.0f, 0.0f));
        }
    }

    private void dlc() {
        int i = 0;
        if (this.lJO.getVisibility() != 0) {
            this.lJO.setVisibility(0);
            dlb();
            this.lJD.setEnabled(false);
            this.lJA.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.lJG.size()) {
                    ObjectAnimator objectAnimator = this.lJG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lJG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.lJH != null) {
                                        VideoControllerLayout.this.lJH.dkQ();
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
        if (this.lJO.getVisibility() != 8) {
            dlb();
            this.lJD.setEnabled(true);
            this.lJA.setEnabled(true);
            if (this.lGX.getStatus() == 6 || this.lGX.aXt()) {
                this.lJA.setVisibility(8);
                this.lJD.setVisibility(8);
            } else {
                Fl(this.lGX.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lJG.size()) {
                    ObjectAnimator objectAnimator = this.lJG.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lJG.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.lKB) {
                                        VideoControllerLayout.this.lJO.setVisibility(8);
                                        if (VideoControllerLayout.this.lJH != null) {
                                            VideoControllerLayout.this.lJH.dkR();
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
        this.lJH = aVar;
    }

    public void setCurrentTab(int i) {
        this.hFJ = i;
        switch (this.hFJ) {
            case 1:
                this.lJA.setVisibility(4);
                this.lJD.setVisibility(4);
                this.lJC.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.lGX.getStatus() != 1) {
                    this.lJA.setVisibility(0);
                    this.lJD.setVisibility(0);
                }
                this.lJC.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dld() {
        return this.lJO.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.lJO != null) {
            this.lJO.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.lJO != null) {
            this.lJO.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.lJO != null) {
            this.lJO.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dle() {
        if (this.lJO != null) {
            return this.lJO.dle();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.lJI = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.lJK;
    }

    public List<e> getChoosedFilterList() {
        return this.lJL;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.lJM;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.lJN.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.lJO != null) {
            this.lJO.setMusicList(this.lJN);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dlf() {
        if (this.lJO != null) {
            this.lJO.dlf();
        }
    }

    public void djT() {
        if (this.lJO != null) {
            this.lJO.djT();
        }
    }
}
