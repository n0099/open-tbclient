package com.baidu.tieba.memberCenter.memberpay;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayListAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<MemberPayFragment> f19088a;

    public MemberPayListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.fragment.app.FragmentPagerAdapter
    /* renamed from: b */
    public MemberPayFragment getItem(int i2) {
        if (this.f19088a.size() > i2) {
            return this.f19088a.get(i2);
        }
        return null;
    }

    public void c(List<MemberPayFragment> list) {
        this.f19088a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<MemberPayFragment> list = this.f19088a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
