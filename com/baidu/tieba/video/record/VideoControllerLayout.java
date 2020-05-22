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
    private int hEW;
    private i lFO;
    private AnimatorSet lHH;
    private AnimatorSet lHI;
    private boolean lIA;
    private boolean lIB;
    private List<e> lIC;
    private List<e> lID;
    private List<StickerItem> lIE;
    private List<e> lIF;
    private VideoEffectLayout lIG;
    private ImageView lIs;
    private RelativeLayout lIt;
    private VideoRecordButton lIu;
    private ImageView lIv;
    private long lIw;
    private boolean lIx;
    private List<ObjectAnimator> lIy;
    private a lIz;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface a {
        void dkA();

        void dkB();

        void dkC();

        void dkD();

        void dkE();

        void dkF();

        void dkG();

        void dkn();

        void dky();

        void dkz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.lIw = 0L;
        this.lIx = false;
        this.lIA = true;
        this.lIC = new ArrayList();
        this.lID = new ArrayList();
        this.lIE = new ArrayList();
        this.lIF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lIw = 0L;
        this.lIx = false;
        this.lIA = true;
        this.lIC = new ArrayList();
        this.lID = new ArrayList();
        this.lIE = new ArrayList();
        this.lIF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lIw = 0L;
        this.lIx = false;
        this.lIA = true;
        this.lIC = new ArrayList();
        this.lID = new ArrayList();
        this.lIE = new ArrayList();
        this.lIF = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.lIG = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.lIt = (RelativeLayout) findViewById(R.id.layout_record);
        this.lIs = (ImageView) findViewById(R.id.delete_video);
        this.lIs.setOnClickListener(this);
        this.lIu = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.lIu.setOnTouchListener(this);
        this.lIv = (ImageView) findViewById(R.id.confirm_video);
        this.lIv.setOnClickListener(this);
        this.lIF.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.lIF.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.lFO = iVar;
        Fj(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.lIG != null) {
            this.lIG.setListener(aVar);
        }
    }

    public void Fj(int i) {
        this.lFO.setStatus(i);
        if (this.lIz != null) {
            this.lIz.dkG();
        }
        if (i == 1) {
            this.lIs.setVisibility(8);
            this.lIv.setVisibility(8);
        } else if (i == 3) {
            this.lIs.setImageResource(R.drawable.video_back_selector);
            this.lIv.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.lIs.setImageResource(R.drawable.video_back_selector);
            this.lIv.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.lIs.setImageResource(R.drawable.video_delete_selector);
            if (this.lFO != null && this.lFO.getVideoDuration() >= 3000.0f) {
                this.lIv.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.lIv.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lIs) {
            if (this.lIz != null) {
                this.lIz.dkF();
            }
            int status = this.lFO.getStatus();
            if (this.lFO != null && this.lFO.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.lFO.dki();
                    eP(this.lIC);
                    eP(this.lID);
                    eP(this.lIE);
                    if (this.lFO.getVideoDuration() >= 3000.0f) {
                        Fj(4);
                        return;
                    } else {
                        Fj(this.lFO.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.lFO.dkh();
                Fj(5);
            }
        } else if (view == this.lIv) {
            TiebaStatic.log("c12300");
            if (this.lFO != null && this.lFO.getStatus() > 2 && this.lIz != null) {
                if (this.lFO.getVideoDuration() >= 3000.0f) {
                    this.lIz.dkD();
                } else {
                    this.lIz.dkE();
                }
            }
        }
    }

    private void eP(List list) {
        if (!v.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(final boolean z) {
        if (this.lFO.getProgress() >= 100) {
            if (this.lIz != null) {
                this.lIz.dkD();
                return;
            }
            return;
        }
        if (this.lIG.getCurrentBeautyItem() != null) {
            this.lIC.add(this.lIG.getCurrentBeautyItem());
        }
        if (this.lIG.getCurrentFilterItem() != null) {
            this.lID.add(this.lIG.getCurrentFilterItem());
        }
        if (this.lIG.getCurrentStickItem() != null) {
            this.lIE.add(this.lIG.getCurrentStickItem());
        }
        Fj(2);
        if (this.lIG.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.lFO.getStatus() == 6 || VideoControllerLayout.this.lFO.aXs()) {
                        VideoControllerLayout.this.vc(z);
                    }
                }
            });
        } else {
            vc(z);
        }
        if (this.lFO != null) {
            this.lFO.startRecord();
        }
        if (this.lIz != null) {
            this.lIz.dky();
        }
    }

    public void stopRecord() {
        dkK();
        int status = this.lFO.getStatus();
        if (this.lFO != null) {
            if (!this.lFO.btw() && this.lFO.aXs()) {
                this.lFO.stopRecord();
            }
            dkJ();
        }
        if (this.lIz != null) {
            this.lIz.dkn();
            if (status == 6) {
                this.lIz.dkA();
            }
        }
    }

    public void dkJ() {
        if (this.lFO != null) {
            if (this.lFO.getVideoDuration() >= 3000.0f) {
                Fj(4);
            } else if (this.lFO.getVideoDuration() > 0) {
                Fj(3);
            } else {
                Fj(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(boolean z) {
        if (this.lHI != null && this.lHI.isRunning()) {
            this.lHI.cancel();
        }
        if (this.lHH == null) {
            this.lHH = new AnimatorSet();
            this.lHH.playTogether(ObjectAnimator.ofFloat(this.lIs, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lIv, "alpha", 1.0f, 0.0f));
            this.lHH.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lJt) {
                        VideoControllerLayout.this.lIs.setVisibility(8);
                        VideoControllerLayout.this.lIv.setVisibility(8);
                    }
                }
            });
            this.lHH.setDuration(300L);
        }
        this.lHH.start();
        if (this.lFO.getStatus() != 6) {
            this.lIu.vc(z);
        }
    }

    public void dkK() {
        if (this.lFO == null || this.lFO.aXs() || this.lFO.getStatus() == 6) {
            if (this.lHH != null && this.lHH.isRunning()) {
                this.lHH.cancel();
            }
            if (this.lHI == null) {
                this.lHI = new AnimatorSet();
                this.lHI.playTogether(ObjectAnimator.ofFloat(this.lIs, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lIv, "alpha", 0.0f, 1.0f));
                this.lHI.setDuration(300L);
            }
            this.lIs.setVisibility(0);
            this.lIv.setVisibility(0);
            this.lHI.start();
            if (this.lFO.getStatus() != 7 && this.lFO.getStatus() != 6) {
                this.lIu.dkK();
                return;
            }
            this.lIu.getTvTip().setVisibility(8);
            if (this.hEW == 2) {
                this.lIu.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hEW) {
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
                if (this.lIz != null) {
                    this.lIz.dkF();
                }
                if (this.lFO.getStatus() != 7 && this.lFO.getStatus() != 6) {
                    if (this.lFO != null && this.lFO.dkg()) {
                        this.lIB = true;
                        com.baidu.tbadk.core.util.e.aUf().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.lIw = currentTimeMillis;
                    this.lIx = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.lIx && VideoControllerLayout.this.lIw == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.el(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.lIB) {
                    this.lIB = false;
                    return;
                }
                this.lIx = false;
                if (this.lFO.aXs() || this.lFO.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.lFO.getStatus() != 8) {
                    el(false);
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
                if (this.lFO.getStatus() == 6) {
                    this.lFO.setStatus(1);
                    if (this.lIz != null) {
                        this.lIz.dkA();
                        this.lIz.dkn();
                    }
                    this.lIu.getTvTip().setText("");
                    this.lIu.getTvTip().setVisibility(8);
                    return;
                } else if (this.lIG.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.lIz != null) {
                    this.lIz.dkz();
                    this.lIu.dkV();
                    return;
                } else {
                    return;
                }
            case 1:
                this.lIu.dkW();
                return;
            default:
                return;
        }
    }

    public void dkt() {
        if (this.lIG.getVisibility() == 0) {
            a((m) null);
        }
        vc(false);
        this.lIu.getLayer1().setVisibility(8);
        this.lIu.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.lIu.getTvTip().setVisibility(0);
        if (this.lIz != null) {
            this.lIz.dky();
        }
    }

    public void dkL() {
        if (this.lFO.getStatus() == 6) {
            if (this.hEW == 2) {
                Fj(7);
                this.lIu.setAlpha(1.0f);
                this.lIs.setVisibility(8);
                this.lIv.setVisibility(8);
                this.lIu.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.lFO != null) {
                    this.lFO.startRecord();
                    return;
                }
                return;
            }
            this.lIu.getTvTip().setVisibility(8);
            if (this.lIz != null) {
                this.lIz.dkz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dku() {
        if (dkO() && this.lIG.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dkO()) {
            dkN();
        }
        this.lIG.dku();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkv() {
        if (dkO() && this.lIG.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dkO()) {
            dkN();
        }
        this.lIG.dkv();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkw() {
        if (dkO() && this.lIG.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dkO()) {
            dkN();
        }
        this.lIG.dkw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkx() {
        if (dkO() && this.lIG.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dkO()) {
            dkN();
        }
        this.lIG.dkx();
    }

    private void dkM() {
        if (v.isEmpty(this.lIy)) {
            this.lIy = new ArrayList();
            this.lIy.add(ObjectAnimator.ofFloat(this.lIG, "translationY", 1000.0f, 0.0f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIt, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIu.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIu.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIu.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIu.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIv, "scaleX", 1.0f, 0.7f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIv, "scaleY", 1.0f, 0.7f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIs, "scaleX", 1.0f, 0.7f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIs, "scaleY", 1.0f, 0.7f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIv, "alpha", 1.0f, 0.0f));
            this.lIy.add(ObjectAnimator.ofFloat(this.lIs, "alpha", 1.0f, 0.0f));
        }
    }

    private void dkN() {
        int i = 0;
        if (this.lIG.getVisibility() != 0) {
            this.lIG.setVisibility(0);
            dkM();
            this.lIv.setEnabled(false);
            this.lIs.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.lIy.size()) {
                    ObjectAnimator objectAnimator = this.lIy.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lIy.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.lIz != null) {
                                        VideoControllerLayout.this.lIz.dkB();
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
        if (this.lIG.getVisibility() != 8) {
            dkM();
            this.lIv.setEnabled(true);
            this.lIs.setEnabled(true);
            if (this.lFO.getStatus() == 6 || this.lFO.aXs()) {
                this.lIs.setVisibility(8);
                this.lIv.setVisibility(8);
            } else {
                Fj(this.lFO.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.lIy.size()) {
                    ObjectAnimator objectAnimator = this.lIy.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.lIy.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.lJt) {
                                        VideoControllerLayout.this.lIG.setVisibility(8);
                                        if (VideoControllerLayout.this.lIz != null) {
                                            VideoControllerLayout.this.lIz.dkC();
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
        this.lIz = aVar;
    }

    public void setCurrentTab(int i) {
        this.hEW = i;
        switch (this.hEW) {
            case 1:
                this.lIs.setVisibility(4);
                this.lIv.setVisibility(4);
                this.lIu.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.lFO.getStatus() != 1) {
                    this.lIs.setVisibility(0);
                    this.lIv.setVisibility(0);
                }
                this.lIu.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dkO() {
        return this.lIG.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.lIG != null) {
            this.lIG.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.lIG != null) {
            this.lIG.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.lIG != null) {
            this.lIG.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dkP() {
        if (this.lIG != null) {
            return this.lIG.dkP();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.lIA = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.lIC;
    }

    public List<e> getChoosedFilterList() {
        return this.lID;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.lIE;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.lIF.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.lIG != null) {
            this.lIG.setMusicList(this.lIF);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dkQ() {
        if (this.lIG != null) {
            this.lIG.dkQ();
        }
    }

    public void djE() {
        if (this.lIG != null) {
            this.lIG.djE();
        }
    }
}
