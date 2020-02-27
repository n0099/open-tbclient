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
/* loaded from: classes10.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String drp;
    private HListView ghp;
    private HListView kDP;
    private d kDQ;
    private k kDR;
    private List<e> kDS;
    private List<e> kDT;
    private List<e> kDU;
    private String kDV;
    private String kDW;
    private e<com.baidu.tieba.video.a> kDX;
    private e<String> kDY;
    private e<MusicData> kDZ;
    private StickerItem kEa;
    private AnimatorSet kEb;
    private AnimatorSet kEc;
    private AnimatorSet kEd;
    private int kEe;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes10.dex */
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
        cSh();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.ghp = (HListView) findViewById(R.id.effect_list_view);
        this.ghp.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.ghp.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kDP = (HListView) findViewById(R.id.sticker_list_view);
        this.kDP.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kDQ = new d();
        this.ghp.setAdapter((ListAdapter) this.kDQ);
        this.kDR = new k();
        this.kDP.setAdapter((ListAdapter) this.kDR);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.DF(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cSh() {
        this.kDV = "2";
        this.kDX = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dp(2));
        this.drp = getString(R.string.filter_nature);
        this.kDY = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kEa = stickerItem;
        this.kDW = getResources().getString(R.string.music_normal);
        this.kDZ = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cSi() {
        if (this.kDS == null) {
            this.kDS = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dp(0));
            a("1", com.baidu.tieba.video.a.Dp(1));
            a("2", com.baidu.tieba.video.a.Dp(2));
            a("3", com.baidu.tieba.video.a.Dp(3));
            a("4", com.baidu.tieba.video.a.Dp(4));
            a("5", com.baidu.tieba.video.a.Dp(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kDS.add(b(0, 1, str, aVar));
    }

    private void cSj() {
        if (this.kDT == null) {
            this.kDT = new ArrayList();
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
        if (this.kDT != null) {
            this.kDT.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRK() {
        this.kEe = 3;
        m(this.kDU, this.kDW);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRL() {
        this.kEe = 0;
        this.kDP.setAdapter((ListAdapter) this.kDR);
        this.kDR.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tx(true);
            return;
        }
        this.kDP.setVisibility(0);
        this.ghp.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        this.kEe = 1;
        cSi();
        m(this.kDS, this.kDV);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        this.kEe = 2;
        cSj();
        m(this.kDT, this.drp);
    }

    public void setListener(final a aVar) {
        if (this.kDQ != null) {
            this.kDQ.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kDV = eVar.getName();
                                VideoEffectLayout.this.kDX = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.drp = eVar.getName();
                                VideoEffectLayout.this.kDY = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kDW = eVar.getName();
                                VideoEffectLayout.this.kDZ = eVar;
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
        if (this.kDR != null) {
            this.kDR.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kEa = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kDR != null) {
                this.kDR.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.isEmpty(this.mStickerItems)) {
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
            if (this.kDR != null) {
                this.kDR.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kDQ.b(list, str);
                    VideoEffectLayout.this.kDQ.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kDP.getVisibility() == 0) {
                runnable.run();
                tx(false);
            } else {
                cSk();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.ghp.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kEe;
    }

    public e<String> getCurrentFilterItem() {
        return this.kDY;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kDX;
    }

    public StickerItem getCurrentStickItem() {
        return this.kEa;
    }

    private void cSk() {
        if (this.kEc != null && this.kEc.isRunning()) {
            this.kEc.cancel();
        }
        if (this.kEb == null) {
            this.kEb = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghp, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ghp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kEb.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.ghp.setVisibility(0);
        this.kEb.start();
    }

    private void tx(boolean z) {
        if (z) {
            if (this.kEd != null && this.kEd.isRunning()) {
                this.kEd.cancel();
            }
            if (this.kEb != null && this.kEb.isRunning()) {
                this.kEb.cancel();
            }
            if (this.kEc == null) {
                this.kEc = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghp, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kDP, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kDP != null) {
                            VideoEffectLayout.this.kDP.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kEn && VideoEffectLayout.this.ghp != null) {
                            VideoEffectLayout.this.ghp.setVisibility(8);
                        }
                    }
                });
                this.kEc.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kEc.start();
            return;
        }
        if (this.kEc != null && this.kEc.isRunning()) {
            this.kEc.cancel();
        }
        if (this.kEd == null) {
            this.kEd = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kDP, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.ghp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.ghp != null) {
                        VideoEffectLayout.this.ghp.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEn && VideoEffectLayout.this.kDP != null) {
                        VideoEffectLayout.this.kDP.setVisibility(8);
                    }
                }
            });
            this.kEd.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kEd.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kDR != null) {
            this.kDR.av(list);
            this.kDR.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kDU == null) {
            this.kDU = new ArrayList();
        } else {
            this.kDU.clear();
        }
        this.kDU.addAll(list);
    }

    public boolean cSf() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cSg() {
        if (this.kDQ != null) {
            this.kDQ.cQW();
            this.kDW = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cQX() {
        if (this.kDQ != null) {
            this.kDQ.cQX();
        }
    }
}
