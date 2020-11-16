package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gDX;
    private ArrayList<BaseFragment> lXR;

    protected abstract BaseFragment dtD();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.lXR = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dtD = dtD();
        dtD.setArguments(bundle);
        this.lXR.add(dtD);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dtD2 = dtD();
            dtD2.setArguments(bundle2);
            this.lXR.add(dtD2);
            this.gDX = new int[]{0, 1};
            return;
        }
        this.gDX = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gDX.length || i < 0) {
            return null;
        }
        return this.lXR.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gDX.length;
    }

    public int DQ(int i) {
        return this.gDX[i];
    }
}
