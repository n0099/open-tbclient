package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private t bRy;
    private k bRz;
    private int[] blI;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.adE());
        bundle.putString("key_empty_view_text", personPostActivity.adF());
        this.bRz = new k();
        this.bRz.setArguments(bundle);
        this.bRy = new t();
        this.bRy.setArguments(bundle);
        this.blI = new int[]{0, 1};
    }

    public t adG() {
        return this.bRy;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bRy;
            case 1:
                return this.bRz;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gk(int i) {
        return this.blI[i];
    }
}
