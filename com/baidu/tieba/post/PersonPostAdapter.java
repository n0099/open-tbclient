package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dzZ;
    private PersonThreadFragment itS;
    private PersonReplyFragment itT;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.ccB());
        this.itT = new PersonReplyFragment();
        this.itT.setArguments(bundle);
        this.itT.a(personPostActivity);
        this.itS = new PersonThreadFragment();
        this.itS.setArguments(bundle);
        this.itS.a((d) personPostActivity);
        this.itS.a((b) personPostActivity);
        this.dzZ = new int[]{0, 1};
    }

    public PersonThreadFragment ccC() {
        return this.itS;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.itS;
            case 1:
                return this.itT;
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
