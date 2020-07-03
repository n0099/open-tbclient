package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fHv;
    private PersonThreadFragment kYM;
    private PersonReplyFragment kYN;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cWG());
        this.kYN = new PersonReplyFragment();
        this.kYN.setArguments(bundle);
        this.kYN.a(personPostActivity);
        this.kYM = new PersonThreadFragment();
        this.kYM.setArguments(bundle);
        this.kYM.a((d) personPostActivity);
        this.kYM.a((b) personPostActivity);
        this.fHv = new int[]{0, 1};
    }

    public PersonThreadFragment cWH() {
        return this.kYM;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.kYM;
            case 1:
                return this.kYN;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int yN(int i) {
        return this.fHv[i];
    }
}
