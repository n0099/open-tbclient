package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bQT;
    private int[] bom;

    protected abstract BaseFragment adY();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bQT = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment adY = adY();
        adY.setArguments(bundle);
        this.bQT.add(adY);
        if (z) {
            this.bom = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment adY2 = adY();
        adY2.setArguments(bundle2);
        this.bQT.add(adY2);
        this.bom = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bom.length || i < 0) {
            return null;
        }
        return this.bQT.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bom.length;
    }

    public int gB(int i) {
        return this.bom[i];
    }
}
