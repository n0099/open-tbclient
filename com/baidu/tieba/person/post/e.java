package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class e extends FragmentPagerAdapter {
    private int[] bCa;
    private p ckL;
    private i ckM;

    public e(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.agF());
        this.ckM = new i();
        this.ckM.setArguments(bundle);
        this.ckL = new p();
        this.ckL.setArguments(bundle);
        this.bCa = new int[]{0, 1};
    }

    public p agG() {
        return this.ckL;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.ckL;
            case 1:
                return this.ckM;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int hf(int i) {
        return this.bCa[i];
    }
}
