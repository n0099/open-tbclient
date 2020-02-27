package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] eDj;
    private PersonThreadFragment jzR;
    private PersonReplyFragment jzS;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.czV());
        this.jzS = new PersonReplyFragment();
        this.jzS.setArguments(bundle);
        this.jzS.a(personPostActivity);
        this.jzR = new PersonThreadFragment();
        this.jzR.setArguments(bundle);
        this.jzR.a((d) personPostActivity);
        this.jzR.a((b) personPostActivity);
        this.eDj = new int[]{0, 1};
    }

    public PersonThreadFragment czW() {
        return this.jzR;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jzR;
            case 1:
                return this.jzS;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wP(int i) {
        return this.eDj[i];
    }
}
