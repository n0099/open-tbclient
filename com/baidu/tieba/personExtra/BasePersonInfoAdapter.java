package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dJB;
    private ArrayList<BaseFragment> imz;

    protected abstract BaseFragment bZJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.imz = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bZJ = bZJ();
        bZJ.setArguments(bundle);
        this.imz.add(bZJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bZJ2 = bZJ();
            bZJ2.setArguments(bundle2);
            this.imz.add(bZJ2);
            this.dJB = new int[]{0, 1};
            return;
        }
        this.dJB = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dJB.length || i < 0) {
            return null;
        }
        return this.imz.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dJB.length;
    }

    public int uC(int i) {
        return this.dJB[i];
    }
}
