package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] bZC;
    private PersonThreadFragment gGe;
    private PersonReplyFragment gGf;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bsr());
        this.gGf = new PersonReplyFragment();
        this.gGf.setArguments(bundle);
        this.gGf.a(personPostActivity);
        this.gGe = new PersonThreadFragment();
        this.gGe.setArguments(bundle);
        this.gGe.a((d) personPostActivity);
        this.gGe.a((b) personPostActivity);
        this.bZC = new int[]{0, 1};
    }

    public PersonThreadFragment bss() {
        return this.gGe;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gGe;
            case 1:
                return this.gGf;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qp(int i) {
        return this.bZC[i];
    }
}
