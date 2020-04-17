package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fin;
    private PersonThreadFragment klJ;
    private PersonReplyFragment klK;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cLc());
        this.klK = new PersonReplyFragment();
        this.klK.setArguments(bundle);
        this.klK.a(personPostActivity);
        this.klJ = new PersonThreadFragment();
        this.klJ.setArguments(bundle);
        this.klJ.a((d) personPostActivity);
        this.klJ.a((b) personPostActivity);
        this.fin = new int[]{0, 1};
    }

    public PersonThreadFragment cLd() {
        return this.klJ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.klJ;
            case 1:
                return this.klK;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int xv(int i) {
        return this.fin[i];
    }
}
