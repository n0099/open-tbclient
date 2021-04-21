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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import d.b.j0.q3.m.k;
import d.b.j0.q3.m.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {

    /* renamed from: e  reason: collision with root package name */
    public HListView f21572e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f21573f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.q3.m.d f21574g;

    /* renamed from: h  reason: collision with root package name */
    public k f21575h;
    public List<d.b.j0.q3.m.e> i;
    public List<d.b.j0.q3.m.e> j;
    public List<d.b.j0.q3.m.e> k;
    public List<StickerItem> l;
    public String m;
    public String n;
    public String o;
    public d.b.j0.q3.m.e<d.b.j0.q3.a> p;
    public d.b.j0.q3.m.e<String> q;
    public d.b.j0.q3.m.e<MusicData> r;
    public StickerItem s;
    public AnimatorSet t;
    public AnimatorSet u;
    public AnimatorSet v;
    public Handler w;
    public int x;

    /* loaded from: classes5.dex */
    public class a implements h {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21576e;

        public a(h hVar) {
            this.f21576e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(d.b.j0.q3.m.e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            h hVar = this.f21576e;
            if (hVar != null) {
                hVar.onEffectChoosed(eVar, obj);
            }
            int c2 = eVar.c();
            if (c2 == 1) {
                VideoEffectLayout.this.m = eVar.b();
                VideoEffectLayout.this.p = eVar;
            } else if (c2 == 2) {
                VideoEffectLayout.this.n = eVar.b();
                VideoEffectLayout.this.q = eVar;
            } else if (c2 != 3) {
            } else {
                VideoEffectLayout.this.o = eVar.b();
                VideoEffectLayout.this.r = eVar;
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21578e;

        public b(h hVar) {
            this.f21578e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(d.b.j0.q3.m.e eVar, Object obj) {
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
            if (stickerItem == null) {
                return;
            }
            VideoEffectLayout.this.w(stickerItem);
            h hVar = this.f21578e;
            if (hVar != null) {
                hVar.onStickerChoosed(stickerItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f21580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f21581f;

        public c(List list, String str) {
            this.f21580e = list;
            this.f21581f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoEffectLayout.this.f21574g.e(this.f21580e, this.f21581f);
            VideoEffectLayout.this.f21574g.notifyDataSetChanged();
            VideoEffectLayout.this.setListViewSelection(0);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21583e;

        public d(int i) {
            this.f21583e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoEffectLayout.this.f21572e.setSelection(this.f21583e);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends m {
        public e() {
        }

        @Override // d.b.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f61294e || VideoEffectLayout.this.f21572e == null) {
                return;
            }
            VideoEffectLayout.this.f21572e.setVisibility(8);
        }

        @Override // d.b.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (VideoEffectLayout.this.f21573f != null) {
                VideoEffectLayout.this.f21573f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoEffectLayout.this.requestLayout();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends m {
        public g() {
        }

        @Override // d.b.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f61294e || VideoEffectLayout.this.f21573f == null) {
                return;
            }
            VideoEffectLayout.this.f21573f.setVisibility(8);
        }

        @Override // d.b.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (VideoEffectLayout.this.f21572e != null) {
                VideoEffectLayout.this.f21572e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void onEffectChoosed(d.b.j0.q3.m.e eVar, Object obj);

        void onStickerChoosed(StickerItem stickerItem);
    }

    public VideoEffectLayout(Context context) {
        super(context);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i) {
        this.w.post(new d(i));
    }

    public d.b.j0.q3.m.e<d.b.j0.q3.a> getCurrentBeautyItem() {
        return this.p;
    }

    public int getCurrentEffectLayout() {
        return this.x;
    }

    public d.b.j0.q3.m.e<String> getCurrentFilterItem() {
        return this.q;
    }

    public StickerItem getCurrentStickItem() {
        return this.s;
    }

    public final void k(String str, d.b.j0.q3.a aVar) {
        this.i.add(n(0, 1, str, aVar));
    }

    public final void l(int i, String str, String str2) {
        List<d.b.j0.q3.m.e> list = this.j;
        if (list == null) {
            return;
        }
        list.add(n(i, 2, str, str2));
    }

    public final void m(List<d.b.j0.q3.m.e> list, String str) {
        if (list == null) {
            return;
        }
        c cVar = new c(list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f21573f.getVisibility() == 0) {
            cVar.run();
            y(false);
        } else {
            x();
            this.w.postDelayed(cVar, 250L);
        }
    }

    public final <T> d.b.j0.q3.m.e<T> n(int i, int i2, String str, T t) {
        d.b.j0.q3.m.e<T> eVar = new d.b.j0.q3.m.e<>();
        eVar.g(i2);
        eVar.e(i);
        eVar.f(str);
        eVar.h(t);
        return eVar;
    }

    public final void o() {
        if (this.i == null) {
            this.i = new ArrayList();
            k("No", d.b.j0.q3.a.b(0));
            k("1", d.b.j0.q3.a.b(1));
            k("2", d.b.j0.q3.a.b(2));
            k("3", d.b.j0.q3.a.b(3));
            k("4", d.b.j0.q3.a.b(4));
            k("5", d.b.j0.q3.a.b(5));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        this.x = 1;
        o();
        m(this.i, this.m);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        this.x = 2;
        p();
        m(this.j, this.n);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        this.x = 3;
        m(this.k, this.o);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        this.x = 0;
        this.f21573f.setAdapter((ListAdapter) this.f21575h);
        this.f21575h.notifyDataSetChanged();
        setListViewSelection(0);
        if (getVisibility() == 0) {
            y(true);
            return;
        }
        this.f21573f.setVisibility(0);
        this.f21572e.setVisibility(8);
    }

    public final void p() {
        if (this.j == null) {
            this.j = new ArrayList();
            l(R.drawable.filter_icon_avatar_default, q(R.string.filter_nature), "origin");
            l(R.drawable.filter_icon_avatar_hongkong, q(R.string.filter_hongkong), "hongkong");
            l(R.drawable.filter_icon_avatar_refreshing, q(R.string.filter_refreshing), "refreshing");
            l(R.drawable.filter_icon_avatar_girly, q(R.string.filter_girly), "girly");
            l(R.drawable.filter_icon_avatar_concrete, q(R.string.filter_concrete), "concrete");
            l(R.drawable.filter_icon_avatar_warm, q(R.string.filter_warm), "warm");
            l(R.drawable.filter_icon_avatar_cold, q(R.string.filter_cold), "cold");
            l(R.drawable.filter_icon_avatar_japanese, q(R.string.filter_japanese), "Japanese");
            l(R.drawable.filter_icon_avatar_cruz, q(R.string.filter_hdr), "cruz");
            l(R.drawable.filter_icon_avatar_abao, q(R.string.filter_abao), "abao");
            l(R.drawable.filter_icon_avatar_dew, q(R.string.filter_dew), "dew");
            l(R.drawable.filter_icon_avatar_slowlived, q(R.string.filter_slowlived), "slowlived");
            l(R.drawable.filter_icon_avatar_sweet, q(R.string.filter_sweet), "sweet");
            l(R.drawable.filter_icon_avatar_boardwalk, q(R.string.filter_boardwalk), "boardwalk");
            l(R.drawable.filter_icon_avatar_keylime, q(R.string.filter_keylime), "keylime");
            l(R.drawable.filter_icon_avatar_electric, q(R.string.filter_electric), "electric");
            l(R.drawable.filter_icon_avatar_silver, q(R.string.filter_silver), "silver");
            l(R.drawable.filter_icon_avatar_blackwhite, q(R.string.filter_blackwhite), "blackwhite");
        }
    }

    public final String q(int i) {
        return getResources().getText(i).toString();
    }

    public final void r() {
        this.m = "2";
        this.p = n(R.drawable.beauty_icon_avatar_2, 1, "2", d.b.j0.q3.a.b(2));
        this.n = q(R.string.filter_nature);
        this.q = n(R.drawable.filter_icon_avatar_default, 2, q(R.string.filter_nature), "origin");
        StickerItem stickerItem = new StickerItem();
        stickerItem.id = -1;
        stickerItem.name = "nosticker";
        this.s = stickerItem;
        this.o = getResources().getString(R.string.music_normal);
        getResources().getString(R.string.music_normal);
        new MusicData("-100", 1, getResources().getString(R.string.music_normal));
    }

    public final void s() {
        this.w = new Handler();
        r();
        LinearLayout.inflate(getContext(), R.layout.layout_effect_container, this);
        HListView hListView = (HListView) findViewById(R.id.effect_list_view);
        this.f21572e = hListView;
        hListView.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
        this.f21572e.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
        this.f21573f = hListView2;
        hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
        d.b.j0.q3.m.d dVar = new d.b.j0.q3.m.d();
        this.f21574g = dVar;
        this.f21572e.setAdapter((ListAdapter) dVar);
        k kVar = new k();
        this.f21575h = kVar;
        this.f21573f.setAdapter((ListAdapter) kVar);
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        if (ListUtils.isEmpty(this.l)) {
            return;
        }
        if (stickerItem != null) {
            for (StickerItem stickerItem2 : this.l) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isDownLoading = false;
                } else {
                    stickerItem2.isDownLoading = true;
                }
            }
        } else {
            for (StickerItem stickerItem3 : this.l) {
                stickerItem3.isDownLoading = false;
            }
        }
        k kVar = this.f21575h;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void setListener(h hVar) {
        d.b.j0.q3.m.d dVar = this.f21574g;
        if (dVar != null) {
            dVar.f(new a(hVar));
        }
        k kVar = this.f21575h;
        if (kVar != null) {
            kVar.e(new b(hVar));
        }
    }

    public void setMusicList(List<d.b.j0.q3.m.e> list) {
        List<d.b.j0.q3.m.e> list2 = this.k;
        if (list2 == null) {
            this.k = new ArrayList();
        } else {
            list2.clear();
        }
        this.k.addAll(list);
    }

    public void setStickerItems(List<StickerItem> list) {
        this.l = list;
        k kVar = this.f21575h;
        if (kVar != null) {
            kVar.d(list);
            this.f21575h.notifyDataSetChanged();
        }
    }

    public boolean t() {
        if (ListUtils.isEmpty(this.l)) {
            return true;
        }
        return this.l.size() == 1 && this.l.get(0).id == -1;
    }

    public void u() {
        d.b.j0.q3.m.d dVar = this.f21574g;
        if (dVar != null) {
            dVar.c();
            this.o = TbadkCoreApplication.getInst().getString(R.string.music_normal);
        }
    }

    public void v() {
        d.b.j0.q3.m.d dVar = this.f21574g;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void w(StickerItem stickerItem) {
        this.s = stickerItem;
        if (ListUtils.isEmpty(this.l) || stickerItem == null) {
            return;
        }
        for (StickerItem stickerItem2 : this.l) {
            if (stickerItem2.id != stickerItem.id) {
                stickerItem2.isSelect = false;
            } else {
                stickerItem2.isSelect = true;
            }
        }
        k kVar = this.f21575h;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public final void x() {
        AnimatorSet animatorSet = this.u;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.u.cancel();
        }
        if (this.t == null) {
            this.t = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21572e, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21572e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(200L);
            this.t.playSequentially(ofFloat, ofPropertyValuesHolder);
        }
        this.f21572e.setVisibility(0);
        this.t.start();
    }

    public final void y(boolean z) {
        if (z) {
            AnimatorSet animatorSet = this.v;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.v.cancel();
            }
            AnimatorSet animatorSet2 = this.t;
            if (animatorSet2 != null && animatorSet2.isRunning()) {
                this.t.cancel();
            }
            if (this.u == null) {
                this.u = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21572e, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21573f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                ofPropertyValuesHolder.addListener(new e());
                this.u.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            d.b.c.e.m.e.a().postDelayed(new f(), 300L);
            this.u.start();
            return;
        }
        AnimatorSet animatorSet3 = this.u;
        if (animatorSet3 != null && animatorSet3.isRunning()) {
            this.u.cancel();
        }
        if (this.v == null) {
            this.v = new AnimatorSet();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21573f, "alpha", 1.0f, 0.0f);
            ofFloat2.setDuration(300L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f21572e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
            ofPropertyValuesHolder2.setDuration(200L);
            ofPropertyValuesHolder2.addListener(new g());
            this.v.playSequentially(ofFloat2, ofPropertyValuesHolder2);
        }
        this.v.start();
    }

    public VideoEffectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s();
    }

    public VideoEffectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        s();
    }
}
