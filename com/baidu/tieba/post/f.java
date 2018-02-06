package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class f extends FragmentPagerAdapter {
    private int[] clo;
    private j gxj;
    private i gxk;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bmk());
        this.gxk = new i();
        this.gxk.setArguments(bundle);
        this.gxk.a(personPostActivity);
        this.gxj = new j();
        this.gxj.setArguments(bundle);
        this.gxj.a((d) personPostActivity);
        this.gxj.a((b) personPostActivity);
        this.clo = new int[]{0, 1};
    }

    public j bml() {
        return this.gxj;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gxj;
            case 1:
                return this.gxk;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qx(int i) {
        return this.clo[i];
    }
}
