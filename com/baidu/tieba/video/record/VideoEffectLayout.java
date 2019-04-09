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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String ccO;
    private HListView eOs;
    private HListView jdV;
    private d jdW;
    private k jdX;
    private List<e> jdY;
    private List<e> jdZ;
    private List<e> jea;
    private String jeb;
    private String jec;
    private e<com.baidu.tieba.video.a> jed;
    private e<String> jee;
    private e<MusicData> jef;
    private StickerItem jeg;
    private AnimatorSet jeh;
    private AnimatorSet jei;
    private AnimatorSet jej;
    private int jek;
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
        cmb();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.eOs = (HListView) findViewById(d.g.effect_list_view);
        this.eOs.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.eOs.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jdV = (HListView) findViewById(d.g.sticker_list_view);
        this.jdV.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jdW = new d();
        this.eOs.setAdapter((ListAdapter) this.jdW);
        this.jdX = new k();
        this.jdV.setAdapter((ListAdapter) this.jdX);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Ay(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cmb() {
        this.jeb = "2";
        this.jed = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Ai(2));
        this.ccO = getString(d.j.filter_nature);
        this.jee = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jeg = stickerItem;
        this.jec = getResources().getString(d.j.music_normal);
        this.jef = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    private void cmc() {
        if (this.jdY == null) {
            this.jdY = new ArrayList();
            a("No", com.baidu.tieba.video.a.Ai(0));
            a("1", com.baidu.tieba.video.a.Ai(1));
            a("2", com.baidu.tieba.video.a.Ai(2));
            a("3", com.baidu.tieba.video.a.Ai(3));
            a("4", com.baidu.tieba.video.a.Ai(4));
            a("5", com.baidu.tieba.video.a.Ai(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jdY.add(c(0, 1, str, aVar));
    }

    private void cmd() {
        if (this.jdZ == null) {
            this.jdZ = new ArrayList();
            m(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "origin");
            m(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            m(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            m(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            m(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            m(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            m(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            m(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            m(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            m(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            m(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            m(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            m(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            m(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            m(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            m(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            m(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            m(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void m(int i, String str, String str2) {
        if (this.jdZ != null) {
            this.jdZ.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        this.jek = 3;
        n(this.jea, this.jec);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        this.jek = 0;
        this.jdV.setAdapter((ListAdapter) this.jdX);
        this.jdX.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            qL(true);
            return;
        }
        this.jdV.setVisibility(0);
        this.eOs.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        this.jek = 1;
        cmc();
        n(this.jdY, this.jeb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jek = 2;
        cmd();
        n(this.jdZ, this.ccO);
    }

    public void setListener(final a aVar) {
        if (this.jdW != null) {
            this.jdW.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jeb = eVar.getName();
                                VideoEffectLayout.this.jed = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ccO = eVar.getName();
                                VideoEffectLayout.this.jee = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jec = eVar.getName();
                                VideoEffectLayout.this.jef = eVar;
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
        if (this.jdX != null) {
            this.jdX.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jeg = stickerItem;
        if (!v.T(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jdX != null) {
                this.jdX.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.T(this.mStickerItems)) {
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
            if (this.jdX != null) {
                this.jdX.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jdW.b(list, str);
                    VideoEffectLayout.this.jdW.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jdV.getVisibility() == 0) {
                runnable.run();
                qL(false);
            } else {
                cme();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.eOs.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jek;
    }

    public e<String> getCurrentFilterItem() {
        return this.jee;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jed;
    }

    public StickerItem getCurrentStickItem() {
        return this.jeg;
    }

    private void cme() {
        if (this.jei != null && this.jei.isRunning()) {
            this.jei.cancel();
        }
        if (this.jeh == null) {
            this.jeh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOs, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.eOs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jeh.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.eOs.setVisibility(0);
        this.jeh.start();
    }

    private void qL(boolean z) {
        if (z) {
            if (this.jej != null && this.jej.isRunning()) {
                this.jej.cancel();
            }
            if (this.jeh != null && this.jeh.isRunning()) {
                this.jeh.cancel();
            }
            if (this.jei == null) {
                this.jei = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOs, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jdV, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jdV != null) {
                            VideoEffectLayout.this.jdV.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jet && VideoEffectLayout.this.eOs != null) {
                            VideoEffectLayout.this.eOs.setVisibility(8);
                        }
                    }
                });
                this.jei.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jei.start();
            return;
        }
        if (this.jei != null && this.jei.isRunning()) {
            this.jei.cancel();
        }
        if (this.jej == null) {
            this.jej = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jdV, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.eOs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.eOs != null) {
                        VideoEffectLayout.this.eOs.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jet && VideoEffectLayout.this.jdV != null) {
                        VideoEffectLayout.this.jdV.setVisibility(8);
                    }
                }
            });
            this.jej.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jej.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jdX != null) {
            this.jdX.M(list);
            this.jdX.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jea == null) {
            this.jea = new ArrayList();
        } else {
            this.jea.clear();
        }
        this.jea.addAll(list);
    }

    public boolean clZ() {
        if (v.T(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cma() {
        if (this.jdW != null) {
            this.jdW.ckN();
            this.jec = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void ckO() {
        if (this.jdW != null) {
            this.jdW.ckO();
        }
    }
}
