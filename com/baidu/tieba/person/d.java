package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bOB;
    private int[] bls;

    protected abstract BaseFragment acJ();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bOB = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment acJ = acJ();
        acJ.setArguments(bundle);
        this.bOB.add(acJ);
        if (z) {
            this.bls = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment acJ2 = acJ();
        acJ2.setArguments(bundle2);
        this.bOB.add(acJ2);
        this.bls = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bls.length || i < 0) {
            return null;
        }
        return this.bOB.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bls.length;
    }

    public int gi(int i) {
        return this.bls[i];
    }
}
