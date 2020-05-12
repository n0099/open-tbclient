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
    private String dRS;
    private HListView gRA;
    private e<MusicData> lqA;
    private StickerItem lqB;
    private AnimatorSet lqC;
    private AnimatorSet lqD;
    private AnimatorSet lqE;
    private int lqF;
    private HListView lqq;
    private d lqr;
    private k lqs;
    private List<e> lqt;
    private List<e> lqu;
    private List<e> lqv;
    private String lqw;
    private String lqx;
    private e<com.baidu.tieba.video.a> lqy;
    private e<String> lqz;
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
        ddD();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gRA = (HListView) findViewById(R.id.effect_list_view);
        this.gRA.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gRA.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lqq = (HListView) findViewById(R.id.sticker_list_view);
        this.lqq.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lqr = new d();
        this.gRA.setAdapter((ListAdapter) this.lqr);
        this.lqs = new k();
        this.lqq.setAdapter((ListAdapter) this.lqs);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Er(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void ddD() {
        this.lqw = "2";
        this.lqy = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Eb(2));
        this.dRS = getString(R.string.filter_nature);
        this.lqz = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.lqB = stickerItem;
        this.lqx = getResources().getString(R.string.music_normal);
        this.lqA = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void ddE() {
        if (this.lqt == null) {
            this.lqt = new ArrayList();
            a("No", com.baidu.tieba.video.a.Eb(0));
            a("1", com.baidu.tieba.video.a.Eb(1));
            a("2", com.baidu.tieba.video.a.Eb(2));
            a("3", com.baidu.tieba.video.a.Eb(3));
            a("4", com.baidu.tieba.video.a.Eb(4));
            a("5", com.baidu.tieba.video.a.Eb(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.lqt.add(b(0, 1, str, aVar));
    }

    private void ddF() {
        if (this.lqu == null) {
            this.lqu = new ArrayList();
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
        if (this.lqu != null) {
            this.lqu.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddg() {
        this.lqF = 3;
        m(this.lqv, this.lqx);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddh() {
        this.lqF = 0;
        this.lqq.setAdapter((ListAdapter) this.lqs);
        this.lqs.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            uF(true);
            return;
        }
        this.lqq.setVisibility(0);
        this.gRA.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        this.lqF = 1;
        ddE();
        m(this.lqt, this.lqw);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddj() {
        this.lqF = 2;
        ddF();
        m(this.lqu, this.dRS);
    }

    public void setListener(final a aVar) {
        if (this.lqr != null) {
            this.lqr.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.lqw = eVar.getName();
                                VideoEffectLayout.this.lqy = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.dRS = eVar.getName();
                                VideoEffectLayout.this.lqz = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.lqx = eVar.getName();
                                VideoEffectLayout.this.lqA = eVar;
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
        if (this.lqs != null) {
            this.lqs.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.lqB = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.lqs != null) {
                this.lqs.notifyDataSetChanged();
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
            if (this.lqs != null) {
                this.lqs.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.lqr.b(list, str);
                    VideoEffectLayout.this.lqr.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.lqq.getVisibility() == 0) {
                runnable.run();
                uF(false);
            } else {
                ddG();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.gRA.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.lqF;
    }

    public e<String> getCurrentFilterItem() {
        return this.lqz;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.lqy;
    }

    public StickerItem getCurrentStickItem() {
        return this.lqB;
    }

    private void ddG() {
        if (this.lqD != null && this.lqD.isRunning()) {
            this.lqD.cancel();
        }
        if (this.lqC == null) {
            this.lqC = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gRA, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gRA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.lqC.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gRA.setVisibility(0);
        this.lqC.start();
    }

    private void uF(boolean z) {
        if (z) {
            if (this.lqE != null && this.lqE.isRunning()) {
                this.lqE.cancel();
            }
            if (this.lqC != null && this.lqC.isRunning()) {
                this.lqC.cancel();
            }
            if (this.lqD == null) {
                this.lqD = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gRA, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.lqq, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.lqq != null) {
                            VideoEffectLayout.this.lqq.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.lqO && VideoEffectLayout.this.gRA != null) {
                            VideoEffectLayout.this.gRA.setVisibility(8);
                        }
                    }
                });
                this.lqD.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.lqD.start();
            return;
        }
        if (this.lqD != null && this.lqD.isRunning()) {
            this.lqD.cancel();
        }
        if (this.lqE == null) {
            this.lqE = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lqq, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.gRA, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.gRA != null) {
                        VideoEffectLayout.this.gRA.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqO && VideoEffectLayout.this.lqq != null) {
                        VideoEffectLayout.this.lqq.setVisibility(8);
                    }
                }
            });
            this.lqE.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.lqE.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.lqs != null) {
            this.lqs.aE(list);
            this.lqs.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.lqv == null) {
            this.lqv = new ArrayList();
        } else {
            this.lqv.clear();
        }
        this.lqv.addAll(list);
    }

    public boolean ddB() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void ddC() {
        if (this.lqr != null) {
            this.lqr.dcp();
            this.lqx = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dcq() {
        if (this.lqr != null) {
            this.lqr.dcq();
        }
    }
}
