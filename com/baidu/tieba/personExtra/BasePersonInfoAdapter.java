package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gYG;
    private ArrayList<BaseFragment> mrk;

    protected abstract BaseFragment dyL();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mrk = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dyL = dyL();
        dyL.setArguments(bundle);
        this.mrk.add(dyL);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dyL2 = dyL();
            dyL2.setArguments(bundle2);
            this.mrk.add(dyL2);
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
        return this.mrk.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gYG.length;
    }

    public int Ey(int i) {
        return this.gYG[i];
    }
}
