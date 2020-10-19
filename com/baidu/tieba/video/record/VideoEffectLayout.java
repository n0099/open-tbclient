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
/* loaded from: classes23.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String eUc;
    private HListView ihN;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView ncL;
    private d ncM;
    private k ncN;
    private List<e> ncO;
    private List<e> ncP;
    private List<e> ncQ;
    private String ncR;
    private String ncS;
    private e<com.baidu.tieba.video.a> ncT;
    private e<String> ncU;
    private e<MusicData> ncV;
    private StickerItem ncW;
    private AnimatorSet ncX;
    private AnimatorSet ncY;
    private AnimatorSet ncZ;
    private int nda;

    /* loaded from: classes23.dex */
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
        dLQ();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.ihN = (HListView) findViewById(R.id.effect_list_view);
        this.ihN.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.ihN.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.ncL = (HListView) findViewById(R.id.sticker_list_view);
        this.ncL.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.ncM = new d();
        this.ihN.setAdapter((ListAdapter) this.ncM);
        this.ncN = new k();
        this.ncL.setAdapter((ListAdapter) this.ncN);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Kj(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dLQ() {
        this.ncR = "2";
        this.ncT = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.JS(2));
        this.eUc = getString(R.string.filter_nature);
        this.ncU = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.ncW = stickerItem;
        this.ncS = getResources().getString(R.string.music_normal);
        this.ncV = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dLR() {
        if (this.ncO == null) {
            this.ncO = new ArrayList();
            a("No", com.baidu.tieba.video.a.JS(0));
            a("1", com.baidu.tieba.video.a.JS(1));
            a("2", com.baidu.tieba.video.a.JS(2));
            a("3", com.baidu.tieba.video.a.JS(3));
            a("4", com.baidu.tieba.video.a.JS(4));
            a("5", com.baidu.tieba.video.a.JS(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.ncO.add(b(0, 1, str, aVar));
    }

    private void dLS() {
        if (this.ncP == null) {
            this.ncP = new ArrayList();
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
        if (this.ncP != null) {
            this.ncP.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLt() {
        this.nda = 3;
        o(this.ncQ, this.ncS);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLu() {
        this.nda = 0;
        this.ncL.setAdapter((ListAdapter) this.ncN);
        this.ncN.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            xG(true);
            return;
        }
        this.ncL.setVisibility(0);
        this.ihN.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLv() {
        this.nda = 1;
        dLR();
        o(this.ncO, this.ncR);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLw() {
        this.nda = 2;
        dLS();
        o(this.ncP, this.eUc);
    }

    public void setListener(final a aVar) {
        if (this.ncM != null) {
            this.ncM.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.ncR = eVar.getName();
                                VideoEffectLayout.this.ncT = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eUc = eVar.getName();
                                VideoEffectLayout.this.ncU = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.ncS = eVar.getName();
                                VideoEffectLayout.this.ncV = eVar;
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
        if (this.ncN != null) {
            this.ncN.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.ncW = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.ncN != null) {
                this.ncN.notifyDataSetChanged();
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
            if (this.ncN != null) {
                this.ncN.notifyDataSetChanged();
            }
        }
    }

    private void o(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.ncM.b(list, str);
                    VideoEffectLayout.this.ncM.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.ncL.getVisibility() == 0) {
                runnable.run();
                xG(false);
            } else {
                dLT();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.ihN.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nda;
    }

    public e<String> getCurrentFilterItem() {
        return this.ncU;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.ncT;
    }

    public StickerItem getCurrentStickItem() {
        return this.ncW;
    }

    private void dLT() {
        if (this.ncY != null && this.ncY.isRunning()) {
            this.ncY.cancel();
        }
        if (this.ncX == null) {
            this.ncX = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihN, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ihN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.ncX.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.ihN.setVisibility(0);
        this.ncX.start();
    }

    private void xG(boolean z) {
        if (z) {
            if (this.ncZ != null && this.ncZ.isRunning()) {
                this.ncZ.cancel();
            }
            if (this.ncX != null && this.ncX.isRunning()) {
                this.ncX.cancel();
            }
            if (this.ncY == null) {
                this.ncY = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ihN, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ncL, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.ncL != null) {
                            VideoEffectLayout.this.ncL.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.ndj && VideoEffectLayout.this.ihN != null) {
                            VideoEffectLayout.this.ihN.setVisibility(8);
                        }
                    }
                });
                this.ncY.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.ncY.start();
            return;
        }
        if (this.ncY != null && this.ncY.isRunning()) {
            this.ncY.cancel();
        }
        if (this.ncZ == null) {
            this.ncZ = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ncL, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.ihN, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.ihN != null) {
                        VideoEffectLayout.this.ihN.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.ndj && VideoEffectLayout.this.ncL != null) {
                        VideoEffectLayout.this.ncL.setVisibility(8);
                    }
                }
            });
            this.ncZ.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.ncZ.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.ncN != null) {
            this.ncN.aR(list);
            this.ncN.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.ncQ == null) {
            this.ncQ = new ArrayList();
        } else {
            this.ncQ.clear();
        }
        this.ncQ.addAll(list);
    }

    public boolean dLO() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dLP() {
        if (this.ncM != null) {
            this.ncM.dKC();
            this.ncS = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dKD() {
        if (this.ncM != null) {
            this.ncM.dKD();
        }
    }
}
