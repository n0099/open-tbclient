package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private int[] cpg;
    private ArrayList<BaseFragment> duw;

    protected abstract BaseFragment aBs();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.duw = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt(LegoListActivityConfig.PAGE_TYPE, 0);
        BaseFragment aBs = aBs();
        aBs.setArguments(bundle);
        this.duw.add(aBs);
        if (z) {
            this.cpg = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(LegoListActivityConfig.PAGE_TYPE, 1);
        BaseFragment aBs2 = aBs();
        aBs2.setArguments(bundle2);
        this.duw.add(aBs2);
        this.cpg = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.cpg.length || i < 0) {
            return null;
        }
        return this.duw.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cpg.length;
    }

    public int jC(int i) {
        return this.cpg[i];
    }
}
