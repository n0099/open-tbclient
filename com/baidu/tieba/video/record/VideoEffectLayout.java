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
    private String bme;
    private HListView dyB;
    private AnimatorSet hyA;
    private int hyB;
    private HListView hym;
    private d hyn;
    private l hyo;
    private List<e> hyp;
    private List<e> hyq;
    private List<e> hyr;
    private String hys;
    private String hyt;
    private e<com.baidu.tieba.video.a> hyu;
    private e<String> hyv;
    private e<MusicData> hyw;
    private StickerItem hyx;
    private AnimatorSet hyy;
    private AnimatorSet hyz;
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
        bEo();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dyB = (HListView) findViewById(d.g.effect_list_view);
        this.dyB.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dyB.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hym = (HListView) findViewById(d.g.sticker_list_view);
        this.hym.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hyn = new d();
        this.dyB.setAdapter((ListAdapter) this.hyn);
        this.hyo = new l();
        this.hym.setAdapter((ListAdapter) this.hyo);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wS(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEo() {
        this.hys = "2";
        this.hyu = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wC(2));
        this.bme = getString(d.j.filter_nature);
        this.hyv = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hyx = stickerItem;
        this.hyt = getResources().getString(d.j.music_normal);
        this.hyw = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bEd() {
        bEo();
        if (this.hyn != null) {
            this.hyn.bCZ();
            this.hyn.bCY();
            this.hyn.bDa();
        }
        if (this.hyo != null) {
            this.hyo.bEf();
        }
    }

    private void bEp() {
        if (this.hyp == null) {
            this.hyp = new ArrayList();
            a("No", com.baidu.tieba.video.a.wC(0));
            a("1", com.baidu.tieba.video.a.wC(1));
            a("2", com.baidu.tieba.video.a.wC(2));
            a("3", com.baidu.tieba.video.a.wC(3));
            a("4", com.baidu.tieba.video.a.wC(4));
            a("5", com.baidu.tieba.video.a.wC(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hyp.add(c(0, 1, str, aVar));
    }

    private void bEq() {
        if (this.hyq == null) {
            this.hyq = new ArrayList();
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
        if (this.hyq != null) {
            this.hyq.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        this.hyB = 3;
        j(this.hyr, this.hyt);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        this.hyB = 0;
        this.hym.setAdapter((ListAdapter) this.hyo);
        this.hyo.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nA(true);
            return;
        }
        this.hym.setVisibility(0);
        this.dyB.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDT() {
        this.hyB = 1;
        bEp();
        j(this.hyp, this.hys);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDU() {
        this.hyB = 2;
        bEq();
        j(this.hyq, this.bme);
    }

    public void setListener(final a aVar) {
        if (this.hyn != null) {
            this.hyn.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hys = eVar.getName();
                                VideoEffectLayout.this.hyu = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bme = eVar.getName();
                                VideoEffectLayout.this.hyv = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hyt = eVar.getName();
                                VideoEffectLayout.this.hyw = eVar;
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
        if (this.hyo != null) {
            this.hyo.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hyx = stickerItem;
        if (!v.E(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hyo != null) {
                this.hyo.notifyDataSetChanged();
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
            if (this.hyo != null) {
                this.hyo.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hyn.e(list, str);
                    VideoEffectLayout.this.hyn.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hym.getVisibility() == 0) {
                runnable.run();
                nA(false);
            } else {
                bEr();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dyB.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hyB;
    }

    public e<String> getCurrentFilterItem() {
        return this.hyv;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hyu;
    }

    public StickerItem getCurrentStickItem() {
        return this.hyx;
    }

    private void bEr() {
        if (this.hyz != null && this.hyz.isRunning()) {
            this.hyz.cancel();
        }
        if (this.hyy == null) {
            this.hyy = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyB, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dyB, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hyy.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dyB.setVisibility(0);
        this.hyy.start();
    }

    private void nA(boolean z) {
        if (z) {
            if (this.hyA != null && this.hyA.isRunning()) {
                this.hyA.cancel();
            }
            if (this.hyy != null && this.hyy.isRunning()) {
                this.hyy.cancel();
            }
            if (this.hyz == null) {
                this.hyz = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyB, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hym, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hym != null) {
                            VideoEffectLayout.this.hym.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hyM && VideoEffectLayout.this.dyB != null) {
                            VideoEffectLayout.this.dyB.setVisibility(8);
                        }
                    }
                });
                this.hyz.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hyz.start();
            return;
        }
        if (this.hyz != null && this.hyz.isRunning()) {
            this.hyz.cancel();
        }
        if (this.hyA == null) {
            this.hyA = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hym, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dyB, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dyB != null) {
                        VideoEffectLayout.this.dyB.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyM && VideoEffectLayout.this.hym != null) {
                        VideoEffectLayout.this.hym.setVisibility(8);
                    }
                }
            });
            this.hyA.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hyA.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hyo != null) {
            this.hyo.A(list);
            this.hyo.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hyr == null) {
            this.hyr = new ArrayList();
        } else {
            this.hyr.clear();
        }
        this.hyr.addAll(list);
    }

    public boolean bEm() {
        if (v.E(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEn() {
        if (this.hyn != null) {
            this.hyn.bDa();
            this.hyt = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bDb() {
        if (this.hyn != null) {
            this.hyn.bDb();
        }
    }
}
