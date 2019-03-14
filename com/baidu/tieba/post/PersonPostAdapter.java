package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dpp;
    private PersonThreadFragment iby;
    private PersonReplyFragment ibz;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bUB());
        this.ibz = new PersonReplyFragment();
        this.ibz.setArguments(bundle);
        this.ibz.a(personPostActivity);
        this.iby = new PersonThreadFragment();
        this.iby.setArguments(bundle);
        this.iby.a((d) personPostActivity);
        this.iby.a((b) personPostActivity);
        this.dpp = new int[]{0, 1};
    }

    public PersonThreadFragment bUC() {
        return this.iby;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iby;
            case 1:
                return this.ibz;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int un(int i) {
        return this.dpp[i];
    }
}
