package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int[] f20267a;

    /* renamed from: b  reason: collision with root package name */
    public PersonThreadFragment f20268b;

    /* renamed from: c  reason: collision with root package name */
    public PersonReplyFragment f20269c;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString(PersonPostActivity.KEY_EMPTYVIEW_TXT, personPostActivity.getEmptyViewText());
        PersonReplyFragment personReplyFragment = new PersonReplyFragment();
        this.f20269c = personReplyFragment;
        personReplyFragment.setArguments(bundle);
        this.f20269c.V0(personPostActivity);
        PersonThreadFragment personThreadFragment = new PersonThreadFragment();
        this.f20268b = personThreadFragment;
        personThreadFragment.setArguments(bundle);
        this.f20268b.U0(personPostActivity);
        this.f20268b.T0(personPostActivity);
        this.f20267a = new int[]{0, 1};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f20269c;
        }
        return this.f20268b;
    }

    public int i(int i) {
        return this.f20267a[i];
    }

    public PersonThreadFragment j() {
        return this.f20268b;
    }
}
