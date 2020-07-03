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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String eoX;
    private HListView hsG;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;
    private HListView mdU;
    private d mdV;
    private k mdW;
    private List<e> mdX;
    private List<e> mdY;
    private List<e> mdZ;
    private String mea;
    private String meb;
    private e<com.baidu.tieba.video.a> mec;
    private e<String> med;
    private e<MusicData> mee;
    private StickerItem mef;
    private AnimatorSet meg;
    private AnimatorSet meh;
    private AnimatorSet mei;
    private int mej;

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
        dps();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hsG = (HListView) findViewById(R.id.effect_list_view);
        this.hsG.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hsG.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdU = (HListView) findViewById(R.id.sticker_list_view);
        this.mdU.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdV = new d();
        this.hsG.setAdapter((ListAdapter) this.mdV);
        this.mdW = new k();
        this.mdU.setAdapter((ListAdapter) this.mdW);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Gh(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dps() {
        this.mea = "2";
        this.mec = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.FQ(2));
        this.eoX = getString(R.string.filter_nature);
        this.med = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mef = stickerItem;
        this.meb = getResources().getString(R.string.music_normal);
        this.mee = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dpt() {
        if (this.mdX == null) {
            this.mdX = new ArrayList();
            a("No", com.baidu.tieba.video.a.FQ(0));
            a("1", com.baidu.tieba.video.a.FQ(1));
            a("2", com.baidu.tieba.video.a.FQ(2));
            a("3", com.baidu.tieba.video.a.FQ(3));
            a("4", com.baidu.tieba.video.a.FQ(4));
            a("5", com.baidu.tieba.video.a.FQ(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mdX.add(b(0, 1, str, aVar));
    }

    private void dpu() {
        if (this.mdY == null) {
            this.mdY = new ArrayList();
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
        if (this.mdY != null) {
            this.mdY.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doV() {
        this.mej = 3;
        m(this.mdZ, this.meb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doW() {
        this.mej = 0;
        this.mdU.setAdapter((ListAdapter) this.mdW);
        this.mdW.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            vv(true);
            return;
        }
        this.mdU.setVisibility(0);
        this.hsG.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doX() {
        this.mej = 1;
        dpt();
        m(this.mdX, this.mea);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doY() {
        this.mej = 2;
        dpu();
        m(this.mdY, this.eoX);
    }

    public void setListener(final a aVar) {
        if (this.mdV != null) {
            this.mdV.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.mea = eVar.getName();
                                VideoEffectLayout.this.mec = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eoX = eVar.getName();
                                VideoEffectLayout.this.med = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.meb = eVar.getName();
                                VideoEffectLayout.this.mee = eVar;
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
        if (this.mdW != null) {
            this.mdW.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mef = stickerItem;
        if (!w.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mdW != null) {
                this.mdW.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!w.isEmpty(this.mStickerItems)) {
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
            if (this.mdW != null) {
                this.mdW.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mdV.b(list, str);
                    VideoEffectLayout.this.mdV.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mdU.getVisibility() == 0) {
                runnable.run();
                vv(false);
            } else {
                dpv();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hsG.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.mej;
    }

    public e<String> getCurrentFilterItem() {
        return this.med;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mec;
    }

    public StickerItem getCurrentStickItem() {
        return this.mef;
    }

    private void dpv() {
        if (this.meh != null && this.meh.isRunning()) {
            this.meh.cancel();
        }
        if (this.meg == null) {
            this.meg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hsG, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hsG, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.meg.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hsG.setVisibility(0);
        this.meg.start();
    }

    private void vv(boolean z) {
        if (z) {
            if (this.mei != null && this.mei.isRunning()) {
                this.mei.cancel();
            }
            if (this.meg != null && this.meg.isRunning()) {
                this.meg.cancel();
            }
            if (this.meh == null) {
                this.meh = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hsG, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mdU, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mdU != null) {
                            VideoEffectLayout.this.mdU.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mes && VideoEffectLayout.this.hsG != null) {
                            VideoEffectLayout.this.hsG.setVisibility(8);
                        }
                    }
                });
                this.meh.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.meh.start();
            return;
        }
        if (this.meh != null && this.meh.isRunning()) {
            this.meh.cancel();
        }
        if (this.mei == null) {
            this.mei = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mdU, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hsG, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hsG != null) {
                        VideoEffectLayout.this.hsG.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mes && VideoEffectLayout.this.mdU != null) {
                        VideoEffectLayout.this.mdU.setVisibility(8);
                    }
                }
            });
            this.mei.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mei.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mdW != null) {
            this.mdW.aD(list);
            this.mdW.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mdZ == null) {
            this.mdZ = new ArrayList();
        } else {
            this.mdZ.clear();
        }
        this.mdZ.addAll(list);
    }

    public boolean dpq() {
        if (w.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dpr() {
        if (this.mdV != null) {
            this.mdV.doe();
            this.meb = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void dof() {
        if (this.mdV != null) {
            this.mdV.dof();
        }
    }
}
