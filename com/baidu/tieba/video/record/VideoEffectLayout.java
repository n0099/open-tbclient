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
    private String axR;
    private HListView cSs;
    private List<e> gUA;
    private String gUB;
    private String gUC;
    private e<com.baidu.tieba.video.a> gUD;
    private e<String> gUE;
    private e<MusicData> gUF;
    private StickerItem gUG;
    private AnimatorSet gUH;
    private AnimatorSet gUI;
    private AnimatorSet gUJ;
    private int gUK;
    private HListView gUv;
    private d gUw;
    private k gUx;
    private List<e> gUy;
    private List<e> gUz;
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
        bzg();
        inflate(getContext(), d.i.layout_effect_container, this);
        this.cSs = (HListView) findViewById(d.g.effect_list_view);
        this.cSs.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cSs.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gUv = (HListView) findViewById(d.g.sticker_list_view);
        this.gUv.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gUw = new d();
        this.cSs.setAdapter((ListAdapter) this.gUw);
        this.gUx = new k();
        this.gUv.setAdapter((ListAdapter) this.gUx);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.ut(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bzg() {
        this.gUB = "2";
        this.gUD = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ud(2));
        this.axR = getString(d.k.filter_nature);
        this.gUE = c(d.f.filter_icon_avatar_default, 2, getString(d.k.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gUG = stickerItem;
        this.gUC = getResources().getString(d.k.music_normal);
        this.gUF = new e<>(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute);
    }

    private void bzh() {
        if (this.gUy == null) {
            this.gUy = new ArrayList();
            a("No", com.baidu.tieba.video.a.ud(0));
            a("1", com.baidu.tieba.video.a.ud(1));
            a("2", com.baidu.tieba.video.a.ud(2));
            a("3", com.baidu.tieba.video.a.ud(3));
            a("4", com.baidu.tieba.video.a.ud(4));
            a("5", com.baidu.tieba.video.a.ud(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.gUy.add(c(0, 1, str, aVar));
    }

    private void bzi() {
        if (this.gUz == null) {
            this.gUz = new ArrayList();
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
        if (this.gUz != null) {
            this.gUz.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byJ() {
        this.gUK = 3;
        k(this.gUA, this.gUC);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byK() {
        this.gUK = 0;
        this.gUv.setAdapter((ListAdapter) this.gUx);
        this.gUx.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nd(true);
            return;
        }
        this.gUv.setVisibility(0);
        this.cSs.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        this.gUK = 1;
        bzh();
        k(this.gUy, this.gUB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gUK = 2;
        bzi();
        k(this.gUz, this.axR);
    }

    public void setListener(final a aVar) {
        if (this.gUw != null) {
            this.gUw.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gUB = eVar.getName();
                                VideoEffectLayout.this.gUD = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.axR = eVar.getName();
                                VideoEffectLayout.this.gUE = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gUC = eVar.getName();
                                VideoEffectLayout.this.gUF = eVar;
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
        if (this.gUx != null) {
            this.gUx.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gUG = stickerItem;
        if (!v.w(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gUx != null) {
                this.gUx.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.w(this.mStickerItems)) {
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
            if (this.gUx != null) {
                this.gUx.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gUw.f(list, str);
                    VideoEffectLayout.this.gUw.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gUv.getVisibility() == 0) {
                runnable.run();
                nd(false);
            } else {
                bzj();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.cSs.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gUK;
    }

    public e<String> getCurrentFilterItem() {
        return this.gUE;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gUD;
    }

    public StickerItem getCurrentStickItem() {
        return this.gUG;
    }

    private void bzj() {
        if (this.gUI != null && this.gUI.isRunning()) {
            this.gUI.cancel();
        }
        if (this.gUH == null) {
            this.gUH = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cSs, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cSs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gUH.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cSs.setVisibility(0);
        this.gUH.start();
    }

    private void nd(boolean z) {
        if (z) {
            if (this.gUJ != null && this.gUJ.isRunning()) {
                this.gUJ.cancel();
            }
            if (this.gUH != null && this.gUH.isRunning()) {
                this.gUH.cancel();
            }
            if (this.gUI == null) {
                this.gUI = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cSs, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gUv, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gUv != null) {
                            VideoEffectLayout.this.gUv.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gUV && VideoEffectLayout.this.cSs != null) {
                            VideoEffectLayout.this.cSs.setVisibility(8);
                        }
                    }
                });
                this.gUI.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.gUI.start();
            return;
        }
        if (this.gUI != null && this.gUI.isRunning()) {
            this.gUI.cancel();
        }
        if (this.gUJ == null) {
            this.gUJ = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gUv, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cSs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cSs != null) {
                        VideoEffectLayout.this.cSs.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gUV && VideoEffectLayout.this.gUv != null) {
                        VideoEffectLayout.this.gUv.setVisibility(8);
                    }
                }
            });
            this.gUJ.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gUJ.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gUx != null) {
            this.gUx.q(list);
            this.gUx.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.gUA == null) {
            this.gUA = new ArrayList();
        } else {
            this.gUA.clear();
        }
        this.gUA.addAll(list);
    }

    public boolean bze() {
        if (v.w(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bzf() {
        if (this.gUw != null) {
            this.gUw.bxR();
            this.gUC = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bxS() {
        if (this.gUw != null) {
            this.gUw.bxS();
        }
    }
}
