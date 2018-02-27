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
    private String bmb;
    private HListView dyy;
    private HListView hxO;
    private d hxP;
    private l hxQ;
    private List<e> hxR;
    private List<e> hxS;
    private List<e> hxT;
    private String hxU;
    private String hxV;
    private e<com.baidu.tieba.video.a> hxW;
    private e<String> hxX;
    private e<MusicData> hxY;
    private StickerItem hxZ;
    private AnimatorSet hya;
    private AnimatorSet hyb;
    private AnimatorSet hyc;
    private int hyd;
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
        bEj();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dyy = (HListView) findViewById(d.g.effect_list_view);
        this.dyy.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dyy.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hxO = (HListView) findViewById(d.g.sticker_list_view);
        this.hxO.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hxP = new d();
        this.dyy.setAdapter((ListAdapter) this.hxP);
        this.hxQ = new l();
        this.hxO.setAdapter((ListAdapter) this.hxQ);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wS(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEj() {
        this.hxU = "2";
        this.hxW = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wC(2));
        this.bmb = getString(d.j.filter_nature);
        this.hxX = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hxZ = stickerItem;
        this.hxV = getResources().getString(d.j.music_normal);
        this.hxY = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bDY() {
        bEj();
        if (this.hxP != null) {
            this.hxP.bCU();
            this.hxP.bCT();
            this.hxP.bCV();
        }
        if (this.hxQ != null) {
            this.hxQ.bEa();
        }
    }

    private void bEk() {
        if (this.hxR == null) {
            this.hxR = new ArrayList();
            a("No", com.baidu.tieba.video.a.wC(0));
            a("1", com.baidu.tieba.video.a.wC(1));
            a("2", com.baidu.tieba.video.a.wC(2));
            a("3", com.baidu.tieba.video.a.wC(3));
            a("4", com.baidu.tieba.video.a.wC(4));
            a("5", com.baidu.tieba.video.a.wC(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hxR.add(c(0, 1, str, aVar));
    }

    private void bEl() {
        if (this.hxS == null) {
            this.hxS = new ArrayList();
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
        if (this.hxS != null) {
            this.hxS.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDM() {
        this.hyd = 3;
        j(this.hxT, this.hxV);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        this.hyd = 0;
        this.hxO.setAdapter((ListAdapter) this.hxQ);
        this.hxQ.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nv(true);
            return;
        }
        this.hxO.setVisibility(0);
        this.dyy.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        this.hyd = 1;
        bEk();
        j(this.hxR, this.hxU);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        this.hyd = 2;
        bEl();
        j(this.hxS, this.bmb);
    }

    public void setListener(final a aVar) {
        if (this.hxP != null) {
            this.hxP.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hxU = eVar.getName();
                                VideoEffectLayout.this.hxW = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bmb = eVar.getName();
                                VideoEffectLayout.this.hxX = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hxV = eVar.getName();
                                VideoEffectLayout.this.hxY = eVar;
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
        if (this.hxQ != null) {
            this.hxQ.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hxZ = stickerItem;
        if (!v.E(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hxQ != null) {
                this.hxQ.notifyDataSetChanged();
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
            if (this.hxQ != null) {
                this.hxQ.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hxP.e(list, str);
                    VideoEffectLayout.this.hxP.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hxO.getVisibility() == 0) {
                runnable.run();
                nv(false);
            } else {
                bEm();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dyy.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hyd;
    }

    public e<String> getCurrentFilterItem() {
        return this.hxX;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hxW;
    }

    public StickerItem getCurrentStickItem() {
        return this.hxZ;
    }

    private void bEm() {
        if (this.hyb != null && this.hyb.isRunning()) {
            this.hyb.cancel();
        }
        if (this.hya == null) {
            this.hya = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyy, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dyy, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hya.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dyy.setVisibility(0);
        this.hya.start();
    }

    private void nv(boolean z) {
        if (z) {
            if (this.hyc != null && this.hyc.isRunning()) {
                this.hyc.cancel();
            }
            if (this.hya != null && this.hya.isRunning()) {
                this.hya.cancel();
            }
            if (this.hyb == null) {
                this.hyb = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dyy, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hxO, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hxO != null) {
                            VideoEffectLayout.this.hxO.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hyo && VideoEffectLayout.this.dyy != null) {
                            VideoEffectLayout.this.dyy.setVisibility(8);
                        }
                    }
                });
                this.hyb.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hyb.start();
            return;
        }
        if (this.hyb != null && this.hyb.isRunning()) {
            this.hyb.cancel();
        }
        if (this.hyc == null) {
            this.hyc = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hxO, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dyy, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dyy != null) {
                        VideoEffectLayout.this.dyy.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyo && VideoEffectLayout.this.hxO != null) {
                        VideoEffectLayout.this.hxO.setVisibility(8);
                    }
                }
            });
            this.hyc.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hyc.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hxQ != null) {
            this.hxQ.A(list);
            this.hxQ.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hxT == null) {
            this.hxT = new ArrayList();
        } else {
            this.hxT.clear();
        }
        this.hxT.addAll(list);
    }

    public boolean bEh() {
        if (v.E(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEi() {
        if (this.hxP != null) {
            this.hxP.bCV();
            this.hxV = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCW() {
        if (this.hxP != null) {
            this.hxP.bCW();
        }
    }
}
