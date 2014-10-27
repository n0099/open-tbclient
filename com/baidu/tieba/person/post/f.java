package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private t bDw;
    private l bDx;
    private int[] bfH;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString("key_portrait_url", personPostActivity.aaj());
        bundle.putString("key_empty_view_text", personPostActivity.aak());
        this.bDx = new l();
        this.bDx.setArguments(bundle);
        this.bDw = new t();
        this.bDw.setArguments(bundle);
        this.bfH = new int[]{0, 1};
    }

    public t aal() {
        return this.bDw;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bDw;
            case 1:
                return this.bDx;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gf(int i) {
        return this.bfH[i];
    }
}
