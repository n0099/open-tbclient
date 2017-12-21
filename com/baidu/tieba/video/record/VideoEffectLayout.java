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
    private String avB;
    private HListView cCu;
    private HListView gZM;
    private d gZN;
    private l gZO;
    private List<e> gZP;
    private List<e> gZQ;
    private List<e> gZR;
    private String gZS;
    private String gZT;
    private e<com.baidu.tieba.video.a> gZU;
    private e<String> gZV;
    private e<MusicData> gZW;
    private StickerItem gZX;
    private AnimatorSet gZY;
    private AnimatorSet gZZ;
    private AnimatorSet haa;
    private int hab;
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
        this.gZS = "2";
        this.gZU = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.vm(2));
        this.avB = getString(d.j.filter_nature);
        this.gZV = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gZX = stickerItem;
        this.gZT = getResources().getString(d.j.music_normal);
        this.gZW = new e<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
        inflate(getContext(), d.h.layout_effect_container, this);
        this.cCu = (HListView) findViewById(d.g.effect_list_view);
        this.cCu.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.cCu.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gZM = (HListView) findViewById(d.g.sticker_list_view);
        this.gZM.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gZN = new d();
        this.cCu.setAdapter((ListAdapter) this.gZN);
        this.gZO = new l();
        this.gZM.setAdapter((ListAdapter) this.gZO);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.vA(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void bEB() {
        if (this.gZP == null) {
            this.gZP = new ArrayList();
            a("No", com.baidu.tieba.video.a.vm(0));
            a("1", com.baidu.tieba.video.a.vm(1));
            a("2", com.baidu.tieba.video.a.vm(2));
            a("3", com.baidu.tieba.video.a.vm(3));
            a("4", com.baidu.tieba.video.a.vm(4));
            a("5", com.baidu.tieba.video.a.vm(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.gZP.add(c(0, 1, str, aVar));
    }

    private void bEC() {
        if (this.gZQ == null) {
            this.gZQ = new ArrayList();
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
        if (this.gZQ != null) {
            this.gZQ.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEg() {
        this.hab = 3;
        j(this.gZR, this.gZT);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEh() {
        this.hab = 0;
        this.gZM.setAdapter((ListAdapter) this.gZO);
        this.gZO.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nO(true);
            return;
        }
        this.gZM.setVisibility(0);
        this.cCu.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEi() {
        this.hab = 1;
        bEB();
        j(this.gZP, this.gZS);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEj() {
        this.hab = 2;
        bEC();
        j(this.gZQ, this.avB);
    }

    public void setListener(final a aVar) {
        if (this.gZN != null) {
            this.gZN.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gZS = eVar.getName();
                                VideoEffectLayout.this.gZU = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.avB = eVar.getName();
                                VideoEffectLayout.this.gZV = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gZT = eVar.getName();
                                VideoEffectLayout.this.gZW = eVar;
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
        if (this.gZO != null) {
            this.gZO.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.gZX = stickerItem;
        if (!v.w(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gZO != null) {
                this.gZO.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.w(this.mStickerItems)) {
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
            if (this.gZO != null) {
                this.gZO.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gZN.d(list, str);
                    VideoEffectLayout.this.gZN.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gZM.getVisibility() == 0) {
                runnable.run();
                nO(false);
            } else {
                bED();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.cCu.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.hab;
    }

    public e<String> getCurrentFilterItem() {
        return this.gZV;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gZU;
    }

    public StickerItem getCurrentStickItem() {
        return this.gZX;
    }

    private void bED() {
        if (this.gZZ != null && this.gZZ.isRunning()) {
            this.gZZ.cancel();
        }
        if (this.gZY == null) {
            this.gZY = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cCu, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.cCu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gZY.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.cCu.setVisibility(0);
        this.gZY.start();
    }

    private void nO(boolean z) {
        if (z) {
            if (this.haa != null && this.haa.isRunning()) {
                this.haa.cancel();
            }
            if (this.gZY != null && this.gZY.isRunning()) {
                this.gZY.cancel();
            }
            if (this.gZZ == null) {
                this.gZZ = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cCu, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gZM, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gZM != null) {
                            VideoEffectLayout.this.gZM.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.hal && VideoEffectLayout.this.cCu != null) {
                            VideoEffectLayout.this.cCu.setVisibility(8);
                        }
                    }
                });
                this.gZZ.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gZZ.start();
            return;
        }
        if (this.gZZ != null && this.gZZ.isRunning()) {
            this.gZZ.cancel();
        }
        if (this.haa == null) {
            this.haa = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gZM, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.cCu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new o() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.cCu != null) {
                        VideoEffectLayout.this.cCu.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hal && VideoEffectLayout.this.gZM != null) {
                        VideoEffectLayout.this.gZM.setVisibility(8);
                    }
                }
            });
            this.haa.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.haa.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gZO != null) {
            this.gZO.r(list);
            this.gZO.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.gZR == null) {
            this.gZR = new ArrayList();
        } else {
            this.gZR.clear();
        }
        this.gZR.addAll(list);
    }

    public boolean bEz() {
        if (v.w(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bEA() {
        if (this.gZN != null) {
            this.gZN.bDp();
            this.gZT = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bDq() {
        if (this.gZN != null) {
            this.gZN.bDq();
        }
    }
}
