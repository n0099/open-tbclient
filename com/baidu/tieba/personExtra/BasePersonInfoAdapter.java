package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bZC;
    private ArrayList<BaseFragment> gsU;

    protected abstract BaseFragment boZ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gsU = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment boZ = boZ();
        boZ.setArguments(bundle);
        this.gsU.add(boZ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment boZ2 = boZ();
            boZ2.setArguments(bundle2);
            this.gsU.add(boZ2);
            this.bZC = new int[]{0, 1};
            return;
        }
        this.bZC = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bZC.length || i < 0) {
            return null;
        }
        return this.gsU.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bZC.length;
    }

    public int qp(int i) {
        return this.bZC[i];
    }
}
