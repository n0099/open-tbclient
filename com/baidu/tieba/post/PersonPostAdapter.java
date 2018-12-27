package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bZF;
    private PersonThreadFragment gIV;
    private PersonReplyFragment gIW;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.btd());
        this.gIW = new PersonReplyFragment();
        this.gIW.setArguments(bundle);
        this.gIW.a(personPostActivity);
        this.gIV = new PersonThreadFragment();
        this.gIV.setArguments(bundle);
        this.gIV.a((d) personPostActivity);
        this.gIV.a((b) personPostActivity);
        this.bZF = new int[]{0, 1};
    }

    public PersonThreadFragment bte() {
        return this.gIV;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gIV;
            case 1:
                return this.gIW;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qC(int i) {
        return this.bZF[i];
    }
}
