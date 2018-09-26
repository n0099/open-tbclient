package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bMu;
    private ArrayList<BaseFragment> gdc;

    protected abstract BaseFragment bkA();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gdc = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bkA = bkA();
        bkA.setArguments(bundle);
        this.gdc.add(bkA);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bkA2 = bkA();
            bkA2.setArguments(bundle2);
            this.gdc.add(bkA2);
            this.bMu = new int[]{0, 1};
            return;
        }
        this.bMu = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bMu.length || i < 0) {
            return null;
        }
        return this.gdc.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bMu.length;
    }

    public int pe(int i) {
        return this.bMu[i];
    }
}
