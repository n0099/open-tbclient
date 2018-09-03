package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bGF;
    private PersonThreadFragment giT;
    private PersonReplyFragment giU;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bli());
        this.giU = new PersonReplyFragment();
        this.giU.setArguments(bundle);
        this.giU.a(personPostActivity);
        this.giT = new PersonThreadFragment();
        this.giT.setArguments(bundle);
        this.giT.a((d) personPostActivity);
        this.giT.a((b) personPostActivity);
        this.bGF = new int[]{0, 1};
    }

    public PersonThreadFragment blj() {
        return this.giT;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.giT;
            case 1:
                return this.giU;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int oA(int i) {
        return this.bGF[i];
    }
}
