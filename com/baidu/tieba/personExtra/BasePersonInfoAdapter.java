package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fMQ;
    private ArrayList<BaseFragment> kRa;

    protected abstract BaseFragment cWh();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.kRa = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cWh = cWh();
        cWh.setArguments(bundle);
        this.kRa.add(cWh);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cWh2 = cWh();
            cWh2.setArguments(bundle2);
            this.kRa.add(cWh2);
            this.fMQ = new int[]{0, 1};
            return;
        }
        this.fMQ = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fMQ.length || i < 0) {
            return null;
        }
        return this.kRa.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fMQ.length;
    }

    public int zm(int i) {
        return this.fMQ[i];
    }
}
