package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes23.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gcg;
    private PersonThreadFragment lFA;
    private PersonReplyFragment lFB;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.doC());
        this.lFB = new PersonReplyFragment();
        this.lFB.setArguments(bundle);
        this.lFB.a(personPostActivity);
        this.lFA = new PersonThreadFragment();
        this.lFA.setArguments(bundle);
        this.lFA.a((d) personPostActivity);
        this.lFA.a((b) personPostActivity);
        this.gcg = new int[]{0, 1};
    }

    public PersonThreadFragment doD() {
        return this.lFA;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.lFA;
            case 1:
                return this.lFB;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Cg(int i) {
        return this.gcg[i];
    }
}
