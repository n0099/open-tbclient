package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] eDx;
    private PersonThreadFragment jAf;
    private PersonReplyFragment jAg;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.czY());
        this.jAg = new PersonReplyFragment();
        this.jAg.setArguments(bundle);
        this.jAg.a(personPostActivity);
        this.jAf = new PersonThreadFragment();
        this.jAf.setArguments(bundle);
        this.jAf.a((d) personPostActivity);
        this.jAf.a((b) personPostActivity);
        this.eDx = new int[]{0, 1};
    }

    public PersonThreadFragment czZ() {
        return this.jAf;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jAf;
            case 1:
                return this.jAg;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wP(int i) {
        return this.eDx[i];
    }
}
