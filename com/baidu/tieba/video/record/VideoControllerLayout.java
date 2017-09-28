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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LocalVideoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, VideoEffectButtonLayout.a {
    private ImageView gAY;
    private RelativeLayout gAZ;
    private i gAg;
    private AnimatorSet gAu;
    private AnimatorSet gAv;
    private VideoRecordButton gBa;
    private ImageView gBb;
    private View gBc;
    private float gBd;
    private long gBe;
    private boolean gBf;
    private List<ObjectAnimator> gBg;
    private a gBh;
    private boolean gBi;
    private List<d> gBj;
    private List<d> gBk;
    private List<StickerItem> gBl;
    private VideoEffectLayout gBm;
    private Runnable gBn;
    private String gva;
    private String mForumId;
    private String mForumName;
    private Handler mHandler;
    private float mPosY;

    /* loaded from: classes2.dex */
    public interface a {
        void bxA();

        void bxB();

        void bxC();

        void bxD();

        void bxE();

        void bxF();

        void bxG();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gBe = 0L;
        this.gBf = false;
        this.gBi = true;
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.gBl = new ArrayList();
        this.mHandler = new Handler();
        this.gBn = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAg.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gBa.setAlpha(1.0f);
                    VideoControllerLayout.this.gAY.setVisibility(8);
                    VideoControllerLayout.this.gBb.setVisibility(8);
                    VideoControllerLayout.this.gBa.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAg != null) {
                        VideoControllerLayout.this.gAg.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBe = 0L;
        this.gBf = false;
        this.gBi = true;
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.gBl = new ArrayList();
        this.mHandler = new Handler();
        this.gBn = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAg.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gBa.setAlpha(1.0f);
                    VideoControllerLayout.this.gAY.setVisibility(8);
                    VideoControllerLayout.this.gBb.setVisibility(8);
                    VideoControllerLayout.this.gBa.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAg != null) {
                        VideoControllerLayout.this.gAg.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBe = 0L;
        this.gBf = false;
        this.gBi = true;
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.gBl = new ArrayList();
        this.mHandler = new Handler();
        this.gBn = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAg.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gBa.setAlpha(1.0f);
                    VideoControllerLayout.this.gAY.setVisibility(8);
                    VideoControllerLayout.this.gBb.setVisibility(8);
                    VideoControllerLayout.this.gBa.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAg != null) {
                        VideoControllerLayout.this.gAg.startRecord();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.record_controller_layout, this);
        this.gBm = (VideoEffectLayout) findViewById(d.h.layout_effect);
        this.gAZ = (RelativeLayout) findViewById(d.h.layout_record);
        this.gAY = (ImageView) findViewById(d.h.delete_video);
        this.gAY.setOnClickListener(this);
        this.gBa = (VideoRecordButton) findViewById(d.h.layout_record_button);
        this.gBa.setOnTouchListener(this);
        this.gBb = (ImageView) findViewById(d.h.confirm_video);
        this.gBb.setOnClickListener(this);
        this.gBc = findViewById(d.h.drag_up_tips_layout);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoControllerLayout.this.mPosY = motionEvent.getY();
                        if (VideoControllerLayout.this.gBh != null) {
                            VideoControllerLayout.this.gBh.bxG();
                            break;
                        }
                        break;
                    case 1:
                        if (VideoControllerLayout.this.gBd - VideoControllerLayout.this.mPosY < 0.0f && Math.abs(VideoControllerLayout.this.gBd - VideoControllerLayout.this.mPosY) > 25.0f && VideoControllerLayout.this.gAg.getStatus() == 1) {
                            TiebaStatic.log("c12296");
                            if (VideoControllerLayout.this.gBi) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(VideoControllerLayout.this.getContext(), VideoControllerLayout.this.mForumId, VideoControllerLayout.this.mForumName, VideoControllerLayout.this.gva)));
                                break;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), d.l.no_local_video_tip);
                                break;
                            }
                        }
                        break;
                    case 2:
                        VideoControllerLayout.this.gBd = motionEvent.getY();
                        break;
                }
                return true;
            }
        });
    }

    public void setRecordController(i iVar) {
        this.gAg = iVar;
        uG(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gBm != null) {
            this.gBm.setListener(aVar);
        }
    }

    public void uG(int i) {
        this.gAg.setStatus(i);
        if (i == 1) {
            this.gBc.setVisibility(0);
            this.gAY.setVisibility(8);
            this.gBb.setVisibility(8);
            return;
        }
        this.gBc.setVisibility(8);
        if (i == 3) {
            this.gAY.setImageResource(d.g.video_back_selector);
            this.gBb.setImageResource(d.g.icon_video_confirm_d);
        } else if (i == 4) {
            this.gAY.setImageResource(d.g.video_back_selector);
            this.gBb.setImageResource(d.g.video_confirm_selector);
        } else if (i == 5) {
            this.gAY.setImageResource(d.g.video_delete_selector);
            if (this.gAg != null && this.gAg.getVideoDuration() >= 3000.0f) {
                this.gBb.setImageResource(d.g.video_confirm_selector);
            } else {
                this.gBb.setImageResource(d.g.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBc) {
            TiebaStatic.log("c12296");
            if (this.gBh != null) {
                this.gBh.bxG();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(getContext())));
        } else if (view == this.gAY) {
            if (this.gBh != null) {
                this.gBh.bxG();
            }
            int status = this.gAg.getStatus();
            if (this.gAg != null && this.gAg.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gAg.bxs();
                    dD(this.gBj);
                    dD(this.gBk);
                    dD(this.gBl);
                    if (this.gAg.getVideoDuration() >= 3000.0f) {
                        uG(4);
                        return;
                    } else {
                        uG(this.gAg.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gAg.bxr();
                uG(5);
            }
        } else if (view == this.gBb) {
            TiebaStatic.log("c12300");
            if (this.gAg != null && this.gAg.getStatus() > 2 && this.gBh != null) {
                if (this.gAg.getVideoDuration() >= 3000.0f) {
                    this.gBh.bxE();
                } else {
                    this.gBh.bxF();
                }
            }
        }
    }

    private void dD(List list) {
        if (!v.u(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (this.gAg.getProgress() >= 100) {
            if (this.gBh != null) {
                this.gBh.bxE();
                return;
            }
            return;
        }
        if (this.gBm.getCurrentBeautyItem() != null) {
            this.gBj.add(this.gBm.getCurrentBeautyItem());
        }
        if (this.gBm.getCurrentFilterItem() != null) {
            this.gBk.add(this.gBm.getCurrentFilterItem());
        }
        if (this.gBm.getCurrentStickItem() != null) {
            this.gBl.add(this.gBm.getCurrentStickItem());
        }
        uG(2);
        if (this.gBm.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gAg.getStatus() == 6) {
                        VideoControllerLayout.this.bxJ();
                    }
                }
            });
        } else {
            bxJ();
        }
        if (this.gAg != null) {
            this.gAg.startRecord();
        }
        if (this.gBh != null) {
            this.gBh.bxA();
        }
    }

    public void stopRecord() {
        bxK();
        int status = this.gAg.getStatus();
        if (this.gAg != null) {
            if (this.gAg.getStatus() != 6 && this.gAg.isRecording()) {
                this.gAg.stopRecord();
            }
            if (this.gAg.getVideoDuration() >= 3000.0f) {
                uG(4);
            } else if (this.gAg.getVideoDuration() > 0) {
                uG(3);
            } else {
                uG(1);
            }
        }
        if (this.gBh != null) {
            if (status == 6) {
                this.gBh.bxC();
                bxL();
            }
            this.gBh.bxB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxJ() {
        if (this.gAv != null && this.gAv.isRunning()) {
            this.gAv.cancel();
        }
        if (this.gAu == null) {
            this.gAu = new AnimatorSet();
            this.gAu.playTogether(ObjectAnimator.ofFloat(this.gAY, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gBb, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gBc, "alpha", 1.0f, 0.0f));
            this.gAu.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBQ) {
                        VideoControllerLayout.this.gAY.setVisibility(8);
                        VideoControllerLayout.this.gBb.setVisibility(8);
                        VideoControllerLayout.this.gBc.setVisibility(8);
                    }
                }
            });
            this.gAu.setDuration(300L);
        }
        this.gAu.start();
        if (this.gAg.getStatus() != 6) {
            this.gBa.bxJ();
        }
    }

    public void bxK() {
        if (this.gAg == null || this.gAg.isRecording() || this.gAg.getStatus() == 6) {
            if (this.gAu != null && this.gAu.isRunning()) {
                this.gAu.cancel();
            }
            if (this.gAv == null) {
                this.gAv = new AnimatorSet();
                this.gAv.playTogether(ObjectAnimator.ofFloat(this.gAY, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gBb, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gBc, "alpha", 0.0f, 1.0f));
                this.gAv.setDuration(300L);
            }
            this.gAY.setVisibility(0);
            this.gBb.setVisibility(0);
            this.gAv.start();
            if (this.gAg.getStatus() != 7 && this.gAg.getStatus() != 6) {
                this.gBa.bxK();
            } else {
                this.gBa.getTvTip().setText(getResources().getText(d.l.video_record_button_press));
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gBh != null) {
                    this.gBh.bxG();
                }
                if (this.gAg.getStatus() != 7 && this.gAg.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gBe = currentTimeMillis;
                    this.gBf = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gBf && VideoControllerLayout.this.gBe == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.startRecord();
                            }
                        }
                    }, 200L);
                    break;
                }
                break;
            case 1:
            case 3:
                this.gBf = false;
                if (this.gAg.isRecording() || this.gAg.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    if (this.gAg.getStatus() == 6) {
                        bxL();
                    }
                    stopRecord();
                    break;
                } else if (this.gBm.getVisibility() == 0) {
                    a((m) null);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
        if (this.gBm.getVisibility() == 0) {
            a((m) null);
        }
        bxJ();
        this.gBa.getTvTip().setText(getResources().getText(d.l.video_record_button_cancel));
        this.gBa.getTvTip().setVisibility(0);
        if (this.gBh != null) {
            this.gBh.bxA();
        }
        this.mHandler.removeCallbacks(this.gBn);
        this.mHandler.postDelayed(this.gBn, 3000L);
    }

    public void bxL() {
        this.mHandler.removeCallbacks(this.gBn);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        if (bxO() && this.gBm.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bxO()) {
            bxN();
        }
        this.gBm.bxx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        if (bxO() && this.gBm.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bxO()) {
            bxN();
        }
        this.gBm.bxy();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxz() {
        if (bxO() && this.gBm.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bxO()) {
            bxN();
        }
        this.gBm.bxz();
    }

    private void bxM() {
        if (v.u(this.gBg)) {
            this.gBg = new ArrayList();
            this.gBg.add(ObjectAnimator.ofFloat(this.gBm, "translationY", 1000.0f, 0.0f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gAZ, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.f.ds100)));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getLayer1(), "scaleX", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getLayer1(), "scaleY", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getLayer2(), "scaleX", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getLayer2(), "scaleY", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getTvTip(), "scaleX", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getTvTip(), "scaleY", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBa.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBb, "scaleX", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBb, "scaleY", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gAY, "scaleX", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gAY, "scaleY", 1.0f, 0.7f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBb, "alpha", 1.0f, 0.0f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gAY, "alpha", 1.0f, 0.0f));
            this.gBg.add(ObjectAnimator.ofFloat(this.gBc, "alpha", 1.0f, 0.0f));
        }
    }

    private void bxN() {
        int i = 0;
        if (this.gBm.getVisibility() != 0) {
            this.gBm.setVisibility(0);
            bxM();
            this.gBb.setEnabled(false);
            this.gAY.setEnabled(false);
            this.gBc.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gBg.size()) {
                    ObjectAnimator objectAnimator = this.gBg.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        objectAnimator.start();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(final m mVar) {
        int i = 0;
        if (this.gBm.getVisibility() != 8) {
            bxM();
            this.gBb.setEnabled(true);
            this.gAY.setEnabled(true);
            this.gBc.setEnabled(true);
            if (this.gAg.getStatus() == 6 || this.gAg.isRecording()) {
                this.gBc.setVisibility(8);
                this.gAY.setVisibility(8);
                this.gBb.setVisibility(8);
                this.gBa.getTvTip().setVisibility(8);
            } else {
                uG(this.gAg.getStatus());
                this.gBa.getTvTip().setVisibility(0);
            }
            while (true) {
                int i2 = i;
                if (i2 < this.gBg.size()) {
                    ObjectAnimator objectAnimator = this.gBg.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gBg.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.6
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    VideoControllerLayout.this.gBm.setVisibility(8);
                                    if (VideoControllerLayout.this.gBh != null) {
                                        VideoControllerLayout.this.gBh.bxD();
                                    }
                                    if (mVar != null) {
                                        mVar.onAnimationEnd(animator);
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
        this.gBh = aVar;
    }

    public boolean bxO() {
        return this.gBm.getVisibility() == 0;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setVideoTitle(String str) {
        this.gva = str;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gBm != null) {
            this.gBm.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gBm != null) {
            this.gBm.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gBm != null) {
            this.gBm.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bxP() {
        if (this.gBm != null) {
            return this.gBm.bxP();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gBi = z;
    }

    public List<d> getChoosedBeautyList() {
        return this.gBj;
    }

    public List<d> getChoosedFilterList() {
        return this.gBk;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gBl;
    }
}
