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
/* loaded from: classes17.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int inl;
    private i mAj;
    private ImageView mCO;
    private RelativeLayout mCP;
    private VideoRecordButton mCQ;
    private ImageView mCR;
    private long mCS;
    private boolean mCT;
    private List<ObjectAnimator> mCU;
    private a mCV;
    private boolean mCW;
    private boolean mCX;
    private List<e> mCY;
    private List<e> mCZ;
    private AnimatorSet mCc;
    private AnimatorSet mCd;
    private List<StickerItem> mDa;
    private List<e> mDc;
    private VideoEffectLayout mDd;
    private Handler mHandler;

    /* loaded from: classes17.dex */
    public interface a {
        void dDG();

        void dDR();

        void dDS();

        void dDT();

        void dDU();

        void dDV();

        void dDW();

        void dDX();

        void dDY();

        void dDZ();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mCS = 0L;
        this.mCT = false;
        this.mCW = true;
        this.mCY = new ArrayList();
        this.mCZ = new ArrayList();
        this.mDa = new ArrayList();
        this.mDc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCS = 0L;
        this.mCT = false;
        this.mCW = true;
        this.mCY = new ArrayList();
        this.mCZ = new ArrayList();
        this.mDa = new ArrayList();
        this.mDc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCS = 0L;
        this.mCT = false;
        this.mCW = true;
        this.mCY = new ArrayList();
        this.mCZ = new ArrayList();
        this.mDa = new ArrayList();
        this.mDc = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mDd = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mCP = (RelativeLayout) findViewById(R.id.layout_record);
        this.mCO = (ImageView) findViewById(R.id.delete_video);
        this.mCO.setOnClickListener(this);
        this.mCQ = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mCQ.setOnTouchListener(this);
        this.mCR = (ImageView) findViewById(R.id.confirm_video);
        this.mCR.setOnClickListener(this);
        this.mDc.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mDc.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.mAj = iVar;
        Jh(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mDd != null) {
            this.mDd.setListener(aVar);
        }
    }

    public void Jh(int i) {
        this.mAj.setStatus(i);
        if (this.mCV != null) {
            this.mCV.dDZ();
        }
        if (i == 1) {
            this.mCO.setVisibility(8);
            this.mCR.setVisibility(8);
        } else if (i == 3) {
            this.mCO.setImageResource(R.drawable.video_back_selector);
            this.mCR.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mCO.setImageResource(R.drawable.video_back_selector);
            this.mCR.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mCO.setImageResource(R.drawable.video_delete_selector);
            if (this.mAj != null && this.mAj.getVideoDuration() >= 3000.0f) {
                this.mCR.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mCR.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mCO) {
            if (this.mCV != null) {
                this.mCV.dDY();
            }
            int status = this.mAj.getStatus();
            if (this.mAj != null && this.mAj.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.mAj.dDB();
                    fs(this.mCY);
                    fs(this.mCZ);
                    fs(this.mDa);
                    if (this.mAj.getVideoDuration() >= 3000.0f) {
                        Jh(4);
                        return;
                    } else {
                        Jh(this.mAj.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.mAj.dDA();
                Jh(5);
            }
        } else if (view == this.mCR) {
            TiebaStatic.log("c12300");
            if (this.mAj != null && this.mAj.getStatus() > 2 && this.mCV != null) {
                if (this.mAj.getVideoDuration() >= 3000.0f) {
                    this.mCV.dDW();
                } else {
                    this.mCV.dDX();
                }
            }
        }
    }

    private void fs(List list) {
        if (!y.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(final boolean z) {
        if (this.mAj.getProgress() >= 100) {
            if (this.mCV != null) {
                this.mCV.dDW();
                return;
            }
            return;
        }
        if (this.mDd.getCurrentBeautyItem() != null) {
            this.mCY.add(this.mDd.getCurrentBeautyItem());
        }
        if (this.mDd.getCurrentFilterItem() != null) {
            this.mCZ.add(this.mDd.getCurrentFilterItem());
        }
        if (this.mDd.getCurrentStickItem() != null) {
            this.mDa.add(this.mDd.getCurrentStickItem());
        }
        Jh(2);
        if (this.mDd.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.mAj.getStatus() == 6 || VideoControllerLayout.this.mAj.bmc()) {
                        VideoControllerLayout.this.wP(z);
                    }
                }
            });
        } else {
            wP(z);
        }
        if (this.mAj != null) {
            this.mAj.startRecord();
        }
        if (this.mCV != null) {
            this.mCV.dDR();
        }
    }

    public void stopRecord() {
        dEd();
        int status = this.mAj.getStatus();
        if (this.mAj != null) {
            if (!this.mAj.bIO() && this.mAj.bmc()) {
                this.mAj.stopRecord();
            }
            dEc();
        }
        if (this.mCV != null) {
            this.mCV.dDG();
            if (status == 6) {
                this.mCV.dDT();
            }
        }
    }

    public void dEc() {
        if (this.mAj != null) {
            if (this.mAj.getVideoDuration() >= 3000.0f) {
                Jh(4);
            } else if (this.mAj.getVideoDuration() > 0) {
                Jh(3);
            } else {
                Jh(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP(boolean z) {
        if (this.mCd != null && this.mCd.isRunning()) {
            this.mCd.cancel();
        }
        if (this.mCc == null) {
            this.mCc = new AnimatorSet();
            this.mCc.playTogether(ObjectAnimator.ofFloat(this.mCO, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mCR, "alpha", 1.0f, 0.0f));
            this.mCc.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDS) {
                        VideoControllerLayout.this.mCO.setVisibility(8);
                        VideoControllerLayout.this.mCR.setVisibility(8);
                    }
                }
            });
            this.mCc.setDuration(300L);
        }
        this.mCc.start();
        if (this.mAj.getStatus() != 6) {
            this.mCQ.wP(z);
        }
    }

    public void dEd() {
        if (this.mAj == null || this.mAj.bmc() || this.mAj.getStatus() == 6) {
            if (this.mCc != null && this.mCc.isRunning()) {
                this.mCc.cancel();
            }
            if (this.mCd == null) {
                this.mCd = new AnimatorSet();
                this.mCd.playTogether(ObjectAnimator.ofFloat(this.mCO, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mCR, "alpha", 0.0f, 1.0f));
                this.mCd.setDuration(300L);
            }
            this.mCO.setVisibility(0);
            this.mCR.setVisibility(0);
            this.mCd.start();
            if (this.mAj.getStatus() != 7 && this.mAj.getStatus() != 6) {
                this.mCQ.dEd();
                return;
            }
            this.mCQ.getTvTip().setVisibility(8);
            if (this.inl == 2) {
                this.mCQ.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.inl) {
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
                if (this.mCV != null) {
                    this.mCV.dDY();
                }
                if (this.mAj.getStatus() != 7 && this.mAj.getStatus() != 6) {
                    if (this.mAj != null && this.mAj.dDz()) {
                        this.mCX = true;
                        com.baidu.tbadk.core.util.e.bis().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mCS = currentTimeMillis;
                    this.mCT = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mCT && VideoControllerLayout.this.mCS == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.eP(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.mCX) {
                    this.mCX = false;
                    return;
                }
                this.mCT = false;
                if (this.mAj.bmc() || this.mAj.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.mAj.getStatus() != 8) {
                    eP(false);
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
                if (this.mAj.getStatus() == 6) {
                    this.mAj.setStatus(1);
                    if (this.mCV != null) {
                        this.mCV.dDT();
                        this.mCV.dDG();
                    }
                    this.mCQ.getTvTip().setText("");
                    this.mCQ.getTvTip().setVisibility(8);
                    return;
                } else if (this.mDd.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mCV != null) {
                    this.mCV.dDS();
                    this.mCQ.dEo();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mCQ.dEp();
                return;
            default:
                return;
        }
    }

    public void dDM() {
        if (this.mDd.getVisibility() == 0) {
            a((m) null);
        }
        wP(false);
        this.mCQ.getLayer1().setVisibility(8);
        this.mCQ.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mCQ.getTvTip().setVisibility(0);
        if (this.mCV != null) {
            this.mCV.dDR();
        }
    }

    public void dEe() {
        if (this.mAj.getStatus() == 6) {
            if (this.inl == 2) {
                Jh(7);
                this.mCQ.setAlpha(1.0f);
                this.mCO.setVisibility(8);
                this.mCR.setVisibility(8);
                this.mCQ.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.mAj != null) {
                    this.mAj.startRecord();
                    return;
                }
                return;
            }
            this.mCQ.getTvTip().setVisibility(8);
            if (this.mCV != null) {
                this.mCV.dDS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDN() {
        if (dEh() && this.mDd.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dEh()) {
            dEg();
        }
        this.mDd.dDN();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDO() {
        if (dEh() && this.mDd.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dEh()) {
            dEg();
        }
        this.mDd.dDO();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDP() {
        if (dEh() && this.mDd.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dEh()) {
            dEg();
        }
        this.mDd.dDP();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDQ() {
        if (dEh() && this.mDd.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dEh()) {
            dEg();
        }
        this.mDd.dDQ();
    }

    private void dEf() {
        if (y.isEmpty(this.mCU)) {
            this.mCU = new ArrayList();
            this.mCU.add(ObjectAnimator.ofFloat(this.mDd, "translationY", 1000.0f, 0.0f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCP, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCQ.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCQ.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCQ.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCQ.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCR, "scaleX", 1.0f, 0.7f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCR, "scaleY", 1.0f, 0.7f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCO, "scaleX", 1.0f, 0.7f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCO, "scaleY", 1.0f, 0.7f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCR, "alpha", 1.0f, 0.0f));
            this.mCU.add(ObjectAnimator.ofFloat(this.mCO, "alpha", 1.0f, 0.0f));
        }
    }

    private void dEg() {
        int i = 0;
        if (this.mDd.getVisibility() != 0) {
            this.mDd.setVisibility(0);
            dEf();
            this.mCR.setEnabled(false);
            this.mCO.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mCU.size()) {
                    ObjectAnimator objectAnimator = this.mCU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mCU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mCV != null) {
                                        VideoControllerLayout.this.mCV.dDU();
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
        if (this.mDd.getVisibility() != 8) {
            dEf();
            this.mCR.setEnabled(true);
            this.mCO.setEnabled(true);
            if (this.mAj.getStatus() == 6 || this.mAj.bmc()) {
                this.mCO.setVisibility(8);
                this.mCR.setVisibility(8);
            } else {
                Jh(this.mAj.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mCU.size()) {
                    ObjectAnimator objectAnimator = this.mCU.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mCU.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mDS) {
                                        VideoControllerLayout.this.mDd.setVisibility(8);
                                        if (VideoControllerLayout.this.mCV != null) {
                                            VideoControllerLayout.this.mCV.dDV();
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
        this.mCV = aVar;
    }

    public void setCurrentTab(int i) {
        this.inl = i;
        switch (this.inl) {
            case 1:
                this.mCO.setVisibility(4);
                this.mCR.setVisibility(4);
                this.mCQ.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.mAj.getStatus() != 1) {
                    this.mCO.setVisibility(0);
                    this.mCR.setVisibility(0);
                }
                this.mCQ.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dEh() {
        return this.mDd.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mDd != null) {
            this.mDd.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mDd != null) {
            this.mDd.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mDd != null) {
            this.mDd.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dEi() {
        if (this.mDd != null) {
            return this.mDd.dEi();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mCW = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mCY;
    }

    public List<e> getChoosedFilterList() {
        return this.mCZ;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mDa;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mDc.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mDd != null) {
            this.mDd.setMusicList(this.mDc);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void s(String str, int i, String str2) {
    }

    public void dEj() {
        if (this.mDd != null) {
            this.mDd.dEj();
        }
    }

    public void dCX() {
        if (this.mDd != null) {
            this.mDd.dCX();
        }
    }
}
