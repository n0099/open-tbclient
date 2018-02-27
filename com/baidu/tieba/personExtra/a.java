package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class a extends FragmentPagerAdapter {
    private int[] clc;
    private ArrayList<BaseFragment> gkp;

    protected abstract BaseFragment bjb();

    public a(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gkp = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bjb = bjb();
        bjb.setArguments(bundle);
        this.gkp.add(bjb);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bjb2 = bjb();
            bjb2.setArguments(bundle2);
            this.gkp.add(bjb2);
            this.clc = new int[]{0, 1};
            return;
        }
        this.clc = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.clc.length || i < 0) {
            return null;
        }
        return this.gkp.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.clc.length;
    }

    public int qx(int i) {
        return this.clc[i];
    }
}
