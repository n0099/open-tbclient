package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends FragmentPagerAdapter {
    private List<a> mFragments;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public String title;
    }

    public i(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.mFragments = new ArrayList();
        if (list != null && list.size() > 0) {
            this.mFragments.addAll(list);
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).fragment;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mFragments != null) {
            return this.mFragments.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).title;
    }
}
