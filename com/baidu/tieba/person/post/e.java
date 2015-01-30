package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
/* loaded from: classes.dex */
public class e extends FragmentPagerAdapter {
    private s bIX;
    private j bIY;
    private int[] bkE;

    public e(PersonPostActivity personPostActivity) {
        super(personPostActivity.getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("key_uid", personPostActivity.getUid());
        bundle.putString(PersonPostActivityConfig.KEY_PORTRAIT_URL, personPostActivity.abh());
        bundle.putString("key_empty_view_text", personPostActivity.abi());
        this.bIY = new j();
        this.bIY.setArguments(bundle);
        this.bIX = new s();
        this.bIX.setArguments(bundle);
        this.bkE = new int[]{0, 1};
    }

    public s abj() {
        return this.bIX;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return this.bIX;
            case 1:
                return this.bIY;
            default:
                return null;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    public int gx(int i) {
        return this.bkE[i];
    }
}
