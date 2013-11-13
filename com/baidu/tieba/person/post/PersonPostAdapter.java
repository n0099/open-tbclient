package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    PersonThreadFragment f2259a;
    PersonReplyFragment b;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.c());
        bundle.putString("key_portrait_url", personPostActivity.e());
        bundle.putString("key_empty_view_text", personPostActivity.f());
        this.b = new PersonReplyFragment();
        this.b.g(bundle);
        this.f2259a = new PersonThreadFragment();
        this.f2259a.g(bundle);
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment a(int i) {
        switch (i) {
            case 0:
                return this.f2259a;
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
