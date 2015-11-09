package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private int[] bGq;
    private u csR;
    private j csS;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.ajx());
        this.csS = new j();
        this.csS.setArguments(bundle);
        this.csR = new u();
        this.csR.setArguments(bundle);
        this.bGq = new int[]{0, 1};
    }

    public u ajy() {
        return this.csR;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.csR;
            case 1:
                return this.csS;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int hI(int i) {
        return this.bGq[i];
    }
}
