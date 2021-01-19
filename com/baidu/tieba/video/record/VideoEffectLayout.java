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
/* loaded from: classes7.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String ftX;
    private HListView iTv;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView nJi;
    private d nJj;
    private k nJk;
    private List<e> nJl;
    private List<e> nJm;
    private List<e> nJn;
    private String nJo;
    private String nJp;
    private e<com.baidu.tieba.video.a> nJq;
    private e<String> nJr;
    private e<MusicData> nJs;
    private StickerItem nJt;
    private AnimatorSet nJu;
    private AnimatorSet nJv;
    private AnimatorSet nJw;
    private int nJx;

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
        dSG();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iTv = (HListView) findViewById(R.id.effect_list_view);
        this.iTv.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iTv.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nJi = (HListView) findViewById(R.id.sticker_list_view);
        this.nJi.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nJj = new d();
        this.iTv.setAdapter((ListAdapter) this.nJj);
        this.nJk = new k();
        this.nJi.setAdapter((ListAdapter) this.nJk);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Kp(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dSG() {
        this.nJo = "2";
        this.nJq = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.JZ(2));
        this.ftX = getString(R.string.filter_nature);
        this.nJr = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nJt = stickerItem;
        this.nJp = getResources().getString(R.string.music_normal);
        this.nJs = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dSH() {
        if (this.nJl == null) {
            this.nJl = new ArrayList();
            a("No", com.baidu.tieba.video.a.JZ(0));
            a("1", com.baidu.tieba.video.a.JZ(1));
            a("2", com.baidu.tieba.video.a.JZ(2));
            a("3", com.baidu.tieba.video.a.JZ(3));
            a("4", com.baidu.tieba.video.a.JZ(4));
            a("5", com.baidu.tieba.video.a.JZ(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nJl.add(b(0, 1, str, aVar));
    }

    private void dSI() {
        if (this.nJm == null) {
            this.nJm = new ArrayList();
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
        if (this.nJm != null) {
            this.nJm.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSj() {
        this.nJx = 3;
        t(this.nJn, this.nJp);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSk() {
        this.nJx = 0;
        this.nJi.setAdapter((ListAdapter) this.nJk);
        this.nJk.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            yO(true);
            return;
        }
        this.nJi.setVisibility(0);
        this.iTv.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSl() {
        this.nJx = 1;
        dSH();
        t(this.nJl, this.nJo);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSm() {
        this.nJx = 2;
        dSI();
        t(this.nJm, this.ftX);
    }

    public void setListener(final a aVar) {
        if (this.nJj != null) {
            this.nJj.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nJo = eVar.getName();
                                VideoEffectLayout.this.nJq = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.ftX = eVar.getName();
                                VideoEffectLayout.this.nJr = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nJp = eVar.getName();
                                VideoEffectLayout.this.nJs = eVar;
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
        if (this.nJk != null) {
            this.nJk.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nJt = stickerItem;
        if (!x.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nJk != null) {
                this.nJk.notifyDataSetChanged();
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
            if (this.nJk != null) {
                this.nJk.notifyDataSetChanged();
            }
        }
    }

    private void t(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nJj.c(list, str);
                    VideoEffectLayout.this.nJj.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nJi.getVisibility() == 0) {
                runnable.run();
                yO(false);
            } else {
                dSJ();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iTv.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nJx;
    }

    public e<String> getCurrentFilterItem() {
        return this.nJr;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nJq;
    }

    public StickerItem getCurrentStickItem() {
        return this.nJt;
    }

    private void dSJ() {
        if (this.nJv != null && this.nJv.isRunning()) {
            this.nJv.cancel();
        }
        if (this.nJu == null) {
            this.nJu = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iTv, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iTv, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nJu.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iTv.setVisibility(0);
        this.nJu.start();
    }

    private void yO(boolean z) {
        if (z) {
            if (this.nJw != null && this.nJw.isRunning()) {
                this.nJw.cancel();
            }
            if (this.nJu != null && this.nJu.isRunning()) {
                this.nJu.cancel();
            }
            if (this.nJv == null) {
                this.nJv = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iTv, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nJi, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nJi != null) {
                            VideoEffectLayout.this.nJi.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nJG && VideoEffectLayout.this.iTv != null) {
                            VideoEffectLayout.this.iTv.setVisibility(8);
                        }
                    }
                });
                this.nJv.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nJv.start();
            return;
        }
        if (this.nJv != null && this.nJv.isRunning()) {
            this.nJv.cancel();
        }
        if (this.nJw == null) {
            this.nJw = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nJi, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iTv, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iTv != null) {
                        VideoEffectLayout.this.iTv.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nJG && VideoEffectLayout.this.nJi != null) {
                        VideoEffectLayout.this.nJi.setVisibility(8);
                    }
                }
            });
            this.nJw.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nJw.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nJk != null) {
            this.nJk.bs(list);
            this.nJk.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nJn == null) {
            this.nJn = new ArrayList();
        } else {
            this.nJn.clear();
        }
        this.nJn.addAll(list);
    }

    public boolean dSE() {
        if (x.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dSF() {
        if (this.nJj != null) {
            this.nJj.dRr();
            this.nJp = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dRs() {
        if (this.nJj != null) {
            this.nJj.dRs();
        }
    }
}
