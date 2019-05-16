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
    private HListView feA;
    private HListView jwP;
    private d jwQ;
    private k jwR;
    private List<e> jwS;
    private List<e> jwT;
    private List<e> jwU;
    private String jwV;
    private String jwW;
    private e<com.baidu.tieba.video.a> jwX;
    private e<String> jwY;
    private e<MusicData> jwZ;
    private StickerItem jxa;
    private AnimatorSet jxb;
    private AnimatorSet jxc;
    private AnimatorSet jxd;
    private int jxe;
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
        cue();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.feA = (HListView) findViewById(R.id.effect_list_view);
        this.feA.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.feA.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwP = (HListView) findViewById(R.id.sticker_list_view);
        this.jwP.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jwQ = new d();
        this.feA.setAdapter((ListAdapter) this.jwQ);
        this.jwR = new k();
        this.jwP.setAdapter((ListAdapter) this.jwR);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.BG(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cue() {
        this.jwV = "2";
        this.jwX = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Bq(2));
        this.ckS = getString(R.string.filter_nature);
        this.jwY = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jxa = stickerItem;
        this.jwW = getResources().getString(R.string.music_normal);
        this.jwZ = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cuf() {
        if (this.jwS == null) {
            this.jwS = new ArrayList();
            a("No", com.baidu.tieba.video.a.Bq(0));
            a("1", com.baidu.tieba.video.a.Bq(1));
            a("2", com.baidu.tieba.video.a.Bq(2));
            a("3", com.baidu.tieba.video.a.Bq(3));
            a("4", com.baidu.tieba.video.a.Bq(4));
            a("5", com.baidu.tieba.video.a.Bq(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jwS.add(c(0, 1, str, aVar));
    }

    private void cug() {
        if (this.jwT == null) {
            this.jwT = new ArrayList();
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
        if (this.jwT != null) {
            this.jwT.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctH() {
        this.jxe = 3;
        n(this.jwU, this.jwW);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        this.jxe = 0;
        this.jwP.setAdapter((ListAdapter) this.jwR);
        this.jwR.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rA(true);
            return;
        }
        this.jwP.setVisibility(0);
        this.feA.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        this.jxe = 1;
        cuf();
        n(this.jwS, this.jwV);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jxe = 2;
        cug();
        n(this.jwT, this.ckS);
    }

    public void setListener(final a aVar) {
        if (this.jwQ != null) {
            this.jwQ.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jwV = eVar.getName();
                                VideoEffectLayout.this.jwX = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ckS = eVar.getName();
                                VideoEffectLayout.this.jwY = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jwW = eVar.getName();
                                VideoEffectLayout.this.jwZ = eVar;
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
        if (this.jwR != null) {
            this.jwR.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jxa = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jwR != null) {
                this.jwR.notifyDataSetChanged();
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
            if (this.jwR != null) {
                this.jwR.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jwQ.b(list, str);
                    VideoEffectLayout.this.jwQ.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jwP.getVisibility() == 0) {
                runnable.run();
                rA(false);
            } else {
                cuh();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.feA.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jxe;
    }

    public e<String> getCurrentFilterItem() {
        return this.jwY;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jwX;
    }

    public StickerItem getCurrentStickItem() {
        return this.jxa;
    }

    private void cuh() {
        if (this.jxc != null && this.jxc.isRunning()) {
            this.jxc.cancel();
        }
        if (this.jxb == null) {
            this.jxb = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feA, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.feA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jxb.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.feA.setVisibility(0);
        this.jxb.start();
    }

    private void rA(boolean z) {
        if (z) {
            if (this.jxd != null && this.jxd.isRunning()) {
                this.jxd.cancel();
            }
            if (this.jxb != null && this.jxb.isRunning()) {
                this.jxb.cancel();
            }
            if (this.jxc == null) {
                this.jxc = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feA, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jwP, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jwP != null) {
                            VideoEffectLayout.this.jwP.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jxn && VideoEffectLayout.this.feA != null) {
                            VideoEffectLayout.this.feA.setVisibility(8);
                        }
                    }
                });
                this.jxc.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jxc.start();
            return;
        }
        if (this.jxc != null && this.jxc.isRunning()) {
            this.jxc.cancel();
        }
        if (this.jxd == null) {
            this.jxd = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jwP, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.feA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.feA != null) {
                        VideoEffectLayout.this.feA.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxn && VideoEffectLayout.this.jwP != null) {
                        VideoEffectLayout.this.jwP.setVisibility(8);
                    }
                }
            });
            this.jxd.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jxd.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jwR != null) {
            this.jwR.T(list);
            this.jwR.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jwU == null) {
            this.jwU = new ArrayList();
        } else {
            this.jwU.clear();
        }
        this.jwU.addAll(list);
    }

    public boolean cuc() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cud() {
        if (this.jwQ != null) {
            this.jwQ.csQ();
            this.jwW = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void csR() {
        if (this.jwQ != null) {
            this.jwQ.csR();
        }
    }
}
