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
import com.baidu.tbadk.TbConfig;
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
    private String auK;
    private HListView cta;
    private HListView gKU;
    private c gKV;
    private k gKW;
    private List<d> gKX;
    private List<d> gKY;
    private List<d> gKZ;
    private String gLa;
    private String gLb;
    private d<com.baidu.tieba.video.a> gLc;
    private d<String> gLd;
    private d<MusicData> gLe;
    private StickerItem gLf;
    private AnimatorSet gLg;
    private AnimatorSet gLh;
    private AnimatorSet gLi;
    private int gLj;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes2.dex */
    public interface a {
        void a(StickerItem stickerItem);

        void a(d dVar, Object obj);
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
        this.gLa = "2";
        this.gLc = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uG(2));
        this.auK = getString(d.j.filter_nature);
        this.gLd = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gLf = stickerItem;
        this.gLb = getResources().getString(d.j.music_normal);
        this.gLe = new d<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
        inflate(getContext(), d.h.layout_effect_container, this);
        this.cta = (HListView) findViewById(d.g.effect_list_view);
        this.cta.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cta.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gKU = (HListView) findViewById(d.g.sticker_list_view);
        this.gKU.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gKV = new c();
        this.cta.setAdapter((ListAdapter) this.gKV);
        this.gKW = new k();
        this.gKU.setAdapter((ListAdapter) this.gKW);
    }

    private <T> d<T> c(int i, int i2, String str, T t) {
        d<T> dVar = new d<>();
        dVar.setType(i2);
        dVar.uS(i);
        dVar.setName(str);
        dVar.setValue(t);
        return dVar;
    }

    private void bBa() {
        if (this.gKX == null) {
            this.gKX = new ArrayList();
            a(d.f.beauty_icon_avatar_0, "Normal", com.baidu.tieba.video.a.uG(0));
            a(d.f.beauty_icon_avatar_1, "1", com.baidu.tieba.video.a.uG(1));
            a(d.f.beauty_icon_avatar_2, "2", com.baidu.tieba.video.a.uG(2));
            a(d.f.beauty_icon_avatar_3, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, com.baidu.tieba.video.a.uG(3));
            a(d.f.beauty_icon_avatar_4, "4", com.baidu.tieba.video.a.uG(4));
            a(d.f.beauty_icon_avatar_5, "5", com.baidu.tieba.video.a.uG(5));
        }
    }

    private void a(int i, String str, com.baidu.tieba.video.a aVar) {
        this.gKX.add(c(i, 1, str, aVar));
    }

    private void bBb() {
        if (this.gKY == null) {
            this.gKY = new ArrayList();
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
        if (this.gKY != null) {
            this.gKY.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAH() {
        this.gLj = 3;
        j(this.gKZ, this.gLb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAI() {
        this.gLj = 0;
        this.gKU.setAdapter((ListAdapter) this.gKW);
        this.gKW.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nd(true);
            return;
        }
        this.gKU.setVisibility(0);
        this.cta.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAJ() {
        this.gLj = 1;
        bBa();
        j(this.gKX, this.gLa);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAK() {
        this.gLj = 2;
        bBb();
        j(this.gKY, this.auK);
    }

    public void setListener(final a aVar) {
        if (this.gKV != null) {
            this.gKV.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar, Object obj) {
                    if (dVar != null) {
                        if (aVar != null) {
                            aVar.a(dVar, obj);
                        }
                        switch (dVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gLa = dVar.getName();
                                VideoEffectLayout.this.gLc = dVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.auK = dVar.getName();
                                VideoEffectLayout.this.gLd = dVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gLb = dVar.getName();
                                VideoEffectLayout.this.gLe = dVar;
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
        if (this.gKW != null) {
            this.gKW.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar, Object obj) {
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
        this.gLf = stickerItem;
        if (!v.v(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gKW != null) {
                this.gKW.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.v(this.mStickerItems)) {
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
            if (this.gKW != null) {
                this.gKW.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<d> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gKV.d(list, str);
                    VideoEffectLayout.this.gKV.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gKU.getVisibility() == 0) {
                runnable.run();
                nd(false);
            } else {
                bBc();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.cta.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gLj;
    }

    public d<String> getCurrentFilterItem() {
        return this.gLd;
    }

    public d<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gLc;
    }

    public StickerItem getCurrentStickItem() {
        return this.gLf;
    }

    private void bBc() {
        if (this.gLh != null && this.gLh.isRunning()) {
            this.gLh.cancel();
        }
        if (this.gLg == null) {
            this.gLg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cta, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cta, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gLg.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cta.setVisibility(0);
        this.gLg.start();
    }

    private void nd(boolean z) {
        if (z) {
            if (this.gLi != null && this.gLi.isRunning()) {
                this.gLi.cancel();
            }
            if (this.gLg != null && this.gLg.isRunning()) {
                this.gLg.cancel();
            }
            if (this.gLh == null) {
                this.gLh = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cta, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gKU, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gKU != null) {
                            VideoEffectLayout.this.gKU.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gLq && VideoEffectLayout.this.cta != null) {
                            VideoEffectLayout.this.cta.setVisibility(8);
                        }
                    }
                });
                this.gLh.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gLh.start();
            return;
        }
        if (this.gLh != null && this.gLh.isRunning()) {
            this.gLh.cancel();
        }
        if (this.gLi == null) {
            this.gLi = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gKU, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cta, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cta != null) {
                        VideoEffectLayout.this.cta.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gLq && VideoEffectLayout.this.gKU != null) {
                        VideoEffectLayout.this.gKU.setVisibility(8);
                    }
                }
            });
            this.gLi.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gLi.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gKW != null) {
            this.gKW.q(list);
            this.gKW.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<d> list) {
        if (this.gKZ == null) {
            this.gKZ = new ArrayList();
        } else {
            this.gKZ.clear();
        }
        this.gKZ.addAll(list);
    }

    public boolean bAY() {
        if (v.v(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bAZ() {
        if (this.gKV != null) {
            this.gKV.bAa();
            this.gLb = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bAb() {
        if (this.gKV != null) {
            this.gKV.bAb();
        }
    }
}
