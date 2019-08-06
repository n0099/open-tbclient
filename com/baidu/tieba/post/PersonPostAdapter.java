package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dDA;
    private PersonThreadFragment iBo;
    private PersonReplyFragment iBp;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cfK());
        this.iBp = new PersonReplyFragment();
        this.iBp.setArguments(bundle);
        this.iBp.a(personPostActivity);
        this.iBo = new PersonThreadFragment();
        this.iBo.setArguments(bundle);
        this.iBo.a((d) personPostActivity);
        this.iBo.a((b) personPostActivity);
        this.dDA = new int[]{0, 1};
    }

    public PersonThreadFragment cfL() {
        return this.iBo;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iBo;
            case 1:
                return this.iBp;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int vT(int i) {
        return this.dDA[i];
    }
}
