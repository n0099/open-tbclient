package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] ezc;
    private ArrayList<BaseFragment> jif;

    protected abstract BaseFragment cun();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jif = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cun = cun();
        cun.setArguments(bundle);
        this.jif.add(cun);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cun2 = cun();
            cun2.setArguments(bundle2);
            this.jif.add(cun2);
            this.ezc = new int[]{0, 1};
            return;
        }
        this.ezc = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.ezc.length || i < 0) {
            return null;
        }
        return this.jif.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.ezc.length;
    }

    public int wJ(int i) {
        return this.ezc[i];
    }
}
