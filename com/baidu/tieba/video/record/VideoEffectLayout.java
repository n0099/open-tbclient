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
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String bmo;
    private HListView dyK;
    private HListView hyb;
    private d hyc;
    private l hyd;
    private List<e> hye;
    private List<e> hyf;
    private List<e> hyg;
    private String hyh;
    private String hyi;
    private e<com.baidu.tieba.video.a> hyj;
    private e<String> hyk;
    private e<MusicData> hyl;
    private StickerItem hym;
    private AnimatorSet hyn;
    private AnimatorSet hyo;
    private AnimatorSet hyp;
    private int hyq;
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
        bEk();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dyK = (HListView) findViewById(d.g.effect_list_view);
        this.dyK.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dyK.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hyb = (HListView) findViewById(d.g.sticker_list_view);
        this.hyb.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hyc = new d();
        this.dyK.setAdapter((ListAdapter) this.hyc);
        this.hyd = new l();
        this.hyb.setAdapter((ListAdapter) this.hyd);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wR(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEk() {
        this.hyh = "2";
        this.hyj = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wB(2));
        this.bmo = getString(d.j.filter_nature);
        this.hyk = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hym = stickerItem;
        this.hyi = getResources().getString(d.j.music_normal);
        this.hyl = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bDZ() {
        bEk();
        if (this.hyc != null) {
            this.hyc.bCV();
            this.hyc.bCU();
            this.hyc.bCW();
        }
        if (this.hyd != null) {
            this.hyd.bEb();
        }
    }

    private void bEl() {
        if (this.hye == null) {
            this.hye = new ArrayList();
            a("No", com.baidu.tieba.video.a.wB(0));
            a("1", com.baidu.tieba.video.a.wB(1));
            a("2", com.baidu.tieba.video.a.wB(2));
            a("3", com.baidu.tieba.video.a.wB(3));
            a("4", com.baidu.tieba.video.a.wB(4));
            a("5", com.baidu.tieba.video.a.wB(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hye.add(c(0, 1, str, aVar));
    }

    private void bEm() {
        if (this.hyf == null) {
            this.hyf = new ArrayList();
            k(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "nature");
            k(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            k(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            k(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            k(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            k(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            k(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            k(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            k(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            k(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            k(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            k(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            k(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            k(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            k(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            k(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            k(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            k(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void k(int i, String str, String str2) {
        if (this.hyf != null) {
            this.hyf.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        this.hyq = 3;
        j(this.hyg, this.hyi);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        this.hyq = 0;
        this.hyb.setAdapter((ListAdapter) this.hyd);
        this.hyd.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nv(true);
            return;
        }
        this.hyb.setVisibility(0);
        this.dyK.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        this.hyq = 1;
        bEl();
        j(this.hye, this.hyh);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        this.hyq = 2;
        bEm();
        j(this.hyf, this.bmo);
    }

    public void setListener(final a aVar) {
        if (this.hyc != null) {
            this.hyc.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hyh = eVar.getName();
                                VideoEffectLayout.this.hyj = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bmo = eVar.getName();
                                VideoEffectLayout.this.hyk = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hyi = eVar.getName();
                                VideoEffectLayout.this.hyl = eVar;
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
        if (this.hyd != null) {
            this.hyd.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hym = stickerItem;
        if (!v.E(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hyd != null) {
                this.hyd.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.E(this.mStickerItems)) {
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
            if (this.hyd != null) {
                this.hyd.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hyc.e(list, str);
                    VideoEffectLayout.this.hyc.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hyb.getVisibility() == 0) {
                runnable.run();
                nv(false);
            } else {
                bEn();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dyK.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hyq;
    }

    public e<String> getCurrentFilterItem() {
        return this.hyk;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hyj;
    }

    public StickerItem getCurrentStickItem() {
        return this.hym;
    }

    private void bEn() {
        if (this.hyo != null && this.hyo.isRunning()) {
            this.hyo.cancel();
        }
        if (this.hyn == null) {
            this.hyn = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyK, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dyK, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hyn.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dyK.setVisibility(0);
        this.hyn.start();
    }

    private void nv(boolean z) {
        if (z) {
            if (this.hyp != null && this.hyp.isRunning()) {
                this.hyp.cancel();
            }
            if (this.hyn != null && this.hyn.isRunning()) {
                this.hyn.cancel();
            }
            if (this.hyo == null) {
                this.hyo = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyK, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hyb, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hyb != null) {
                            VideoEffectLayout.this.hyb.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hyB && VideoEffectLayout.this.dyK != null) {
                            VideoEffectLayout.this.dyK.setVisibility(8);
                        }
                    }
                });
                this.hyo.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hyo.start();
            return;
        }
        if (this.hyo != null && this.hyo.isRunning()) {
            this.hyo.cancel();
        }
        if (this.hyp == null) {
            this.hyp = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hyb, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dyK, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dyK != null) {
                        VideoEffectLayout.this.dyK.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyB && VideoEffectLayout.this.hyb != null) {
                        VideoEffectLayout.this.hyb.setVisibility(8);
                    }
                }
            });
            this.hyp.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hyp.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hyd != null) {
            this.hyd.A(list);
            this.hyd.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hyg == null) {
            this.hyg = new ArrayList();
        } else {
            this.hyg.clear();
        }
        this.hyg.addAll(list);
    }

    public boolean bEi() {
        if (v.E(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEj() {
        if (this.hyc != null) {
            this.hyc.bCW();
            this.hyi = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCX() {
        if (this.hyc != null) {
            this.hyc.bCX();
        }
    }
}
