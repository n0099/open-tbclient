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
/* loaded from: classes7.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String dmV;
    private HListView gce;
    private AnimatorSet kzA;
    private AnimatorSet kzB;
    private int kzC;
    private HListView kzn;
    private d kzo;
    private k kzp;
    private List<e> kzq;
    private List<e> kzr;
    private List<e> kzs;
    private String kzt;
    private String kzu;
    private e<com.baidu.tieba.video.a> kzv;
    private e<String> kzw;
    private e<MusicData> kzx;
    private StickerItem kzy;
    private AnimatorSet kzz;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes7.dex */
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
        cPJ();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gce = (HListView) findViewById(R.id.effect_list_view);
        this.gce.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gce.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kzn = (HListView) findViewById(R.id.sticker_list_view);
        this.kzn.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kzo = new d();
        this.gce.setAdapter((ListAdapter) this.kzo);
        this.kzp = new k();
        this.kzn.setAdapter((ListAdapter) this.kzp);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Dt(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cPJ() {
        this.kzt = "2";
        this.kzv = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dd(2));
        this.dmV = getString(R.string.filter_nature);
        this.kzw = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kzy = stickerItem;
        this.kzu = getResources().getString(R.string.music_normal);
        this.kzx = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cPK() {
        if (this.kzq == null) {
            this.kzq = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dd(0));
            a("1", com.baidu.tieba.video.a.Dd(1));
            a("2", com.baidu.tieba.video.a.Dd(2));
            a("3", com.baidu.tieba.video.a.Dd(3));
            a("4", com.baidu.tieba.video.a.Dd(4));
            a("5", com.baidu.tieba.video.a.Dd(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kzq.add(b(0, 1, str, aVar));
    }

    private void cPL() {
        if (this.kzr == null) {
            this.kzr = new ArrayList();
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
        if (this.kzr != null) {
            this.kzr.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPm() {
        this.kzC = 3;
        m(this.kzs, this.kzu);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPn() {
        this.kzC = 0;
        this.kzn.setAdapter((ListAdapter) this.kzp);
        this.kzp.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            th(true);
            return;
        }
        this.kzn.setVisibility(0);
        this.gce.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPo() {
        this.kzC = 1;
        cPK();
        m(this.kzq, this.kzt);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPp() {
        this.kzC = 2;
        cPL();
        m(this.kzr, this.dmV);
    }

    public void setListener(final a aVar) {
        if (this.kzo != null) {
            this.kzo.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kzt = eVar.getName();
                                VideoEffectLayout.this.kzv = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.dmV = eVar.getName();
                                VideoEffectLayout.this.kzw = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kzu = eVar.getName();
                                VideoEffectLayout.this.kzx = eVar;
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
        if (this.kzp != null) {
            this.kzp.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kzy = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kzp != null) {
                this.kzp.notifyDataSetChanged();
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
            if (this.kzp != null) {
                this.kzp.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kzo.b(list, str);
                    VideoEffectLayout.this.kzo.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kzn.getVisibility() == 0) {
                runnable.run();
                th(false);
            } else {
                cPM();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.gce.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kzC;
    }

    public e<String> getCurrentFilterItem() {
        return this.kzw;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kzv;
    }

    public StickerItem getCurrentStickItem() {
        return this.kzy;
    }

    private void cPM() {
        if (this.kzA != null && this.kzA.isRunning()) {
            this.kzA.cancel();
        }
        if (this.kzz == null) {
            this.kzz = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gce, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gce, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kzz.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gce.setVisibility(0);
        this.kzz.start();
    }

    private void th(boolean z) {
        if (z) {
            if (this.kzB != null && this.kzB.isRunning()) {
                this.kzB.cancel();
            }
            if (this.kzz != null && this.kzz.isRunning()) {
                this.kzz.cancel();
            }
            if (this.kzA == null) {
                this.kzA = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gce, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kzn, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kzn != null) {
                            VideoEffectLayout.this.kzn.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kzL && VideoEffectLayout.this.gce != null) {
                            VideoEffectLayout.this.gce.setVisibility(8);
                        }
                    }
                });
                this.kzA.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kzA.start();
            return;
        }
        if (this.kzA != null && this.kzA.isRunning()) {
            this.kzA.cancel();
        }
        if (this.kzB == null) {
            this.kzB = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kzn, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.gce, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.gce != null) {
                        VideoEffectLayout.this.gce.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kzL && VideoEffectLayout.this.kzn != null) {
                        VideoEffectLayout.this.kzn.setVisibility(8);
                    }
                }
            });
            this.kzB.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kzB.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kzp != null) {
            this.kzp.aw(list);
            this.kzp.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kzs == null) {
            this.kzs = new ArrayList();
        } else {
            this.kzs.clear();
        }
        this.kzs.addAll(list);
    }

    public boolean cPH() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cPI() {
        if (this.kzo != null) {
            this.kzo.cOy();
            this.kzu = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cOz() {
        if (this.kzo != null) {
            this.kzo.cOz();
        }
    }
}
