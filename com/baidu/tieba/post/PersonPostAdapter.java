package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes8.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gWK;
    private PersonThreadFragment mLB;
    private PersonReplyFragment mLC;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dAW());
        this.mLC = new PersonReplyFragment();
        this.mLC.setArguments(bundle);
        this.mLC.a(personPostActivity);
        this.mLB = new PersonThreadFragment();
        this.mLB.setArguments(bundle);
        this.mLB.a((d) personPostActivity);
        this.mLB.a((b) personPostActivity);
        this.gWK = new int[]{0, 1};
    }

    public PersonThreadFragment dAX() {
        return this.mLB;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mLB;
            case 1:
                return this.mLC;
            default:
                return null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int Dj(int i) {
        return this.gWK[i];
    }
}
