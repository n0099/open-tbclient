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
import d.a.i0.r.d0.b;
import d.a.j0.j2.f;
import d.a.j0.s3.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<VideoItemData> f22314a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22315b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f22316c;

    /* renamed from: d  reason: collision with root package name */
    public String f22317d;

    /* renamed from: e  reason: collision with root package name */
    public String f22318e;

    /* renamed from: f  reason: collision with root package name */
    public long f22319f;

    /* renamed from: g  reason: collision with root package name */
    public String f22320g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<VideoPlayFragment> f22321h;

    /* renamed from: i  reason: collision with root package name */
    public f.c f22322i;
    public VideoPlayFragment.k0 j;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f22319f = -1L;
        this.f22321h = new SparseArray<>();
        new a();
    }

    public VideoPlayFragment b(int i2) {
        return this.f22321h.get(i2);
    }

    public void c(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment b2;
        VideoPlayFragment b3;
        VideoPlayFragment videoPlayFragment = this.f22321h.get(i2);
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
        int i3 = i2 - 1;
        String E1 = (i3 < 0 || (b3 = b(i3)) == null) ? null : b3.E1();
        int i4 = i2 + 1;
        if (i4 < getCount() && (b2 = b(i4)) != null) {
            str2 = b2.E1();
        }
        ArrayList arrayList = new ArrayList();
        int count = ListUtils.getCount(list);
        for (int i5 = 0; i5 < count; i5++) {
            String str3 = list.get(i5);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, E1) && !TextUtils.equals(str3, str2)) {
                arrayList.add(str3);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921340, arrayList));
    }

    public void d() {
        int k = b.j().k("nani_key_download_show_rate", 2);
        if (this.f22319f <= 0 || k == 1) {
            return;
        }
        b.j().w("key_vertical_shown_time", this.f22319f);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        super.destroyItem(viewGroup, i2, obj);
        this.f22321h.remove(i2);
    }

    public void e(List<VideoItemData> list, Rect rect) {
        this.f22314a = list;
        this.f22315b = true;
        this.f22316c = rect;
    }

    public void f(f.c cVar) {
        this.f22322i = cVar;
    }

    public void g(VideoPlayFragment.k0 k0Var) {
        this.j = k0Var;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f22314a)) {
            return 0;
        }
        return this.f22314a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.Q1(this.f22322i);
        videoPlayFragment.U1(this.j);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) ListUtils.getItem(this.f22314a, i2));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
        bundle.putSerializable("page_from", this.f22317d);
        bundle.putSerializable("from", this.f22318e);
        bundle.putSerializable("obj_id", this.f22320g);
        if (this.f22315b) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f22316c);
            this.f22315b = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i2);
        this.f22321h.put(i2, videoPlayFragment);
        return videoPlayFragment;
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
