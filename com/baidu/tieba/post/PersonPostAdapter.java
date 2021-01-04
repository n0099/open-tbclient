package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes8.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gYG;
    private PersonThreadFragment mHc;
    private PersonReplyFragment mHd;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dCD());
        this.mHd = new PersonReplyFragment();
        this.mHd.setArguments(bundle);
        this.mHd.a(personPostActivity);
        this.mHc = new PersonThreadFragment();
        this.mHc.setArguments(bundle);
        this.mHc.a((d) personPostActivity);
        this.mHc.a((b) personPostActivity);
        this.gYG = new int[]{0, 1};
    }

    public PersonThreadFragment dCE() {
        return this.mHc;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mHc;
            case 1:
                return this.mHd;
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
