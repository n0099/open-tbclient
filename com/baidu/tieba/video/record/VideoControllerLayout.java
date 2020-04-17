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
    private int hqc;
    private i lna;
    private AnimatorSet loY;
    private AnimatorSet loZ;
    private ImageView lpJ;
    private RelativeLayout lpK;
    private VideoRecordButton lpL;
    private ImageView lpM;
    private long lpN;
    private boolean lpO;
    private List<ObjectAnimator> lpP;
    private a lpQ;
    private boolean lpR;
    private boolean lpS;
    private List<e> lpT;
    private List<e> lpU;
    private List<StickerItem> lpV;
    private List<e> lpW;
    private VideoEffectLayout lpX;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void ddb();

        void ddm();

        void ddn();

        void ddo();

        void ddp();

        void ddq();

        void ddr();

        void dds();

        void ddt();

        void ddu();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.lpN = 0L;
        this.lpO = false;
        this.lpR = true;
        this.lpT = new ArrayList();
        this.lpU = new ArrayList();
        this.lpV = new ArrayList();
        this.lpW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lpN = 0L;
        this.lpO = false;
        this.lpR = true;
        this.lpT = new ArrayList();
        this.lpU = new ArrayList();
        this.lpV = new ArrayList();
        this.lpW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lpN = 0L;
        this.lpO = false;
        this.lpR = true;
        this.lpT = new ArrayList();
        this.lpU = new ArrayList();
        this.lpV = new ArrayList();
        this.lpW = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.lpX = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.lpK = (RelativeLayout) findViewById(R.id.layout_record);
        this.lpJ = (ImageView) findViewById(R.id.delete_video);
        this.lpJ.setOnClickListener(this);
        this.lpL = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.lpL.setOnTouchListener(this);
        this.lpM = (ImageView) findViewById(R.id.confirm_video);
        this.lpM.setOnClickListener(this);
        this.lpW.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.lpW.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.lna = iVar;
        Ey(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.lpX != null) {
            this.lpX.setListener(aVar);
        }
    }

    public void Ey(int i) {
        this.lna.setStatus(i);
        if (this.lpQ != null) {
            this.lpQ.ddu();
        }
        if (i == 1) {
            this.lpJ.setVisibility(8);
            this.lpM.setVisibility(8);
        } else if (i == 3) {
            this.lpJ.setImageResource(R.drawable.video_back_selector);
            this.lpM.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.lpJ.setImageResource(R.drawable.video_back_selector);
            this.lpM.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.lpJ.setImageResource(R.drawable.video_delete_selector);
            if (this.lna != null && this.lna.getVideoDuration() >= 3000.0f) {
                this.lpM.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.lpM.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lpJ) {
            if (this.lpQ != null) {
                this.lpQ.ddt();
            }
            int status = this.lna.getStatus();
            if (this.lna != null && this.lna.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.lna.dcW();
                    eI(this.lpT);
                    eI(this.lpU);
                    eI(this.lpV);
                    if (this.lna.getVideoDuration() >= 3000.0f) {
                        Ey(4);
                        return;
                    } else {
                        Ey(this.lna.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.lna.dcV();
                Ey(5);
            }
        } else if (view == this.lpM) {
            TiebaStatic.log("c12300");
            if (this.lna != null && this.lna.getStatus() > 2 && this.lpQ != null) {
                if (this.lna.getVideoDuration() >= 3000.0f) {
                    this.lpQ.ddr();
                } else {
                    this.lpQ.dds();
                }
            }
        }
    }

    private void eI(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(final boolean z) {
        if (this.lna.getProgress() >= 100) {
            if (this.lpQ != null) {
                this.lpQ.ddr();
                return;
            }
            return;
        }
        if (this.lpX.getCurrentBeautyItem() != null) {
            this.lpT.add(this.lpX.getCurrentBeautyItem());
        }
        if (this.lpX.getCurrentFilterItem() != null) {
            this.lpU.add(this.lpX.getCurrentFilterItem());
        }
        if (this.lpX.getCurrentStickItem() != null) {
            this.lpV.add(this.lpX.getCurrentStickItem());
        }
        Ey(2);
        if (this.lpX.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.lna.getStatus() == 6 || VideoControllerLayout.this.lna.aRo()) {
                        VideoControllerLayout.this.uE(z);
                    }
                }
            });
        } else {
            uE(z);
        }
        if (this.lna != null) {
            this.lna.startRecord();
        }
        if (this.lpQ != null) {
            this.lpQ.ddm();
        }
    }

    public void stopRecord() {
        ddy();
        int status = this.lna.getStatus();
        if (this.lna != null) {
            if (!this.lna.bnG() && this.lna.aRo()) {
                this.lna.stopRecord();
            }
            ddx();
        }
        if (this.lpQ != null) {
            this.lpQ.ddb();
            if (status == 6) {
                this.lpQ.ddo();
            }
        }
    }

    public void ddx() {
        if (this.lna != null) {
            if (this.lna.getVideoDuration() >= 3000.0f) {
                Ey(4);
            } else if (this.lna.getVideoDuration() > 0) {
                Ey(3);
            } else {
                Ey(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(boolean z) {
        if (this.loZ != null && this.loZ.isRunning()) {
            this.loZ.cancel();
        }
        if (this.loY == null) {
            this.loY = new AnimatorSet();
            this.loY.playTogether(ObjectAnimator.ofFloat(this.lpJ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lpM, "alpha", 1.0f, 0.0f));
            this.loY.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqK) {
                        VideoControllerLayout.this.lpJ.setVisibility(8);
                        VideoControllerLayout.this.lpM.setVisibility(8);
                    }
                }
            });
            this.loY.setDuration(300L);
        }
        this.loY.start();
        if (this.lna.getStatus() != 6) {
            this.lpL.uE(z);
        }
    }

    public void ddy() {
        if (this.lna == null || this.lna.aRo() || this.lna.getStatus() == 6) {
            if (this.loY != null && this.loY.isRunning()) {
                this.loY.cancel();
            }
            if (this.loZ == null) {
                this.loZ = new AnimatorSet();
                this.loZ.playTogether(ObjectAnimator.ofFloat(this.lpJ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lpM, "alpha", 0.0f, 1.0f));
                this.loZ.setDuration(300L);
            }
            this.lpJ.setVisibility(0);
            this.lpM.setVisibility(0);
            this.loZ.start();
            if (this.lna.getStatus() != 7 && this.lna.getStatus() != 6) {
                this.lpL.ddy();
                return;
            }
            this.lpL.getTvTip().setVisibility(8);
            if (this.hqc == 2) {
                this.lpL.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hqc) {
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
                if (this.lpQ != null) {
                    this.lpQ.ddt();
                }
                if (this.lna.getStatus() != 7 && this.lna.getStatus() != 6) {
                    if (this.lna != null && this.lna.dcU()) {
                        this.lpS = true;
                        com.baidu.tbadk.core.util.e.aOd().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.lpN = currentTimeMillis;
                    this.lpO = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.lpO && VideoControllerLayout.this.lpN == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.dU(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.lpS) {
                    this.lpS = false;
                    return;
                }
                this.lpO = false;
                if (this.lna.aRo() || this.lna.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.lna.getStatus() != 8) {
                    dU(false);
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
                if (this.lna.getStatus() == 6) {
                    this.lna.setStatus(1);
                    if (this.lpQ != null) {
                        this.lpQ.ddo();
                        this.lpQ.ddb();
                    }
                    this.lpL.getTvTip().setText("");
                    this.lpL.getTvTip().setVisibility(8);
                    return;
                } else if (this.lpX.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.lpQ != null) {
                    this.lpQ.ddn();
                    this.lpL.ddJ();
                    return;
                } else {
                    return;
                }
            case 1:
                this.lpL.ddK();
                return;
            default:
                return;
        }
    }

    public void ddh() {
        if (this.lpX.getVisibility() == 0) {
            a((m) null);
        }
        uE(false);
        this.lpL.getLayer1().setVisibility(8);
        this.lpL.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.lpL.getTvTip().setVisibility(0);
        if (this.lpQ != null) {
            this.lpQ.ddm();
        }
    }

    public void ddz() {
        if (this.lna.getStatus() == 6) {
            if (this.hqc == 2) {
                Ey(7);
                this.lpL.setAlpha(1.0f);
                this.lpJ.setVisibility(8);
                this.lpM.setVisibility(8);
                this.lpL.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.lna != null) {
                    this.lna.startRecord();
                    return;
                }
                return;
            }
            this.lpL.getTvTip().setVisibility(8);
            if (this.lpQ != null) {
                this.lpQ.ddn();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        if (ddC() && this.lpX.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!ddC()) {
            ddB();
        }
        this.lpX.ddi();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddj() {
        if (ddC() && this.lpX.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!ddC()) {
            ddB();
        }
        this.lpX.ddj();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddk() {
        if (ddC() && this.lpX.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!ddC()) {
            ddB();
        }
        this.lpX.ddk();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddl() {
        if (ddC() && this.lpX.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!ddC()) {
            ddB();
        }
        this.lpX.ddl();
    }

    private void ddA() {
        if (v.isEmpty(this.lpP)) {
            this.lpP = new ArrayList();
            this.lpP.add(ObjectAnimator.ofFloat(this.lpX, "translationY", 1000.0f, 0.0f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpK, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpL.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpL.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpL.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpL.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpM, "scaleX", 1.0f, 0.7f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpM, "scaleY", 1.0f, 0.7f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpJ, "scaleX", 1.0f, 0.7f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpJ, "scaleY", 1.0f, 0.7f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpM, "alpha", 1.0f, 0.0f));
            this.lpP.add(ObjectAnimator.ofFloat(this.lpJ, "alpha", 1.0f, 0.0f));
        }
    }

    private void ddB() {
        int i = 0;
        if (this.lpX.getVisibility() != 0) {
            this.lpX.setVisibility(0);
            ddA();
            this.lpM.setEnabled(false);
            this.lpJ.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.lpP.size()) {
                    ObjectAnimator objectAnimator = this.lpP.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lpP.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.lpQ != null) {
                                        VideoControllerLayout.this.lpQ.ddp();
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
        if (this.lpX.getVisibility() != 8) {
            ddA();
            this.lpM.setEnabled(true);
            this.lpJ.setEnabled(true);
            if (this.lna.getStatus() == 6 || this.lna.aRo()) {
                this.lpJ.setVisibility(8);
                this.lpM.setVisibility(8);
            } else {
                Ey(this.lna.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lpP.size()) {
                    ObjectAnimator objectAnimator = this.lpP.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lpP.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.lqK) {
                                        VideoControllerLayout.this.lpX.setVisibility(8);
                                        if (VideoControllerLayout.this.lpQ != null) {
                                            VideoControllerLayout.this.lpQ.ddq();
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
        this.lpQ = aVar;
    }

    public void setCurrentTab(int i) {
        this.hqc = i;
        switch (this.hqc) {
            case 1:
                this.lpJ.setVisibility(4);
                this.lpM.setVisibility(4);
                this.lpL.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.lna.getStatus() != 1) {
                    this.lpJ.setVisibility(0);
                    this.lpM.setVisibility(0);
                }
                this.lpL.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean ddC() {
        return this.lpX.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.lpX != null) {
            this.lpX.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.lpX != null) {
            this.lpX.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.lpX != null) {
            this.lpX.setDownLoadStrick(stickerItem);
        }
    }

    public boolean ddD() {
        if (this.lpX != null) {
            return this.lpX.ddD();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.lpR = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.lpT;
    }

    public List<e> getChoosedFilterList() {
        return this.lpU;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.lpV;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.lpW.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.lpX != null) {
            this.lpX.setMusicList(this.lpW);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void ddE() {
        if (this.lpX != null) {
            this.lpX.ddE();
        }
    }

    public void dcs() {
        if (this.lpX != null) {
            this.lpX.dcs();
        }
    }
}
