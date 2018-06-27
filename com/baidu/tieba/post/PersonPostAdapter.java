package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bFQ;
    private PersonThreadFragment git;
    private PersonReplyFragment giu;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bmS());
        this.giu = new PersonReplyFragment();
        this.giu.setArguments(bundle);
        this.giu.a(personPostActivity);
        this.git = new PersonThreadFragment();
        this.git.setArguments(bundle);
        this.git.a((d) personPostActivity);
        this.git.a((b) personPostActivity);
        this.bFQ = new int[]{0, 1};
    }

    public PersonThreadFragment bmT() {
        return this.git;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.git;
            case 1:
                return this.giu;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int om(int i) {
        return this.bFQ[i];
    }
}
