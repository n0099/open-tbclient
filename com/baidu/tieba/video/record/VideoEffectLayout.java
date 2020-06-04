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
/* loaded from: classes10.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String egm;
    private HListView hgw;
    private HListView lKd;
    private d lKe;
    private k lKf;
    private List<e> lKg;
    private List<e> lKh;
    private List<e> lKi;
    private String lKj;
    private String lKk;
    private e<com.baidu.tieba.video.a> lKl;
    private e<String> lKm;
    private e<MusicData> lKn;
    private StickerItem lKo;
    private AnimatorSet lKp;
    private AnimatorSet lKq;
    private AnimatorSet lKr;
    private int lKs;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

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
        dlg();
        inflate(getContext(), R.layout.layout_effect_container, this);
        this.hgw = (HListView) findViewById(R.id.effect_list_view);
        this.hgw.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.hgw.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lKd = (HListView) findViewById(R.id.sticker_list_view);
        this.lKd.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        this.lKe = new d();
        this.hgw.setAdapter((ListAdapter) this.lKe);
        this.lKf = new k();
        this.lKd.setAdapter((ListAdapter) this.lKf);
    }

    private <T> e<T> b(int i, int i2, String str, T t) {
        e<T> eVar = new e<>();
        eVar.setType(i2);
        eVar.Fe(i);
        eVar.setName(str);
        eVar.setValue(t);
        return eVar;
    }

    private void dlg() {
        this.lKj = "2";
        this.lKl = b(R.drawable.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.EO(2));
        this.egm = getString(R.string.filter_nature);
        this.lKm = b(R.drawable.filter_icon_avatar_default, 2, getString(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.lKo = stickerItem;
        this.lKk = getResources().getString(R.string.music_normal);
        this.lKn = new e<>(3, getResources().getString(R.string.music_normal), new MusicData("-100", 1, getResources().getString(R.string.music_normal)), R.drawable.icon_video_mute);
    }

    private void dlh() {
        if (this.lKg == null) {
            this.lKg = new ArrayList();
            a("No", com.baidu.tieba.video.a.EO(0));
            a("1", com.baidu.tieba.video.a.EO(1));
            a("2", com.baidu.tieba.video.a.EO(2));
            a("3", com.baidu.tieba.video.a.EO(3));
            a("4", com.baidu.tieba.video.a.EO(4));
            a("5", com.baidu.tieba.video.a.EO(5));
        }
    }

    private void a(String str, com.baidu.tieba.video.a aVar) {
        this.lKg.add(b(0, 1, str, aVar));
    }

    private void dli() {
        if (this.lKh == null) {
            this.lKh = new ArrayList();
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
        if (this.lKh != null) {
            this.lKh.add(b(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkJ() {
        this.lKs = 3;
        n(this.lKi, this.lKk);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkK() {
        this.lKs = 0;
        this.lKd.setAdapter((ListAdapter) this.lKf);
        this.lKf.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            vd(true);
            return;
        }
        this.lKd.setVisibility(0);
        this.hgw.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkL() {
        this.lKs = 1;
        dlh();
        n(this.lKg, this.lKj);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkM() {
        this.lKs = 2;
        dli();
        n(this.lKh, this.egm);
    }

    public void setListener(final a aVar) {
        if (this.lKe != null) {
            this.lKe.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(e eVar, Object obj) {
                    if (eVar != null) {
                        if (aVar != null) {
                            aVar.a(eVar, obj);
                        }
                        switch (eVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.lKj = eVar.getName();
                                VideoEffectLayout.this.lKl = eVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.egm = eVar.getName();
                                VideoEffectLayout.this.lKm = eVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.lKk = eVar.getName();
                                VideoEffectLayout.this.lKn = eVar;
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
        if (this.lKf != null) {
            this.lKf.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
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
        this.lKo = stickerItem;
        if (!v.isEmpty(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.lKf != null) {
                this.lKf.notifyDataSetChanged();
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
            if (this.lKf != null) {
                this.lKf.notifyDataSetChanged();
            }
        }
    }

    private void n(final List<e> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.lKe.b(list, str);
                    VideoEffectLayout.this.lKe.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.lKd.getVisibility() == 0) {
                runnable.run();
                vd(false);
            } else {
                dlj();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.hgw.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.lKs;
    }

    public e<String> getCurrentFilterItem() {
        return this.lKm;
    }

    public e<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.lKl;
    }

    public StickerItem getCurrentStickItem() {
        return this.lKo;
    }

    private void dlj() {
        if (this.lKq != null && this.lKq.isRunning()) {
            this.lKq.cancel();
        }
        if (this.lKp == null) {
            this.lKp = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgw, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.hgw, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.lKp.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.hgw.setVisibility(0);
        this.lKp.start();
    }

    private void vd(boolean z) {
        if (z) {
            if (this.lKr != null && this.lKr.isRunning()) {
                this.lKr.cancel();
            }
            if (this.lKp != null && this.lKp.isRunning()) {
                this.lKp.cancel();
            }
            if (this.lKq == null) {
                this.lKq = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hgw, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.lKd, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.lKd != null) {
                            VideoEffectLayout.this.lKd.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.lKB && VideoEffectLayout.this.hgw != null) {
                            VideoEffectLayout.this.hgw.setVisibility(8);
                        }
                    }
                });
                this.lKq.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.requestLayout();
                }
            }, 300L);
            this.lKq.start();
            return;
        }
        if (this.lKq != null && this.lKq.isRunning()) {
            this.lKq.cancel();
        }
        if (this.lKr == null) {
            this.lKr = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.lKd, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.hgw, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.7
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.hgw != null) {
                        VideoEffectLayout.this.hgw.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lKB && VideoEffectLayout.this.lKd != null) {
                        VideoEffectLayout.this.lKd.setVisibility(8);
                    }
                }
            });
            this.lKr.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.lKr.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.lKf != null) {
            this.lKf.az(list);
            this.lKf.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<e> list) {
        if (this.lKi == null) {
            this.lKi = new ArrayList();
        } else {
            this.lKi.clear();
        }
        this.lKi.addAll(list);
    }

    public boolean dle() {
        if (v.isEmpty(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void dlf() {
        if (this.lKe != null) {
            this.lKe.djS();
            this.lKk = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void djT() {
        if (this.lKe != null) {
            this.lKe.djT();
        }
    }
}
