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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int jCC;
    private Handler mHandler;
    private i nKE;
    private AnimatorSet nMw;
    private AnimatorSet nMx;
    private ImageView nNj;
    private RelativeLayout nNk;
    private VideoRecordButton nNl;
    private ImageView nNm;
    private long nNn;
    private boolean nNo;
    private List<ObjectAnimator> nNp;
    private a nNq;
    private boolean nNr;
    private boolean nNs;
    private List<e> nNt;
    private List<e> nNu;
    private List<StickerItem> nNv;
    private List<e> nNw;
    private VideoEffectLayout nNx;

    /* loaded from: classes8.dex */
    public interface a {
        void dVT();

        void dWf();

        void dWg();

        void dWh();

        void dWi();

        void dWj();

        void dWk();

        void dWl();

        void dWm();

        void dWn();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.nNn = 0L;
        this.nNo = false;
        this.nNr = true;
        this.nNt = new ArrayList();
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nNn = 0L;
        this.nNo = false;
        this.nNr = true;
        this.nNt = new ArrayList();
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nNn = 0L;
        this.nNo = false;
        this.nNr = true;
        this.nNt = new ArrayList();
        this.nNu = new ArrayList();
        this.nNv = new ArrayList();
        this.nNw = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.nNx = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.nNk = (RelativeLayout) findViewById(R.id.layout_record);
        this.nNj = (ImageView) findViewById(R.id.delete_video);
        this.nNj.setOnClickListener(this);
        this.nNl = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nNl.setOnTouchListener(this);
        this.nNm = (ImageView) findViewById(R.id.confirm_video);
        this.nNm.setOnClickListener(this);
        this.nNw.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.nNw.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.nKE = iVar;
        Me(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.nNx != null) {
            this.nNx.setListener(aVar);
        }
    }

    public void Me(int i) {
        this.nKE.setStatus(i);
        if (this.nNq != null) {
            this.nNq.dWn();
        }
        if (i == 1) {
            this.nNj.setVisibility(8);
            this.nNm.setVisibility(8);
        } else if (i == 3) {
            this.nNj.setImageResource(R.drawable.video_back_selector);
            this.nNm.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nNj.setImageResource(R.drawable.video_back_selector);
            this.nNm.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nNj.setImageResource(R.drawable.video_delete_selector);
            if (this.nKE != null && this.nKE.getVideoDuration() >= 3000.0f) {
                this.nNm.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.nNm.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nNj) {
            if (this.nNq != null) {
                this.nNq.dWm();
            }
            int status = this.nKE.getStatus();
            if (this.nKE != null && this.nKE.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.nKE.dVO();
                    gd(this.nNt);
                    gd(this.nNu);
                    gd(this.nNv);
                    if (this.nKE.getVideoDuration() >= 3000.0f) {
                        Me(4);
                        return;
                    } else {
                        Me(this.nKE.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.nKE.dVN();
                Me(5);
            }
        } else if (view == this.nNm) {
            TiebaStatic.log("c12300");
            if (this.nKE != null && this.nKE.getStatus() > 2 && this.nNq != null) {
                if (this.nKE.getVideoDuration() >= 3000.0f) {
                    this.nNq.dWk();
                } else {
                    this.nNq.dWl();
                }
            }
        }
    }

    private void gd(List list) {
        if (!x.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(final boolean z) {
        if (this.nKE.getProgress() >= 100) {
            if (this.nNq != null) {
                this.nNq.dWk();
                return;
            }
            return;
        }
        if (this.nNx.getCurrentBeautyItem() != null) {
            this.nNt.add(this.nNx.getCurrentBeautyItem());
        }
        if (this.nNx.getCurrentFilterItem() != null) {
            this.nNu.add(this.nNx.getCurrentFilterItem());
        }
        if (this.nNx.getCurrentStickItem() != null) {
            this.nNv.add(this.nNx.getCurrentStickItem());
        }
        Me(2);
        if (this.nNx.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.nKE.getStatus() == 6 || VideoControllerLayout.this.nKE.bzj()) {
                        VideoControllerLayout.this.yR(z);
                    }
                }
            });
        } else {
            yR(z);
        }
        if (this.nKE != null) {
            this.nKE.startRecord();
        }
        if (this.nNq != null) {
            this.nNq.dWf();
        }
    }

    public void stopRecord() {
        dWr();
        int status = this.nKE.getStatus();
        if (this.nKE != null) {
            if (!this.nKE.bXq() && this.nKE.bzj()) {
                this.nKE.stopRecord();
            }
            dWq();
        }
        if (this.nNq != null) {
            this.nNq.dVT();
            if (status == 6) {
                this.nNq.dWh();
            }
        }
    }

    public void dWq() {
        if (this.nKE != null) {
            if (this.nKE.getVideoDuration() >= 3000.0f) {
                Me(4);
            } else if (this.nKE.getVideoDuration() > 0) {
                Me(3);
            } else {
                Me(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(boolean z) {
        if (this.nMx != null && this.nMx.isRunning()) {
            this.nMx.cancel();
        }
        if (this.nMw == null) {
            this.nMw = new AnimatorSet();
            this.nMw.playTogether(ObjectAnimator.ofFloat(this.nNj, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nNm, "alpha", 1.0f, 0.0f));
            this.nMw.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOk) {
                        VideoControllerLayout.this.nNj.setVisibility(8);
                        VideoControllerLayout.this.nNm.setVisibility(8);
                    }
                }
            });
            this.nMw.setDuration(300L);
        }
        this.nMw.start();
        if (this.nKE.getStatus() != 6) {
            this.nNl.yR(z);
        }
    }

    public void dWr() {
        if (this.nKE == null || this.nKE.bzj() || this.nKE.getStatus() == 6) {
            if (this.nMw != null && this.nMw.isRunning()) {
                this.nMw.cancel();
            }
            if (this.nMx == null) {
                this.nMx = new AnimatorSet();
                this.nMx.playTogether(ObjectAnimator.ofFloat(this.nNj, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nNm, "alpha", 0.0f, 1.0f));
                this.nMx.setDuration(300L);
            }
            this.nNj.setVisibility(0);
            this.nNm.setVisibility(0);
            this.nMx.start();
            if (this.nKE.getStatus() != 7 && this.nKE.getStatus() != 6) {
                this.nNl.dWr();
                return;
            }
            this.nNl.getTvTip().setVisibility(8);
            if (this.jCC == 2) {
                this.nNl.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.jCC) {
            case 1:
                l(view, motionEvent);
                return true;
            case 2:
                k(view, motionEvent);
                return true;
            default:
                return true;
        }
    }

    private void k(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nNq != null) {
                    this.nNq.dWm();
                }
                if (this.nKE.getStatus() != 7 && this.nKE.getStatus() != 6) {
                    if (this.nKE != null && this.nKE.dVM()) {
                        this.nNs = true;
                        com.baidu.tbadk.core.util.e.bvz().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.nNn = currentTimeMillis;
                    this.nNo = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.nNo && VideoControllerLayout.this.nNn == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.gg(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.nNs) {
                    this.nNs = false;
                    return;
                }
                this.nNo = false;
                if (this.nKE.bzj() || this.nKE.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.nKE.getStatus() != 8) {
                    gg(false);
                    return;
                } else {
                    return;
                }
            case 2:
            default:
                return;
        }
    }

    private void l(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.nKE.getStatus() == 6) {
                    this.nKE.setStatus(1);
                    if (this.nNq != null) {
                        this.nNq.dWh();
                        this.nNq.dVT();
                    }
                    this.nNl.getTvTip().setText("");
                    this.nNl.getTvTip().setVisibility(8);
                    return;
                } else if (this.nNx.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.nNq != null) {
                    this.nNq.dWg();
                    this.nNl.dWC();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nNl.dWD();
                return;
            default:
                return;
        }
    }

    public void dWa() {
        if (this.nNx.getVisibility() == 0) {
            a((m) null);
        }
        yR(false);
        this.nNl.getLayer1().setVisibility(8);
        this.nNl.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nNl.getTvTip().setVisibility(0);
        if (this.nNq != null) {
            this.nNq.dWf();
        }
    }

    public void dWs() {
        if (this.nKE.getStatus() == 6) {
            if (this.jCC == 2) {
                Me(7);
                this.nNl.setAlpha(1.0f);
                this.nNj.setVisibility(8);
                this.nNm.setVisibility(8);
                this.nNl.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.nKE != null) {
                    this.nKE.startRecord();
                    return;
                }
                return;
            }
            this.nNl.getTvTip().setVisibility(8);
            if (this.nNq != null) {
                this.nNq.dWg();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        if (dWv() && this.nNx.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dWv()) {
            dWu();
        }
        this.nNx.dWb();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        if (dWv() && this.nNx.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dWv()) {
            dWu();
        }
        this.nNx.dWc();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        if (dWv() && this.nNx.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dWv()) {
            dWu();
        }
        this.nNx.dWd();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWe() {
        if (dWv() && this.nNx.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dWv()) {
            dWu();
        }
        this.nNx.dWe();
    }

    private void dWt() {
        if (x.isEmpty(this.nNp)) {
            this.nNp = new ArrayList();
            this.nNp.add(ObjectAnimator.ofFloat(this.nNx, "translationY", 1000.0f, 0.0f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNk, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNl.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNl.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNl.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNl.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNm, "scaleX", 1.0f, 0.7f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNm, "scaleY", 1.0f, 0.7f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNj, "scaleX", 1.0f, 0.7f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNj, "scaleY", 1.0f, 0.7f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNm, "alpha", 1.0f, 0.0f));
            this.nNp.add(ObjectAnimator.ofFloat(this.nNj, "alpha", 1.0f, 0.0f));
        }
    }

    private void dWu() {
        int i = 0;
        if (this.nNx.getVisibility() != 0) {
            this.nNx.setVisibility(0);
            dWt();
            this.nNm.setEnabled(false);
            this.nNj.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nNp.size()) {
                    ObjectAnimator objectAnimator = this.nNp.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nNp.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.nNq != null) {
                                        VideoControllerLayout.this.nNq.dWi();
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
        if (this.nNx.getVisibility() != 8) {
            dWt();
            this.nNm.setEnabled(true);
            this.nNj.setEnabled(true);
            if (this.nKE.getStatus() == 6 || this.nKE.bzj()) {
                this.nNj.setVisibility(8);
                this.nNm.setVisibility(8);
            } else {
                Me(this.nKE.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nNp.size()) {
                    ObjectAnimator objectAnimator = this.nNp.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nNp.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.nOk) {
                                        VideoControllerLayout.this.nNx.setVisibility(8);
                                        if (VideoControllerLayout.this.nNq != null) {
                                            VideoControllerLayout.this.nNq.dWj();
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
        this.nNq = aVar;
    }

    public void setCurrentTab(int i) {
        this.jCC = i;
        switch (this.jCC) {
            case 1:
                this.nNj.setVisibility(4);
                this.nNm.setVisibility(4);
                this.nNl.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.nKE.getStatus() != 1) {
                    this.nNj.setVisibility(0);
                    this.nNm.setVisibility(0);
                }
                this.nNl.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dWv() {
        return this.nNx.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.nNx != null) {
            this.nNx.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.nNx != null) {
            this.nNx.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.nNx != null) {
            this.nNx.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dWw() {
        if (this.nNx != null) {
            return this.nNx.dWw();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.nNr = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.nNt;
    }

    public List<e> getChoosedFilterList() {
        return this.nNu;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.nNv;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.nNw.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.nNx != null) {
            this.nNx.setMusicList(this.nNw);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dWx() {
        if (this.nNx != null) {
            this.nNx.dWx();
        }
    }

    public void dVk() {
        if (this.nNx != null) {
            this.nNx.dVk();
        }
    }
}
