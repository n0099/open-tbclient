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
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dCt;
    private i hie;
    private ImageView hkO;
    private RelativeLayout hkP;
    private VideoRecordButton hkQ;
    private ImageView hkR;
    private long hkS;
    private boolean hkT;
    private List<ObjectAnimator> hkU;
    private a hkV;
    private boolean hkW;
    private boolean hkX;
    private List<e> hkY;
    private List<e> hkZ;
    private AnimatorSet hkc;
    private AnimatorSet hkd;
    private List<StickerItem> hla;
    private List<e> hlb;
    private VideoEffectLayout hlc;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bCS();

        void bDd();

        void bDe();

        void bDf();

        void bDg();

        void bDh();

        void bDi();

        void bDj();

        void bDk();

        void bDl();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hkS = 0L;
        this.hkT = false;
        this.hkW = true;
        this.hkY = new ArrayList();
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkS = 0L;
        this.hkT = false;
        this.hkW = true;
        this.hkY = new ArrayList();
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkS = 0L;
        this.hkT = false;
        this.hkW = true;
        this.hkY = new ArrayList();
        this.hkZ = new ArrayList();
        this.hla = new ArrayList();
        this.hlb = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hlc = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hkP = (RelativeLayout) findViewById(d.g.layout_record);
        this.hkO = (ImageView) findViewById(d.g.delete_video);
        this.hkO.setOnClickListener(this);
        this.hkQ = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hkQ.setOnTouchListener(this);
        this.hkR = (ImageView) findViewById(d.g.confirm_video);
        this.hkR.setOnClickListener(this);
        this.hlb.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hlb.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hie = iVar;
        uU(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hlc != null) {
            this.hlc.setListener(aVar);
        }
    }

    public void uU(int i) {
        this.hie.setStatus(i);
        if (this.hkV != null) {
            this.hkV.bDl();
        }
        if (i == 1) {
            this.hkO.setVisibility(8);
            this.hkR.setVisibility(8);
        } else if (i == 3) {
            this.hkO.setImageResource(d.f.video_back_selector);
            this.hkR.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hkO.setImageResource(d.f.video_back_selector);
            this.hkR.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hkO.setImageResource(d.f.video_delete_selector);
            if (this.hie != null && this.hie.getVideoDuration() >= 3000.0f) {
                this.hkR.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hkR.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hkO) {
            if (this.hkV != null) {
                this.hkV.bDk();
            }
            int status = this.hie.getStatus();
            if (this.hie != null && this.hie.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hie.bCL();
                    dL(this.hkY);
                    dL(this.hkZ);
                    dL(this.hla);
                    if (this.hie.getVideoDuration() >= 3000.0f) {
                        uU(4);
                        return;
                    } else {
                        uU(this.hie.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hie.bCK();
                uU(5);
            }
        } else if (view == this.hkR) {
            TiebaStatic.log("c12300");
            if (this.hie != null && this.hie.getStatus() > 2 && this.hkV != null) {
                if (this.hie.getVideoDuration() >= 3000.0f) {
                    this.hkV.bDi();
                } else {
                    this.hkV.bDj();
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
        if (this.hie.getProgress() >= 100) {
            if (this.hkV != null) {
                this.hkV.bDi();
                return;
            }
            return;
        }
        if (this.hlc.getCurrentBeautyItem() != null) {
            this.hkY.add(this.hlc.getCurrentBeautyItem());
        }
        if (this.hlc.getCurrentFilterItem() != null) {
            this.hkZ.add(this.hlc.getCurrentFilterItem());
        }
        if (this.hlc.getCurrentStickItem() != null) {
            this.hla.add(this.hlc.getCurrentStickItem());
        }
        uU(2);
        if (this.hlc.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hie.getStatus() == 6 || VideoControllerLayout.this.hie.isRecording()) {
                        VideoControllerLayout.this.nd(z);
                    }
                }
            });
        } else {
            nd(z);
        }
        if (this.hie != null) {
            this.hie.startRecord();
        }
        if (this.hkV != null) {
            this.hkV.bDd();
        }
    }

    public void stopRecord() {
        bDp();
        int status = this.hie.getStatus();
        if (this.hie != null) {
            if (!this.hie.bCM() && this.hie.isRecording()) {
                this.hie.stopRecord();
            }
            bDo();
        }
        if (this.hkV != null) {
            this.hkV.bCS();
            if (status == 6) {
                this.hkV.bDf();
            }
        }
    }

    public void bDo() {
        if (this.hie != null) {
            if (this.hie.getVideoDuration() >= 3000.0f) {
                uU(4);
            } else if (this.hie.getVideoDuration() > 0) {
                uU(3);
            } else {
                uU(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        if (this.hkd != null && this.hkd.isRunning()) {
            this.hkd.cancel();
        }
        if (this.hkc == null) {
            this.hkc = new AnimatorSet();
            this.hkc.playTogether(ObjectAnimator.ofFloat(this.hkO, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hkR, "alpha", 1.0f, 0.0f));
            this.hkc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlR) {
                        VideoControllerLayout.this.hkO.setVisibility(8);
                        VideoControllerLayout.this.hkR.setVisibility(8);
                    }
                }
            });
            this.hkc.setDuration(300L);
        }
        this.hkc.start();
        if (this.hie.getStatus() != 6) {
            this.hkQ.nd(z);
        }
    }

    public void bDp() {
        if (this.hie == null || this.hie.isRecording() || this.hie.getStatus() == 6) {
            if (this.hkc != null && this.hkc.isRunning()) {
                this.hkc.cancel();
            }
            if (this.hkd == null) {
                this.hkd = new AnimatorSet();
                this.hkd.playTogether(ObjectAnimator.ofFloat(this.hkO, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hkR, "alpha", 0.0f, 1.0f));
                this.hkd.setDuration(300L);
            }
            this.hkO.setVisibility(0);
            this.hkR.setVisibility(0);
            this.hkd.start();
            if (this.hie.getStatus() != 7 && this.hie.getStatus() != 6) {
                this.hkQ.bDp();
                return;
            }
            this.hkQ.getTvTip().setVisibility(8);
            if (this.dCt == 2) {
                this.hkQ.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dCt) {
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
                if (this.hkV != null) {
                    this.hkV.bDk();
                }
                if (this.hie.getStatus() != 7 && this.hie.getStatus() != 6) {
                    if (this.hie != null && this.hie.bCJ()) {
                        this.hkX = true;
                        com.baidu.tbadk.core.util.e.ye().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hkS = currentTimeMillis;
                    this.hkT = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hkT && VideoControllerLayout.this.hkS == currentTimeMillis) {
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
                if (this.hkX) {
                    this.hkX = false;
                    return;
                }
                this.hkT = false;
                if (this.hie.isRecording() || this.hie.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hie.getStatus() != 8) {
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
                if (this.hie.getStatus() == 6) {
                    this.hie.setStatus(1);
                    if (this.hkV != null) {
                        this.hkV.bDf();
                        this.hkV.bCS();
                    }
                    this.hkQ.getTvTip().setText("");
                    this.hkQ.getTvTip().setVisibility(8);
                    return;
                } else if (this.hlc.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hkV != null) {
                    this.hkV.bDe();
                    this.hkQ.bDA();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hkQ.bDB();
                return;
            default:
                return;
        }
    }

    public void bCY() {
        if (this.hlc.getVisibility() == 0) {
            a((m) null);
        }
        nd(false);
        this.hkQ.getLayer1().setVisibility(8);
        this.hkQ.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hkQ.getTvTip().setVisibility(0);
        if (this.hkV != null) {
            this.hkV.bDd();
        }
    }

    public void bDq() {
        if (this.hie.getStatus() == 6) {
            if (this.dCt == 2) {
                uU(7);
                this.hkQ.setAlpha(1.0f);
                this.hkO.setVisibility(8);
                this.hkR.setVisibility(8);
                this.hkQ.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.hie != null) {
                    this.hie.startRecord();
                    return;
                }
                return;
            }
            this.hkQ.getTvTip().setVisibility(8);
            if (this.hkV != null) {
                this.hkV.bDe();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bCZ() {
        if (bDt() && this.hlc.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bDt()) {
            bDs();
        }
        this.hlc.bCZ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDa() {
        if (bDt() && this.hlc.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bDt()) {
            bDs();
        }
        this.hlc.bDa();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        if (bDt() && this.hlc.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bDt()) {
            bDs();
        }
        this.hlc.bDb();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        if (bDt() && this.hlc.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bDt()) {
            bDs();
        }
        this.hlc.bDc();
    }

    private void bDr() {
        if (w.z(this.hkU)) {
            this.hkU = new ArrayList();
            this.hkU.add(ObjectAnimator.ofFloat(this.hlc, "translationY", 1000.0f, 0.0f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkP, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkQ.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkQ.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkQ.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkQ.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkR, "scaleX", 1.0f, 0.7f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkR, "scaleY", 1.0f, 0.7f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkO, "scaleX", 1.0f, 0.7f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkO, "scaleY", 1.0f, 0.7f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkR, "alpha", 1.0f, 0.0f));
            this.hkU.add(ObjectAnimator.ofFloat(this.hkO, "alpha", 1.0f, 0.0f));
        }
    }

    private void bDs() {
        int i = 0;
        if (this.hlc.getVisibility() != 0) {
            this.hlc.setVisibility(0);
            bDr();
            this.hkR.setEnabled(false);
            this.hkO.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hkU.size()) {
                    ObjectAnimator objectAnimator = this.hkU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hkU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hkV != null) {
                                        VideoControllerLayout.this.hkV.bDg();
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
        if (this.hlc.getVisibility() != 8) {
            bDr();
            this.hkR.setEnabled(true);
            this.hkO.setEnabled(true);
            if (this.hie.getStatus() == 6 || this.hie.isRecording()) {
                this.hkO.setVisibility(8);
                this.hkR.setVisibility(8);
            } else {
                uU(this.hie.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hkU.size()) {
                    ObjectAnimator objectAnimator = this.hkU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hkU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hlR) {
                                        VideoControllerLayout.this.hlc.setVisibility(8);
                                        if (VideoControllerLayout.this.hkV != null) {
                                            VideoControllerLayout.this.hkV.bDh();
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
        this.hkV = aVar;
    }

    public void setCurrentTab(int i) {
        this.dCt = i;
        switch (this.dCt) {
            case 1:
                this.hkO.setVisibility(4);
                this.hkR.setVisibility(4);
                this.hkQ.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hie.getStatus() != 1) {
                    this.hkO.setVisibility(0);
                    this.hkR.setVisibility(0);
                }
                this.hkQ.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bDt() {
        return this.hlc.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hlc != null) {
            this.hlc.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hlc != null) {
            this.hlc.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hlc != null) {
            this.hlc.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bDu() {
        if (this.hlc != null) {
            return this.hlc.bDu();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hkW = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hkY;
    }

    public List<e> getChoosedFilterList() {
        return this.hkZ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hla;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hlb.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hlc != null) {
            this.hlc.setMusicList(this.hlb);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDv() {
        if (this.hlc != null) {
            this.hlc.bDv();
        }
    }

    public void bCj() {
        if (this.hlc != null) {
            this.hlc.bCj();
        }
    }
}
