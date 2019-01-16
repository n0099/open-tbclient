package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] caq;
    private ArrayList<BaseFragment> gwP;

    protected abstract BaseFragment bqt();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gwP = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bqt = bqt();
        bqt.setArguments(bundle);
        this.gwP.add(bqt);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bqt2 = bqt();
            bqt2.setArguments(bundle2);
            this.gwP.add(bqt2);
            this.caq = new int[]{0, 1};
            return;
        }
        this.caq = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.caq.length || i < 0) {
            return null;
        }
        return this.gwP.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.caq.length;
    }

    public int qD(int i) {
        return this.caq[i];
    }
}
