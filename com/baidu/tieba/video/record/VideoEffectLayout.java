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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String auz;
    private HListView clS;
    private List<d> gBA;
    private List<d> gBB;
    private String gBC;
    private d<com.baidu.tieba.video.a> gBD;
    private d<String> gBE;
    private StickerItem gBF;
    private AnimatorSet gBG;
    private AnimatorSet gBH;
    private AnimatorSet gBI;
    private int gBJ;
    private HListView gBx;
    private c gBy;
    private j gBz;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes2.dex */
    public interface a {
        void a(StickerItem stickerItem);

        void a(d dVar);
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
        this.gBC = "2";
        this.gBD = c(d.g.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uq(2));
        this.auz = getString(d.l.filter_nature);
        this.gBE = c(d.g.filter_icon_avatar_default, 2, getString(d.l.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gBF = stickerItem;
        inflate(getContext(), d.j.layout_effect_container, this);
        this.clS = (HListView) findViewById(d.h.effect_list_view);
        this.clS.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.f.ds28));
        this.clS.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBx = (HListView) findViewById(d.h.sticker_list_view);
        this.gBx.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBy = new c();
        this.clS.setAdapter((ListAdapter) this.gBy);
        this.gBz = new j();
        this.gBx.setAdapter((ListAdapter) this.gBz);
    }

    private <T> d<T> c(int i, int i2, String str, T t) {
        d<T> dVar = new d<>();
        dVar.setType(i2);
        dVar.uC(i);
        dVar.setName(str);
        dVar.setValue(t);
        return dVar;
    }

    private void bxQ() {
        if (this.gBA == null) {
            this.gBA = new ArrayList();
            a(d.g.beauty_icon_avatar_0, "Normal", com.baidu.tieba.video.a.uq(0));
            a(d.g.beauty_icon_avatar_1, "1", com.baidu.tieba.video.a.uq(1));
            a(d.g.beauty_icon_avatar_2, "2", com.baidu.tieba.video.a.uq(2));
            a(d.g.beauty_icon_avatar_3, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, com.baidu.tieba.video.a.uq(3));
            a(d.g.beauty_icon_avatar_4, "4", com.baidu.tieba.video.a.uq(4));
            a(d.g.beauty_icon_avatar_5, "5", com.baidu.tieba.video.a.uq(5));
        }
    }

    private void a(int i, String str, com.baidu.tieba.video.a aVar) {
        this.gBA.add(c(i, 1, str, aVar));
    }

    private void bxR() {
        if (this.gBB == null) {
            this.gBB = new ArrayList();
            k(d.g.filter_icon_avatar_default, getString(d.l.filter_nature), "nature");
            k(d.g.filter_icon_avatar_hongkong, getString(d.l.filter_hongkong), "hongkong");
            k(d.g.filter_icon_avatar_refreshing, getString(d.l.filter_refreshing), "refreshing");
            k(d.g.filter_icon_avatar_girly, getString(d.l.filter_girly), "girly");
            k(d.g.filter_icon_avatar_concrete, getString(d.l.filter_concrete), "concrete");
            k(d.g.filter_icon_avatar_warm, getString(d.l.filter_warm), "warm");
            k(d.g.filter_icon_avatar_cold, getString(d.l.filter_cold), "cold");
            k(d.g.filter_icon_avatar_japanese, getString(d.l.filter_japanese), "Japanese");
            k(d.g.filter_icon_avatar_cruz, getString(d.l.filter_hdr), "cruz");
            k(d.g.filter_icon_avatar_abao, getString(d.l.filter_abao), "abao");
            k(d.g.filter_icon_avatar_dew, getString(d.l.filter_dew), "dew");
            k(d.g.filter_icon_avatar_slowlived, getString(d.l.filter_slowlived), "slowlived");
            k(d.g.filter_icon_avatar_sweet, getString(d.l.filter_sweet), "sweet");
            k(d.g.filter_icon_avatar_boardwalk, getString(d.l.filter_boardwalk), "boardwalk");
            k(d.g.filter_icon_avatar_keylime, getString(d.l.filter_keylime), "keylime");
            k(d.g.filter_icon_avatar_electric, getString(d.l.filter_electric), "electric");
            k(d.g.filter_icon_avatar_silver, getString(d.l.filter_silver), "silver");
            k(d.g.filter_icon_avatar_blackwhite, getString(d.l.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void k(int i, String str, String str2) {
        if (this.gBB != null) {
            this.gBB.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        this.gBJ = 0;
        this.gBx.setAdapter((ListAdapter) this.gBz);
        this.gBz.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ni(true);
            return;
        }
        this.gBx.setVisibility(0);
        this.clS.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        this.gBJ = 1;
        bxQ();
        k(this.gBA, this.gBC);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxz() {
        this.gBJ = 2;
        bxR();
        k(this.gBB, this.auz);
    }

    public void setListener(final a aVar) {
        if (this.gBy != null) {
            this.gBy.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar) {
                    if (dVar != null) {
                        if (aVar != null) {
                            aVar.a(dVar);
                        }
                        switch (dVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gBC = dVar.getName();
                                VideoEffectLayout.this.gBD = dVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.auz = dVar.getName();
                                VideoEffectLayout.this.gBE = dVar;
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
        if (this.gBz != null) {
            this.gBz.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar) {
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
        this.gBF = stickerItem;
        if (!v.u(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gBz != null) {
                this.gBz.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.u(this.mStickerItems)) {
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
            if (this.gBz != null) {
                this.gBz.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<d> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gBy.d(list, str);
                    VideoEffectLayout.this.gBy.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gBx.getVisibility() == 0) {
                runnable.run();
                ni(false);
            } else {
                bxS();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.clS.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gBJ;
    }

    public d<String> getCurrentFilterItem() {
        return this.gBE;
    }

    public d<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gBD;
    }

    public StickerItem getCurrentStickItem() {
        return this.gBF;
    }

    private void bxS() {
        if (this.gBH != null && this.gBH.isRunning()) {
            this.gBH.cancel();
        }
        if (this.gBG == null) {
            this.gBG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clS, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.clS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gBG.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.clS.setVisibility(0);
        this.gBG.start();
    }

    private void ni(boolean z) {
        if (z) {
            if (this.gBI != null && this.gBI.isRunning()) {
                this.gBI.cancel();
            }
            if (this.gBG != null && this.gBG.isRunning()) {
                this.gBG.cancel();
            }
            if (this.gBH == null) {
                this.gBH = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clS, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBx, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gBx != null) {
                            VideoEffectLayout.this.gBx.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gBQ && VideoEffectLayout.this.clS != null) {
                            VideoEffectLayout.this.clS.setVisibility(8);
                        }
                    }
                });
                this.gBH.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gBH.start();
            return;
        }
        if (this.gBH != null && this.gBH.isRunning()) {
            this.gBH.cancel();
        }
        if (this.gBI == null) {
            this.gBI = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gBx, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.clS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.clS != null) {
                        VideoEffectLayout.this.clS.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBQ && VideoEffectLayout.this.gBx != null) {
                        VideoEffectLayout.this.gBx.setVisibility(8);
                    }
                }
            });
            this.gBI.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gBI.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gBz != null) {
            this.gBz.p(list);
            this.gBz.notifyDataSetChanged();
        }
    }

    public boolean bxP() {
        if (v.u(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }
}
