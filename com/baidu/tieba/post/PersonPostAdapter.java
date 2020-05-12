package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fis;
    private PersonThreadFragment klN;
    private PersonReplyFragment klO;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cLa());
        this.klO = new PersonReplyFragment();
        this.klO.setArguments(bundle);
        this.klO.a(personPostActivity);
        this.klN = new PersonThreadFragment();
        this.klN.setArguments(bundle);
        this.klN.a((d) personPostActivity);
        this.klN.a((b) personPostActivity);
        this.fis = new int[]{0, 1};
    }

    public PersonThreadFragment cLb() {
        return this.klN;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.klN;
            case 1:
                return this.klO;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int xv(int i) {
        return this.fis[i];
    }
}
