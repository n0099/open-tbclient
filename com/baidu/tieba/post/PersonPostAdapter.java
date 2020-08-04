package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes18.dex */
public class PersonPostAdapter extends FragmentPagerAdapter {
    private int[] fMQ;
    private PersonThreadFragment lgf;
    private PersonReplyFragment lgg;

    public PersonPostAdapter(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.cZO());
        this.lgg = new PersonReplyFragment();
        this.lgg.setArguments(bundle);
        this.lgg.a(personPostActivity);
        this.lgf = new PersonThreadFragment();
        this.lgf.setArguments(bundle);
        this.lgf.a((d) personPostActivity);
        this.lgf.a((b) personPostActivity);
        this.fMQ = new int[]{0, 1};
    }

    public PersonThreadFragment cZP() {
        return this.lgf;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.lgf;
            case 1:
                return this.lgg;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int zm(int i) {
        return this.fMQ[i];
    }
}
