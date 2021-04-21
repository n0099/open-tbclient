package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int[] f19975a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f19976b;

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.f19976b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment e2 = e();
        e2.setArguments(bundle);
        this.f19976b.add(e2);
        if (z) {
            this.f19975a = new int[]{0};
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment e3 = e();
        e3.setArguments(bundle2);
        this.f19976b.add(e3);
        this.f19975a = new int[]{0, 1};
    }

    public abstract BaseFragment e();

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f19975a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.f19975a.length || i < 0) {
            return null;
        }
        return this.f19976b.get(i);
    }

    public int i(int i) {
        return this.f19975a[i];
    }
}
