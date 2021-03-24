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
    public List<a> f18319a;

    /* renamed from: b  reason: collision with root package name */
    public int f18320b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18321c;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f18322a;

        /* renamed from: b  reason: collision with root package name */
        public String f18323b;
    }

    public MessageFragmentPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.f18320b = -1;
        this.f18319a = new ArrayList();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f18319a.addAll(list);
    }

    public void c(boolean z) {
        this.f18321c = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<a> list = this.f18319a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        List<a> list = this.f18319a;
        if (list == null || i < 0 || i >= list.size() || this.f18319a.get(i) == null) {
            return null;
        }
        return this.f18319a.get(i).f18322a;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        List<a> list = this.f18319a;
        if (list != null && i >= 0 && i < list.size() && this.f18319a.get(i) != null) {
            return this.f18319a.get(i).hashCode();
        }
        return super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        List<a> list = this.f18319a;
        if (list == null || i < 0 || i >= list.size() || this.f18319a.get(i) == null) {
            return null;
        }
        return this.f18319a.get(i).f18323b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        super.setPrimaryItem(viewGroup, i, obj);
        if (!this.f18321c || (i2 = this.f18320b) == i) {
            return;
        }
        if (i2 != -1) {
            ((BaseFragment) getItem(i2)).setPrimary(false);
        }
        this.f18320b = i;
        if (obj instanceof BaseFragment) {
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
