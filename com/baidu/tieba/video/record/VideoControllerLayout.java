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
    private ImageView gAX;
    private RelativeLayout gAY;
    private VideoRecordButton gAZ;
    private i gAf;
    private AnimatorSet gAt;
    private AnimatorSet gAu;
    private ImageView gBa;
    private View gBb;
    private float gBc;
    private long gBd;
    private boolean gBe;
    private List<ObjectAnimator> gBf;
    private a gBg;
    private boolean gBh;
    private List<d> gBi;
    private List<d> gBj;
    private List<StickerItem> gBk;
    private VideoEffectLayout gBl;
    private Runnable gBm;
    private String guZ;
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

        void bxz();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gBd = 0L;
        this.gBe = false;
        this.gBh = true;
        this.gBi = new ArrayList();
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.mHandler = new Handler();
        this.gBm = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAf.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gAZ.setAlpha(1.0f);
                    VideoControllerLayout.this.gAX.setVisibility(8);
                    VideoControllerLayout.this.gBa.setVisibility(8);
                    VideoControllerLayout.this.gAZ.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAf != null) {
                        VideoControllerLayout.this.gAf.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBd = 0L;
        this.gBe = false;
        this.gBh = true;
        this.gBi = new ArrayList();
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.mHandler = new Handler();
        this.gBm = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAf.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gAZ.setAlpha(1.0f);
                    VideoControllerLayout.this.gAX.setVisibility(8);
                    VideoControllerLayout.this.gBa.setVisibility(8);
                    VideoControllerLayout.this.gAZ.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAf != null) {
                        VideoControllerLayout.this.gAf.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gBd = 0L;
        this.gBe = false;
        this.gBh = true;
        this.gBi = new ArrayList();
        this.gBj = new ArrayList();
        this.gBk = new ArrayList();
        this.mHandler = new Handler();
        this.gBm = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gAf.getStatus() == 6) {
                    VideoControllerLayout.this.uG(7);
                    VideoControllerLayout.this.gAZ.setAlpha(1.0f);
                    VideoControllerLayout.this.gAX.setVisibility(8);
                    VideoControllerLayout.this.gBa.setVisibility(8);
                    VideoControllerLayout.this.gAZ.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gAf != null) {
                        VideoControllerLayout.this.gAf.startRecord();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.record_controller_layout, this);
        this.gBl = (VideoEffectLayout) findViewById(d.h.layout_effect);
        this.gAY = (RelativeLayout) findViewById(d.h.layout_record);
        this.gAX = (ImageView) findViewById(d.h.delete_video);
        this.gAX.setOnClickListener(this);
        this.gAZ = (VideoRecordButton) findViewById(d.h.layout_record_button);
        this.gAZ.setOnTouchListener(this);
        this.gBa = (ImageView) findViewById(d.h.confirm_video);
        this.gBa.setOnClickListener(this);
        this.gBb = findViewById(d.h.drag_up_tips_layout);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoControllerLayout.this.mPosY = motionEvent.getY();
                        if (VideoControllerLayout.this.gBg != null) {
                            VideoControllerLayout.this.gBg.bxF();
                            break;
                        }
                        break;
                    case 1:
                        if (VideoControllerLayout.this.gBc - VideoControllerLayout.this.mPosY < 0.0f && Math.abs(VideoControllerLayout.this.gBc - VideoControllerLayout.this.mPosY) > 25.0f && VideoControllerLayout.this.gAf.getStatus() == 1) {
                            TiebaStatic.log("c12296");
                            if (VideoControllerLayout.this.gBh) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(VideoControllerLayout.this.getContext(), VideoControllerLayout.this.mForumId, VideoControllerLayout.this.mForumName, VideoControllerLayout.this.guZ)));
                                break;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), d.l.no_local_video_tip);
                                break;
                            }
                        }
                        break;
                    case 2:
                        VideoControllerLayout.this.gBc = motionEvent.getY();
                        break;
                }
                return true;
            }
        });
    }

    public void setRecordController(i iVar) {
        this.gAf = iVar;
        uG(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gBl != null) {
            this.gBl.setListener(aVar);
        }
    }

    public void uG(int i) {
        this.gAf.setStatus(i);
        if (i == 1) {
            this.gBb.setVisibility(0);
            this.gAX.setVisibility(8);
            this.gBa.setVisibility(8);
            return;
        }
        this.gBb.setVisibility(8);
        if (i == 3) {
            this.gAX.setImageResource(d.g.video_back_selector);
            this.gBa.setImageResource(d.g.icon_video_confirm_d);
        } else if (i == 4) {
            this.gAX.setImageResource(d.g.video_back_selector);
            this.gBa.setImageResource(d.g.video_confirm_selector);
        } else if (i == 5) {
            this.gAX.setImageResource(d.g.video_delete_selector);
            if (this.gAf != null && this.gAf.getVideoDuration() >= 3000.0f) {
                this.gBa.setImageResource(d.g.video_confirm_selector);
            } else {
                this.gBa.setImageResource(d.g.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBb) {
            TiebaStatic.log("c12296");
            if (this.gBg != null) {
                this.gBg.bxF();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(getContext())));
        } else if (view == this.gAX) {
            if (this.gBg != null) {
                this.gBg.bxF();
            }
            int status = this.gAf.getStatus();
            if (this.gAf != null && this.gAf.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gAf.bxr();
                    dD(this.gBi);
                    dD(this.gBj);
                    dD(this.gBk);
                    if (this.gAf.getVideoDuration() >= 3000.0f) {
                        uG(4);
                        return;
                    } else {
                        uG(this.gAf.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gAf.bxq();
                uG(5);
            }
        } else if (view == this.gBa) {
            TiebaStatic.log("c12300");
            if (this.gAf != null && this.gAf.getStatus() > 2 && this.gBg != null) {
                if (this.gAf.getVideoDuration() >= 3000.0f) {
                    this.gBg.bxD();
                } else {
                    this.gBg.bxE();
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
        if (this.gAf.getProgress() >= 100) {
            if (this.gBg != null) {
                this.gBg.bxD();
                return;
            }
            return;
        }
        if (this.gBl.getCurrentBeautyItem() != null) {
            this.gBi.add(this.gBl.getCurrentBeautyItem());
        }
        if (this.gBl.getCurrentFilterItem() != null) {
            this.gBj.add(this.gBl.getCurrentFilterItem());
        }
        if (this.gBl.getCurrentStickItem() != null) {
            this.gBk.add(this.gBl.getCurrentStickItem());
        }
        uG(2);
        if (this.gBl.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gAf.getStatus() == 6) {
                        VideoControllerLayout.this.bxI();
                    }
                }
            });
        } else {
            bxI();
        }
        if (this.gAf != null) {
            this.gAf.startRecord();
        }
        if (this.gBg != null) {
            this.gBg.bxz();
        }
    }

    public void stopRecord() {
        bxJ();
        int status = this.gAf.getStatus();
        if (this.gAf != null) {
            if (this.gAf.getStatus() != 6 && this.gAf.isRecording()) {
                this.gAf.stopRecord();
            }
            if (this.gAf.getVideoDuration() >= 3000.0f) {
                uG(4);
            } else if (this.gAf.getVideoDuration() > 0) {
                uG(3);
            } else {
                uG(1);
            }
        }
        if (this.gBg != null) {
            if (status == 6) {
                this.gBg.bxB();
                bxK();
            }
            this.gBg.bxA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
        if (this.gAu != null && this.gAu.isRunning()) {
            this.gAu.cancel();
        }
        if (this.gAt == null) {
            this.gAt = new AnimatorSet();
            this.gAt.playTogether(ObjectAnimator.ofFloat(this.gAX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gBa, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gBb, "alpha", 1.0f, 0.0f));
            this.gAt.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBP) {
                        VideoControllerLayout.this.gAX.setVisibility(8);
                        VideoControllerLayout.this.gBa.setVisibility(8);
                        VideoControllerLayout.this.gBb.setVisibility(8);
                    }
                }
            });
            this.gAt.setDuration(300L);
        }
        this.gAt.start();
        if (this.gAf.getStatus() != 6) {
            this.gAZ.bxI();
        }
    }

    public void bxJ() {
        if (this.gAf == null || this.gAf.isRecording() || this.gAf.getStatus() == 6) {
            if (this.gAt != null && this.gAt.isRunning()) {
                this.gAt.cancel();
            }
            if (this.gAu == null) {
                this.gAu = new AnimatorSet();
                this.gAu.playTogether(ObjectAnimator.ofFloat(this.gAX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gBa, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gBb, "alpha", 0.0f, 1.0f));
                this.gAu.setDuration(300L);
            }
            this.gAX.setVisibility(0);
            this.gBa.setVisibility(0);
            this.gAu.start();
            if (this.gAf.getStatus() != 7 && this.gAf.getStatus() != 6) {
                this.gAZ.bxJ();
            } else {
                this.gAZ.getTvTip().setText(getResources().getText(d.l.video_record_button_press));
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gBg != null) {
                    this.gBg.bxF();
                }
                if (this.gAf.getStatus() != 7 && this.gAf.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gBd = currentTimeMillis;
                    this.gBe = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gBe && VideoControllerLayout.this.gBd == currentTimeMillis) {
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
                this.gBe = false;
                if (this.gAf.isRecording() || this.gAf.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    if (this.gAf.getStatus() == 6) {
                        bxK();
                    }
                    stopRecord();
                    break;
                } else if (this.gBl.getVisibility() == 0) {
                    a((m) null);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxv() {
        if (this.gBl.getVisibility() == 0) {
            a((m) null);
        }
        bxI();
        this.gAZ.getTvTip().setText(getResources().getText(d.l.video_record_button_cancel));
        this.gAZ.getTvTip().setVisibility(0);
        if (this.gBg != null) {
            this.gBg.bxz();
        }
        this.mHandler.removeCallbacks(this.gBm);
        this.mHandler.postDelayed(this.gBm, 3000L);
    }

    public void bxK() {
        this.mHandler.removeCallbacks(this.gBm);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
        if (bxN() && this.gBl.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bxN()) {
            bxM();
        }
        this.gBl.bxw();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        if (bxN() && this.gBl.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bxN()) {
            bxM();
        }
        this.gBl.bxx();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        if (bxN() && this.gBl.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bxN()) {
            bxM();
        }
        this.gBl.bxy();
    }

    private void bxL() {
        if (v.u(this.gBf)) {
            this.gBf = new ArrayList();
            this.gBf.add(ObjectAnimator.ofFloat(this.gBl, "translationY", 1000.0f, 0.0f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAY, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.f.ds100)));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getLayer1(), "scaleX", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getLayer1(), "scaleY", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getLayer2(), "scaleX", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getLayer2(), "scaleY", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getTvTip(), "scaleX", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getTvTip(), "scaleY", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAZ.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gBa, "scaleX", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gBa, "scaleY", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAX, "scaleX", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAX, "scaleY", 1.0f, 0.7f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gBa, "alpha", 1.0f, 0.0f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gAX, "alpha", 1.0f, 0.0f));
            this.gBf.add(ObjectAnimator.ofFloat(this.gBb, "alpha", 1.0f, 0.0f));
        }
    }

    private void bxM() {
        int i = 0;
        if (this.gBl.getVisibility() != 0) {
            this.gBl.setVisibility(0);
            bxL();
            this.gBa.setEnabled(false);
            this.gAX.setEnabled(false);
            this.gBb.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gBf.size()) {
                    ObjectAnimator objectAnimator = this.gBf.get(i2);
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
        if (this.gBl.getVisibility() != 8) {
            bxL();
            this.gBa.setEnabled(true);
            this.gAX.setEnabled(true);
            this.gBb.setEnabled(true);
            if (this.gAf.getStatus() == 6 || this.gAf.isRecording()) {
                this.gBb.setVisibility(8);
                this.gAX.setVisibility(8);
                this.gBa.setVisibility(8);
                this.gAZ.getTvTip().setVisibility(8);
            } else {
                uG(this.gAf.getStatus());
                this.gAZ.getTvTip().setVisibility(0);
            }
            while (true) {
                int i2 = i;
                if (i2 < this.gBf.size()) {
                    ObjectAnimator objectAnimator = this.gBf.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gBf.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.6
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    VideoControllerLayout.this.gBl.setVisibility(8);
                                    if (VideoControllerLayout.this.gBg != null) {
                                        VideoControllerLayout.this.gBg.bxC();
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
        this.gBg = aVar;
    }

    public boolean bxN() {
        return this.gBl.getVisibility() == 0;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setVideoTitle(String str) {
        this.guZ = str;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gBl != null) {
            this.gBl.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gBl != null) {
            this.gBl.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gBl != null) {
            this.gBl.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bxO() {
        if (this.gBl != null) {
            return this.gBl.bxO();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gBh = z;
    }

    public List<d> getChoosedBeautyList() {
        return this.gBi;
    }

    public List<d> getChoosedFilterList() {
        return this.gBj;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gBk;
    }
}
