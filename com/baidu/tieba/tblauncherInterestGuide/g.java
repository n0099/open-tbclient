package com.baidu.tieba.tblauncherInterestGuide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public class g extends FragmentPagerAdapter {
    private final BaseFragment[] hgW;
    private final int mCount;

    public g(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.hgW = new BaseFragment[]{new e(), new f()};
        this.mCount = this.hgW.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.hgW[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
