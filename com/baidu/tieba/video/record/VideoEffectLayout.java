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
/* loaded from: classes8.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String fwn;
    private HListView iZq;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private StickerItem nTA;
    private AnimatorSet nTB;
    private AnimatorSet nTC;
    private AnimatorSet nTD;
    private int nTE;
    private HListView nTp;
    private d nTq;
    private k nTr;
    private List<e> nTs;
    private List<e> nTt;
    private List<e> nTu;
    private String nTv;
    private String nTw;
    private e<com.baidu.tieba.video.a> nTx;
    private e<String> nTy;
    private e<MusicData> nTz;

    /* loaded from: classes8.dex */
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
        dUZ();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.iZq = (HListView) findViewById(R.id.effect_list_view);
        this.iZq.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.iZq.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nTp = (HListView) findViewById(R.id.sticker_list_view);
        this.nTp.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.nTq = new d();
        this.iZq.setAdapter((ListAdapter) this.nTq);
        this.nTr = new k();
        this.nTp.setAdapter((ListAdapter) this.nTr);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.KJ(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dUZ() {
        this.nTv = "2";
        this.nTx = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Kt(2));
        this.fwn = getString(R.string.filter_nature);
        this.nTy = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.nTA = stickerItem;
        this.nTw = getResources().getString(R.string.music_normal);
        this.nTz = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dVa() {
        if (this.nTs == null) {
            this.nTs = new ArrayList();
            a("No", com.baidu.tieba.video.a.Kt(0));
            a("1", com.baidu.tieba.video.a.Kt(1));
            a("2", com.baidu.tieba.video.a.Kt(2));
            a("3", com.baidu.tieba.video.a.Kt(3));
            a("4", com.baidu.tieba.video.a.Kt(4));
            a("5", com.baidu.tieba.video.a.Kt(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.nTs.add(b(0, 1, str, aVar));
    }

    private void dVb() {
        if (this.nTt == null) {
            this.nTt = new ArrayList();
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
        if (this.nTt != null) {
            this.nTt.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUC() {
        this.nTE = 3;
        r(this.nTu, this.nTw);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUD() {
        this.nTE = 0;
        this.nTp.setAdapter((ListAdapter) this.nTr);
        this.nTr.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            zh(true);
            return;
        }
        this.nTp.setVisibility(0);
        this.iZq.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUE() {
        this.nTE = 1;
        dVa();
        r(this.nTs, this.nTv);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUF() {
        this.nTE = 2;
        dVb();
        r(this.nTt, this.fwn);
    }

    public void setListener(final a aVar) {
        if (this.nTq != null) {
            this.nTq.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.nTv = eVar.getName();
                                VideoEffectLayout.this.nTx = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.fwn = eVar.getName();
                                VideoEffectLayout.this.nTy = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.nTw = eVar.getName();
                                VideoEffectLayout.this.nTz = eVar;
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
        if (this.nTr != null) {
            this.nTr.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.nTA = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.nTr != null) {
                this.nTr.notifyDataSetChanged();
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
            if (this.nTr != null) {
                this.nTr.notifyDataSetChanged();
            }
        }
    }

    private void r(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.nTq.setData(list, str);
                    VideoEffectLayout.this.nTq.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.nTp.getVisibility() == 0) {
                runnable.run();
                zh(false);
            } else {
                dVc();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.iZq.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.nTE;
    }

    public e<String> getCurrentFilterItem() {
        return this.nTy;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.nTx;
    }

    public StickerItem getCurrentStickItem() {
        return this.nTA;
    }

    private void dVc() {
        if (this.nTC != null && this.nTC.isRunning()) {
            this.nTC.cancel();
        }
        if (this.nTB == null) {
            this.nTB = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iZq, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.iZq, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.nTB.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.iZq.setVisibility(0);
        this.nTB.start();
    }

    private void zh(boolean z) {
        if (z) {
            if (this.nTD != null && this.nTD.isRunning()) {
                this.nTD.cancel();
            }
            if (this.nTB != null && this.nTB.isRunning()) {
                this.nTB.cancel();
            }
            if (this.nTC == null) {
                this.nTC = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iZq, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.nTp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.nTp != null) {
                            VideoEffectLayout.this.nTp.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.nTN && VideoEffectLayout.this.iZq != null) {
                            VideoEffectLayout.this.iZq.setVisibility(8);
                        }
                    }
                });
                this.nTC.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.nTC.start();
            return;
        }
        if (this.nTC != null && this.nTC.isRunning()) {
            this.nTC.cancel();
        }
        if (this.nTD == null) {
            this.nTD = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nTp, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.iZq, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.iZq != null) {
                        VideoEffectLayout.this.iZq.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTN && VideoEffectLayout.this.nTp != null) {
                        VideoEffectLayout.this.nTp.setVisibility(8);
                    }
                }
            });
            this.nTD.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.nTD.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.nTr != null) {
            this.nTr.bn(list);
            this.nTr.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.nTu == null) {
            this.nTu = new ArrayList();
        } else {
            this.nTu.clear();
        }
        this.nTu.addAll(list);
    }

    public boolean dUX() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dUY() {
        if (this.nTq != null) {
            this.nTq.dTK();
            this.nTw = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dTL() {
        if (this.nTq != null) {
            this.nTq.dTL();
        }
    }
}
