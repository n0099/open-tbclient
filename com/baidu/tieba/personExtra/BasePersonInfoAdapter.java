package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] eDj;
    private ArrayList<BaseFragment> jiY;

    protected abstract BaseFragment cvG();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jiY = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cvG = cvG();
        cvG.setArguments(bundle);
        this.jiY.add(cvG);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cvG2 = cvG();
            cvG2.setArguments(bundle2);
            this.jiY.add(cvG2);
            this.eDj = new int[]{0, 1};
            return;
        }
        this.eDj = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.eDj.length || i < 0) {
            return null;
        }
        return this.jiY.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eDj.length;
    }

    public int wP(int i) {
        return this.eDj[i];
    }
}
