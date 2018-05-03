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
    private String axQ;
    private HListView cRl;
    private e<String> gTA;
    private e<MusicData> gTB;
    private StickerItem gTC;
    private AnimatorSet gTD;
    private AnimatorSet gTE;
    private AnimatorSet gTF;
    private int gTG;
    private HListView gTr;
    private d gTs;
    private k gTt;
    private List<e> gTu;
    private List<e> gTv;
    private List<e> gTw;
    private String gTx;
    private String gTy;
    private e<com.baidu.tieba.video.a> gTz;
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
        bzi();
        inflate(getContext(), d.i.layout_effect_container, this);
        this.cRl = (HListView) findViewById(d.g.effect_list_view);
        this.cRl.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cRl.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gTr = (HListView) findViewById(d.g.sticker_list_view);
        this.gTr.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gTs = new d();
        this.cRl.setAdapter((ListAdapter) this.gTs);
        this.gTt = new k();
        this.gTr.setAdapter((ListAdapter) this.gTt);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.uu(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bzi() {
        this.gTx = "2";
        this.gTz = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ue(2));
        this.axQ = getString(d.k.filter_nature);
        this.gTA = c(d.f.filter_icon_avatar_default, 2, getString(d.k.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gTC = stickerItem;
        this.gTy = getResources().getString(d.k.music_normal);
        this.gTB = new e<>(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute);
    }

    private void bzj() {
        if (this.gTu == null) {
            this.gTu = new ArrayList();
            a("No", com.baidu.tieba.video.a.ue(0));
            a("1", com.baidu.tieba.video.a.ue(1));
            a("2", com.baidu.tieba.video.a.ue(2));
            a("3", com.baidu.tieba.video.a.ue(3));
            a("4", com.baidu.tieba.video.a.ue(4));
            a("5", com.baidu.tieba.video.a.ue(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.gTu.add(c(0, 1, str, aVar));
    }

    private void bzk() {
        if (this.gTv == null) {
            this.gTv = new ArrayList();
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
        if (this.gTv != null) {
            this.gTv.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        this.gTG = 3;
        k(this.gTw, this.gTy);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gTG = 0;
        this.gTr.setAdapter((ListAdapter) this.gTt);
        this.gTt.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nc(true);
            return;
        }
        this.gTr.setVisibility(0);
        this.cRl.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        this.gTG = 1;
        bzj();
        k(this.gTu, this.gTx);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        this.gTG = 2;
        bzk();
        k(this.gTv, this.axQ);
    }

    public void setListener(final a aVar) {
        if (this.gTs != null) {
            this.gTs.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gTx = eVar.getName();
                                VideoEffectLayout.this.gTz = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.axQ = eVar.getName();
                                VideoEffectLayout.this.gTA = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gTy = eVar.getName();
                                VideoEffectLayout.this.gTB = eVar;
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
        if (this.gTt != null) {
            this.gTt.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gTC = stickerItem;
        if (!v.w(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gTt != null) {
                this.gTt.notifyDataSetChanged();
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
            if (this.gTt != null) {
                this.gTt.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gTs.f(list, str);
                    VideoEffectLayout.this.gTs.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gTr.getVisibility() == 0) {
                runnable.run();
                nc(false);
            } else {
                bzl();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.cRl.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gTG;
    }

    public e<String> getCurrentFilterItem() {
        return this.gTA;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gTz;
    }

    public StickerItem getCurrentStickItem() {
        return this.gTC;
    }

    private void bzl() {
        if (this.gTE != null && this.gTE.isRunning()) {
            this.gTE.cancel();
        }
        if (this.gTD == null) {
            this.gTD = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cRl, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cRl, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gTD.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cRl.setVisibility(0);
        this.gTD.start();
    }

    private void nc(boolean z) {
        if (z) {
            if (this.gTF != null && this.gTF.isRunning()) {
                this.gTF.cancel();
            }
            if (this.gTD != null && this.gTD.isRunning()) {
                this.gTD.cancel();
            }
            if (this.gTE == null) {
                this.gTE = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cRl, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gTr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gTr != null) {
                            VideoEffectLayout.this.gTr.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gTR && VideoEffectLayout.this.cRl != null) {
                            VideoEffectLayout.this.cRl.setVisibility(8);
                        }
                    }
                });
                this.gTE.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.gTE.start();
            return;
        }
        if (this.gTE != null && this.gTE.isRunning()) {
            this.gTE.cancel();
        }
        if (this.gTF == null) {
            this.gTF = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gTr, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cRl, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cRl != null) {
                        VideoEffectLayout.this.cRl.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTR && VideoEffectLayout.this.gTr != null) {
                        VideoEffectLayout.this.gTr.setVisibility(8);
                    }
                }
            });
            this.gTF.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gTF.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gTt != null) {
            this.gTt.q(list);
            this.gTt.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.gTw == null) {
            this.gTw = new ArrayList();
        } else {
            this.gTw.clear();
        }
        this.gTw.addAll(list);
    }

    public boolean bzg() {
        if (v.w(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bzh() {
        if (this.gTs != null) {
            this.gTs.bxT();
            this.gTy = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bxU() {
        if (this.gTs != null) {
            this.gTs.bxU();
        }
    }
}
