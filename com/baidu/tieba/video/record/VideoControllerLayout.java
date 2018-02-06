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
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int dRY;
    private j huN;
    private AnimatorSet hwM;
    private AnimatorSet hwN;
    private VideoRecordButton hxA;
    private ImageView hxB;
    private long hxC;
    private boolean hxD;
    private List<ObjectAnimator> hxE;
    private a hxF;
    private boolean hxG;
    private boolean hxH;
    private List<e> hxI;
    private List<e> hxJ;
    private List<StickerItem> hxK;
    private List<e> hxL;
    private VideoEffectLayout hxM;
    private ImageView hxy;
    private RelativeLayout hxz;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDG();

        void bDH();

        void bDR();

        void bDS();

        void bDT();

        void bDU();

        void bDV();

        void bDW();

        void bDX();

        void bDY();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hxC = 0L;
        this.hxD = false;
        this.hxG = true;
        this.hxI = new ArrayList();
        this.hxJ = new ArrayList();
        this.hxK = new ArrayList();
        this.hxL = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hxC = 0L;
        this.hxD = false;
        this.hxG = true;
        this.hxI = new ArrayList();
        this.hxJ = new ArrayList();
        this.hxK = new ArrayList();
        this.hxL = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxC = 0L;
        this.hxD = false;
        this.hxG = true;
        this.hxI = new ArrayList();
        this.hxJ = new ArrayList();
        this.hxK = new ArrayList();
        this.hxL = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.hxM = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hxz = (RelativeLayout) findViewById(d.g.layout_record);
        this.hxy = (ImageView) findViewById(d.g.delete_video);
        this.hxy.setOnClickListener(this);
        this.hxA = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hxA.setOnTouchListener(this);
        this.hxB = (ImageView) findViewById(d.g.confirm_video);
        this.hxB.setOnClickListener(this);
        this.hxL.add(0, new e(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.hxL.add(1, new e(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(j jVar) {
        this.huN = jVar;
        wY(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hxM != null) {
            this.hxM.setListener(aVar);
        }
    }

    public void wY(int i) {
        this.huN.setStatus(i);
        if (this.hxF != null) {
            this.hxF.bDY();
        }
        if (i == 1) {
            this.hxy.setVisibility(8);
            this.hxB.setVisibility(8);
        } else if (i == 3) {
            this.hxy.setImageResource(d.f.video_back_selector);
            this.hxB.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hxy.setImageResource(d.f.video_back_selector);
            this.hxB.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hxy.setImageResource(d.f.video_delete_selector);
            if (this.huN != null && this.huN.getVideoDuration() >= 3000.0f) {
                this.hxB.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hxB.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hxy) {
            if (this.hxF != null) {
                this.hxF.bDX();
            }
            int status = this.huN.getStatus();
            if (this.huN != null && this.huN.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.huN.bDA();
                    dN(this.hxI);
                    dN(this.hxJ);
                    dN(this.hxK);
                    if (this.huN.getVideoDuration() >= 3000.0f) {
                        wY(4);
                        return;
                    } else {
                        wY(this.huN.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.huN.bDz();
                wY(5);
            }
        } else if (view == this.hxB) {
            TiebaStatic.log("c12300");
            if (this.huN != null && this.huN.getStatus() > 2 && this.hxF != null) {
                if (this.huN.getVideoDuration() >= 3000.0f) {
                    this.hxF.bDH();
                } else {
                    this.hxF.bDW();
                }
            }
        }
    }

    private void dN(List list) {
        if (!v.E(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nt(final boolean z) {
        if (this.huN.getProgress() >= 100) {
            if (this.hxF != null) {
                this.hxF.bDH();
                return;
            }
            return;
        }
        if (this.hxM.getCurrentBeautyItem() != null) {
            this.hxI.add(this.hxM.getCurrentBeautyItem());
        }
        if (this.hxM.getCurrentFilterItem() != null) {
            this.hxJ.add(this.hxM.getCurrentFilterItem());
        }
        if (this.hxM.getCurrentStickItem() != null) {
            this.hxK.add(this.hxM.getCurrentStickItem());
        }
        wY(2);
        if (this.hxM.getVisibility() == 0) {
            a(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.huN.getStatus() == 6 || VideoControllerLayout.this.huN.isRecording()) {
                        VideoControllerLayout.this.nu(z);
                    }
                }
            });
        } else {
            nu(z);
        }
        if (this.huN != null) {
            this.huN.startRecord();
        }
        if (this.hxF != null) {
            this.hxF.bDR();
        }
    }

    public void stopRecord() {
        bEd();
        int status = this.huN.getStatus();
        if (this.huN != null) {
            if (this.huN.getStatus() != 6 && this.huN.isRecording()) {
                this.huN.stopRecord();
            }
            if (this.huN.getVideoDuration() >= 3000.0f) {
                wY(4);
            } else if (this.huN.getVideoDuration() > 0) {
                wY(3);
            } else {
                wY(1);
            }
        }
        if (this.hxF != null) {
            this.hxF.bDG();
            if (status == 6) {
                this.hxF.bDT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu(boolean z) {
        if (this.hwN != null && this.hwN.isRunning()) {
            this.hwN.cancel();
        }
        if (this.hwM == null) {
            this.hwM = new AnimatorSet();
            this.hwM.playTogether(ObjectAnimator.ofFloat(this.hxy, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hxB, "alpha", 1.0f, 0.0f));
            this.hwM.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyB) {
                        VideoControllerLayout.this.hxy.setVisibility(8);
                        VideoControllerLayout.this.hxB.setVisibility(8);
                    }
                }
            });
            this.hwM.setDuration(300L);
        }
        this.hwM.start();
        if (this.huN.getStatus() != 6) {
            this.hxA.nu(z);
        }
    }

    public void bEd() {
        if (this.huN == null || this.huN.isRecording() || this.huN.getStatus() == 6) {
            if (this.hwM != null && this.hwM.isRunning()) {
                this.hwM.cancel();
            }
            if (this.hwN == null) {
                this.hwN = new AnimatorSet();
                this.hwN.playTogether(ObjectAnimator.ofFloat(this.hxy, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hxB, "alpha", 0.0f, 1.0f));
                this.hwN.setDuration(300L);
            }
            this.hxy.setVisibility(0);
            this.hxB.setVisibility(0);
            this.hwN.start();
            if (this.huN.getStatus() != 7 && this.huN.getStatus() != 6) {
                this.hxA.bEd();
                return;
            }
            this.hxA.getTvTip().setVisibility(8);
            if (this.dRY == 2) {
                this.hxA.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dRY) {
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
                if (this.hxF != null) {
                    this.hxF.bDX();
                }
                if (this.huN.getStatus() != 7 && this.huN.getStatus() != 6) {
                    if (this.huN != null && this.huN.bDy()) {
                        this.hxH = true;
                        com.baidu.tbadk.core.util.e.BR().showToast(d.j.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hxC = currentTimeMillis;
                    this.hxD = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hxD && VideoControllerLayout.this.hxC == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nt(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hxH) {
                    this.hxH = false;
                    return;
                }
                this.hxD = false;
                if (this.huN.isRecording() || this.huN.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.huN.getStatus() != 8) {
                    nt(false);
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
                if (this.huN.getStatus() == 6) {
                    this.huN.setStatus(1);
                    if (this.hxF != null) {
                        this.hxF.bDT();
                        this.hxF.bDG();
                    }
                    this.hxA.getTvTip().setText("");
                    this.hxA.getTvTip().setVisibility(8);
                    return;
                } else if (this.hxM.getVisibility() == 0) {
                    a((o) null);
                    return;
                } else if (this.hxF != null) {
                    this.hxF.bDS();
                    this.hxA.bEo();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hxA.bEp();
                return;
            default:
                return;
        }
    }

    public void bDM() {
        if (this.hxM.getVisibility() == 0) {
            a((o) null);
        }
        nu(false);
        this.hxA.getLayer1().setVisibility(8);
        this.hxA.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.hxA.getTvTip().setVisibility(0);
        if (this.hxF != null) {
            this.hxF.bDR();
        }
    }

    public void bEe() {
        if (this.huN.getStatus() == 6) {
            if (this.dRY == 2) {
                wY(7);
                this.hxA.setAlpha(1.0f);
                this.hxy.setVisibility(8);
                this.hxB.setVisibility(8);
                this.hxA.getTvTip().setText(getResources().getString(d.j.video_record_button_pasue));
                if (this.huN != null) {
                    this.huN.startRecord();
                    return;
                }
                return;
            }
            this.hxA.getTvTip().setVisibility(8);
            if (this.hxF != null) {
                this.hxF.bDS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        if (bEh() && this.hxM.getCurrentEffectLayout() == 3) {
            a((o) null);
            return;
        }
        if (!bEh()) {
            bEg();
        }
        this.hxM.bDN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        if (bEh() && this.hxM.getCurrentEffectLayout() == 0) {
            a((o) null);
            return;
        }
        if (!bEh()) {
            bEg();
        }
        this.hxM.bDO();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        if (bEh() && this.hxM.getCurrentEffectLayout() == 1) {
            a((o) null);
            return;
        }
        if (!bEh()) {
            bEg();
        }
        this.hxM.bDP();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        if (bEh() && this.hxM.getCurrentEffectLayout() == 2) {
            a((o) null);
            return;
        }
        if (!bEh()) {
            bEg();
        }
        this.hxM.bDQ();
    }

    private void bEf() {
        if (v.E(this.hxE)) {
            this.hxE = new ArrayList();
            this.hxE.add(ObjectAnimator.ofFloat(this.hxM, "translationY", 1000.0f, 0.0f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxz, "translationY", 0.0f, com.baidu.adp.lib.util.l.t(getContext(), d.e.ds100)));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxA.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxA.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxA.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxA.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxB, "scaleX", 1.0f, 0.7f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxB, "scaleY", 1.0f, 0.7f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxy, "scaleX", 1.0f, 0.7f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxy, "scaleY", 1.0f, 0.7f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxB, "alpha", 1.0f, 0.0f));
            this.hxE.add(ObjectAnimator.ofFloat(this.hxy, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEg() {
        int i = 0;
        if (this.hxM.getVisibility() != 0) {
            this.hxM.setVisibility(0);
            bEf();
            this.hxB.setEnabled(false);
            this.hxy.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hxE.size()) {
                    ObjectAnimator objectAnimator = this.hxE.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxE.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hxF != null) {
                                        VideoControllerLayout.this.hxF.bDU();
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

    public void a(final o oVar) {
        if (this.hxM.getVisibility() != 8) {
            bEf();
            this.hxB.setEnabled(true);
            this.hxy.setEnabled(true);
            if (this.huN.getStatus() == 6 || this.huN.isRecording()) {
                this.hxy.setVisibility(8);
                this.hxB.setVisibility(8);
            } else {
                wY(this.huN.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hxE.size()) {
                    ObjectAnimator objectAnimator = this.hxE.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hxE.size() - 1) {
                            objectAnimator.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hyB) {
                                        VideoControllerLayout.this.hxM.setVisibility(8);
                                        if (VideoControllerLayout.this.hxF != null) {
                                            VideoControllerLayout.this.hxF.bDV();
                                        }
                                        if (oVar != null) {
                                            oVar.onAnimationEnd(animator);
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
        this.hxF = aVar;
    }

    public void setCurrentTab(int i) {
        this.dRY = i;
        switch (this.dRY) {
            case 1:
                this.hxy.setVisibility(4);
                this.hxB.setVisibility(4);
                this.hxA.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.huN.getStatus() != 1) {
                    this.hxy.setVisibility(0);
                    this.hxB.setVisibility(0);
                }
                this.hxA.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEh() {
        return this.hxM.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hxM != null) {
            this.hxM.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hxM != null) {
            this.hxM.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hxM != null) {
            this.hxM.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEi() {
        if (this.hxM != null) {
            return this.hxM.bEi();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hxG = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hxI;
    }

    public List<e> getChoosedFilterList() {
        return this.hxJ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hxK;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hxL.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hxM != null) {
            this.hxM.setMusicList(this.hxL);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bDZ() {
        if (this.hxM != null) {
            this.hxM.bDZ();
        }
    }

    public void bEj() {
        if (this.hxM != null) {
            this.hxM.bEj();
        }
    }

    public void bCX() {
        if (this.hxM != null) {
            this.hxM.bCX();
        }
    }
}
