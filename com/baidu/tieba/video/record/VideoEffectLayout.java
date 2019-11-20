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
    private String czp;
    private HListView fnH;
    private HListView jFE;
    private d jFF;
    private k jFG;
    private List<e> jFH;
    private List<e> jFI;
    private List<e> jFJ;
    private String jFK;
    private String jFL;
    private e<com.baidu.tieba.video.a> jFM;
    private e<String> jFN;
    private e<MusicData> jFO;
    private StickerItem jFP;
    private AnimatorSet jFQ;
    private AnimatorSet jFR;
    private AnimatorSet jFS;
    private int jFT;
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
        cvS();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.fnH = (HListView) findViewById(R.id.effect_list_view);
        this.fnH.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.fnH.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jFE = (HListView) findViewById(R.id.sticker_list_view);
        this.jFE.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.jFF = new d();
        this.fnH.setAdapter((ListAdapter) this.jFF);
        this.jFG = new k();
        this.jFE.setAdapter((ListAdapter) this.jFG);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.AY(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cvS() {
        this.jFK = "2";
        this.jFM = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.AI(2));
        this.czp = getString(R.string.filter_nature);
        this.jFN = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.jFP = stickerItem;
        this.jFL = getResources().getString(R.string.music_normal);
        this.jFO = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cvT() {
        if (this.jFH == null) {
            this.jFH = new ArrayList();
            a("No", com.baidu.tieba.video.a.AI(0));
            a("1", com.baidu.tieba.video.a.AI(1));
            a("2", com.baidu.tieba.video.a.AI(2));
            a("3", com.baidu.tieba.video.a.AI(3));
            a("4", com.baidu.tieba.video.a.AI(4));
            a("5", com.baidu.tieba.video.a.AI(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.jFH.add(b(0, 1, str, aVar));
    }

    private void cvU() {
        if (this.jFI == null) {
            this.jFI = new ArrayList();
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
        if (this.jFI != null) {
            this.jFI.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvv() {
        this.jFT = 3;
        l(this.jFJ, this.jFL);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvw() {
        this.jFT = 0;
        this.jFE.setAdapter((ListAdapter) this.jFG);
        this.jFG.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            rB(true);
            return;
        }
        this.jFE.setVisibility(0);
        this.fnH.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        this.jFT = 1;
        cvT();
        l(this.jFH, this.jFK);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        this.jFT = 2;
        cvU();
        l(this.jFI, this.czp);
    }

    public void setListener(final a aVar) {
        if (this.jFF != null) {
            this.jFF.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.jFK = eVar.getName();
                                VideoEffectLayout.this.jFM = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.czp = eVar.getName();
                                VideoEffectLayout.this.jFN = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.jFL = eVar.getName();
                                VideoEffectLayout.this.jFO = eVar;
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
        if (this.jFG != null) {
            this.jFG.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.jFP = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.jFG != null) {
                this.jFG.notifyDataSetChanged();
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
            if (this.jFG != null) {
                this.jFG.notifyDataSetChanged();
            }
        }
    }

    private void l(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.jFF.b(list, str);
                    VideoEffectLayout.this.jFF.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.jFE.getVisibility() == 0) {
                runnable.run();
                rB(false);
            } else {
                cvV();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.fnH.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.jFT;
    }

    public e<String> getCurrentFilterItem() {
        return this.jFN;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.jFM;
    }

    public StickerItem getCurrentStickItem() {
        return this.jFP;
    }

    private void cvV() {
        if (this.jFR != null && this.jFR.isRunning()) {
            this.jFR.cancel();
        }
        if (this.jFQ == null) {
            this.jFQ = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fnH, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.fnH, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.jFQ.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.fnH.setVisibility(0);
        this.jFQ.start();
    }

    private void rB(boolean z) {
        if (z) {
            if (this.jFS != null && this.jFS.isRunning()) {
                this.jFS.cancel();
            }
            if (this.jFQ != null && this.jFQ.isRunning()) {
                this.jFQ.cancel();
            }
            if (this.jFR == null) {
                this.jFR = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fnH, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.jFE, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.jFE != null) {
                            VideoEffectLayout.this.jFE.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.jGc && VideoEffectLayout.this.fnH != null) {
                            VideoEffectLayout.this.fnH.setVisibility(8);
                        }
                    }
                });
                this.jFR.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.jFR.start();
            return;
        }
        if (this.jFR != null && this.jFR.isRunning()) {
            this.jFR.cancel();
        }
        if (this.jFS == null) {
            this.jFS = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.jFE, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.fnH, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.fnH != null) {
                        VideoEffectLayout.this.fnH.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGc && VideoEffectLayout.this.jFE != null) {
                        VideoEffectLayout.this.jFE.setVisibility(8);
                    }
                }
            });
            this.jFS.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.jFS.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.jFG != null) {
            this.jFG.aq(list);
            this.jFG.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.jFJ == null) {
            this.jFJ = new ArrayList();
        } else {
            this.jFJ.clear();
        }
        this.jFJ.addAll(list);
    }

    public boolean cvQ() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cvR() {
        if (this.jFF != null) {
            this.jFF.cuC();
            this.jFL = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cuD() {
        if (this.jFF != null) {
            this.jFF.cuD();
        }
    }
}
