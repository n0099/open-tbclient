package com.baidu.tieba.memberCenter.memberpay;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayListAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<MemberPayFragment> f18362a;

    public MemberPayListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<MemberPayFragment> list = this.f18362a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.fragment.app.FragmentPagerAdapter
    /* renamed from: i */
    public MemberPayFragment getItem(int i2) {
        if (this.f18362a.size() > i2) {
            return this.f18362a.get(i2);
        }
        return null;
    }

    public void j(List<MemberPayFragment> list) {
        this.f18362a = list;
    }
}
