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
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String cAg;
    private HListView foy;
    private List<e> jGA;
    private String jGB;
    private String jGC;
    private e<com.baidu.tieba.video.a> jGD;
    private e<String> jGE;
    private e<MusicData> jGF;
    private StickerItem jGG;
    private AnimatorSet jGH;
    private AnimatorSet jGI;
    private AnimatorSet jGJ;
    private int jGK;
    private HListView jGv;
    private d jGw;
    private k jGx;
    private List<e> jGy;
    private List<e> jGz;
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
        cvU();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.foy = (HListView) findViewById(R.id.effect_list_view);
        this.foy.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.foy.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jGv = (HListView) findViewById(R.id.sticker_list_view);
        this.jGv.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jGw = new d();
        this.foy.setAdapter((ListAdapter) this.jGw);
        this.jGx = new k();
        this.jGv.setAdapter((ListAdapter) this.jGx);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.AZ(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cvU() {
        this.jGB = "2";
        this.jGD = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.AJ(2));
        this.cAg = getString(R.string.filter_nature);
        this.jGE = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jGG = stickerItem;
        this.jGC = getResources().getString(R.string.music_normal);
        this.jGF = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cvV() {
        if (this.jGy == null) {
            this.jGy = new ArrayList();
            a("No", com.baidu.tieba.video.a.AJ(0));
            a("1", com.baidu.tieba.video.a.AJ(1));
            a("2", com.baidu.tieba.video.a.AJ(2));
            a("3", com.baidu.tieba.video.a.AJ(3));
            a("4", com.baidu.tieba.video.a.AJ(4));
            a("5", com.baidu.tieba.video.a.AJ(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jGy.add(b(0, 1, str, aVar));
    }

    private void cvW() {
        if (this.jGz == null) {
            this.jGz = new ArrayList();
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
        if (this.jGz != null) {
            this.jGz.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        this.jGK = 3;
        l(this.jGA, this.jGC);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        this.jGK = 0;
        this.jGv.setAdapter((ListAdapter) this.jGx);
        this.jGx.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rB(true);
            return;
        }
        this.jGv.setVisibility(0);
        this.foy.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvz() {
        this.jGK = 1;
        cvV();
        l(this.jGy, this.jGB);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvA() {
        this.jGK = 2;
        cvW();
        l(this.jGz, this.cAg);
    }

    public void setListener(final a aVar) {
        if (this.jGw != null) {
            this.jGw.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jGB = eVar.getName();
                                VideoEffectLayout.this.jGD = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.cAg = eVar.getName();
                                VideoEffectLayout.this.jGE = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jGC = eVar.getName();
                                VideoEffectLayout.this.jGF = eVar;
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
        if (this.jGx != null) {
            this.jGx.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jGG = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jGx != null) {
                this.jGx.notifyDataSetChanged();
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
            if (this.jGx != null) {
                this.jGx.notifyDataSetChanged();
            }
        }
    }

    private void l(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jGw.b(list, str);
                    VideoEffectLayout.this.jGw.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jGv.getVisibility() == 0) {
                runnable.run();
                rB(false);
            } else {
                cvX();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.foy.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jGK;
    }

    public e<String> getCurrentFilterItem() {
        return this.jGE;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jGD;
    }

    public StickerItem getCurrentStickItem() {
        return this.jGG;
    }

    private void cvX() {
        if (this.jGI != null && this.jGI.isRunning()) {
            this.jGI.cancel();
        }
        if (this.jGH == null) {
            this.jGH = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.foy, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.foy, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jGH.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.foy.setVisibility(0);
        this.jGH.start();
    }

    private void rB(boolean z) {
        if (z) {
            if (this.jGJ != null && this.jGJ.isRunning()) {
                this.jGJ.cancel();
            }
            if (this.jGH != null && this.jGH.isRunning()) {
                this.jGH.cancel();
            }
            if (this.jGI == null) {
                this.jGI = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.foy, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jGv, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jGv != null) {
                            VideoEffectLayout.this.jGv.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jGT && VideoEffectLayout.this.foy != null) {
                            VideoEffectLayout.this.foy.setVisibility(8);
                        }
                    }
                });
                this.jGI.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jGI.start();
            return;
        }
        if (this.jGI != null && this.jGI.isRunning()) {
            this.jGI.cancel();
        }
        if (this.jGJ == null) {
            this.jGJ = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jGv, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.foy, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.foy != null) {
                        VideoEffectLayout.this.foy.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGT && VideoEffectLayout.this.jGv != null) {
                        VideoEffectLayout.this.jGv.setVisibility(8);
                    }
                }
            });
            this.jGJ.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jGJ.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jGx != null) {
            this.jGx.aq(list);
            this.jGx.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jGA == null) {
            this.jGA = new ArrayList();
        } else {
            this.jGA.clear();
        }
        this.jGA.addAll(list);
    }

    public boolean cvS() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cvT() {
        if (this.jGw != null) {
            this.jGw.cuE();
            this.jGC = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cuF() {
        if (this.jGw != null) {
            this.jGw.cuF();
        }
    }
}
