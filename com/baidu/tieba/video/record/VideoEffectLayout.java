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
/* loaded from: classes8.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String fyF;
    private HListView iYc;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView nNN;
    private d nNO;
    private k nNP;
    private List<e> nNQ;
    private List<e> nNR;
    private List<e> nNS;
    private String nNT;
    private String nNU;
    private e<com.baidu.tieba.video.a> nNV;
    private e<String> nNW;
    private e<MusicData> nNX;
    private StickerItem nNY;
    private AnimatorSet nNZ;
    private AnimatorSet nOa;
    private AnimatorSet nOb;
    private int nOc;

    /* loaded from: classes8.dex */
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
        dWx();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iYc = (HListView) findViewById(R.id.effect_list_view);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iYc.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nNN = (HListView) findViewById(R.id.sticker_list_view);
        this.nNN.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nNO = new d();
        this.iYc.setAdapter((ListAdapter) this.nNO);
        this.nNP = new k();
        this.nNN.setAdapter((ListAdapter) this.nNP);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.LW(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dWx() {
        this.nNT = "2";
        this.nNV = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.LG(2));
        this.fyF = getString(R.string.filter_nature);
        this.nNW = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nNY = stickerItem;
        this.nNU = getResources().getString(R.string.music_normal);
        this.nNX = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dWy() {
        if (this.nNQ == null) {
            this.nNQ = new ArrayList();
            a("No", com.baidu.tieba.video.a.LG(0));
            a("1", com.baidu.tieba.video.a.LG(1));
            a("2", com.baidu.tieba.video.a.LG(2));
            a("3", com.baidu.tieba.video.a.LG(3));
            a("4", com.baidu.tieba.video.a.LG(4));
            a("5", com.baidu.tieba.video.a.LG(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nNQ.add(b(0, 1, str, aVar));
    }

    private void dWz() {
        if (this.nNR == null) {
            this.nNR = new ArrayList();
            q(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            q(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            q(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            q(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            q(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            q(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            q(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            q(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            q(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            q(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            q(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            q(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            q(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            q(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            q(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            q(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            q(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            q(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void q(int i, String str, String str2) {
        if (this.nNR != null) {
            this.nNR.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWa() {
        this.nOc = 3;
        t(this.nNS, this.nNU);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        this.nOc = 0;
        this.nNN.setAdapter((ListAdapter) this.nNP);
        this.nNP.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            yS(true);
            return;
        }
        this.nNN.setVisibility(0);
        this.iYc.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        this.nOc = 1;
        dWy();
        t(this.nNQ, this.nNT);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        this.nOc = 2;
        dWz();
        t(this.nNR, this.fyF);
    }

    public void setListener(final a aVar) {
        if (this.nNO != null) {
            this.nNO.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nNT = eVar.getName();
                                VideoEffectLayout.this.nNV = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.fyF = eVar.getName();
                                VideoEffectLayout.this.nNW = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nNU = eVar.getName();
                                VideoEffectLayout.this.nNX = eVar;
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
        if (this.nNP != null) {
            this.nNP.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nNY = stickerItem;
        if (!x.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nNP != null) {
                this.nNP.notifyDataSetChanged();
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
            if (this.nNP != null) {
                this.nNP.notifyDataSetChanged();
            }
        }
    }

    private void t(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nNO.c(list, str);
                    VideoEffectLayout.this.nNO.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nNN.getVisibility() == 0) {
                runnable.run();
                yS(false);
            } else {
                dWA();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iYc.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nOc;
    }

    public e<String> getCurrentFilterItem() {
        return this.nNW;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nNV;
    }

    public StickerItem getCurrentStickItem() {
        return this.nNY;
    }

    private void dWA() {
        if (this.nOa != null && this.nOa.isRunning()) {
            this.nOa.cancel();
        }
        if (this.nNZ == null) {
            this.nNZ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iYc, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iYc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nNZ.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iYc.setVisibility(0);
        this.nNZ.start();
    }

    private void yS(boolean z) {
        if (z) {
            if (this.nOb != null && this.nOb.isRunning()) {
                this.nOb.cancel();
            }
            if (this.nNZ != null && this.nNZ.isRunning()) {
                this.nNZ.cancel();
            }
            if (this.nOa == null) {
                this.nOa = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iYc, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nNN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nNN != null) {
                            VideoEffectLayout.this.nNN.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nOl && VideoEffectLayout.this.iYc != null) {
                            VideoEffectLayout.this.iYc.setVisibility(8);
                        }
                    }
                });
                this.nOa.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nOa.start();
            return;
        }
        if (this.nOa != null && this.nOa.isRunning()) {
            this.nOa.cancel();
        }
        if (this.nOb == null) {
            this.nOb = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nNN, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iYc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iYc != null) {
                        VideoEffectLayout.this.iYc.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOl && VideoEffectLayout.this.nNN != null) {
                        VideoEffectLayout.this.nNN.setVisibility(8);
                    }
                }
            });
            this.nOb.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nOb.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nNP != null) {
            this.nNP.bs(list);
            this.nNP.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nNS == null) {
            this.nNS = new ArrayList();
        } else {
            this.nNS.clear();
        }
        this.nNS.addAll(list);
    }

    public boolean dWv() {
        if (x.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dWw() {
        if (this.nNO != null) {
            this.nNO.dVi();
            this.nNU = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dVj() {
        if (this.nNO != null) {
            this.nNO.dVj();
        }
    }
}
