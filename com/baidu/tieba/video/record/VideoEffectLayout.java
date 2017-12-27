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
    private String bjH;
    private HListView dqX;
    private HListView hGQ;
    private d hGR;
    private l hGS;
    private List<e> hGT;
    private List<e> hGU;
    private List<e> hGV;
    private String hGW;
    private String hGX;
    private e<com.baidu.tieba.video.a> hGY;
    private e<String> hGZ;
    private e<MusicData> hHa;
    private StickerItem hHb;
    private AnimatorSet hHc;
    private AnimatorSet hHd;
    private AnimatorSet hHe;
    private int hHf;
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
        bKd();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dqX = (HListView) findViewById(d.g.effect_list_view);
        this.dqX.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dqX.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hGQ = (HListView) findViewById(d.g.sticker_list_view);
        this.hGQ.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hGR = new d();
        this.dqX.setAdapter((ListAdapter) this.hGR);
        this.hGS = new l();
        this.hGQ.setAdapter((ListAdapter) this.hGS);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.yq(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bKd() {
        this.hGW = "2";
        this.hGY = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ya(2));
        this.bjH = getString(d.j.filter_nature);
        this.hGZ = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hHb = stickerItem;
        this.hGX = getResources().getString(d.j.music_normal);
        this.hHa = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bJS() {
        bKd();
        if (this.hGR != null) {
            this.hGR.bIN();
            this.hGR.bIM();
            this.hGR.bIO();
        }
        if (this.hGS != null) {
            this.hGS.bJU();
        }
    }

    private void bKe() {
        if (this.hGT == null) {
            this.hGT = new ArrayList();
            a("No", com.baidu.tieba.video.a.ya(0));
            a("1", com.baidu.tieba.video.a.ya(1));
            a("2", com.baidu.tieba.video.a.ya(2));
            a("3", com.baidu.tieba.video.a.ya(3));
            a("4", com.baidu.tieba.video.a.ya(4));
            a("5", com.baidu.tieba.video.a.ya(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hGT.add(c(0, 1, str, aVar));
    }

    private void bKf() {
        if (this.hGU == null) {
            this.hGU = new ArrayList();
            l(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "nature");
            l(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            l(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            l(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            l(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            l(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            l(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            l(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            l(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            l(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            l(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            l(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            l(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            l(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            l(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            l(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            l(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            l(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void l(int i, String str, String str2) {
        if (this.hGU != null) {
            this.hGU.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJG() {
        this.hHf = 3;
        k(this.hGV, this.hGX);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJH() {
        this.hHf = 0;
        this.hGQ.setAdapter((ListAdapter) this.hGS);
        this.hGS.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            oi(true);
            return;
        }
        this.hGQ.setVisibility(0);
        this.dqX.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJI() {
        this.hHf = 1;
        bKe();
        k(this.hGT, this.hGW);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJJ() {
        this.hHf = 2;
        bKf();
        k(this.hGU, this.bjH);
    }

    public void setListener(final a aVar) {
        if (this.hGR != null) {
            this.hGR.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hGW = eVar.getName();
                                VideoEffectLayout.this.hGY = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bjH = eVar.getName();
                                VideoEffectLayout.this.hGZ = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hGX = eVar.getName();
                                VideoEffectLayout.this.hHa = eVar;
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
        if (this.hGS != null) {
            this.hGS.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hHb = stickerItem;
        if (!v.G(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hGS != null) {
                this.hGS.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.G(this.mStickerItems)) {
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
            if (this.hGS != null) {
                this.hGS.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hGR.e(list, str);
                    VideoEffectLayout.this.hGR.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hGQ.getVisibility() == 0) {
                runnable.run();
                oi(false);
            } else {
                bKg();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dqX.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hHf;
    }

    public e<String> getCurrentFilterItem() {
        return this.hGZ;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hGY;
    }

    public StickerItem getCurrentStickItem() {
        return this.hHb;
    }

    private void bKg() {
        if (this.hHd != null && this.hHd.isRunning()) {
            this.hHd.cancel();
        }
        if (this.hHc == null) {
            this.hHc = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dqX, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dqX, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hHc.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dqX.setVisibility(0);
        this.hHc.start();
    }

    private void oi(boolean z) {
        if (z) {
            if (this.hHe != null && this.hHe.isRunning()) {
                this.hHe.cancel();
            }
            if (this.hHc != null && this.hHc.isRunning()) {
                this.hHc.cancel();
            }
            if (this.hHd == null) {
                this.hHd = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dqX, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hGQ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hGQ != null) {
                            VideoEffectLayout.this.hGQ.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hHq && VideoEffectLayout.this.dqX != null) {
                            VideoEffectLayout.this.dqX.setVisibility(8);
                        }
                    }
                });
                this.hHd.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hHd.start();
            return;
        }
        if (this.hHd != null && this.hHd.isRunning()) {
            this.hHd.cancel();
        }
        if (this.hHe == null) {
            this.hHe = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hGQ, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dqX, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dqX != null) {
                        VideoEffectLayout.this.dqX.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hHq && VideoEffectLayout.this.hGQ != null) {
                        VideoEffectLayout.this.hGQ.setVisibility(8);
                    }
                }
            });
            this.hHe.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hHe.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hGS != null) {
            this.hGS.B(list);
            this.hGS.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hGV == null) {
            this.hGV = new ArrayList();
        } else {
            this.hGV.clear();
        }
        this.hGV.addAll(list);
    }

    public boolean bKb() {
        if (v.G(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bKc() {
        if (this.hGR != null) {
            this.hGR.bIO();
            this.hGX = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bIP() {
        if (this.hGR != null) {
            this.hGR.bIP();
        }
    }
}
