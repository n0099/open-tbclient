package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class g extends FragmentPagerAdapter {
    private int[] cdE;
    private v dgH;
    private k dgI;

    public g(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.auQ());
        this.dgI = new k();
        this.dgI.setArguments(bundle);
        this.dgH = new v();
        this.dgH.setArguments(bundle);
        this.cdE = new int[]{0, 1};
    }

    public v auR() {
        return this.dgH;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.dgH;
            case 1:
                return this.dgI;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int js(int i) {
        return this.cdE[i];
    }
}
