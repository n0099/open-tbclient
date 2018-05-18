package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bvQ;
    private ArrayList<BaseFragment> fGf;

    protected abstract BaseFragment bed();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.fGf = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bed = bed();
        bed.setArguments(bundle);
        this.fGf.add(bed);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bed2 = bed();
            bed2.setArguments(bundle2);
            this.fGf.add(bed2);
            this.bvQ = new int[]{0, 1};
            return;
        }
        this.bvQ = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bvQ.length || i < 0) {
            return null;
        }
        return this.fGf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bvQ.length;
    }

    public int nT(int i) {
        return this.bvQ[i];
    }
}
