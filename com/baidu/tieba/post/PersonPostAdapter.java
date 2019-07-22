package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dDt;
    private PersonThreadFragment iAk;
    private PersonReplyFragment iAl;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cfs());
        this.iAl = new PersonReplyFragment();
        this.iAl.setArguments(bundle);
        this.iAl.a(personPostActivity);
        this.iAk = new PersonThreadFragment();
        this.iAk.setArguments(bundle);
        this.iAk.a((d) personPostActivity);
        this.iAk.a((b) personPostActivity);
        this.dDt = new int[]{0, 1};
    }

    public PersonThreadFragment cft() {
        return this.iAk;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iAk;
            case 1:
                return this.iAl;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int vR(int i) {
        return this.dDt[i];
    }
}
