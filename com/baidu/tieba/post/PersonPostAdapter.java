package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes8.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gYG;
    private PersonThreadFragment mHb;
    private PersonReplyFragment mHc;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dCE());
        this.mHc = new PersonReplyFragment();
        this.mHc.setArguments(bundle);
        this.mHc.a(personPostActivity);
        this.mHb = new PersonThreadFragment();
        this.mHb.setArguments(bundle);
        this.mHb.a((d) personPostActivity);
        this.mHb.a((b) personPostActivity);
        this.gYG = new int[]{0, 1};
    }

    public PersonThreadFragment dCF() {
        return this.mHb;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mHb;
            case 1:
                return this.mHc;
            default:
                return null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Ey(int i) {
        return this.gYG[i];
    }
}
