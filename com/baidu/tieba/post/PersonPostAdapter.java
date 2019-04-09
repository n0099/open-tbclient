package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dpt;
    private PersonThreadFragment ibl;
    private PersonReplyFragment ibm;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bUx());
        this.ibm = new PersonReplyFragment();
        this.ibm.setArguments(bundle);
        this.ibm.a(personPostActivity);
        this.ibl = new PersonThreadFragment();
        this.ibl.setArguments(bundle);
        this.ibl.a((d) personPostActivity);
        this.ibl.a((b) personPostActivity);
        this.dpt = new int[]{0, 1};
    }

    public PersonThreadFragment bUy() {
        return this.ibl;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.ibl;
            case 1:
                return this.ibm;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int uj(int i) {
        return this.dpt[i];
    }
}
