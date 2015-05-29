package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private t bUd;
    private k bUe;
    private int[] bom;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.aeM());
        this.bUe = new k();
        this.bUe.setArguments(bundle);
        this.bUd = new t();
        this.bUd.setArguments(bundle);
        this.bom = new int[]{0, 1};
    }

    public t aeN() {
        return this.bUd;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bUd;
            case 1:
                return this.bUe;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gB(int i) {
        return this.bom[i];
    }
}
