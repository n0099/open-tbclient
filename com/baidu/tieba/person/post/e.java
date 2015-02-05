package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class e extends FragmentPagerAdapter {
    private s bIW;
    private j bIX;
    private int[] bkD;

    public e(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.abc());
        bundle.putString("key_empty_view_text", personPostActivity.abd());
        this.bIX = new j();
        this.bIX.setArguments(bundle);
        this.bIW = new s();
        this.bIW.setArguments(bundle);
        this.bkD = new int[]{0, 1};
    }

    public s abe() {
        return this.bIW;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bIW;
            case 1:
                return this.bIX;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gx(int i) {
        return this.bkD[i];
    }
}
