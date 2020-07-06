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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnClickListener, View.OnTouchListener, com.baidu.tieba.video.editvideo.b, VideoEffectButtonLayout.a {
    private int hSW;
    private Handler mHandler;
    private i maR;
    private AnimatorSet mcJ;
    private AnimatorSet mcK;
    private List<ObjectAnimator> mdA;
    private a mdB;
    private boolean mdC;
    private boolean mdD;
    private List<e> mdE;
    private List<e> mdF;
    private List<StickerItem> mdG;
    private List<e> mdH;
    private VideoEffectLayout mdI;
    private ImageView mdu;
    private RelativeLayout mdv;
    private VideoRecordButton mdw;
    private ImageView mdx;
    private long mdy;
    private boolean mdz;

    /* loaded from: classes10.dex */
    public interface a {
        void doS();

        void dpd();

        void dpe();

        void dpf();

        void dpg();

        void dph();

        void dpi();

        void dpj();

        void dpk();

        void dpl();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mdy = 0L;
        this.mdz = false;
        this.mdC = true;
        this.mdE = new ArrayList();
        this.mdF = new ArrayList();
        this.mdG = new ArrayList();
        this.mdH = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdy = 0L;
        this.mdz = false;
        this.mdC = true;
        this.mdE = new ArrayList();
        this.mdF = new ArrayList();
        this.mdG = new ArrayList();
        this.mdH = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdy = 0L;
        this.mdz = false;
        this.mdC = true;
        this.mdE = new ArrayList();
        this.mdF = new ArrayList();
        this.mdG = new ArrayList();
        this.mdH = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mdI = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mdv = (RelativeLayout) findViewById(R.id.layout_record);
        this.mdu = (ImageView) findViewById(R.id.delete_video);
        this.mdu.setOnClickListener(this);
        this.mdw = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mdw.setOnTouchListener(this);
        this.mdx = (ImageView) findViewById(R.id.confirm_video);
        this.mdx.setOnClickListener(this);
        this.mdH.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mdH.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.maR = iVar;
        Gp(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mdI != null) {
            this.mdI.setListener(aVar);
        }
    }

    public void Gp(int i) {
        this.maR.setStatus(i);
        if (this.mdB != null) {
            this.mdB.dpl();
        }
        if (i == 1) {
            this.mdu.setVisibility(8);
            this.mdx.setVisibility(8);
        } else if (i == 3) {
            this.mdu.setImageResource(R.drawable.video_back_selector);
            this.mdx.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mdu.setImageResource(R.drawable.video_back_selector);
            this.mdx.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mdu.setImageResource(R.drawable.video_delete_selector);
            if (this.maR != null && this.maR.getVideoDuration() >= 3000.0f) {
                this.mdx.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mdx.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mdu) {
            if (this.mdB != null) {
                this.mdB.dpk();
            }
            int status = this.maR.getStatus();
            if (this.maR != null && this.maR.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.maR.doN();
                    fe(this.mdE);
                    fe(this.mdF);
                    fe(this.mdG);
                    if (this.maR.getVideoDuration() >= 3000.0f) {
                        Gp(4);
                        return;
                    } else {
                        Gp(this.maR.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.maR.doM();
                Gp(5);
            }
        } else if (view == this.mdx) {
            TiebaStatic.log("c12300");
            if (this.maR != null && this.maR.getStatus() > 2 && this.mdB != null) {
                if (this.maR.getVideoDuration() >= 3000.0f) {
                    this.mdB.dpi();
                } else {
                    this.mdB.dpj();
                }
            }
        }
    }

    private void fe(List list) {
        if (!w.isEmpty(list)) {
            list.remove(list.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eq(final boolean z) {
        if (this.maR.getProgress() >= 100) {
            if (this.mdB != null) {
                this.mdB.dpi();
                return;
            }
            return;
        }
        if (this.mdI.getCurrentBeautyItem() != null) {
            this.mdE.add(this.mdI.getCurrentBeautyItem());
        }
        if (this.mdI.getCurrentFilterItem() != null) {
            this.mdF.add(this.mdI.getCurrentFilterItem());
        }
        if (this.mdI.getCurrentStickItem() != null) {
            this.mdG.add(this.mdI.getCurrentStickItem());
        }
        Gp(2);
        if (this.mdI.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.maR.getStatus() == 6 || VideoControllerLayout.this.maR.aZz()) {
                        VideoControllerLayout.this.vu(z);
                    }
                }
            });
        } else {
            vu(z);
        }
        if (this.maR != null) {
            this.maR.startRecord();
        }
        if (this.mdB != null) {
            this.mdB.dpd();
        }
    }

    public void stopRecord() {
        dpp();
        int status = this.maR.getStatus();
        if (this.maR != null) {
            if (!this.maR.bwu() && this.maR.aZz()) {
                this.maR.stopRecord();
            }
            dpo();
        }
        if (this.mdB != null) {
            this.mdB.doS();
            if (status == 6) {
                this.mdB.dpf();
            }
        }
    }

    public void dpo() {
        if (this.maR != null) {
            if (this.maR.getVideoDuration() >= 3000.0f) {
                Gp(4);
            } else if (this.maR.getVideoDuration() > 0) {
                Gp(3);
            } else {
                Gp(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(boolean z) {
        if (this.mcK != null && this.mcK.isRunning()) {
            this.mcK.cancel();
        }
        if (this.mcJ == null) {
            this.mcJ = new AnimatorSet();
            this.mcJ.playTogether(ObjectAnimator.ofFloat(this.mdu, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mdx, "alpha", 1.0f, 0.0f));
            this.mcJ.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mev) {
                        VideoControllerLayout.this.mdu.setVisibility(8);
                        VideoControllerLayout.this.mdx.setVisibility(8);
                    }
                }
            });
            this.mcJ.setDuration(300L);
        }
        this.mcJ.start();
        if (this.maR.getStatus() != 6) {
            this.mdw.vu(z);
        }
    }

    public void dpp() {
        if (this.maR == null || this.maR.aZz() || this.maR.getStatus() == 6) {
            if (this.mcJ != null && this.mcJ.isRunning()) {
                this.mcJ.cancel();
            }
            if (this.mcK == null) {
                this.mcK = new AnimatorSet();
                this.mcK.playTogether(ObjectAnimator.ofFloat(this.mdu, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mdx, "alpha", 0.0f, 1.0f));
                this.mcK.setDuration(300L);
            }
            this.mdu.setVisibility(0);
            this.mdx.setVisibility(0);
            this.mcK.start();
            if (this.maR.getStatus() != 7 && this.maR.getStatus() != 6) {
                this.mdw.dpp();
                return;
            }
            this.mdw.getTvTip().setVisibility(8);
            if (this.hSW == 2) {
                this.mdw.getLayer1().setVisibility(0);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.hSW) {
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
                if (this.mdB != null) {
                    this.mdB.dpk();
                }
                if (this.maR.getStatus() != 7 && this.maR.getStatus() != 6) {
                    if (this.maR != null && this.maR.doL()) {
                        this.mdD = true;
                        com.baidu.tbadk.core.util.e.aVX().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mdy = currentTimeMillis;
                    this.mdz = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mdz && VideoControllerLayout.this.mdy == currentTimeMillis) {
                                TiebaStatic.log("c12297");
                                VideoControllerLayout.this.eq(true);
                            }
                        }
                    }, 200L);
                    return;
                }
                return;
            case 1:
            case 3:
                if (this.mdD) {
                    this.mdD = false;
                    return;
                }
                this.mdz = false;
                if (this.maR.aZz() || this.maR.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.maR.getStatus() != 8) {
                    eq(false);
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
                if (this.maR.getStatus() == 6) {
                    this.maR.setStatus(1);
                    if (this.mdB != null) {
                        this.mdB.dpf();
                        this.mdB.doS();
                    }
                    this.mdw.getTvTip().setText("");
                    this.mdw.getTvTip().setVisibility(8);
                    return;
                } else if (this.mdI.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mdB != null) {
                    this.mdB.dpe();
                    this.mdw.dpA();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mdw.dpB();
                return;
            default:
                return;
        }
    }

    public void doY() {
        if (this.mdI.getVisibility() == 0) {
            a((m) null);
        }
        vu(false);
        this.mdw.getLayer1().setVisibility(8);
        this.mdw.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mdw.getTvTip().setVisibility(0);
        if (this.mdB != null) {
            this.mdB.dpd();
        }
    }

    public void dpq() {
        if (this.maR.getStatus() == 6) {
            if (this.hSW == 2) {
                Gp(7);
                this.mdw.setAlpha(1.0f);
                this.mdu.setVisibility(8);
                this.mdx.setVisibility(8);
                this.mdw.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.maR != null) {
                    this.maR.startRecord();
                    return;
                }
                return;
            }
            this.mdw.getTvTip().setVisibility(8);
            if (this.mdB != null) {
                this.mdB.dpe();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doZ() {
        if (dpt() && this.mdI.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dpt()) {
            dps();
        }
        this.mdI.doZ();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpa() {
        if (dpt() && this.mdI.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dpt()) {
            dps();
        }
        this.mdI.dpa();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpb() {
        if (dpt() && this.mdI.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dpt()) {
            dps();
        }
        this.mdI.dpb();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpc() {
        if (dpt() && this.mdI.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dpt()) {
            dps();
        }
        this.mdI.dpc();
    }

    private void dpr() {
        if (w.isEmpty(this.mdA)) {
            this.mdA = new ArrayList();
            this.mdA.add(ObjectAnimator.ofFloat(this.mdI, "translationY", 1000.0f, 0.0f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdv, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdw.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdw.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdw.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdw.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdx, "scaleX", 1.0f, 0.7f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdx, "scaleY", 1.0f, 0.7f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdu, "scaleX", 1.0f, 0.7f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdu, "scaleY", 1.0f, 0.7f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdx, "alpha", 1.0f, 0.0f));
            this.mdA.add(ObjectAnimator.ofFloat(this.mdu, "alpha", 1.0f, 0.0f));
        }
    }

    private void dps() {
        int i = 0;
        if (this.mdI.getVisibility() != 0) {
            this.mdI.setVisibility(0);
            dpr();
            this.mdx.setEnabled(false);
            this.mdu.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mdA.size()) {
                    ObjectAnimator objectAnimator = this.mdA.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mdA.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mdB != null) {
                                        VideoControllerLayout.this.mdB.dpg();
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
        if (this.mdI.getVisibility() != 8) {
            dpr();
            this.mdx.setEnabled(true);
            this.mdu.setEnabled(true);
            if (this.maR.getStatus() == 6 || this.maR.aZz()) {
                this.mdu.setVisibility(8);
                this.mdx.setVisibility(8);
            } else {
                Gp(this.maR.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mdA.size()) {
                    ObjectAnimator objectAnimator = this.mdA.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mdA.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mev) {
                                        VideoControllerLayout.this.mdI.setVisibility(8);
                                        if (VideoControllerLayout.this.mdB != null) {
                                            VideoControllerLayout.this.mdB.dph();
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
        this.mdB = aVar;
    }

    public void setCurrentTab(int i) {
        this.hSW = i;
        switch (this.hSW) {
            case 1:
                this.mdu.setVisibility(4);
                this.mdx.setVisibility(4);
                this.mdw.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.maR.getStatus() != 1) {
                    this.mdu.setVisibility(0);
                    this.mdx.setVisibility(0);
                }
                this.mdw.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dpt() {
        return this.mdI.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mdI != null) {
            this.mdI.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mdI != null) {
            this.mdI.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mdI != null) {
            this.mdI.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dpu() {
        if (this.mdI != null) {
            return this.mdI.dpu();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mdC = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mdE;
    }

    public List<e> getChoosedFilterList() {
        return this.mdF;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mdG;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mdH.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mdI != null) {
            this.mdI.setMusicList(this.mdH);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dpv() {
        if (this.mdI != null) {
            this.mdI.dpv();
        }
    }

    public void doj() {
        if (this.mdI != null) {
            this.mdI.doj();
        }
    }
}
