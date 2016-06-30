package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private int[] cUw;
    private ArrayList<BaseFragment> ecO;

    protected abstract BaseFragment aKk();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.ecO = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aKk = aKk();
        aKk.setArguments(bundle);
        this.ecO.add(aKk);
        if (z) {
            this.cUw = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aKk2 = aKk();
        aKk2.setArguments(bundle2);
        this.ecO.add(aKk2);
        this.cUw = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.cUw.length || i < 0) {
            return null;
        }
        return this.ecO.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cUw.length;
    }

    public int le(int i) {
        return this.cUw[i];
    }
}
