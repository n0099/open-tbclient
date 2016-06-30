package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class g extends FragmentPagerAdapter {
    private int[] cUw;
    private x enj;
    private k enk;

    public g(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.aLN());
        this.enk = new k();
        this.enk.setArguments(bundle);
        this.enj = new x();
        this.enj.setArguments(bundle);
        this.cUw = new int[]{0, 1};
    }

    public x aLO() {
        return this.enj;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.enj;
            case 1:
                return this.enk;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int le(int i) {
        return this.cUw[i];
    }
}
