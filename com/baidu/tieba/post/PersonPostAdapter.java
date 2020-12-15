package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes24.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gMW;
    private PersonThreadFragment mBL;
    private PersonReplyFragment mBM;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dCO());
        this.mBM = new PersonReplyFragment();
        this.mBM.setArguments(bundle);
        this.mBM.a(personPostActivity);
        this.mBL = new PersonThreadFragment();
        this.mBL.setArguments(bundle);
        this.mBL.a((d) personPostActivity);
        this.mBL.a((b) personPostActivity);
        this.gMW = new int[]{0, 1};
    }

    public PersonThreadFragment dCP() {
        return this.mBL;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mBL;
            case 1:
                return this.mBM;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int EF(int i) {
        return this.gMW[i];
    }
}
