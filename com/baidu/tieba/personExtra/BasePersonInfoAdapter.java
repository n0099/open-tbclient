package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gYG;
    private ArrayList<BaseFragment> mrj;

    protected abstract BaseFragment dyM();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mrj = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dyM = dyM();
        dyM.setArguments(bundle);
        this.mrj.add(dyM);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dyM2 = dyM();
            dyM2.setArguments(bundle2);
            this.mrj.add(dyM2);
            this.gYG = new int[]{0, 1};
            return;
        }
        this.gYG = new int[]{0};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gYG.length || i < 0) {
            return null;
        }
        return this.mrj.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gYG.length;
    }

    public int Ey(int i) {
        return this.gYG[i];
    }
}
