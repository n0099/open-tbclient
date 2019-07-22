package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dDt;
    private ArrayList<BaseFragment> ilB;

    protected abstract BaseFragment cbD();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.ilB = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cbD = cbD();
        cbD.setArguments(bundle);
        this.ilB.add(cbD);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cbD2 = cbD();
            cbD2.setArguments(bundle2);
            this.ilB.add(cbD2);
            this.dDt = new int[]{0, 1};
            return;
        }
        this.dDt = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dDt.length || i < 0) {
            return null;
        }
        return this.ilB.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dDt.length;
    }

    public int vR(int i) {
        return this.dDt[i];
    }
}
