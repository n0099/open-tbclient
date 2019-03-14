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
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String ccL;
    private HListView eOF;
    private HListView jeg;
    private d jeh;
    private k jei;
    private List<e> jej;
    private List<e> jek;
    private List<e> jel;
    private String jem;
    private String jen;
    private e<com.baidu.tieba.video.a> jeo;
    private e<String> jep;
    private e<MusicData> jeq;
    private StickerItem jer;
    private AnimatorSet jes;
    private AnimatorSet jet;
    private AnimatorSet jeu;
    private int jev;
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
        cmd();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.eOF = (HListView) findViewById(d.g.effect_list_view);
        this.eOF.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.eOF.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jeg = (HListView) findViewById(d.g.sticker_list_view);
        this.jeg.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.jeh = new d();
        this.eOF.setAdapter((ListAdapter) this.jeh);
        this.jei = new k();
        this.jeg.setAdapter((ListAdapter) this.jei);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.AC(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cmd() {
        this.jem = "2";
        this.jeo = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Am(2));
        this.ccL = getString(d.j.filter_nature);
        this.jep = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jer = stickerItem;
        this.jen = getResources().getString(d.j.music_normal);
        this.jeq = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    private void cme() {
        if (this.jej == null) {
            this.jej = new ArrayList();
            a("No", com.baidu.tieba.video.a.Am(0));
            a("1", com.baidu.tieba.video.a.Am(1));
            a("2", com.baidu.tieba.video.a.Am(2));
            a("3", com.baidu.tieba.video.a.Am(3));
            a("4", com.baidu.tieba.video.a.Am(4));
            a("5", com.baidu.tieba.video.a.Am(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jej.add(c(0, 1, str, aVar));
    }

    private void cmf() {
        if (this.jek == null) {
            this.jek = new ArrayList();
            m(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "origin");
            m(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            m(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            m(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            m(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            m(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            m(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            m(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            m(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            m(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            m(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            m(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            m(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            m(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            m(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            m(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            m(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            m(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void m(int i, String str, String str2) {
        if (this.jek != null) {
            this.jek.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        this.jev = 3;
        n(this.jel, this.jen);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jev = 0;
        this.jeg.setAdapter((ListAdapter) this.jei);
        this.jei.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            qL(true);
            return;
        }
        this.jeg.setVisibility(0);
        this.eOF.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clI() {
        this.jev = 1;
        cme();
        n(this.jej, this.jem);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clJ() {
        this.jev = 2;
        cmf();
        n(this.jek, this.ccL);
    }

    public void setListener(final a aVar) {
        if (this.jeh != null) {
            this.jeh.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jem = eVar.getName();
                                VideoEffectLayout.this.jeo = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ccL = eVar.getName();
                                VideoEffectLayout.this.jep = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jen = eVar.getName();
                                VideoEffectLayout.this.jeq = eVar;
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
        if (this.jei != null) {
            this.jei.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jer = stickerItem;
        if (!v.T(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jei != null) {
                this.jei.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.T(this.mStickerItems)) {
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
            if (this.jei != null) {
                this.jei.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jeh.b(list, str);
                    VideoEffectLayout.this.jeh.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jeg.getVisibility() == 0) {
                runnable.run();
                qL(false);
            } else {
                cmg();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.eOF.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jev;
    }

    public e<String> getCurrentFilterItem() {
        return this.jep;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jeo;
    }

    public StickerItem getCurrentStickItem() {
        return this.jer;
    }

    private void cmg() {
        if (this.jet != null && this.jet.isRunning()) {
            this.jet.cancel();
        }
        if (this.jes == null) {
            this.jes = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOF, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.eOF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jes.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.eOF.setVisibility(0);
        this.jes.start();
    }

    private void qL(boolean z) {
        if (z) {
            if (this.jeu != null && this.jeu.isRunning()) {
                this.jeu.cancel();
            }
            if (this.jes != null && this.jes.isRunning()) {
                this.jes.cancel();
            }
            if (this.jet == null) {
                this.jet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eOF, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jeg, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jeg != null) {
                            VideoEffectLayout.this.jeg.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jeE && VideoEffectLayout.this.eOF != null) {
                            VideoEffectLayout.this.eOF.setVisibility(8);
                        }
                    }
                });
                this.jet.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jet.start();
            return;
        }
        if (this.jet != null && this.jet.isRunning()) {
            this.jet.cancel();
        }
        if (this.jeu == null) {
            this.jeu = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jeg, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.eOF, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.eOF != null) {
                        VideoEffectLayout.this.eOF.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jeE && VideoEffectLayout.this.jeg != null) {
                        VideoEffectLayout.this.jeg.setVisibility(8);
                    }
                }
            });
            this.jeu.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jeu.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jei != null) {
            this.jei.M(list);
            this.jei.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jel == null) {
            this.jel = new ArrayList();
        } else {
            this.jel.clear();
        }
        this.jel.addAll(list);
    }

    public boolean cmb() {
        if (v.T(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cmc() {
        if (this.jeh != null) {
            this.jeh.ckP();
            this.jen = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void ckQ() {
        if (this.jeh != null) {
            this.jeh.ckQ();
        }
    }
}
