package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dps;
    private ArrayList<BaseFragment> hMM;

    protected abstract BaseFragment bQO();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.hMM = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bQO = bQO();
        bQO.setArguments(bundle);
        this.hMM.add(bQO);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bQO2 = bQO();
            bQO2.setArguments(bundle2);
            this.hMM.add(bQO2);
            this.dps = new int[]{0, 1};
            return;
        }
        this.dps = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dps.length || i < 0) {
            return null;
        }
        return this.hMM.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dps.length;
    }

    public int uj(int i) {
        return this.dps[i];
    }
}
