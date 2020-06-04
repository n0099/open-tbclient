package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fwl;
    private PersonThreadFragment kEQ;
    private PersonReplyFragment kER;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cSq());
        this.kER = new PersonReplyFragment();
        this.kER.setArguments(bundle);
        this.kER.a(personPostActivity);
        this.kEQ = new PersonThreadFragment();
        this.kEQ.setArguments(bundle);
        this.kEQ.a((d) personPostActivity);
        this.kEQ.a((b) personPostActivity);
        this.fwl = new int[]{0, 1};
    }

    public PersonThreadFragment cSr() {
        return this.kEQ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.kEQ;
            case 1:
                return this.kER;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int yd(int i) {
        return this.fwl[i];
    }
}
