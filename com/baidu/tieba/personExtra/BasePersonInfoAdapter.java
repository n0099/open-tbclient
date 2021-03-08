package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gYH;
    private ArrayList<BaseFragment> mxW;

    protected abstract BaseFragment dxt();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mxW = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dxt = dxt();
        dxt.setArguments(bundle);
        this.mxW.add(dxt);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dxt2 = dxt();
            dxt2.setArguments(bundle2);
            this.mxW.add(dxt2);
            this.gYH = new int[]{0, 1};
            return;
        }
        this.gYH = new int[]{0};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gYH.length || i < 0) {
            return null;
        }
        return this.mxW.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gYH.length;
    }

    public int Dm(int i) {
        return this.gYH[i];
    }
}
