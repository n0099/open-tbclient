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
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String aKr;
    private HListView dik;
    private HListView hth;
    private d hti;
    private k htj;
    private List<e> htk;
    private List<e> htl;
    private List<e> htm;
    private String htn;
    private String hto;
    private e<com.baidu.tieba.video.a> htp;
    private e<String> htq;
    private e<MusicData> htr;
    private StickerItem hts;
    private AnimatorSet htt;
    private AnimatorSet htu;
    private AnimatorSet htv;
    private int htw;
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
        bGn();
        inflate(getContext(), e.h.layout_effect_container, this);
        this.dik = (HListView) findViewById(e.g.effect_list_view);
        this.dik.setDividerWidth(getContext().getResources().getDimensionPixelSize(e.C0141e.ds28));
        this.dik.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hth = (HListView) findViewById(e.g.sticker_list_view);
        this.hth.setSelector(getResources().getDrawable(e.f.transparent_bg));
        this.hti = new d();
        this.dik.setAdapter((ListAdapter) this.hti);
        this.htj = new k();
        this.hth.setAdapter((ListAdapter) this.htj);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.vn(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bGn() {
        this.htn = "2";
        this.htp = c(e.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uX(2));
        this.aKr = getString(e.j.filter_nature);
        this.htq = c(e.f.filter_icon_avatar_default, 2, getString(e.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hts = stickerItem;
        this.hto = getResources().getString(e.j.music_normal);
        this.htr = new e<>(3, getResources().getString(e.j.music_normal), new MusicData("-100", 1, getResources().getString(e.j.music_normal)), e.f.icon_video_mute);
    }

    private void bGo() {
        if (this.htk == null) {
            this.htk = new ArrayList();
            a("No", com.baidu.tieba.video.a.uX(0));
            a("1", com.baidu.tieba.video.a.uX(1));
            a("2", com.baidu.tieba.video.a.uX(2));
            a("3", com.baidu.tieba.video.a.uX(3));
            a("4", com.baidu.tieba.video.a.uX(4));
            a("5", com.baidu.tieba.video.a.uX(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.htk.add(c(0, 1, str, aVar));
    }

    private void bGp() {
        if (this.htl == null) {
            this.htl = new ArrayList();
            j(e.f.filter_icon_avatar_default, getString(e.j.filter_nature), "nature");
            j(e.f.filter_icon_avatar_hongkong, getString(e.j.filter_hongkong), "hongkong");
            j(e.f.filter_icon_avatar_refreshing, getString(e.j.filter_refreshing), "refreshing");
            j(e.f.filter_icon_avatar_girly, getString(e.j.filter_girly), "girly");
            j(e.f.filter_icon_avatar_concrete, getString(e.j.filter_concrete), "concrete");
            j(e.f.filter_icon_avatar_warm, getString(e.j.filter_warm), "warm");
            j(e.f.filter_icon_avatar_cold, getString(e.j.filter_cold), "cold");
            j(e.f.filter_icon_avatar_japanese, getString(e.j.filter_japanese), "Japanese");
            j(e.f.filter_icon_avatar_cruz, getString(e.j.filter_hdr), "cruz");
            j(e.f.filter_icon_avatar_abao, getString(e.j.filter_abao), "abao");
            j(e.f.filter_icon_avatar_dew, getString(e.j.filter_dew), "dew");
            j(e.f.filter_icon_avatar_slowlived, getString(e.j.filter_slowlived), "slowlived");
            j(e.f.filter_icon_avatar_sweet, getString(e.j.filter_sweet), "sweet");
            j(e.f.filter_icon_avatar_boardwalk, getString(e.j.filter_boardwalk), "boardwalk");
            j(e.f.filter_icon_avatar_keylime, getString(e.j.filter_keylime), "keylime");
            j(e.f.filter_icon_avatar_electric, getString(e.j.filter_electric), "electric");
            j(e.f.filter_icon_avatar_silver, getString(e.j.filter_silver), "silver");
            j(e.f.filter_icon_avatar_blackwhite, getString(e.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void j(int i, String str, String str2) {
        if (this.htl != null) {
            this.htl.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFQ() {
        this.htw = 3;
        k(this.htm, this.hto);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFR() {
        this.htw = 0;
        this.hth.setAdapter((ListAdapter) this.htj);
        this.htj.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nB(true);
            return;
        }
        this.hth.setVisibility(0);
        this.dik.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFS() {
        this.htw = 1;
        bGo();
        k(this.htk, this.htn);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFT() {
        this.htw = 2;
        bGp();
        k(this.htl, this.aKr);
    }

    public void setListener(final a aVar) {
        if (this.hti != null) {
            this.hti.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.htn = eVar.getName();
                                VideoEffectLayout.this.htp = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.aKr = eVar.getName();
                                VideoEffectLayout.this.htq = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hto = eVar.getName();
                                VideoEffectLayout.this.htr = eVar;
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
        if (this.htj != null) {
            this.htj.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hts = stickerItem;
        if (!v.z(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.htj != null) {
                this.htj.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.z(this.mStickerItems)) {
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
            if (this.htj != null) {
                this.htj.notifyDataSetChanged();
            }
        }
    }

    private void k(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hti.f(list, str);
                    VideoEffectLayout.this.hti.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hth.getVisibility() == 0) {
                runnable.run();
                nB(false);
            } else {
                bGq();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dik.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.htw;
    }

    public e<String> getCurrentFilterItem() {
        return this.htq;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.htp;
    }

    public StickerItem getCurrentStickItem() {
        return this.hts;
    }

    private void bGq() {
        if (this.htu != null && this.htu.isRunning()) {
            this.htu.cancel();
        }
        if (this.htt == null) {
            this.htt = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dik, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dik, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.htt.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dik.setVisibility(0);
        this.htt.start();
    }

    private void nB(boolean z) {
        if (z) {
            if (this.htv != null && this.htv.isRunning()) {
                this.htv.cancel();
            }
            if (this.htt != null && this.htt.isRunning()) {
                this.htt.cancel();
            }
            if (this.htu == null) {
                this.htu = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dik, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hth, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hth != null) {
                            VideoEffectLayout.this.hth.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.htH && VideoEffectLayout.this.dik != null) {
                            VideoEffectLayout.this.dik.setVisibility(8);
                        }
                    }
                });
                this.htu.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.htu.start();
            return;
        }
        if (this.htu != null && this.htu.isRunning()) {
            this.htu.cancel();
        }
        if (this.htv == null) {
            this.htv = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hth, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dik, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dik != null) {
                        VideoEffectLayout.this.dik.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.htH && VideoEffectLayout.this.hth != null) {
                        VideoEffectLayout.this.hth.setVisibility(8);
                    }
                }
            });
            this.htv.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.htv.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.htj != null) {
            this.htj.t(list);
            this.htj.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.htm == null) {
            this.htm = new ArrayList();
        } else {
            this.htm.clear();
        }
        this.htm.addAll(list);
    }

    public boolean bGl() {
        if (v.z(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bGm() {
        if (this.hti != null) {
            this.hti.bEZ();
            this.hto = TbadkCoreApplication.getInst().getString(e.j.music_normal);
        }
    }

    public void bFa() {
        if (this.hti != null) {
            this.hti.bFa();
        }
    }
}
