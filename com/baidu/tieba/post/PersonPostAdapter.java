package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bUW;
    private PersonThreadFragment gxM;
    private PersonReplyFragment gxN;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.brd());
        this.gxN = new PersonReplyFragment();
        this.gxN.setArguments(bundle);
        this.gxN.a(personPostActivity);
        this.gxM = new PersonThreadFragment();
        this.gxM.setArguments(bundle);
        this.gxM.a((d) personPostActivity);
        this.gxM.a((b) personPostActivity);
        this.bUW = new int[]{0, 1};
    }

    public PersonThreadFragment bre() {
        return this.gxM;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gxM;
            case 1:
                return this.gxN;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int pC(int i) {
        return this.bUW[i];
    }
}
