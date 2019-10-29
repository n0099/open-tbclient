package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes6.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] dKs;
    private PersonThreadFragment iCc;
    private PersonReplyFragment iCd;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cdy());
        this.iCd = new PersonReplyFragment();
        this.iCd.setArguments(bundle);
        this.iCd.a(personPostActivity);
        this.iCc = new PersonThreadFragment();
        this.iCc.setArguments(bundle);
        this.iCc.a((d) personPostActivity);
        this.iCc.a((b) personPostActivity);
        this.dKs = new int[]{0, 1};
    }

    public PersonThreadFragment cdz() {
        return this.iCc;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.iCc;
            case 1:
                return this.iCd;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int uD(int i) {
        return this.dKs[i];
    }
}
