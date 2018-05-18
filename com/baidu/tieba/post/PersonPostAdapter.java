package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bvQ;
    private PersonThreadFragment fTd;
    private PersonReplyFragment fTe;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bhq());
        this.fTe = new PersonReplyFragment();
        this.fTe.setArguments(bundle);
        this.fTe.a(personPostActivity);
        this.fTd = new PersonThreadFragment();
        this.fTd.setArguments(bundle);
        this.fTd.a((d) personPostActivity);
        this.fTd.a((b) personPostActivity);
        this.bvQ = new int[]{0, 1};
    }

    public PersonThreadFragment bhr() {
        return this.fTd;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.fTd;
            case 1:
                return this.fTe;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int nT(int i) {
        return this.bvQ[i];
    }
}
