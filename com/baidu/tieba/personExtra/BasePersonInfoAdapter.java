package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fHv;
    private ArrayList<BaseFragment> kHZ;

    protected abstract BaseFragment cSr();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.kHZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cSr = cSr();
        cSr.setArguments(bundle);
        this.kHZ.add(cSr);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cSr2 = cSr();
            cSr2.setArguments(bundle2);
            this.kHZ.add(cSr2);
            this.fHv = new int[]{0, 1};
            return;
        }
        this.fHv = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fHv.length || i < 0) {
            return null;
        }
        return this.kHZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fHv.length;
    }

    public int yN(int i) {
        return this.fHv[i];
    }
}
