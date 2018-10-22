package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bUW;
    private ArrayList<BaseFragment> gkF;

    protected abstract BaseFragment bnL();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gkF = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bnL = bnL();
        bnL.setArguments(bundle);
        this.gkF.add(bnL);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bnL2 = bnL();
            bnL2.setArguments(bundle2);
            this.gkF.add(bnL2);
            this.bUW = new int[]{0, 1};
            return;
        }
        this.bUW = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bUW.length || i < 0) {
            return null;
        }
        return this.gkF.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bUW.length;
    }

    public int pC(int i) {
        return this.bUW[i];
    }
}
