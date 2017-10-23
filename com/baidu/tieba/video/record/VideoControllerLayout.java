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
    private ImageView gAI;
    private RelativeLayout gAJ;
    private VideoRecordButton gAK;
    private ImageView gAL;
    private View gAM;
    private float gAN;
    private long gAO;
    private boolean gAP;
    private List<ObjectAnimator> gAQ;
    private a gAR;
    private boolean gAS;
    private List<d> gAT;
    private List<d> gAU;
    private List<StickerItem> gAV;
    private VideoEffectLayout gAW;
    private Runnable gAX;
    private AnimatorSet gAe;
    private AnimatorSet gAf;
    private String guL;
    private i gzQ;
    private String mForumId;
    private String mForumName;
    private Handler mHandler;
    private float mPosY;

    /* loaded from: classes2.dex */
    public interface a {
        void bxr();

        void bxs();

        void bxt();

        void bxu();

        void bxv();

        void bxw();

        void bxx();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gAO = 0L;
        this.gAP = false;
        this.gAS = true;
        this.gAT = new ArrayList();
        this.gAU = new ArrayList();
        this.gAV = new ArrayList();
        this.mHandler = new Handler();
        this.gAX = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gzQ.getStatus() == 6) {
                    VideoControllerLayout.this.uF(7);
                    VideoControllerLayout.this.gAK.setAlpha(1.0f);
                    VideoControllerLayout.this.gAI.setVisibility(8);
                    VideoControllerLayout.this.gAL.setVisibility(8);
                    VideoControllerLayout.this.gAK.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gzQ != null) {
                        VideoControllerLayout.this.gzQ.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAO = 0L;
        this.gAP = false;
        this.gAS = true;
        this.gAT = new ArrayList();
        this.gAU = new ArrayList();
        this.gAV = new ArrayList();
        this.mHandler = new Handler();
        this.gAX = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gzQ.getStatus() == 6) {
                    VideoControllerLayout.this.uF(7);
                    VideoControllerLayout.this.gAK.setAlpha(1.0f);
                    VideoControllerLayout.this.gAI.setVisibility(8);
                    VideoControllerLayout.this.gAL.setVisibility(8);
                    VideoControllerLayout.this.gAK.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gzQ != null) {
                        VideoControllerLayout.this.gzQ.startRecord();
                    }
                }
            }
        };
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAO = 0L;
        this.gAP = false;
        this.gAS = true;
        this.gAT = new ArrayList();
        this.gAU = new ArrayList();
        this.gAV = new ArrayList();
        this.mHandler = new Handler();
        this.gAX = new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoControllerLayout.this.gzQ.getStatus() == 6) {
                    VideoControllerLayout.this.uF(7);
                    VideoControllerLayout.this.gAK.setAlpha(1.0f);
                    VideoControllerLayout.this.gAI.setVisibility(8);
                    VideoControllerLayout.this.gAL.setVisibility(8);
                    VideoControllerLayout.this.gAK.getTvTip().setText(VideoControllerLayout.this.getResources().getText(d.l.video_record_button_pasue));
                    if (VideoControllerLayout.this.gzQ != null) {
                        VideoControllerLayout.this.gzQ.startRecord();
                    }
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.j.record_controller_layout, this);
        this.gAW = (VideoEffectLayout) findViewById(d.h.layout_effect);
        this.gAJ = (RelativeLayout) findViewById(d.h.layout_record);
        this.gAI = (ImageView) findViewById(d.h.delete_video);
        this.gAI.setOnClickListener(this);
        this.gAK = (VideoRecordButton) findViewById(d.h.layout_record_button);
        this.gAK.setOnTouchListener(this);
        this.gAL = (ImageView) findViewById(d.h.confirm_video);
        this.gAL.setOnClickListener(this);
        this.gAM = findViewById(d.h.drag_up_tips_layout);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoControllerLayout.this.mPosY = motionEvent.getY();
                        if (VideoControllerLayout.this.gAR != null) {
                            VideoControllerLayout.this.gAR.bxx();
                            break;
                        }
                        break;
                    case 1:
                        if (VideoControllerLayout.this.gAN - VideoControllerLayout.this.mPosY < 0.0f && Math.abs(VideoControllerLayout.this.gAN - VideoControllerLayout.this.mPosY) > 25.0f && VideoControllerLayout.this.gzQ.getStatus() == 1) {
                            TiebaStatic.log("c12296");
                            if (VideoControllerLayout.this.gAS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(VideoControllerLayout.this.getContext(), VideoControllerLayout.this.mForumId, VideoControllerLayout.this.mForumName, VideoControllerLayout.this.guL)));
                                break;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), d.l.no_local_video_tip);
                                break;
                            }
                        }
                        break;
                    case 2:
                        VideoControllerLayout.this.gAN = motionEvent.getY();
                        break;
                }
                return true;
            }
        });
    }

    public void setRecordController(i iVar) {
        this.gzQ = iVar;
        uF(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gAW != null) {
            this.gAW.setListener(aVar);
        }
    }

    public void uF(int i) {
        this.gzQ.setStatus(i);
        if (i == 1) {
            this.gAM.setVisibility(0);
            this.gAI.setVisibility(8);
            this.gAL.setVisibility(8);
            return;
        }
        this.gAM.setVisibility(8);
        if (i == 3) {
            this.gAI.setImageResource(d.g.video_back_selector);
            this.gAL.setImageResource(d.g.icon_video_confirm_d);
        } else if (i == 4) {
            this.gAI.setImageResource(d.g.video_back_selector);
            this.gAL.setImageResource(d.g.video_confirm_selector);
        } else if (i == 5) {
            this.gAI.setImageResource(d.g.video_delete_selector);
            if (this.gzQ != null && this.gzQ.getVideoDuration() >= 3000.0f) {
                this.gAL.setImageResource(d.g.video_confirm_selector);
            } else {
                this.gAL.setImageResource(d.g.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gAM) {
            TiebaStatic.log("c12296");
            if (this.gAR != null) {
                this.gAR.bxx();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(getContext())));
        } else if (view == this.gAI) {
            if (this.gAR != null) {
                this.gAR.bxx();
            }
            int status = this.gzQ.getStatus();
            if (this.gzQ != null && this.gzQ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gzQ.bxj();
                    dD(this.gAT);
                    dD(this.gAU);
                    dD(this.gAV);
                    if (this.gzQ.getVideoDuration() >= 3000.0f) {
                        uF(4);
                        return;
                    } else {
                        uF(this.gzQ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gzQ.bxi();
                uF(5);
            }
        } else if (view == this.gAL) {
            TiebaStatic.log("c12300");
            if (this.gzQ != null && this.gzQ.getStatus() > 2 && this.gAR != null) {
                if (this.gzQ.getVideoDuration() >= 3000.0f) {
                    this.gAR.bxv();
                } else {
                    this.gAR.bxw();
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
        if (this.gzQ.getProgress() >= 100) {
            if (this.gAR != null) {
                this.gAR.bxv();
                return;
            }
            return;
        }
        if (this.gAW.getCurrentBeautyItem() != null) {
            this.gAT.add(this.gAW.getCurrentBeautyItem());
        }
        if (this.gAW.getCurrentFilterItem() != null) {
            this.gAU.add(this.gAW.getCurrentFilterItem());
        }
        if (this.gAW.getCurrentStickItem() != null) {
            this.gAV.add(this.gAW.getCurrentStickItem());
        }
        uF(2);
        if (this.gAW.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gzQ.getStatus() == 6) {
                        VideoControllerLayout.this.bxA();
                    }
                }
            });
        } else {
            bxA();
        }
        if (this.gzQ != null) {
            this.gzQ.startRecord();
        }
        if (this.gAR != null) {
            this.gAR.bxr();
        }
    }

    public void stopRecord() {
        bxB();
        int status = this.gzQ.getStatus();
        if (this.gzQ != null) {
            if (this.gzQ.getStatus() != 6 && this.gzQ.isRecording()) {
                this.gzQ.stopRecord();
            }
            if (this.gzQ.getVideoDuration() >= 3000.0f) {
                uF(4);
            } else if (this.gzQ.getVideoDuration() > 0) {
                uF(3);
            } else {
                uF(1);
            }
        }
        if (this.gAR != null) {
            if (status == 6) {
                this.gAR.bxt();
                bxC();
            }
            this.gAR.bxs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxA() {
        if (this.gAf != null && this.gAf.isRunning()) {
            this.gAf.cancel();
        }
        if (this.gAe == null) {
            this.gAe = new AnimatorSet();
            this.gAe.playTogether(ObjectAnimator.ofFloat(this.gAI, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAM, "alpha", 1.0f, 0.0f));
            this.gAe.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBA) {
                        VideoControllerLayout.this.gAI.setVisibility(8);
                        VideoControllerLayout.this.gAL.setVisibility(8);
                        VideoControllerLayout.this.gAM.setVisibility(8);
                    }
                }
            });
            this.gAe.setDuration(300L);
        }
        this.gAe.start();
        if (this.gzQ.getStatus() != 6) {
            this.gAK.bxA();
        }
    }

    public void bxB() {
        if (this.gzQ == null || this.gzQ.isRecording() || this.gzQ.getStatus() == 6) {
            if (this.gAe != null && this.gAe.isRunning()) {
                this.gAe.cancel();
            }
            if (this.gAf == null) {
                this.gAf = new AnimatorSet();
                this.gAf.playTogether(ObjectAnimator.ofFloat(this.gAI, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAM, "alpha", 0.0f, 1.0f));
                this.gAf.setDuration(300L);
            }
            this.gAI.setVisibility(0);
            this.gAL.setVisibility(0);
            this.gAf.start();
            if (this.gzQ.getStatus() != 7 && this.gzQ.getStatus() != 6) {
                this.gAK.bxB();
            } else {
                this.gAK.getTvTip().setText(getResources().getText(d.l.video_record_button_press));
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gAR != null) {
                    this.gAR.bxx();
                }
                if (this.gzQ.getStatus() != 7 && this.gzQ.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gAO = currentTimeMillis;
                    this.gAP = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gAP && VideoControllerLayout.this.gAO == currentTimeMillis) {
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
                this.gAP = false;
                if (this.gzQ.isRecording() || this.gzQ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    if (this.gzQ.getStatus() == 6) {
                        bxC();
                    }
                    stopRecord();
                    break;
                } else if (this.gAW.getVisibility() == 0) {
                    a((m) null);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxn() {
        if (this.gAW.getVisibility() == 0) {
            a((m) null);
        }
        bxA();
        this.gAK.getTvTip().setText(getResources().getText(d.l.video_record_button_cancel));
        this.gAK.getTvTip().setVisibility(0);
        if (this.gAR != null) {
            this.gAR.bxr();
        }
        this.mHandler.removeCallbacks(this.gAX);
        this.mHandler.postDelayed(this.gAX, 3000L);
    }

    public void bxC() {
        this.mHandler.removeCallbacks(this.gAX);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxo() {
        if (bxF() && this.gAW.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!bxF()) {
            bxE();
        }
        this.gAW.bxo();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxp() {
        if (bxF() && this.gAW.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!bxF()) {
            bxE();
        }
        this.gAW.bxp();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxq() {
        if (bxF() && this.gAW.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!bxF()) {
            bxE();
        }
        this.gAW.bxq();
    }

    private void bxD() {
        if (v.u(this.gAQ)) {
            this.gAQ = new ArrayList();
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAW, "translationY", 1000.0f, 0.0f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAJ, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.f.ds100)));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getLayer1(), "scaleX", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getLayer1(), "scaleY", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getLayer2(), "scaleX", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getLayer2(), "scaleY", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getTvTip(), "scaleX", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getTvTip(), "scaleY", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAK.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAL, "scaleX", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAL, "scaleY", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAI, "scaleX", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAI, "scaleY", 1.0f, 0.7f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAL, "alpha", 1.0f, 0.0f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAI, "alpha", 1.0f, 0.0f));
            this.gAQ.add(ObjectAnimator.ofFloat(this.gAM, "alpha", 1.0f, 0.0f));
        }
    }

    private void bxE() {
        int i = 0;
        if (this.gAW.getVisibility() != 0) {
            this.gAW.setVisibility(0);
            bxD();
            this.gAL.setEnabled(false);
            this.gAI.setEnabled(false);
            this.gAM.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gAQ.size()) {
                    ObjectAnimator objectAnimator = this.gAQ.get(i2);
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
        if (this.gAW.getVisibility() != 8) {
            bxD();
            this.gAL.setEnabled(true);
            this.gAI.setEnabled(true);
            this.gAM.setEnabled(true);
            if (this.gzQ.getStatus() == 6 || this.gzQ.isRecording()) {
                this.gAM.setVisibility(8);
                this.gAI.setVisibility(8);
                this.gAL.setVisibility(8);
                this.gAK.getTvTip().setVisibility(8);
            } else {
                uF(this.gzQ.getStatus());
                this.gAK.getTvTip().setVisibility(0);
            }
            while (true) {
                int i2 = i;
                if (i2 < this.gAQ.size()) {
                    ObjectAnimator objectAnimator = this.gAQ.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gAQ.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.6
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    VideoControllerLayout.this.gAW.setVisibility(8);
                                    if (VideoControllerLayout.this.gAR != null) {
                                        VideoControllerLayout.this.gAR.bxu();
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
        this.gAR = aVar;
    }

    public boolean bxF() {
        return this.gAW.getVisibility() == 0;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setVideoTitle(String str) {
        this.guL = str;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gAW != null) {
            this.gAW.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gAW != null) {
            this.gAW.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gAW != null) {
            this.gAW.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bxG() {
        if (this.gAW != null) {
            return this.gAW.bxG();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gAS = z;
    }

    public List<d> getChoosedBeautyList() {
        return this.gAT;
    }

    public List<d> getChoosedFilterList() {
        return this.gAU;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gAV;
    }
}
