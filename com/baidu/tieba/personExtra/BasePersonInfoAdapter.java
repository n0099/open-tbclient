package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fis;
    private ArrayList<BaseFragment> jVe;

    protected abstract BaseFragment cGJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jVe = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cGJ = cGJ();
        cGJ.setArguments(bundle);
        this.jVe.add(cGJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cGJ2 = cGJ();
            cGJ2.setArguments(bundle2);
            this.jVe.add(cGJ2);
            this.fis = new int[]{0, 1};
            return;
        }
        this.fis = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fis.length || i < 0) {
            return null;
        }
        return this.jVe.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fis.length;
    }

    public int xv(int i) {
        return this.fis[i];
    }
}
