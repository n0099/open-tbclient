package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int[] f19769a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<BaseFragment> f19770b;

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.f19770b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment b2 = b();
        b2.setArguments(bundle);
        this.f19770b.add(b2);
        if (z) {
            this.f19769a = new int[]{0};
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment b3 = b();
        b3.setArguments(bundle2);
        this.f19770b.add(b3);
        this.f19769a = new int[]{0, 1};
    }

    public abstract BaseFragment b();

    public int c(int i2) {
        return this.f19769a[i2];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f19769a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 >= this.f19769a.length || i2 < 0) {
            return null;
        }
        return this.f19770b.get(i2);
    }
}
