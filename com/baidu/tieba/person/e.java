package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private int[] coj;
    private ArrayList<BaseFragment> drb;

    protected abstract BaseFragment aAS();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.drb = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt(LegoListActivityConfig.PAGE_TYPE, 0);
        BaseFragment aAS = aAS();
        aAS.setArguments(bundle);
        this.drb.add(aAS);
        if (z) {
            this.coj = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt(LegoListActivityConfig.PAGE_TYPE, 1);
        BaseFragment aAS2 = aAS();
        aAS2.setArguments(bundle2);
        this.drb.add(aAS2);
        this.coj = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.coj.length || i < 0) {
            return null;
        }
        return this.drb.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.coj.length;
    }

    public int jY(int i) {
        return this.coj[i];
    }
}
