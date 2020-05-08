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
    private int hqi;
    private i lne;
    private ImageView lpN;
    private RelativeLayout lpO;
    private VideoRecordButton lpP;
    private ImageView lpQ;
    private long lpR;
    private boolean lpS;
    private List<ObjectAnimator> lpT;
    private a lpU;
    private boolean lpV;
    private boolean lpW;
    private List<e> lpX;
    private List<e> lpY;
    private List<StickerItem> lpZ;
    private AnimatorSet lpc;
    private AnimatorSet lpd;
    private List<e> lqa;
    private VideoEffectLayout lqb;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void dcY();

        void ddj();

        void ddk();

        void ddl();

        void ddm();

        void ddn();

        void ddo();

        void ddp();

        void ddq();

        void ddr();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.lpR = 0L;
        this.lpS = false;
        this.lpV = true;
        this.lpX = new ArrayList();
        this.lpY = new ArrayList();
        this.lpZ = new ArrayList();
        this.lqa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lpR = 0L;
        this.lpS = false;
        this.lpV = true;
        this.lpX = new ArrayList();
        this.lpY = new ArrayList();
        this.lpZ = new ArrayList();
        this.lqa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lpR = 0L;
        this.lpS = false;
        this.lpV = true;
        this.lpX = new ArrayList();
        this.lpY = new ArrayList();
        this.lpZ = new ArrayList();
        this.lqa = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.lqb = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.lpO = (RelativeLayout) findViewById(R.id.layout_record);
        this.lpN = (ImageView) findViewById(R.id.delete_video);
        this.lpN.setOnClickListener(this);
        this.lpP = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.lpP.setOnTouchListener(this);
        this.lpQ = (ImageView) findViewById(R.id.confirm_video);
        this.lpQ.setOnClickListener(this);
        this.lqa.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.lqa.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.lne = iVar;
        Ey(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.lqb != null) {
            this.lqb.setListener(aVar);
        }
    }

    public void Ey(int i) {
        this.lne.setStatus(i);
        if (this.lpU != null) {
            this.lpU.ddr();
        }
        if (i == 1) {
            this.lpN.setVisibility(8);
            this.lpQ.setVisibility(8);
        } else if (i == 3) {
            this.lpN.setImageResource(R.drawable.video_back_selector);
            this.lpQ.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.lpN.setImageResource(R.drawable.video_back_selector);
            this.lpQ.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.lpN.setImageResource(R.drawable.video_delete_selector);
            if (this.lne != null && this.lne.getVideoDuration() >= 3000.0f) {
                this.lpQ.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.lpQ.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lpN) {
            if (this.lpU != null) {
                this.lpU.ddq();
            }
            int status = this.lne.getStatus();
            if (this.lne != null && this.lne.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.lne.dcT();
                    eI(this.lpX);
                    eI(this.lpY);
                    eI(this.lpZ);
                    if (this.lne.getVideoDuration() >= 3000.0f) {
                        Ey(4);
                        return;
                    } else {
                        Ey(this.lne.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.lne.dcS();
                Ey(5);
            }
        } else if (view == this.lpQ) {
            TiebaStatic.log("c12300");
            if (this.lne != null && this.lne.getStatus() > 2 && this.lpU != null) {
                if (this.lne.getVideoDuration() >= 3000.0f) {
                    this.lpU.ddo();
                } else {
                    this.lpU.ddp();
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
        if (this.lne.getProgress() >= 100) {
            if (this.lpU != null) {
                this.lpU.ddo();
                return;
            }
            return;
        }
        if (this.lqb.getCurrentBeautyItem() != null) {
            this.lpX.add(this.lqb.getCurrentBeautyItem());
        }
        if (this.lqb.getCurrentFilterItem() != null) {
            this.lpY.add(this.lqb.getCurrentFilterItem());
        }
        if (this.lqb.getCurrentStickItem() != null) {
            this.lpZ.add(this.lqb.getCurrentStickItem());
        }
        Ey(2);
        if (this.lqb.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.lne.getStatus() == 6 || VideoControllerLayout.this.lne.aRl()) {
                        VideoControllerLayout.this.uE(z);
                    }
                }
            });
        } else {
            uE(z);
        }
        if (this.lne != null) {
            this.lne.startRecord();
        }
        if (this.lpU != null) {
            this.lpU.ddj();
        }
    }

    public void stopRecord() {
        ddv();
        int status = this.lne.getStatus();
        if (this.lne != null) {
            if (!this.lne.bnE() && this.lne.aRl()) {
                this.lne.stopRecord();
            }
            ddu();
        }
        if (this.lpU != null) {
            this.lpU.dcY();
            if (status == 6) {
                this.lpU.ddl();
            }
        }
    }

    public void ddu() {
        if (this.lne != null) {
            if (this.lne.getVideoDuration() >= 3000.0f) {
                Ey(4);
            } else if (this.lne.getVideoDuration() > 0) {
                Ey(3);
            } else {
                Ey(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(boolean z) {
        if (this.lpd != null && this.lpd.isRunning()) {
            this.lpd.cancel();
        }
        if (this.lpc == null) {
            this.lpc = new AnimatorSet();
            this.lpc.playTogether(ObjectAnimator.ofFloat(this.lpN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lpQ, "alpha", 1.0f, 0.0f));
            this.lpc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqO) {
                        VideoControllerLayout.this.lpN.setVisibility(8);
                        VideoControllerLayout.this.lpQ.setVisibility(8);
                    }
                }
            });
            this.lpc.setDuration(300L);
        }
        this.lpc.start();
        if (this.lne.getStatus() != 6) {
            this.lpP.uE(z);
        }
    }

    public void ddv() {
        if (this.lne == null || this.lne.aRl() || this.lne.getStatus() == 6) {
            if (this.lpc != null && this.lpc.isRunning()) {
                this.lpc.cancel();
            }
            if (this.lpd == null) {
                this.lpd = new AnimatorSet();
                this.lpd.playTogether(ObjectAnimator.ofFloat(this.lpN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lpQ, "alpha", 0.0f, 1.0f));
                this.lpd.setDuration(300L);
            }
            this.lpN.setVisibility(0);
            this.lpQ.setVisibility(0);
            this.lpd.start();
            if (this.lne.getStatus() != 7 && this.lne.getStatus() != 6) {
                this.lpP.ddv();
                return;
            }
            this.lpP.getTvTip().setVisibility(8);
            if (this.hqi == 2) {
                this.lpP.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hqi) {
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
                if (this.lpU != null) {
                    this.lpU.ddq();
                }
                if (this.lne.getStatus() != 7 && this.lne.getStatus() != 6) {
                    if (this.lne != null && this.lne.dcR()) {
                        this.lpW = true;
                        com.baidu.tbadk.core.util.e.aOb().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.lpR = currentTimeMillis;
                    this.lpS = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.lpS && VideoControllerLayout.this.lpR == currentTimeMillis) {
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
                if (this.lpW) {
                    this.lpW = false;
                    return;
                }
                this.lpS = false;
                if (this.lne.aRl() || this.lne.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.lne.getStatus() != 8) {
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
                if (this.lne.getStatus() == 6) {
                    this.lne.setStatus(1);
                    if (this.lpU != null) {
                        this.lpU.ddl();
                        this.lpU.dcY();
                    }
                    this.lpP.getTvTip().setText("");
                    this.lpP.getTvTip().setVisibility(8);
                    return;
                } else if (this.lqb.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.lpU != null) {
                    this.lpU.ddk();
                    this.lpP.ddG();
                    return;
                } else {
                    return;
                }
            case 1:
                this.lpP.ddH();
                return;
            default:
                return;
        }
    }

    public void dde() {
        if (this.lqb.getVisibility() == 0) {
            a((m) null);
        }
        uE(false);
        this.lpP.getLayer1().setVisibility(8);
        this.lpP.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.lpP.getTvTip().setVisibility(0);
        if (this.lpU != null) {
            this.lpU.ddj();
        }
    }

    public void ddw() {
        if (this.lne.getStatus() == 6) {
            if (this.hqi == 2) {
                Ey(7);
                this.lpP.setAlpha(1.0f);
                this.lpN.setVisibility(8);
                this.lpQ.setVisibility(8);
                this.lpP.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.lne != null) {
                    this.lne.startRecord();
                    return;
                }
                return;
            }
            this.lpP.getTvTip().setVisibility(8);
            if (this.lpU != null) {
                this.lpU.ddk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddf() {
        if (ddz() && this.lqb.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!ddz()) {
            ddy();
        }
        this.lqb.ddf();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddg() {
        if (ddz() && this.lqb.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!ddz()) {
            ddy();
        }
        this.lqb.ddg();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddh() {
        if (ddz() && this.lqb.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!ddz()) {
            ddy();
        }
        this.lqb.ddh();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        if (ddz() && this.lqb.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!ddz()) {
            ddy();
        }
        this.lqb.ddi();
    }

    private void ddx() {
        if (v.isEmpty(this.lpT)) {
            this.lpT = new ArrayList();
            this.lpT.add(ObjectAnimator.ofFloat(this.lqb, "translationY", 1000.0f, 0.0f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpO, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpP.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpP.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpP.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpP.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpQ, "scaleX", 1.0f, 0.7f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpQ, "scaleY", 1.0f, 0.7f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpN, "scaleX", 1.0f, 0.7f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpN, "scaleY", 1.0f, 0.7f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpQ, "alpha", 1.0f, 0.0f));
            this.lpT.add(ObjectAnimator.ofFloat(this.lpN, "alpha", 1.0f, 0.0f));
        }
    }

    private void ddy() {
        int i = 0;
        if (this.lqb.getVisibility() != 0) {
            this.lqb.setVisibility(0);
            ddx();
            this.lpQ.setEnabled(false);
            this.lpN.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.lpT.size()) {
                    ObjectAnimator objectAnimator = this.lpT.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lpT.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.lpU != null) {
                                        VideoControllerLayout.this.lpU.ddm();
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
        if (this.lqb.getVisibility() != 8) {
            ddx();
            this.lpQ.setEnabled(true);
            this.lpN.setEnabled(true);
            if (this.lne.getStatus() == 6 || this.lne.aRl()) {
                this.lpN.setVisibility(8);
                this.lpQ.setVisibility(8);
            } else {
                Ey(this.lne.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lpT.size()) {
                    ObjectAnimator objectAnimator = this.lpT.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lpT.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.lqO) {
                                        VideoControllerLayout.this.lqb.setVisibility(8);
                                        if (VideoControllerLayout.this.lpU != null) {
                                            VideoControllerLayout.this.lpU.ddn();
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
        this.lpU = aVar;
    }

    public void setCurrentTab(int i) {
        this.hqi = i;
        switch (this.hqi) {
            case 1:
                this.lpN.setVisibility(4);
                this.lpQ.setVisibility(4);
                this.lpP.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.lne.getStatus() != 1) {
                    this.lpN.setVisibility(0);
                    this.lpQ.setVisibility(0);
                }
                this.lpP.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean ddz() {
        return this.lqb.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.lqb != null) {
            this.lqb.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.lqb != null) {
            this.lqb.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.lqb != null) {
            this.lqb.setDownLoadStrick(stickerItem);
        }
    }

    public boolean ddA() {
        if (this.lqb != null) {
            return this.lqb.ddA();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.lpV = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.lpX;
    }

    public List<e> getChoosedFilterList() {
        return this.lpY;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.lpZ;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.lqa.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.lqb != null) {
            this.lqb.setMusicList(this.lqa);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void ddB() {
        if (this.lqb != null) {
            this.lqb.ddB();
        }
    }

    public void dcp() {
        if (this.lqb != null) {
            this.lqb.dcp();
        }
    }
}
