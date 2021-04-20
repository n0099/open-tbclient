package com.baidu.tieba.videoplay;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import d.b.h0.r.d0.b;
import d.b.i0.j2.f;
import d.b.i0.s3.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<VideoItemData> f21665a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21666b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21667c;

    /* renamed from: d  reason: collision with root package name */
    public String f21668d;

    /* renamed from: e  reason: collision with root package name */
    public String f21669e;

    /* renamed from: f  reason: collision with root package name */
    public long f21670f;

    /* renamed from: g  reason: collision with root package name */
    public String f21671g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<VideoPlayFragment> f21672h;
    public f.c i;
    public VideoPlayFragment.k0 j;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f21670f = -1L;
        this.f21672h = new SparseArray<>();
        new a();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.f21672h.remove(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f21665a)) {
            return 0;
        }
        return this.f21665a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.Q1(this.i);
        videoPlayFragment.U1(this.j);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) ListUtils.getItem(this.f21665a, i));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i));
        bundle.putSerializable("page_from", this.f21668d);
        bundle.putSerializable("from", this.f21669e);
        bundle.putSerializable("obj_id", this.f21671g);
        if (this.f21666b) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f21667c);
            this.f21666b = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    public VideoPlayFragment i(int i) {
        return this.f21672h.get(i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i);
        this.f21672h.put(i, videoPlayFragment);
        return videoPlayFragment;
    }

    public void j(int i) {
        String str;
        List<String> list;
        VideoPlayFragment i2;
        VideoPlayFragment i3;
        VideoPlayFragment videoPlayFragment = this.f21672h.get(i);
        String str2 = null;
        if (videoPlayFragment != null) {
            list = videoPlayFragment.F1();
            if (ListUtils.getCount(list) < 5) {
                return;
            }
            str = videoPlayFragment.E1();
        } else {
            str = null;
            list = null;
        }
        int i4 = i - 1;
        String E1 = (i4 < 0 || (i3 = i(i4)) == null) ? null : i3.E1();
        int i5 = i + 1;
        if (i5 < getCount() && (i2 = i(i5)) != null) {
            str2 = i2.E1();
        }
        ArrayList arrayList = new ArrayList();
        int count = ListUtils.getCount(list);
        for (int i6 = 0; i6 < count; i6++) {
            String str3 = list.get(i6);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, E1) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
    }

    public void k() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f21670f <= 0 || k == 1) {
            return;
        }
        b.j().w("key_vertical_shown_time", this.f21670f);
    }

    public void l(List<VideoItemData> list, Rect rect) {
        this.f21665a = list;
        this.f21666b = true;
        this.f21667c = rect;
    }

    public void m(f.c cVar) {
        this.i = cVar;
    }

    public void n(VideoPlayFragment.k0 k0Var) {
        this.j = k0Var;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle = (Bundle) super.saveState();
        if (bundle != null) {
            bundle.putParcelableArray("states", null);
        }
        return bundle;
    }
}
