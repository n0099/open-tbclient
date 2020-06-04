package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fwl;
    private ArrayList<BaseFragment> kod;

    protected abstract BaseFragment cNZ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.kod = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cNZ = cNZ();
        cNZ.setArguments(bundle);
        this.kod.add(cNZ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cNZ2 = cNZ();
            cNZ2.setArguments(bundle2);
            this.kod.add(cNZ2);
            this.fwl = new int[]{0, 1};
            return;
        }
        this.fwl = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fwl.length || i < 0) {
            return null;
        }
        return this.kod.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fwl.length;
    }

    public int yd(int i) {
        return this.fwl[i];
    }
}
