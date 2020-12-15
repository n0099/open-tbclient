package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gMW;
    private ArrayList<BaseFragment> mmb;

    protected abstract BaseFragment dyW();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mmb = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dyW = dyW();
        dyW.setArguments(bundle);
        this.mmb.add(dyW);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dyW2 = dyW();
            dyW2.setArguments(bundle2);
            this.mmb.add(dyW2);
            this.gMW = new int[]{0, 1};
            return;
        }
        this.gMW = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gMW.length || i < 0) {
            return null;
        }
        return this.mmb.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gMW.length;
    }

    public int EF(int i) {
        return this.gMW[i];
    }
}
