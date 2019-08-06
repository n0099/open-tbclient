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
    private int fLJ;
    private i jAW;
    private AnimatorSet jCU;
    private AnimatorSet jCV;
    private ImageView jDG;
    private RelativeLayout jDH;
    private VideoRecordButton jDI;
    private ImageView jDJ;
    private long jDK;
    private boolean jDL;
    private List<ObjectAnimator> jDM;
    private a jDN;
    private boolean jDO;
    private boolean jDP;
    private List<e> jDQ;
    private List<e> jDR;
    private List<StickerItem> jDS;
    private List<e> jDT;
    private VideoEffectLayout jDU;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void cwM();

        void cwX();

        void cwY();

        void cwZ();

        void cxa();

        void cxb();

        void cxc();

        void cxd();

        void cxe();

        void cxf();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jDK = 0L;
        this.jDL = false;
        this.jDO = true;
        this.jDQ = new ArrayList();
        this.jDR = new ArrayList();
        this.jDS = new ArrayList();
        this.jDT = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDK = 0L;
        this.jDL = false;
        this.jDO = true;
        this.jDQ = new ArrayList();
        this.jDR = new ArrayList();
        this.jDS = new ArrayList();
        this.jDT = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDK = 0L;
        this.jDL = false;
        this.jDO = true;
        this.jDQ = new ArrayList();
        this.jDR = new ArrayList();
        this.jDS = new ArrayList();
        this.jDT = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jDU = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jDH = (RelativeLayout) findViewById(R.id.layout_record);
        this.jDG = (ImageView) findViewById(R.id.delete_video);
        this.jDG.setOnClickListener(this);
        this.jDI = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jDI.setOnTouchListener(this);
        this.jDJ = (ImageView) findViewById(R.id.confirm_video);
        this.jDJ.setOnClickListener(this);
        this.jDT.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jDT.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jAW = iVar;
        Cw(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jDU != null) {
            this.jDU.setListener(aVar);
        }
    }

    public void Cw(int i) {
        this.jAW.setStatus(i);
        if (this.jDN != null) {
            this.jDN.cxf();
        }
        if (i == 1) {
            this.jDG.setVisibility(8);
            this.jDJ.setVisibility(8);
        } else if (i == 3) {
            this.jDG.setImageResource(R.drawable.video_back_selector);
            this.jDJ.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jDG.setImageResource(R.drawable.video_back_selector);
            this.jDJ.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jDG.setImageResource(R.drawable.video_delete_selector);
            if (this.jAW != null && this.jAW.getVideoDuration() >= 3000.0f) {
                this.jDJ.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jDJ.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jDG) {
            if (this.jDN != null) {
                this.jDN.cxe();
            }
            int status = this.jAW.getStatus();
            if (this.jAW != null && this.jAW.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jAW.cwF();
                    et(this.jDQ);
                    et(this.jDR);
                    et(this.jDS);
                    if (this.jAW.getVideoDuration() >= 3000.0f) {
                        Cw(4);
                        return;
                    } else {
                        Cw(this.jAW.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jAW.cwE();
                Cw(5);
            }
        } else if (view == this.jDJ) {
            TiebaStatic.log("c12300");
            if (this.jAW != null && this.jAW.getStatus() > 2 && this.jDN != null) {
                if (this.jAW.getVideoDuration() >= 3000.0f) {
                    this.jDN.cxc();
                } else {
                    this.jDN.cxd();
                }
            }
        }
    }

    private void et(List list) {
        if (!v.aa(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(final boolean z) {
        if (this.jAW.getProgress() >= 100) {
            if (this.jDN != null) {
                this.jDN.cxc();
                return;
            }
            return;
        }
        if (this.jDU.getCurrentBeautyItem() != null) {
            this.jDQ.add(this.jDU.getCurrentBeautyItem());
        }
        if (this.jDU.getCurrentFilterItem() != null) {
            this.jDR.add(this.jDU.getCurrentFilterItem());
        }
        if (this.jDU.getCurrentStickItem() != null) {
            this.jDS.add(this.jDU.getCurrentStickItem());
        }
        Cw(2);
        if (this.jDU.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jAW.getStatus() == 6 || VideoControllerLayout.this.jAW.alC()) {
                        VideoControllerLayout.this.rO(z);
                    }
                }
            });
        } else {
            rO(z);
        }
        if (this.jAW != null) {
            this.jAW.startRecord();
        }
        if (this.jDN != null) {
            this.jDN.cwX();
        }
    }

    public void stopRecord() {
        cxj();
        int status = this.jAW.getStatus();
        if (this.jAW != null) {
            if (!this.jAW.cwG() && this.jAW.alC()) {
                this.jAW.stopRecord();
            }
            cxi();
        }
        if (this.jDN != null) {
            this.jDN.cwM();
            if (status == 6) {
                this.jDN.cwZ();
            }
        }
    }

    public void cxi() {
        if (this.jAW != null) {
            if (this.jAW.getVideoDuration() >= 3000.0f) {
                Cw(4);
            } else if (this.jAW.getVideoDuration() > 0) {
                Cw(3);
            } else {
                Cw(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        if (this.jCV != null && this.jCV.isRunning()) {
            this.jCV.cancel();
        }
        if (this.jCU == null) {
            this.jCU = new AnimatorSet();
            this.jCU.playTogether(ObjectAnimator.ofFloat(this.jDG, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jDJ, "alpha", 1.0f, 0.0f));
            this.jCU.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jEH) {
                        VideoControllerLayout.this.jDG.setVisibility(8);
                        VideoControllerLayout.this.jDJ.setVisibility(8);
                    }
                }
            });
            this.jCU.setDuration(300L);
        }
        this.jCU.start();
        if (this.jAW.getStatus() != 6) {
            this.jDI.rO(z);
        }
    }

    public void cxj() {
        if (this.jAW == null || this.jAW.alC() || this.jAW.getStatus() == 6) {
            if (this.jCU != null && this.jCU.isRunning()) {
                this.jCU.cancel();
            }
            if (this.jCV == null) {
                this.jCV = new AnimatorSet();
                this.jCV.playTogether(ObjectAnimator.ofFloat(this.jDG, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jDJ, "alpha", 0.0f, 1.0f));
                this.jCV.setDuration(300L);
            }
            this.jDG.setVisibility(0);
            this.jDJ.setVisibility(0);
            this.jCV.start();
            if (this.jAW.getStatus() != 7 && this.jAW.getStatus() != 6) {
                this.jDI.cxj();
                return;
            }
            this.jDI.getTvTip().setVisibility(8);
            if (this.fLJ == 2) {
                this.jDI.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fLJ) {
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
                if (this.jDN != null) {
                    this.jDN.cxe();
                }
                if (this.jAW.getStatus() != 7 && this.jAW.getStatus() != 6) {
                    if (this.jAW != null && this.jAW.cwD()) {
                        this.jDP = true;
                        com.baidu.tbadk.core.util.e.ahY().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jDK = currentTimeMillis;
                    this.jDL = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jDL && VideoControllerLayout.this.jDK == currentTimeMillis) {
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
                if (this.jDP) {
                    this.jDP = false;
                    return;
                }
                this.jDL = false;
                if (this.jAW.alC() || this.jAW.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jAW.getStatus() != 8) {
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
                if (this.jAW.getStatus() == 6) {
                    this.jAW.setStatus(1);
                    if (this.jDN != null) {
                        this.jDN.cwZ();
                        this.jDN.cwM();
                    }
                    this.jDI.getTvTip().setText("");
                    this.jDI.getTvTip().setVisibility(8);
                    return;
                } else if (this.jDU.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jDN != null) {
                    this.jDN.cwY();
                    this.jDI.cxu();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jDI.cxv();
                return;
            default:
                return;
        }
    }

    public void cwS() {
        if (this.jDU.getVisibility() == 0) {
            a((m) null);
        }
        rO(false);
        this.jDI.getLayer1().setVisibility(8);
        this.jDI.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jDI.getTvTip().setVisibility(0);
        if (this.jDN != null) {
            this.jDN.cwX();
        }
    }

    public void cxk() {
        if (this.jAW.getStatus() == 6) {
            if (this.fLJ == 2) {
                Cw(7);
                this.jDI.setAlpha(1.0f);
                this.jDG.setVisibility(8);
                this.jDJ.setVisibility(8);
                this.jDI.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jAW != null) {
                    this.jAW.startRecord();
                    return;
                }
                return;
            }
            this.jDI.getTvTip().setVisibility(8);
            if (this.jDN != null) {
                this.jDN.cwY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwT() {
        if (cxn() && this.jDU.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cxn()) {
            cxm();
        }
        this.jDU.cwT();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwU() {
        if (cxn() && this.jDU.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cxn()) {
            cxm();
        }
        this.jDU.cwU();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwV() {
        if (cxn() && this.jDU.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cxn()) {
            cxm();
        }
        this.jDU.cwV();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwW() {
        if (cxn() && this.jDU.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cxn()) {
            cxm();
        }
        this.jDU.cwW();
    }

    private void cxl() {
        if (v.aa(this.jDM)) {
            this.jDM = new ArrayList();
            this.jDM.add(ObjectAnimator.ofFloat(this.jDU, "translationY", 1000.0f, 0.0f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDH, "translationY", 0.0f, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds100)));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDI.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDI.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDI.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDI.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDJ, "scaleX", 1.0f, 0.7f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDJ, "scaleY", 1.0f, 0.7f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDG, "scaleX", 1.0f, 0.7f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDG, "scaleY", 1.0f, 0.7f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDJ, "alpha", 1.0f, 0.0f));
            this.jDM.add(ObjectAnimator.ofFloat(this.jDG, "alpha", 1.0f, 0.0f));
        }
    }

    private void cxm() {
        int i = 0;
        if (this.jDU.getVisibility() != 0) {
            this.jDU.setVisibility(0);
            cxl();
            this.jDJ.setEnabled(false);
            this.jDG.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jDM.size()) {
                    ObjectAnimator objectAnimator = this.jDM.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jDM.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jDN != null) {
                                        VideoControllerLayout.this.jDN.cxa();
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
        if (this.jDU.getVisibility() != 8) {
            cxl();
            this.jDJ.setEnabled(true);
            this.jDG.setEnabled(true);
            if (this.jAW.getStatus() == 6 || this.jAW.alC()) {
                this.jDG.setVisibility(8);
                this.jDJ.setVisibility(8);
            } else {
                Cw(this.jAW.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jDM.size()) {
                    ObjectAnimator objectAnimator = this.jDM.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jDM.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jEH) {
                                        VideoControllerLayout.this.jDU.setVisibility(8);
                                        if (VideoControllerLayout.this.jDN != null) {
                                            VideoControllerLayout.this.jDN.cxb();
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
        this.jDN = aVar;
    }

    public void setCurrentTab(int i) {
        this.fLJ = i;
        switch (this.fLJ) {
            case 1:
                this.jDG.setVisibility(4);
                this.jDJ.setVisibility(4);
                this.jDI.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jAW.getStatus() != 1) {
                    this.jDG.setVisibility(0);
                    this.jDJ.setVisibility(0);
                }
                this.jDI.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cxn() {
        return this.jDU.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jDU != null) {
            this.jDU.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jDU != null) {
            this.jDU.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jDU != null) {
            this.jDU.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cxo() {
        if (this.jDU != null) {
            return this.jDU.cxo();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jDO = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jDQ;
    }

    public List<e> getChoosedFilterList() {
        return this.jDR;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jDS;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jDT.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jDU != null) {
            this.jDU.setMusicList(this.jDT);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void cxp() {
        if (this.jDU != null) {
            this.jDU.cxp();
        }
    }

    public void cwd() {
        if (this.jDU != null) {
            this.jDU.cwd();
        }
    }
}
