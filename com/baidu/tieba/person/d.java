package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bET;
    private int[] bjh;

    protected abstract BaseFragment ZW();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bET = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment ZW = ZW();
        ZW.setArguments(bundle);
        this.bET.add(ZW);
        if (z) {
            this.bjh = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment ZW2 = ZW();
        ZW2.setArguments(bundle2);
        this.bET.add(ZW2);
        this.bjh = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bjh.length || i < 0) {
            return null;
        }
        return this.bET.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bjh.length;
    }

    public int go(int i) {
        return this.bjh[i];
    }
}
