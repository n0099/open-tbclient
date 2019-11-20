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
    private int fMa;
    private i jCt;
    private AnimatorSet jEp;
    private AnimatorSet jEq;
    private ImageView jFb;
    private RelativeLayout jFc;
    private VideoRecordButton jFd;
    private ImageView jFe;
    private long jFf;
    private boolean jFg;
    private List<ObjectAnimator> jFh;
    private a jFi;
    private boolean jFj;
    private boolean jFk;
    private List<e> jFl;
    private List<e> jFm;
    private List<StickerItem> jFn;
    private List<e> jFo;
    private VideoEffectLayout jFp;
    private Handler mHandler;

    /* loaded from: classes5.dex */
    public interface a {
        void cvA();

        void cvB();

        void cvC();

        void cvD();

        void cvE();

        void cvF();

        void cvG();

        void cvH();

        void cvo();

        void cvz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.jFf = 0L;
        this.jFg = false;
        this.jFj = true;
        this.jFl = new ArrayList();
        this.jFm = new ArrayList();
        this.jFn = new ArrayList();
        this.jFo = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFf = 0L;
        this.jFg = false;
        this.jFj = true;
        this.jFl = new ArrayList();
        this.jFm = new ArrayList();
        this.jFn = new ArrayList();
        this.jFo = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFf = 0L;
        this.jFg = false;
        this.jFj = true;
        this.jFl = new ArrayList();
        this.jFm = new ArrayList();
        this.jFn = new ArrayList();
        this.jFo = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.jFp = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.jFc = (RelativeLayout) findViewById(R.id.layout_record);
        this.jFb = (ImageView) findViewById(R.id.delete_video);
        this.jFb.setOnClickListener(this);
        this.jFd = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.jFd.setOnTouchListener(this);
        this.jFe = (ImageView) findViewById(R.id.confirm_video);
        this.jFe.setOnClickListener(this);
        this.jFo.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.jFo.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.jCt = iVar;
        Bf(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.jFp != null) {
            this.jFp.setListener(aVar);
        }
    }

    public void Bf(int i) {
        this.jCt.setStatus(i);
        if (this.jFi != null) {
            this.jFi.cvH();
        }
        if (i == 1) {
            this.jFb.setVisibility(8);
            this.jFe.setVisibility(8);
        } else if (i == 3) {
            this.jFb.setImageResource(R.drawable.video_back_selector);
            this.jFe.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.jFb.setImageResource(R.drawable.video_back_selector);
            this.jFe.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.jFb.setImageResource(R.drawable.video_delete_selector);
            if (this.jCt != null && this.jCt.getVideoDuration() >= 3000.0f) {
                this.jFe.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.jFe.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jFb) {
            if (this.jFi != null) {
                this.jFi.cvG();
            }
            int status = this.jCt.getStatus();
            if (this.jCt != null && this.jCt.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.jCt.cvh();
                    eG(this.jFl);
                    eG(this.jFm);
                    eG(this.jFn);
                    if (this.jCt.getVideoDuration() >= 3000.0f) {
                        Bf(4);
                        return;
                    } else {
                        Bf(this.jCt.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.jCt.cvg();
                Bf(5);
            }
        } else if (view == this.jFe) {
            TiebaStatic.log("c12300");
            if (this.jCt != null && this.jCt.getStatus() > 2 && this.jFi != null) {
                if (this.jCt.getVideoDuration() >= 3000.0f) {
                    this.jFi.cvE();
                } else {
                    this.jFi.cvF();
                }
            }
        }
    }

    private void eG(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(final boolean z) {
        if (this.jCt.getProgress() >= 100) {
            if (this.jFi != null) {
                this.jFi.cvE();
                return;
            }
            return;
        }
        if (this.jFp.getCurrentBeautyItem() != null) {
            this.jFl.add(this.jFp.getCurrentBeautyItem());
        }
        if (this.jFp.getCurrentFilterItem() != null) {
            this.jFm.add(this.jFp.getCurrentFilterItem());
        }
        if (this.jFp.getCurrentStickItem() != null) {
            this.jFn.add(this.jFp.getCurrentStickItem());
        }
        Bf(2);
        if (this.jFp.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.jCt.getStatus() == 6 || VideoControllerLayout.this.jCt.aoA()) {
                        VideoControllerLayout.this.rA(z);
                    }
                }
            });
        } else {
            rA(z);
        }
        if (this.jCt != null) {
            this.jCt.startRecord();
        }
        if (this.jFi != null) {
            this.jFi.cvz();
        }
    }

    public void stopRecord() {
        cvL();
        int status = this.jCt.getStatus();
        if (this.jCt != null) {
            if (!this.jCt.cvi() && this.jCt.aoA()) {
                this.jCt.stopRecord();
            }
            cvK();
        }
        if (this.jFi != null) {
            this.jFi.cvo();
            if (status == 6) {
                this.jFi.cvB();
            }
        }
    }

    public void cvK() {
        if (this.jCt != null) {
            if (this.jCt.getVideoDuration() >= 3000.0f) {
                Bf(4);
            } else if (this.jCt.getVideoDuration() > 0) {
                Bf(3);
            } else {
                Bf(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(boolean z) {
        if (this.jEq != null && this.jEq.isRunning()) {
            this.jEq.cancel();
        }
        if (this.jEp == null) {
            this.jEp = new AnimatorSet();
            this.jEp.playTogether(ObjectAnimator.ofFloat(this.jFb, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFe, "alpha", 1.0f, 0.0f));
            this.jEp.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGc) {
                        VideoControllerLayout.this.jFb.setVisibility(8);
                        VideoControllerLayout.this.jFe.setVisibility(8);
                    }
                }
            });
            this.jEp.setDuration(300L);
        }
        this.jEp.start();
        if (this.jCt.getStatus() != 6) {
            this.jFd.rA(z);
        }
    }

    public void cvL() {
        if (this.jCt == null || this.jCt.aoA() || this.jCt.getStatus() == 6) {
            if (this.jEp != null && this.jEp.isRunning()) {
                this.jEp.cancel();
            }
            if (this.jEq == null) {
                this.jEq = new AnimatorSet();
                this.jEq.playTogether(ObjectAnimator.ofFloat(this.jFb, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFe, "alpha", 0.0f, 1.0f));
                this.jEq.setDuration(300L);
            }
            this.jFb.setVisibility(0);
            this.jFe.setVisibility(0);
            this.jEq.start();
            if (this.jCt.getStatus() != 7 && this.jCt.getStatus() != 6) {
                this.jFd.cvL();
                return;
            }
            this.jFd.getTvTip().setVisibility(8);
            if (this.fMa == 2) {
                this.jFd.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.fMa) {
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
                if (this.jFi != null) {
                    this.jFi.cvG();
                }
                if (this.jCt.getStatus() != 7 && this.jCt.getStatus() != 6) {
                    if (this.jCt != null && this.jCt.cvf()) {
                        this.jFk = true;
                        com.baidu.tbadk.core.util.e.alU().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.jFf = currentTimeMillis;
                    this.jFg = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.jFg && VideoControllerLayout.this.jFf == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.aY(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.jFk) {
                    this.jFk = false;
                    return;
                }
                this.jFg = false;
                if (this.jCt.aoA() || this.jCt.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.jCt.getStatus() != 8) {
                    aY(false);
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
                if (this.jCt.getStatus() == 6) {
                    this.jCt.setStatus(1);
                    if (this.jFi != null) {
                        this.jFi.cvB();
                        this.jFi.cvo();
                    }
                    this.jFd.getTvTip().setText("");
                    this.jFd.getTvTip().setVisibility(8);
                    return;
                } else if (this.jFp.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.jFi != null) {
                    this.jFi.cvA();
                    this.jFd.cvW();
                    return;
                } else {
                    return;
                }
            case 1:
                this.jFd.cvX();
                return;
            default:
                return;
        }
    }

    public void cvu() {
        if (this.jFp.getVisibility() == 0) {
            a((m) null);
        }
        rA(false);
        this.jFd.getLayer1().setVisibility(8);
        this.jFd.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.jFd.getTvTip().setVisibility(0);
        if (this.jFi != null) {
            this.jFi.cvz();
        }
    }

    public void cvM() {
        if (this.jCt.getStatus() == 6) {
            if (this.fMa == 2) {
                Bf(7);
                this.jFd.setAlpha(1.0f);
                this.jFb.setVisibility(8);
                this.jFe.setVisibility(8);
                this.jFd.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.jCt != null) {
                    this.jCt.startRecord();
                    return;
                }
                return;
            }
            this.jFd.getTvTip().setVisibility(8);
            if (this.jFi != null) {
                this.jFi.cvA();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvv() {
        if (cvP() && this.jFp.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!cvP()) {
            cvO();
        }
        this.jFp.cvv();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvw() {
        if (cvP() && this.jFp.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!cvP()) {
            cvO();
        }
        this.jFp.cvw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        if (cvP() && this.jFp.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!cvP()) {
            cvO();
        }
        this.jFp.cvx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        if (cvP() && this.jFp.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!cvP()) {
            cvO();
        }
        this.jFp.cvy();
    }

    private void cvN() {
        if (v.isEmpty(this.jFh)) {
            this.jFh = new ArrayList();
            this.jFh.add(ObjectAnimator.ofFloat(this.jFp, "translationY", 1000.0f, 0.0f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFc, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFd.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFd.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFd.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFd.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFe, "scaleX", 1.0f, 0.7f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFe, "scaleY", 1.0f, 0.7f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFb, "scaleX", 1.0f, 0.7f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFb, "scaleY", 1.0f, 0.7f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFe, "alpha", 1.0f, 0.0f));
            this.jFh.add(ObjectAnimator.ofFloat(this.jFb, "alpha", 1.0f, 0.0f));
        }
    }

    private void cvO() {
        int i = 0;
        if (this.jFp.getVisibility() != 0) {
            this.jFp.setVisibility(0);
            cvN();
            this.jFe.setEnabled(false);
            this.jFb.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.jFh.size()) {
                    ObjectAnimator objectAnimator = this.jFh.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jFh.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.jFi != null) {
                                        VideoControllerLayout.this.jFi.cvC();
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
        if (this.jFp.getVisibility() != 8) {
            cvN();
            this.jFe.setEnabled(true);
            this.jFb.setEnabled(true);
            if (this.jCt.getStatus() == 6 || this.jCt.aoA()) {
                this.jFb.setVisibility(8);
                this.jFe.setVisibility(8);
            } else {
                Bf(this.jCt.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jFh.size()) {
                    ObjectAnimator objectAnimator = this.jFh.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.jFh.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.jGc) {
                                        VideoControllerLayout.this.jFp.setVisibility(8);
                                        if (VideoControllerLayout.this.jFi != null) {
                                            VideoControllerLayout.this.jFi.cvD();
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
        this.jFi = aVar;
    }

    public void setCurrentTab(int i) {
        this.fMa = i;
        switch (this.fMa) {
            case 1:
                this.jFb.setVisibility(4);
                this.jFe.setVisibility(4);
                this.jFd.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.jCt.getStatus() != 1) {
                    this.jFb.setVisibility(0);
                    this.jFe.setVisibility(0);
                }
                this.jFd.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean cvP() {
        return this.jFp.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.jFp != null) {
            this.jFp.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.jFp != null) {
            this.jFp.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.jFp != null) {
            this.jFp.setDownLoadStrick(stickerItem);
        }
    }

    public boolean cvQ() {
        if (this.jFp != null) {
            return this.jFp.cvQ();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.jFj = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.jFl;
    }

    public List<e> getChoosedFilterList() {
        return this.jFm;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.jFn;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.jFo.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.jFp != null) {
            this.jFp.setMusicList(this.jFo);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void r(String str, int i, String str2) {
    }

    public void cvR() {
        if (this.jFp != null) {
            this.jFp.cvR();
        }
    }

    public void cuD() {
        if (this.jFp != null) {
            this.jFp.cuD();
        }
    }
}
