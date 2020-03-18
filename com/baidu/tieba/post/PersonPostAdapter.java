package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes11.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] eDT;
    private PersonThreadFragment jBE;
    private PersonReplyFragment jBF;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cAs());
        this.jBF = new PersonReplyFragment();
        this.jBF.setArguments(bundle);
        this.jBF.a(personPostActivity);
        this.jBE = new PersonThreadFragment();
        this.jBE.setArguments(bundle);
        this.jBE.a((d) personPostActivity);
        this.jBE.a((b) personPostActivity);
        this.eDT = new int[]{0, 1};
    }

    public PersonThreadFragment cAt() {
        return this.jBE;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.jBE;
            case 1:
                return this.jBF;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int wX(int i) {
        return this.eDT[i];
    }
}
