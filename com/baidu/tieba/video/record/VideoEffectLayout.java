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
    private String aGm;
    private HListView dbz;
    private HListView hfW;
    private d hfX;
    private k hfY;
    private List<e> hfZ;
    private List<e> hga;
    private List<e> hgb;
    private String hgc;
    private String hgd;
    private e<com.baidu.tieba.video.a> hge;
    private e<String> hgf;
    private e<MusicData> hgg;
    private StickerItem hgh;
    private AnimatorSet hgi;
    private AnimatorSet hgj;
    private AnimatorSet hgk;
    private int hgl;
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
        bEm();
        inflate(getContext(), d.i.layout_effect_container, this);
        this.dbz = (HListView) findViewById(d.g.effect_list_view);
        this.dbz.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dbz.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hfW = (HListView) findViewById(d.g.sticker_list_view);
        this.hfW.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hfX = new d();
        this.dbz.setAdapter((ListAdapter) this.hfX);
        this.hfY = new k();
        this.hfW.setAdapter((ListAdapter) this.hfY);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.uG(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEm() {
        this.hgc = "2";
        this.hge = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uq(2));
        this.aGm = getString(d.k.filter_nature);
        this.hgf = c(d.f.filter_icon_avatar_default, 2, getString(d.k.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hgh = stickerItem;
        this.hgd = getResources().getString(d.k.music_normal);
        this.hgg = new e<>(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute);
    }

    private void bEn() {
        if (this.hfZ == null) {
            this.hfZ = new ArrayList();
            a("No", com.baidu.tieba.video.a.uq(0));
            a("1", com.baidu.tieba.video.a.uq(1));
            a("2", com.baidu.tieba.video.a.uq(2));
            a("3", com.baidu.tieba.video.a.uq(3));
            a("4", com.baidu.tieba.video.a.uq(4));
            a("5", com.baidu.tieba.video.a.uq(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hfZ.add(c(0, 1, str, aVar));
    }

    private void bEo() {
        if (this.hga == null) {
            this.hga = new ArrayList();
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
        if (this.hga != null) {
            this.hga.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        this.hgl = 3;
        k(this.hgb, this.hgd);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        this.hgl = 0;
        this.hfW.setAdapter((ListAdapter) this.hfY);
        this.hfY.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nj(true);
            return;
        }
        this.hfW.setVisibility(0);
        this.dbz.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        this.hgl = 1;
        bEn();
        k(this.hfZ, this.hgc);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        this.hgl = 2;
        bEo();
        k(this.hga, this.aGm);
    }

    public void setListener(final a aVar) {
        if (this.hfX != null) {
            this.hfX.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hgc = eVar.getName();
                                VideoEffectLayout.this.hge = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aGm = eVar.getName();
                                VideoEffectLayout.this.hgf = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hgd = eVar.getName();
                                VideoEffectLayout.this.hgg = eVar;
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
        if (this.hfY != null) {
            this.hfY.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hgh = stickerItem;
        if (!w.z(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hfY != null) {
                this.hfY.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!w.z(this.mStickerItems)) {
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
            if (this.hfY != null) {
                this.hfY.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hfX.f(list, str);
                    VideoEffectLayout.this.hfX.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hfW.getVisibility() == 0) {
                runnable.run();
                nj(false);
            } else {
                bEp();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dbz.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hgl;
    }

    public e<String> getCurrentFilterItem() {
        return this.hgf;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hge;
    }

    public StickerItem getCurrentStickItem() {
        return this.hgh;
    }

    private void bEp() {
        if (this.hgj != null && this.hgj.isRunning()) {
            this.hgj.cancel();
        }
        if (this.hgi == null) {
            this.hgi = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dbz, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dbz, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hgi.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dbz.setVisibility(0);
        this.hgi.start();
    }

    private void nj(boolean z) {
        if (z) {
            if (this.hgk != null && this.hgk.isRunning()) {
                this.hgk.cancel();
            }
            if (this.hgi != null && this.hgi.isRunning()) {
                this.hgi.cancel();
            }
            if (this.hgj == null) {
                this.hgj = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dbz, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hfW, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hfW != null) {
                            VideoEffectLayout.this.hfW.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hgw && VideoEffectLayout.this.dbz != null) {
                            VideoEffectLayout.this.dbz.setVisibility(8);
                        }
                    }
                });
                this.hgj.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hgj.start();
            return;
        }
        if (this.hgj != null && this.hgj.isRunning()) {
            this.hgj.cancel();
        }
        if (this.hgk == null) {
            this.hgk = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hfW, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dbz, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dbz != null) {
                        VideoEffectLayout.this.dbz.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hgw && VideoEffectLayout.this.hfW != null) {
                        VideoEffectLayout.this.hfW.setVisibility(8);
                    }
                }
            });
            this.hgk.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hgk.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hfY != null) {
            this.hfY.t(list);
            this.hfY.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hgb == null) {
            this.hgb = new ArrayList();
        } else {
            this.hgb.clear();
        }
        this.hgb.addAll(list);
    }

    public boolean bEk() {
        if (w.z(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEl() {
        if (this.hfX != null) {
            this.hfX.bCX();
            this.hgd = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bCY() {
        if (this.hfX != null) {
            this.hfX.bCY();
        }
    }
}
