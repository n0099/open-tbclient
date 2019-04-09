package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dpt;
    private ArrayList<BaseFragment> hMN;

    protected abstract BaseFragment bQO();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.hMN = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bQO = bQO();
        bQO.setArguments(bundle);
        this.hMN.add(bQO);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bQO2 = bQO();
            bQO2.setArguments(bundle2);
            this.hMN.add(bQO2);
            this.dpt = new int[]{0, 1};
            return;
        }
        this.dpt = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dpt.length || i < 0) {
            return null;
        }
        return this.hMN.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dpt.length;
    }

    public int uj(int i) {
        return this.dpt[i];
    }
}
