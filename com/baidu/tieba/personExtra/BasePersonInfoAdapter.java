package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gMU;
    private ArrayList<BaseFragment> mlZ;

    protected abstract BaseFragment dyV();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mlZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dyV = dyV();
        dyV.setArguments(bundle);
        this.mlZ.add(dyV);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dyV2 = dyV();
            dyV2.setArguments(bundle2);
            this.mlZ.add(dyV2);
            this.gMU = new int[]{0, 1};
            return;
        }
        this.gMU = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gMU.length || i < 0) {
            return null;
        }
        return this.mlZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gMU.length;
    }

    public int EF(int i) {
        return this.gMU[i];
    }
}
