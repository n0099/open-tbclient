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
    private HListView cRo;
    private String gTA;
    private String gTB;
    private e<com.baidu.tieba.video.a> gTC;
    private e<String> gTD;
    private e<MusicData> gTE;
    private StickerItem gTF;
    private AnimatorSet gTG;
    private AnimatorSet gTH;
    private AnimatorSet gTI;
    private int gTJ;
    private HListView gTu;
    private d gTv;
    private k gTw;
    private List<e> gTx;
    private List<e> gTy;
    private List<e> gTz;
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
        this.cRo = (HListView) findViewById(d.g.effect_list_view);
        this.cRo.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cRo.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gTu = (HListView) findViewById(d.g.sticker_list_view);
        this.gTu.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gTv = new d();
        this.cRo.setAdapter((ListAdapter) this.gTv);
        this.gTw = new k();
        this.gTu.setAdapter((ListAdapter) this.gTw);
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
        this.gTA = "2";
        this.gTC = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ue(2));
        this.axQ = getString(d.k.filter_nature);
        this.gTD = c(d.f.filter_icon_avatar_default, 2, getString(d.k.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gTF = stickerItem;
        this.gTB = getResources().getString(d.k.music_normal);
        this.gTE = new e<>(3, getResources().getString(d.k.music_normal), new MusicData("-100", 1, getResources().getString(d.k.music_normal)), d.f.icon_video_mute);
    }

    private void bzj() {
        if (this.gTx == null) {
            this.gTx = new ArrayList();
            a("No", com.baidu.tieba.video.a.ue(0));
            a("1", com.baidu.tieba.video.a.ue(1));
            a("2", com.baidu.tieba.video.a.ue(2));
            a("3", com.baidu.tieba.video.a.ue(3));
            a("4", com.baidu.tieba.video.a.ue(4));
            a("5", com.baidu.tieba.video.a.ue(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.gTx.add(c(0, 1, str, aVar));
    }

    private void bzk() {
        if (this.gTy == null) {
            this.gTy = new ArrayList();
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
        if (this.gTy != null) {
            this.gTy.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        this.gTJ = 3;
        k(this.gTz, this.gTB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gTJ = 0;
        this.gTu.setAdapter((ListAdapter) this.gTw);
        this.gTw.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nc(true);
            return;
        }
        this.gTu.setVisibility(0);
        this.cRo.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        this.gTJ = 1;
        bzj();
        k(this.gTx, this.gTA);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        this.gTJ = 2;
        bzk();
        k(this.gTy, this.axQ);
    }

    public void setListener(final a aVar) {
        if (this.gTv != null) {
            this.gTv.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gTA = eVar.getName();
                                VideoEffectLayout.this.gTC = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.axQ = eVar.getName();
                                VideoEffectLayout.this.gTD = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gTB = eVar.getName();
                                VideoEffectLayout.this.gTE = eVar;
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
        if (this.gTw != null) {
            this.gTw.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gTF = stickerItem;
        if (!v.w(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gTw != null) {
                this.gTw.notifyDataSetChanged();
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
            if (this.gTw != null) {
                this.gTw.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gTv.f(list, str);
                    VideoEffectLayout.this.gTv.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gTu.getVisibility() == 0) {
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
                VideoEffectLayout.this.cRo.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gTJ;
    }

    public e<String> getCurrentFilterItem() {
        return this.gTD;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gTC;
    }

    public StickerItem getCurrentStickItem() {
        return this.gTF;
    }

    private void bzl() {
        if (this.gTH != null && this.gTH.isRunning()) {
            this.gTH.cancel();
        }
        if (this.gTG == null) {
            this.gTG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cRo, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cRo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gTG.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cRo.setVisibility(0);
        this.gTG.start();
    }

    private void nc(boolean z) {
        if (z) {
            if (this.gTI != null && this.gTI.isRunning()) {
                this.gTI.cancel();
            }
            if (this.gTG != null && this.gTG.isRunning()) {
                this.gTG.cancel();
            }
            if (this.gTH == null) {
                this.gTH = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cRo, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gTu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gTu != null) {
                            VideoEffectLayout.this.gTu.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gTU && VideoEffectLayout.this.cRo != null) {
                            VideoEffectLayout.this.cRo.setVisibility(8);
                        }
                    }
                });
                this.gTH.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.gTH.start();
            return;
        }
        if (this.gTH != null && this.gTH.isRunning()) {
            this.gTH.cancel();
        }
        if (this.gTI == null) {
            this.gTI = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gTu, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cRo, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cRo != null) {
                        VideoEffectLayout.this.cRo.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTU && VideoEffectLayout.this.gTu != null) {
                        VideoEffectLayout.this.gTu.setVisibility(8);
                    }
                }
            });
            this.gTI.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gTI.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gTw != null) {
            this.gTw.q(list);
            this.gTw.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.gTz == null) {
            this.gTz = new ArrayList();
        } else {
            this.gTz.clear();
        }
        this.gTz.addAll(list);
    }

    public boolean bzg() {
        if (v.w(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bzh() {
        if (this.gTv != null) {
            this.gTv.bxT();
            this.gTB = TbadkCoreApplication.getInst().getString(d.k.music_normal);
        }
    }

    public void bxU() {
        if (this.gTv != null) {
            this.gTv.bxU();
        }
    }
}
