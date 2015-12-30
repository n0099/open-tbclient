package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class e extends FragmentPagerAdapter {
    private int[] bZj;
    private ArrayList<BaseFragment> cNf;

    protected abstract BaseFragment aov();

    public e(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cNf = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aov = aov();
        aov.setArguments(bundle);
        this.cNf.add(aov);
        if (z) {
            this.bZj = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aov2 = aov();
        aov2.setArguments(bundle2);
        this.cNf.add(aov2);
        this.bZj = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bZj.length || i < 0) {
            return null;
        }
        return this.cNf.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bZj.length;
    }

    public int iV(int i) {
        return this.bZj[i];
    }
}
