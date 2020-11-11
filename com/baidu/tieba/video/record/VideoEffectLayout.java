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
    private String fir;
    private HListView iAi;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView nvi;
    private d nvj;
    private k nvk;
    private List<e> nvl;
    private List<e> nvm;
    private List<e> nvn;
    private String nvo;
    private String nvp;
    private e<com.baidu.tieba.video.a> nvq;
    private e<String> nvr;
    private e<MusicData> nvs;
    private StickerItem nvt;
    private AnimatorSet nvu;
    private AnimatorSet nvv;
    private AnimatorSet nvw;
    private int nvx;

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
        dRA();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iAi = (HListView) findViewById(R.id.effect_list_view);
        this.iAi.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iAi.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nvi = (HListView) findViewById(R.id.sticker_list_view);
        this.nvi.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nvj = new d();
        this.iAi.setAdapter((ListAdapter) this.nvj);
        this.nvk = new k();
        this.nvi.setAdapter((ListAdapter) this.nvk);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.KO(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dRA() {
        this.nvo = "2";
        this.nvq = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Kx(2));
        this.fir = getString(R.string.filter_nature);
        this.nvr = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nvt = stickerItem;
        this.nvp = getResources().getString(R.string.music_normal);
        this.nvs = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dRB() {
        if (this.nvl == null) {
            this.nvl = new ArrayList();
            a("No", com.baidu.tieba.video.a.Kx(0));
            a("1", com.baidu.tieba.video.a.Kx(1));
            a("2", com.baidu.tieba.video.a.Kx(2));
            a("3", com.baidu.tieba.video.a.Kx(3));
            a("4", com.baidu.tieba.video.a.Kx(4));
            a("5", com.baidu.tieba.video.a.Kx(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nvl.add(b(0, 1, str, aVar));
    }

    private void dRC() {
        if (this.nvm == null) {
            this.nvm = new ArrayList();
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
        if (this.nvm != null) {
            this.nvm.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRd() {
        this.nvx = 3;
        r(this.nvn, this.nvp);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRe() {
        this.nvx = 0;
        this.nvi.setAdapter((ListAdapter) this.nvk);
        this.nvk.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            yg(true);
            return;
        }
        this.nvi.setVisibility(0);
        this.iAi.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRf() {
        this.nvx = 1;
        dRB();
        r(this.nvl, this.nvo);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRg() {
        this.nvx = 2;
        dRC();
        r(this.nvm, this.fir);
    }

    public void setListener(final a aVar) {
        if (this.nvj != null) {
            this.nvj.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nvo = eVar.getName();
                                VideoEffectLayout.this.nvq = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.fir = eVar.getName();
                                VideoEffectLayout.this.nvr = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nvp = eVar.getName();
                                VideoEffectLayout.this.nvs = eVar;
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
        if (this.nvk != null) {
            this.nvk.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nvt = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nvk != null) {
                this.nvk.notifyDataSetChanged();
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
            if (this.nvk != null) {
                this.nvk.notifyDataSetChanged();
            }
        }
    }

    private void r(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nvj.c(list, str);
                    VideoEffectLayout.this.nvj.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nvi.getVisibility() == 0) {
                runnable.run();
                yg(false);
            } else {
                dRD();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iAi.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nvx;
    }

    public e<String> getCurrentFilterItem() {
        return this.nvr;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nvq;
    }

    public StickerItem getCurrentStickItem() {
        return this.nvt;
    }

    private void dRD() {
        if (this.nvv != null && this.nvv.isRunning()) {
            this.nvv.cancel();
        }
        if (this.nvu == null) {
            this.nvu = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iAi, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iAi, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nvu.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iAi.setVisibility(0);
        this.nvu.start();
    }

    private void yg(boolean z) {
        if (z) {
            if (this.nvw != null && this.nvw.isRunning()) {
                this.nvw.cancel();
            }
            if (this.nvu != null && this.nvu.isRunning()) {
                this.nvu.cancel();
            }
            if (this.nvv == null) {
                this.nvv = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iAi, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nvi, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nvi != null) {
                            VideoEffectLayout.this.nvi.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nvG && VideoEffectLayout.this.iAi != null) {
                            VideoEffectLayout.this.iAi.setVisibility(8);
                        }
                    }
                });
                this.nvv.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nvv.start();
            return;
        }
        if (this.nvv != null && this.nvv.isRunning()) {
            this.nvv.cancel();
        }
        if (this.nvw == null) {
            this.nvw = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nvi, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iAi, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iAi != null) {
                        VideoEffectLayout.this.iAi.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nvG && VideoEffectLayout.this.nvi != null) {
                        VideoEffectLayout.this.nvi.setVisibility(8);
                    }
                }
            });
            this.nvw.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nvw.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nvk != null) {
            this.nvk.bi(list);
            this.nvk.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nvn == null) {
            this.nvn = new ArrayList();
        } else {
            this.nvn.clear();
        }
        this.nvn.addAll(list);
    }

    public boolean dRy() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dRz() {
        if (this.nvj != null) {
            this.nvj.dQm();
            this.nvp = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dQn() {
        if (this.nvj != null) {
            this.nvj.dQn();
        }
    }
}
