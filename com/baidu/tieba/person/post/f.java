package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private int[] bZj;
    private u cVg;
    private j cVh;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.apD());
        this.cVh = new j();
        this.cVh.setArguments(bundle);
        this.cVg = new u();
        this.cVg.setArguments(bundle);
        this.bZj = new int[]{0, 1};
    }

    public u apE() {
        return this.cVg;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.cVg;
            case 1:
                return this.cVh;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int iV(int i) {
        return this.bZj[i];
    }
}
