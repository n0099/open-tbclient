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
    private i maO;
    private AnimatorSet mcG;
    private AnimatorSet mcH;
    private boolean mdA;
    private List<e> mdB;
    private List<e> mdC;
    private List<StickerItem> mdD;
    private List<e> mdE;
    private VideoEffectLayout mdF;
    private ImageView mdr;
    private RelativeLayout mds;
    private VideoRecordButton mdt;
    private ImageView mdu;
    private long mdv;
    private boolean mdw;
    private List<ObjectAnimator> mdx;
    private a mdy;
    private boolean mdz;

    /* loaded from: classes10.dex */
    public interface a {
        void doO();

        void doZ();

        void dpa();

        void dpb();

        void dpc();

        void dpd();

        void dpe();

        void dpf();

        void dpg();

        void dph();
    }

    public VideoControllerLayout(Context context) {
        super(context);
        this.mdv = 0L;
        this.mdw = false;
        this.mdz = true;
        this.mdB = new ArrayList();
        this.mdC = new ArrayList();
        this.mdD = new ArrayList();
        this.mdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mdv = 0L;
        this.mdw = false;
        this.mdz = true;
        this.mdB = new ArrayList();
        this.mdC = new ArrayList();
        this.mdD = new ArrayList();
        this.mdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mdv = 0L;
        this.mdw = false;
        this.mdz = true;
        this.mdB = new ArrayList();
        this.mdC = new ArrayList();
        this.mdD = new ArrayList();
        this.mdE = new ArrayList();
        this.mHandler = new Handler();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.record_controller_layout, this);
        this.mdF = (VideoEffectLayout) findViewById(R.id.layout_effect);
        this.mds = (RelativeLayout) findViewById(R.id.layout_record);
        this.mdr = (ImageView) findViewById(R.id.delete_video);
        this.mdr.setOnClickListener(this);
        this.mdt = (VideoRecordButton) findViewById(R.id.layout_record_button);
        this.mdt.setOnTouchListener(this);
        this.mdu = (ImageView) findViewById(R.id.confirm_video);
        this.mdu.setOnClickListener(this);
        this.mdE.add(0, new e(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute));
        this.mdE.add(1, new e(3, getResources().getString(R.string.music_cloud), new MusicData("-200", 2, getResources().getString(R.string.music_cloud)), R.drawable.icon_video_cloudmusic));
    }

    public void setRecordController(i iVar) {
        this.maO = iVar;
        Gp(1);
    }

    public void setEffectChoosedListener(VideoEffectLayout.a aVar) {
        if (this.mdF != null) {
            this.mdF.setListener(aVar);
        }
    }

    public void Gp(int i) {
        this.maO.setStatus(i);
        if (this.mdy != null) {
            this.mdy.dph();
        }
        if (i == 1) {
            this.mdr.setVisibility(8);
            this.mdu.setVisibility(8);
        } else if (i == 3) {
            this.mdr.setImageResource(R.drawable.video_back_selector);
            this.mdu.setImageResource(R.drawable.icon_video_confirm_d);
        } else if (i == 4) {
            this.mdr.setImageResource(R.drawable.video_back_selector);
            this.mdu.setImageResource(R.drawable.video_confirm_selector);
        } else if (i == 5) {
            this.mdr.setImageResource(R.drawable.video_delete_selector);
            if (this.maO != null && this.maO.getVideoDuration() >= 3000.0f) {
                this.mdu.setImageResource(R.drawable.video_confirm_selector);
            } else {
                this.mdu.setImageResource(R.drawable.icon_video_confirm_d);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mdr) {
            if (this.mdy != null) {
                this.mdy.dpg();
            }
            int status = this.maO.getStatus();
            if (this.maO != null && this.maO.getVideoDuration() > 0 && status > 2) {
                if (status == 5) {
                    TiebaStatic.log("c12299");
                    this.maO.doJ();
                    fe(this.mdB);
                    fe(this.mdC);
                    fe(this.mdD);
                    if (this.maO.getVideoDuration() >= 3000.0f) {
                        Gp(4);
                        return;
                    } else {
                        Gp(this.maO.getVideoDuration() > 0 ? 3 : 1);
                        return;
                    }
                }
                this.maO.doI();
                Gp(5);
            }
        } else if (view == this.mdu) {
            TiebaStatic.log("c12300");
            if (this.maO != null && this.maO.getStatus() > 2 && this.mdy != null) {
                if (this.maO.getVideoDuration() >= 3000.0f) {
                    this.mdy.dpe();
                } else {
                    this.mdy.dpf();
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
        if (this.maO.getProgress() >= 100) {
            if (this.mdy != null) {
                this.mdy.dpe();
                return;
            }
            return;
        }
        if (this.mdF.getCurrentBeautyItem() != null) {
            this.mdB.add(this.mdF.getCurrentBeautyItem());
        }
        if (this.mdF.getCurrentFilterItem() != null) {
            this.mdC.add(this.mdF.getCurrentFilterItem());
        }
        if (this.mdF.getCurrentStickItem() != null) {
            this.mdD.add(this.mdF.getCurrentStickItem());
        }
        Gp(2);
        if (this.mdF.getVisibility() == 0) {
            a(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (VideoControllerLayout.this.maO.getStatus() == 6 || VideoControllerLayout.this.maO.aZz()) {
                        VideoControllerLayout.this.vu(z);
                    }
                }
            });
        } else {
            vu(z);
        }
        if (this.maO != null) {
            this.maO.startRecord();
        }
        if (this.mdy != null) {
            this.mdy.doZ();
        }
    }

    public void stopRecord() {
        dpl();
        int status = this.maO.getStatus();
        if (this.maO != null) {
            if (!this.maO.bwt() && this.maO.aZz()) {
                this.maO.stopRecord();
            }
            dpk();
        }
        if (this.mdy != null) {
            this.mdy.doO();
            if (status == 6) {
                this.mdy.dpb();
            }
        }
    }

    public void dpk() {
        if (this.maO != null) {
            if (this.maO.getVideoDuration() >= 3000.0f) {
                Gp(4);
            } else if (this.maO.getVideoDuration() > 0) {
                Gp(3);
            } else {
                Gp(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(boolean z) {
        if (this.mcH != null && this.mcH.isRunning()) {
            this.mcH.cancel();
        }
        if (this.mcG == null) {
            this.mcG = new AnimatorSet();
            this.mcG.playTogether(ObjectAnimator.ofFloat(this.mdr, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mdu, "alpha", 1.0f, 0.0f));
            this.mcG.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mes) {
                        VideoControllerLayout.this.mdr.setVisibility(8);
                        VideoControllerLayout.this.mdu.setVisibility(8);
                    }
                }
            });
            this.mcG.setDuration(300L);
        }
        this.mcG.start();
        if (this.maO.getStatus() != 6) {
            this.mdt.vu(z);
        }
    }

    public void dpl() {
        if (this.maO == null || this.maO.aZz() || this.maO.getStatus() == 6) {
            if (this.mcG != null && this.mcG.isRunning()) {
                this.mcG.cancel();
            }
            if (this.mcH == null) {
                this.mcH = new AnimatorSet();
                this.mcH.playTogether(ObjectAnimator.ofFloat(this.mdr, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mdu, "alpha", 0.0f, 1.0f));
                this.mcH.setDuration(300L);
            }
            this.mdr.setVisibility(0);
            this.mdu.setVisibility(0);
            this.mcH.start();
            if (this.maO.getStatus() != 7 && this.maO.getStatus() != 6) {
                this.mdt.dpl();
                return;
            }
            this.mdt.getTvTip().setVisibility(8);
            if (this.hSW == 2) {
                this.mdt.getLayer1().setVisibility(0);
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
                if (this.mdy != null) {
                    this.mdy.dpg();
                }
                if (this.maO.getStatus() != 7 && this.maO.getStatus() != 6) {
                    if (this.maO != null && this.maO.doH()) {
                        this.mdA = true;
                        com.baidu.tbadk.core.util.e.aVX().showToast(R.string.music_is_downloading);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    this.mdv = currentTimeMillis;
                    this.mdw = true;
                    this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (VideoControllerLayout.this.mdw && VideoControllerLayout.this.mdv == currentTimeMillis) {
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
                if (this.mdA) {
                    this.mdA = false;
                    return;
                }
                this.mdw = false;
                if (this.maO.aZz() || this.maO.getStatus() == 6) {
                    TiebaStatic.log("c12298");
                    stopRecord();
                    return;
                } else if (this.maO.getStatus() != 8) {
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
                if (this.maO.getStatus() == 6) {
                    this.maO.setStatus(1);
                    if (this.mdy != null) {
                        this.mdy.dpb();
                        this.mdy.doO();
                    }
                    this.mdt.getTvTip().setText("");
                    this.mdt.getTvTip().setVisibility(8);
                    return;
                } else if (this.mdF.getVisibility() == 0) {
                    a((m) null);
                    return;
                } else if (this.mdy != null) {
                    this.mdy.dpa();
                    this.mdt.dpw();
                    return;
                } else {
                    return;
                }
            case 1:
                this.mdt.dpx();
                return;
            default:
                return;
        }
    }

    public void doU() {
        if (this.mdF.getVisibility() == 0) {
            a((m) null);
        }
        vu(false);
        this.mdt.getLayer1().setVisibility(8);
        this.mdt.getTvTip().setText(getResources().getText(R.string.video_record_button_cancel));
        this.mdt.getTvTip().setVisibility(0);
        if (this.mdy != null) {
            this.mdy.doZ();
        }
    }

    public void dpm() {
        if (this.maO.getStatus() == 6) {
            if (this.hSW == 2) {
                Gp(7);
                this.mdt.setAlpha(1.0f);
                this.mdr.setVisibility(8);
                this.mdu.setVisibility(8);
                this.mdt.getTvTip().setText(getResources().getString(R.string.video_record_button_pasue));
                if (this.maO != null) {
                    this.maO.startRecord();
                    return;
                }
                return;
            }
            this.mdt.getTvTip().setVisibility(8);
            if (this.mdy != null) {
                this.mdy.dpa();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doV() {
        if (dpp() && this.mdF.getCurrentEffectLayout() == 3) {
            a((m) null);
            return;
        }
        if (!dpp()) {
            dpo();
        }
        this.mdF.doV();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doW() {
        if (dpp() && this.mdF.getCurrentEffectLayout() == 0) {
            a((m) null);
            return;
        }
        if (!dpp()) {
            dpo();
        }
        this.mdF.doW();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doX() {
        if (dpp() && this.mdF.getCurrentEffectLayout() == 1) {
            a((m) null);
            return;
        }
        if (!dpp()) {
            dpo();
        }
        this.mdF.doX();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doY() {
        if (dpp() && this.mdF.getCurrentEffectLayout() == 2) {
            a((m) null);
            return;
        }
        if (!dpp()) {
            dpo();
        }
        this.mdF.doY();
    }

    private void dpn() {
        if (w.isEmpty(this.mdx)) {
            this.mdx = new ArrayList();
            this.mdx.add(ObjectAnimator.ofFloat(this.mdF, "translationY", 1000.0f, 0.0f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mds, "translationY", 0.0f, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds100)));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdt.getLayer3(), "scaleX", 0.766f, 0.585f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdt.getLayer3(), "scaleY", 0.766f, 0.585f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdt.getLayer2(), "scaleX", 1.0f, 0.82f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdt.getLayer2(), "scaleY", 1.0f, 0.82f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdu, "scaleX", 1.0f, 0.7f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdu, "scaleY", 1.0f, 0.7f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdr, "scaleX", 1.0f, 0.7f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdr, "scaleY", 1.0f, 0.7f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdu, "alpha", 1.0f, 0.0f));
            this.mdx.add(ObjectAnimator.ofFloat(this.mdr, "alpha", 1.0f, 0.0f));
        }
    }

    private void dpo() {
        int i = 0;
        if (this.mdF.getVisibility() != 0) {
            this.mdF.setVisibility(0);
            dpn();
            this.mdu.setEnabled(false);
            this.mdr.setEnabled(false);
            while (true) {
                int i2 = i;
                if (i2 < this.mdx.size()) {
                    ObjectAnimator objectAnimator = this.mdx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        objectAnimator.setDuration(500L);
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mdx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.4
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationStart(Animator animator) {
                                    if (VideoControllerLayout.this.mdy != null) {
                                        VideoControllerLayout.this.mdy.dpc();
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
        if (this.mdF.getVisibility() != 8) {
            dpn();
            this.mdu.setEnabled(true);
            this.mdr.setEnabled(true);
            if (this.maO.getStatus() == 6 || this.maO.aZz()) {
                this.mdr.setVisibility(8);
                this.mdu.setVisibility(8);
            } else {
                Gp(this.maO.getStatus());
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mdx.size()) {
                    ObjectAnimator objectAnimator = this.mdx.get(i2);
                    if (objectAnimator != null) {
                        objectAnimator.setDuration(500L);
                        objectAnimator.cancel();
                        objectAnimator.removeAllListeners();
                        if (i2 == this.mdx.size() - 1) {
                            objectAnimator.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoControllerLayout.5
                                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (!this.mes) {
                                        VideoControllerLayout.this.mdF.setVisibility(8);
                                        if (VideoControllerLayout.this.mdy != null) {
                                            VideoControllerLayout.this.mdy.dpd();
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
        this.mdy = aVar;
    }

    public void setCurrentTab(int i) {
        this.hSW = i;
        switch (this.hSW) {
            case 1:
                this.mdr.setVisibility(4);
                this.mdu.setVisibility(4);
                this.mdt.getLayer1().setVisibility(8);
                return;
            case 2:
                if (this.maO.getStatus() != 1) {
                    this.mdr.setVisibility(0);
                    this.mdu.setVisibility(0);
                }
                this.mdt.getLayer1().setVisibility(0);
                return;
            default:
                return;
        }
    }

    public boolean dpp() {
        return this.mdF.getVisibility() == 0;
    }

    public void setStickerItems(List<StickerItem> list) {
        if (this.mdF != null) {
            this.mdF.setStickerItems(list);
        }
    }

    public void b(StickerItem stickerItem) {
        if (this.mdF != null) {
            this.mdF.c(stickerItem);
        }
    }

    public void setDownLoadSticker(StickerItem stickerItem) {
        if (this.mdF != null) {
            this.mdF.setDownLoadStrick(stickerItem);
        }
    }

    public boolean dpq() {
        if (this.mdF != null) {
            return this.mdF.dpq();
        }
        return false;
    }

    public void setHasLocalVideo(boolean z) {
        this.mdz = z;
    }

    public List<e> getChoosedBeautyList() {
        return this.mdB;
    }

    public List<e> getChoosedFilterList() {
        return this.mdC;
    }

    public List<StickerItem> getChoosedStickerList() {
        return this.mdD;
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void setMusicData(List<MusicData> list) {
        if (list != null && list.size() > 0) {
            for (MusicData musicData : list) {
                this.mdE.add(new e(3, musicData.name, musicData, -1));
            }
        }
        if (this.mdF != null) {
            this.mdF.setMusicList(this.mdE);
        }
    }

    @Override // com.baidu.tieba.video.editvideo.b
    public void t(String str, int i, String str2) {
    }

    public void dpr() {
        if (this.mdF != null) {
            this.mdF.dpr();
        }
    }

    public void dof() {
        if (this.mdF != null) {
            this.mdF.dof();
        }
    }
}
