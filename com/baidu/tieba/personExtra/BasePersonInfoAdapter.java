package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dKs;
    private ArrayList<BaseFragment> inq;

    protected abstract BaseFragment bZL();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.inq = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bZL = bZL();
        bZL.setArguments(bundle);
        this.inq.add(bZL);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bZL2 = bZL();
            bZL2.setArguments(bundle2);
            this.inq.add(bZL2);
            this.dKs = new int[]{0, 1};
            return;
        }
        this.dKs = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dKs.length || i < 0) {
            return null;
        }
        return this.inq.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dKs.length;
    }

    public int uD(int i) {
        return this.dKs[i];
    }
}
