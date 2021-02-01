package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gWK;
    private ArrayList<BaseFragment> mvF;

    protected abstract BaseFragment dxd();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mvF = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dxd = dxd();
        dxd.setArguments(bundle);
        this.mvF.add(dxd);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dxd2 = dxd();
            dxd2.setArguments(bundle2);
            this.mvF.add(dxd2);
            this.gWK = new int[]{0, 1};
            return;
        }
        this.gWK = new int[]{0};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gWK.length || i < 0) {
            return null;
        }
        return this.mvF.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gWK.length;
    }

    public int Dj(int i) {
        return this.gWK[i];
    }
}
