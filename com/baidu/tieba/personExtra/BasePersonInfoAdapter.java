package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gcg;
    private ArrayList<BaseFragment> lpU;

    protected abstract BaseFragment dkK();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lpU = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dkK = dkK();
        dkK.setArguments(bundle);
        this.lpU.add(dkK);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dkK2 = dkK();
            dkK2.setArguments(bundle2);
            this.lpU.add(dkK2);
            this.gcg = new int[]{0, 1};
            return;
        }
        this.gcg = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gcg.length || i < 0) {
            return null;
        }
        return this.lpU.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gcg.length;
    }

    public int Cg(int i) {
        return this.gcg[i];
    }
}
