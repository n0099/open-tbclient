package com.baidu.tieba.tblauncherInterestGuide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes2.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {
    private final int mCount;
    private final BaseFragment[] nvl;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.nvl = new BaseFragment[]{new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.mCount = this.nvl.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return this.nvl[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }
}
