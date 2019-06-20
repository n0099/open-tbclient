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
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String ckT;
    private HListView feB;
    private HListView jwT;
    private d jwU;
    private k jwV;
    private List<e> jwW;
    private List<e> jwX;
    private List<e> jwY;
    private String jwZ;
    private String jxa;
    private e<com.baidu.tieba.video.a> jxb;
    private e<String> jxc;
    private e<MusicData> jxd;
    private StickerItem jxe;
    private AnimatorSet jxf;
    private AnimatorSet jxg;
    private AnimatorSet jxh;
    private int jxi;
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
        cuf();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.feB = (HListView) findViewById(R.id.effect_list_view);
        this.feB.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.feB.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwT = (HListView) findViewById(R.id.sticker_list_view);
        this.jwT.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwU = new d();
        this.feB.setAdapter((ListAdapter) this.jwU);
        this.jwV = new k();
        this.jwT.setAdapter((ListAdapter) this.jwV);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.BG(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cuf() {
        this.jwZ = "2";
        this.jxb = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Bq(2));
        this.ckT = getString(R.string.filter_nature);
        this.jxc = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jxe = stickerItem;
        this.jxa = getResources().getString(R.string.music_normal);
        this.jxd = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cug() {
        if (this.jwW == null) {
            this.jwW = new ArrayList();
            a("No", com.baidu.tieba.video.a.Bq(0));
            a("1", com.baidu.tieba.video.a.Bq(1));
            a("2", com.baidu.tieba.video.a.Bq(2));
            a("3", com.baidu.tieba.video.a.Bq(3));
            a("4", com.baidu.tieba.video.a.Bq(4));
            a("5", com.baidu.tieba.video.a.Bq(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jwW.add(c(0, 1, str, aVar));
    }

    private void cuh() {
        if (this.jwX == null) {
            this.jwX = new ArrayList();
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
        if (this.jwX != null) {
            this.jwX.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        this.jxi = 3;
        n(this.jwY, this.jxa);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        this.jxi = 0;
        this.jwT.setAdapter((ListAdapter) this.jwV);
        this.jwV.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rB(true);
            return;
        }
        this.jwT.setVisibility(0);
        this.feB.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jxi = 1;
        cug();
        n(this.jwW, this.jwZ);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        this.jxi = 2;
        cuh();
        n(this.jwX, this.ckT);
    }

    public void setListener(final a aVar) {
        if (this.jwU != null) {
            this.jwU.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jwZ = eVar.getName();
                                VideoEffectLayout.this.jxb = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ckT = eVar.getName();
                                VideoEffectLayout.this.jxc = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jxa = eVar.getName();
                                VideoEffectLayout.this.jxd = eVar;
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
        if (this.jwV != null) {
            this.jwV.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jxe = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jwV != null) {
                this.jwV.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.aa(this.mStickerItems)) {
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
            if (this.jwV != null) {
                this.jwV.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jwU.b(list, str);
                    VideoEffectLayout.this.jwU.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jwT.getVisibility() == 0) {
                runnable.run();
                rB(false);
            } else {
                cui();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.feB.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jxi;
    }

    public e<String> getCurrentFilterItem() {
        return this.jxc;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jxb;
    }

    public StickerItem getCurrentStickItem() {
        return this.jxe;
    }

    private void cui() {
        if (this.jxg != null && this.jxg.isRunning()) {
            this.jxg.cancel();
        }
        if (this.jxf == null) {
            this.jxf = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feB, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.feB, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jxf.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.feB.setVisibility(0);
        this.jxf.start();
    }

    private void rB(boolean z) {
        if (z) {
            if (this.jxh != null && this.jxh.isRunning()) {
                this.jxh.cancel();
            }
            if (this.jxf != null && this.jxf.isRunning()) {
                this.jxf.cancel();
            }
            if (this.jxg == null) {
                this.jxg = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feB, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jwT, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jwT != null) {
                            VideoEffectLayout.this.jwT.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jxr && VideoEffectLayout.this.feB != null) {
                            VideoEffectLayout.this.feB.setVisibility(8);
                        }
                    }
                });
                this.jxg.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jxg.start();
            return;
        }
        if (this.jxg != null && this.jxg.isRunning()) {
            this.jxg.cancel();
        }
        if (this.jxh == null) {
            this.jxh = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jwT, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.feB, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.feB != null) {
                        VideoEffectLayout.this.feB.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxr && VideoEffectLayout.this.jwT != null) {
                        VideoEffectLayout.this.jwT.setVisibility(8);
                    }
                }
            });
            this.jxh.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jxh.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jwV != null) {
            this.jwV.T(list);
            this.jwV.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jwY == null) {
            this.jwY = new ArrayList();
        } else {
            this.jwY.clear();
        }
        this.jwY.addAll(list);
    }

    public boolean cud() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cue() {
        if (this.jwU != null) {
            this.jwU.csR();
            this.jxa = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void csS() {
        if (this.jwU != null) {
            this.jwU.csS();
        }
    }
}
