package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fwa;
    private PersonThreadFragment kDI;
    private PersonReplyFragment kDJ;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cSa());
        this.kDJ = new PersonReplyFragment();
        this.kDJ.setArguments(bundle);
        this.kDJ.a(personPostActivity);
        this.kDI = new PersonThreadFragment();
        this.kDI.setArguments(bundle);
        this.kDI.a((d) personPostActivity);
        this.kDI.a((b) personPostActivity);
        this.fwa = new int[]{0, 1};
    }

    public PersonThreadFragment cSb() {
        return this.kDI;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.kDI;
            case 1:
                return this.kDJ;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int yb(int i) {
        return this.fwa[i];
    }
}
