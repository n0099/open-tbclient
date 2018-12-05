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
    private String aTi;
    private HListView dxS;
    private e<String> hJA;
    private e<MusicData> hJB;
    private StickerItem hJC;
    private AnimatorSet hJD;
    private AnimatorSet hJE;
    private AnimatorSet hJF;
    private int hJG;
    private HListView hJr;
    private d hJs;
    private k hJt;
    private List<e> hJu;
    private List<e> hJv;
    private List<e> hJw;
    private String hJx;
    private String hJy;
    private e<com.baidu.tieba.video.a> hJz;
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
        bLe();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.dxS = (HListView) findViewById(e.g.effect_list_view);
        this.dxS.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.dxS.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hJr = (HListView) findViewById(e.g.sticker_list_view);
        this.hJr.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hJs = new d();
        this.dxS.setAdapter((ListAdapter) this.hJs);
        this.hJt = new k();
        this.hJr.setAdapter((ListAdapter) this.hJt);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wA(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bLe() {
        this.hJx = "2";
        this.hJz = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wk(2));
        this.aTi = getString(e.j.filter_nature);
        this.hJA = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hJC = stickerItem;
        this.hJy = getResources().getString(e.j.music_normal);
        this.hJB = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bLf() {
        if (this.hJu == null) {
            this.hJu = new ArrayList();
            a("No", com.baidu.tieba.video.a.wk(0));
            a("1", com.baidu.tieba.video.a.wk(1));
            a("2", com.baidu.tieba.video.a.wk(2));
            a("3", com.baidu.tieba.video.a.wk(3));
            a("4", com.baidu.tieba.video.a.wk(4));
            a("5", com.baidu.tieba.video.a.wk(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hJu.add(c(0, 1, str, aVar));
    }

    private void bLg() {
        if (this.hJv == null) {
            this.hJv = new ArrayList();
            m(e.f.filter_icon_avatar_default, getString(e.j.filter_nature), "origin");
            m(e.f.filter_icon_avatar_hongkong, getString(e.j.filter_hongkong), "hongkong");
            m(e.f.filter_icon_avatar_refreshing, getString(e.j.filter_refreshing), "refreshing");
            m(e.f.filter_icon_avatar_girly, getString(e.j.filter_girly), "girly");
            m(e.f.filter_icon_avatar_concrete, getString(e.j.filter_concrete), "concrete");
            m(e.f.filter_icon_avatar_warm, getString(e.j.filter_warm), "warm");
            m(e.f.filter_icon_avatar_cold, getString(e.j.filter_cold), "cold");
            m(e.f.filter_icon_avatar_japanese, getString(e.j.filter_japanese), "Japanese");
            m(e.f.filter_icon_avatar_cruz, getString(e.j.filter_hdr), "cruz");
            m(e.f.filter_icon_avatar_abao, getString(e.j.filter_abao), "abao");
            m(e.f.filter_icon_avatar_dew, getString(e.j.filter_dew), "dew");
            m(e.f.filter_icon_avatar_slowlived, getString(e.j.filter_slowlived), "slowlived");
            m(e.f.filter_icon_avatar_sweet, getString(e.j.filter_sweet), "sweet");
            m(e.f.filter_icon_avatar_boardwalk, getString(e.j.filter_boardwalk), "boardwalk");
            m(e.f.filter_icon_avatar_keylime, getString(e.j.filter_keylime), "keylime");
            m(e.f.filter_icon_avatar_electric, getString(e.j.filter_electric), "electric");
            m(e.f.filter_icon_avatar_silver, getString(e.j.filter_silver), "silver");
            m(e.f.filter_icon_avatar_blackwhite, getString(e.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void m(int i, String str, String str2) {
        if (this.hJv != null) {
            this.hJv.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKH() {
        this.hJG = 3;
        k(this.hJw, this.hJy);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKI() {
        this.hJG = 0;
        this.hJr.setAdapter((ListAdapter) this.hJt);
        this.hJt.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            oh(true);
            return;
        }
        this.hJr.setVisibility(0);
        this.dxS.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKJ() {
        this.hJG = 1;
        bLf();
        k(this.hJu, this.hJx);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKK() {
        this.hJG = 2;
        bLg();
        k(this.hJv, this.aTi);
    }

    public void setListener(final a aVar) {
        if (this.hJs != null) {
            this.hJs.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hJx = eVar.getName();
                                VideoEffectLayout.this.hJz = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aTi = eVar.getName();
                                VideoEffectLayout.this.hJA = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hJy = eVar.getName();
                                VideoEffectLayout.this.hJB = eVar;
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
        if (this.hJt != null) {
            this.hJt.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hJC = stickerItem;
        if (!v.I(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hJt != null) {
                this.hJt.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.I(this.mStickerItems)) {
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
            if (this.hJt != null) {
                this.hJt.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hJs.setData(list, str);
                    VideoEffectLayout.this.hJs.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hJr.getVisibility() == 0) {
                runnable.run();
                oh(false);
            } else {
                bLh();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dxS.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hJG;
    }

    public e<String> getCurrentFilterItem() {
        return this.hJA;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hJz;
    }

    public StickerItem getCurrentStickItem() {
        return this.hJC;
    }

    private void bLh() {
        if (this.hJE != null && this.hJE.isRunning()) {
            this.hJE.cancel();
        }
        if (this.hJD == null) {
            this.hJD = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dxS, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dxS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hJD.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dxS.setVisibility(0);
        this.hJD.start();
    }

    private void oh(boolean z) {
        if (z) {
            if (this.hJF != null && this.hJF.isRunning()) {
                this.hJF.cancel();
            }
            if (this.hJD != null && this.hJD.isRunning()) {
                this.hJD.cancel();
            }
            if (this.hJE == null) {
                this.hJE = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dxS, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hJr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hJr != null) {
                            VideoEffectLayout.this.hJr.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hJQ && VideoEffectLayout.this.dxS != null) {
                            VideoEffectLayout.this.dxS.setVisibility(8);
                        }
                    }
                });
                this.hJE.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hJE.start();
            return;
        }
        if (this.hJE != null && this.hJE.isRunning()) {
            this.hJE.cancel();
        }
        if (this.hJF == null) {
            this.hJF = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hJr, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dxS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dxS != null) {
                        VideoEffectLayout.this.dxS.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hJQ && VideoEffectLayout.this.hJr != null) {
                        VideoEffectLayout.this.hJr.setVisibility(8);
                    }
                }
            });
            this.hJF.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hJF.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hJt != null) {
            this.hJt.C(list);
            this.hJt.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hJw == null) {
            this.hJw = new ArrayList();
        } else {
            this.hJw.clear();
        }
        this.hJw.addAll(list);
    }

    public boolean bLc() {
        if (v.I(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bLd() {
        if (this.hJs != null) {
            this.hJs.bJQ();
            this.hJy = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bJR() {
        if (this.hJs != null) {
            this.hJs.bJR();
        }
    }
}
