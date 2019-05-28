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
    private String ckS;
    private HListView feB;
    private HListView jwQ;
    private d jwR;
    private k jwS;
    private List<e> jwT;
    private List<e> jwU;
    private List<e> jwV;
    private String jwW;
    private String jwX;
    private e<com.baidu.tieba.video.a> jwY;
    private e<String> jwZ;
    private e<MusicData> jxa;
    private StickerItem jxb;
    private AnimatorSet jxc;
    private AnimatorSet jxd;
    private AnimatorSet jxe;
    private int jxf;
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
        cug();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.feB = (HListView) findViewById(R.id.effect_list_view);
        this.feB.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.feB.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwQ = (HListView) findViewById(R.id.sticker_list_view);
        this.jwQ.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwR = new d();
        this.feB.setAdapter((ListAdapter) this.jwR);
        this.jwS = new k();
        this.jwQ.setAdapter((ListAdapter) this.jwS);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.BG(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cug() {
        this.jwW = "2";
        this.jwY = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Bq(2));
        this.ckS = getString(R.string.filter_nature);
        this.jwZ = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jxb = stickerItem;
        this.jwX = getResources().getString(R.string.music_normal);
        this.jxa = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cuh() {
        if (this.jwT == null) {
            this.jwT = new ArrayList();
            a("No", com.baidu.tieba.video.a.Bq(0));
            a("1", com.baidu.tieba.video.a.Bq(1));
            a("2", com.baidu.tieba.video.a.Bq(2));
            a("3", com.baidu.tieba.video.a.Bq(3));
            a("4", com.baidu.tieba.video.a.Bq(4));
            a("5", com.baidu.tieba.video.a.Bq(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jwT.add(c(0, 1, str, aVar));
    }

    private void cui() {
        if (this.jwU == null) {
            this.jwU = new ArrayList();
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
        if (this.jwU != null) {
            this.jwU.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        this.jxf = 3;
        n(this.jwV, this.jwX);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jxf = 0;
        this.jwQ.setAdapter((ListAdapter) this.jwS);
        this.jwS.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rA(true);
            return;
        }
        this.jwQ.setVisibility(0);
        this.feB.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        this.jxf = 1;
        cuh();
        n(this.jwT, this.jwW);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctM() {
        this.jxf = 2;
        cui();
        n(this.jwU, this.ckS);
    }

    public void setListener(final a aVar) {
        if (this.jwR != null) {
            this.jwR.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jwW = eVar.getName();
                                VideoEffectLayout.this.jwY = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ckS = eVar.getName();
                                VideoEffectLayout.this.jwZ = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jwX = eVar.getName();
                                VideoEffectLayout.this.jxa = eVar;
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
        if (this.jwS != null) {
            this.jwS.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jxb = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jwS != null) {
                this.jwS.notifyDataSetChanged();
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
            if (this.jwS != null) {
                this.jwS.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jwR.b(list, str);
                    VideoEffectLayout.this.jwR.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jwQ.getVisibility() == 0) {
                runnable.run();
                rA(false);
            } else {
                cuj();
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
        return this.jxf;
    }

    public e<String> getCurrentFilterItem() {
        return this.jwZ;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jwY;
    }

    public StickerItem getCurrentStickItem() {
        return this.jxb;
    }

    private void cuj() {
        if (this.jxd != null && this.jxd.isRunning()) {
            this.jxd.cancel();
        }
        if (this.jxc == null) {
            this.jxc = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feB, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.feB, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jxc.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.feB.setVisibility(0);
        this.jxc.start();
    }

    private void rA(boolean z) {
        if (z) {
            if (this.jxe != null && this.jxe.isRunning()) {
                this.jxe.cancel();
            }
            if (this.jxc != null && this.jxc.isRunning()) {
                this.jxc.cancel();
            }
            if (this.jxd == null) {
                this.jxd = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feB, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jwQ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jwQ != null) {
                            VideoEffectLayout.this.jwQ.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jxo && VideoEffectLayout.this.feB != null) {
                            VideoEffectLayout.this.feB.setVisibility(8);
                        }
                    }
                });
                this.jxd.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jxd.start();
            return;
        }
        if (this.jxd != null && this.jxd.isRunning()) {
            this.jxd.cancel();
        }
        if (this.jxe == null) {
            this.jxe = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jwQ, "alpha", 1.0f, 0.0f);
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
                    if (!this.jxo && VideoEffectLayout.this.jwQ != null) {
                        VideoEffectLayout.this.jwQ.setVisibility(8);
                    }
                }
            });
            this.jxe.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jxe.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jwS != null) {
            this.jwS.T(list);
            this.jwS.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jwV == null) {
            this.jwV = new ArrayList();
        } else {
            this.jwV.clear();
        }
        this.jwV.addAll(list);
    }

    public boolean cue() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cuf() {
        if (this.jwR != null) {
            this.jwR.csS();
            this.jwX = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void csT() {
        if (this.jwR != null) {
            this.jwR.csT();
        }
    }
}
