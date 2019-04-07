package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dps;
    private PersonThreadFragment ibk;
    private PersonReplyFragment ibl;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bUx());
        this.ibl = new PersonReplyFragment();
        this.ibl.setArguments(bundle);
        this.ibl.a(personPostActivity);
        this.ibk = new PersonThreadFragment();
        this.ibk.setArguments(bundle);
        this.ibk.a((d) personPostActivity);
        this.ibk.a((b) personPostActivity);
        this.dps = new int[]{0, 1};
    }

    public PersonThreadFragment bUy() {
        return this.ibk;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.ibk;
            case 1:
                return this.ibl;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int uj(int i) {
        return this.dps[i];
    }
}
