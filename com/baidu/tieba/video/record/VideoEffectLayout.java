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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String foX;
    private HListView iLR;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private e<com.baidu.tieba.video.a> nKA;
    private e<String> nKB;
    private e<MusicData> nKC;
    private StickerItem nKD;
    private AnimatorSet nKE;
    private AnimatorSet nKF;
    private AnimatorSet nKG;
    private int nKH;
    private HListView nKs;
    private d nKt;
    private k nKu;
    private List<e> nKv;
    private List<e> nKw;
    private List<e> nKx;
    private String nKy;
    private String nKz;

    /* loaded from: classes23.dex */
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
        dWU();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iLR = (HListView) findViewById(R.id.effect_list_view);
        this.iLR.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iLR.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nKs = (HListView) findViewById(R.id.sticker_list_view);
        this.nKs.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nKt = new d();
        this.iLR.setAdapter((ListAdapter) this.nKt);
        this.nKu = new k();
        this.nKs.setAdapter((ListAdapter) this.nKu);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Mj(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dWU() {
        this.nKy = "2";
        this.nKA = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.LS(2));
        this.foX = getString(R.string.filter_nature);
        this.nKB = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nKD = stickerItem;
        this.nKz = getResources().getString(R.string.music_normal);
        this.nKC = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dWV() {
        if (this.nKv == null) {
            this.nKv = new ArrayList();
            a("No", com.baidu.tieba.video.a.LS(0));
            a("1", com.baidu.tieba.video.a.LS(1));
            a("2", com.baidu.tieba.video.a.LS(2));
            a("3", com.baidu.tieba.video.a.LS(3));
            a("4", com.baidu.tieba.video.a.LS(4));
            a("5", com.baidu.tieba.video.a.LS(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nKv.add(b(0, 1, str, aVar));
    }

    private void dWW() {
        if (this.nKw == null) {
            this.nKw = new ArrayList();
            s(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            s(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            s(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            s(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            s(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            s(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            s(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            s(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            s(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            s(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            s(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            s(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            s(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            s(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            s(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            s(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            s(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            s(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void s(int i, String str, String str2) {
        if (this.nKw != null) {
            this.nKw.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWx() {
        this.nKH = 3;
        t(this.nKx, this.nKz);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWy() {
        this.nKH = 0;
        this.nKs.setAdapter((ListAdapter) this.nKu);
        this.nKu.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            yS(true);
            return;
        }
        this.nKs.setVisibility(0);
        this.iLR.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWz() {
        this.nKH = 1;
        dWV();
        t(this.nKv, this.nKy);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWA() {
        this.nKH = 2;
        dWW();
        t(this.nKw, this.foX);
    }

    public void setListener(final a aVar) {
        if (this.nKt != null) {
            this.nKt.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nKy = eVar.getName();
                                VideoEffectLayout.this.nKA = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.foX = eVar.getName();
                                VideoEffectLayout.this.nKB = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nKz = eVar.getName();
                                VideoEffectLayout.this.nKC = eVar;
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
        if (this.nKu != null) {
            this.nKu.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nKD = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nKu != null) {
                this.nKu.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!y.isEmpty(this.mStickerItems)) {
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
            if (this.nKu != null) {
                this.nKu.notifyDataSetChanged();
            }
        }
    }

    private void t(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nKt.c(list, str);
                    VideoEffectLayout.this.nKt.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nKs.getVisibility() == 0) {
                runnable.run();
                yS(false);
            } else {
                dWX();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iLR.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nKH;
    }

    public e<String> getCurrentFilterItem() {
        return this.nKB;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nKA;
    }

    public StickerItem getCurrentStickItem() {
        return this.nKD;
    }

    private void dWX() {
        if (this.nKF != null && this.nKF.isRunning()) {
            this.nKF.cancel();
        }
        if (this.nKE == null) {
            this.nKE = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iLR, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iLR, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nKE.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iLR.setVisibility(0);
        this.nKE.start();
    }

    private void yS(boolean z) {
        if (z) {
            if (this.nKG != null && this.nKG.isRunning()) {
                this.nKG.cancel();
            }
            if (this.nKE != null && this.nKE.isRunning()) {
                this.nKE.cancel();
            }
            if (this.nKF == null) {
                this.nKF = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iLR, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nKs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nKs != null) {
                            VideoEffectLayout.this.nKs.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nKQ && VideoEffectLayout.this.iLR != null) {
                            VideoEffectLayout.this.iLR.setVisibility(8);
                        }
                    }
                });
                this.nKF.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nKF.start();
            return;
        }
        if (this.nKF != null && this.nKF.isRunning()) {
            this.nKF.cancel();
        }
        if (this.nKG == null) {
            this.nKG = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nKs, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iLR, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iLR != null) {
                        VideoEffectLayout.this.iLR.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKQ && VideoEffectLayout.this.nKs != null) {
                        VideoEffectLayout.this.nKs.setVisibility(8);
                    }
                }
            });
            this.nKG.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nKG.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nKu != null) {
            this.nKu.bl(list);
            this.nKu.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nKx == null) {
            this.nKx = new ArrayList();
        } else {
            this.nKx.clear();
        }
        this.nKx.addAll(list);
    }

    public boolean dWS() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dWT() {
        if (this.nKt != null) {
            this.nKt.dVG();
            this.nKz = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dVH() {
        if (this.nKt != null) {
            this.nKt.dVH();
        }
    }
}
