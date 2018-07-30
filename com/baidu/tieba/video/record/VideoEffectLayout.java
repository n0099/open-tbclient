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
    private String aHe;
    private HListView dcr;
    private e<String> hlA;
    private e<MusicData> hlB;
    private StickerItem hlC;
    private AnimatorSet hlD;
    private AnimatorSet hlE;
    private AnimatorSet hlF;
    private int hlG;
    private HListView hlr;
    private d hls;
    private k hlt;
    private List<e> hlu;
    private List<e> hlv;
    private List<e> hlw;
    private String hlx;
    private String hly;
    private e<com.baidu.tieba.video.a> hlz;
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
        bDw();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dcr = (HListView) findViewById(d.g.effect_list_view);
        this.dcr.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dcr.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hlr = (HListView) findViewById(d.g.sticker_list_view);
        this.hlr.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hls = new d();
        this.dcr.setAdapter((ListAdapter) this.hls);
        this.hlt = new k();
        this.hlr.setAdapter((ListAdapter) this.hlt);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.uN(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bDw() {
        this.hlx = "2";
        this.hlz = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ux(2));
        this.aHe = getString(d.j.filter_nature);
        this.hlA = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hlC = stickerItem;
        this.hly = getResources().getString(d.j.music_normal);
        this.hlB = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    private void bDx() {
        if (this.hlu == null) {
            this.hlu = new ArrayList();
            a("No", com.baidu.tieba.video.a.ux(0));
            a("1", com.baidu.tieba.video.a.ux(1));
            a("2", com.baidu.tieba.video.a.ux(2));
            a("3", com.baidu.tieba.video.a.ux(3));
            a("4", com.baidu.tieba.video.a.ux(4));
            a("5", com.baidu.tieba.video.a.ux(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hlu.add(c(0, 1, str, aVar));
    }

    private void bDy() {
        if (this.hlv == null) {
            this.hlv = new ArrayList();
            j(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "nature");
            j(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            j(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            j(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            j(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            j(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            j(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            j(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            j(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            j(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            j(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            j(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            j(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            j(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            j(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            j(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            j(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            j(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void j(int i, String str, String str2) {
        if (this.hlv != null) {
            this.hlv.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bCZ() {
        this.hlG = 3;
        k(this.hlw, this.hly);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDa() {
        this.hlG = 0;
        this.hlr.setAdapter((ListAdapter) this.hlt);
        this.hlt.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ne(true);
            return;
        }
        this.hlr.setVisibility(0);
        this.dcr.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        this.hlG = 1;
        bDx();
        k(this.hlu, this.hlx);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        this.hlG = 2;
        bDy();
        k(this.hlv, this.aHe);
    }

    public void setListener(final a aVar) {
        if (this.hls != null) {
            this.hls.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hlx = eVar.getName();
                                VideoEffectLayout.this.hlz = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aHe = eVar.getName();
                                VideoEffectLayout.this.hlA = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hly = eVar.getName();
                                VideoEffectLayout.this.hlB = eVar;
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
        if (this.hlt != null) {
            this.hlt.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hlC = stickerItem;
        if (!w.z(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hlt != null) {
                this.hlt.notifyDataSetChanged();
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
            if (this.hlt != null) {
                this.hlt.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hls.f(list, str);
                    VideoEffectLayout.this.hls.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hlr.getVisibility() == 0) {
                runnable.run();
                ne(false);
            } else {
                bDz();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dcr.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hlG;
    }

    public e<String> getCurrentFilterItem() {
        return this.hlA;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hlz;
    }

    public StickerItem getCurrentStickItem() {
        return this.hlC;
    }

    private void bDz() {
        if (this.hlE != null && this.hlE.isRunning()) {
            this.hlE.cancel();
        }
        if (this.hlD == null) {
            this.hlD = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcr, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dcr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hlD.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dcr.setVisibility(0);
        this.hlD.start();
    }

    private void ne(boolean z) {
        if (z) {
            if (this.hlF != null && this.hlF.isRunning()) {
                this.hlF.cancel();
            }
            if (this.hlD != null && this.hlD.isRunning()) {
                this.hlD.cancel();
            }
            if (this.hlE == null) {
                this.hlE = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcr, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hlr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hlr != null) {
                            VideoEffectLayout.this.hlr.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hlR && VideoEffectLayout.this.dcr != null) {
                            VideoEffectLayout.this.dcr.setVisibility(8);
                        }
                    }
                });
                this.hlE.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hlE.start();
            return;
        }
        if (this.hlE != null && this.hlE.isRunning()) {
            this.hlE.cancel();
        }
        if (this.hlF == null) {
            this.hlF = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hlr, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dcr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dcr != null) {
                        VideoEffectLayout.this.dcr.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlR && VideoEffectLayout.this.hlr != null) {
                        VideoEffectLayout.this.hlr.setVisibility(8);
                    }
                }
            });
            this.hlF.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hlF.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hlt != null) {
            this.hlt.t(list);
            this.hlt.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hlw == null) {
            this.hlw = new ArrayList();
        } else {
            this.hlw.clear();
        }
        this.hlw.addAll(list);
    }

    public boolean bDu() {
        if (w.z(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bDv() {
        if (this.hls != null) {
            this.hls.bCi();
            this.hly = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCj() {
        if (this.hls != null) {
            this.hls.bCj();
        }
    }
}
