package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private int[] a;
    private t b;
    private l c;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.g());
        bundle.putString("key_portrait_url", personPostActivity.i());
        bundle.putString("key_empty_view_text", personPostActivity.j());
        this.c = new l();
        this.c.setArguments(bundle);
        this.b = new t();
        this.b.setArguments(bundle);
        this.a = new int[]{0, 1};
    }

    public t a() {
        return this.b;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.b;
            case 1:
                return this.c;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int a(int i) {
        return this.a[i];
    }
}
