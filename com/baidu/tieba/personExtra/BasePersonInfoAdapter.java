package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gEq;
    private ArrayList<BaseFragment> lXz;

    protected abstract BaseFragment dud();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lXz = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dud = dud();
        dud.setArguments(bundle);
        this.lXz.add(dud);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dud2 = dud();
            dud2.setArguments(bundle2);
            this.lXz.add(dud2);
            this.gEq = new int[]{0, 1};
            return;
        }
        this.gEq = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gEq.length || i < 0) {
            return null;
        }
        return this.lXz.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gEq.length;
    }

    public int Ds(int i) {
        return this.gEq[i];
    }
}
