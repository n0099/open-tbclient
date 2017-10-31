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
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private String gDD;
    private i gJB;
    private AnimatorSet gJQ;
    private AnimatorSet gJR;
    private float gKA;
    private long gKB;
    private boolean gKC;
    private List<ObjectAnimator> gKD;
    private a gKE;
    private boolean gKF;
    private List<d> gKG;
    private List<d> gKH;
    private List<StickerItem> gKI;
    private List<d> gKJ;
    private VideoEffectLayout gKK;
    private ImageView gKv;
    private RelativeLayout gKw;
    private VideoRecordButton gKx;
    private ImageView gKy;
    private View gKz;
    private String mForumId;
    private String mForumName;
    private Handler mHandler;
    private float mPosY;

    /* loaded from: classes2.dex */
    public interface a {
        void bAB();

        void bAC();

        void bAL();

        void bAM();

        void bAN();

        void bAO();

        void bAP();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gKB = 0L;
        this.gKC = false;
        this.gKF = true;
        this.gKG = new ArrayList();
        this.gKH = new ArrayList();
        this.gKI = new ArrayList();
        this.gKJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKB = 0L;
        this.gKC = false;
        this.gKF = true;
        this.gKG = new ArrayList();
        this.gKH = new ArrayList();
        this.gKI = new ArrayList();
        this.gKJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKB = 0L;
        this.gKC = false;
        this.gKF = true;
        this.gKG = new ArrayList();
        this.gKH = new ArrayList();
        this.gKI = new ArrayList();
        this.gKJ = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.gKK = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gKw = (RelativeLayout) findViewById(d.g.layout_record);
        this.gKv = (ImageView) findViewById(d.g.delete_video);
        this.gKv.setOnClickListener(this);
        this.gKx = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gKx.setOnTouchListener(this);
        this.gKy = (ImageView) findViewById(d.g.confirm_video);
        this.gKy.setOnClickListener(this);
        this.gKz = findViewById(d.g.drag_up_tips_layout);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoControllerLayout.this.mPosY = motionEvent.getY();
                        if (VideoControllerLayout.this.gKE != null) {
                            VideoControllerLayout.this.gKE.bAP();
                            break;
                        }
                        break;
                    case 1:
                        if (VideoControllerLayout.this.gKA - VideoControllerLayout.this.mPosY < 0.0f && Math.abs(VideoControllerLayout.this.gKA - VideoControllerLayout.this.mPosY) > 25.0f && VideoControllerLayout.this.gJB.getStatus() == 1) {
                            TiebaStatic.log("c12296");
                            if (VideoControllerLayout.this.gKF) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(VideoControllerLayout.this.getContext(), VideoControllerLayout.this.mForumId, VideoControllerLayout.this.mForumName, VideoControllerLayout.this.gDD)));
                                break;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
                                break;
                            }
                        }
                        break;
                    case 2:
                        VideoControllerLayout.this.gKA = motionEvent.getY();
                        break;
                }
                return true;
            }
        });
        this.gKJ.add(0, new d(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.gKJ.add(1, new d(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.gJB = iVar;
        uX(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gKK != null) {
            this.gKK.setListener(aVar);
        }
    }

    public void uX(int i) {
        this.gJB.setStatus(i);
        if (i == 1) {
            this.gKz.setVisibility(0);
            this.gKv.setVisibility(8);
            this.gKy.setVisibility(8);
            return;
        }
        this.gKz.setVisibility(8);
        if (i == 3) {
            this.gKv.setImageResource(d.f.video_back_selector);
            this.gKy.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gKv.setImageResource(d.f.video_back_selector);
            this.gKy.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gKv.setImageResource(d.f.video_delete_selector);
            if (this.gJB != null && this.gJB.getVideoDuration() >= 3000.0f) {
                this.gKy.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gKy.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gKz) {
            TiebaStatic.log("c12296");
            if (this.gKE != null) {
                this.gKE.bAP();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(getContext())));
        } else if (view == this.gKv) {
            if (this.gKE != null) {
                this.gKE.bAP();
            }
            int status = this.gJB.getStatus();
            if (this.gJB != null && this.gJB.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gJB.bAz();
                    dF(this.gKG);
                    dF(this.gKH);
                    dF(this.gKI);
                    if (this.gJB.getVideoDuration() >= 3000.0f) {
                        uX(4);
                        return;
                    } else {
                        uX(this.gJB.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gJB.bAy();
                uX(5);
            }
        } else if (view == this.gKy) {
            TiebaStatic.log("c12300");
            if (this.gJB != null && this.gJB.getStatus() > 2 && this.gKE != null) {
                if (this.gJB.getVideoDuration() >= 3000.0f) {
                    this.gKE.bAC();
                } else {
                    this.gKE.bAO();
                }
            }
        }
    }

    private void dF(List list) {
        if (!v.v(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (this.gJB.getProgress() >= 100) {
            if (this.gKE != null) {
                this.gKE.bAC();
                return;
            }
            return;
        }
        if (this.gKK.getCurrentBeautyItem() != null) {
            this.gKG.add(this.gKK.getCurrentBeautyItem());
        }
        if (this.gKK.getCurrentFilterItem() != null) {
            this.gKH.add(this.gKK.getCurrentFilterItem());
        }
        if (this.gKK.getCurrentStickItem() != null) {
            this.gKI.add(this.gKK.getCurrentStickItem());
        }
        uX(2);
        if (this.gKK.getVisibility() == 0) {
            a(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gJB.getStatus() == 6 || VideoControllerLayout.this.gJB.isRecording()) {
                        VideoControllerLayout.this.bAS();
                    }
                }
            });
        } else {
            bAS();
        }
        if (this.gJB != null) {
            this.gJB.startRecord();
        }
        if (this.gKE != null) {
            this.gKE.bAL();
        }
    }

    public void stopRecord() {
        bAT();
        int status = this.gJB.getStatus();
        if (this.gJB != null) {
            if (this.gJB.getStatus() != 6 && this.gJB.isRecording()) {
                this.gJB.stopRecord();
            }
            if (this.gJB.getVideoDuration() >= 3000.0f) {
                uX(4);
            } else if (this.gJB.getVideoDuration() > 0) {
                uX(3);
            } else {
                uX(1);
            }
        }
        if (this.gKE != null) {
            this.gKE.bAB();
            if (status == 6) {
                this.gKE.bAM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAS() {
        if (this.gJR != null && this.gJR.isRunning()) {
            this.gJR.cancel();
        }
        if (this.gJQ == null) {
            this.gJQ = new AnimatorSet();
            this.gJQ.playTogether(ObjectAnimator.ofFloat(this.gKv, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gKy, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gKz, "alpha", 1.0f, 0.0f));
            this.gJQ.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gLq) {
                        VideoControllerLayout.this.gKv.setVisibility(8);
                        VideoControllerLayout.this.gKy.setVisibility(8);
                        VideoControllerLayout.this.gKz.setVisibility(8);
                    }
                }
            });
            this.gJQ.setDuration(300L);
        }
        this.gJQ.start();
        if (this.gJB.getStatus() != 6) {
            this.gKx.bAS();
        }
    }

    public void bAT() {
        if (this.gJB == null || this.gJB.isRecording() || this.gJB.getStatus() == 6) {
            if (this.gJQ != null && this.gJQ.isRunning()) {
                this.gJQ.cancel();
            }
            if (this.gJR == null) {
                this.gJR = new AnimatorSet();
                this.gJR.playTogether(ObjectAnimator.ofFloat(this.gKv, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gKy, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gKz, "alpha", 0.0f, 1.0f));
                this.gJR.setDuration(300L);
            }
            this.gKv.setVisibility(0);
            this.gKy.setVisibility(0);
            this.gJR.start();
            if (this.gJB.getStatus() != 7 && this.gJB.getStatus() != 6) {
                this.gKx.bAT();
            } else {
                this.gKx.getTvTip().setText(getResources().getText(d.j.video_record_button_press));
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gKE != null) {
                    this.gKE.bAP();
                }
                if (this.gJB.getStatus() != 7 && this.gJB.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gKB = currentTimeMillis;
                    this.gKC = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gKC && VideoControllerLayout.this.gKB == currentTimeMillis) {
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
                this.gKC = false;
                if (this.gJB.isRecording() || this.gJB.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    break;
                } else if (this.gKK.getVisibility() == 0) {
                    a((n) null);
                    break;
                }
                break;
        }
        return true;
    }

    public void bAG() {
        if (this.gKK.getVisibility() == 0) {
            a((n) null);
        }
        bAS();
        this.gKx.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.gKx.getTvTip().setVisibility(0);
        if (this.gKE != null) {
            this.gKE.bAL();
        }
    }

    public void bAU() {
        if (this.gJB.getStatus() == 6) {
            uX(7);
            this.gKx.setAlpha(1.0f);
            this.gKv.setVisibility(8);
            this.gKy.setVisibility(8);
            this.gKx.getTvTip().setText(getResources().getText(d.j.video_record_button_pasue));
            if (this.gJB != null) {
                this.gJB.startRecord();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAH() {
        if (bAX() && this.gKK.getCurrentEffectLayout() == 3) {
            a((n) null);
            return;
        }
        if (!bAX()) {
            bAW();
        }
        this.gKK.bAH();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAI() {
        if (bAX() && this.gKK.getCurrentEffectLayout() == 0) {
            a((n) null);
            return;
        }
        if (!bAX()) {
            bAW();
        }
        this.gKK.bAI();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAJ() {
        if (bAX() && this.gKK.getCurrentEffectLayout() == 1) {
            a((n) null);
            return;
        }
        if (!bAX()) {
            bAW();
        }
        this.gKK.bAJ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAK() {
        if (bAX() && this.gKK.getCurrentEffectLayout() == 2) {
            a((n) null);
            return;
        }
        if (!bAX()) {
            bAW();
        }
        this.gKK.bAK();
    }

    private void bAV() {
        if (v.v(this.gKD)) {
            this.gKD = new ArrayList();
            this.gKD.add(ObjectAnimator.ofFloat(this.gKK, "translationY", 1000.0f, 0.0f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKw, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getLayer1(), "scaleX", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getLayer1(), "scaleY", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getLayer2(), "scaleX", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getLayer2(), "scaleY", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getTvTip(), "scaleX", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getTvTip(), "scaleY", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKx.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKy, "scaleX", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKy, "scaleY", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKv, "scaleX", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKv, "scaleY", 1.0f, 0.7f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKy, "alpha", 1.0f, 0.0f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKv, "alpha", 1.0f, 0.0f));
            this.gKD.add(ObjectAnimator.ofFloat(this.gKz, "alpha", 1.0f, 0.0f));
        }
    }

    private void bAW() {
        int i = 0;
        if (this.gKK.getVisibility() != 0) {
            this.gKK.setVisibility(0);
            bAV();
            this.gKy.setEnabled(false);
            this.gKv.setEnabled(false);
            this.gKz.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gKD.size()) {
                    ObjectAnimator objectAnimator = this.gKD.get(i2);
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

    private void a(final n nVar) {
        int i = 0;
        if (this.gKK.getVisibility() != 8) {
            bAV();
            this.gKy.setEnabled(true);
            this.gKv.setEnabled(true);
            this.gKz.setEnabled(true);
            if (this.gJB.getStatus() == 6 || this.gJB.isRecording()) {
                this.gKz.setVisibility(8);
                this.gKv.setVisibility(8);
                this.gKy.setVisibility(8);
                this.gKx.getTvTip().setVisibility(8);
            } else {
                uX(this.gJB.getStatus());
                this.gKx.getTvTip().setVisibility(0);
            }
            while (true) {
                int i2 = i;
                if (i2 < this.gKD.size()) {
                    ObjectAnimator objectAnimator = this.gKD.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gKD.size() - 1) {
                            objectAnimator.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    VideoControllerLayout.this.gKK.setVisibility(8);
                                    if (VideoControllerLayout.this.gKE != null) {
                                        VideoControllerLayout.this.gKE.bAN();
                                    }
                                    if (nVar != null) {
                                        nVar.onAnimationEnd(animator);
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
        this.gKE = aVar;
    }

    public boolean bAX() {
        return this.gKK.getVisibility() == 0;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setVideoTitle(String str) {
        this.gDD = str;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gKK != null) {
            this.gKK.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gKK != null) {
            this.gKK.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gKK != null) {
            this.gKK.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bAY() {
        if (this.gKK != null) {
            return this.gKK.bAY();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gKF = z;
    }

    public List<d> getChoosedBeautyList() {
        return this.gKG;
    }

    public List<d> getChoosedFilterList() {
        return this.gKH;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gKI;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gKJ.add(new d(3, musicData.name, musicData, -1));
            }
        }
        if (this.gKK != null) {
            this.gKK.setMusicList(this.gKJ);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void th(String str) {
    }

    public void bAZ() {
        if (this.gKK != null) {
            this.gKK.bAZ();
        }
    }

    public void bAb() {
        if (this.gKK != null) {
            this.gKK.bAb();
        }
    }
}
