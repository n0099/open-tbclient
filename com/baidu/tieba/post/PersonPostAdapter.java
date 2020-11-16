package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes23.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] gDX;
    private PersonThreadFragment mnF;
    private PersonReplyFragment mnG;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.dxw());
        this.mnG = new PersonReplyFragment();
        this.mnG.setArguments(bundle);
        this.mnG.a(personPostActivity);
        this.mnF = new PersonThreadFragment();
        this.mnF.setArguments(bundle);
        this.mnF.a((d) personPostActivity);
        this.mnF.a((b) personPostActivity);
        this.gDX = new int[]{0, 1};
    }

    public PersonThreadFragment dxx() {
        return this.mnF;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.mnF;
            case 1:
                return this.mnG;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int DQ(int i) {
        return this.gDX[i];
    }
}
