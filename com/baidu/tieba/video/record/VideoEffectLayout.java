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
    private String aun;
    private HListView clF;
    private HListView gBh;
    private c gBi;
    private j gBj;
    private List<d> gBk;
    private List<d> gBl;
    private String gBm;
    private d<com.baidu.tieba.video.a> gBn;
    private d<String> gBo;
    private StickerItem gBp;
    private AnimatorSet gBq;
    private AnimatorSet gBr;
    private AnimatorSet gBs;
    private int gBt;
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
        this.gBm = "2";
        this.gBn = c(d.g.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.up(2));
        this.aun = getString(d.l.filter_nature);
        this.gBo = c(d.g.filter_icon_avatar_default, 2, getString(d.l.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gBp = stickerItem;
        inflate(getContext(), d.j.layout_effect_container, this);
        this.clF = (HListView) findViewById(d.h.effect_list_view);
        this.clF.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.f.ds28));
        this.clF.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBh = (HListView) findViewById(d.h.sticker_list_view);
        this.gBh.setSelector(getResources().getDrawable(d.g.transparent_bg));
        this.gBi = new c();
        this.clF.setAdapter((ListAdapter) this.gBi);
        this.gBj = new j();
        this.gBh.setAdapter((ListAdapter) this.gBj);
    }

    private <T> d<T> c(int i, int i2, String str, T t) {
        d<T> dVar = new d<>();
        dVar.setType(i2);
        dVar.uB(i);
        dVar.setName(str);
        dVar.setValue(t);
        return dVar;
    }

    private void bxH() {
        if (this.gBk == null) {
            this.gBk = new ArrayList();
            a(d.g.beauty_icon_avatar_0, "Normal", com.baidu.tieba.video.a.up(0));
            a(d.g.beauty_icon_avatar_1, "1", com.baidu.tieba.video.a.up(1));
            a(d.g.beauty_icon_avatar_2, "2", com.baidu.tieba.video.a.up(2));
            a(d.g.beauty_icon_avatar_3, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, com.baidu.tieba.video.a.up(3));
            a(d.g.beauty_icon_avatar_4, "4", com.baidu.tieba.video.a.up(4));
            a(d.g.beauty_icon_avatar_5, "5", com.baidu.tieba.video.a.up(5));
        }
    }

    private void a(int i, String str, com.baidu.tieba.video.a aVar) {
        this.gBk.add(c(i, 1, str, aVar));
    }

    private void bxI() {
        if (this.gBl == null) {
            this.gBl = new ArrayList();
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
        if (this.gBl != null) {
            this.gBl.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxn() {
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxo() {
        this.gBt = 0;
        this.gBh.setAdapter((ListAdapter) this.gBj);
        this.gBj.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nh(true);
            return;
        }
        this.gBh.setVisibility(0);
        this.clF.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxp() {
        this.gBt = 1;
        bxH();
        k(this.gBk, this.gBm);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxq() {
        this.gBt = 2;
        bxI();
        k(this.gBl, this.aun);
    }

    public void setListener(final a aVar) {
        if (this.gBi != null) {
            this.gBi.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar) {
                    if (dVar != null) {
                        if (aVar != null) {
                            aVar.a(dVar);
                        }
                        switch (dVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gBm = dVar.getName();
                                VideoEffectLayout.this.gBn = dVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aun = dVar.getName();
                                VideoEffectLayout.this.gBo = dVar;
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
        if (this.gBj != null) {
            this.gBj.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gBp = stickerItem;
        if (!v.u(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gBj != null) {
                this.gBj.notifyDataSetChanged();
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
            if (this.gBj != null) {
                this.gBj.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<d> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gBi.d(list, str);
                    VideoEffectLayout.this.gBi.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gBh.getVisibility() == 0) {
                runnable.run();
                nh(false);
            } else {
                bxJ();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.clF.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gBt;
    }

    public d<String> getCurrentFilterItem() {
        return this.gBo;
    }

    public d<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gBn;
    }

    public StickerItem getCurrentStickItem() {
        return this.gBp;
    }

    private void bxJ() {
        if (this.gBr != null && this.gBr.isRunning()) {
            this.gBr.cancel();
        }
        if (this.gBq == null) {
            this.gBq = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clF, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.clF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gBq.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.clF.setVisibility(0);
        this.gBq.start();
    }

    private void nh(boolean z) {
        if (z) {
            if (this.gBs != null && this.gBs.isRunning()) {
                this.gBs.cancel();
            }
            if (this.gBq != null && this.gBq.isRunning()) {
                this.gBq.cancel();
            }
            if (this.gBr == null) {
                this.gBr = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.clF, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBh, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gBh != null) {
                            VideoEffectLayout.this.gBh.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gBA && VideoEffectLayout.this.clF != null) {
                            VideoEffectLayout.this.clF.setVisibility(8);
                        }
                    }
                });
                this.gBr.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gBr.start();
            return;
        }
        if (this.gBr != null && this.gBr.isRunning()) {
            this.gBr.cancel();
        }
        if (this.gBs == null) {
            this.gBs = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gBh, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.clF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.clF != null) {
                        VideoEffectLayout.this.clF.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBA && VideoEffectLayout.this.gBh != null) {
                        VideoEffectLayout.this.gBh.setVisibility(8);
                    }
                }
            });
            this.gBs.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gBs.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gBj != null) {
            this.gBj.p(list);
            this.gBj.notifyDataSetChanged();
        }
    }

    public boolean bxG() {
        if (v.u(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }
}
