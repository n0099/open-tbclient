package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bZF;
    private ArrayList<BaseFragment> gvL;

    protected abstract BaseFragment bpK();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gvL = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bpK = bpK();
        bpK.setArguments(bundle);
        this.gvL.add(bpK);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bpK2 = bpK();
            bpK2.setArguments(bundle2);
            this.gvL.add(bpK2);
            this.bZF = new int[]{0, 1};
            return;
        }
        this.bZF = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bZF.length || i < 0) {
            return null;
        }
        return this.gvL.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bZF.length;
    }

    public int qC(int i) {
        return this.bZF[i];
    }
}
