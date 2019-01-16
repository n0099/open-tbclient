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
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String aTT;
    private HListView dBo;
    private HListView hNJ;
    private d hNK;
    private k hNL;
    private List<e> hNM;
    private List<e> hNN;
    private List<e> hNO;
    private String hNP;
    private String hNQ;
    private e<com.baidu.tieba.video.a> hNR;
    private e<String> hNS;
    private e<MusicData> hNT;
    private StickerItem hNU;
    private AnimatorSet hNV;
    private AnimatorSet hNW;
    private AnimatorSet hNX;
    private int hNY;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes5.dex */
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
        bMC();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.dBo = (HListView) findViewById(e.g.effect_list_view);
        this.dBo.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.dBo.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hNJ = (HListView) findViewById(e.g.sticker_list_view);
        this.hNJ.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hNK = new d();
        this.dBo.setAdapter((ListAdapter) this.hNK);
        this.hNL = new k();
        this.hNJ.setAdapter((ListAdapter) this.hNL);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wQ(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bMC() {
        this.hNP = "2";
        this.hNR = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wA(2));
        this.aTT = getString(e.j.filter_nature);
        this.hNS = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hNU = stickerItem;
        this.hNQ = getResources().getString(e.j.music_normal);
        this.hNT = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bMD() {
        if (this.hNM == null) {
            this.hNM = new ArrayList();
            a("No", com.baidu.tieba.video.a.wA(0));
            a("1", com.baidu.tieba.video.a.wA(1));
            a("2", com.baidu.tieba.video.a.wA(2));
            a("3", com.baidu.tieba.video.a.wA(3));
            a("4", com.baidu.tieba.video.a.wA(4));
            a("5", com.baidu.tieba.video.a.wA(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hNM.add(c(0, 1, str, aVar));
    }

    private void bME() {
        if (this.hNN == null) {
            this.hNN = new ArrayList();
            m(e.f.filter_icon_avatar_default, getString(e.j.filter_nature), "origin");
            m(e.f.filter_icon_avatar_hongkong, getString(e.j.filter_hongkong), "hongkong");
            m(e.f.filter_icon_avatar_refreshing, getString(e.j.filter_refreshing), "refreshing");
            m(e.f.filter_icon_avatar_girly, getString(e.j.filter_girly), "girly");
            m(e.f.filter_icon_avatar_concrete, getString(e.j.filter_concrete), "concrete");
            m(e.f.filter_icon_avatar_warm, getString(e.j.filter_warm), "warm");
            m(e.f.filter_icon_avatar_cold, getString(e.j.filter_cold), "cold");
            m(e.f.filter_icon_avatar_japanese, getString(e.j.filter_japanese), "Japanese");
            m(e.f.filter_icon_avatar_cruz, getString(e.j.filter_hdr), "cruz");
            m(e.f.filter_icon_avatar_abao, getString(e.j.filter_abao), "abao");
            m(e.f.filter_icon_avatar_dew, getString(e.j.filter_dew), "dew");
            m(e.f.filter_icon_avatar_slowlived, getString(e.j.filter_slowlived), "slowlived");
            m(e.f.filter_icon_avatar_sweet, getString(e.j.filter_sweet), "sweet");
            m(e.f.filter_icon_avatar_boardwalk, getString(e.j.filter_boardwalk), "boardwalk");
            m(e.f.filter_icon_avatar_keylime, getString(e.j.filter_keylime), "keylime");
            m(e.f.filter_icon_avatar_electric, getString(e.j.filter_electric), "electric");
            m(e.f.filter_icon_avatar_silver, getString(e.j.filter_silver), "silver");
            m(e.f.filter_icon_avatar_blackwhite, getString(e.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void m(int i, String str, String str2) {
        if (this.hNN != null) {
            this.hNN.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMf() {
        this.hNY = 3;
        l(this.hNO, this.hNQ);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMg() {
        this.hNY = 0;
        this.hNJ.setAdapter((ListAdapter) this.hNL);
        this.hNL.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ol(true);
            return;
        }
        this.hNJ.setVisibility(0);
        this.dBo.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMh() {
        this.hNY = 1;
        bMD();
        l(this.hNM, this.hNP);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMi() {
        this.hNY = 2;
        bME();
        l(this.hNN, this.aTT);
    }

    public void setListener(final a aVar) {
        if (this.hNK != null) {
            this.hNK.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hNP = eVar.getName();
                                VideoEffectLayout.this.hNR = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aTT = eVar.getName();
                                VideoEffectLayout.this.hNS = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hNQ = eVar.getName();
                                VideoEffectLayout.this.hNT = eVar;
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
        if (this.hNL != null) {
            this.hNL.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hNU = stickerItem;
        if (!v.I(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hNL != null) {
                this.hNL.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.I(this.mStickerItems)) {
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
            if (this.hNL != null) {
                this.hNL.notifyDataSetChanged();
            }
        }
    }

    private void l(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hNK.setData(list, str);
                    VideoEffectLayout.this.hNK.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hNJ.getVisibility() == 0) {
                runnable.run();
                ol(false);
            } else {
                bMF();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dBo.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hNY;
    }

    public e<String> getCurrentFilterItem() {
        return this.hNS;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hNR;
    }

    public StickerItem getCurrentStickItem() {
        return this.hNU;
    }

    private void bMF() {
        if (this.hNW != null && this.hNW.isRunning()) {
            this.hNW.cancel();
        }
        if (this.hNV == null) {
            this.hNV = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dBo, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dBo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hNV.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dBo.setVisibility(0);
        this.hNV.start();
    }

    private void ol(boolean z) {
        if (z) {
            if (this.hNX != null && this.hNX.isRunning()) {
                this.hNX.cancel();
            }
            if (this.hNV != null && this.hNV.isRunning()) {
                this.hNV.cancel();
            }
            if (this.hNW == null) {
                this.hNW = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dBo, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hNJ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hNJ != null) {
                            VideoEffectLayout.this.hNJ.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hOi && VideoEffectLayout.this.dBo != null) {
                            VideoEffectLayout.this.dBo.setVisibility(8);
                        }
                    }
                });
                this.hNW.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hNW.start();
            return;
        }
        if (this.hNW != null && this.hNW.isRunning()) {
            this.hNW.cancel();
        }
        if (this.hNX == null) {
            this.hNX = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hNJ, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dBo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dBo != null) {
                        VideoEffectLayout.this.dBo.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOi && VideoEffectLayout.this.hNJ != null) {
                        VideoEffectLayout.this.hNJ.setVisibility(8);
                    }
                }
            });
            this.hNX.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hNX.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hNL != null) {
            this.hNL.C(list);
            this.hNL.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hNO == null) {
            this.hNO = new ArrayList();
        } else {
            this.hNO.clear();
        }
        this.hNO.addAll(list);
    }

    public boolean bMA() {
        if (v.I(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bMB() {
        if (this.hNK != null) {
            this.hNK.bLo();
            this.hNQ = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bLp() {
        if (this.hNK != null) {
            this.hNK.bLp();
        }
    }
}
