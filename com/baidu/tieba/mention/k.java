package com.baidu.tieba.mention;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public final class k extends FragmentPagerAdapter {
    private com.baidu.tbadk.core.d[] a;
    private int[] b;
    private int c;
    private com.baidu.adp.framework.c.a d;

    public k(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.d = new l(this, 2008002);
        com.baidu.adp.framework.c.a().a(this.d);
        boolean a = com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2008002));
        com.baidu.adp.framework.c.a().b(this.d);
        if (!a) {
            this.a = new com.baidu.tbadk.core.d[]{new af(), new a()};
            this.b = new int[]{1, 2};
            this.c = this.a.length;
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
        if (i < 0 || i >= this.c) {
            return null;
        }
        return this.a[i];
    }

    public final int a(int i) {
        return this.b[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.c;
    }
}
