package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] exP;
    private ArrayList<BaseFragment> jex;

    protected abstract BaseFragment cte();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jex = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cte = cte();
        cte.setArguments(bundle);
        this.jex.add(cte);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cte2 = cte();
            cte2.setArguments(bundle2);
            this.jex.add(cte2);
            this.exP = new int[]{0, 1};
            return;
        }
        this.exP = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.exP.length || i < 0) {
            return null;
        }
        return this.jex.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.exP.length;
    }

    public int wE(int i) {
        return this.exP[i];
    }
}
