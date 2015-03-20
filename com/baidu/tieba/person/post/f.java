package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private t bRi;
    private k bRj;
    private int[] bls;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.adp());
        bundle.putString("key_empty_view_text", personPostActivity.adq());
        this.bRj = new k();
        this.bRj.setArguments(bundle);
        this.bRi = new t();
        this.bRi.setArguments(bundle);
        this.bls = new int[]{0, 1};
    }

    public t adr() {
        return this.bRi;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bRi;
            case 1:
                return this.bRj;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gi(int i) {
        return this.bls[i];
    }
}
