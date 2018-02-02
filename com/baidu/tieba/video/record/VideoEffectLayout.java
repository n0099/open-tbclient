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
    private String bjZ;
    private HListView dvS;
    private HListView hwN;
    private d hwO;
    private l hwP;
    private List<e> hwQ;
    private List<e> hwR;
    private List<e> hwS;
    private String hwT;
    private String hwU;
    private e<com.baidu.tieba.video.a> hwV;
    private e<String> hwW;
    private e<MusicData> hwX;
    private StickerItem hwY;
    private AnimatorSet hwZ;
    private AnimatorSet hxa;
    private AnimatorSet hxb;
    private int hxc;
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
        bDC();
        inflate(getContext(), d.h.layout_effect_container, this);
        this.dvS = (HListView) findViewById(d.g.effect_list_view);
        this.dvS.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.dvS.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hwN = (HListView) findViewById(d.g.sticker_list_view);
        this.hwN.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.hwO = new d();
        this.dvS.setAdapter((ListAdapter) this.hwO);
        this.hwP = new l();
        this.hwN.setAdapter((ListAdapter) this.hwP);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.wS(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bDC() {
        this.hwT = "2";
        this.hwV = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.wC(2));
        this.bjZ = getString(d.j.filter_nature);
        this.hwW = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.hwY = stickerItem;
        this.hwU = getResources().getString(d.j.music_normal);
        this.hwX = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
    }

    public void bDr() {
        bDC();
        if (this.hwO != null) {
            this.hwO.bCm();
            this.hwO.bCl();
            this.hwO.bCn();
        }
        if (this.hwP != null) {
            this.hwP.bDt();
        }
    }

    private void bDD() {
        if (this.hwQ == null) {
            this.hwQ = new ArrayList();
            a("No", com.baidu.tieba.video.a.wC(0));
            a("1", com.baidu.tieba.video.a.wC(1));
            a("2", com.baidu.tieba.video.a.wC(2));
            a("3", com.baidu.tieba.video.a.wC(3));
            a("4", com.baidu.tieba.video.a.wC(4));
            a("5", com.baidu.tieba.video.a.wC(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.hwQ.add(c(0, 1, str, aVar));
    }

    private void bDE() {
        if (this.hwR == null) {
            this.hwR = new ArrayList();
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
        if (this.hwR != null) {
            this.hwR.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        this.hxc = 3;
        j(this.hwS, this.hwU);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        this.hxc = 0;
        this.hwN.setAdapter((ListAdapter) this.hwP);
        this.hwP.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            no(true);
            return;
        }
        this.hwN.setVisibility(0);
        this.dvS.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDh() {
        this.hxc = 1;
        bDD();
        j(this.hwQ, this.hwT);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDi() {
        this.hxc = 2;
        bDE();
        j(this.hwR, this.bjZ);
    }

    public void setListener(final a aVar) {
        if (this.hwO != null) {
            this.hwO.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.hwT = eVar.getName();
                                VideoEffectLayout.this.hwV = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.bjZ = eVar.getName();
                                VideoEffectLayout.this.hwW = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.hwU = eVar.getName();
                                VideoEffectLayout.this.hwX = eVar;
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
        if (this.hwP != null) {
            this.hwP.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.hwY = stickerItem;
        if (!v.E(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.hwP != null) {
                this.hwP.notifyDataSetChanged();
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
            if (this.hwP != null) {
                this.hwP.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.hwO.e(list, str);
                    VideoEffectLayout.this.hwO.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.hwN.getVisibility() == 0) {
                runnable.run();
                no(false);
            } else {
                bDF();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.dvS.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hxc;
    }

    public e<String> getCurrentFilterItem() {
        return this.hwW;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.hwV;
    }

    public StickerItem getCurrentStickItem() {
        return this.hwY;
    }

    private void bDF() {
        if (this.hxa != null && this.hxa.isRunning()) {
            this.hxa.cancel();
        }
        if (this.hwZ == null) {
            this.hwZ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dvS, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.dvS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.hwZ.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.dvS.setVisibility(0);
        this.hwZ.start();
    }

    private void no(boolean z) {
        if (z) {
            if (this.hxb != null && this.hxb.isRunning()) {
                this.hxb.cancel();
            }
            if (this.hwZ != null && this.hwZ.isRunning()) {
                this.hwZ.cancel();
            }
            if (this.hxa == null) {
                this.hxa = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.dvS, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hwN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.hwN != null) {
                            VideoEffectLayout.this.hwN.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hxn && VideoEffectLayout.this.dvS != null) {
                            VideoEffectLayout.this.dvS.setVisibility(8);
                        }
                    }
                });
                this.hxa.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.hxa.start();
            return;
        }
        if (this.hxa != null && this.hxa.isRunning()) {
            this.hxa.cancel();
        }
        if (this.hxb == null) {
            this.hxb = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hwN, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.dvS, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.dvS != null) {
                        VideoEffectLayout.this.dvS.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hxn && VideoEffectLayout.this.hwN != null) {
                        VideoEffectLayout.this.hwN.setVisibility(8);
                    }
                }
            });
            this.hxb.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.hxb.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.hwP != null) {
            this.hwP.A(list);
            this.hwP.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.hwS == null) {
            this.hwS = new ArrayList();
        } else {
            this.hwS.clear();
        }
        this.hwS.addAll(list);
    }

    public boolean bDA() {
        if (v.E(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bDB() {
        if (this.hwO != null) {
            this.hwO.bCn();
            this.hwU = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bCo() {
        if (this.hwO != null) {
            this.hwO.bCo();
        }
    }
}
