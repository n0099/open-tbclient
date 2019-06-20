package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dzZ;
    private ArrayList<BaseFragment> ifl;

    protected abstract BaseFragment bYO();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.ifl = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bYO = bYO();
        bYO.setArguments(bundle);
        this.ifl.add(bYO);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bYO2 = bYO();
            bYO2.setArguments(bundle2);
            this.ifl.add(bYO2);
            this.dzZ = new int[]{0, 1};
            return;
        }
        this.dzZ = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dzZ.length || i < 0) {
            return null;
        }
        return this.ifl.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dzZ.length;
    }

    public int vq(int i) {
        return this.dzZ[i];
    }
}
