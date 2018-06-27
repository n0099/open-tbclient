package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bFQ;
    private ArrayList<BaseFragment> fVA;

    protected abstract BaseFragment bjJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.fVA = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bjJ = bjJ();
        bjJ.setArguments(bundle);
        this.fVA.add(bjJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bjJ2 = bjJ();
            bjJ2.setArguments(bundle2);
            this.fVA.add(bjJ2);
            this.bFQ = new int[]{0, 1};
            return;
        }
        this.bFQ = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bFQ.length || i < 0) {
            return null;
        }
        return this.fVA.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bFQ.length;
    }

    public int om(int i) {
        return this.bFQ[i];
    }
}
