package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes24.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gMU;
    private PersonThreadFragment mBJ;
    private PersonReplyFragment mBK;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dCN());
        this.mBK = new PersonReplyFragment();
        this.mBK.setArguments(bundle);
        this.mBK.a(personPostActivity);
        this.mBJ = new PersonThreadFragment();
        this.mBJ.setArguments(bundle);
        this.mBJ.a((d) personPostActivity);
        this.mBJ.a((b) personPostActivity);
        this.gMU = new int[]{0, 1};
    }

    public PersonThreadFragment dCO() {
        return this.mBJ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mBJ;
            case 1:
                return this.mBK;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int EF(int i) {
        return this.gMU[i];
    }
}
