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
    private String dRN;
    private HListView gRu;
    private AnimatorSet lqA;
    private int lqB;
    private HListView lqm;
    private d lqn;
    private k lqo;
    private List<e> lqp;
    private List<e> lqq;
    private List<e> lqr;
    private String lqs;
    private String lqt;
    private e<com.baidu.tieba.video.a> lqu;
    private e<String> lqv;
    private e<MusicData> lqw;
    private StickerItem lqx;
    private AnimatorSet lqy;
    private AnimatorSet lqz;
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
        ddF();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gRu = (HListView) findViewById(R.id.effect_list_view);
        this.gRu.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gRu.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lqm = (HListView) findViewById(R.id.sticker_list_view);
        this.lqm.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lqn = new d();
        this.gRu.setAdapter((ListAdapter) this.lqn);
        this.lqo = new k();
        this.lqm.setAdapter((ListAdapter) this.lqo);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Er(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void ddF() {
        this.lqs = "2";
        this.lqu = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Eb(2));
        this.dRN = getString(R.string.filter_nature);
        this.lqv = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.lqx = stickerItem;
        this.lqt = getResources().getString(R.string.music_normal);
        this.lqw = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void ddG() {
        if (this.lqp == null) {
            this.lqp = new ArrayList();
            a("No", com.baidu.tieba.video.a.Eb(0));
            a("1", com.baidu.tieba.video.a.Eb(1));
            a("2", com.baidu.tieba.video.a.Eb(2));
            a("3", com.baidu.tieba.video.a.Eb(3));
            a("4", com.baidu.tieba.video.a.Eb(4));
            a("5", com.baidu.tieba.video.a.Eb(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.lqp.add(b(0, 1, str, aVar));
    }

    private void ddH() {
        if (this.lqq == null) {
            this.lqq = new ArrayList();
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
        if (this.lqq != null) {
            this.lqq.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        this.lqB = 3;
        m(this.lqr, this.lqt);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddj() {
        this.lqB = 0;
        this.lqm.setAdapter((ListAdapter) this.lqo);
        this.lqo.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            uF(true);
            return;
        }
        this.lqm.setVisibility(0);
        this.gRu.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddk() {
        this.lqB = 1;
        ddG();
        m(this.lqp, this.lqs);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddl() {
        this.lqB = 2;
        ddH();
        m(this.lqq, this.dRN);
    }

    public void setListener(final a aVar) {
        if (this.lqn != null) {
            this.lqn.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.lqs = eVar.getName();
                                VideoEffectLayout.this.lqu = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.dRN = eVar.getName();
                                VideoEffectLayout.this.lqv = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.lqt = eVar.getName();
                                VideoEffectLayout.this.lqw = eVar;
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
        if (this.lqo != null) {
            this.lqo.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.lqx = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.lqo != null) {
                this.lqo.notifyDataSetChanged();
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
            if (this.lqo != null) {
                this.lqo.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.lqn.b(list, str);
                    VideoEffectLayout.this.lqn.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.lqm.getVisibility() == 0) {
                runnable.run();
                uF(false);
            } else {
                ddI();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.gRu.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.lqB;
    }

    public e<String> getCurrentFilterItem() {
        return this.lqv;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.lqu;
    }

    public StickerItem getCurrentStickItem() {
        return this.lqx;
    }

    private void ddI() {
        if (this.lqz != null && this.lqz.isRunning()) {
            this.lqz.cancel();
        }
        if (this.lqy == null) {
            this.lqy = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gRu, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gRu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.lqy.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gRu.setVisibility(0);
        this.lqy.start();
    }

    private void uF(boolean z) {
        if (z) {
            if (this.lqA != null && this.lqA.isRunning()) {
                this.lqA.cancel();
            }
            if (this.lqy != null && this.lqy.isRunning()) {
                this.lqy.cancel();
            }
            if (this.lqz == null) {
                this.lqz = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gRu, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.lqm, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.lqm != null) {
                            VideoEffectLayout.this.lqm.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.lqK && VideoEffectLayout.this.gRu != null) {
                            VideoEffectLayout.this.gRu.setVisibility(8);
                        }
                    }
                });
                this.lqz.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.lqz.start();
            return;
        }
        if (this.lqz != null && this.lqz.isRunning()) {
            this.lqz.cancel();
        }
        if (this.lqA == null) {
            this.lqA = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lqm, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.gRu, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.gRu != null) {
                        VideoEffectLayout.this.gRu.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqK && VideoEffectLayout.this.lqm != null) {
                        VideoEffectLayout.this.lqm.setVisibility(8);
                    }
                }
            });
            this.lqA.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.lqA.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.lqo != null) {
            this.lqo.aE(list);
            this.lqo.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.lqr == null) {
            this.lqr = new ArrayList();
        } else {
            this.lqr.clear();
        }
        this.lqr.addAll(list);
    }

    public boolean ddD() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void ddE() {
        if (this.lqn != null) {
            this.lqn.dcr();
            this.lqt = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dcs() {
        if (this.lqn != null) {
            this.lqn.dcs();
        }
    }
}
