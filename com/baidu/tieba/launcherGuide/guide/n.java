package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class n extends FragmentPagerAdapter {
    private final BaseFragment[] cEd;
    private final int xj;

    public n(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.cEd = new BaseFragment[]{new h(), new k()};
        this.xj = this.cEd.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.xj) {
            return null;
        }
        return this.cEd[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.xj;
    }
}
