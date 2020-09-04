package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes18.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fYS;
    private PersonThreadFragment lwJ;
    private PersonReplyFragment lwK;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dkV());
        this.lwK = new PersonReplyFragment();
        this.lwK.setArguments(bundle);
        this.lwK.a(personPostActivity);
        this.lwJ = new PersonThreadFragment();
        this.lwJ.setArguments(bundle);
        this.lwJ.a((d) personPostActivity);
        this.lwJ.a((b) personPostActivity);
        this.fYS = new int[]{0, 1};
    }

    public PersonThreadFragment dkW() {
        return this.lwJ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.lwJ;
            case 1:
                return this.lwK;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int BF(int i) {
        return this.fYS[i];
    }
}
