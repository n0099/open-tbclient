package com.baidu.tieba.personExtra;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] gUa;
    private ArrayList<BaseFragment> mmE;

    protected abstract BaseFragment duU();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.mmE = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment duU = duU();
        duU.setArguments(bundle);
        this.mmE.add(duU);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment duU2 = duU();
            duU2.setArguments(bundle2);
            this.mmE.add(duU2);
            this.gUa = new int[]{0, 1};
            return;
        }
        this.gUa = new int[]{0};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.gUa.length || i < 0) {
            return null;
        }
        return this.mmE.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.gUa.length;
    }

    public int CS(int i) {
        return this.gUa[i];
    }
}
