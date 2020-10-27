package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gyC;
    private ArrayList<BaseFragment> lRD;

    protected abstract BaseFragment drB();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lRD = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment drB = drB();
        drB.setArguments(bundle);
        this.lRD.add(drB);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment drB2 = drB();
            drB2.setArguments(bundle2);
            this.lRD.add(drB2);
            this.gyC = new int[]{0, 1};
            return;
        }
        this.gyC = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gyC.length || i < 0) {
            return null;
        }
        return this.lRD.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gyC.length;
    }

    public int Df(int i) {
        return this.gyC[i];
    }
}
