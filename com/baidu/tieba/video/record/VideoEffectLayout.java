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
    private HListView kCP;
    private d kCQ;
    private k kCR;
    private List<e> kCS;
    private List<e> kCT;
    private List<e> kCU;
    private String kCV;
    private String kCW;
    private e<com.baidu.tieba.video.a> kCX;
    private e<String> kCY;
    private e<MusicData> kCZ;
    private StickerItem kDa;
    private AnimatorSet kDb;
    private AnimatorSet kDc;
    private AnimatorSet kDd;
    private int kDe;
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
        cQM();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.gfp = (HListView) findViewById(R.id.effect_list_view);
        this.gfp.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.gfp.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kCP = (HListView) findViewById(R.id.sticker_list_view);
        this.kCP.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.kCQ = new d();
        this.gfp.setAdapter((ListAdapter) this.kCQ);
        this.kCR = new k();
        this.kCP.setAdapter((ListAdapter) this.kCR);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Dz(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void cQM() {
        this.kCV = "2";
        this.kCX = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.Dj(2));
        this.dng = getString(R.string.filter_nature);
        this.kCY = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.kDa = stickerItem;
        this.kCW = getResources().getString(R.string.music_normal);
        this.kCZ = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void cQN() {
        if (this.kCS == null) {
            this.kCS = new ArrayList();
            a("No", com.baidu.tieba.video.a.Dj(0));
            a("1", com.baidu.tieba.video.a.Dj(1));
            a("2", com.baidu.tieba.video.a.Dj(2));
            a("3", com.baidu.tieba.video.a.Dj(3));
            a("4", com.baidu.tieba.video.a.Dj(4));
            a("5", com.baidu.tieba.video.a.Dj(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.kCS.add(b(0, 1, str, aVar));
    }

    private void cQO() {
        if (this.kCT == null) {
            this.kCT = new ArrayList();
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
        if (this.kCT != null) {
            this.kCT.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQp() {
        this.kDe = 3;
        m(this.kCU, this.kCW);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQq() {
        this.kDe = 0;
        this.kCP.setAdapter((ListAdapter) this.kCR);
        this.kCR.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            tt(true);
            return;
        }
        this.kCP.setVisibility(0);
        this.gfp.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        this.kDe = 1;
        cQN();
        m(this.kCS, this.kCV);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        this.kDe = 2;
        cQO();
        m(this.kCT, this.dng);
    }

    public void setListener(final a aVar) {
        if (this.kCQ != null) {
            this.kCQ.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.kCV = eVar.getName();
                                VideoEffectLayout.this.kCX = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.dng = eVar.getName();
                                VideoEffectLayout.this.kCY = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.kCW = eVar.getName();
                                VideoEffectLayout.this.kCZ = eVar;
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
        if (this.kCR != null) {
            this.kCR.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.kDa = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.kCR != null) {
                this.kCR.notifyDataSetChanged();
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
            if (this.kCR != null) {
                this.kCR.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.kCQ.b(list, str);
                    VideoEffectLayout.this.kCQ.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.kCP.getVisibility() == 0) {
                runnable.run();
                tt(false);
            } else {
                cQP();
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
        return this.kDe;
    }

    public e<String> getCurrentFilterItem() {
        return this.kCY;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.kCX;
    }

    public StickerItem getCurrentStickItem() {
        return this.kDa;
    }

    private void cQP() {
        if (this.kDc != null && this.kDc.isRunning()) {
            this.kDc.cancel();
        }
        if (this.kDb == null) {
            this.kDb = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfp, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gfp, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.kDb.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.gfp.setVisibility(0);
        this.kDb.start();
    }

    private void tt(boolean z) {
        if (z) {
            if (this.kDd != null && this.kDd.isRunning()) {
                this.kDd.cancel();
            }
            if (this.kDb != null && this.kDb.isRunning()) {
                this.kDb.cancel();
            }
            if (this.kDc == null) {
                this.kDc = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gfp, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.kCP, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.kCP != null) {
                            VideoEffectLayout.this.kCP.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.kDn && VideoEffectLayout.this.gfp != null) {
                            VideoEffectLayout.this.gfp.setVisibility(8);
                        }
                    }
                });
                this.kDc.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.kDc.start();
            return;
        }
        if (this.kDc != null && this.kDc.isRunning()) {
            this.kDc.cancel();
        }
        if (this.kDd == null) {
            this.kDd = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kCP, "alpha", 1.0f, 0.0f);
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
                    if (!this.kDn && VideoEffectLayout.this.kCP != null) {
                        VideoEffectLayout.this.kCP.setVisibility(8);
                    }
                }
            });
            this.kDd.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.kDd.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.kCR != null) {
            this.kCR.av(list);
            this.kCR.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.kCU == null) {
            this.kCU = new ArrayList();
        } else {
            this.kCU.clear();
        }
        this.kCU.addAll(list);
    }

    public boolean cQK() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void cQL() {
        if (this.kCQ != null) {
            this.kCQ.cPB();
            this.kCW = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void cPC() {
        if (this.kCQ != null) {
            this.kCQ.cPC();
        }
    }
}
