package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] eDT;
    private ArrayList<BaseFragment> jkL;

    protected abstract BaseFragment cwc();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jkL = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cwc = cwc();
        cwc.setArguments(bundle);
        this.jkL.add(cwc);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cwc2 = cwc();
            cwc2.setArguments(bundle2);
            this.jkL.add(cwc2);
            this.eDT = new int[]{0, 1};
            return;
        }
        this.eDT = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.eDT.length || i < 0) {
            return null;
        }
        return this.jkL.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eDT.length;
    }

    public int wX(int i) {
        return this.eDT[i];
    }
}
