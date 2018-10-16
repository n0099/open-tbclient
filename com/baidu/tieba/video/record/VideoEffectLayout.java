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
import com.baidu.tieba.e;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String aOT;
    private HListView dqo;
    private String hAA;
    private String hAB;
    private e<com.baidu.tieba.video.a> hAC;
    private e<String> hAD;
    private e<MusicData> hAE;
    private StickerItem hAF;
    private AnimatorSet hAG;
    private AnimatorSet hAH;
    private AnimatorSet hAI;
    private int hAJ;
    private HListView hAu;
    private d hAv;
    private k hAw;
    private List<e> hAx;
    private List<e> hAy;
    private List<e> hAz;
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
        bJA();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.dqo = (HListView) findViewById(e.g.effect_list_view);
        this.dqo.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0175e.ds28));
        this.dqo.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hAu = (HListView) findViewById(e.g.sticker_list_view);
        this.hAu.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hAv = new d();
        this.dqo.setAdapter((ListAdapter) this.hAv);
        this.hAw = new k();
        this.hAu.setAdapter((ListAdapter) this.hAw);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.vK(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bJA() {
        this.hAA = "2";
        this.hAC = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.vu(2));
        this.aOT = getString(e.j.filter_nature);
        this.hAD = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hAF = stickerItem;
        this.hAB = getResources().getString(e.j.music_normal);
        this.hAE = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bJB() {
        if (this.hAx == null) {
            this.hAx = new ArrayList();
            a("No", com.baidu.tieba.video.a.vu(0));
            a("1", com.baidu.tieba.video.a.vu(1));
            a("2", com.baidu.tieba.video.a.vu(2));
            a("3", com.baidu.tieba.video.a.vu(3));
            a("4", com.baidu.tieba.video.a.vu(4));
            a("5", com.baidu.tieba.video.a.vu(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hAx.add(c(0, 1, str, aVar));
    }

    private void bJC() {
        if (this.hAy == null) {
            this.hAy = new ArrayList();
            l(e.f.filter_icon_avatar_default, getString(e.j.filter_nature), "nature");
            l(e.f.filter_icon_avatar_hongkong, getString(e.j.filter_hongkong), "hongkong");
            l(e.f.filter_icon_avatar_refreshing, getString(e.j.filter_refreshing), "refreshing");
            l(e.f.filter_icon_avatar_girly, getString(e.j.filter_girly), "girly");
            l(e.f.filter_icon_avatar_concrete, getString(e.j.filter_concrete), "concrete");
            l(e.f.filter_icon_avatar_warm, getString(e.j.filter_warm), "warm");
            l(e.f.filter_icon_avatar_cold, getString(e.j.filter_cold), "cold");
            l(e.f.filter_icon_avatar_japanese, getString(e.j.filter_japanese), "Japanese");
            l(e.f.filter_icon_avatar_cruz, getString(e.j.filter_hdr), "cruz");
            l(e.f.filter_icon_avatar_abao, getString(e.j.filter_abao), "abao");
            l(e.f.filter_icon_avatar_dew, getString(e.j.filter_dew), "dew");
            l(e.f.filter_icon_avatar_slowlived, getString(e.j.filter_slowlived), "slowlived");
            l(e.f.filter_icon_avatar_sweet, getString(e.j.filter_sweet), "sweet");
            l(e.f.filter_icon_avatar_boardwalk, getString(e.j.filter_boardwalk), "boardwalk");
            l(e.f.filter_icon_avatar_keylime, getString(e.j.filter_keylime), "keylime");
            l(e.f.filter_icon_avatar_electric, getString(e.j.filter_electric), "electric");
            l(e.f.filter_icon_avatar_silver, getString(e.j.filter_silver), "silver");
            l(e.f.filter_icon_avatar_blackwhite, getString(e.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void l(int i, String str, String str2) {
        if (this.hAy != null) {
            this.hAy.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJd() {
        this.hAJ = 3;
        k(this.hAz, this.hAB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJe() {
        this.hAJ = 0;
        this.hAu.setAdapter((ListAdapter) this.hAw);
        this.hAw.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nR(true);
            return;
        }
        this.hAu.setVisibility(0);
        this.dqo.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJf() {
        this.hAJ = 1;
        bJB();
        k(this.hAx, this.hAA);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJg() {
        this.hAJ = 2;
        bJC();
        k(this.hAy, this.aOT);
    }

    public void setListener(final a aVar) {
        if (this.hAv != null) {
            this.hAv.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hAA = eVar.getName();
                                VideoEffectLayout.this.hAC = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aOT = eVar.getName();
                                VideoEffectLayout.this.hAD = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hAB = eVar.getName();
                                VideoEffectLayout.this.hAE = eVar;
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
        if (this.hAw != null) {
            this.hAw.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hAF = stickerItem;
        if (!v.J(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hAw != null) {
                this.hAw.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.J(this.mStickerItems)) {
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
            if (this.hAw != null) {
                this.hAw.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hAv.f(list, str);
                    VideoEffectLayout.this.hAv.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hAu.getVisibility() == 0) {
                runnable.run();
                nR(false);
            } else {
                bJD();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dqo.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hAJ;
    }

    public e<String> getCurrentFilterItem() {
        return this.hAD;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hAC;
    }

    public StickerItem getCurrentStickItem() {
        return this.hAF;
    }

    private void bJD() {
        if (this.hAH != null && this.hAH.isRunning()) {
            this.hAH.cancel();
        }
        if (this.hAG == null) {
            this.hAG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dqo, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dqo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hAG.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dqo.setVisibility(0);
        this.hAG.start();
    }

    private void nR(boolean z) {
        if (z) {
            if (this.hAI != null && this.hAI.isRunning()) {
                this.hAI.cancel();
            }
            if (this.hAG != null && this.hAG.isRunning()) {
                this.hAG.cancel();
            }
            if (this.hAH == null) {
                this.hAH = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dqo, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hAu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hAu != null) {
                            VideoEffectLayout.this.hAu.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hAT && VideoEffectLayout.this.dqo != null) {
                            VideoEffectLayout.this.dqo.setVisibility(8);
                        }
                    }
                });
                this.hAH.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hAH.start();
            return;
        }
        if (this.hAH != null && this.hAH.isRunning()) {
            this.hAH.cancel();
        }
        if (this.hAI == null) {
            this.hAI = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hAu, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dqo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dqo != null) {
                        VideoEffectLayout.this.dqo.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAT && VideoEffectLayout.this.hAu != null) {
                        VideoEffectLayout.this.hAu.setVisibility(8);
                    }
                }
            });
            this.hAI.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hAI.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hAw != null) {
            this.hAw.D(list);
            this.hAw.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hAz == null) {
            this.hAz = new ArrayList();
        } else {
            this.hAz.clear();
        }
        this.hAz.addAll(list);
    }

    public boolean bJy() {
        if (v.J(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bJz() {
        if (this.hAv != null) {
            this.hAv.bIm();
            this.hAB = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bIn() {
        if (this.hAv != null) {
            this.hAv.bIn();
        }
    }
}
