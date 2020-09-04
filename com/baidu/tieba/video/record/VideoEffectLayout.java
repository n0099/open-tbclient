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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String eFO;
    private HListView hLN;
    private String mDA;
    private String mDB;
    private e<com.baidu.tieba.video.a> mDC;
    private e<String> mDD;
    private e<MusicData> mDE;
    private StickerItem mDF;
    private AnimatorSet mDG;
    private AnimatorSet mDH;
    private AnimatorSet mDI;
    private int mDJ;
    private HListView mDs;
    private d mDt;
    private k mDu;
    private List<e> mDv;
    private List<e> mDw;
    private List<e> mDz;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes17.dex */
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
        dEk();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hLN = (HListView) findViewById(R.id.effect_list_view);
        this.hLN.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hLN.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mDs = (HListView) findViewById(R.id.sticker_list_view);
        this.mDs.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mDt = new d();
        this.hLN.setAdapter((ListAdapter) this.mDt);
        this.mDu = new k();
        this.mDs.setAdapter((ListAdapter) this.mDu);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.IZ(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dEk() {
        this.mDA = "2";
        this.mDC = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.II(2));
        this.eFO = getString(R.string.filter_nature);
        this.mDD = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mDF = stickerItem;
        this.mDB = getResources().getString(R.string.music_normal);
        this.mDE = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dEl() {
        if (this.mDv == null) {
            this.mDv = new ArrayList();
            a("No", com.baidu.tieba.video.a.II(0));
            a("1", com.baidu.tieba.video.a.II(1));
            a("2", com.baidu.tieba.video.a.II(2));
            a("3", com.baidu.tieba.video.a.II(3));
            a("4", com.baidu.tieba.video.a.II(4));
            a("5", com.baidu.tieba.video.a.II(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mDv.add(b(0, 1, str, aVar));
    }

    private void dEm() {
        if (this.mDw == null) {
            this.mDw = new ArrayList();
            q(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            q(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            q(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            q(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            q(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            q(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            q(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            q(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            q(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            q(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            q(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            q(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            q(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            q(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            q(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            q(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            q(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            q(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void q(int i, String str, String str2) {
        if (this.mDw != null) {
            this.mDw.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDN() {
        this.mDJ = 3;
        n(this.mDz, this.mDB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDO() {
        this.mDJ = 0;
        this.mDs.setAdapter((ListAdapter) this.mDu);
        this.mDu.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            wQ(true);
            return;
        }
        this.mDs.setVisibility(0);
        this.hLN.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDP() {
        this.mDJ = 1;
        dEl();
        n(this.mDv, this.mDA);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDQ() {
        this.mDJ = 2;
        dEm();
        n(this.mDw, this.eFO);
    }

    public void setListener(final a aVar) {
        if (this.mDt != null) {
            this.mDt.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.mDA = eVar.getName();
                                VideoEffectLayout.this.mDC = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eFO = eVar.getName();
                                VideoEffectLayout.this.mDD = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.mDB = eVar.getName();
                                VideoEffectLayout.this.mDE = eVar;
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
        if (this.mDu != null) {
            this.mDu.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mDF = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mDu != null) {
                this.mDu.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!y.isEmpty(this.mStickerItems)) {
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
            if (this.mDu != null) {
                this.mDu.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mDt.b(list, str);
                    VideoEffectLayout.this.mDt.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mDs.getVisibility() == 0) {
                runnable.run();
                wQ(false);
            } else {
                dEn();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hLN.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.mDJ;
    }

    public e<String> getCurrentFilterItem() {
        return this.mDD;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mDC;
    }

    public StickerItem getCurrentStickItem() {
        return this.mDF;
    }

    private void dEn() {
        if (this.mDH != null && this.mDH.isRunning()) {
            this.mDH.cancel();
        }
        if (this.mDG == null) {
            this.mDG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLN, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hLN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.mDG.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hLN.setVisibility(0);
        this.mDG.start();
    }

    private void wQ(boolean z) {
        if (z) {
            if (this.mDI != null && this.mDI.isRunning()) {
                this.mDI.cancel();
            }
            if (this.mDG != null && this.mDG.isRunning()) {
                this.mDG.cancel();
            }
            if (this.mDH == null) {
                this.mDH = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLN, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mDs, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mDs != null) {
                            VideoEffectLayout.this.mDs.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mDS && VideoEffectLayout.this.hLN != null) {
                            VideoEffectLayout.this.hLN.setVisibility(8);
                        }
                    }
                });
                this.mDH.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.mDH.start();
            return;
        }
        if (this.mDH != null && this.mDH.isRunning()) {
            this.mDH.cancel();
        }
        if (this.mDI == null) {
            this.mDI = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mDs, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hLN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hLN != null) {
                        VideoEffectLayout.this.hLN.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDS && VideoEffectLayout.this.mDs != null) {
                        VideoEffectLayout.this.mDs.setVisibility(8);
                    }
                }
            });
            this.mDI.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mDI.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mDu != null) {
            this.mDu.aK(list);
            this.mDu.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mDz == null) {
            this.mDz = new ArrayList();
        } else {
            this.mDz.clear();
        }
        this.mDz.addAll(list);
    }

    public boolean dEi() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dEj() {
        if (this.mDt != null) {
            this.mDt.dCW();
            this.mDB = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dCX() {
        if (this.mDt != null) {
            this.mDt.dCX();
        }
    }
}
