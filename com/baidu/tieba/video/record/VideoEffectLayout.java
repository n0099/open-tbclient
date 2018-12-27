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
    private String aTl;
    private HListView dAF;
    private HListView hMC;
    private d hMD;
    private k hME;
    private List<e> hMF;
    private List<e> hMG;
    private List<e> hMH;
    private String hMI;
    private String hMJ;
    private e<com.baidu.tieba.video.a> hMK;
    private e<String> hML;
    private e<MusicData> hMM;
    private StickerItem hMN;
    private AnimatorSet hMO;
    private AnimatorSet hMP;
    private AnimatorSet hMQ;
    private int hMR;
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
        bLT();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.dAF = (HListView) findViewById(e.g.effect_list_view);
        this.dAF.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.dAF.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hMC = (HListView) findViewById(e.g.sticker_list_view);
        this.hMC.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hMD = new d();
        this.dAF.setAdapter((ListAdapter) this.hMD);
        this.hME = new k();
        this.hMC.setAdapter((ListAdapter) this.hME);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wN(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bLT() {
        this.hMI = "2";
        this.hMK = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wx(2));
        this.aTl = getString(e.j.filter_nature);
        this.hML = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hMN = stickerItem;
        this.hMJ = getResources().getString(e.j.music_normal);
        this.hMM = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bLU() {
        if (this.hMF == null) {
            this.hMF = new ArrayList();
            a("No", com.baidu.tieba.video.a.wx(0));
            a("1", com.baidu.tieba.video.a.wx(1));
            a("2", com.baidu.tieba.video.a.wx(2));
            a("3", com.baidu.tieba.video.a.wx(3));
            a("4", com.baidu.tieba.video.a.wx(4));
            a("5", com.baidu.tieba.video.a.wx(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hMF.add(c(0, 1, str, aVar));
    }

    private void bLV() {
        if (this.hMG == null) {
            this.hMG = new ArrayList();
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
        if (this.hMG != null) {
            this.hMG.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLw() {
        this.hMR = 3;
        l(this.hMH, this.hMJ);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLx() {
        this.hMR = 0;
        this.hMC.setAdapter((ListAdapter) this.hME);
        this.hME.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ok(true);
            return;
        }
        this.hMC.setVisibility(0);
        this.dAF.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLy() {
        this.hMR = 1;
        bLU();
        l(this.hMF, this.hMI);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLz() {
        this.hMR = 2;
        bLV();
        l(this.hMG, this.aTl);
    }

    public void setListener(final a aVar) {
        if (this.hMD != null) {
            this.hMD.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hMI = eVar.getName();
                                VideoEffectLayout.this.hMK = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aTl = eVar.getName();
                                VideoEffectLayout.this.hML = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hMJ = eVar.getName();
                                VideoEffectLayout.this.hMM = eVar;
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
        if (this.hME != null) {
            this.hME.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hMN = stickerItem;
        if (!v.I(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hME != null) {
                this.hME.notifyDataSetChanged();
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
            if (this.hME != null) {
                this.hME.notifyDataSetChanged();
            }
        }
    }

    private void l(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hMD.setData(list, str);
                    VideoEffectLayout.this.hMD.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hMC.getVisibility() == 0) {
                runnable.run();
                ok(false);
            } else {
                bLW();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dAF.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hMR;
    }

    public e<String> getCurrentFilterItem() {
        return this.hML;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hMK;
    }

    public StickerItem getCurrentStickItem() {
        return this.hMN;
    }

    private void bLW() {
        if (this.hMP != null && this.hMP.isRunning()) {
            this.hMP.cancel();
        }
        if (this.hMO == null) {
            this.hMO = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dAF, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dAF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hMO.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dAF.setVisibility(0);
        this.hMO.start();
    }

    private void ok(boolean z) {
        if (z) {
            if (this.hMQ != null && this.hMQ.isRunning()) {
                this.hMQ.cancel();
            }
            if (this.hMO != null && this.hMO.isRunning()) {
                this.hMO.cancel();
            }
            if (this.hMP == null) {
                this.hMP = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dAF, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hMC, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hMC != null) {
                            VideoEffectLayout.this.hMC.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hNb && VideoEffectLayout.this.dAF != null) {
                            VideoEffectLayout.this.dAF.setVisibility(8);
                        }
                    }
                });
                this.hMP.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hMP.start();
            return;
        }
        if (this.hMP != null && this.hMP.isRunning()) {
            this.hMP.cancel();
        }
        if (this.hMQ == null) {
            this.hMQ = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hMC, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dAF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dAF != null) {
                        VideoEffectLayout.this.dAF.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hNb && VideoEffectLayout.this.hMC != null) {
                        VideoEffectLayout.this.hMC.setVisibility(8);
                    }
                }
            });
            this.hMQ.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hMQ.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hME != null) {
            this.hME.C(list);
            this.hME.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hMH == null) {
            this.hMH = new ArrayList();
        } else {
            this.hMH.clear();
        }
        this.hMH.addAll(list);
    }

    public boolean bLR() {
        if (v.I(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bLS() {
        if (this.hMD != null) {
            this.hMD.bKF();
            this.hMJ = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bKG() {
        if (this.hMD != null) {
            this.hMD.bKG();
        }
    }
}
