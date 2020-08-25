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
    private String eFK;
    private HListView hLH;
    private HListView mCZ;
    private d mDa;
    private k mDc;
    private List<e> mDd;
    private List<e> mDe;
    private List<e> mDf;
    private String mDg;
    private String mDh;
    private e<com.baidu.tieba.video.a> mDi;
    private e<String> mDj;
    private e<MusicData> mDk;
    private StickerItem mDl;
    private AnimatorSet mDm;
    private AnimatorSet mDn;
    private AnimatorSet mDo;
    private int mDp;
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
        dEb();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hLH = (HListView) findViewById(R.id.effect_list_view);
        this.hLH.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hLH.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mCZ = (HListView) findViewById(R.id.sticker_list_view);
        this.mCZ.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mDa = new d();
        this.hLH.setAdapter((ListAdapter) this.mDa);
        this.mDc = new k();
        this.mCZ.setAdapter((ListAdapter) this.mDc);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.IZ(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dEb() {
        this.mDg = "2";
        this.mDi = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.II(2));
        this.eFK = getString(R.string.filter_nature);
        this.mDj = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mDl = stickerItem;
        this.mDh = getResources().getString(R.string.music_normal);
        this.mDk = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dEc() {
        if (this.mDd == null) {
            this.mDd = new ArrayList();
            a("No", com.baidu.tieba.video.a.II(0));
            a("1", com.baidu.tieba.video.a.II(1));
            a("2", com.baidu.tieba.video.a.II(2));
            a("3", com.baidu.tieba.video.a.II(3));
            a("4", com.baidu.tieba.video.a.II(4));
            a("5", com.baidu.tieba.video.a.II(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mDd.add(b(0, 1, str, aVar));
    }

    private void dEd() {
        if (this.mDe == null) {
            this.mDe = new ArrayList();
            p(R.drawable.filter_icon_avatar_default, getString(R.string.filter_nature), "origin");
            p(R.drawable.filter_icon_avatar_hongkong, getString(R.string.filter_hongkong), "hongkong");
            p(R.drawable.filter_icon_avatar_refreshing, getString(R.string.filter_refreshing), "refreshing");
            p(R.drawable.filter_icon_avatar_girly, getString(R.string.filter_girly), "girly");
            p(R.drawable.filter_icon_avatar_concrete, getString(R.string.filter_concrete), "concrete");
            p(R.drawable.filter_icon_avatar_warm, getString(R.string.filter_warm), "warm");
            p(R.drawable.filter_icon_avatar_cold, getString(R.string.filter_cold), "cold");
            p(R.drawable.filter_icon_avatar_japanese, getString(R.string.filter_japanese), "Japanese");
            p(R.drawable.filter_icon_avatar_cruz, getString(R.string.filter_hdr), "cruz");
            p(R.drawable.filter_icon_avatar_abao, getString(R.string.filter_abao), "abao");
            p(R.drawable.filter_icon_avatar_dew, getString(R.string.filter_dew), "dew");
            p(R.drawable.filter_icon_avatar_slowlived, getString(R.string.filter_slowlived), "slowlived");
            p(R.drawable.filter_icon_avatar_sweet, getString(R.string.filter_sweet), "sweet");
            p(R.drawable.filter_icon_avatar_boardwalk, getString(R.string.filter_boardwalk), "boardwalk");
            p(R.drawable.filter_icon_avatar_keylime, getString(R.string.filter_keylime), "keylime");
            p(R.drawable.filter_icon_avatar_electric, getString(R.string.filter_electric), "electric");
            p(R.drawable.filter_icon_avatar_silver, getString(R.string.filter_silver), "silver");
            p(R.drawable.filter_icon_avatar_blackwhite, getString(R.string.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void p(int i, String str, String str2) {
        if (this.mDe != null) {
            this.mDe.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDE() {
        this.mDp = 3;
        n(this.mDf, this.mDh);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDF() {
        this.mDp = 0;
        this.mCZ.setAdapter((ListAdapter) this.mDc);
        this.mDc.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            wO(true);
            return;
        }
        this.mCZ.setVisibility(0);
        this.hLH.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDG() {
        this.mDp = 1;
        dEc();
        n(this.mDd, this.mDg);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDH() {
        this.mDp = 2;
        dEd();
        n(this.mDe, this.eFK);
    }

    public void setListener(final a aVar) {
        if (this.mDa != null) {
            this.mDa.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.mDg = eVar.getName();
                                VideoEffectLayout.this.mDi = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eFK = eVar.getName();
                                VideoEffectLayout.this.mDj = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.mDh = eVar.getName();
                                VideoEffectLayout.this.mDk = eVar;
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
        if (this.mDc != null) {
            this.mDc.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mDl = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mDc != null) {
                this.mDc.notifyDataSetChanged();
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
            if (this.mDc != null) {
                this.mDc.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mDa.b(list, str);
                    VideoEffectLayout.this.mDa.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mCZ.getVisibility() == 0) {
                runnable.run();
                wO(false);
            } else {
                dEe();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hLH.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.mDp;
    }

    public e<String> getCurrentFilterItem() {
        return this.mDj;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mDi;
    }

    public StickerItem getCurrentStickItem() {
        return this.mDl;
    }

    private void dEe() {
        if (this.mDn != null && this.mDn.isRunning()) {
            this.mDn.cancel();
        }
        if (this.mDm == null) {
            this.mDm = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLH, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hLH, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.mDm.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hLH.setVisibility(0);
        this.mDm.start();
    }

    private void wO(boolean z) {
        if (z) {
            if (this.mDo != null && this.mDo.isRunning()) {
                this.mDo.cancel();
            }
            if (this.mDm != null && this.mDm.isRunning()) {
                this.mDm.cancel();
            }
            if (this.mDn == null) {
                this.mDn = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLH, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mCZ, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mCZ != null) {
                            VideoEffectLayout.this.mCZ.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mDA && VideoEffectLayout.this.hLH != null) {
                            VideoEffectLayout.this.hLH.setVisibility(8);
                        }
                    }
                });
                this.mDn.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.mDn.start();
            return;
        }
        if (this.mDn != null && this.mDn.isRunning()) {
            this.mDn.cancel();
        }
        if (this.mDo == null) {
            this.mDo = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mCZ, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hLH, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hLH != null) {
                        VideoEffectLayout.this.hLH.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDA && VideoEffectLayout.this.mCZ != null) {
                        VideoEffectLayout.this.mCZ.setVisibility(8);
                    }
                }
            });
            this.mDo.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mDo.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mDc != null) {
            this.mDc.aK(list);
            this.mDc.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mDf == null) {
            this.mDf = new ArrayList();
        } else {
            this.mDf.clear();
        }
        this.mDf.addAll(list);
    }

    public boolean dDZ() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dEa() {
        if (this.mDa != null) {
            this.mDa.dCN();
            this.mDh = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dCO() {
        if (this.mDa != null) {
            this.mDa.dCO();
        }
    }
}
