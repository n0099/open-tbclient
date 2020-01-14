package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes9.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] ezc;
    private PersonThreadFragment jzb;
    private PersonReplyFragment jzc;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cyA());
        this.jzc = new PersonReplyFragment();
        this.jzc.setArguments(bundle);
        this.jzc.a(personPostActivity);
        this.jzb = new PersonThreadFragment();
        this.jzb.setArguments(bundle);
        this.jzb.a((d) personPostActivity);
        this.jzb.a((b) personPostActivity);
        this.ezc = new int[]{0, 1};
    }

    public PersonThreadFragment cyB() {
        return this.jzb;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jzb;
            case 1:
                return this.jzc;
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
