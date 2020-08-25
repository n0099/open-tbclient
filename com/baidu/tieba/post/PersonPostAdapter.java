package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes18.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fYO;
    private PersonThreadFragment lwy;
    private PersonReplyFragment lwz;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dkS());
        this.lwz = new PersonReplyFragment();
        this.lwz.setArguments(bundle);
        this.lwz.a(personPostActivity);
        this.lwy = new PersonThreadFragment();
        this.lwy.setArguments(bundle);
        this.lwy.a((d) personPostActivity);
        this.lwy.a((b) personPostActivity);
        this.fYO = new int[]{0, 1};
    }

    public PersonThreadFragment dkT() {
        return this.lwy;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.lwy;
            case 1:
                return this.lwz;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int BF(int i) {
        return this.fYO[i];
    }
}
