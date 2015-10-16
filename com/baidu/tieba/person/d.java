package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private int[] bFV;
    private ArrayList<BaseFragment> cnY;

    protected abstract BaseFragment aif();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cnY = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aif = aif();
        aif.setArguments(bundle);
        this.cnY.add(aif);
        if (z) {
            this.bFV = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aif2 = aif();
        aif2.setArguments(bundle2);
        this.cnY.add(aif2);
        this.bFV = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bFV.length || i < 0) {
            return null;
        }
        return this.cnY.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bFV.length;
    }

    public int hv(int i) {
        return this.bFV[i];
    }
}
