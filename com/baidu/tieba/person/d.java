package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> bAR;
    private int[] bfH;

    protected abstract BaseFragment Zy();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.bAR = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment Zy = Zy();
        Zy.setArguments(bundle);
        this.bAR.add(Zy);
        if (z) {
            this.bfH = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment Zy2 = Zy();
        Zy2.setArguments(bundle2);
        this.bAR.add(Zy2);
        this.bfH = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bfH.length || i < 0) {
            return null;
        }
        return this.bAR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bfH.length;
    }

    public int gf(int i) {
        return this.bfH[i];
    }
}
