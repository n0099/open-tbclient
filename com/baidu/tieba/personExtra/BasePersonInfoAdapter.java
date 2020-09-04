package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fYS;
    private ArrayList<BaseFragment> lgZ;

    protected abstract BaseFragment dhf();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lgZ = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dhf = dhf();
        dhf.setArguments(bundle);
        this.lgZ.add(dhf);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dhf2 = dhf();
            dhf2.setArguments(bundle2);
            this.lgZ.add(dhf2);
            this.fYS = new int[]{0, 1};
            return;
        }
        this.fYS = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fYS.length || i < 0) {
            return null;
        }
        return this.lgZ.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fYS.length;
    }

    public int BF(int i) {
        return this.fYS[i];
    }
}
