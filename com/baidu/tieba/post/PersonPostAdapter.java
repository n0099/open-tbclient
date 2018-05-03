package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bvg;
    private PersonThreadFragment fRX;
    private PersonReplyFragment fRY;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bhq());
        this.fRY = new PersonReplyFragment();
        this.fRY.setArguments(bundle);
        this.fRY.a(personPostActivity);
        this.fRX = new PersonThreadFragment();
        this.fRX.setArguments(bundle);
        this.fRX.a((d) personPostActivity);
        this.fRX.a((b) personPostActivity);
        this.bvg = new int[]{0, 1};
    }

    public PersonThreadFragment bhr() {
        return this.fRX;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.fRX;
            case 1:
                return this.fRY;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int nU(int i) {
        return this.bvg[i];
    }
}
