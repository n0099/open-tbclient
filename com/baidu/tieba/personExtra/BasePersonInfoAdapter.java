package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bVK;
    private ArrayList<BaseFragment> gme;

    protected abstract BaseFragment bng();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.gme = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bng = bng();
        bng.setArguments(bundle);
        this.gme.add(bng);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bng2 = bng();
            bng2.setArguments(bundle2);
            this.gme.add(bng2);
            this.bVK = new int[]{0, 1};
            return;
        }
        this.bVK = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bVK.length || i < 0) {
            return null;
        }
        return this.gme.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bVK.length;
    }

    public int pV(int i) {
        return this.bVK[i];
    }
}
