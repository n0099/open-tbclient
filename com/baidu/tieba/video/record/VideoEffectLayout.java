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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String aHe;
    private HListView cZA;
    private HListView hkd;
    private d hke;
    private k hkf;
    private List<e> hkg;
    private List<e> hkh;
    private List<e> hki;
    private String hkj;
    private String hkk;
    private e<com.baidu.tieba.video.a> hkl;
    private e<String> hkm;
    private e<MusicData> hkn;
    private StickerItem hko;
    private AnimatorSet hkp;
    private AnimatorSet hkq;
    private AnimatorSet hkr;
    private int hks;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes2.dex */
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
        bEM();
        inflate(getContext(), d.i.layout_effect_container, this);
        this.cZA = (HListView) findViewById(d.g.effect_list_view);
        this.cZA.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cZA.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hkd = (HListView) findViewById(d.g.sticker_list_view);
        this.hkd.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hke = new d();
        this.cZA.setAdapter((ListAdapter) this.hke);
        this.hkf = new k();
        this.hkd.setAdapter((ListAdapter) this.hkf);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.uO(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEM() {
        this.hkj = "2";
        this.hkl = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uy(2));
        this.aHe = getString(d.k.filter_nature);
        this.hkm = c(d.f.filter_icon_avatar_default, 2, getString(d.k.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hko = stickerItem;
        this.hkk = getResources().getString(d.k.music_normal);
        this.hkn = new e<>(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute);
    }

    private void bEN() {
        if (this.hkg == null) {
            this.hkg = new ArrayList();
            a("No", com.baidu.tieba.video.a.uy(0));
            a("1", com.baidu.tieba.video.a.uy(1));
            a("2", com.baidu.tieba.video.a.uy(2));
            a("3", com.baidu.tieba.video.a.uy(3));
            a("4", com.baidu.tieba.video.a.uy(4));
            a("5", com.baidu.tieba.video.a.uy(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hkg.add(c(0, 1, str, aVar));
    }

    private void bEO() {
        if (this.hkh == null) {
            this.hkh = new ArrayList();
            j(d.f.filter_icon_avatar_default, getString(d.k.filter_nature), "nature");
            j(d.f.filter_icon_avatar_hongkong, getString(d.k.filter_hongkong), "hongkong");
            j(d.f.filter_icon_avatar_refreshing, getString(d.k.filter_refreshing), "refreshing");
            j(d.f.filter_icon_avatar_girly, getString(d.k.filter_girly), "girly");
            j(d.f.filter_icon_avatar_concrete, getString(d.k.filter_concrete), "concrete");
            j(d.f.filter_icon_avatar_warm, getString(d.k.filter_warm), "warm");
            j(d.f.filter_icon_avatar_cold, getString(d.k.filter_cold), "cold");
            j(d.f.filter_icon_avatar_japanese, getString(d.k.filter_japanese), "Japanese");
            j(d.f.filter_icon_avatar_cruz, getString(d.k.filter_hdr), "cruz");
            j(d.f.filter_icon_avatar_abao, getString(d.k.filter_abao), "abao");
            j(d.f.filter_icon_avatar_dew, getString(d.k.filter_dew), "dew");
            j(d.f.filter_icon_avatar_slowlived, getString(d.k.filter_slowlived), "slowlived");
            j(d.f.filter_icon_avatar_sweet, getString(d.k.filter_sweet), "sweet");
            j(d.f.filter_icon_avatar_boardwalk, getString(d.k.filter_boardwalk), "boardwalk");
            j(d.f.filter_icon_avatar_keylime, getString(d.k.filter_keylime), "keylime");
            j(d.f.filter_icon_avatar_electric, getString(d.k.filter_electric), "electric");
            j(d.f.filter_icon_avatar_silver, getString(d.k.filter_silver), "silver");
            j(d.f.filter_icon_avatar_blackwhite, getString(d.k.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void j(int i, String str, String str2) {
        if (this.hkh != null) {
            this.hkh.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEp() {
        this.hks = 3;
        k(this.hki, this.hkk);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEq() {
        this.hks = 0;
        this.hkd.setAdapter((ListAdapter) this.hkf);
        this.hkf.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nr(true);
            return;
        }
        this.hkd.setVisibility(0);
        this.cZA.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEr() {
        this.hks = 1;
        bEN();
        k(this.hkg, this.hkj);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEs() {
        this.hks = 2;
        bEO();
        k(this.hkh, this.aHe);
    }

    public void setListener(final a aVar) {
        if (this.hke != null) {
            this.hke.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hkj = eVar.getName();
                                VideoEffectLayout.this.hkl = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aHe = eVar.getName();
                                VideoEffectLayout.this.hkm = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hkk = eVar.getName();
                                VideoEffectLayout.this.hkn = eVar;
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
        if (this.hkf != null) {
            this.hkf.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hko = stickerItem;
        if (!w.A(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hkf != null) {
                this.hkf.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!w.A(this.mStickerItems)) {
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
            if (this.hkf != null) {
                this.hkf.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hke.f(list, str);
                    VideoEffectLayout.this.hke.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hkd.getVisibility() == 0) {
                runnable.run();
                nr(false);
            } else {
                bEP();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.cZA.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hks;
    }

    public e<String> getCurrentFilterItem() {
        return this.hkm;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hkl;
    }

    public StickerItem getCurrentStickItem() {
        return this.hko;
    }

    private void bEP() {
        if (this.hkq != null && this.hkq.isRunning()) {
            this.hkq.cancel();
        }
        if (this.hkp == null) {
            this.hkp = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZA, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cZA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hkp.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cZA.setVisibility(0);
        this.hkp.start();
    }

    private void nr(boolean z) {
        if (z) {
            if (this.hkr != null && this.hkr.isRunning()) {
                this.hkr.cancel();
            }
            if (this.hkp != null && this.hkp.isRunning()) {
                this.hkp.cancel();
            }
            if (this.hkq == null) {
                this.hkq = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cZA, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hkd, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hkd != null) {
                            VideoEffectLayout.this.hkd.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hkD && VideoEffectLayout.this.cZA != null) {
                            VideoEffectLayout.this.cZA.setVisibility(8);
                        }
                    }
                });
                this.hkq.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hkq.start();
            return;
        }
        if (this.hkq != null && this.hkq.isRunning()) {
            this.hkq.cancel();
        }
        if (this.hkr == null) {
            this.hkr = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hkd, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cZA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cZA != null) {
                        VideoEffectLayout.this.cZA.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hkD && VideoEffectLayout.this.hkd != null) {
                        VideoEffectLayout.this.hkd.setVisibility(8);
                    }
                }
            });
            this.hkr.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hkr.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hkf != null) {
            this.hkf.u(list);
            this.hkf.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hki == null) {
            this.hki = new ArrayList();
        } else {
            this.hki.clear();
        }
        this.hki.addAll(list);
    }

    public boolean bEK() {
        if (w.A(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEL() {
        if (this.hke != null) {
            this.hke.bDx();
            this.hkk = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bDy() {
        if (this.hke != null) {
            this.hke.bDy();
        }
    }
}
