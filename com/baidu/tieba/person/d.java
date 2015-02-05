package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bGD;
    private int[] bkD;

    protected abstract BaseFragment aaw();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bGD = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aaw = aaw();
        aaw.setArguments(bundle);
        this.bGD.add(aaw);
        if (z) {
            this.bkD = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aaw2 = aaw();
        aaw2.setArguments(bundle2);
        this.bGD.add(aaw2);
        this.bkD = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bkD.length || i < 0) {
            return null;
        }
        return this.bGD.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bkD.length;
    }

    public int gx(int i) {
        return this.bkD[i];
    }
}
