package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes24.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gox;
    private PersonThreadFragment lUO;
    private PersonReplyFragment lUP;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dsn());
        this.lUP = new PersonReplyFragment();
        this.lUP.setArguments(bundle);
        this.lUP.a(personPostActivity);
        this.lUO = new PersonThreadFragment();
        this.lUO.setArguments(bundle);
        this.lUO.a((d) personPostActivity);
        this.lUO.a((b) personPostActivity);
        this.gox = new int[]{0, 1};
    }

    public PersonThreadFragment dso() {
        return this.lUO;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.lUO;
            case 1:
                return this.lUP;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int CM(int i) {
        return this.gox[i];
    }
}
