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
import com.baidu.tieba.f;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String aHd;
    private HListView dcp;
    private e<com.baidu.tieba.video.a> hlA;
    private e<String> hlB;
    private e<MusicData> hlC;
    private StickerItem hlD;
    private AnimatorSet hlE;
    private AnimatorSet hlF;
    private AnimatorSet hlG;
    private int hlH;
    private HListView hls;
    private d hlt;
    private k hlu;
    private List<e> hlv;
    private List<e> hlw;
    private List<e> hlx;
    private String hly;
    private String hlz;
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
        bDy();
        inflate(getContext(), f.h.layout_effect_container, this);
        this.dcp = (HListView) findViewById(f.g.effect_list_view);
        this.dcp.setDividerWidth(getContext().getResources().getDimensionPixelSize(f.e.ds28));
        this.dcp.setSelector(getResources().getDrawable(f.C0146f.transparent_bg));
        this.hls = (HListView) findViewById(f.g.sticker_list_view);
        this.hls.setSelector(getResources().getDrawable(f.C0146f.transparent_bg));
        this.hlt = new d();
        this.dcp.setAdapter((ListAdapter) this.hlt);
        this.hlu = new k();
        this.hls.setAdapter((ListAdapter) this.hlu);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.uN(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bDy() {
        this.hly = "2";
        this.hlA = c(f.C0146f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.ux(2));
        this.aHd = getString(f.j.filter_nature);
        this.hlB = c(f.C0146f.filter_icon_avatar_default, 2, getString(f.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hlD = stickerItem;
        this.hlz = getResources().getString(f.j.music_normal);
        this.hlC = new e<>(3, getResources().getString(f.j.music_normal), new MusicData("-100", 1, getResources().getString(f.j.music_normal)), f.C0146f.icon_video_mute);
    }

    private void bDz() {
        if (this.hlv == null) {
            this.hlv = new ArrayList();
            a("No", com.baidu.tieba.video.a.ux(0));
            a("1", com.baidu.tieba.video.a.ux(1));
            a("2", com.baidu.tieba.video.a.ux(2));
            a("3", com.baidu.tieba.video.a.ux(3));
            a("4", com.baidu.tieba.video.a.ux(4));
            a("5", com.baidu.tieba.video.a.ux(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hlv.add(c(0, 1, str, aVar));
    }

    private void bDA() {
        if (this.hlw == null) {
            this.hlw = new ArrayList();
            j(f.C0146f.filter_icon_avatar_default, getString(f.j.filter_nature), "nature");
            j(f.C0146f.filter_icon_avatar_hongkong, getString(f.j.filter_hongkong), "hongkong");
            j(f.C0146f.filter_icon_avatar_refreshing, getString(f.j.filter_refreshing), "refreshing");
            j(f.C0146f.filter_icon_avatar_girly, getString(f.j.filter_girly), "girly");
            j(f.C0146f.filter_icon_avatar_concrete, getString(f.j.filter_concrete), "concrete");
            j(f.C0146f.filter_icon_avatar_warm, getString(f.j.filter_warm), "warm");
            j(f.C0146f.filter_icon_avatar_cold, getString(f.j.filter_cold), "cold");
            j(f.C0146f.filter_icon_avatar_japanese, getString(f.j.filter_japanese), "Japanese");
            j(f.C0146f.filter_icon_avatar_cruz, getString(f.j.filter_hdr), "cruz");
            j(f.C0146f.filter_icon_avatar_abao, getString(f.j.filter_abao), "abao");
            j(f.C0146f.filter_icon_avatar_dew, getString(f.j.filter_dew), "dew");
            j(f.C0146f.filter_icon_avatar_slowlived, getString(f.j.filter_slowlived), "slowlived");
            j(f.C0146f.filter_icon_avatar_sweet, getString(f.j.filter_sweet), "sweet");
            j(f.C0146f.filter_icon_avatar_boardwalk, getString(f.j.filter_boardwalk), "boardwalk");
            j(f.C0146f.filter_icon_avatar_keylime, getString(f.j.filter_keylime), "keylime");
            j(f.C0146f.filter_icon_avatar_electric, getString(f.j.filter_electric), "electric");
            j(f.C0146f.filter_icon_avatar_silver, getString(f.j.filter_silver), "silver");
            j(f.C0146f.filter_icon_avatar_blackwhite, getString(f.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void j(int i, String str, String str2) {
        if (this.hlw != null) {
            this.hlw.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        this.hlH = 3;
        k(this.hlx, this.hlz);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        this.hlH = 0;
        this.hls.setAdapter((ListAdapter) this.hlu);
        this.hlu.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            ne(true);
            return;
        }
        this.hls.setVisibility(0);
        this.dcp.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        this.hlH = 1;
        bDz();
        k(this.hlv, this.hly);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        this.hlH = 2;
        bDA();
        k(this.hlw, this.aHd);
    }

    public void setListener(final a aVar) {
        if (this.hlt != null) {
            this.hlt.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hly = eVar.getName();
                                VideoEffectLayout.this.hlA = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aHd = eVar.getName();
                                VideoEffectLayout.this.hlB = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hlz = eVar.getName();
                                VideoEffectLayout.this.hlC = eVar;
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
        if (this.hlu != null) {
            this.hlu.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hlD = stickerItem;
        if (!w.z(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hlu != null) {
                this.hlu.notifyDataSetChanged();
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
            if (this.hlu != null) {
                this.hlu.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hlt.f(list, str);
                    VideoEffectLayout.this.hlt.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hls.getVisibility() == 0) {
                runnable.run();
                ne(false);
            } else {
                bDB();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dcp.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hlH;
    }

    public e<String> getCurrentFilterItem() {
        return this.hlB;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hlA;
    }

    public StickerItem getCurrentStickItem() {
        return this.hlD;
    }

    private void bDB() {
        if (this.hlF != null && this.hlF.isRunning()) {
            this.hlF.cancel();
        }
        if (this.hlE == null) {
            this.hlE = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcp, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dcp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hlE.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dcp.setVisibility(0);
        this.hlE.start();
    }

    private void ne(boolean z) {
        if (z) {
            if (this.hlG != null && this.hlG.isRunning()) {
                this.hlG.cancel();
            }
            if (this.hlE != null && this.hlE.isRunning()) {
                this.hlE.cancel();
            }
            if (this.hlF == null) {
                this.hlF = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dcp, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hls, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hls != null) {
                            VideoEffectLayout.this.hls.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hlS && VideoEffectLayout.this.dcp != null) {
                            VideoEffectLayout.this.dcp.setVisibility(8);
                        }
                    }
                });
                this.hlF.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hlF.start();
            return;
        }
        if (this.hlF != null && this.hlF.isRunning()) {
            this.hlF.cancel();
        }
        if (this.hlG == null) {
            this.hlG = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hls, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dcp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dcp != null) {
                        VideoEffectLayout.this.dcp.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlS && VideoEffectLayout.this.hls != null) {
                        VideoEffectLayout.this.hls.setVisibility(8);
                    }
                }
            });
            this.hlG.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hlG.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hlu != null) {
            this.hlu.t(list);
            this.hlu.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hlx == null) {
            this.hlx = new ArrayList();
        } else {
            this.hlx.clear();
        }
        this.hlx.addAll(list);
    }

    public boolean bDw() {
        if (w.z(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bDx() {
        if (this.hlt != null) {
            this.hlt.bCk();
            this.hlz = TbadkCoreApplication.getInst().getString(f.j.music_normal);
        }
    }

    public void bCl() {
        if (this.hlt != null) {
            this.hlt.bCl();
        }
    }
}
