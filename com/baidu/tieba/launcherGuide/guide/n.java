package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class n extends FragmentPagerAdapter {
    private final BaseFragment[] mFragments;
    private final int wB;

    public n(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mFragments = new BaseFragment[]{new h(), new k()};
        this.wB = this.mFragments.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.wB) {
            return null;
        }
        return this.mFragments[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wB;
    }
}
