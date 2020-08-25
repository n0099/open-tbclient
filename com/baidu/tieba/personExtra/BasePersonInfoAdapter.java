package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fYO;
    private ArrayList<BaseFragment> lgS;

    protected abstract BaseFragment dhe();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lgS = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dhe = dhe();
        dhe.setArguments(bundle);
        this.lgS.add(dhe);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dhe2 = dhe();
            dhe2.setArguments(bundle2);
            this.lgS.add(dhe2);
            this.fYO = new int[]{0, 1};
            return;
        }
        this.fYO = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fYO.length || i < 0) {
            return null;
        }
        return this.lgS.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fYO.length;
    }

    public int BF(int i) {
        return this.fYO[i];
    }
}
