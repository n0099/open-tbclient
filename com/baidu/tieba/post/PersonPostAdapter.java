package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bDT;
    private PersonThreadFragment ges;
    private PersonReplyFragment get;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bmo());
        this.get = new PersonReplyFragment();
        this.get.setArguments(bundle);
        this.get.a(personPostActivity);
        this.ges = new PersonThreadFragment();
        this.ges.setArguments(bundle);
        this.ges.a((d) personPostActivity);
        this.ges.a((b) personPostActivity);
        this.bDT = new int[]{0, 1};
    }

    public PersonThreadFragment bmp() {
        return this.ges;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.ges;
            case 1:
                return this.get;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int of(int i) {
        return this.bDT[i];
    }
}
