package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dzY;
    private PersonThreadFragment itP;
    private PersonReplyFragment itQ;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.ccy());
        this.itQ = new PersonReplyFragment();
        this.itQ.setArguments(bundle);
        this.itQ.a(personPostActivity);
        this.itP = new PersonThreadFragment();
        this.itP.setArguments(bundle);
        this.itP.a((d) personPostActivity);
        this.itP.a((b) personPostActivity);
        this.dzY = new int[]{0, 1};
    }

    public PersonThreadFragment ccz() {
        return this.itP;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.itP;
            case 1:
                return this.itQ;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int vq(int i) {
        return this.dzY[i];
    }
}
