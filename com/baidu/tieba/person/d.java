package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bGE;
    private int[] bkE;

    protected abstract BaseFragment aaB();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bGE = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aaB = aaB();
        aaB.setArguments(bundle);
        this.bGE.add(aaB);
        if (z) {
            this.bkE = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aaB2 = aaB();
        aaB2.setArguments(bundle2);
        this.bGE.add(aaB2);
        this.bkE = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bkE.length || i < 0) {
            return null;
        }
        return this.bGE.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bkE.length;
    }

    public int gx(int i) {
        return this.bkE[i];
    }
}
