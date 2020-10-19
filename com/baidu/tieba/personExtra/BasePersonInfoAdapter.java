package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gox;
    private ArrayList<BaseFragment> lFh;

    protected abstract BaseFragment dou();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lFh = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dou = dou();
        dou.setArguments(bundle);
        this.lFh.add(dou);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dou2 = dou();
            dou2.setArguments(bundle2);
            this.lFh.add(dou2);
            this.gox = new int[]{0, 1};
            return;
        }
        this.gox = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gox.length || i < 0) {
            return null;
        }
        return this.lFh.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gox.length;
    }

    public int CM(int i) {
        return this.gox[i];
    }
}
