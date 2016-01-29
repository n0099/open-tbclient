package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> cWz;
    private int[] cdE;

    protected abstract BaseFragment atm();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cWz = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment atm = atm();
        atm.setArguments(bundle);
        this.cWz.add(atm);
        if (z) {
            this.cdE = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment atm2 = atm();
        atm2.setArguments(bundle2);
        this.cWz.add(atm2);
        this.cdE = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.cdE.length || i < 0) {
            return null;
        }
        return this.cWz.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cdE.length;
    }

    public int js(int i) {
        return this.cdE[i];
    }
}
