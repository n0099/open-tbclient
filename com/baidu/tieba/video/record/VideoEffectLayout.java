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
/* loaded from: classes22.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String eHV;
    private HListView hSO;
    private Handler mHandler;
    private HListView mNf;
    private d mNg;
    private k mNh;
    private List<e> mNi;
    private List<e> mNj;
    private List<e> mNk;
    private String mNl;
    private String mNm;
    private e<com.baidu.tieba.video.a> mNn;
    private e<String> mNo;
    private e<MusicData> mNp;
    private StickerItem mNq;
    private AnimatorSet mNr;
    private AnimatorSet mNs;
    private AnimatorSet mNt;
    private int mNu;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes22.dex */
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
        dIe();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hSO = (HListView) findViewById(R.id.effect_list_view);
        this.hSO.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hSO.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mNf = (HListView) findViewById(R.id.sticker_list_view);
        this.mNf.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mNg = new d();
        this.hSO.setAdapter((ListAdapter) this.mNg);
        this.mNh = new k();
        this.mNf.setAdapter((ListAdapter) this.mNh);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.JD(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dIe() {
        this.mNl = "2";
        this.mNn = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Jm(2));
        this.eHV = getString(R.string.filter_nature);
        this.mNo = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mNq = stickerItem;
        this.mNm = getResources().getString(R.string.music_normal);
        this.mNp = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dIf() {
        if (this.mNi == null) {
            this.mNi = new ArrayList();
            a("No", com.baidu.tieba.video.a.Jm(0));
            a("1", com.baidu.tieba.video.a.Jm(1));
            a("2", com.baidu.tieba.video.a.Jm(2));
            a("3", com.baidu.tieba.video.a.Jm(3));
            a("4", com.baidu.tieba.video.a.Jm(4));
            a("5", com.baidu.tieba.video.a.Jm(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mNi.add(b(0, 1, str, aVar));
    }

    private void dIg() {
        if (this.mNj == null) {
            this.mNj = new ArrayList();
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
        if (this.mNj != null) {
            this.mNj.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHH() {
        this.mNu = 3;
        o(this.mNk, this.mNm);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHI() {
        this.mNu = 0;
        this.mNf.setAdapter((ListAdapter) this.mNh);
        this.mNh.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            wZ(true);
            return;
        }
        this.mNf.setVisibility(0);
        this.hSO.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHJ() {
        this.mNu = 1;
        dIf();
        o(this.mNi, this.mNl);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHK() {
        this.mNu = 2;
        dIg();
        o(this.mNj, this.eHV);
    }

    public void setListener(final a aVar) {
        if (this.mNg != null) {
            this.mNg.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.mNl = eVar.getName();
                                VideoEffectLayout.this.mNn = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eHV = eVar.getName();
                                VideoEffectLayout.this.mNo = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.mNm = eVar.getName();
                                VideoEffectLayout.this.mNp = eVar;
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
        if (this.mNh != null) {
            this.mNh.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mNq = stickerItem;
        if (!y.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mNh != null) {
                this.mNh.notifyDataSetChanged();
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
            if (this.mNh != null) {
                this.mNh.notifyDataSetChanged();
            }
        }
    }

    private void o(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mNg.b(list, str);
                    VideoEffectLayout.this.mNg.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mNf.getVisibility() == 0) {
                runnable.run();
                wZ(false);
            } else {
                dIh();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hSO.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.mNu;
    }

    public e<String> getCurrentFilterItem() {
        return this.mNo;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mNn;
    }

    public StickerItem getCurrentStickItem() {
        return this.mNq;
    }

    private void dIh() {
        if (this.mNs != null && this.mNs.isRunning()) {
            this.mNs.cancel();
        }
        if (this.mNr == null) {
            this.mNr = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hSO, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hSO, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.mNr.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hSO.setVisibility(0);
        this.mNr.start();
    }

    private void wZ(boolean z) {
        if (z) {
            if (this.mNt != null && this.mNt.isRunning()) {
                this.mNt.cancel();
            }
            if (this.mNr != null && this.mNr.isRunning()) {
                this.mNr.cancel();
            }
            if (this.mNs == null) {
                this.mNs = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hSO, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mNf, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mNf != null) {
                            VideoEffectLayout.this.mNf.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mND && VideoEffectLayout.this.hSO != null) {
                            VideoEffectLayout.this.hSO.setVisibility(8);
                        }
                    }
                });
                this.mNs.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.mNs.start();
            return;
        }
        if (this.mNs != null && this.mNs.isRunning()) {
            this.mNs.cancel();
        }
        if (this.mNt == null) {
            this.mNt = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mNf, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hSO, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hSO != null) {
                        VideoEffectLayout.this.hSO.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mND && VideoEffectLayout.this.mNf != null) {
                        VideoEffectLayout.this.mNf.setVisibility(8);
                    }
                }
            });
            this.mNt.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mNt.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mNh != null) {
            this.mNh.aO(list);
            this.mNh.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mNk == null) {
            this.mNk = new ArrayList();
        } else {
            this.mNk.clear();
        }
        this.mNk.addAll(list);
    }

    public boolean dIc() {
        if (y.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dId() {
        if (this.mNg != null) {
            this.mNg.dGQ();
            this.mNm = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dGR() {
        if (this.mNg != null) {
            this.mNg.dGR();
        }
    }
}
