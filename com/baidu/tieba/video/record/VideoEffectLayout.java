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
    private HListView mdX;
    private d mdY;
    private k mdZ;
    private List<e> mea;
    private List<e> meb;
    private List<e> mec;
    private String med;
    private String mee;
    private e<com.baidu.tieba.video.a> mef;
    private e<String> meg;
    private e<MusicData> meh;
    private StickerItem mei;
    private AnimatorSet mej;
    private AnimatorSet mek;
    private AnimatorSet mel;
    private int mem;

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
        dpw();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hsG = (HListView) findViewById(R.id.effect_list_view);
        this.hsG.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hsG.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdX = (HListView) findViewById(R.id.sticker_list_view);
        this.mdX.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.mdY = new d();
        this.hsG.setAdapter((ListAdapter) this.mdY);
        this.mdZ = new k();
        this.mdX.setAdapter((ListAdapter) this.mdZ);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Gh(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dpw() {
        this.med = "2";
        this.mef = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.FQ(2));
        this.eoX = getString(R.string.filter_nature);
        this.meg = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.mei = stickerItem;
        this.mee = getResources().getString(R.string.music_normal);
        this.meh = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dpx() {
        if (this.mea == null) {
            this.mea = new ArrayList();
            a("No", com.baidu.tieba.video.a.FQ(0));
            a("1", com.baidu.tieba.video.a.FQ(1));
            a("2", com.baidu.tieba.video.a.FQ(2));
            a("3", com.baidu.tieba.video.a.FQ(3));
            a("4", com.baidu.tieba.video.a.FQ(4));
            a("5", com.baidu.tieba.video.a.FQ(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.mea.add(b(0, 1, str, aVar));
    }

    private void dpy() {
        if (this.meb == null) {
            this.meb = new ArrayList();
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
        if (this.meb != null) {
            this.meb.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doZ() {
        this.mem = 3;
        m(this.mec, this.mee);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpa() {
        this.mem = 0;
        this.mdX.setAdapter((ListAdapter) this.mdZ);
        this.mdZ.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            vv(true);
            return;
        }
        this.mdX.setVisibility(0);
        this.hsG.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpb() {
        this.mem = 1;
        dpx();
        m(this.mea, this.med);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpc() {
        this.mem = 2;
        dpy();
        m(this.meb, this.eoX);
    }

    public void setListener(final a aVar) {
        if (this.mdY != null) {
            this.mdY.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.med = eVar.getName();
                                VideoEffectLayout.this.mef = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.eoX = eVar.getName();
                                VideoEffectLayout.this.meg = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.mee = eVar.getName();
                                VideoEffectLayout.this.meh = eVar;
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
        if (this.mdZ != null) {
            this.mdZ.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.mei = stickerItem;
        if (!w.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.mdZ != null) {
                this.mdZ.notifyDataSetChanged();
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
            if (this.mdZ != null) {
                this.mdZ.notifyDataSetChanged();
            }
        }
    }

    private void m(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.mdY.b(list, str);
                    VideoEffectLayout.this.mdY.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.mdX.getVisibility() == 0) {
                runnable.run();
                vv(false);
            } else {
                dpz();
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
        return this.mem;
    }

    public e<String> getCurrentFilterItem() {
        return this.meg;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.mef;
    }

    public StickerItem getCurrentStickItem() {
        return this.mei;
    }

    private void dpz() {
        if (this.mek != null && this.mek.isRunning()) {
            this.mek.cancel();
        }
        if (this.mej == null) {
            this.mej = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hsG, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hsG, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.mej.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hsG.setVisibility(0);
        this.mej.start();
    }

    private void vv(boolean z) {
        if (z) {
            if (this.mel != null && this.mel.isRunning()) {
                this.mel.cancel();
            }
            if (this.mej != null && this.mej.isRunning()) {
                this.mej.cancel();
            }
            if (this.mek == null) {
                this.mek = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hsG, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mdX, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.mdX != null) {
                            VideoEffectLayout.this.mdX.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.mev && VideoEffectLayout.this.hsG != null) {
                            VideoEffectLayout.this.hsG.setVisibility(8);
                        }
                    }
                });
                this.mek.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.mek.start();
            return;
        }
        if (this.mek != null && this.mek.isRunning()) {
            this.mek.cancel();
        }
        if (this.mel == null) {
            this.mel = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mdX, "alpha", 1.0f, 0.0f);
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
                    if (!this.mev && VideoEffectLayout.this.mdX != null) {
                        VideoEffectLayout.this.mdX.setVisibility(8);
                    }
                }
            });
            this.mel.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.mel.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.mdZ != null) {
            this.mdZ.aD(list);
            this.mdZ.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.mec == null) {
            this.mec = new ArrayList();
        } else {
            this.mec.clear();
        }
        this.mec.addAll(list);
    }

    public boolean dpu() {
        if (w.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dpv() {
        if (this.mdY != null) {
            this.mdY.doi();
            this.mee = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void doj() {
        if (this.mdY != null) {
            this.mdY.doj();
        }
    }
}
