package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bvg;
    private ArrayList<BaseFragment> fEZ;

    protected abstract BaseFragment bed();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.fEZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bed = bed();
        bed.setArguments(bundle);
        this.fEZ.add(bed);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bed2 = bed();
            bed2.setArguments(bundle2);
            this.fEZ.add(bed2);
            this.bvg = new int[]{0, 1};
            return;
        }
        this.bvg = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bvg.length || i < 0) {
            return null;
        }
        return this.fEZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bvg.length;
    }

    public int nU(int i) {
        return this.bvg[i];
    }
}
