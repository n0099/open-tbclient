package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public final class k extends FragmentPagerAdapter {
    private final com.baidu.tieba.j[] a;
    private final int b;

    public k(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.a = new com.baidu.tieba.j[]{new com.baidu.tieba.chat.a(), new af(), new a()};
        this.b = this.a.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
        if (i < 0 || i >= this.b) {
            return null;
        }
        return this.a[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.b;
    }
}
