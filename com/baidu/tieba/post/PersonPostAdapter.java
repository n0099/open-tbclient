package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes8.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gWY;
    private PersonThreadFragment mLQ;
    private PersonReplyFragment mLR;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dBd());
        this.mLR = new PersonReplyFragment();
        this.mLR.setArguments(bundle);
        this.mLR.a(personPostActivity);
        this.mLQ = new PersonThreadFragment();
        this.mLQ.setArguments(bundle);
        this.mLQ.a((d) personPostActivity);
        this.mLQ.a((b) personPostActivity);
        this.gWY = new int[]{0, 1};
    }

    public PersonThreadFragment dBe() {
        return this.mLQ;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mLQ;
            case 1:
                return this.mLR;
            default:
                return null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Dj(int i) {
        return this.gWY[i];
    }
}
