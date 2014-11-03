package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private u bDK;
    private l bDL;
    private int[] bfV;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString("key_portrait_url", personPostActivity.aal());
        bundle.putString("key_empty_view_text", personPostActivity.aam());
        this.bDL = new l();
        this.bDL.setArguments(bundle);
        this.bDK = new u();
        this.bDK.setArguments(bundle);
        this.bfV = new int[]{0, 1};
    }

    public u aan() {
        return this.bDK;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bDK;
            case 1:
                return this.bDL;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gf(int i) {
        return this.bfV[i];
    }
}
