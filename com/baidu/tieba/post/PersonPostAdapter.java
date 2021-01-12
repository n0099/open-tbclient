package com.baidu.tieba.post;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes7.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gUa;
    private PersonThreadFragment mCs;
    private PersonReplyFragment mCt;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dyM());
        this.mCt = new PersonReplyFragment();
        this.mCt.setArguments(bundle);
        this.mCt.a(personPostActivity);
        this.mCs = new PersonThreadFragment();
        this.mCs.setArguments(bundle);
        this.mCs.a((d) personPostActivity);
        this.mCs.a((b) personPostActivity);
        this.gUa = new int[]{0, 1};
    }

    public PersonThreadFragment dyN() {
        return this.mCs;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mCs;
            case 1:
                return this.mCt;
            default:
                return null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int CS(int i) {
        return this.gUa[i];
    }
}
