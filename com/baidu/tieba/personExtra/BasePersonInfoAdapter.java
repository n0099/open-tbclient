package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dDA;
    private ArrayList<BaseFragment> imG;

    protected abstract BaseFragment cbV();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.imG = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cbV = cbV();
        cbV.setArguments(bundle);
        this.imG.add(cbV);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cbV2 = cbV();
            cbV2.setArguments(bundle2);
            this.imG.add(cbV2);
            this.dDA = new int[]{0, 1};
            return;
        }
        this.dDA = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dDA.length || i < 0) {
            return null;
        }
        return this.imG.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dDA.length;
    }

    public int vT(int i) {
        return this.dDA[i];
    }
}
