package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dpp;
    private ArrayList<BaseFragment> hNa;

    protected abstract BaseFragment bQS();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.hNa = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bQS = bQS();
        bQS.setArguments(bundle);
        this.hNa.add(bQS);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bQS2 = bQS();
            bQS2.setArguments(bundle2);
            this.hNa.add(bQS2);
            this.dpp = new int[]{0, 1};
            return;
        }
        this.dpp = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dpp.length || i < 0) {
            return null;
        }
        return this.hNa.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dpp.length;
    }

    public int un(int i) {
        return this.dpp[i];
    }
}
