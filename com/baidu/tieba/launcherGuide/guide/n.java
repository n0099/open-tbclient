package com.baidu.tieba.launcherGuide.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes.dex */
public class n extends FragmentPagerAdapter {
    private final BaseFragment[] ciT;
    private final int wH;

    public n(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.ciT = new BaseFragment[]{new h(), new k()};
        this.wH = this.ciT.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.wH) {
            return null;
        }
        return this.ciT[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.wH;
    }
}
