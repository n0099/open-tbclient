package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bBf;
    private int[] bfV;

    protected abstract BaseFragment ZB();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bBf = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment ZB = ZB();
        ZB.setArguments(bundle);
        this.bBf.add(ZB);
        if (z) {
            this.bfV = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment ZB2 = ZB();
        ZB2.setArguments(bundle2);
        this.bBf.add(ZB2);
        this.bfV = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bfV.length || i < 0) {
            return null;
        }
        return this.bBf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bfV.length;
    }

    public int gf(int i) {
        return this.bfV[i];
    }
}
