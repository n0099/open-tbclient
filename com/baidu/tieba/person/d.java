package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private int[] bCa;
    private ArrayList<BaseFragment> chx;

    protected abstract BaseFragment afQ();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.chx = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment afQ = afQ();
        afQ.setArguments(bundle);
        this.chx.add(afQ);
        if (z) {
            this.bCa = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment afQ2 = afQ();
        afQ2.setArguments(bundle2);
        this.chx.add(afQ2);
        this.bCa = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bCa.length || i < 0) {
            return null;
        }
        return this.chx.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bCa.length;
    }

    public int hf(int i) {
        return this.bCa[i];
    }
}
