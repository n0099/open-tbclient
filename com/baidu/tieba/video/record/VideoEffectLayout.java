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
    private String aPJ;
    private HListView drs;
    private HListView hCf;
    private d hCg;
    private k hCh;
    private List<e> hCi;
    private List<e> hCj;
    private List<e> hCk;
    private String hCl;
    private String hCm;
    private e<com.baidu.tieba.video.a> hCn;
    private e<String> hCo;
    private e<MusicData> hCp;
    private StickerItem hCq;
    private AnimatorSet hCr;
    private AnimatorSet hCs;
    private AnimatorSet hCt;
    private int hCu;
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
        bIZ();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.drs = (HListView) findViewById(e.g.effect_list_view);
        this.drs.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0200e.ds28));
        this.drs.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hCf = (HListView) findViewById(e.g.sticker_list_view);
        this.hCf.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hCg = new d();
        this.drs.setAdapter((ListAdapter) this.hCg);
        this.hCh = new k();
        this.hCf.setAdapter((ListAdapter) this.hCh);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wd(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bIZ() {
        this.hCl = "2";
        this.hCn = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.vN(2));
        this.aPJ = getString(e.j.filter_nature);
        this.hCo = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hCq = stickerItem;
        this.hCm = getResources().getString(e.j.music_normal);
        this.hCp = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bJa() {
        if (this.hCi == null) {
            this.hCi = new ArrayList();
            a("No", com.baidu.tieba.video.a.vN(0));
            a("1", com.baidu.tieba.video.a.vN(1));
            a("2", com.baidu.tieba.video.a.vN(2));
            a("3", com.baidu.tieba.video.a.vN(3));
            a("4", com.baidu.tieba.video.a.vN(4));
            a("5", com.baidu.tieba.video.a.vN(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hCi.add(c(0, 1, str, aVar));
    }

    private void bJb() {
        if (this.hCj == null) {
            this.hCj = new ArrayList();
            l(e.f.filter_icon_avatar_default, getString(e.j.filter_nature), "origin");
            l(e.f.filter_icon_avatar_hongkong, getString(e.j.filter_hongkong), "hongkong");
            l(e.f.filter_icon_avatar_refreshing, getString(e.j.filter_refreshing), "refreshing");
            l(e.f.filter_icon_avatar_girly, getString(e.j.filter_girly), "girly");
            l(e.f.filter_icon_avatar_concrete, getString(e.j.filter_concrete), "concrete");
            l(e.f.filter_icon_avatar_warm, getString(e.j.filter_warm), "warm");
            l(e.f.filter_icon_avatar_cold, getString(e.j.filter_cold), "cold");
            l(e.f.filter_icon_avatar_japanese, getString(e.j.filter_japanese), "Japanese");
            l(e.f.filter_icon_avatar_cruz, getString(e.j.filter_hdr), "cruz");
            l(e.f.filter_icon_avatar_abao, getString(e.j.filter_abao), "abao");
            l(e.f.filter_icon_avatar_dew, getString(e.j.filter_dew), "dew");
            l(e.f.filter_icon_avatar_slowlived, getString(e.j.filter_slowlived), "slowlived");
            l(e.f.filter_icon_avatar_sweet, getString(e.j.filter_sweet), "sweet");
            l(e.f.filter_icon_avatar_boardwalk, getString(e.j.filter_boardwalk), "boardwalk");
            l(e.f.filter_icon_avatar_keylime, getString(e.j.filter_keylime), "keylime");
            l(e.f.filter_icon_avatar_electric, getString(e.j.filter_electric), "electric");
            l(e.f.filter_icon_avatar_silver, getString(e.j.filter_silver), "silver");
            l(e.f.filter_icon_avatar_blackwhite, getString(e.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void l(int i, String str, String str2) {
        if (this.hCj != null) {
            this.hCj.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIC() {
        this.hCu = 3;
        j(this.hCk, this.hCm);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bID() {
        this.hCu = 0;
        this.hCf.setAdapter((ListAdapter) this.hCh);
        this.hCh.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            of(true);
            return;
        }
        this.hCf.setVisibility(0);
        this.drs.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIE() {
        this.hCu = 1;
        bJa();
        j(this.hCi, this.hCl);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIF() {
        this.hCu = 2;
        bJb();
        j(this.hCj, this.aPJ);
    }

    public void setListener(final a aVar) {
        if (this.hCg != null) {
            this.hCg.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hCl = eVar.getName();
                                VideoEffectLayout.this.hCn = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aPJ = eVar.getName();
                                VideoEffectLayout.this.hCo = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hCm = eVar.getName();
                                VideoEffectLayout.this.hCp = eVar;
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
        if (this.hCh != null) {
            this.hCh.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hCq = stickerItem;
        if (!v.I(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hCh != null) {
                this.hCh.notifyDataSetChanged();
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
            if (this.hCh != null) {
                this.hCh.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hCg.setData(list, str);
                    VideoEffectLayout.this.hCg.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hCf.getVisibility() == 0) {
                runnable.run();
                of(false);
            } else {
                bJc();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.drs.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hCu;
    }

    public e<String> getCurrentFilterItem() {
        return this.hCo;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hCn;
    }

    public StickerItem getCurrentStickItem() {
        return this.hCq;
    }

    private void bJc() {
        if (this.hCs != null && this.hCs.isRunning()) {
            this.hCs.cancel();
        }
        if (this.hCr == null) {
            this.hCr = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.drs, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.drs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hCr.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.drs.setVisibility(0);
        this.hCr.start();
    }

    private void of(boolean z) {
        if (z) {
            if (this.hCt != null && this.hCt.isRunning()) {
                this.hCt.cancel();
            }
            if (this.hCr != null && this.hCr.isRunning()) {
                this.hCr.cancel();
            }
            if (this.hCs == null) {
                this.hCs = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.drs, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hCf, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hCf != null) {
                            VideoEffectLayout.this.hCf.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hCE && VideoEffectLayout.this.drs != null) {
                            VideoEffectLayout.this.drs.setVisibility(8);
                        }
                    }
                });
                this.hCs.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hCs.start();
            return;
        }
        if (this.hCs != null && this.hCs.isRunning()) {
            this.hCs.cancel();
        }
        if (this.hCt == null) {
            this.hCt = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hCf, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.drs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.drs != null) {
                        VideoEffectLayout.this.drs.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hCE && VideoEffectLayout.this.hCf != null) {
                        VideoEffectLayout.this.hCf.setVisibility(8);
                    }
                }
            });
            this.hCt.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hCt.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hCh != null) {
            this.hCh.C(list);
            this.hCh.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hCk == null) {
            this.hCk = new ArrayList();
        } else {
            this.hCk.clear();
        }
        this.hCk.addAll(list);
    }

    public boolean bIX() {
        if (v.I(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bIY() {
        if (this.hCg != null) {
            this.hCg.bHL();
            this.hCm = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bHM() {
        if (this.hCg != null) {
            this.hCg.bHM();
        }
    }
}
