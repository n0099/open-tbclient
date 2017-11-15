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
    private String gEL;
    private i gKJ;
    private AnimatorSet gKY;
    private AnimatorSet gKZ;
    private ImageView gLD;
    private RelativeLayout gLE;
    private VideoRecordButton gLF;
    private ImageView gLG;
    private View gLH;
    private float gLI;
    private long gLJ;
    private boolean gLK;
    private List<ObjectAnimator> gLL;
    private a gLM;
    private boolean gLN;
    private List<d> gLO;
    private List<d> gLP;
    private List<StickerItem> gLQ;
    private List<d> gLR;
    private VideoEffectLayout gLS;
    private String mForumId;
    private String mForumName;
    private Handler mHandler;
    private float mPosY;

    /* loaded from: classes2.dex */
    public interface a {
        void bAN();

        void bAO();

        void bAX();

        void bAY();

        void bAZ();

        void bBa();

        void bBb();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.gLJ = 0L;
        this.gLK = false;
        this.gLN = true;
        this.gLO = new ArrayList();
        this.gLP = new ArrayList();
        this.gLQ = new ArrayList();
        this.gLR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLJ = 0L;
        this.gLK = false;
        this.gLN = true;
        this.gLO = new ArrayList();
        this.gLP = new ArrayList();
        this.gLQ = new ArrayList();
        this.gLR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLJ = 0L;
        this.gLK = false;
        this.gLN = true;
        this.gLO = new ArrayList();
        this.gLP = new ArrayList();
        this.gLQ = new ArrayList();
        this.gLR = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.record_controller_layout, this);
        this.gLS = (VideoEffectLayout) findViewById(d.g.layout_effect);
        this.gLE = (RelativeLayout) findViewById(d.g.layout_record);
        this.gLD = (ImageView) findViewById(d.g.delete_video);
        this.gLD.setOnClickListener(this);
        this.gLF = (VideoRecordButton) findViewById(d.g.layout_record_button);
        this.gLF.setOnTouchListener(this);
        this.gLG = (ImageView) findViewById(d.g.confirm_video);
        this.gLG.setOnClickListener(this);
        this.gLH = findViewById(d.g.drag_up_tips_layout);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoControllerLayout.this.mPosY = motionEvent.getY();
                        if (VideoControllerLayout.this.gLM != null) {
                            VideoControllerLayout.this.gLM.bBb();
                            break;
                        }
                        break;
                    case 1:
                        if (VideoControllerLayout.this.gLI - VideoControllerLayout.this.mPosY < 0.0f && Math.abs(VideoControllerLayout.this.gLI - VideoControllerLayout.this.mPosY) > 25.0f && VideoControllerLayout.this.gKJ.getStatus() == 1) {
                            TiebaStatic.log("c12296");
                            if (VideoControllerLayout.this.gLN) {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(VideoControllerLayout.this.getContext(), VideoControllerLayout.this.mForumId, VideoControllerLayout.this.mForumName, VideoControllerLayout.this.gEL)));
                                break;
                            } else {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), d.j.no_local_video_tip);
                                break;
                            }
                        }
                        break;
                    case 2:
                        VideoControllerLayout.this.gLI = motionEvent.getY();
                        break;
                }
                return true;
            }
        });
        this.gLR.add(0, new d(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute));
        this.gLR.add(1, new d(3, getResources().getString(d.j.music_cloud), new MusicData("-200", 2, getResources().getString(d.j.music_cloud)), d.f.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.gKJ = iVar;
        vb(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.gLS != null) {
            this.gLS.setListener(aVar);
        }
    }

    public void vb(int i) {
        this.gKJ.setStatus(i);
        if (i == 1) {
            this.gLH.setVisibility(0);
            this.gLD.setVisibility(8);
            this.gLG.setVisibility(8);
            return;
        }
        this.gLH.setVisibility(8);
        if (i == 3) {
            this.gLD.setImageResource(d.f.video_back_selector);
            this.gLG.setImageResource(d.f.icon_video_confirm_d);
        } else if (i == 4) {
            this.gLD.setImageResource(d.f.video_back_selector);
            this.gLG.setImageResource(d.f.video_confirm_selector);
        } else if (i == 5) {
            this.gLD.setImageResource(d.f.video_delete_selector);
            if (this.gKJ != null && this.gKJ.getVideoDuration() >= 3000.0f) {
                this.gLG.setImageResource(d.f.video_confirm_selector);
            } else {
                this.gLG.setImageResource(d.f.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gLH) {
            TiebaStatic.log("c12296");
            if (this.gLM != null) {
                this.gLM.bBb();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LocalVideoActivityConfig(getContext())));
        } else if (view == this.gLD) {
            if (this.gLM != null) {
                this.gLM.bBb();
            }
            int status = this.gKJ.getStatus();
            if (this.gKJ != null && this.gKJ.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.gKJ.bAL();
                    dG(this.gLO);
                    dG(this.gLP);
                    dG(this.gLQ);
                    if (this.gKJ.getVideoDuration() >= 3000.0f) {
                        vb(4);
                        return;
                    } else {
                        vb(this.gKJ.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.gKJ.bAK();
                vb(5);
            }
        } else if (view == this.gLG) {
            TiebaStatic.log("c12300");
            if (this.gKJ != null && this.gKJ.getStatus() > 2 && this.gLM != null) {
                if (this.gKJ.getVideoDuration() >= 3000.0f) {
                    this.gLM.bAO();
                } else {
                    this.gLM.bBa();
                }
            }
        }
    }

    private void dG(List list) {
        if (!v.v(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() {
        if (this.gKJ.getProgress() >= 100) {
            if (this.gLM != null) {
                this.gLM.bAO();
                return;
            }
            return;
        }
        if (this.gLS.getCurrentBeautyItem() != null) {
            this.gLO.add(this.gLS.getCurrentBeautyItem());
        }
        if (this.gLS.getCurrentFilterItem() != null) {
            this.gLP.add(this.gLS.getCurrentFilterItem());
        }
        if (this.gLS.getCurrentStickItem() != null) {
            this.gLQ.add(this.gLS.getCurrentStickItem());
        }
        vb(2);
        if (this.gLS.getVisibility() == 0) {
            a(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.gKJ.getStatus() == 6 || VideoControllerLayout.this.gKJ.isRecording()) {
                        VideoControllerLayout.this.bBe();
                    }
                }
            });
        } else {
            bBe();
        }
        if (this.gKJ != null) {
            this.gKJ.startRecord();
        }
        if (this.gLM != null) {
            this.gLM.bAX();
        }
    }

    public void stopRecord() {
        bBf();
        int status = this.gKJ.getStatus();
        if (this.gKJ != null) {
            if (this.gKJ.getStatus() != 6 && this.gKJ.isRecording()) {
                this.gKJ.stopRecord();
            }
            if (this.gKJ.getVideoDuration() >= 3000.0f) {
                vb(4);
            } else if (this.gKJ.getVideoDuration() > 0) {
                vb(3);
            } else {
                vb(1);
            }
        }
        if (this.gLM != null) {
            this.gLM.bAN();
            if (status == 6) {
                this.gLM.bAY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (this.gKZ != null && this.gKZ.isRunning()) {
            this.gKZ.cancel();
        }
        if (this.gKY == null) {
            this.gKY = new AnimatorSet();
            this.gKY.playTogether(ObjectAnimator.ofFloat(this.gLD, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gLG, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gLH, "alpha", 1.0f, 0.0f));
            this.gKY.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gMy) {
                        VideoControllerLayout.this.gLD.setVisibility(8);
                        VideoControllerLayout.this.gLG.setVisibility(8);
                        VideoControllerLayout.this.gLH.setVisibility(8);
                    }
                }
            });
            this.gKY.setDuration(300L);
        }
        this.gKY.start();
        if (this.gKJ.getStatus() != 6) {
            this.gLF.bBe();
        }
    }

    public void bBf() {
        if (this.gKJ == null || this.gKJ.isRecording() || this.gKJ.getStatus() == 6) {
            if (this.gKY != null && this.gKY.isRunning()) {
                this.gKY.cancel();
            }
            if (this.gKZ == null) {
                this.gKZ = new AnimatorSet();
                this.gKZ.playTogether(ObjectAnimator.ofFloat(this.gLD, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gLG, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gLH, "alpha", 0.0f, 1.0f));
                this.gKZ.setDuration(300L);
            }
            this.gLD.setVisibility(0);
            this.gLG.setVisibility(0);
            this.gKZ.start();
            if (this.gKJ.getStatus() != 7 && this.gKJ.getStatus() != 6) {
                this.gLF.bBf();
            } else {
                this.gLF.getTvTip().setText(getResources().getText(d.j.video_record_button_press));
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.gLM != null) {
                    this.gLM.bBb();
                }
                if (this.gKJ.getStatus() != 7 && this.gKJ.getStatus() != 6) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.gLJ = currentTimeMillis;
                    this.gLK = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.gLK && VideoControllerLayout.this.gLJ == currentTimeMillis) {
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
                this.gLK = false;
                if (this.gKJ.isRecording() || this.gKJ.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    break;
                } else if (this.gLS.getVisibility() == 0) {
                    a((n) null);
                    break;
                }
                break;
        }
        return true;
    }

    public void bAS() {
        if (this.gLS.getVisibility() == 0) {
            a((n) null);
        }
        bBe();
        this.gLF.getTvTip().setText(getResources().getText(d.j.video_record_button_cancel));
        this.gLF.getTvTip().setVisibility(0);
        if (this.gLM != null) {
            this.gLM.bAX();
        }
    }

    public void bBg() {
        if (this.gKJ.getStatus() == 6) {
            vb(7);
            this.gLF.setAlpha(1.0f);
            this.gLD.setVisibility(8);
            this.gLG.setVisibility(8);
            this.gLF.getTvTip().setText(getResources().getText(d.j.video_record_button_pasue));
            if (this.gKJ != null) {
                this.gKJ.startRecord();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAT() {
        if (bBj() && this.gLS.getCurrentEffectLayout() == 3) {
            a((n) null);
            return;
        }
        if (!bBj()) {
            bBi();
        }
        this.gLS.bAT();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAU() {
        if (bBj() && this.gLS.getCurrentEffectLayout() == 0) {
            a((n) null);
            return;
        }
        if (!bBj()) {
            bBi();
        }
        this.gLS.bAU();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAV() {
        if (bBj() && this.gLS.getCurrentEffectLayout() == 1) {
            a((n) null);
            return;
        }
        if (!bBj()) {
            bBi();
        }
        this.gLS.bAV();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAW() {
        if (bBj() && this.gLS.getCurrentEffectLayout() == 2) {
            a((n) null);
            return;
        }
        if (!bBj()) {
            bBi();
        }
        this.gLS.bAW();
    }

    private void bBh() {
        if (v.v(this.gLL)) {
            this.gLL = new ArrayList();
            this.gLL.add(ObjectAnimator.ofFloat(this.gLS, "translationY", 1000.0f, 0.0f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLE, "translationY", 0.0f, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds100)));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getLayer1(), "scaleX", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getLayer1(), "scaleY", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getLayer2(), "scaleX", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getLayer2(), "scaleY", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getTvTip(), "scaleX", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getTvTip(), "scaleY", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLF.getTvTip(), "alpha", 1.0f, 0.0f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLG, "scaleX", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLG, "scaleY", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLD, "scaleX", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLD, "scaleY", 1.0f, 0.7f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLG, "alpha", 1.0f, 0.0f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLD, "alpha", 1.0f, 0.0f));
            this.gLL.add(ObjectAnimator.ofFloat(this.gLH, "alpha", 1.0f, 0.0f));
        }
    }

    private void bBi() {
        int i = 0;
        if (this.gLS.getVisibility() != 0) {
            this.gLS.setVisibility(0);
            bBh();
            this.gLG.setEnabled(false);
            this.gLD.setEnabled(false);
            this.gLH.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.gLL.size()) {
                    ObjectAnimator objectAnimator = this.gLL.get(i2);
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
        if (this.gLS.getVisibility() != 8) {
            bBh();
            this.gLG.setEnabled(true);
            this.gLD.setEnabled(true);
            this.gLH.setEnabled(true);
            if (this.gKJ.getStatus() == 6 || this.gKJ.isRecording()) {
                this.gLH.setVisibility(8);
                this.gLD.setVisibility(8);
                this.gLG.setVisibility(8);
                this.gLF.getTvTip().setVisibility(8);
            } else {
                vb(this.gKJ.getStatus());
                this.gLF.getTvTip().setVisibility(0);
            }
            while (true) {
                int i2 = i;
                if (i2 < this.gLL.size()) {
                    ObjectAnimator objectAnimator = this.gLL.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.gLL.size() - 1) {
                            objectAnimator.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    VideoControllerLayout.this.gLS.setVisibility(8);
                                    if (VideoControllerLayout.this.gLM != null) {
                                        VideoControllerLayout.this.gLM.bAZ();
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
        this.gLM = aVar;
    }

    public boolean bBj() {
        return this.gLS.getVisibility() == 0;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public void setVideoTitle(String str) {
        this.gEL = str;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.gLS != null) {
            this.gLS.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.gLS != null) {
            this.gLS.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.gLS != null) {
            this.gLS.setDownLoadStrick(stickerItem);
        }
    }

    public boolean bBk() {
        if (this.gLS != null) {
            return this.gLS.bBk();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.gLN = z;
    }

    public List<d> getChoosedBeautyList() {
        return this.gLO;
    }

    public List<d> getChoosedFilterList() {
        return this.gLP;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.gLQ;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.gLR.add(new d(3, musicData.name, musicData, -1));
            }
        }
        if (this.gLS != null) {
            this.gLS.setMusicList(this.gLR);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void tn(String str) {
    }

    public void bBl() {
        if (this.gLS != null) {
            this.gLS.bBl();
        }
    }

    public void bAn() {
        if (this.gLS != null) {
            this.gLS.bAn();
        }
    }
}
