package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private int[] bCH;
    private ArrayList<BaseFragment> cir;

    protected abstract BaseFragment agg();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cir = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment agg = agg();
        agg.setArguments(bundle);
        this.cir.add(agg);
        if (z) {
            this.bCH = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment agg2 = agg();
        agg2.setArguments(bundle2);
        this.cir.add(agg2);
        this.bCH = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bCH.length || i < 0) {
            return null;
        }
        return this.cir.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bCH.length;
    }

    public int hp(int i) {
        return this.bCH[i];
    }
}
