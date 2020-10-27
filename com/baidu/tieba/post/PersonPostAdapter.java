package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes24.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gyC;
    private PersonThreadFragment mhn;
    private PersonReplyFragment mho;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dvu());
        this.mho = new PersonReplyFragment();
        this.mho.setArguments(bundle);
        this.mho.a(personPostActivity);
        this.mhn = new PersonThreadFragment();
        this.mhn.setArguments(bundle);
        this.mhn.a((d) personPostActivity);
        this.mhn.a((b) personPostActivity);
        this.gyC = new int[]{0, 1};
    }

    public PersonThreadFragment dvv() {
        return this.mhn;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mhn;
            case 1:
                return this.mho;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Df(int i) {
        return this.gyC[i];
    }
}
