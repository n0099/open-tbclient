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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dCq;
    private i hif;
    private ImageView hkP;
    private RelativeLayout hkQ;
    private VideoRecordButton hkR;
    private ImageView hkS;
    private long hkT;
    private boolean hkU;
    private List<ObjectAnimator> hkV;
    private a hkW;
    private boolean hkX;
    private boolean hkY;
    private List<e> hkZ;
    private AnimatorSet hkd;
    private AnimatorSet hke;
    private List<e> hla;
    private List<StickerItem> hlb;
    private List<e> hlc;
    private VideoEffectLayout hld;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bCU();

        void bDf();

        void bDg();

        void bDh();

        void bDi();

        void bDj();

        void bDk();

        void bDl();

        void bDm();

        void bDn();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hkT = 0L;
        this.hkU = false;
        this.hkX = true;
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.hlc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkT = 0L;
        this.hkU = false;
        this.hkX = true;
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.hlc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkT = 0L;
        this.hkU = false;
        this.hkX = true;
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.hlc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(f.h.record_controller_layout, this);
        this.hld = (VideoEffectLayout) findViewById(f.g.layout_effect);
        this.hkQ = (RelativeLayout) findViewById(f.g.layout_record);
        this.hkP = (ImageView) findViewById(f.g.delete_video);
        this.hkP.setOnClickListener(this);
        this.hkR = (VideoRecordButton) findViewById(f.g.layout_record_button);
        this.hkR.setOnTouchListener(this);
        this.hkS = (ImageView) findViewById(f.g.confirm_video);
        this.hkS.setOnClickListener(this);
        this.hlc.add(0, new e(3, getResources().getString(f.j.music_normal), new MusicData("-100", 1, getResources().getString(f.j.music_normal)), f.C0146f.icon_video_mute));
        this.hlc.add(1, new e(3, getResources().getString(f.j.music_cloud), new MusicData("-200", 2, getResources().getString(f.j.music_cloud)), f.C0146f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hif = iVar;
        uU(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hld != null) {
            this.hld.setListener(aVar);
        }
    }

    public void uU(int i) {
        this.hif.setStatus(i);
        if (this.hkW != null) {
            this.hkW.bDn();
        }
        if (i == 1) {
            this.hkP.setVisibility(8);
            this.hkS.setVisibility(8);
        } else if (i == 3) {
            this.hkP.setImageResource(f.C0146f.video_back_selector);
            this.hkS.setImageResource(f.C0146f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hkP.setImageResource(f.C0146f.video_back_selector);
            this.hkS.setImageResource(f.C0146f.video_confirm_selector);
        } else if (i == 5) {
            this.hkP.setImageResource(f.C0146f.video_delete_selector);
            if (this.hif != null && this.hif.getVideoDuration() >= 3000.0f) {
                this.hkS.setImageResource(f.C0146f.video_confirm_selector);
            } else {
                this.hkS.setImageResource(f.C0146f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hkP) {
            if (this.hkW != null) {
                this.hkW.bDm();
            }
            int status = this.hif.getStatus();
            if (this.hif != null && this.hif.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hif.bCN();
                    dL(this.hkZ);
                    dL(this.hla);
                    dL(this.hlb);
                    if (this.hif.getVideoDuration() >= 3000.0f) {
                        uU(4);
                        return;
                    } else {
                        uU(this.hif.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hif.bCM();
                uU(5);
            }
        } else if (view == this.hkS) {
            TiebaStatic.log("c12300");
            if (this.hif != null && this.hif.getStatus() > 2 && this.hkW != null) {
                if (this.hif.getVideoDuration() >= 3000.0f) {
                    this.hkW.bDk();
                } else {
                    this.hkW.bDl();
                }
            }
        }
    }

    private void dL(List list) {
        if (!w.z(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(final boolean z) {
        if (this.hif.getProgress() >= 100) {
            if (this.hkW != null) {
                this.hkW.bDk();
                return;
            }
            return;
        }
        if (this.hld.getCurrentBeautyItem() != null) {
            this.hkZ.add(this.hld.getCurrentBeautyItem());
        }
        if (this.hld.getCurrentFilterItem() != null) {
            this.hla.add(this.hld.getCurrentFilterItem());
        }
        if (this.hld.getCurrentStickItem() != null) {
            this.hlb.add(this.hld.getCurrentStickItem());
        }
        uU(2);
        if (this.hld.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hif.getStatus() == 6 || VideoControllerLayout.this.hif.isRecording()) {
                        VideoControllerLayout.this.nd(z);
                    }
                }
            });
        } else {
            nd(z);
        }
        if (this.hif != null) {
            this.hif.startRecord();
        }
        if (this.hkW != null) {
            this.hkW.bDf();
        }
    }

    public void stopRecord() {
        bDr();
        int status = this.hif.getStatus();
        if (this.hif != null) {
            if (!this.hif.bCO() && this.hif.isRecording()) {
                this.hif.stopRecord();
            }
            bDq();
        }
        if (this.hkW != null) {
            this.hkW.bCU();
            if (status == 6) {
                this.hkW.bDh();
            }
        }
    }

    public void bDq() {
        if (this.hif != null) {
            if (this.hif.getVideoDuration() >= 3000.0f) {
                uU(4);
            } else if (this.hif.getVideoDuration() > 0) {
                uU(3);
            } else {
                uU(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        if (this.hke != null && this.hke.isRunning()) {
            this.hke.cancel();
        }
        if (this.hkd == null) {
            this.hkd = new AnimatorSet();
            this.hkd.playTogether(ObjectAnimator.ofFloat(this.hkP, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hkS, "alpha", 1.0f, 0.0f));
            this.hkd.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlS) {
                        VideoControllerLayout.this.hkP.setVisibility(8);
                        VideoControllerLayout.this.hkS.setVisibility(8);
                    }
                }
            });
            this.hkd.setDuration(300L);
        }
        this.hkd.start();
        if (this.hif.getStatus() != 6) {
            this.hkR.nd(z);
        }
    }

    public void bDr() {
        if (this.hif == null || this.hif.isRecording() || this.hif.getStatus() == 6) {
            if (this.hkd != null && this.hkd.isRunning()) {
                this.hkd.cancel();
            }
            if (this.hke == null) {
                this.hke = new AnimatorSet();
                this.hke.playTogether(ObjectAnimator.ofFloat(this.hkP, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hkS, "alpha", 0.0f, 1.0f));
                this.hke.setDuration(300L);
            }
            this.hkP.setVisibility(0);
            this.hkS.setVisibility(0);
            this.hke.start();
            if (this.hif.getStatus() != 7 && this.hif.getStatus() != 6) {
                this.hkR.bDr();
                return;
            }
            this.hkR.getTvTip().setVisibility(8);
            if (this.dCq == 2) {
                this.hkR.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dCq) {
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
                if (this.hkW != null) {
                    this.hkW.bDm();
                }
                if (this.hif.getStatus() != 7 && this.hif.getStatus() != 6) {
                    if (this.hif != null && this.hif.bCL()) {
                        this.hkY = true;
                        com.baidu.tbadk.core.util.e.yd().showToast(f.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hkT = currentTimeMillis;
                    this.hkU = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hkU && VideoControllerLayout.this.hkT == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nc(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hkY) {
                    this.hkY = false;
                    return;
                }
                this.hkU = false;
                if (this.hif.isRecording() || this.hif.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hif.getStatus() != 8) {
                    nc(false);
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
                if (this.hif.getStatus() == 6) {
                    this.hif.setStatus(1);
                    if (this.hkW != null) {
                        this.hkW.bDh();
                        this.hkW.bCU();
                    }
                    this.hkR.getTvTip().setText("");
                    this.hkR.getTvTip().setVisibility(8);
                    return;
                } else if (this.hld.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hkW != null) {
                    this.hkW.bDg();
                    this.hkR.bDC();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hkR.bDD();
                return;
            default:
                return;
        }
    }

    public void bDa() {
        if (this.hld.getVisibility() == 0) {
            a((m) null);
        }
        nd(false);
        this.hkR.getLayer1().setVisibility(8);
        this.hkR.getTvTip().setText(getResources().getText(f.j.video_record_button_cancel));
        this.hkR.getTvTip().setVisibility(0);
        if (this.hkW != null) {
            this.hkW.bDf();
        }
    }

    public void bDs() {
        if (this.hif.getStatus() == 6) {
            if (this.dCq == 2) {
                uU(7);
                this.hkR.setAlpha(1.0f);
                this.hkP.setVisibility(8);
                this.hkS.setVisibility(8);
                this.hkR.getTvTip().setText(getResources().getString(f.j.video_record_button_pasue));
                if (this.hif != null) {
                    this.hif.startRecord();
                    return;
                }
                return;
            }
            this.hkR.getTvTip().setVisibility(8);
            if (this.hkW != null) {
                this.hkW.bDg();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        if (bDv() && this.hld.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bDv()) {
            bDu();
        }
        this.hld.bDb();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        if (bDv() && this.hld.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bDv()) {
            bDu();
        }
        this.hld.bDc();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        if (bDv() && this.hld.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bDv()) {
            bDu();
        }
        this.hld.bDd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        if (bDv() && this.hld.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bDv()) {
            bDu();
        }
        this.hld.bDe();
    }

    private void bDt() {
        if (w.z(this.hkV)) {
            this.hkV = new ArrayList();
            this.hkV.add(ObjectAnimator.ofFloat(this.hld, "translationY", 1000.0f, 0.0f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkQ, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), f.e.ds100)));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkR.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkR.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkR.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkR.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkS, "scaleX", 1.0f, 0.7f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkS, "scaleY", 1.0f, 0.7f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkP, "scaleX", 1.0f, 0.7f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkP, "scaleY", 1.0f, 0.7f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkS, "alpha", 1.0f, 0.0f));
            this.hkV.add(ObjectAnimator.ofFloat(this.hkP, "alpha", 1.0f, 0.0f));
        }
    }

    private void bDu() {
        int i = 0;
        if (this.hld.getVisibility() != 0) {
            this.hld.setVisibility(0);
            bDt();
            this.hkS.setEnabled(false);
            this.hkP.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hkV.size()) {
                    ObjectAnimator objectAnimator = this.hkV.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hkV.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hkW != null) {
                                        VideoControllerLayout.this.hkW.bDi();
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
        if (this.hld.getVisibility() != 8) {
            bDt();
            this.hkS.setEnabled(true);
            this.hkP.setEnabled(true);
            if (this.hif.getStatus() == 6 || this.hif.isRecording()) {
                this.hkP.setVisibility(8);
                this.hkS.setVisibility(8);
            } else {
                uU(this.hif.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hkV.size()) {
                    ObjectAnimator objectAnimator = this.hkV.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hkV.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hlS) {
                                        VideoControllerLayout.this.hld.setVisibility(8);
                                        if (VideoControllerLayout.this.hkW != null) {
                                            VideoControllerLayout.this.hkW.bDj();
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
        this.hkW = aVar;
    }

    public void setCurrentTab(int i) {
        this.dCq = i;
        switch (this.dCq) {
            case 1:
                this.hkP.setVisibility(4);
                this.hkS.setVisibility(4);
                this.hkR.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hif.getStatus() != 1) {
                    this.hkP.setVisibility(0);
                    this.hkS.setVisibility(0);
                }
                this.hkR.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bDv() {
        return this.hld.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hld != null) {
            this.hld.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hld != null) {
            this.hld.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hld != null) {
            this.hld.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bDw() {
        if (this.hld != null) {
            return this.hld.bDw();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hkX = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hkZ;
    }

    public List<e> getChoosedFilterList() {
        return this.hla;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hlb;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hlc.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hld != null) {
            this.hld.setMusicList(this.hlc);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void m(String str, int i, String str2) {
    }

    public void bDx() {
        if (this.hld != null) {
            this.hld.bDx();
        }
    }

    public void bCl() {
        if (this.hld != null) {
            this.hld.bCl();
        }
    }
}
