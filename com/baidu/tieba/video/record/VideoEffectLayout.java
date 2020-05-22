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
    private String egm;
    private HListView hgl;
    private HListView lIV;
    private d lIW;
    private k lIX;
    private List<e> lIY;
    private List<e> lIZ;
    private List<e> lJa;
    private String lJb;
    private String lJc;
    private e<com.baidu.tieba.video.a> lJd;
    private e<String> lJe;
    private e<MusicData> lJf;
    private StickerItem lJg;
    private AnimatorSet lJh;
    private AnimatorSet lJi;
    private AnimatorSet lJj;
    private int lJk;
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
        dkR();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hgl = (HListView) findViewById(R.id.effect_list_view);
        this.hgl.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hgl.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lIV = (HListView) findViewById(R.id.sticker_list_view);
        this.lIV.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lIW = new d();
        this.hgl.setAdapter((ListAdapter) this.lIW);
        this.lIX = new k();
        this.lIV.setAdapter((ListAdapter) this.lIX);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Fc(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dkR() {
        this.lJb = "2";
        this.lJd = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.EM(2));
        this.egm = getString(R.string.filter_nature);
        this.lJe = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.lJg = stickerItem;
        this.lJc = getResources().getString(R.string.music_normal);
        this.lJf = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dkS() {
        if (this.lIY == null) {
            this.lIY = new ArrayList();
            a("No", com.baidu.tieba.video.a.EM(0));
            a("1", com.baidu.tieba.video.a.EM(1));
            a("2", com.baidu.tieba.video.a.EM(2));
            a("3", com.baidu.tieba.video.a.EM(3));
            a("4", com.baidu.tieba.video.a.EM(4));
            a("5", com.baidu.tieba.video.a.EM(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.lIY.add(b(0, 1, str, aVar));
    }

    private void dkT() {
        if (this.lIZ == null) {
            this.lIZ = new ArrayList();
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
        if (this.lIZ != null) {
            this.lIZ.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dku() {
        this.lJk = 3;
        m(this.lJa, this.lJc);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkv() {
        this.lJk = 0;
        this.lIV.setAdapter((ListAdapter) this.lIX);
        this.lIX.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            vd(true);
            return;
        }
        this.lIV.setVisibility(0);
        this.hgl.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkw() {
        this.lJk = 1;
        dkS();
        m(this.lIY, this.lJb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkx() {
        this.lJk = 2;
        dkT();
        m(this.lIZ, this.egm);
    }

    public void setListener(final a aVar) {
        if (this.lIW != null) {
            this.lIW.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.lJb = eVar.getName();
                                VideoEffectLayout.this.lJd = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.egm = eVar.getName();
                                VideoEffectLayout.this.lJe = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.lJc = eVar.getName();
                                VideoEffectLayout.this.lJf = eVar;
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
        if (this.lIX != null) {
            this.lIX.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.lJg = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.lIX != null) {
                this.lIX.notifyDataSetChanged();
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
            if (this.lIX != null) {
                this.lIX.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.lIW.b(list, str);
                    VideoEffectLayout.this.lIW.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.lIV.getVisibility() == 0) {
                runnable.run();
                vd(false);
            } else {
                dkU();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hgl.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.lJk;
    }

    public e<String> getCurrentFilterItem() {
        return this.lJe;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.lJd;
    }

    public StickerItem getCurrentStickItem() {
        return this.lJg;
    }

    private void dkU() {
        if (this.lJi != null && this.lJi.isRunning()) {
            this.lJi.cancel();
        }
        if (this.lJh == null) {
            this.lJh = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgl, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hgl, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.lJh.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hgl.setVisibility(0);
        this.lJh.start();
    }

    private void vd(boolean z) {
        if (z) {
            if (this.lJj != null && this.lJj.isRunning()) {
                this.lJj.cancel();
            }
            if (this.lJh != null && this.lJh.isRunning()) {
                this.lJh.cancel();
            }
            if (this.lJi == null) {
                this.lJi = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgl, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.lIV, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.lIV != null) {
                            VideoEffectLayout.this.lIV.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.lJt && VideoEffectLayout.this.hgl != null) {
                            VideoEffectLayout.this.hgl.setVisibility(8);
                        }
                    }
                });
                this.lJi.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.lJi.start();
            return;
        }
        if (this.lJi != null && this.lJi.isRunning()) {
            this.lJi.cancel();
        }
        if (this.lJj == null) {
            this.lJj = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lIV, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hgl, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hgl != null) {
                        VideoEffectLayout.this.hgl.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lJt && VideoEffectLayout.this.lIV != null) {
                        VideoEffectLayout.this.lIV.setVisibility(8);
                    }
                }
            });
            this.lJj.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.lJj.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.lIX != null) {
            this.lIX.az(list);
            this.lIX.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.lJa == null) {
            this.lJa = new ArrayList();
        } else {
            this.lJa.clear();
        }
        this.lJa.addAll(list);
    }

    public boolean dkP() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dkQ() {
        if (this.lIW != null) {
            this.lIW.djD();
            this.lJc = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void djE() {
        if (this.lIW != null) {
            this.lIW.djE();
        }
    }
}
