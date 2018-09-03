package com.baidu.tieba.tblauncherInterestGuide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {
    private final BaseFragment[] gUE;
    private final int mCount;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.gUE = new BaseFragment[]{new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.mCount = this.gUE.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.gUE[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
