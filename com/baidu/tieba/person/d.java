package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bOR;
    private int[] blI;

    protected abstract BaseFragment acY();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bOR = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment acY = acY();
        acY.setArguments(bundle);
        this.bOR.add(acY);
        if (z) {
            this.blI = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment acY2 = acY();
        acY2.setArguments(bundle2);
        this.bOR.add(acY2);
        this.blI = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.blI.length || i < 0) {
            return null;
        }
        return this.bOR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.blI.length;
    }

    public int gk(int i) {
        return this.blI[i];
    }
}
