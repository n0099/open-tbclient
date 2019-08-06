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
    private String cmn;
    private HListView fkd;
    private HListView jEj;
    private d jEk;
    private k jEl;
    private List<e> jEm;
    private List<e> jEn;
    private List<e> jEo;
    private String jEp;
    private String jEq;
    private e<com.baidu.tieba.video.a> jEr;
    private e<String> jEs;
    private e<MusicData> jEt;
    private StickerItem jEu;
    private AnimatorSet jEv;
    private AnimatorSet jEw;
    private AnimatorSet jEx;
    private int jEy;
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
        cxq();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.fkd = (HListView) findViewById(R.id.effect_list_view);
        this.fkd.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.fkd.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jEj = (HListView) findViewById(R.id.sticker_list_view);
        this.jEj.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jEk = new d();
        this.fkd.setAdapter((ListAdapter) this.jEk);
        this.jEl = new k();
        this.jEj.setAdapter((ListAdapter) this.jEl);
    }

    private <T> e<T> c(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Cp(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cxq() {
        this.jEp = "2";
        this.jEr = c(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.BZ(2));
        this.cmn = getString(R.string.filter_nature);
        this.jEs = c(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jEu = stickerItem;
        this.jEq = getResources().getString(R.string.music_normal);
        this.jEt = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cxr() {
        if (this.jEm == null) {
            this.jEm = new ArrayList();
            a("No", com.baidu.tieba.video.a.BZ(0));
            a("1", com.baidu.tieba.video.a.BZ(1));
            a("2", com.baidu.tieba.video.a.BZ(2));
            a("3", com.baidu.tieba.video.a.BZ(3));
            a("4", com.baidu.tieba.video.a.BZ(4));
            a("5", com.baidu.tieba.video.a.BZ(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jEm.add(c(0, 1, str, aVar));
    }

    private void cxs() {
        if (this.jEn == null) {
            this.jEn = new ArrayList();
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
        if (this.jEn != null) {
            this.jEn.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwT() {
        this.jEy = 3;
        n(this.jEo, this.jEq);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwU() {
        this.jEy = 0;
        this.jEj.setAdapter((ListAdapter) this.jEl);
        this.jEl.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rP(true);
            return;
        }
        this.jEj.setVisibility(0);
        this.fkd.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwV() {
        this.jEy = 1;
        cxr();
        n(this.jEm, this.jEp);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwW() {
        this.jEy = 2;
        cxs();
        n(this.jEn, this.cmn);
    }

    public void setListener(final a aVar) {
        if (this.jEk != null) {
            this.jEk.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jEp = eVar.getName();
                                VideoEffectLayout.this.jEr = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.cmn = eVar.getName();
                                VideoEffectLayout.this.jEs = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jEq = eVar.getName();
                                VideoEffectLayout.this.jEt = eVar;
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
        if (this.jEl != null) {
            this.jEl.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jEu = stickerItem;
        if (!v.aa(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jEl != null) {
                this.jEl.notifyDataSetChanged();
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
            if (this.jEl != null) {
                this.jEl.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jEk.b(list, str);
                    VideoEffectLayout.this.jEk.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jEj.getVisibility() == 0) {
                runnable.run();
                rP(false);
            } else {
                cxt();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.fkd.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jEy;
    }

    public e<String> getCurrentFilterItem() {
        return this.jEs;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jEr;
    }

    public StickerItem getCurrentStickItem() {
        return this.jEu;
    }

    private void cxt() {
        if (this.jEw != null && this.jEw.isRunning()) {
            this.jEw.cancel();
        }
        if (this.jEv == null) {
            this.jEv = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fkd, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.fkd, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jEv.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.fkd.setVisibility(0);
        this.jEv.start();
    }

    private void rP(boolean z) {
        if (z) {
            if (this.jEx != null && this.jEx.isRunning()) {
                this.jEx.cancel();
            }
            if (this.jEv != null && this.jEv.isRunning()) {
                this.jEv.cancel();
            }
            if (this.jEw == null) {
                this.jEw = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fkd, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jEj, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jEj != null) {
                            VideoEffectLayout.this.jEj.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jEH && VideoEffectLayout.this.fkd != null) {
                            VideoEffectLayout.this.fkd.setVisibility(8);
                        }
                    }
                });
                this.jEw.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jEw.start();
            return;
        }
        if (this.jEw != null && this.jEw.isRunning()) {
            this.jEw.cancel();
        }
        if (this.jEx == null) {
            this.jEx = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jEj, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.fkd, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.fkd != null) {
                        VideoEffectLayout.this.fkd.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jEH && VideoEffectLayout.this.jEj != null) {
                        VideoEffectLayout.this.jEj.setVisibility(8);
                    }
                }
            });
            this.jEx.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jEx.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jEl != null) {
            this.jEl.T(list);
            this.jEl.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jEo == null) {
            this.jEo = new ArrayList();
        } else {
            this.jEo.clear();
        }
        this.jEo.addAll(list);
    }

    public boolean cxo() {
        if (v.aa(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cxp() {
        if (this.jEk != null) {
            this.jEk.cwc();
            this.jEq = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cwd() {
        if (this.jEk != null) {
            this.jEk.cwd();
        }
    }
}
