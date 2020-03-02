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
    private String drq;
    private HListView ghr;
    private HListView kDR;
    private d kDS;
    private k kDT;
    private List<e> kDU;
    private List<e> kDV;
    private List<e> kDW;
    private String kDX;
    private String kDY;
    private e<com.baidu.tieba.video.a> kDZ;
    private e<String> kEa;
    private e<MusicData> kEb;
    private StickerItem kEc;
    private AnimatorSet kEd;
    private AnimatorSet kEe;
    private AnimatorSet kEf;
    private int kEg;
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
        cSj();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.ghr = (HListView) findViewById(R.id.effect_list_view);
        this.ghr.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.ghr.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kDR = (HListView) findViewById(R.id.sticker_list_view);
        this.kDR.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kDS = new d();
        this.ghr.setAdapter((ListAdapter) this.kDS);
        this.kDT = new k();
        this.kDR.setAdapter((ListAdapter) this.kDT);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.DF(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cSj() {
        this.kDX = "2";
        this.kDZ = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dp(2));
        this.drq = getString(R.string.filter_nature);
        this.kEa = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kEc = stickerItem;
        this.kDY = getResources().getString(R.string.music_normal);
        this.kEb = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cSk() {
        if (this.kDU == null) {
            this.kDU = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dp(0));
            a("1", com.baidu.tieba.video.a.Dp(1));
            a("2", com.baidu.tieba.video.a.Dp(2));
            a("3", com.baidu.tieba.video.a.Dp(3));
            a("4", com.baidu.tieba.video.a.Dp(4));
            a("5", com.baidu.tieba.video.a.Dp(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kDU.add(b(0, 1, str, aVar));
    }

    private void cSl() {
        if (this.kDV == null) {
            this.kDV = new ArrayList();
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
        if (this.kDV != null) {
            this.kDV.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        this.kEg = 3;
        m(this.kDW, this.kDY);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        this.kEg = 0;
        this.kDR.setAdapter((ListAdapter) this.kDT);
        this.kDT.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tx(true);
            return;
        }
        this.kDR.setVisibility(0);
        this.ghr.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        this.kEg = 1;
        cSk();
        m(this.kDU, this.kDX);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        this.kEg = 2;
        cSl();
        m(this.kDV, this.drq);
    }

    public void setListener(final a aVar) {
        if (this.kDS != null) {
            this.kDS.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kDX = eVar.getName();
                                VideoEffectLayout.this.kDZ = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.drq = eVar.getName();
                                VideoEffectLayout.this.kEa = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kDY = eVar.getName();
                                VideoEffectLayout.this.kEb = eVar;
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
        if (this.kDT != null) {
            this.kDT.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kEc = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kDT != null) {
                this.kDT.notifyDataSetChanged();
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
            if (this.kDT != null) {
                this.kDT.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kDS.b(list, str);
                    VideoEffectLayout.this.kDS.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kDR.getVisibility() == 0) {
                runnable.run();
                tx(false);
            } else {
                cSm();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.ghr.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kEg;
    }

    public e<String> getCurrentFilterItem() {
        return this.kEa;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kDZ;
    }

    public StickerItem getCurrentStickItem() {
        return this.kEc;
    }

    private void cSm() {
        if (this.kEe != null && this.kEe.isRunning()) {
            this.kEe.cancel();
        }
        if (this.kEd == null) {
            this.kEd = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghr, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ghr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kEd.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.ghr.setVisibility(0);
        this.kEd.start();
    }

    private void tx(boolean z) {
        if (z) {
            if (this.kEf != null && this.kEf.isRunning()) {
                this.kEf.cancel();
            }
            if (this.kEd != null && this.kEd.isRunning()) {
                this.kEd.cancel();
            }
            if (this.kEe == null) {
                this.kEe = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ghr, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kDR, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kDR != null) {
                            VideoEffectLayout.this.kDR.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kEp && VideoEffectLayout.this.ghr != null) {
                            VideoEffectLayout.this.ghr.setVisibility(8);
                        }
                    }
                });
                this.kEe.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kEe.start();
            return;
        }
        if (this.kEe != null && this.kEe.isRunning()) {
            this.kEe.cancel();
        }
        if (this.kEf == null) {
            this.kEf = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kDR, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.ghr, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.ghr != null) {
                        VideoEffectLayout.this.ghr.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEp && VideoEffectLayout.this.kDR != null) {
                        VideoEffectLayout.this.kDR.setVisibility(8);
                    }
                }
            });
            this.kEf.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kEf.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kDT != null) {
            this.kDT.av(list);
            this.kDT.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kDW == null) {
            this.kDW = new ArrayList();
        } else {
            this.kDW.clear();
        }
        this.kDW.addAll(list);
    }

    public boolean cSh() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cSi() {
        if (this.kDS != null) {
            this.kDS.cQY();
            this.kDY = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cQZ() {
        if (this.kDS != null) {
            this.kDS.cQZ();
        }
    }
}
