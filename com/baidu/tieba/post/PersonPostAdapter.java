package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes24.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gEq;
    private PersonThreadFragment mnl;
    private PersonReplyFragment mnm;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dxW());
        this.mnm = new PersonReplyFragment();
        this.mnm.setArguments(bundle);
        this.mnm.a(personPostActivity);
        this.mnl = new PersonThreadFragment();
        this.mnl.setArguments(bundle);
        this.mnl.a((d) personPostActivity);
        this.mnl.a((b) personPostActivity);
        this.gEq = new int[]{0, 1};
    }

    public PersonThreadFragment dxX() {
        return this.mnl;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mnl;
            case 1:
                return this.mnm;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Ds(int i) {
        return this.gEq[i];
    }
}
