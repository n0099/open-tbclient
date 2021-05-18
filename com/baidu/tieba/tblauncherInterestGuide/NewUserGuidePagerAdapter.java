package com.baidu.tieba.tblauncherInterestGuide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes5.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final BaseFragment[] f21091a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21092b;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        BaseFragment[] baseFragmentArr = {new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.f21091a = baseFragmentArr;
        this.f21092b = baseFragmentArr.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f21092b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 < 0 || i2 >= this.f21092b) {
            return null;
        }
        return this.f21091a[i2];
    }
}
