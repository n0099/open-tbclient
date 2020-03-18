package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String drR;
    private HListView gin;
    private HListView kFK;
    private d kFL;
    private k kFM;
    private List<e> kFN;
    private List<e> kFO;
    private List<e> kFP;
    private String kFQ;
    private String kFR;
    private e<com.baidu.tieba.video.a> kFS;
    private e<String> kFT;
    private e<MusicData> kFU;
    private StickerItem kFV;
    private AnimatorSet kFW;
    private AnimatorSet kFX;
    private AnimatorSet kFY;
    private int kFZ;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes10.dex */
    public interface a {
        void a(StickerItem stickerItem);

        void a(e eVar, Object obj);
    }

    public VideoEffectLayout(Context context) {
        super(context);
        initView();
    }

    public VideoEffectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VideoEffectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.mHandler = new Handler();
        cSE();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gin = (HListView) findViewById(R.id.effect_list_view);
        this.gin.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gin.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kFK = (HListView) findViewById(R.id.sticker_list_view);
        this.kFK.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kFL = new d();
        this.gin.setAdapter((ListAdapter) this.kFL);
        this.kFM = new k();
        this.kFK.setAdapter((ListAdapter) this.kFM);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.DN(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cSE() {
        this.kFQ = "2";
        this.kFS = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dx(2));
        this.drR = getString(R.string.filter_nature);
        this.kFT = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kFV = stickerItem;
        this.kFR = getResources().getString(R.string.music_normal);
        this.kFU = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cSF() {
        if (this.kFN == null) {
            this.kFN = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dx(0));
            a("1", com.baidu.tieba.video.a.Dx(1));
            a("2", com.baidu.tieba.video.a.Dx(2));
            a("3", com.baidu.tieba.video.a.Dx(3));
            a("4", com.baidu.tieba.video.a.Dx(4));
            a("5", com.baidu.tieba.video.a.Dx(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kFN.add(b(0, 1, str, aVar));
    }

    private void cSG() {
        if (this.kFO == null) {
            this.kFO = new ArrayList();
            o(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            o(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            o(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            o(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            o(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            o(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            o(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            o(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            o(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            o(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            o(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            o(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            o(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            o(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            o(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            o(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            o(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            o(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void o(int i, String str, String str2) {
        if (this.kFO != null) {
            this.kFO.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSh() {
        this.kFZ = 3;
        m(this.kFP, this.kFR);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSi() {
        this.kFZ = 0;
        this.kFK.setAdapter((ListAdapter) this.kFM);
        this.kFM.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tD(true);
            return;
        }
        this.kFK.setVisibility(0);
        this.gin.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSj() {
        this.kFZ = 1;
        cSF();
        m(this.kFN, this.kFQ);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSk() {
        this.kFZ = 2;
        cSG();
        m(this.kFO, this.drR);
    }

    public void setListener(final a aVar) {
        if (this.kFL != null) {
            this.kFL.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kFQ = eVar.getName();
                                VideoEffectLayout.this.kFS = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.drR = eVar.getName();
                                VideoEffectLayout.this.kFT = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kFR = eVar.getName();
                                VideoEffectLayout.this.kFU = eVar;
                                return;
                            default:
                                return;
                        }
                    }
                }

                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(StickerItem stickerItem) {
                }
            });
        }
        if (this.kFM != null) {
            this.kFM.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                }

                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(StickerItem stickerItem) {
                    if (stickerItem != null) {
                        VideoEffectLayout.this.c(stickerItem);
                        if (aVar != null) {
                            aVar.a(stickerItem);
                        }
                    }
                }
            });
        }
    }

    public void c(StickerItem stickerItem) {
        this.kFV = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kFM != null) {
                this.kFM.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.isEmpty(this.mStickerItems)) {
            if (stickerItem != null) {
                for (StickerItem stickerItem2 : this.mStickerItems) {
                    if (stickerItem2.id != stickerItem.id) {
                        stickerItem2.isDownLoading = false;
                    } else {
                        stickerItem2.isDownLoading = true;
                    }
                }
            } else {
                for (StickerItem stickerItem3 : this.mStickerItems) {
                    stickerItem3.isDownLoading = false;
                }
            }
            if (this.kFM != null) {
                this.kFM.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kFL.b(list, str);
                    VideoEffectLayout.this.kFL.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kFK.getVisibility() == 0) {
                runnable.run();
                tD(false);
            } else {
                cSH();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.gin.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kFZ;
    }

    public e<String> getCurrentFilterItem() {
        return this.kFT;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kFS;
    }

    public StickerItem getCurrentStickItem() {
        return this.kFV;
    }

    private void cSH() {
        if (this.kFX != null && this.kFX.isRunning()) {
            this.kFX.cancel();
        }
        if (this.kFW == null) {
            this.kFW = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gin, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gin, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kFW.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gin.setVisibility(0);
        this.kFW.start();
    }

    private void tD(boolean z) {
        if (z) {
            if (this.kFY != null && this.kFY.isRunning()) {
                this.kFY.cancel();
            }
            if (this.kFW != null && this.kFW.isRunning()) {
                this.kFW.cancel();
            }
            if (this.kFX == null) {
                this.kFX = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gin, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kFK, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kFK != null) {
                            VideoEffectLayout.this.kFK.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kGi && VideoEffectLayout.this.gin != null) {
                            VideoEffectLayout.this.gin.setVisibility(8);
                        }
                    }
                });
                this.kFX.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kFX.start();
            return;
        }
        if (this.kFX != null && this.kFX.isRunning()) {
            this.kFX.cancel();
        }
        if (this.kFY == null) {
            this.kFY = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kFK, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.gin, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.gin != null) {
                        VideoEffectLayout.this.gin.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kGi && VideoEffectLayout.this.kFK != null) {
                        VideoEffectLayout.this.kFK.setVisibility(8);
                    }
                }
            });
            this.kFY.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kFY.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kFM != null) {
            this.kFM.av(list);
            this.kFM.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kFP == null) {
            this.kFP = new ArrayList();
        } else {
            this.kFP.clear();
        }
        this.kFP.addAll(list);
    }

    public boolean cSC() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cSD() {
        if (this.kFL != null) {
            this.kFL.cRt();
            this.kFR = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cRu() {
        if (this.kFL != null) {
            this.kFL.cRu();
        }
    }
}
