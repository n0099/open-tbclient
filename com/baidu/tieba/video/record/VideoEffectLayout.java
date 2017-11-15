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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    private String auS;
    private HListView ctt;
    private HListView gMc;
    private c gMd;
    private k gMe;
    private List<d> gMf;
    private List<d> gMg;
    private List<d> gMh;
    private String gMi;
    private String gMj;
    private d<com.baidu.tieba.video.a> gMk;
    private d<String> gMl;
    private d<MusicData> gMm;
    private StickerItem gMn;
    private AnimatorSet gMo;
    private AnimatorSet gMp;
    private AnimatorSet gMq;
    private int gMr;
    private Handler mHandler;
    private List<StickerItem> mStickerItems;

    /* loaded from: classes2.dex */
    public interface a {
        void a(StickerItem stickerItem);

        void a(d dVar, Object obj);
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
        this.gMi = "2";
        this.gMk = c(d.f.beauty_icon_avatar_2, 1, "2", com.baidu.tieba.video.a.uK(2));
        this.auS = getString(d.j.filter_nature);
        this.gMl = c(d.f.filter_icon_avatar_default, 2, getString(d.j.filter_nature), "nature");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.gMn = stickerItem;
        this.gMj = getResources().getString(d.j.music_normal);
        this.gMm = new d<>(3, getResources().getString(d.j.music_normal), new MusicData("-100", 1, getResources().getString(d.j.music_normal)), d.f.icon_video_mute);
        inflate(getContext(), d.h.layout_effect_container, this);
        this.ctt = (HListView) findViewById(d.g.effect_list_view);
        this.ctt.setDividerWidth(getContext().getResources().getDimensionPixelSize(d.e.ds28));
        this.ctt.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gMc = (HListView) findViewById(d.g.sticker_list_view);
        this.gMc.setSelector(getResources().getDrawable(d.f.transparent_bg));
        this.gMd = new c();
        this.ctt.setAdapter((ListAdapter) this.gMd);
        this.gMe = new k();
        this.gMc.setAdapter((ListAdapter) this.gMe);
    }

    private <T> d<T> c(int i, int i2, String str, T t) {
        d<T> dVar = new d<>();
        dVar.setType(i2);
        dVar.uW(i);
        dVar.setName(str);
        dVar.setValue(t);
        return dVar;
    }

    private void bBm() {
        if (this.gMf == null) {
            this.gMf = new ArrayList();
            a(d.f.beauty_icon_avatar_0, "Normal", com.baidu.tieba.video.a.uK(0));
            a(d.f.beauty_icon_avatar_1, "1", com.baidu.tieba.video.a.uK(1));
            a(d.f.beauty_icon_avatar_2, "2", com.baidu.tieba.video.a.uK(2));
            a(d.f.beauty_icon_avatar_3, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, com.baidu.tieba.video.a.uK(3));
            a(d.f.beauty_icon_avatar_4, "4", com.baidu.tieba.video.a.uK(4));
            a(d.f.beauty_icon_avatar_5, "5", com.baidu.tieba.video.a.uK(5));
        }
    }

    private void a(int i, String str, com.baidu.tieba.video.a aVar) {
        this.gMf.add(c(i, 1, str, aVar));
    }

    private void bBn() {
        if (this.gMg == null) {
            this.gMg = new ArrayList();
            k(d.f.filter_icon_avatar_default, getString(d.j.filter_nature), "nature");
            k(d.f.filter_icon_avatar_hongkong, getString(d.j.filter_hongkong), "hongkong");
            k(d.f.filter_icon_avatar_refreshing, getString(d.j.filter_refreshing), "refreshing");
            k(d.f.filter_icon_avatar_girly, getString(d.j.filter_girly), "girly");
            k(d.f.filter_icon_avatar_concrete, getString(d.j.filter_concrete), "concrete");
            k(d.f.filter_icon_avatar_warm, getString(d.j.filter_warm), "warm");
            k(d.f.filter_icon_avatar_cold, getString(d.j.filter_cold), "cold");
            k(d.f.filter_icon_avatar_japanese, getString(d.j.filter_japanese), "Japanese");
            k(d.f.filter_icon_avatar_cruz, getString(d.j.filter_hdr), "cruz");
            k(d.f.filter_icon_avatar_abao, getString(d.j.filter_abao), "abao");
            k(d.f.filter_icon_avatar_dew, getString(d.j.filter_dew), "dew");
            k(d.f.filter_icon_avatar_slowlived, getString(d.j.filter_slowlived), "slowlived");
            k(d.f.filter_icon_avatar_sweet, getString(d.j.filter_sweet), "sweet");
            k(d.f.filter_icon_avatar_boardwalk, getString(d.j.filter_boardwalk), "boardwalk");
            k(d.f.filter_icon_avatar_keylime, getString(d.j.filter_keylime), "keylime");
            k(d.f.filter_icon_avatar_electric, getString(d.j.filter_electric), "electric");
            k(d.f.filter_icon_avatar_silver, getString(d.j.filter_silver), "silver");
            k(d.f.filter_icon_avatar_blackwhite, getString(d.j.filter_blackwhite), "blackwhite");
        }
    }

    private String getString(int i) {
        return getResources().getText(i).toString();
    }

    private void k(int i, String str, String str2) {
        if (this.gMg != null) {
            this.gMg.add(c(i, 2, str, str2));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAT() {
        this.gMr = 3;
        j(this.gMh, this.gMj);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAU() {
        this.gMr = 0;
        this.gMc.setAdapter((ListAdapter) this.gMe);
        this.gMe.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            nl(true);
            return;
        }
        this.gMc.setVisibility(0);
        this.ctt.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAV() {
        this.gMr = 1;
        bBm();
        j(this.gMf, this.gMi);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAW() {
        this.gMr = 2;
        bBn();
        j(this.gMg, this.auS);
    }

    public void setListener(final a aVar) {
        if (this.gMd != null) {
            this.gMd.setListener(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.1
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar, Object obj) {
                    if (dVar != null) {
                        if (aVar != null) {
                            aVar.a(dVar, obj);
                        }
                        switch (dVar.getType()) {
                            case 1:
                                VideoEffectLayout.this.gMi = dVar.getName();
                                VideoEffectLayout.this.gMk = dVar;
                                return;
                            case 2:
                                VideoEffectLayout.this.auS = dVar.getName();
                                VideoEffectLayout.this.gMl = dVar;
                                return;
                            case 3:
                                VideoEffectLayout.this.gMj = dVar.getName();
                                VideoEffectLayout.this.gMm = dVar;
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
        if (this.gMe != null) {
            this.gMe.a(new a() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.2
                @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
                public void a(d dVar, Object obj) {
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
        this.gMn = stickerItem;
        if (!v.v(this.mStickerItems) && stickerItem != null) {
            for (StickerItem stickerItem2 : this.mStickerItems) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            if (this.gMe != null) {
                this.gMe.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (!v.v(this.mStickerItems)) {
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
            if (this.gMe != null) {
                this.gMe.notifyDataSetChanged();
            }
        }
    }

    private void j(final List<d> list, final String str) {
        if (list != null) {
            Runnable runnable = new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    VideoEffectLayout.this.gMd.d(list, str);
                    VideoEffectLayout.this.gMd.notifyDataSetChanged();
                    VideoEffectLayout.this.setListViewSelection(0);
                }
            };
            if (getVisibility() != 0) {
                runnable.run();
            } else if (this.gMc.getVisibility() == 0) {
                runnable.run();
                nl(false);
            } else {
                bBo();
                this.mHandler.postDelayed(runnable, 250L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.4
            @Override // java.lang.Runnable
            public void run() {
                VideoEffectLayout.this.ctt.setSelection(i);
            }
        });
    }

    public int getCurrentEffectLayout() {
        return this.gMr;
    }

    public d<String> getCurrentFilterItem() {
        return this.gMl;
    }

    public d<com.baidu.tieba.video.a> getCurrentBeautyItem() {
        return this.gMk;
    }

    public StickerItem getCurrentStickItem() {
        return this.gMn;
    }

    private void bBo() {
        if (this.gMp != null && this.gMp.isRunning()) {
            this.gMp.cancel();
        }
        if (this.gMo == null) {
            this.gMo = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ctt, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.ctt, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.gMo.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.ctt.setVisibility(0);
        this.gMo.start();
    }

    private void nl(boolean z) {
        if (z) {
            if (this.gMq != null && this.gMq.isRunning()) {
                this.gMq.cancel();
            }
            if (this.gMo != null && this.gMo.isRunning()) {
                this.gMo.cancel();
            }
            if (this.gMp == null) {
                this.gMp = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ctt, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gMc, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.5
                    @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        if (VideoEffectLayout.this.gMc != null) {
                            VideoEffectLayout.this.gMc.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.gMy && VideoEffectLayout.this.ctt != null) {
                            VideoEffectLayout.this.ctt.setVisibility(8);
                        }
                    }
                });
                this.gMp.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.gMp.start();
            return;
        }
        if (this.gMp != null && this.gMp.isRunning()) {
            this.gMp.cancel();
        }
        if (this.gMq == null) {
            this.gMq = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gMc, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.ctt, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoEffectLayout.6
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (VideoEffectLayout.this.ctt != null) {
                        VideoEffectLayout.this.ctt.setVisibility(0);
                    }
                }

                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gMy && VideoEffectLayout.this.gMc != null) {
                        VideoEffectLayout.this.gMc.setVisibility(8);
                    }
                }
            });
            this.gMq.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.gMq.start();
    }

    public void setStickerItems(List<StickerItem> list) {
        this.mStickerItems = list;
        if (this.gMe != null) {
            this.gMe.q(list);
            this.gMe.notifyDataSetChanged();
        }
    }

    public void setMusicList(List<d> list) {
        if (this.gMh == null) {
            this.gMh = new ArrayList();
        } else {
            this.gMh.clear();
        }
        this.gMh.addAll(list);
    }

    public boolean bBk() {
        if (v.v(this.mStickerItems)) {
            return true;
        }
        return this.mStickerItems.size() == 1 && this.mStickerItems.get(0).id == -1;
    }

    public void bBl() {
        if (this.gMd != null) {
            this.gMd.bAm();
            this.gMj = TbadkCoreApplication.getInst().getString(d.j.music_normal);
        }
    }

    public void bAn() {
        if (this.gMd != null) {
            this.gMd.bAn();
        }
    }
}
