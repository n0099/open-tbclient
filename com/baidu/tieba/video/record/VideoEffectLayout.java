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
    private String bjR;
    private HListView dvx;
    private String hwA;
    private e<com.baidu.tieba.video.a> hwB;
    private e<String> hwC;
    private e<MusicData> hwD;
    private StickerItem hwE;
    private AnimatorSet hwF;
    private AnimatorSet hwG;
    private AnimatorSet hwH;
    private int hwI;
    private HListView hwt;
    private d hwu;
    private l hwv;
    private List<e> hww;
    private List<e> hwx;
    private List<e> hwy;
    private String hwz;
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
        bDA();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dvx = (HListView) findViewById(d.g.effect_list_view);
        this.dvx.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dvx.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hwt = (HListView) findViewById(d.g.sticker_list_view);
        this.hwt.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hwu = new d();
        this.dvx.setAdapter((ListAdapter) this.hwu);
        this.hwv = new l();
        this.hwt.setAdapter((ListAdapter) this.hwv);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wS(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bDA() {
        this.hwz = "2";
        this.hwB = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wC(2));
        this.bjR = getString(d.j.filter_nature);
        this.hwC = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hwE = stickerItem;
        this.hwA = getResources().getString(d.j.music_normal);
        this.hwD = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bDp() {
        bDA();
        if (this.hwu != null) {
            this.hwu.bCk();
            this.hwu.bCj();
            this.hwu.bCl();
        }
        if (this.hwv != null) {
            this.hwv.bDr();
        }
    }

    private void bDB() {
        if (this.hww == null) {
            this.hww = new ArrayList();
            a("No", com.baidu.tieba.video.a.wC(0));
            a("1", com.baidu.tieba.video.a.wC(1));
            a("2", com.baidu.tieba.video.a.wC(2));
            a("3", com.baidu.tieba.video.a.wC(3));
            a("4", com.baidu.tieba.video.a.wC(4));
            a("5", com.baidu.tieba.video.a.wC(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hww.add(c(0, 1, str, aVar));
    }

    private void bDC() {
        if (this.hwx == null) {
            this.hwx = new ArrayList();
            k(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "nature");
            k(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            k(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            k(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            k(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            k(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            k(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            k(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            k(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            k(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            k(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            k(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            k(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            k(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            k(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            k(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            k(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            k(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void k(int i, String str, String str2) {
        if (this.hwx != null) {
            this.hwx.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        this.hwI = 3;
        j(this.hwy, this.hwA);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        this.hwI = 0;
        this.hwt.setAdapter((ListAdapter) this.hwv);
        this.hwv.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nl(true);
            return;
        }
        this.hwt.setVisibility(0);
        this.dvx.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        this.hwI = 1;
        bDB();
        j(this.hww, this.hwz);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        this.hwI = 2;
        bDC();
        j(this.hwx, this.bjR);
    }

    public void setListener(final a aVar) {
        if (this.hwu != null) {
            this.hwu.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hwz = eVar.getName();
                                VideoEffectLayout.this.hwB = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bjR = eVar.getName();
                                VideoEffectLayout.this.hwC = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hwA = eVar.getName();
                                VideoEffectLayout.this.hwD = eVar;
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
        if (this.hwv != null) {
            this.hwv.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hwE = stickerItem;
        if (!v.E(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hwv != null) {
                this.hwv.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.E(this.mStickerItems)) {
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
            if (this.hwv != null) {
                this.hwv.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hwu.e(list, str);
                    VideoEffectLayout.this.hwu.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hwt.getVisibility() == 0) {
                runnable.run();
                nl(false);
            } else {
                bDD();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dvx.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hwI;
    }

    public e<String> getCurrentFilterItem() {
        return this.hwC;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hwB;
    }

    public StickerItem getCurrentStickItem() {
        return this.hwE;
    }

    private void bDD() {
        if (this.hwG != null && this.hwG.isRunning()) {
            this.hwG.cancel();
        }
        if (this.hwF == null) {
            this.hwF = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dvx, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dvx, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hwF.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dvx.setVisibility(0);
        this.hwF.start();
    }

    private void nl(boolean z) {
        if (z) {
            if (this.hwH != null && this.hwH.isRunning()) {
                this.hwH.cancel();
            }
            if (this.hwF != null && this.hwF.isRunning()) {
                this.hwF.cancel();
            }
            if (this.hwG == null) {
                this.hwG = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dvx, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hwt, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hwt != null) {
                            VideoEffectLayout.this.hwt.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hwT && VideoEffectLayout.this.dvx != null) {
                            VideoEffectLayout.this.dvx.setVisibility(8);
                        }
                    }
                });
                this.hwG.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hwG.start();
            return;
        }
        if (this.hwG != null && this.hwG.isRunning()) {
            this.hwG.cancel();
        }
        if (this.hwH == null) {
            this.hwH = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hwt, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dvx, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dvx != null) {
                        VideoEffectLayout.this.dvx.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hwT && VideoEffectLayout.this.hwt != null) {
                        VideoEffectLayout.this.hwt.setVisibility(8);
                    }
                }
            });
            this.hwH.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hwH.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hwv != null) {
            this.hwv.A(list);
            this.hwv.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hwy == null) {
            this.hwy = new ArrayList();
        } else {
            this.hwy.clear();
        }
        this.hwy.addAll(list);
    }

    public boolean bDy() {
        if (v.E(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bDz() {
        if (this.hwu != null) {
            this.hwu.bCl();
            this.hwA = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCm() {
        if (this.hwu != null) {
            this.hwu.bCm();
        }
    }
}
