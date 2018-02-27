package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class f extends FragmentPagerAdapter {
    private int[] clc;
    private j gwY;
    private i gwZ;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bmj());
        this.gwZ = new i();
        this.gwZ.setArguments(bundle);
        this.gwZ.a(personPostActivity);
        this.gwY = new j();
        this.gwY.setArguments(bundle);
        this.gwY.a((d) personPostActivity);
        this.gwY.a((b) personPostActivity);
        this.clc = new int[]{0, 1};
    }

    public j bmk() {
        return this.gwY;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gwY;
            case 1:
                return this.gwZ;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qx(int i) {
        return this.clc[i];
    }
}
