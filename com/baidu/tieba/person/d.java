package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class d extends FragmentPagerAdapter {
    private int[] a;
    private ArrayList<com.baidu.tbadk.core.d> b;

    protected abstract com.baidu.tbadk.core.d a();

    public d(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.b = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        com.baidu.tbadk.core.d a = a();
        a.setArguments(bundle);
        this.b.add(a);
        if (z) {
            this.a = new int[1];
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("page_type", 1);
        com.baidu.tbadk.core.d a2 = a();
        a2.setArguments(bundle2);
        this.b.add(a2);
        this.a = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.a.length || i < 0) {
            return null;
        }
        return this.b.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.a.length;
    }

    public int a(int i) {
        return this.a[i];
    }
}
