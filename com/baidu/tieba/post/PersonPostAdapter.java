package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bMu;
    private PersonThreadFragment gql;
    private PersonReplyFragment gqm;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bnO());
        this.gqm = new PersonReplyFragment();
        this.gqm.setArguments(bundle);
        this.gqm.a(personPostActivity);
        this.gql = new PersonThreadFragment();
        this.gql.setArguments(bundle);
        this.gql.a((d) personPostActivity);
        this.gql.a((b) personPostActivity);
        this.bMu = new int[]{0, 1};
    }

    public PersonThreadFragment bnP() {
        return this.gql;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gql;
            case 1:
                return this.gqm;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int pe(int i) {
        return this.bMu[i];
    }
}
