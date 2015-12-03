package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private int[] bVx;
    private ArrayList<BaseFragment> cIP;

    protected abstract BaseFragment ank();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cIP = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment ank = ank();
        ank.setArguments(bundle);
        this.cIP.add(ank);
        if (z) {
            this.bVx = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment ank2 = ank();
        ank2.setArguments(bundle2);
        this.cIP.add(ank2);
        this.bVx = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bVx.length || i < 0) {
            return null;
        }
        return this.cIP.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bVx.length;
    }

    public int iw(int i) {
        return this.bVx[i];
    }
}
