package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bDT;
    private ArrayList<BaseFragment> fRy;

    protected abstract BaseFragment bjd();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.fRy = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bjd = bjd();
        bjd.setArguments(bundle);
        this.fRy.add(bjd);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bjd2 = bjd();
            bjd2.setArguments(bundle2);
            this.fRy.add(bjd2);
            this.bDT = new int[]{0, 1};
            return;
        }
        this.bDT = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bDT.length || i < 0) {
            return null;
        }
        return this.fRy.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bDT.length;
    }

    public int of(int i) {
        return this.bDT[i];
    }
}
