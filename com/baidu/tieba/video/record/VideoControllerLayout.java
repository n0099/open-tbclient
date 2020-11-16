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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jcA;
    private Handler mHandler;
    private i ntk;
    private ImageView nvM;
    private RelativeLayout nvN;
    private VideoRecordButton nvO;
    private ImageView nvP;
    private long nvQ;
    private boolean nvR;
    private List<ObjectAnimator> nvS;
    private a nvT;
    private boolean nvU;
    private boolean nvV;
    private List<e> nvW;
    private List<e> nvX;
    private List<StickerItem> nvY;
    private List<e> nvZ;
    private AnimatorSet nvb;
    private AnimatorSet nvc;
    private VideoEffectLayout nwa;

    /* loaded from: classes22.dex */
    public interface a {
        void dQV();

        void dRg();

        void dRh();

        void dRi();

        void dRj();

        void dRk();

        void dRl();

        void dRm();

        void dRn();

        void dRo();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nvQ = 0L;
        this.nvR = false;
        this.nvU = true;
        this.nvW = new ArrayList();
        this.nvX = new ArrayList();
        this.nvY = new ArrayList();
        this.nvZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvQ = 0L;
        this.nvR = false;
        this.nvU = true;
        this.nvW = new ArrayList();
        this.nvX = new ArrayList();
        this.nvY = new ArrayList();
        this.nvZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvQ = 0L;
        this.nvR = false;
        this.nvU = true;
        this.nvW = new ArrayList();
        this.nvX = new ArrayList();
        this.nvY = new ArrayList();
        this.nvZ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nwa = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nvN = (RelativeLayout) findViewById(R.id.layout_record);
        this.nvM = (ImageView) findViewById(R.id.delete_video);
        this.nvM.setOnClickListener(this);
        this.nvO = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nvO.setOnTouchListener(this);
        this.nvP = (ImageView) findViewById(R.id.confirm_video);
        this.nvP.setOnClickListener(this);
        this.nvZ.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nvZ.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.ntk = iVar;
        Lz(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nwa != null) {
            this.nwa.setListener(aVar);
        }
    }

    public void Lz(int i) {
        this.ntk.setStatus(i);
        if (this.nvT != null) {
            this.nvT.dRo();
        }
        if (i == 1) {
            this.nvM.setVisibility(8);
            this.nvP.setVisibility(8);
        } else if (i == 3) {
            this.nvM.setImageResource(R.drawable.video_back_selector);
            this.nvP.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nvM.setImageResource(R.drawable.video_back_selector);
            this.nvP.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nvM.setImageResource(R.drawable.video_delete_selector);
            if (this.ntk != null && this.ntk.getVideoDuration() >= 3000.0f) {
                this.nvP.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nvP.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nvM) {
            if (this.nvT != null) {
                this.nvT.dRn();
            }
            int status = this.ntk.getStatus();
            if (this.ntk != null && this.ntk.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.ntk.dQQ();
                    fV(this.nvW);
                    fV(this.nvX);
                    fV(this.nvY);
                    if (this.ntk.getVideoDuration() >= 3000.0f) {
                        Lz(4);
                        return;
                    } else {
                        Lz(this.ntk.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.ntk.dQP();
                Lz(5);
            }
        } else if (view == this.nvP) {
            TiebaStatic.log("c12300");
            if (this.ntk != null && this.ntk.getStatus() > 2 && this.nvT != null) {
                if (this.ntk.getVideoDuration() >= 3000.0f) {
                    this.nvT.dRl();
                } else {
                    this.nvT.dRm();
                }
            }
        }
    }

    private void fV(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(final boolean z) {
        if (this.ntk.getProgress() >= 100) {
            if (this.nvT != null) {
                this.nvT.dRl();
                return;
            }
            return;
        }
        if (this.nwa.getCurrentBeautyItem() != null) {
            this.nvW.add(this.nwa.getCurrentBeautyItem());
        }
        if (this.nwa.getCurrentFilterItem() != null) {
            this.nvX.add(this.nwa.getCurrentFilterItem());
        }
        if (this.nwa.getCurrentStickItem() != null) {
            this.nvY.add(this.nwa.getCurrentStickItem());
        }
        Lz(2);
        if (this.nwa.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.ntk.getStatus() == 6 || VideoControllerLayout.this.ntk.btp()) {
                        VideoControllerLayout.this.ym(z);
                    }
                }
            });
        } else {
            ym(z);
        }
        if (this.ntk != null) {
            this.ntk.startRecord();
        }
        if (this.nvT != null) {
            this.nvT.dRg();
        }
    }

    public void stopRecord() {
        dRs();
        int status = this.ntk.getStatus();
        if (this.ntk != null) {
            if (!this.ntk.bRa() && this.ntk.btp()) {
                this.ntk.stopRecord();
            }
            dRr();
        }
        if (this.nvT != null) {
            this.nvT.dQV();
            if (status == 6) {
                this.nvT.dRi();
            }
        }
    }

    public void dRr() {
        if (this.ntk != null) {
            if (this.ntk.getVideoDuration() >= 3000.0f) {
                Lz(4);
            } else if (this.ntk.getVideoDuration() > 0) {
                Lz(3);
            } else {
                Lz(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(boolean z) {
        if (this.nvc != null && this.nvc.isRunning()) {
            this.nvc.cancel();
        }
        if (this.nvb == null) {
            this.nvb = new AnimatorSet();
            this.nvb.playTogether(ObjectAnimator.ofFloat(this.nvM, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nvP, "alpha", 1.0f, 0.0f));
            this.nvb.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nwN) {
                        VideoControllerLayout.this.nvM.setVisibility(8);
                        VideoControllerLayout.this.nvP.setVisibility(8);
                    }
                }
            });
            this.nvb.setDuration(300L);
        }
        this.nvb.start();
        if (this.ntk.getStatus() != 6) {
            this.nvO.ym(z);
        }
    }

    public void dRs() {
        if (this.ntk == null || this.ntk.btp() || this.ntk.getStatus() == 6) {
            if (this.nvb != null && this.nvb.isRunning()) {
                this.nvb.cancel();
            }
            if (this.nvc == null) {
                this.nvc = new AnimatorSet();
                this.nvc.playTogether(ObjectAnimator.ofFloat(this.nvM, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nvP, "alpha", 0.0f, 1.0f));
                this.nvc.setDuration(300L);
            }
            this.nvM.setVisibility(0);
            this.nvP.setVisibility(0);
            this.nvc.start();
            if (this.ntk.getStatus() != 7 && this.ntk.getStatus() != 6) {
                this.nvO.dRs();
                return;
            }
            this.nvO.getTvTip().setVisibility(8);
            if (this.jcA == 2) {
                this.nvO.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jcA) {
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
                if (this.nvT != null) {
                    this.nvT.dRn();
                }
                if (this.ntk.getStatus() != 7 && this.ntk.getStatus() != 6) {
                    if (this.ntk != null && this.ntk.dQO()) {
                        this.nvV = true;
                        com.baidu.tbadk.core.util.e.bpC().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nvQ = currentTimeMillis;
                    this.nvR = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nvR && VideoControllerLayout.this.nvQ == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.fI(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nvV) {
                    this.nvV = false;
                    return;
                }
                this.nvR = false;
                if (this.ntk.btp() || this.ntk.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.ntk.getStatus() != 8) {
                    fI(false);
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
                if (this.ntk.getStatus() == 6) {
                    this.ntk.setStatus(1);
                    if (this.nvT != null) {
                        this.nvT.dRi();
                        this.nvT.dQV();
                    }
                    this.nvO.getTvTip().setText("");
                    this.nvO.getTvTip().setVisibility(8);
                    return;
                } else if (this.nwa.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nvT != null) {
                    this.nvT.dRh();
                    this.nvO.dRD();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nvO.dRE();
                return;
            default:
                return;
        }
    }

    public void dRb() {
        if (this.nwa.getVisibility() == 0) {
            a((m) null);
        }
        ym(false);
        this.nvO.getLayer1().setVisibility(8);
        this.nvO.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nvO.getTvTip().setVisibility(0);
        if (this.nvT != null) {
            this.nvT.dRg();
        }
    }

    public void dRt() {
        if (this.ntk.getStatus() == 6) {
            if (this.jcA == 2) {
                Lz(7);
                this.nvO.setAlpha(1.0f);
                this.nvM.setVisibility(8);
                this.nvP.setVisibility(8);
                this.nvO.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.ntk != null) {
                    this.ntk.startRecord();
                    return;
                }
                return;
            }
            this.nvO.getTvTip().setVisibility(8);
            if (this.nvT != null) {
                this.nvT.dRh();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRc() {
        if (dRw() && this.nwa.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dRw()) {
            dRv();
        }
        this.nwa.dRc();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRd() {
        if (dRw() && this.nwa.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dRw()) {
            dRv();
        }
        this.nwa.dRd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRe() {
        if (dRw() && this.nwa.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dRw()) {
            dRv();
        }
        this.nwa.dRe();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRf() {
        if (dRw() && this.nwa.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dRw()) {
            dRv();
        }
        this.nwa.dRf();
    }

    private void dRu() {
        if (y.isEmpty(this.nvS)) {
            this.nvS = new ArrayList();
            this.nvS.add(ObjectAnimator.ofFloat(this.nwa, "translationY", 1000.0f, 0.0f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvN, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvO.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvO.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvO.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvO.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvP, "scaleX", 1.0f, 0.7f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvP, "scaleY", 1.0f, 0.7f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvM, "scaleX", 1.0f, 0.7f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvM, "scaleY", 1.0f, 0.7f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvP, "alpha", 1.0f, 0.0f));
            this.nvS.add(ObjectAnimator.ofFloat(this.nvM, "alpha", 1.0f, 0.0f));
        }
    }

    private void dRv() {
        int i = 0;
        if (this.nwa.getVisibility() != 0) {
            this.nwa.setVisibility(0);
            dRu();
            this.nvP.setEnabled(false);
            this.nvM.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nvS.size()) {
                    ObjectAnimator objectAnimator = this.nvS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nvS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nvT != null) {
                                        VideoControllerLayout.this.nvT.dRj();
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
        if (this.nwa.getVisibility() != 8) {
            dRu();
            this.nvP.setEnabled(true);
            this.nvM.setEnabled(true);
            if (this.ntk.getStatus() == 6 || this.ntk.btp()) {
                this.nvM.setVisibility(8);
                this.nvP.setVisibility(8);
            } else {
                Lz(this.ntk.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nvS.size()) {
                    ObjectAnimator objectAnimator = this.nvS.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nvS.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nwN) {
                                        VideoControllerLayout.this.nwa.setVisibility(8);
                                        if (VideoControllerLayout.this.nvT != null) {
                                            VideoControllerLayout.this.nvT.dRk();
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
        this.nvT = aVar;
    }

    public void setCurrentTab(int i) {
        this.jcA = i;
        switch (this.jcA) {
            case 1:
                this.nvM.setVisibility(4);
                this.nvP.setVisibility(4);
                this.nvO.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.ntk.getStatus() != 1) {
                    this.nvM.setVisibility(0);
                    this.nvP.setVisibility(0);
                }
                this.nvO.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dRw() {
        return this.nwa.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nwa != null) {
            this.nwa.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nwa != null) {
            this.nwa.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nwa != null) {
            this.nwa.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dRx() {
        if (this.nwa != null) {
            return this.nwa.dRx();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nvU = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nvW;
    }

    public List<e> getChoosedFilterList() {
        return this.nvX;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nvY;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nvZ.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nwa != null) {
            this.nwa.setMusicList(this.nvZ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void v(String str, int i, String str2) {
    }

    public void dRy() {
        if (this.nwa != null) {
            this.nwa.dRy();
        }
    }

    public void dQm() {
        if (this.nwa != null) {
            this.nwa.dQm();
        }
    }
}
