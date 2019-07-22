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
    private String cmg;
    private HListView fjD;
    private HListView jDc;
    private d jDd;
    private k jDe;
    private List<e> jDf;
    private List<e> jDg;
    private List<e> jDh;
    private String jDi;
    private String jDj;
    private e<com.baidu.tieba.video.a> jDk;
    private e<String> jDl;
    private e<MusicData> jDm;
    private StickerItem jDn;
    private AnimatorSet jDo;
    private AnimatorSet jDp;
    private AnimatorSet jDq;
    private int jDr;
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
        cwU();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.fjD = (HListView) findViewById(R.id.effect_list_view);
        this.fjD.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.fjD.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jDc = (HListView) findViewById(R.id.sticker_list_view);
        this.jDc.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jDd = new d();
        this.fjD.setAdapter((ListAdapter) this.jDd);
        this.jDe = new k();
        this.jDc.setAdapter((ListAdapter) this.jDe);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Cn(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cwU() {
        this.jDi = "2";
        this.jDk = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.BX(2));
        this.cmg = getString(R.string.filter_nature);
        this.jDl = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jDn = stickerItem;
        this.jDj = getResources().getString(R.string.music_normal);
        this.jDm = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cwV() {
        if (this.jDf == null) {
            this.jDf = new ArrayList();
            a("No", com.baidu.tieba.video.a.BX(0));
            a("1", com.baidu.tieba.video.a.BX(1));
            a("2", com.baidu.tieba.video.a.BX(2));
            a("3", com.baidu.tieba.video.a.BX(3));
            a("4", com.baidu.tieba.video.a.BX(4));
            a("5", com.baidu.tieba.video.a.BX(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jDf.add(c(0, 1, str, aVar));
    }

    private void cwW() {
        if (this.jDg == null) {
            this.jDg = new ArrayList();
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
        if (this.jDg != null) {
            this.jDg.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwx() {
        this.jDr = 3;
        n(this.jDh, this.jDj);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwy() {
        this.jDr = 0;
        this.jDc.setAdapter((ListAdapter) this.jDe);
        this.jDe.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rO(true);
            return;
        }
        this.jDc.setVisibility(0);
        this.fjD.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwz() {
        this.jDr = 1;
        cwV();
        n(this.jDf, this.jDi);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwA() {
        this.jDr = 2;
        cwW();
        n(this.jDg, this.cmg);
    }

    public void setListener(final a aVar) {
        if (this.jDd != null) {
            this.jDd.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jDi = eVar.getName();
                                VideoEffectLayout.this.jDk = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.cmg = eVar.getName();
                                VideoEffectLayout.this.jDl = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jDj = eVar.getName();
                                VideoEffectLayout.this.jDm = eVar;
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
        if (this.jDe != null) {
            this.jDe.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jDn = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jDe != null) {
                this.jDe.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.aa(this.mStickerItems)) {
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
            if (this.jDe != null) {
                this.jDe.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jDd.b(list, str);
                    VideoEffectLayout.this.jDd.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jDc.getVisibility() == 0) {
                runnable.run();
                rO(false);
            } else {
                cwX();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.fjD.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jDr;
    }

    public e<String> getCurrentFilterItem() {
        return this.jDl;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jDk;
    }

    public StickerItem getCurrentStickItem() {
        return this.jDn;
    }

    private void cwX() {
        if (this.jDp != null && this.jDp.isRunning()) {
            this.jDp.cancel();
        }
        if (this.jDo == null) {
            this.jDo = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fjD, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.fjD, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jDo.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.fjD.setVisibility(0);
        this.jDo.start();
    }

    private void rO(boolean z) {
        if (z) {
            if (this.jDq != null && this.jDq.isRunning()) {
                this.jDq.cancel();
            }
            if (this.jDo != null && this.jDo.isRunning()) {
                this.jDo.cancel();
            }
            if (this.jDp == null) {
                this.jDp = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fjD, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jDc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jDc != null) {
                            VideoEffectLayout.this.jDc.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jDA && VideoEffectLayout.this.fjD != null) {
                            VideoEffectLayout.this.fjD.setVisibility(8);
                        }
                    }
                });
                this.jDp.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jDp.start();
            return;
        }
        if (this.jDp != null && this.jDp.isRunning()) {
            this.jDp.cancel();
        }
        if (this.jDq == null) {
            this.jDq = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jDc, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.fjD, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.fjD != null) {
                        VideoEffectLayout.this.fjD.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jDA && VideoEffectLayout.this.jDc != null) {
                        VideoEffectLayout.this.jDc.setVisibility(8);
                    }
                }
            });
            this.jDq.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jDq.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jDe != null) {
            this.jDe.T(list);
            this.jDe.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jDh == null) {
            this.jDh = new ArrayList();
        } else {
            this.jDh.clear();
        }
        this.jDh.addAll(list);
    }

    public boolean cwS() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cwT() {
        if (this.jDd != null) {
            this.jDd.cvG();
            this.jDj = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cvH() {
        if (this.jDd != null) {
            this.jDd.cvH();
        }
    }
}
