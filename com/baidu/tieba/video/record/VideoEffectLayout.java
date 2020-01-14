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
/* loaded from: classes8.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String dng;
    private HListView gfp;
    private HListView kCU;
    private d kCV;
    private k kCW;
    private List<e> kCX;
    private List<e> kCY;
    private List<e> kCZ;
    private String kDa;
    private String kDb;
    private e<com.baidu.tieba.video.a> kDc;
    private e<String> kDd;
    private e<MusicData> kDe;
    private StickerItem kDf;
    private AnimatorSet kDg;
    private AnimatorSet kDh;
    private AnimatorSet kDi;
    private int kDj;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

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
        cQO();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gfp = (HListView) findViewById(R.id.effect_list_view);
        this.gfp.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gfp.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kCU = (HListView) findViewById(R.id.sticker_list_view);
        this.kCU.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kCV = new d();
        this.gfp.setAdapter((ListAdapter) this.kCV);
        this.kCW = new k();
        this.kCU.setAdapter((ListAdapter) this.kCW);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Dz(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cQO() {
        this.kDa = "2";
        this.kDc = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dj(2));
        this.dng = getString(R.string.filter_nature);
        this.kDd = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kDf = stickerItem;
        this.kDb = getResources().getString(R.string.music_normal);
        this.kDe = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cQP() {
        if (this.kCX == null) {
            this.kCX = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dj(0));
            a("1", com.baidu.tieba.video.a.Dj(1));
            a("2", com.baidu.tieba.video.a.Dj(2));
            a("3", com.baidu.tieba.video.a.Dj(3));
            a("4", com.baidu.tieba.video.a.Dj(4));
            a("5", com.baidu.tieba.video.a.Dj(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kCX.add(b(0, 1, str, aVar));
    }

    private void cQQ() {
        if (this.kCY == null) {
            this.kCY = new ArrayList();
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
        if (this.kCY != null) {
            this.kCY.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        this.kDj = 3;
        m(this.kCZ, this.kDb);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        this.kDj = 0;
        this.kCU.setAdapter((ListAdapter) this.kCW);
        this.kCW.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tt(true);
            return;
        }
        this.kCU.setVisibility(0);
        this.gfp.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQt() {
        this.kDj = 1;
        cQP();
        m(this.kCX, this.kDa);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQu() {
        this.kDj = 2;
        cQQ();
        m(this.kCY, this.dng);
    }

    public void setListener(final a aVar) {
        if (this.kCV != null) {
            this.kCV.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kDa = eVar.getName();
                                VideoEffectLayout.this.kDc = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.dng = eVar.getName();
                                VideoEffectLayout.this.kDd = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kDb = eVar.getName();
                                VideoEffectLayout.this.kDe = eVar;
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
        if (this.kCW != null) {
            this.kCW.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kDf = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kCW != null) {
                this.kCW.notifyDataSetChanged();
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
            if (this.kCW != null) {
                this.kCW.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kCV.b(list, str);
                    VideoEffectLayout.this.kCV.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kCU.getVisibility() == 0) {
                runnable.run();
                tt(false);
            } else {
                cQR();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.gfp.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.kDj;
    }

    public e<String> getCurrentFilterItem() {
        return this.kDd;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kDc;
    }

    public StickerItem getCurrentStickItem() {
        return this.kDf;
    }

    private void cQR() {
        if (this.kDh != null && this.kDh.isRunning()) {
            this.kDh.cancel();
        }
        if (this.kDg == null) {
            this.kDg = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfp, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gfp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kDg.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gfp.setVisibility(0);
        this.kDg.start();
    }

    private void tt(boolean z) {
        if (z) {
            if (this.kDi != null && this.kDi.isRunning()) {
                this.kDi.cancel();
            }
            if (this.kDg != null && this.kDg.isRunning()) {
                this.kDg.cancel();
            }
            if (this.kDh == null) {
                this.kDh = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfp, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kCU, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kCU != null) {
                            VideoEffectLayout.this.kCU.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kDs && VideoEffectLayout.this.gfp != null) {
                            VideoEffectLayout.this.gfp.setVisibility(8);
                        }
                    }
                });
                this.kDh.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kDh.start();
            return;
        }
        if (this.kDh != null && this.kDh.isRunning()) {
            this.kDh.cancel();
        }
        if (this.kDi == null) {
            this.kDi = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kCU, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.gfp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.gfp != null) {
                        VideoEffectLayout.this.gfp.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDs && VideoEffectLayout.this.kCU != null) {
                        VideoEffectLayout.this.kCU.setVisibility(8);
                    }
                }
            });
            this.kDi.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kDi.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kCW != null) {
            this.kCW.av(list);
            this.kCW.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kCZ == null) {
            this.kCZ = new ArrayList();
        } else {
            this.kCZ.clear();
        }
        this.kCZ.addAll(list);
    }

    public boolean cQM() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cQN() {
        if (this.kCV != null) {
            this.kCV.cPD();
            this.kDb = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cPE() {
        if (this.kCV != null) {
            this.kCV.cPE();
        }
    }
}
