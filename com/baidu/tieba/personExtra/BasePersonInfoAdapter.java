package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fin;
    private ArrayList<BaseFragment> jVa;

    protected abstract BaseFragment cGM();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jVa = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cGM = cGM();
        cGM.setArguments(bundle);
        this.jVa.add(cGM);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cGM2 = cGM();
            cGM2.setArguments(bundle2);
            this.jVa.add(cGM2);
            this.fin = new int[]{0, 1};
            return;
        }
        this.fin = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fin.length || i < 0) {
            return null;
        }
        return this.jVa.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fin.length;
    }

    public int xv(int i) {
        return this.fin[i];
    }
}
