package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dJB;
    private PersonThreadFragment iBl;
    private PersonReplyFragment iBm;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cdw());
        this.iBm = new PersonReplyFragment();
        this.iBm.setArguments(bundle);
        this.iBm.a(personPostActivity);
        this.iBl = new PersonThreadFragment();
        this.iBl.setArguments(bundle);
        this.iBl.a((d) personPostActivity);
        this.iBl.a((b) personPostActivity);
        this.dJB = new int[]{0, 1};
    }

    public PersonThreadFragment cdx() {
        return this.iBl;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iBl;
            case 1:
                return this.iBm;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int uC(int i) {
        return this.dJB[i];
    }
}
