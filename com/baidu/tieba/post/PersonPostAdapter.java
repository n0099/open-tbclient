package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] caq;
    private PersonThreadFragment gJZ;
    private PersonReplyFragment gKa;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.btM());
        this.gKa = new PersonReplyFragment();
        this.gKa.setArguments(bundle);
        this.gKa.a(personPostActivity);
        this.gJZ = new PersonThreadFragment();
        this.gJZ.setArguments(bundle);
        this.gJZ.a((d) personPostActivity);
        this.gJZ.a((b) personPostActivity);
        this.caq = new int[]{0, 1};
    }

    public PersonThreadFragment btN() {
        return this.gJZ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gJZ;
            case 1:
                return this.gKa;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qD(int i) {
        return this.caq[i];
    }
}
