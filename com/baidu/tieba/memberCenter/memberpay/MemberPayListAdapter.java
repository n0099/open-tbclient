package com.baidu.tieba.memberCenter.memberpay;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class MemberPayListAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<MemberPayFragment> f18664a;

    public MemberPayListAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<MemberPayFragment> list = this.f18664a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.fragment.app.FragmentPagerAdapter
    /* renamed from: i */
    public MemberPayFragment getItem(int i) {
        if (this.f18664a.size() > i) {
            return this.f18664a.get(i);
        }
        return null;
    }

    public void j(List<MemberPayFragment> list) {
        this.f18664a = list;
    }
}
