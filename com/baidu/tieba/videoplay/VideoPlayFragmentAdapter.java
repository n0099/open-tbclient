package com.baidu.tieba.videoplay;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import d.a.o0.k2.f;
import d.a.o0.t3.a.b;
import d.a.o0.t3.a.c;
import d.a.o0.t3.c.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes5.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public c f21653a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21654b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21655c;

    /* renamed from: d  reason: collision with root package name */
    public String f21656d;

    /* renamed from: e  reason: collision with root package name */
    public String f21657e;

    /* renamed from: f  reason: collision with root package name */
    public long f21658f;

    /* renamed from: g  reason: collision with root package name */
    public String f21659g;

    /* renamed from: h  reason: collision with root package name */
    public final Activity f21660h;

    /* renamed from: i  reason: collision with root package name */
    public int f21661i;
    public boolean j;
    public final SparseArray<a> k;
    public f.c l;
    public VideoPlayFragment.k0 m;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager, Activity activity) {
        super(fragmentManager);
        this.f21658f = -1L;
        this.f21661i = -1;
        this.k = new SparseArray<>();
        new b();
        this.f21660h = activity;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        super.destroyItem(viewGroup, i2, obj);
        this.k.remove(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        c cVar = this.f21653a;
        if (cVar == null) {
            return 0;
        }
        return cVar.d();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        VideoItemModel e2 = this.f21653a.e(i2);
        if (VideoMiddleAdSwitch.isOn() && e2 != null && e2.isFunAdType()) {
            VideoAdFragment videoAdFragment = new VideoAdFragment();
            videoAdFragment.K0(this.f21653a.f());
            videoAdFragment.L0(this.f21653a.g());
            Bundle bundle = new Bundle();
            bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, e2);
            bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
            bundle.putSerializable("page_from", this.f21656d);
            bundle.putSerializable("from", this.f21657e);
            bundle.putSerializable("obj_id", this.f21659g);
            videoAdFragment.setArguments(bundle);
            return videoAdFragment;
        }
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.Y1(this.l);
        videoPlayFragment.c2(this.m);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, e2);
        bundle2.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
        bundle2.putSerializable("page_from", this.f21656d);
        bundle2.putSerializable("from", this.f21657e);
        bundle2.putSerializable("obj_id", this.f21659g);
        if (this.f21654b) {
            bundle2.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f21655c);
            this.f21654b = false;
        }
        videoPlayFragment.setArguments(bundle2);
        return videoPlayFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Objects.equals(aVar.a0(), this.f21653a.e(aVar.q()))) {
                return super.getItemPosition(obj);
            }
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public VideoPlayFragment i(int i2) {
        a aVar = this.k.get(i2);
        if (aVar instanceof VideoPlayFragment) {
            return (VideoPlayFragment) aVar;
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        a aVar = (a) super.instantiateItem(viewGroup, i2);
        aVar.Q(i2);
        this.k.put(i2, aVar);
        return aVar;
    }

    public void j(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment i3;
        VideoPlayFragment i4;
        a aVar = this.k.get(i2);
        VideoPlayFragment videoPlayFragment = aVar instanceof VideoPlayFragment ? (VideoPlayFragment) aVar : null;
        if (videoPlayFragment != null) {
            list = videoPlayFragment.K1();
            if (ListUtils.getCount(list) < 5) {
                return;
            }
            str = videoPlayFragment.J1();
        } else {
            str = null;
            list = null;
        }
        int i5 = i2 - 1;
        String J1 = (i5 < 0 || (i4 = i(i5)) == null) ? null : i4.J1();
        int i6 = i2 + 1;
        String J12 = (i6 >= getCount() || (i3 = i(i6)) == null) ? null : i3.J1();
        ArrayList arrayList = new ArrayList();
        int count = ListUtils.getCount(list);
        for (int i7 = 0; i7 < count; i7++) {
            String str2 = list.get(i7);
            if (!TextUtils.equals(str2, str) && !TextUtils.equals(str2, J1) && !TextUtils.equals(str2, J12)) {
                arrayList.add(str2);
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
        }
        if (VideoMiddleAdSwitch.isOn() && this.f21653a.j(i2)) {
            d.a.o0.s0.a.h().n(this.f21660h, null, this.f21653a.g());
        }
    }

    public void k() {
        int k = d.a.n0.r.d0.b.j().k("nani_key_download_show_rate", 2);
        if (this.f21658f <= 0 || k == 1) {
            return;
        }
        d.a.n0.r.d0.b.j().w("key_vertical_shown_time", this.f21658f);
    }

    public void l(c cVar, Rect rect) {
        this.f21653a = cVar;
        this.f21654b = true;
        this.f21655c = rect;
    }

    public void m(f.c cVar) {
        this.l = cVar;
    }

    public void n(boolean z) {
        this.j = z;
        int i2 = this.f21661i;
        if (i2 == -1 || i(i2) == null) {
            return;
        }
        i(this.f21661i).W1(z);
    }

    public void o(VideoPlayFragment.k0 k0Var) {
        this.m = k0Var;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Parcelable[] parcelableArray;
        Bundle bundle = (Bundle) super.saveState();
        if (bundle != null && (parcelableArray = bundle.getParcelableArray("states")) != null && parcelableArray.length > 5) {
            bundle.putParcelableArray("states", null);
        }
        return bundle;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
        int i3 = this.f21661i;
        if (i3 != i2) {
            if (i3 != -1 && i(i3) != null) {
                i(this.f21661i).setPrimary(false);
                i(this.f21661i).W1(this.j);
            }
            this.f21661i = i2;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
            if (obj instanceof VideoPlayFragment) {
                ((VideoPlayFragment) obj).W1(this.j);
            }
        }
    }
}
