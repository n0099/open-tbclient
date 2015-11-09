package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private int[] bGq;
    private ArrayList<BaseFragment> cpu;

    protected abstract BaseFragment aiH();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.cpu = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment aiH = aiH();
        aiH.setArguments(bundle);
        this.cpu.add(aiH);
        if (z) {
            this.bGq = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        BaseFragment aiH2 = aiH();
        aiH2.setArguments(bundle2);
        this.cpu.add(aiH2);
        this.bGq = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bGq.length || i < 0) {
            return null;
        }
        return this.cpu.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bGq.length;
    }

    public int hI(int i) {
        return this.bGq[i];
    }
}
