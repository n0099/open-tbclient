package com.baidu.tieba.imMessageCenter.mention;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MessageFragmentPagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f17572a;

    /* renamed from: b  reason: collision with root package name */
    public int f17573b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17574c;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f17575a;

        /* renamed from: b  reason: collision with root package name */
        public String f17576b;
    }

    public MessageFragmentPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f17573b = -1;
        this.f17572a = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f17572a.addAll(list);
    }

    public void b(boolean z) {
        this.f17574c = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f17572a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        List<a> list = this.f17572a;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f17572a.get(i2) == null) {
            return null;
        }
        return this.f17572a.get(i2).f17575a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i2) {
        List<a> list = this.f17572a;
        if (list != null && i2 >= 0 && i2 < list.size() && this.f17572a.get(i2) != null) {
            return this.f17572a.get(i2).hashCode();
        }
        return super.getItemId(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        List<a> list = this.f17572a;
        if (list == null || i2 < 0 || i2 >= list.size() || this.f17572a.get(i2) == null) {
            return null;
        }
        return this.f17572a.get(i2).f17576b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        int i3;
        super.setPrimaryItem(viewGroup, i2, obj);
        if (!this.f17574c || (i3 = this.f17573b) == i2) {
            return;
        }
        if (i3 != -1) {
            ((BaseFragment) getItem(i3)).setPrimary(false);
        }
        this.f17573b = i2;
        if (obj instanceof BaseFragment) {
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
