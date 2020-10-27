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
    private String fcz;
    private HListView iul;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private AnimatorSet npA;
    private AnimatorSet npB;
    private int npC;
    private HListView npn;
    private d npo;
    private k npp;
    private List<e> npq;
    private List<e> npr;
    private List<e> nps;
    private String npt;
    private String npu;
    private e<com.baidu.tieba.video.a> npv;
    private e<String> npw;
    private e<MusicData> npx;
    private StickerItem npy;
    private AnimatorSet npz;

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
        dOY();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iul = (HListView) findViewById(R.id.effect_list_view);
        this.iul.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iul.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.npn = (HListView) findViewById(R.id.sticker_list_view);
        this.npn.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.npo = new d();
        this.iul.setAdapter((ListAdapter) this.npo);
        this.npp = new k();
        this.npn.setAdapter((ListAdapter) this.npp);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.KB(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dOY() {
        this.npt = "2";
        this.npv = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Kk(2));
        this.fcz = getString(R.string.filter_nature);
        this.npw = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.npy = stickerItem;
        this.npu = getResources().getString(R.string.music_normal);
        this.npx = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dOZ() {
        if (this.npq == null) {
            this.npq = new ArrayList();
            a("No", com.baidu.tieba.video.a.Kk(0));
            a("1", com.baidu.tieba.video.a.Kk(1));
            a("2", com.baidu.tieba.video.a.Kk(2));
            a("3", com.baidu.tieba.video.a.Kk(3));
            a("4", com.baidu.tieba.video.a.Kk(4));
            a("5", com.baidu.tieba.video.a.Kk(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.npq.add(b(0, 1, str, aVar));
    }

    private void dPa() {
        if (this.npr == null) {
            this.npr = new ArrayList();
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
        if (this.npr != null) {
            this.npr.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOB() {
        this.npC = 3;
        q(this.nps, this.npu);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOC() {
        this.npC = 0;
        this.npn.setAdapter((ListAdapter) this.npp);
        this.npp.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            xX(true);
            return;
        }
        this.npn.setVisibility(0);
        this.iul.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOD() {
        this.npC = 1;
        dOZ();
        q(this.npq, this.npt);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOE() {
        this.npC = 2;
        dPa();
        q(this.npr, this.fcz);
    }

    public void setListener(final a aVar) {
        if (this.npo != null) {
            this.npo.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.npt = eVar.getName();
                                VideoEffectLayout.this.npv = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.fcz = eVar.getName();
                                VideoEffectLayout.this.npw = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.npu = eVar.getName();
                                VideoEffectLayout.this.npx = eVar;
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
        if (this.npp != null) {
            this.npp.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.npy = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.npp != null) {
                this.npp.notifyDataSetChanged();
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
            if (this.npp != null) {
                this.npp.notifyDataSetChanged();
            }
        }
    }

    private void q(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.npo.c(list, str);
                    VideoEffectLayout.this.npo.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.npn.getVisibility() == 0) {
                runnable.run();
                xX(false);
            } else {
                dPb();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iul.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.npC;
    }

    public e<String> getCurrentFilterItem() {
        return this.npw;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.npv;
    }

    public StickerItem getCurrentStickItem() {
        return this.npy;
    }

    private void dPb() {
        if (this.npA != null && this.npA.isRunning()) {
            this.npA.cancel();
        }
        if (this.npz == null) {
            this.npz = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iul, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iul, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.npz.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iul.setVisibility(0);
        this.npz.start();
    }

    private void xX(boolean z) {
        if (z) {
            if (this.npB != null && this.npB.isRunning()) {
                this.npB.cancel();
            }
            if (this.npz != null && this.npz.isRunning()) {
                this.npz.cancel();
            }
            if (this.npA == null) {
                this.npA = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iul, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.npn, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.npn != null) {
                            VideoEffectLayout.this.npn.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.npL && VideoEffectLayout.this.iul != null) {
                            VideoEffectLayout.this.iul.setVisibility(8);
                        }
                    }
                });
                this.npA.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.npA.start();
            return;
        }
        if (this.npA != null && this.npA.isRunning()) {
            this.npA.cancel();
        }
        if (this.npB == null) {
            this.npB = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.npn, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iul, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iul != null) {
                        VideoEffectLayout.this.iul.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.npL && VideoEffectLayout.this.npn != null) {
                        VideoEffectLayout.this.npn.setVisibility(8);
                    }
                }
            });
            this.npB.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.npB.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.npp != null) {
            this.npp.bb(list);
            this.npp.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nps == null) {
            this.nps = new ArrayList();
        } else {
            this.nps.clear();
        }
        this.nps.addAll(list);
    }

    public boolean dOW() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dOX() {
        if (this.npo != null) {
            this.npo.dNK();
            this.npu = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dNL() {
        if (this.npo != null) {
            this.npo.dNL();
        }
    }
}
