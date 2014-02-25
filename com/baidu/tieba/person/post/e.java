package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class e extends FragmentPagerAdapter {
    w a;
    q b;

    public e(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.e());
        bundle.putString("key_portrait_url", personPostActivity.g());
        bundle.putString("key_empty_view_text", personPostActivity.h());
        this.b = new q();
        this.b.setArguments(bundle);
        this.a = new w();
        this.a.setArguments(bundle);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public void a(int i) {
    }
}
