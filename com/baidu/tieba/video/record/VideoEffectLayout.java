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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String evm;
    private HListView hys;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private StickerItem mlA;
    private AnimatorSet mlB;
    private AnimatorSet mlC;
    private AnimatorSet mlD;
    private int mlE;
    private HListView mlp;
    private d mlq;
    private k mlr;
    private List<e> mls;
    private List<e> mlt;
    private List<e> mlu;
    private String mlv;
    private String mlw;
    private e<com.baidu.tieba.video.a> mlx;
    private e<String> mly;
    private e<MusicData> mlz;

    /* loaded from: classes17.dex */
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
        dsG();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hys = (HListView) findViewById(R.id.effect_list_view);
        this.hys.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hys.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mlp = (HListView) findViewById(R.id.sticker_list_view);
        this.mlp.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mlq = new d();
        this.hys.setAdapter((ListAdapter) this.mlq);
        this.mlr = new k();
        this.mlp.setAdapter((ListAdapter) this.mlr);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.GD(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dsG() {
        this.mlv = "2";
        this.mlx = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Gm(2));
        this.evm = getString(R.string.filter_nature);
        this.mly = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mlA = stickerItem;
        this.mlw = getResources().getString(R.string.music_normal);
        this.mlz = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dsH() {
        if (this.mls == null) {
            this.mls = new ArrayList();
            a("No", com.baidu.tieba.video.a.Gm(0));
            a("1", com.baidu.tieba.video.a.Gm(1));
            a("2", com.baidu.tieba.video.a.Gm(2));
            a("3", com.baidu.tieba.video.a.Gm(3));
            a("4", com.baidu.tieba.video.a.Gm(4));
            a("5", com.baidu.tieba.video.a.Gm(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mls.add(b(0, 1, str, aVar));
    }

    private void dsI() {
        if (this.mlt == null) {
            this.mlt = new ArrayList();
            p(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            p(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            p(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            p(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            p(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            p(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            p(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            p(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            p(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            p(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            p(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            p(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            p(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            p(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            p(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            p(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            p(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            p(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void p(int i, String str, String str2) {
        if (this.mlt != null) {
            this.mlt.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsj() {
        this.mlE = 3;
        n(this.mlu, this.mlw);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsk() {
        this.mlE = 0;
        this.mlp.setAdapter((ListAdapter) this.mlr);
        this.mlr.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            vZ(true);
            return;
        }
        this.mlp.setVisibility(0);
        this.hys.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsl() {
        this.mlE = 1;
        dsH();
        n(this.mls, this.mlv);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsm() {
        this.mlE = 2;
        dsI();
        n(this.mlt, this.evm);
    }

    public void setListener(final a aVar) {
        if (this.mlq != null) {
            this.mlq.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.mlv = eVar.getName();
                                VideoEffectLayout.this.mlx = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.evm = eVar.getName();
                                VideoEffectLayout.this.mly = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.mlw = eVar.getName();
                                VideoEffectLayout.this.mlz = eVar;
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
        if (this.mlr != null) {
            this.mlr.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mlA = stickerItem;
        if (!x.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mlr != null) {
                this.mlr.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!x.isEmpty(this.mStickerItems)) {
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
            if (this.mlr != null) {
                this.mlr.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mlq.b(list, str);
                    VideoEffectLayout.this.mlq.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mlp.getVisibility() == 0) {
                runnable.run();
                vZ(false);
            } else {
                dsJ();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hys.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.mlE;
    }

    public e<String> getCurrentFilterItem() {
        return this.mly;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mlx;
    }

    public StickerItem getCurrentStickItem() {
        return this.mlA;
    }

    private void dsJ() {
        if (this.mlC != null && this.mlC.isRunning()) {
            this.mlC.cancel();
        }
        if (this.mlB == null) {
            this.mlB = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hys, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hys, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.mlB.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hys.setVisibility(0);
        this.mlB.start();
    }

    private void vZ(boolean z) {
        if (z) {
            if (this.mlD != null && this.mlD.isRunning()) {
                this.mlD.cancel();
            }
            if (this.mlB != null && this.mlB.isRunning()) {
                this.mlB.cancel();
            }
            if (this.mlC == null) {
                this.mlC = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hys, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mlp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mlp != null) {
                            VideoEffectLayout.this.mlp.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mlN && VideoEffectLayout.this.hys != null) {
                            VideoEffectLayout.this.hys.setVisibility(8);
                        }
                    }
                });
                this.mlC.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.mlC.start();
            return;
        }
        if (this.mlC != null && this.mlC.isRunning()) {
            this.mlC.cancel();
        }
        if (this.mlD == null) {
            this.mlD = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mlp, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hys, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hys != null) {
                        VideoEffectLayout.this.hys.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlN && VideoEffectLayout.this.mlp != null) {
                        VideoEffectLayout.this.mlp.setVisibility(8);
                    }
                }
            });
            this.mlD.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mlD.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mlr != null) {
            this.mlr.aK(list);
            this.mlr.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mlu == null) {
            this.mlu = new ArrayList();
        } else {
            this.mlu.clear();
        }
        this.mlu.addAll(list);
    }

    public boolean dsE() {
        if (x.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dsF() {
        if (this.mlq != null) {
            this.mlq.drs();
            this.mlw = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void drt() {
        if (this.mlq != null) {
            this.mlq.drt();
        }
    }
}
