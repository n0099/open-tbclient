package com.baidu.tieba.tblauncherInterestGuide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes5.dex */
public class NewUserGuidePagerAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final BaseFragment[] f21246a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21247b;

    public NewUserGuidePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        BaseFragment[] baseFragmentArr = {new NewUserGuideIntroduceFragment(), new NewUserGuideMainFragment()};
        this.f21246a = baseFragmentArr;
        this.f21247b = baseFragmentArr.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f21247b;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.f21247b) {
            return null;
        }
        return this.f21246a[i];
    }
}
