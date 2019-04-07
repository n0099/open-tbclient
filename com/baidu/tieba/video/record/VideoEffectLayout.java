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
    private String ccN;
    private HListView eOr;
    private HListView jdU;
    private d jdV;
    private k jdW;
    private List<e> jdX;
    private List<e> jdY;
    private List<e> jdZ;
    private String jea;
    private String jeb;
    private e<com.baidu.tieba.video.a> jec;
    private e<String> jed;
    private e<MusicData> jee;
    private StickerItem jef;
    private AnimatorSet jeg;
    private AnimatorSet jeh;
    private AnimatorSet jei;
    private int jej;
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
        this.eOr = (HListView) findViewById(d.g.effect_list_view);
        this.eOr.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.eOr.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jdU = (HListView) findViewById(d.g.sticker_list_view);
        this.jdU.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jdV = new d();
        this.eOr.setAdapter((ListAdapter) this.jdV);
        this.jdW = new k();
        this.jdU.setAdapter((ListAdapter) this.jdW);
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
        this.jea = "2";
        this.jec = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Ai(2));
        this.ccN = getString(d.j.filter_nature);
        this.jed = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jef = stickerItem;
        this.jeb = getResources().getString(d.j.music_normal);
        this.jee = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    private void cmc() {
        if (this.jdX == null) {
            this.jdX = new ArrayList();
            a("No", com.baidu.tieba.video.a.Ai(0));
            a("1", com.baidu.tieba.video.a.Ai(1));
            a("2", com.baidu.tieba.video.a.Ai(2));
            a("3", com.baidu.tieba.video.a.Ai(3));
            a("4", com.baidu.tieba.video.a.Ai(4));
            a("5", com.baidu.tieba.video.a.Ai(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jdX.add(c(0, 1, str, aVar));
    }

    private void cmd() {
        if (this.jdY == null) {
            this.jdY = new ArrayList();
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
        if (this.jdY != null) {
            this.jdY.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        this.jej = 3;
        n(this.jdZ, this.jeb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        this.jej = 0;
        this.jdU.setAdapter((ListAdapter) this.jdW);
        this.jdW.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            qL(true);
            return;
        }
        this.jdU.setVisibility(0);
        this.eOr.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        this.jej = 1;
        cmc();
        n(this.jdX, this.jea);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jej = 2;
        cmd();
        n(this.jdY, this.ccN);
    }

    public void setListener(final a aVar) {
        if (this.jdV != null) {
            this.jdV.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jea = eVar.getName();
                                VideoEffectLayout.this.jec = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ccN = eVar.getName();
                                VideoEffectLayout.this.jed = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jeb = eVar.getName();
                                VideoEffectLayout.this.jee = eVar;
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
        if (this.jdW != null) {
            this.jdW.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jef = stickerItem;
        if (!v.T(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jdW != null) {
                this.jdW.notifyDataSetChanged();
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
            if (this.jdW != null) {
                this.jdW.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jdV.b(list, str);
                    VideoEffectLayout.this.jdV.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jdU.getVisibility() == 0) {
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
                VideoEffectLayout.this.eOr.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jej;
    }

    public e<String> getCurrentFilterItem() {
        return this.jed;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jec;
    }

    public StickerItem getCurrentStickItem() {
        return this.jef;
    }

    private void cme() {
        if (this.jeh != null && this.jeh.isRunning()) {
            this.jeh.cancel();
        }
        if (this.jeg == null) {
            this.jeg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOr, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.eOr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jeg.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.eOr.setVisibility(0);
        this.jeg.start();
    }

    private void qL(boolean z) {
        if (z) {
            if (this.jei != null && this.jei.isRunning()) {
                this.jei.cancel();
            }
            if (this.jeg != null && this.jeg.isRunning()) {
                this.jeg.cancel();
            }
            if (this.jeh == null) {
                this.jeh = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOr, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jdU, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jdU != null) {
                            VideoEffectLayout.this.jdU.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jes && VideoEffectLayout.this.eOr != null) {
                            VideoEffectLayout.this.eOr.setVisibility(8);
                        }
                    }
                });
                this.jeh.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jeh.start();
            return;
        }
        if (this.jeh != null && this.jeh.isRunning()) {
            this.jeh.cancel();
        }
        if (this.jei == null) {
            this.jei = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jdU, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.eOr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.eOr != null) {
                        VideoEffectLayout.this.eOr.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jes && VideoEffectLayout.this.jdU != null) {
                        VideoEffectLayout.this.jdU.setVisibility(8);
                    }
                }
            });
            this.jei.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jei.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jdW != null) {
            this.jdW.M(list);
            this.jdW.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jdZ == null) {
            this.jdZ = new ArrayList();
        } else {
            this.jdZ.clear();
        }
        this.jdZ.addAll(list);
    }

    public boolean clZ() {
        if (v.T(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cma() {
        if (this.jdV != null) {
            this.jdV.ckN();
            this.jeb = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void ckO() {
        if (this.jdV != null) {
            this.jdV.ckO();
        }
    }
}
