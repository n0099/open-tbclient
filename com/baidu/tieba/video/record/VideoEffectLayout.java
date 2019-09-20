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
    private String cni;
    private HListView flQ;
    private HListView jGF;
    private d jGG;
    private k jGH;
    private List<e> jGI;
    private List<e> jGJ;
    private List<e> jGK;
    private String jGL;
    private String jGM;
    private e<com.baidu.tieba.video.a> jGN;
    private e<String> jGO;
    private e<MusicData> jGP;
    private StickerItem jGQ;
    private AnimatorSet jGR;
    private AnimatorSet jGS;
    private AnimatorSet jGT;
    private int jGU;
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
        cye();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.flQ = (HListView) findViewById(R.id.effect_list_view);
        this.flQ.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.flQ.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jGF = (HListView) findViewById(R.id.sticker_list_view);
        this.jGF.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jGG = new d();
        this.flQ.setAdapter((ListAdapter) this.jGG);
        this.jGH = new k();
        this.jGF.setAdapter((ListAdapter) this.jGH);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Ct(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cye() {
        this.jGL = "2";
        this.jGN = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Cd(2));
        this.cni = getString(R.string.filter_nature);
        this.jGO = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jGQ = stickerItem;
        this.jGM = getResources().getString(R.string.music_normal);
        this.jGP = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cyf() {
        if (this.jGI == null) {
            this.jGI = new ArrayList();
            a("No", com.baidu.tieba.video.a.Cd(0));
            a("1", com.baidu.tieba.video.a.Cd(1));
            a("2", com.baidu.tieba.video.a.Cd(2));
            a("3", com.baidu.tieba.video.a.Cd(3));
            a("4", com.baidu.tieba.video.a.Cd(4));
            a("5", com.baidu.tieba.video.a.Cd(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jGI.add(c(0, 1, str, aVar));
    }

    private void cyg() {
        if (this.jGJ == null) {
            this.jGJ = new ArrayList();
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
        if (this.jGJ != null) {
            this.jGJ.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxH() {
        this.jGU = 3;
        n(this.jGK, this.jGM);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxI() {
        this.jGU = 0;
        this.jGF.setAdapter((ListAdapter) this.jGH);
        this.jGH.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rS(true);
            return;
        }
        this.jGF.setVisibility(0);
        this.flQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxJ() {
        this.jGU = 1;
        cyf();
        n(this.jGI, this.jGL);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxK() {
        this.jGU = 2;
        cyg();
        n(this.jGJ, this.cni);
    }

    public void setListener(final a aVar) {
        if (this.jGG != null) {
            this.jGG.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jGL = eVar.getName();
                                VideoEffectLayout.this.jGN = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.cni = eVar.getName();
                                VideoEffectLayout.this.jGO = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jGM = eVar.getName();
                                VideoEffectLayout.this.jGP = eVar;
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
        if (this.jGH != null) {
            this.jGH.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jGQ = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jGH != null) {
                this.jGH.notifyDataSetChanged();
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
            if (this.jGH != null) {
                this.jGH.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jGG.b(list, str);
                    VideoEffectLayout.this.jGG.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jGF.getVisibility() == 0) {
                runnable.run();
                rS(false);
            } else {
                cyh();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.flQ.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jGU;
    }

    public e<String> getCurrentFilterItem() {
        return this.jGO;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jGN;
    }

    public StickerItem getCurrentStickItem() {
        return this.jGQ;
    }

    private void cyh() {
        if (this.jGS != null && this.jGS.isRunning()) {
            this.jGS.cancel();
        }
        if (this.jGR == null) {
            this.jGR = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.flQ, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.flQ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jGR.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.flQ.setVisibility(0);
        this.jGR.start();
    }

    private void rS(boolean z) {
        if (z) {
            if (this.jGT != null && this.jGT.isRunning()) {
                this.jGT.cancel();
            }
            if (this.jGR != null && this.jGR.isRunning()) {
                this.jGR.cancel();
            }
            if (this.jGS == null) {
                this.jGS = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.flQ, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jGF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jGF != null) {
                            VideoEffectLayout.this.jGF.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jHd && VideoEffectLayout.this.flQ != null) {
                            VideoEffectLayout.this.flQ.setVisibility(8);
                        }
                    }
                });
                this.jGS.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jGS.start();
            return;
        }
        if (this.jGS != null && this.jGS.isRunning()) {
            this.jGS.cancel();
        }
        if (this.jGT == null) {
            this.jGT = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jGF, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.flQ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.flQ != null) {
                        VideoEffectLayout.this.flQ.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jHd && VideoEffectLayout.this.jGF != null) {
                        VideoEffectLayout.this.jGF.setVisibility(8);
                    }
                }
            });
            this.jGT.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jGT.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jGH != null) {
            this.jGH.T(list);
            this.jGH.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jGK == null) {
            this.jGK = new ArrayList();
        } else {
            this.jGK.clear();
        }
        this.jGK.addAll(list);
    }

    public boolean cyc() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cyd() {
        if (this.jGG != null) {
            this.jGG.cwQ();
            this.jGM = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cwR() {
        if (this.jGG != null) {
            this.jGG.cwR();
        }
    }
}
