package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dFl;
    private ArrayList<BaseFragment> ioG;

    protected abstract BaseFragment ccJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.ioG = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment ccJ = ccJ();
        ccJ.setArguments(bundle);
        this.ioG.add(ccJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment ccJ2 = ccJ();
            ccJ2.setArguments(bundle2);
            this.ioG.add(ccJ2);
            this.dFl = new int[]{0, 1};
            return;
        }
        this.dFl = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dFl.length || i < 0) {
            return null;
        }
        return this.ioG.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dFl.length;
    }

    public int vX(int i) {
        return this.dFl[i];
    }
}
