package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tieba.person.data.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private int[] bFV;
    private u crv;
    private j crw;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.getPortraitUrl());
        bundle.putString("key_empty_view_text", personPostActivity.aiV());
        this.crw = new j();
        this.crw.setArguments(bundle);
        this.crv = new u();
        this.crv.setArguments(bundle);
        this.bFV = new int[]{0, 1};
    }

    public u aiW() {
        return this.crv;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.crv;
            case 1:
                return this.crw;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int hv(int i) {
        return this.bFV[i];
    }
}
