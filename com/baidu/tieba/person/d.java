package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bQU;
    private int[] bon;

    protected abstract BaseFragment adZ();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bQU = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment adZ = adZ();
        adZ.setArguments(bundle);
        this.bQU.add(adZ);
        if (z) {
            this.bon = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment adZ2 = adZ();
        adZ2.setArguments(bundle2);
        this.bQU.add(adZ2);
        this.bon = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bon.length || i < 0) {
            return null;
        }
        return this.bQU.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bon.length;
    }

    public int gB(int i) {
        return this.bon[i];
    }
}
