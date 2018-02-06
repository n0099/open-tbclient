package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class a extends FragmentPagerAdapter {
    private int[] clo;
    private ArrayList<BaseFragment> gkA;

    protected abstract BaseFragment bjc();

    public a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gkA = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bjc = bjc();
        bjc.setArguments(bundle);
        this.gkA.add(bjc);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bjc2 = bjc();
            bjc2.setArguments(bundle2);
            this.gkA.add(bjc2);
            this.clo = new int[]{0, 1};
            return;
        }
        this.clo = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.clo.length || i < 0) {
            return null;
        }
        return this.gkA.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.clo.length;
    }

    public int qx(int i) {
        return this.clo[i];
    }
}
