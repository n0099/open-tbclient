package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class f extends FragmentPagerAdapter {
    private t bHl;
    private k bHm;
    private int[] bjh;

    public f(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.aaC());
        bundle.putString("key_empty_view_text", personPostActivity.aaD());
        this.bHm = new k();
        this.bHm.setArguments(bundle);
        this.bHl = new t();
        this.bHl.setArguments(bundle);
        this.bjh = new int[]{0, 1};
    }

    public t aaE() {
        return this.bHl;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bHl;
            case 1:
                return this.bHm;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int go(int i) {
        return this.bjh[i];
    }
}
