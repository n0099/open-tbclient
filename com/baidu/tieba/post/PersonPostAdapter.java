package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes7.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gYH;
    private PersonThreadFragment mNS;
    private PersonReplyFragment mNT;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dBl());
        this.mNT = new PersonReplyFragment();
        this.mNT.setArguments(bundle);
        this.mNT.a(personPostActivity);
        this.mNS = new PersonThreadFragment();
        this.mNS.setArguments(bundle);
        this.mNS.a((d) personPostActivity);
        this.mNS.a((b) personPostActivity);
        this.gYH = new int[]{0, 1};
    }

    public PersonThreadFragment dBm() {
        return this.mNS;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mNS;
            case 1:
                return this.mNT;
            default:
                return null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Dm(int i) {
        return this.gYH[i];
    }
}
