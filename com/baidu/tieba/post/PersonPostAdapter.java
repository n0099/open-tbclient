package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] car;
    private PersonThreadFragment gKa;
    private PersonReplyFragment gKb;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.btM());
        this.gKb = new PersonReplyFragment();
        this.gKb.setArguments(bundle);
        this.gKb.a(personPostActivity);
        this.gKa = new PersonThreadFragment();
        this.gKa.setArguments(bundle);
        this.gKa.a((d) personPostActivity);
        this.gKa.a((b) personPostActivity);
        this.car = new int[]{0, 1};
    }

    public PersonThreadFragment btN() {
        return this.gKa;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gKa;
            case 1:
                return this.gKb;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qD(int i) {
        return this.car[i];
    }
}
