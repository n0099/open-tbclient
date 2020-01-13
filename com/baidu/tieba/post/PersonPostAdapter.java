package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes9.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] ezc;
    private PersonThreadFragment jyW;
    private PersonReplyFragment jyX;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cyy());
        this.jyX = new PersonReplyFragment();
        this.jyX.setArguments(bundle);
        this.jyX.a(personPostActivity);
        this.jyW = new PersonThreadFragment();
        this.jyW.setArguments(bundle);
        this.jyW.a((d) personPostActivity);
        this.jyW.a((b) personPostActivity);
        this.ezc = new int[]{0, 1};
    }

    public PersonThreadFragment cyz() {
        return this.jyW;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jyW;
            case 1:
                return this.jyX;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wJ(int i) {
        return this.ezc[i];
    }
}
