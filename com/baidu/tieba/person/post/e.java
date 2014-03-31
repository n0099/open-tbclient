package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public final class e extends FragmentPagerAdapter {
    private int[] a;
    private u b;
    private o c;

    public e(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.f());
        bundle.putString("key_portrait_url", personPostActivity.g());
        bundle.putString("key_empty_view_text", personPostActivity.h());
        this.c = new o();
        this.c.setArguments(bundle);
        this.b = new u();
        this.b.setArguments(bundle);
        this.a = new int[]{0, 1};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
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
    public final int getCount() {
        return 2;
    }

    public final int a(int i) {
        return this.a[i];
    }
}
