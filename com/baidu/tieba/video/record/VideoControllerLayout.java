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
    private int dwv;
    private i hcK;
    private AnimatorSet heH;
    private AnimatorSet heI;
    private a hfA;
    private boolean hfB;
    private boolean hfC;
    private List<e> hfD;
    private List<e> hfE;
    private List<StickerItem> hfF;
    private List<e> hfG;
    private VideoEffectLayout hfH;
    private ImageView hft;
    private RelativeLayout hfu;
    private VideoRecordButton hfv;
    private ImageView hfw;
    private long hfx;
    private boolean hfy;
    private List<ObjectAnimator> hfz;
    private Handler mHandler;

    /* loaded from: classes2.dex */
    public interface a {
        void bDI();

        void bDT();

        void bDU();

        void bDV();

        void bDW();

        void bDX();

        void bDY();

        void bDZ();

        void bEa();

        void bEb();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.hfx = 0L;
        this.hfy = false;
        this.hfB = true;
        this.hfD = new ArrayList();
        this.hfE = new ArrayList();
        this.hfF = new ArrayList();
        this.hfG = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfx = 0L;
        this.hfy = false;
        this.hfB = true;
        this.hfD = new ArrayList();
        this.hfE = new ArrayList();
        this.hfF = new ArrayList();
        this.hfG = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfx = 0L;
        this.hfy = false;
        this.hfB = true;
        this.hfD = new ArrayList();
        this.hfE = new ArrayList();
        this.hfF = new ArrayList();
        this.hfG = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.record_controller_layout, this);
        this.hfH = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.hfu = (RelativeLayout) findViewById(d.g.layout_record);
        this.hft = (ImageView) findViewById(d.g.delete_video);
        this.hft.setOnClickListener(this);
        this.hfv = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.hfv.setOnTouchListener(this);
        this.hfw = (ImageView) findViewById(d.g.confirm_video);
        this.hfw.setOnClickListener(this);
        this.hfG.add(0, new e(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute));
        this.hfG.add(1, new e(3, getResources().getString(d.k.music_cloud), new MusicData("-200", 2, getResources().getString(d.k.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.hcK = iVar;
        uN(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.hfH != null) {
            this.hfH.setListener(aVar);
        }
    }

    public void uN(int i) {
        this.hcK.setStatus(i);
        if (this.hfA != null) {
            this.hfA.bEb();
        }
        if (i == 1) {
            this.hft.setVisibility(8);
            this.hfw.setVisibility(8);
        } else if (i == 3) {
            this.hft.setImageResource(d.f.video_back_selector);
            this.hfw.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.hft.setImageResource(d.f.video_back_selector);
            this.hfw.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.hft.setImageResource(d.f.video_delete_selector);
            if (this.hcK != null && this.hcK.getVideoDuration() >= 3000.0f) {
                this.hfw.setImageResource(d.f.video_confirm_selector);
            } else {
                this.hfw.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hft) {
            if (this.hfA != null) {
                this.hfA.bEa();
            }
            int status = this.hcK.getStatus();
            if (this.hcK != null && this.hcK.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.hcK.bDB();
                    dM(this.hfD);
                    dM(this.hfE);
                    dM(this.hfF);
                    if (this.hcK.getVideoDuration() >= 3000.0f) {
                        uN(4);
                        return;
                    } else {
                        uN(this.hcK.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.hcK.bDA();
                uN(5);
            }
        } else if (view == this.hfw) {
            TiebaStatic.log("c12300");
            if (this.hcK != null && this.hcK.getStatus() > 2 && this.hfA != null) {
                if (this.hcK.getVideoDuration() >= 3000.0f) {
                    this.hfA.bDY();
                } else {
                    this.hfA.bDZ();
                }
            }
        }
    }

    private void dM(List list) {
        if (!w.z(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nh(final boolean z) {
        if (this.hcK.getProgress() >= 100) {
            if (this.hfA != null) {
                this.hfA.bDY();
                return;
            }
            return;
        }
        if (this.hfH.getCurrentBeautyItem() != null) {
            this.hfD.add(this.hfH.getCurrentBeautyItem());
        }
        if (this.hfH.getCurrentFilterItem() != null) {
            this.hfE.add(this.hfH.getCurrentFilterItem());
        }
        if (this.hfH.getCurrentStickItem() != null) {
            this.hfF.add(this.hfH.getCurrentStickItem());
        }
        uN(2);
        if (this.hfH.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.hcK.getStatus() == 6 || VideoControllerLayout.this.hcK.isRecording()) {
                        VideoControllerLayout.this.ni(z);
                    }
                }
            });
        } else {
            ni(z);
        }
        if (this.hcK != null) {
            this.hcK.startRecord();
        }
        if (this.hfA != null) {
            this.hfA.bDT();
        }
    }

    public void stopRecord() {
        bEf();
        int status = this.hcK.getStatus();
        if (this.hcK != null) {
            if (!this.hcK.bDC() && this.hcK.isRecording()) {
                this.hcK.stopRecord();
            }
            bEe();
        }
        if (this.hfA != null) {
            this.hfA.bDI();
            if (status == 6) {
                this.hfA.bDV();
            }
        }
    }

    public void bEe() {
        if (this.hcK != null) {
            if (this.hcK.getVideoDuration() >= 3000.0f) {
                uN(4);
            } else if (this.hcK.getVideoDuration() > 0) {
                uN(3);
            } else {
                uN(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z) {
        if (this.heI != null && this.heI.isRunning()) {
            this.heI.cancel();
        }
        if (this.heH == null) {
            this.heH = new AnimatorSet();
            this.heH.playTogether(ObjectAnimator.ofFloat(this.hft, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hfw, "alpha", 1.0f, 0.0f));
            this.heH.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hgw) {
                        VideoControllerLayout.this.hft.setVisibility(8);
                        VideoControllerLayout.this.hfw.setVisibility(8);
                    }
                }
            });
            this.heH.setDuration(300L);
        }
        this.heH.start();
        if (this.hcK.getStatus() != 6) {
            this.hfv.ni(z);
        }
    }

    public void bEf() {
        if (this.hcK == null || this.hcK.isRecording() || this.hcK.getStatus() == 6) {
            if (this.heH != null && this.heH.isRunning()) {
                this.heH.cancel();
            }
            if (this.heI == null) {
                this.heI = new AnimatorSet();
                this.heI.playTogether(ObjectAnimator.ofFloat(this.hft, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hfw, "alpha", 0.0f, 1.0f));
                this.heI.setDuration(300L);
            }
            this.hft.setVisibility(0);
            this.hfw.setVisibility(0);
            this.heI.start();
            if (this.hcK.getStatus() != 7 && this.hcK.getStatus() != 6) {
                this.hfv.bEf();
                return;
            }
            this.hfv.getTvTip().setVisibility(8);
            if (this.dwv == 2) {
                this.hfv.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.dwv) {
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
                if (this.hfA != null) {
                    this.hfA.bEa();
                }
                if (this.hcK.getStatus() != 7 && this.hcK.getStatus() != 6) {
                    if (this.hcK != null && this.hcK.bDz()) {
                        this.hfC = true;
                        com.baidu.tbadk.core.util.e.xZ().showToast(d.k.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.hfx = currentTimeMillis;
                    this.hfy = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.hfy && VideoControllerLayout.this.hfx == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.nh(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.hfC) {
                    this.hfC = false;
                    return;
                }
                this.hfy = false;
                if (this.hcK.isRecording() || this.hcK.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.hcK.getStatus() != 8) {
                    nh(false);
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
                if (this.hcK.getStatus() == 6) {
                    this.hcK.setStatus(1);
                    if (this.hfA != null) {
                        this.hfA.bDV();
                        this.hfA.bDI();
                    }
                    this.hfv.getTvTip().setText("");
                    this.hfv.getTvTip().setVisibility(8);
                    return;
                } else if (this.hfH.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.hfA != null) {
                    this.hfA.bDU();
                    this.hfv.bEq();
                    return;
                } else {
                    return;
                }
            case 1:
                this.hfv.bEr();
                return;
            default:
                return;
        }
    }

    public void bDO() {
        if (this.hfH.getVisibility() == 0) {
            a((m) null);
        }
        ni(false);
        this.hfv.getLayer1().setVisibility(8);
        this.hfv.getTvTip().setText(getResources().getText(d.k.video_record_button_cancel));
        this.hfv.getTvTip().setVisibility(0);
        if (this.hfA != null) {
            this.hfA.bDT();
        }
    }

    public void bEg() {
        if (this.hcK.getStatus() == 6) {
            if (this.dwv == 2) {
                uN(7);
                this.hfv.setAlpha(1.0f);
                this.hft.setVisibility(8);
                this.hfw.setVisibility(8);
                this.hfv.getTvTip().setText(getResources().getString(d.k.video_record_button_pasue));
                if (this.hcK != null) {
                    this.hcK.startRecord();
                    return;
                }
                return;
            }
            this.hfv.getTvTip().setVisibility(8);
            if (this.hfA != null) {
                this.hfA.bDU();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        if (bEj() && this.hfH.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!bEj()) {
            bEi();
        }
        this.hfH.bDP();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        if (bEj() && this.hfH.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bEj()) {
            bEi();
        }
        this.hfH.bDQ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        if (bEj() && this.hfH.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bEj()) {
            bEi();
        }
        this.hfH.bDR();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        if (bEj() && this.hfH.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bEj()) {
            bEi();
        }
        this.hfH.bDS();
    }

    private void bEh() {
        if (w.z(this.hfz)) {
            this.hfz = new ArrayList();
            this.hfz.add(ObjectAnimator.ofFloat(this.hfH, "translationY", 1000.0f, 0.0f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfu, "translationY", 0.0f, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds100)));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfv.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfv.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfv.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfv.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfw, "scaleX", 1.0f, 0.7f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfw, "scaleY", 1.0f, 0.7f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hft, "scaleX", 1.0f, 0.7f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hft, "scaleY", 1.0f, 0.7f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hfw, "alpha", 1.0f, 0.0f));
            this.hfz.add(ObjectAnimator.ofFloat(this.hft, "alpha", 1.0f, 0.0f));
        }
    }

    private void bEi() {
        int i = 0;
        if (this.hfH.getVisibility() != 0) {
            this.hfH.setVisibility(0);
            bEh();
            this.hfw.setEnabled(false);
            this.hft.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.hfz.size()) {
                    ObjectAnimator objectAnimator = this.hfz.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hfz.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.hfA != null) {
                                        VideoControllerLayout.this.hfA.bDW();
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
        if (this.hfH.getVisibility() != 8) {
            bEh();
            this.hfw.setEnabled(true);
            this.hft.setEnabled(true);
            if (this.hcK.getStatus() == 6 || this.hcK.isRecording()) {
                this.hft.setVisibility(8);
                this.hfw.setVisibility(8);
            } else {
                uN(this.hcK.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hfz.size()) {
                    ObjectAnimator objectAnimator = this.hfz.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.hfz.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.hgw) {
                                        VideoControllerLayout.this.hfH.setVisibility(8);
                                        if (VideoControllerLayout.this.hfA != null) {
                                            VideoControllerLayout.this.hfA.bDX();
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
        this.hfA = aVar;
    }

    public void setCurrentTab(int i) {
        this.dwv = i;
        switch (this.dwv) {
            case 1:
                this.hft.setVisibility(4);
                this.hfw.setVisibility(4);
                this.hfv.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.hcK.getStatus() != 1) {
                    this.hft.setVisibility(0);
                    this.hfw.setVisibility(0);
                }
                this.hfv.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean bEj() {
        return this.hfH.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.hfH != null) {
            this.hfH.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.hfH != null) {
            this.hfH.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.hfH != null) {
            this.hfH.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bEk() {
        if (this.hfH != null) {
            return this.hfH.bEk();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.hfB = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.hfD;
    }

    public List<e> getChoosedFilterList() {
        return this.hfE;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.hfF;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.hfG.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.hfH != null) {
            this.hfH.setMusicList(this.hfG);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void n(String str, int i, String str2) {
    }

    public void bEl() {
        if (this.hfH != null) {
            this.hfH.bEl();
        }
    }

    public void bCY() {
        if (this.hfH != null) {
            this.hfH.bCY();
        }
    }
}
