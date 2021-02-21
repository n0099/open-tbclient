package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gWY;
    private ArrayList<BaseFragment> mvU;

    protected abstract BaseFragment dxk();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mvU = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment dxk = dxk();
        dxk.setArguments(bundle);
        this.mvU.add(dxk);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment dxk2 = dxk();
            dxk2.setArguments(bundle2);
            this.mvU.add(dxk2);
            this.gWY = new int[]{0, 1};
            return;
        }
        this.gWY = new int[]{0};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gWY.length || i < 0) {
            return null;
        }
        return this.mvU.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gWY.length;
    }

    public int Dj(int i) {
        return this.gWY[i];
    }
}
