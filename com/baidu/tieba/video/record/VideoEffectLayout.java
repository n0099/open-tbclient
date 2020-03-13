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
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String drE;
    private HListView ghE;
    private HListView kEd;
    private d kEe;
    private k kEf;
    private List<e> kEg;
    private List<e> kEh;
    private List<e> kEi;
    private String kEj;
    private String kEk;
    private e<com.baidu.tieba.video.a> kEl;
    private e<String> kEm;
    private e<MusicData> kEn;
    private StickerItem kEo;
    private AnimatorSet kEp;
    private AnimatorSet kEq;
    private AnimatorSet kEr;
    private int kEs;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes10.dex */
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
        cSk();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.ghE = (HListView) findViewById(R.id.effect_list_view);
        this.ghE.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.ghE.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kEd = (HListView) findViewById(R.id.sticker_list_view);
        this.kEd.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kEe = new d();
        this.ghE.setAdapter((ListAdapter) this.kEe);
        this.kEf = new k();
        this.kEd.setAdapter((ListAdapter) this.kEf);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.DF(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cSk() {
        this.kEj = "2";
        this.kEl = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dp(2));
        this.drE = getString(R.string.filter_nature);
        this.kEm = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kEo = stickerItem;
        this.kEk = getResources().getString(R.string.music_normal);
        this.kEn = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cSl() {
        if (this.kEg == null) {
            this.kEg = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dp(0));
            a("1", com.baidu.tieba.video.a.Dp(1));
            a("2", com.baidu.tieba.video.a.Dp(2));
            a("3", com.baidu.tieba.video.a.Dp(3));
            a("4", com.baidu.tieba.video.a.Dp(4));
            a("5", com.baidu.tieba.video.a.Dp(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kEg.add(b(0, 1, str, aVar));
    }

    private void cSm() {
        if (this.kEh == null) {
            this.kEh = new ArrayList();
            o(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            o(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            o(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            o(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            o(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            o(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            o(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            o(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            o(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            o(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            o(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            o(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            o(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            o(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            o(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            o(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            o(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            o(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void o(int i, String str, String str2) {
        if (this.kEh != null) {
            this.kEh.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        this.kEs = 3;
        m(this.kEi, this.kEk);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        this.kEs = 0;
        this.kEd.setAdapter((ListAdapter) this.kEf);
        this.kEf.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tx(true);
            return;
        }
        this.kEd.setVisibility(0);
        this.ghE.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        this.kEs = 1;
        cSl();
        m(this.kEg, this.kEj);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRQ() {
        this.kEs = 2;
        cSm();
        m(this.kEh, this.drE);
    }

    public void setListener(final a aVar) {
        if (this.kEe != null) {
            this.kEe.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kEj = eVar.getName();
                                VideoEffectLayout.this.kEl = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.drE = eVar.getName();
                                VideoEffectLayout.this.kEm = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kEk = eVar.getName();
                                VideoEffectLayout.this.kEn = eVar;
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
        if (this.kEf != null) {
            this.kEf.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kEo = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kEf != null) {
                this.kEf.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.isEmpty(this.mStickerItems)) {
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
            if (this.kEf != null) {
                this.kEf.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kEe.b(list, str);
                    VideoEffectLayout.this.kEe.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kEd.getVisibility() == 0) {
                runnable.run();
                tx(false);
            } else {
                cSn();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.ghE.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kEs;
    }

    public e<String> getCurrentFilterItem() {
        return this.kEm;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kEl;
    }

    public StickerItem getCurrentStickItem() {
        return this.kEo;
    }

    private void cSn() {
        if (this.kEq != null && this.kEq.isRunning()) {
            this.kEq.cancel();
        }
        if (this.kEp == null) {
            this.kEp = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghE, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ghE, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kEp.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.ghE.setVisibility(0);
        this.kEp.start();
    }

    private void tx(boolean z) {
        if (z) {
            if (this.kEr != null && this.kEr.isRunning()) {
                this.kEr.cancel();
            }
            if (this.kEp != null && this.kEp.isRunning()) {
                this.kEp.cancel();
            }
            if (this.kEq == null) {
                this.kEq = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghE, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kEd, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kEd != null) {
                            VideoEffectLayout.this.kEd.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kEB && VideoEffectLayout.this.ghE != null) {
                            VideoEffectLayout.this.ghE.setVisibility(8);
                        }
                    }
                });
                this.kEq.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kEq.start();
            return;
        }
        if (this.kEq != null && this.kEq.isRunning()) {
            this.kEq.cancel();
        }
        if (this.kEr == null) {
            this.kEr = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kEd, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.ghE, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.ghE != null) {
                        VideoEffectLayout.this.ghE.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEB && VideoEffectLayout.this.kEd != null) {
                        VideoEffectLayout.this.kEd.setVisibility(8);
                    }
                }
            });
            this.kEr.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kEr.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kEf != null) {
            this.kEf.av(list);
            this.kEf.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kEi == null) {
            this.kEi = new ArrayList();
        } else {
            this.kEi.clear();
        }
        this.kEi.addAll(list);
    }

    public boolean cSi() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cSj() {
        if (this.kEe != null) {
            this.kEe.cQZ();
            this.kEk = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cRa() {
        if (this.kEe != null) {
            this.kEe.cRa();
        }
    }
}
