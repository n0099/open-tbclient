package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dFl;
    private PersonThreadFragment iDG;
    private PersonReplyFragment iDH;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cgy());
        this.iDH = new PersonReplyFragment();
        this.iDH.setArguments(bundle);
        this.iDH.a(personPostActivity);
        this.iDG = new PersonThreadFragment();
        this.iDG.setArguments(bundle);
        this.iDG.a((d) personPostActivity);
        this.iDG.a((b) personPostActivity);
        this.dFl = new int[]{0, 1};
    }

    public PersonThreadFragment cgz() {
        return this.iDG;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iDG;
            case 1:
                return this.iDH;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int vX(int i) {
        return this.dFl[i];
    }
}
