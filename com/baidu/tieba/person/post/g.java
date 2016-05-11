package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class g extends FragmentPagerAdapter {
    private int[] cpg;
    private v dEp;
    private k dEq;

    public g(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.aCO());
        this.dEq = new k();
        this.dEq.setArguments(bundle);
        this.dEp = new v();
        this.dEp.setArguments(bundle);
        this.cpg = new int[]{0, 1};
    }

    public v aCQ() {
        return this.dEp;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.dEp;
            case 1:
                return this.dEq;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int jD(int i) {
        return this.cpg[i];
    }
}
