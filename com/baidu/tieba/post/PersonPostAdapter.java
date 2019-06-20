package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dzZ;
    private PersonThreadFragment itT;
    private PersonReplyFragment itU;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.ccC());
        this.itU = new PersonReplyFragment();
        this.itU.setArguments(bundle);
        this.itU.a(personPostActivity);
        this.itT = new PersonThreadFragment();
        this.itT.setArguments(bundle);
        this.itT.a((d) personPostActivity);
        this.itT.a((b) personPostActivity);
        this.dzZ = new int[]{0, 1};
    }

    public PersonThreadFragment ccD() {
        return this.itT;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.itT;
            case 1:
                return this.itU;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int vq(int i) {
        return this.dzZ[i];
    }
}
