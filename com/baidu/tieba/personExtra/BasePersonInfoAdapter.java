package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] eDx;
    private ArrayList<BaseFragment> jjm;

    protected abstract BaseFragment cvJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jjm = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cvJ = cvJ();
        cvJ.setArguments(bundle);
        this.jjm.add(cvJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cvJ2 = cvJ();
            cvJ2.setArguments(bundle2);
            this.jjm.add(cvJ2);
            this.eDx = new int[]{0, 1};
            return;
        }
        this.eDx = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.eDx.length || i < 0) {
            return null;
        }
        return this.jjm.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eDx.length;
    }

    public int wP(int i) {
        return this.eDx[i];
    }
}
