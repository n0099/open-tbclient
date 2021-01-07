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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String fyF;
    private HListView iYc;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView nNM;
    private d nNN;
    private k nNO;
    private List<e> nNP;
    private List<e> nNQ;
    private List<e> nNR;
    private String nNS;
    private String nNT;
    private e<com.baidu.tieba.video.a> nNU;
    private e<String> nNV;
    private e<MusicData> nNW;
    private StickerItem nNX;
    private AnimatorSet nNY;
    private AnimatorSet nNZ;
    private AnimatorSet nOa;
    private int nOb;

    /* loaded from: classes8.dex */
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
        dWy();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iYc = (HListView) findViewById(R.id.effect_list_view);
        this.iYc.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iYc.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nNM = (HListView) findViewById(R.id.sticker_list_view);
        this.nNM.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nNN = new d();
        this.iYc.setAdapter((ListAdapter) this.nNN);
        this.nNO = new k();
        this.nNM.setAdapter((ListAdapter) this.nNO);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.LW(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dWy() {
        this.nNS = "2";
        this.nNU = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.LG(2));
        this.fyF = getString(R.string.filter_nature);
        this.nNV = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nNX = stickerItem;
        this.nNT = getResources().getString(R.string.music_normal);
        this.nNW = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dWz() {
        if (this.nNP == null) {
            this.nNP = new ArrayList();
            a("No", com.baidu.tieba.video.a.LG(0));
            a("1", com.baidu.tieba.video.a.LG(1));
            a("2", com.baidu.tieba.video.a.LG(2));
            a("3", com.baidu.tieba.video.a.LG(3));
            a("4", com.baidu.tieba.video.a.LG(4));
            a("5", com.baidu.tieba.video.a.LG(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nNP.add(b(0, 1, str, aVar));
    }

    private void dWA() {
        if (this.nNQ == null) {
            this.nNQ = new ArrayList();
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
        if (this.nNQ != null) {
            this.nNQ.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        this.nOb = 3;
        t(this.nNR, this.nNT);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        this.nOb = 0;
        this.nNM.setAdapter((ListAdapter) this.nNO);
        this.nNO.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            yS(true);
            return;
        }
        this.nNM.setVisibility(0);
        this.iYc.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        this.nOb = 1;
        dWz();
        t(this.nNP, this.nNS);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWe() {
        this.nOb = 2;
        dWA();
        t(this.nNQ, this.fyF);
    }

    public void setListener(final a aVar) {
        if (this.nNN != null) {
            this.nNN.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nNS = eVar.getName();
                                VideoEffectLayout.this.nNU = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.fyF = eVar.getName();
                                VideoEffectLayout.this.nNV = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nNT = eVar.getName();
                                VideoEffectLayout.this.nNW = eVar;
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
        if (this.nNO != null) {
            this.nNO.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nNX = stickerItem;
        if (!x.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nNO != null) {
                this.nNO.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!x.isEmpty(this.mStickerItems)) {
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
            if (this.nNO != null) {
                this.nNO.notifyDataSetChanged();
            }
        }
    }

    private void t(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nNN.c(list, str);
                    VideoEffectLayout.this.nNN.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nNM.getVisibility() == 0) {
                runnable.run();
                yS(false);
            } else {
                dWB();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iYc.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nOb;
    }

    public e<String> getCurrentFilterItem() {
        return this.nNV;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nNU;
    }

    public StickerItem getCurrentStickItem() {
        return this.nNX;
    }

    private void dWB() {
        if (this.nNZ != null && this.nNZ.isRunning()) {
            this.nNZ.cancel();
        }
        if (this.nNY == null) {
            this.nNY = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iYc, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iYc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nNY.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iYc.setVisibility(0);
        this.nNY.start();
    }

    private void yS(boolean z) {
        if (z) {
            if (this.nOa != null && this.nOa.isRunning()) {
                this.nOa.cancel();
            }
            if (this.nNY != null && this.nNY.isRunning()) {
                this.nNY.cancel();
            }
            if (this.nNZ == null) {
                this.nNZ = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iYc, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nNM, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nNM != null) {
                            VideoEffectLayout.this.nNM.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nOk && VideoEffectLayout.this.iYc != null) {
                            VideoEffectLayout.this.iYc.setVisibility(8);
                        }
                    }
                });
                this.nNZ.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nNZ.start();
            return;
        }
        if (this.nNZ != null && this.nNZ.isRunning()) {
            this.nNZ.cancel();
        }
        if (this.nOa == null) {
            this.nOa = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nNM, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iYc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iYc != null) {
                        VideoEffectLayout.this.iYc.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOk && VideoEffectLayout.this.nNM != null) {
                        VideoEffectLayout.this.nNM.setVisibility(8);
                    }
                }
            });
            this.nOa.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nOa.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nNO != null) {
            this.nNO.bs(list);
            this.nNO.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nNR == null) {
            this.nNR = new ArrayList();
        } else {
            this.nNR.clear();
        }
        this.nNR.addAll(list);
    }

    public boolean dWw() {
        if (x.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dWx() {
        if (this.nNN != null) {
            this.nNN.dVj();
            this.nNT = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dVk() {
        if (this.nNN != null) {
            this.nNN.dVk();
        }
    }
}
