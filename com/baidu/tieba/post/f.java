package com.baidu.tieba.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes3.dex */
public class f extends FragmentPagerAdapter {
    private int[] clf;
    private j gxo;
    private i gxp;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.bmk());
        this.gxp = new i();
        this.gxp.setArguments(bundle);
        this.gxp.a(personPostActivity);
        this.gxo = new j();
        this.gxo.setArguments(bundle);
        this.gxo.a((d) personPostActivity);
        this.gxo.a((b) personPostActivity);
        this.clf = new int[]{0, 1};
    }

    public j bml() {
        return this.gxo;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.gxo;
            case 1:
                return this.gxp;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int qy(int i) {
        return this.clf[i];
    }
}
