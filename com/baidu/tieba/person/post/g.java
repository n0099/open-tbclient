package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class g extends FragmentPagerAdapter {
    private int[] coj;
    private v dBg;
    private k dBh;

    public g(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.aCw());
        this.dBh = new k();
        this.dBh.setArguments(bundle);
        this.dBg = new v();
        this.dBg.setArguments(bundle);
        this.coj = new int[]{0, 1};
    }

    public v aCx() {
        return this.dBg;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.dBg;
            case 1:
                return this.dBh;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int jY(int i) {
        return this.coj[i];
    }
}
