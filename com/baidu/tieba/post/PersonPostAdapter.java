package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bVK;
    private PersonThreadFragment gzo;
    private PersonReplyFragment gzp;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bqz());
        this.gzp = new PersonReplyFragment();
        this.gzp.setArguments(bundle);
        this.gzp.a(personPostActivity);
        this.gzo = new PersonThreadFragment();
        this.gzo.setArguments(bundle);
        this.gzo.a((d) personPostActivity);
        this.gzo.a((b) personPostActivity);
        this.bVK = new int[]{0, 1};
    }

    public PersonThreadFragment bqA() {
        return this.gzo;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gzo;
            case 1:
                return this.gzp;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int pV(int i) {
        return this.bVK[i];
    }
}
