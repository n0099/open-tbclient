package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] eDk;
    private PersonThreadFragment jzT;
    private PersonReplyFragment jzU;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.czX());
        this.jzU = new PersonReplyFragment();
        this.jzU.setArguments(bundle);
        this.jzU.a(personPostActivity);
        this.jzT = new PersonThreadFragment();
        this.jzT.setArguments(bundle);
        this.jzT.a((d) personPostActivity);
        this.jzT.a((b) personPostActivity);
        this.eDk = new int[]{0, 1};
    }

    public PersonThreadFragment czY() {
        return this.jzT;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jzT;
            case 1:
                return this.jzU;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wP(int i) {
        return this.eDk[i];
    }
}
