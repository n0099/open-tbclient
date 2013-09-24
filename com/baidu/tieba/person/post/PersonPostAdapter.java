package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    PersonThreadFragment f1704a;
    PersonReplyFragment b;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.a());
        bundle.putString("key_portrait_url", personPostActivity.c());
        bundle.putString("key_empty_view_text", personPostActivity.d());
        this.b = new PersonReplyFragment();
        this.b.g(bundle);
        this.f1704a = new PersonThreadFragment();
        this.f1704a.g(bundle);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        switch (i) {
            case 0:
                return this.f1704a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return 2;
    }

    public void c(int i) {
    }
}
