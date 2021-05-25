package com.baidu.wallet.personal.ui.fragment.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment;
import java.util.List;
/* loaded from: classes5.dex */
public class CardListFragmentPageAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<CardListBaseFragment> f26320a;

    public CardListFragmentPageAdapter(FragmentManager fragmentManager, List<CardListBaseFragment> list) {
        super(fragmentManager);
        this.f26320a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f26320a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return this.f26320a.get(i2);
    }
}
