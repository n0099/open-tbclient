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
/* loaded from: classes7.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private i kwi;
    private AnimatorSet kxZ;
    private ImageView kyK;
    private RelativeLayout kyL;
    private VideoRecordButton kyM;
    private ImageView kyN;
    private long kyO;
    private boolean kyP;
    private List<ObjectAnimator> kyQ;
    private a kyR;
    private boolean kyS;
    private boolean kyT;
    private List<e> kyU;
    private List<e> kyV;
    private List<StickerItem> kyW;
    private List<e> kyX;
    private VideoEffectLayout kyY;
    private AnimatorSet kya;
    private int mCurrentTab;
    private Handler mHandler;

    /* loaded from: classes7.dex */
    public interface a {
        void cPf();

        void cPq();

        void cPr();

        void cPs();

        void cPt();

        void cPu();

        void cPv();

        void cPw();

        void cPx();

        void cPy();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.kyO = 0L;
        this.kyP = false;
        this.kyS = true;
        this.kyU = new ArrayList();
        this.kyV = new ArrayList();
        this.kyW = new ArrayList();
        this.kyX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyO = 0L;
        this.kyP = false;
        this.kyS = true;
        this.kyU = new ArrayList();
        this.kyV = new ArrayList();
        this.kyW = new ArrayList();
        this.kyX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kyO = 0L;
        this.kyP = false;
        this.kyS = true;
        this.kyU = new ArrayList();
        this.kyV = new ArrayList();
        this.kyW = new ArrayList();
        this.kyX = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.kyY = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.kyL = (RelativeLayout) findViewById(R.id.layout_record);
        this.kyK = (ImageView) findViewById(R.id.delete_video);
        this.kyK.setOnClickListener(this);
        this.kyM = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.kyM.setOnTouchListener(this);
        this.kyN = (ImageView) findViewById(R.id.confirm_video);
        this.kyN.setOnClickListener(this);
        this.kyX.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.kyX.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.kwi = iVar;
        DA(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.kyY != null) {
            this.kyY.setListener(aVar);
        }
    }

    public void DA(int i) {
        this.kwi.setStatus(i);
        if (this.kyR != null) {
            this.kyR.cPy();
        }
        if (i == 1) {
            this.kyK.setVisibility(8);
            this.kyN.setVisibility(8);
        } else if (i == 3) {
            this.kyK.setImageResource(R.drawable.video_back_selector);
            this.kyN.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.kyK.setImageResource(R.drawable.video_back_selector);
            this.kyN.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.kyK.setImageResource(R.drawable.video_delete_selector);
            if (this.kwi != null && this.kwi.getVideoDuration() >= 3000.0f) {
                this.kyN.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.kyN.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kyK) {
            if (this.kyR != null) {
                this.kyR.cPx();
            }
            int status = this.kwi.getStatus();
            if (this.kwi != null && this.kwi.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.kwi.cPb();
                    ey(this.kyU);
                    ey(this.kyV);
                    ey(this.kyW);
                    if (this.kwi.getVideoDuration() >= 3000.0f) {
                        DA(4);
                        return;
                    } else {
                        DA(this.kwi.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.kwi.cPa();
                DA(5);
            }
        } else if (view == this.kyN) {
            TiebaStatic.log("c12300");
            if (this.kwi != null && this.kwi.getStatus() > 2 && this.kyR != null) {
                if (this.kwi.getVideoDuration() >= 3000.0f) {
                    this.kyR.cPv();
                } else {
                    this.kyR.cPw();
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
    public void cL(final boolean z) {
        if (this.kwi.getProgress() >= 100) {
            if (this.kyR != null) {
                this.kyR.cPv();
                return;
            }
            return;
        }
        if (this.kyY.getCurrentBeautyItem() != null) {
            this.kyU.add(this.kyY.getCurrentBeautyItem());
        }
        if (this.kyY.getCurrentFilterItem() != null) {
            this.kyV.add(this.kyY.getCurrentFilterItem());
        }
        if (this.kyY.getCurrentStickItem() != null) {
            this.kyW.add(this.kyY.getCurrentStickItem());
        }
        DA(2);
        if (this.kyY.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.kwi.getStatus() == 6 || VideoControllerLayout.this.kwi.isRecording()) {
                        VideoControllerLayout.this.tg(z);
                    }
                }
            });
        } else {
            tg(z);
        }
        if (this.kwi != null) {
            this.kwi.startRecord();
        }
        if (this.kyR != null) {
            this.kyR.cPq();
        }
    }

    public void stopRecord() {
        cPC();
        int status = this.kwi.getStatus();
        if (this.kwi != null) {
            if (!this.kwi.bby() && this.kwi.isRecording()) {
                this.kwi.stopRecord();
            }
            cPB();
        }
        if (this.kyR != null) {
            this.kyR.cPf();
            if (status == 6) {
                this.kyR.cPs();
            }
        }
    }

    public void cPB() {
        if (this.kwi != null) {
            if (this.kwi.getVideoDuration() >= 3000.0f) {
                DA(4);
            } else if (this.kwi.getVideoDuration() > 0) {
                DA(3);
            } else {
                DA(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg(boolean z) {
        if (this.kya != null && this.kya.isRunning()) {
            this.kya.cancel();
        }
        if (this.kxZ == null) {
            this.kxZ = new AnimatorSet();
            this.kxZ.playTogether(ObjectAnimator.ofFloat(this.kyK, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kyN, "alpha", 1.0f, 0.0f));
            this.kxZ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kzL) {
                        VideoControllerLayout.this.kyK.setVisibility(8);
                        VideoControllerLayout.this.kyN.setVisibility(8);
                    }
                }
            });
            this.kxZ.setDuration(300L);
        }
        this.kxZ.start();
        if (this.kwi.getStatus() != 6) {
            this.kyM.tg(z);
        }
    }

    public void cPC() {
        if (this.kwi == null || this.kwi.isRecording() || this.kwi.getStatus() == 6) {
            if (this.kxZ != null && this.kxZ.isRunning()) {
                this.kxZ.cancel();
            }
            if (this.kya == null) {
                this.kya = new AnimatorSet();
                this.kya.playTogether(ObjectAnimator.ofFloat(this.kyK, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kyN, "alpha", 0.0f, 1.0f));
                this.kya.setDuration(300L);
            }
            this.kyK.setVisibility(0);
            this.kyN.setVisibility(0);
            this.kya.start();
            if (this.kwi.getStatus() != 7 && this.kwi.getStatus() != 6) {
                this.kyM.cPC();
                return;
            }
            this.kyM.getTvTip().setVisibility(8);
            if (this.mCurrentTab == 2) {
                this.kyM.getLayer1().setVisibility(0);
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
                if (this.kyR != null) {
                    this.kyR.cPx();
                }
                if (this.kwi.getStatus() != 7 && this.kwi.getStatus() != 6) {
                    if (this.kwi != null && this.kwi.cOZ()) {
                        this.kyT = true;
                        com.baidu.tbadk.core.util.e.aDg().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.kyO = currentTimeMillis;
                    this.kyP = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.kyP && VideoControllerLayout.this.kyO == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.cL(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.kyT) {
                    this.kyT = false;
                    return;
                }
                this.kyP = false;
                if (this.kwi.isRecording() || this.kwi.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.kwi.getStatus() != 8) {
                    cL(false);
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
                if (this.kwi.getStatus() == 6) {
                    this.kwi.setStatus(1);
                    if (this.kyR != null) {
                        this.kyR.cPs();
                        this.kyR.cPf();
                    }
                    this.kyM.getTvTip().setText("");
                    this.kyM.getTvTip().setVisibility(8);
                    return;
                } else if (this.kyY.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.kyR != null) {
                    this.kyR.cPr();
                    this.kyM.cPN();
                    return;
                } else {
                    return;
                }
            case 1:
                this.kyM.cPO();
                return;
            default:
                return;
        }
    }

    public void cPl() {
        if (this.kyY.getVisibility() == 0) {
            a((m) null);
        }
        tg(false);
        this.kyM.getLayer1().setVisibility(8);
        this.kyM.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.kyM.getTvTip().setVisibility(0);
        if (this.kyR != null) {
            this.kyR.cPq();
        }
    }

    public void cPD() {
        if (this.kwi.getStatus() == 6) {
            if (this.mCurrentTab == 2) {
                DA(7);
                this.kyM.setAlpha(1.0f);
                this.kyK.setVisibility(8);
                this.kyN.setVisibility(8);
                this.kyM.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.kwi != null) {
                    this.kwi.startRecord();
                    return;
                }
                return;
            }
            this.kyM.getTvTip().setVisibility(8);
            if (this.kyR != null) {
                this.kyR.cPr();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPm() {
        if (cPG() && this.kyY.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cPG()) {
            cPF();
        }
        this.kyY.cPm();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPn() {
        if (cPG() && this.kyY.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cPG()) {
            cPF();
        }
        this.kyY.cPn();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPo() {
        if (cPG() && this.kyY.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cPG()) {
            cPF();
        }
        this.kyY.cPo();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPp() {
        if (cPG() && this.kyY.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cPG()) {
            cPF();
        }
        this.kyY.cPp();
    }

    private void cPE() {
        if (v.isEmpty(this.kyQ)) {
            this.kyQ = new ArrayList();
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyY, "translationY", 1000.0f, 0.0f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyL, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyM.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyM.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyM.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyM.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyN, "scaleX", 1.0f, 0.7f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyN, "scaleY", 1.0f, 0.7f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyK, "scaleX", 1.0f, 0.7f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyK, "scaleY", 1.0f, 0.7f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyN, "alpha", 1.0f, 0.0f));
            this.kyQ.add(ObjectAnimator.ofFloat(this.kyK, "alpha", 1.0f, 0.0f));
        }
    }

    private void cPF() {
        int i = 0;
        if (this.kyY.getVisibility() != 0) {
            this.kyY.setVisibility(0);
            cPE();
            this.kyN.setEnabled(false);
            this.kyK.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.kyQ.size()) {
                    ObjectAnimator objectAnimator = this.kyQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kyQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.kyR != null) {
                                        VideoControllerLayout.this.kyR.cPt();
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
        if (this.kyY.getVisibility() != 8) {
            cPE();
            this.kyN.setEnabled(true);
            this.kyK.setEnabled(true);
            if (this.kwi.getStatus() == 6 || this.kwi.isRecording()) {
                this.kyK.setVisibility(8);
                this.kyN.setVisibility(8);
            } else {
                DA(this.kwi.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kyQ.size()) {
                    ObjectAnimator objectAnimator = this.kyQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.kyQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.kzL) {
                                        VideoControllerLayout.this.kyY.setVisibility(8);
                                        if (VideoControllerLayout.this.kyR != null) {
                                            VideoControllerLayout.this.kyR.cPu();
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
        this.kyR = aVar;
    }

    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        switch (this.mCurrentTab) {
            case 1:
                this.kyK.setVisibility(4);
                this.kyN.setVisibility(4);
                this.kyM.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.kwi.getStatus() != 1) {
                    this.kyK.setVisibility(0);
                    this.kyN.setVisibility(0);
                }
                this.kyM.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cPG() {
        return this.kyY.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.kyY != null) {
            this.kyY.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.kyY != null) {
            this.kyY.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.kyY != null) {
            this.kyY.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cPH() {
        if (this.kyY != null) {
            return this.kyY.cPH();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.kyS = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.kyU;
    }

    public List<e> getChoosedFilterList() {
        return this.kyV;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.kyW;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.kyX.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.kyY != null) {
            this.kyY.setMusicList(this.kyX);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void cPI() {
        if (this.kyY != null) {
            this.kyY.cPI();
        }
    }

    public void cOz() {
        if (this.kyY != null) {
            this.kyY.cOz();
        }
    }
}
