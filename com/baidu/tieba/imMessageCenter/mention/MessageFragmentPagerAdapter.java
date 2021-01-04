package com.baidu.tieba.imMessageCenter.mention;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MessageFragmentPagerAdapter extends FragmentPagerAdapter {
    private boolean isPrimary;
    private List<a> mFragments;
    private int mPrimaryPosition;

    /* loaded from: classes2.dex */
    public static class a {
        public Fragment fragment;
        public String title;
    }

    public MessageFragmentPagerAdapter(FragmentManager fragmentManager, List<a> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.mFragments = new ArrayList();
        if (list != null && list.size() > 0) {
            this.mFragments.addAll(list);
        }
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).fragment;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) ? super.getItemId(i) : this.mFragments.get(i).hashCode();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.mFragments != null) {
            return this.mFragments.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        if (this.mFragments == null || i < 0 || i >= this.mFragments.size() || this.mFragments.get(i) == null) {
            return null;
        }
        return this.mFragments.get(i).title;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.isPrimary && this.mPrimaryPosition != i) {
            if (this.mPrimaryPosition != -1) {
                ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
            }
            this.mPrimaryPosition = i;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }

    public void setPrimary(boolean z) {
        this.isPrimary = z;
    }
}
