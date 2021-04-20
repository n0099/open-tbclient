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
    public List<a> f17997a;

    /* renamed from: b  reason: collision with root package name */
    public int f17998b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17999c;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f18000a;

        /* renamed from: b  reason: collision with root package name */
        public String f18001b;
    }

    public MessageFragmentPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f17998b = -1;
        this.f17997a = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f17997a.addAll(list);
    }

    public void c(boolean z) {
        this.f17999c = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f17997a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        List<a> list = this.f17997a;
        if (list == null || i < 0 || i >= list.size() || this.f17997a.get(i) == null) {
            return null;
        }
        return this.f17997a.get(i).f18000a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        List<a> list = this.f17997a;
        if (list != null && i >= 0 && i < list.size() && this.f17997a.get(i) != null) {
            return this.f17997a.get(i).hashCode();
        }
        return super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<a> list = this.f17997a;
        if (list == null || i < 0 || i >= list.size() || this.f17997a.get(i) == null) {
            return null;
        }
        return this.f17997a.get(i).f18001b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        super.setPrimaryItem(viewGroup, i, obj);
        if (!this.f17999c || (i2 = this.f17998b) == i) {
            return;
        }
        if (i2 != -1) {
            ((BaseFragment) getItem(i2)).setPrimary(false);
        }
        this.f17998b = i;
        if (obj instanceof BaseFragment) {
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
