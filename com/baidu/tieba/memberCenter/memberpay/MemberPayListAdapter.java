package com.baidu.tieba.memberCenter.memberpay;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes8.dex */
public class MemberPayListAdapter extends FragmentPagerAdapter {
    private List<MemberPayFragment> list;

    public MemberPayListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void cv(List<MemberPayFragment> list) {
        this.list = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.fragment.app.FragmentPagerAdapter
    /* renamed from: Eg */
    public MemberPayFragment getItem(int i) {
        if (this.list.size() > i) {
            return this.list.get(i);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }
}
