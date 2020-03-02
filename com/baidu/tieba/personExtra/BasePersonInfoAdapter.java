package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] eDk;
    private ArrayList<BaseFragment> jja;

    protected abstract BaseFragment cvI();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.jja = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cvI = cvI();
        cvI.setArguments(bundle);
        this.jja.add(cvI);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cvI2 = cvI();
            cvI2.setArguments(bundle2);
            this.jja.add(cvI2);
            this.eDk = new int[]{0, 1};
            return;
        }
        this.eDk = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.eDk.length || i < 0) {
            return null;
        }
        return this.jja.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.eDk.length;
    }

    public int wP(int i) {
        return this.eDk[i];
    }
}
