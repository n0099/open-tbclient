package com.baidu.tieba.tblauncherInterestGuide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes7.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {
    private final BaseFragment[] kmX;
    private final int mCount;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.kmX = new BaseFragment[]{new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.mCount = this.kmX.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.kmX[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
