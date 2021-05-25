package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes5.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int[] f20009a;

    /* renamed from: b  reason: collision with root package name */
    public PersonThreadFragment f20010b;

    /* renamed from: c  reason: collision with root package name */
    public PersonReplyFragment f20011c;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString(PersonPostActivity.KEY_EMPTYVIEW_TXT, personPostActivity.getEmptyViewText());
        PersonReplyFragment personReplyFragment = new PersonReplyFragment();
        this.f20011c = personReplyFragment;
        personReplyFragment.setArguments(bundle);
        this.f20011c.U0(personPostActivity);
        PersonThreadFragment personThreadFragment = new PersonThreadFragment();
        this.f20010b = personThreadFragment;
        personThreadFragment.setArguments(bundle);
        this.f20010b.T0(personPostActivity);
        this.f20010b.S0(personPostActivity);
        this.f20009a = new int[]{0, 1};
    }

    public int b(int i2) {
        return this.f20009a[i2];
    }

    public PersonThreadFragment c() {
        return this.f20010b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return null;
            }
            return this.f20011c;
        }
        return this.f20010b;
    }
}
