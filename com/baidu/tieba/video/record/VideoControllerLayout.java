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
/* loaded from: classes23.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int iJv;
    private Handler mHandler;
    private i mZG;
    private AnimatorSet nbx;
    private AnimatorSet nby;
    private ImageView nci;
    private RelativeLayout ncj;
    private VideoRecordButton nck;
    private ImageView ncl;
    private long ncm;
    private boolean ncn;
    private List<ObjectAnimator> nco;
    private a ncp;
    private boolean ncq;
    private boolean ncr;
    private List<e> ncs;
    private List<e> nct;
    private List<StickerItem> ncu;
    private List<e> ncv;
    private VideoEffectLayout ncw;

    /* loaded from: classes23.dex */
    public interface a {
        void dLA();

        void dLB();

        void dLC();

        void dLD();

        void dLE();

        void dLF();

        void dLm();

        void dLx();

        void dLy();

        void dLz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.ncm = 0L;
        this.ncn = false;
        this.ncq = true;
        this.ncs = new ArrayList();
        this.nct = new ArrayList();
        this.ncu = new ArrayList();
        this.ncv = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ncm = 0L;
        this.ncn = false;
        this.ncq = true;
        this.ncs = new ArrayList();
        this.nct = new ArrayList();
        this.ncu = new ArrayList();
        this.ncv = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ncm = 0L;
        this.ncn = false;
        this.ncq = true;
        this.ncs = new ArrayList();
        this.nct = new ArrayList();
        this.ncu = new ArrayList();
        this.ncv = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.ncw = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.ncj = (RelativeLayout) findViewById(R.id.layout_record);
        this.nci = (ImageView) findViewById(R.id.delete_video);
        this.nci.setOnClickListener(this);
        this.nck = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.nck.setOnTouchListener(this);
        this.ncl = (ImageView) findViewById(R.id.confirm_video);
        this.ncl.setOnClickListener(this);
        this.ncv.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.ncv.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mZG = iVar;
        Kr(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.ncw != null) {
            this.ncw.setListener(aVar);
        }
    }

    public void Kr(int i) {
        this.mZG.setStatus(i);
        if (this.ncp != null) {
            this.ncp.dLF();
        }
        if (i == 1) {
            this.nci.setVisibility(8);
            this.ncl.setVisibility(8);
        } else if (i == 3) {
            this.nci.setImageResource(R.drawable.video_back_selector);
            this.ncl.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.nci.setImageResource(R.drawable.video_back_selector);
            this.ncl.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.nci.setImageResource(R.drawable.video_delete_selector);
            if (this.mZG != null && this.mZG.getVideoDuration() >= 3000.0f) {
                this.ncl.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.ncl.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nci) {
            if (this.ncp != null) {
                this.ncp.dLE();
            }
            int status = this.mZG.getStatus();
            if (this.mZG != null && this.mZG.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mZG.dLh();
                    fE(this.ncs);
                    fE(this.nct);
                    fE(this.ncu);
                    if (this.mZG.getVideoDuration() >= 3000.0f) {
                        Kr(4);
                        return;
                    } else {
                        Kr(this.mZG.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mZG.dLg();
                Kr(5);
            }
        } else if (view == this.ncl) {
            TiebaStatic.log("c12300");
            if (this.mZG != null && this.mZG.getStatus() > 2 && this.ncp != null) {
                if (this.mZG.getVideoDuration() >= 3000.0f) {
                    this.ncp.dLC();
                } else {
                    this.ncp.dLD();
                }
            }
        }
    }

    private void fE(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(final boolean z) {
        if (this.mZG.getProgress() >= 100) {
            if (this.ncp != null) {
                this.ncp.dLC();
                return;
            }
            return;
        }
        if (this.ncw.getCurrentBeautyItem() != null) {
            this.ncs.add(this.ncw.getCurrentBeautyItem());
        }
        if (this.ncw.getCurrentFilterItem() != null) {
            this.nct.add(this.ncw.getCurrentFilterItem());
        }
        if (this.ncw.getCurrentStickItem() != null) {
            this.ncu.add(this.ncw.getCurrentStickItem());
        }
        Kr(2);
        if (this.ncw.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mZG.getStatus() == 6 || VideoControllerLayout.this.mZG.bpG()) {
                        VideoControllerLayout.this.xF(z);
                    }
                }
            });
        } else {
            xF(z);
        }
        if (this.mZG != null) {
            this.mZG.startRecord();
        }
        if (this.ncp != null) {
            this.ncp.dLx();
        }
    }

    public void stopRecord() {
        dLJ();
        int status = this.mZG.getStatus();
        if (this.mZG != null) {
            if (!this.mZG.bMH() && this.mZG.bpG()) {
                this.mZG.stopRecord();
            }
            dLI();
        }
        if (this.ncp != null) {
            this.ncp.dLm();
            if (status == 6) {
                this.ncp.dLz();
            }
        }
    }

    public void dLI() {
        if (this.mZG != null) {
            if (this.mZG.getVideoDuration() >= 3000.0f) {
                Kr(4);
            } else if (this.mZG.getVideoDuration() > 0) {
                Kr(3);
            } else {
                Kr(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(boolean z) {
        if (this.nby != null && this.nby.isRunning()) {
            this.nby.cancel();
        }
        if (this.nbx == null) {
            this.nbx = new AnimatorSet();
            this.nbx.playTogether(ObjectAnimator.ofFloat(this.nci, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.ncl, "alpha", 1.0f, 0.0f));
            this.nbx.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.ndj) {
                        VideoControllerLayout.this.nci.setVisibility(8);
                        VideoControllerLayout.this.ncl.setVisibility(8);
                    }
                }
            });
            this.nbx.setDuration(300L);
        }
        this.nbx.start();
        if (this.mZG.getStatus() != 6) {
            this.nck.xF(z);
        }
    }

    public void dLJ() {
        if (this.mZG == null || this.mZG.bpG() || this.mZG.getStatus() == 6) {
            if (this.nbx != null && this.nbx.isRunning()) {
                this.nbx.cancel();
            }
            if (this.nby == null) {
                this.nby = new AnimatorSet();
                this.nby.playTogether(ObjectAnimator.ofFloat(this.nci, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.ncl, "alpha", 0.0f, 1.0f));
                this.nby.setDuration(300L);
            }
            this.nci.setVisibility(0);
            this.ncl.setVisibility(0);
            this.nby.start();
            if (this.mZG.getStatus() != 7 && this.mZG.getStatus() != 6) {
                this.nck.dLJ();
                return;
            }
            this.nck.getTvTip().setVisibility(8);
            if (this.iJv == 2) {
                this.nck.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.iJv) {
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
                if (this.ncp != null) {
                    this.ncp.dLE();
                }
                if (this.mZG.getStatus() != 7 && this.mZG.getStatus() != 6) {
                    if (this.mZG != null && this.mZG.dLf()) {
                        this.ncr = true;
                        com.baidu.tbadk.core.util.e.blW().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.ncm = currentTimeMillis;
                    this.ncn = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.ncn && VideoControllerLayout.this.ncm == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.fj(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.ncr) {
                    this.ncr = false;
                    return;
                }
                this.ncn = false;
                if (this.mZG.bpG() || this.mZG.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mZG.getStatus() != 8) {
                    fj(false);
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
                if (this.mZG.getStatus() == 6) {
                    this.mZG.setStatus(1);
                    if (this.ncp != null) {
                        this.ncp.dLz();
                        this.ncp.dLm();
                    }
                    this.nck.getTvTip().setText("");
                    this.nck.getTvTip().setVisibility(8);
                    return;
                } else if (this.ncw.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.ncp != null) {
                    this.ncp.dLy();
                    this.nck.dLU();
                    return;
                } else {
                    return;
                }
            case 1:
                this.nck.dLV();
                return;
            default:
                return;
        }
    }

    public void dLs() {
        if (this.ncw.getVisibility() == 0) {
            a((m) null);
        }
        xF(false);
        this.nck.getLayer1().setVisibility(8);
        this.nck.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.nck.getTvTip().setVisibility(0);
        if (this.ncp != null) {
            this.ncp.dLx();
        }
    }

    public void dLK() {
        if (this.mZG.getStatus() == 6) {
            if (this.iJv == 2) {
                Kr(7);
                this.nck.setAlpha(1.0f);
                this.nci.setVisibility(8);
                this.ncl.setVisibility(8);
                this.nck.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mZG != null) {
                    this.mZG.startRecord();
                    return;
                }
                return;
            }
            this.nck.getTvTip().setVisibility(8);
            if (this.ncp != null) {
                this.ncp.dLy();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLt() {
        if (dLN() && this.ncw.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dLN()) {
            dLM();
        }
        this.ncw.dLt();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLu() {
        if (dLN() && this.ncw.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dLN()) {
            dLM();
        }
        this.ncw.dLu();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLv() {
        if (dLN() && this.ncw.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dLN()) {
            dLM();
        }
        this.ncw.dLv();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLw() {
        if (dLN() && this.ncw.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dLN()) {
            dLM();
        }
        this.ncw.dLw();
    }

    private void dLL() {
        if (y.isEmpty(this.nco)) {
            this.nco = new ArrayList();
            this.nco.add(ObjectAnimator.ofFloat(this.ncw, "translationY", 1000.0f, 0.0f));
            this.nco.add(ObjectAnimator.ofFloat(this.ncj, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.nco.add(ObjectAnimator.ofFloat(this.nck.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.nco.add(ObjectAnimator.ofFloat(this.nck.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.nco.add(ObjectAnimator.ofFloat(this.nck.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.nco.add(ObjectAnimator.ofFloat(this.nck.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.nco.add(ObjectAnimator.ofFloat(this.ncl, "scaleX", 1.0f, 0.7f));
            this.nco.add(ObjectAnimator.ofFloat(this.ncl, "scaleY", 1.0f, 0.7f));
            this.nco.add(ObjectAnimator.ofFloat(this.nci, "scaleX", 1.0f, 0.7f));
            this.nco.add(ObjectAnimator.ofFloat(this.nci, "scaleY", 1.0f, 0.7f));
            this.nco.add(ObjectAnimator.ofFloat(this.ncl, "alpha", 1.0f, 0.0f));
            this.nco.add(ObjectAnimator.ofFloat(this.nci, "alpha", 1.0f, 0.0f));
        }
    }

    private void dLM() {
        int i = 0;
        if (this.ncw.getVisibility() != 0) {
            this.ncw.setVisibility(0);
            dLL();
            this.ncl.setEnabled(false);
            this.nci.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.nco.size()) {
                    ObjectAnimator objectAnimator = this.nco.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nco.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.ncp != null) {
                                        VideoControllerLayout.this.ncp.dLA();
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
        if (this.ncw.getVisibility() != 8) {
            dLL();
            this.ncl.setEnabled(true);
            this.nci.setEnabled(true);
            if (this.mZG.getStatus() == 6 || this.mZG.bpG()) {
                this.nci.setVisibility(8);
                this.ncl.setVisibility(8);
            } else {
                Kr(this.mZG.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.nco.size()) {
                    ObjectAnimator objectAnimator = this.nco.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.nco.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.ndj) {
                                        VideoControllerLayout.this.ncw.setVisibility(8);
                                        if (VideoControllerLayout.this.ncp != null) {
                                            VideoControllerLayout.this.ncp.dLB();
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
        this.ncp = aVar;
    }

    public void setCurrentTab(int i) {
        this.iJv = i;
        switch (this.iJv) {
            case 1:
                this.nci.setVisibility(4);
                this.ncl.setVisibility(4);
                this.nck.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mZG.getStatus() != 1) {
                    this.nci.setVisibility(0);
                    this.ncl.setVisibility(0);
                }
                this.nck.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dLN() {
        return this.ncw.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.ncw != null) {
            this.ncw.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.ncw != null) {
            this.ncw.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.ncw != null) {
            this.ncw.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dLO() {
        if (this.ncw != null) {
            return this.ncw.dLO();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.ncq = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.ncs;
    }

    public List<e> getChoosedFilterList() {
        return this.nct;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.ncu;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.ncv.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.ncw != null) {
            this.ncw.setMusicList(this.ncv);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void u(String str, int i, String str2) {
    }

    public void dLP() {
        if (this.ncw != null) {
            this.ncw.dLP();
        }
    }

    public void dKD() {
        if (this.ncw != null) {
            this.ncw.dKD();
        }
    }
}
