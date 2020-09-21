package com.baidu.tieba.tblauncherInterestGuide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes21.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {
    private final int mCount;
    private final BaseFragment[] mwy;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mwy = new BaseFragment[]{new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.mCount = this.mwy.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.mwy[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
