package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes8.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] exP;
    private PersonThreadFragment jvu;
    private PersonReplyFragment jvv;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cxr());
        this.jvv = new PersonReplyFragment();
        this.jvv.setArguments(bundle);
        this.jvv.a(personPostActivity);
        this.jvu = new PersonThreadFragment();
        this.jvu.setArguments(bundle);
        this.jvu.a((d) personPostActivity);
        this.jvu.a((b) personPostActivity);
        this.exP = new int[]{0, 1};
    }

    public PersonThreadFragment cxs() {
        return this.jvu;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jvu;
            case 1:
                return this.jvv;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wE(int i) {
        return this.exP[i];
    }
}
