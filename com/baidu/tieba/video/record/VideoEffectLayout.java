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
    private String gBB;
    private d<com.baidu.tieba.video.a> gBC;
    private d<String> gBD;
    private StickerItem gBE;
    private AnimatorSet gBF;
    private AnimatorSet gBG;
    private AnimatorSet gBH;
    private int gBI;
    private HListView gBw;
    private c gBx;
    private j gBy;
    private List<d> gBz;
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
        this.gBB = "2";
        this.gBC = c(d.g.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uq(2));
        this.auz = getString(d.l.filter_nature);
        this.gBD = c(d.g.filter_icon_avatar_default, 2, getString(d.l.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gBE = stickerItem;
        inflate(getContext(), d.j.layout_effect_container, this);
        this.clS = (HListView) findViewById(d.h.effect_list_view);
        this.clS.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.f.ds28));
        this.clS.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBw = (HListView) findViewById(d.h.sticker_list_view);
        this.gBw.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBx = new c();
        this.clS.setAdapter((ListAdapter) this.gBx);
        this.gBy = new j();
        this.gBw.setAdapter((ListAdapter) this.gBy);
    }

    private <T> d<T> c(int i, int i2, String str, T t) {
        d<T> dVar = new d<>();
        dVar.setType(i2);
        dVar.uC(i);
        dVar.setName(str);
        dVar.setValue(t);
        return dVar;
    }

    private void bxP() {
        if (this.gBz == null) {
            this.gBz = new ArrayList();
            a(d.g.beauty_icon_avatar_0, "Normal", com.baidu.tieba.video.a.uq(0));
            a(d.g.beauty_icon_avatar_1, "1", com.baidu.tieba.video.a.uq(1));
            a(d.g.beauty_icon_avatar_2, "2", com.baidu.tieba.video.a.uq(2));
            a(d.g.beauty_icon_avatar_3, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, com.baidu.tieba.video.a.uq(3));
            a(d.g.beauty_icon_avatar_4, "4", com.baidu.tieba.video.a.uq(4));
            a(d.g.beauty_icon_avatar_5, "5", com.baidu.tieba.video.a.uq(5));
        }
    }

    private void a(int i, String str, com.baidu.tieba.video.a aVar) {
        this.gBz.add(c(i, 1, str, aVar));
    }

    private void bxQ() {
        if (this.gBA == null) {
            this.gBA = new ArrayList();
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
        if (this.gBA != null) {
            this.gBA.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxv() {
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
        this.gBI = 0;
        this.gBw.setAdapter((ListAdapter) this.gBy);
        this.gBy.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ni(true);
            return;
        }
        this.gBw.setVisibility(0);
        this.clS.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        this.gBI = 1;
        bxP();
        k(this.gBz, this.gBB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        this.gBI = 2;
        bxQ();
        k(this.gBA, this.auz);
    }

    public void setListener(final a aVar) {
        if (this.gBx != null) {
            this.gBx.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar) {
                    if (dVar != null) {
                        if (aVar != null) {
                            aVar.a(dVar);
                        }
                        switch (dVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gBB = dVar.getName();
                                VideoEffectLayout.this.gBC = dVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.auz = dVar.getName();
                                VideoEffectLayout.this.gBD = dVar;
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
        if (this.gBy != null) {
            this.gBy.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gBE = stickerItem;
        if (!v.u(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gBy != null) {
                this.gBy.notifyDataSetChanged();
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
            if (this.gBy != null) {
                this.gBy.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<d> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gBx.d(list, str);
                    VideoEffectLayout.this.gBx.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gBw.getVisibility() == 0) {
                runnable.run();
                ni(false);
            } else {
                bxR();
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
        return this.gBI;
    }

    public d<String> getCurrentFilterItem() {
        return this.gBD;
    }

    public d<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gBC;
    }

    public StickerItem getCurrentStickItem() {
        return this.gBE;
    }

    private void bxR() {
        if (this.gBG != null && this.gBG.isRunning()) {
            this.gBG.cancel();
        }
        if (this.gBF == null) {
            this.gBF = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clS, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.clS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gBF.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.clS.setVisibility(0);
        this.gBF.start();
    }

    private void ni(boolean z) {
        if (z) {
            if (this.gBH != null && this.gBH.isRunning()) {
                this.gBH.cancel();
            }
            if (this.gBF != null && this.gBF.isRunning()) {
                this.gBF.cancel();
            }
            if (this.gBG == null) {
                this.gBG = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clS, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBw, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gBw != null) {
                            VideoEffectLayout.this.gBw.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gBP && VideoEffectLayout.this.clS != null) {
                            VideoEffectLayout.this.clS.setVisibility(8);
                        }
                    }
                });
                this.gBG.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gBG.start();
            return;
        }
        if (this.gBG != null && this.gBG.isRunning()) {
            this.gBG.cancel();
        }
        if (this.gBH == null) {
            this.gBH = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gBw, "alpha", 1.0f, 0.0f);
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
                    if (!this.gBP && VideoEffectLayout.this.gBw != null) {
                        VideoEffectLayout.this.gBw.setVisibility(8);
                    }
                }
            });
            this.gBH.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gBH.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gBy != null) {
            this.gBy.p(list);
            this.gBy.notifyDataSetChanged();
        }
    }

    public boolean bxO() {
        if (v.u(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }
}
