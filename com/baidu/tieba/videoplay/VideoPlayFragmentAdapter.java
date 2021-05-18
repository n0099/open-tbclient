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
import d.a.j0.r.d0.b;
import d.a.k0.j2.f;
import d.a.k0.s3.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayFragmentAdapter extends FragmentStatePagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<VideoItemData> f21559a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21560b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f21561c;

    /* renamed from: d  reason: collision with root package name */
    public String f21562d;

    /* renamed from: e  reason: collision with root package name */
    public String f21563e;

    /* renamed from: f  reason: collision with root package name */
    public long f21564f;

    /* renamed from: g  reason: collision with root package name */
    public String f21565g;

    /* renamed from: h  reason: collision with root package name */
    public SparseArray<VideoPlayFragment> f21566h;

    /* renamed from: i  reason: collision with root package name */
    public f.c f21567i;
    public VideoPlayFragment.k0 j;

    public VideoPlayFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f21564f = -1L;
        this.f21566h = new SparseArray<>();
        new a();
    }

    public VideoPlayFragment b(int i2) {
        return this.f21566h.get(i2);
    }

    public void c(int i2) {
        String str;
        List<String> list;
        VideoPlayFragment b2;
        VideoPlayFragment b3;
        VideoPlayFragment videoPlayFragment = this.f21566h.get(i2);
        String str2 = null;
        if (videoPlayFragment != null) {
            list = videoPlayFragment.E1();
            if (ListUtils.getCount(list) < 5) {
                return;
            }
            str = videoPlayFragment.D1();
        } else {
            str = null;
            list = null;
        }
        int i3 = i2 - 1;
        String D1 = (i3 < 0 || (b3 = b(i3)) == null) ? null : b3.D1();
        int i4 = i2 + 1;
        if (i4 < getCount() && (b2 = b(i4)) != null) {
            str2 = b2.D1();
        }
        ArrayList arrayList = new ArrayList();
        int count = ListUtils.getCount(list);
        for (int i5 = 0; i5 < count; i5++) {
            String str3 = list.get(i5);
            if (!TextUtils.equals(str3, str) && !TextUtils.equals(str3, D1) && !TextUtils.equals(str3, str2)) {
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
        if (this.f21564f <= 0 || k == 1) {
            return;
        }
        b.j().w("key_vertical_shown_time", this.f21564f);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        super.destroyItem(viewGroup, i2, obj);
        this.f21566h.remove(i2);
    }

    public void e(List<VideoItemData> list, Rect rect) {
        this.f21559a = list;
        this.f21560b = true;
        this.f21561c = rect;
    }

    public void f(f.c cVar) {
        this.f21567i = cVar;
    }

    public void g(VideoPlayFragment.k0 k0Var) {
        this.j = k0Var;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f21559a)) {
            return 0;
        }
        return this.f21559a.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i2) {
        VideoPlayFragment videoPlayFragment = new VideoPlayFragment();
        videoPlayFragment.P1(this.f21567i);
        videoPlayFragment.T1(this.j);
        Bundle bundle = new Bundle();
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_DATA, (Serializable) ListUtils.getItem(this.f21559a, i2));
        bundle.putSerializable(VideoPlayActivityConfig.VIDEO_INDEX, Integer.valueOf(i2));
        bundle.putSerializable("page_from", this.f21562d);
        bundle.putSerializable("from", this.f21563e);
        bundle.putSerializable("obj_id", this.f21565g);
        if (this.f21560b) {
            bundle.putParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT, this.f21561c);
            this.f21560b = false;
        }
        videoPlayFragment.setArguments(bundle);
        return videoPlayFragment;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        VideoPlayFragment videoPlayFragment = (VideoPlayFragment) super.instantiateItem(viewGroup, i2);
        this.f21566h.put(i2, videoPlayFragment);
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
