package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] bGF;
    private ArrayList<BaseFragment> fVN;

    protected abstract BaseFragment bhZ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.fVN = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bhZ = bhZ();
        bhZ.setArguments(bundle);
        this.fVN.add(bhZ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bhZ2 = bhZ();
            bhZ2.setArguments(bundle2);
            this.fVN.add(bhZ2);
            this.bGF = new int[]{0, 1};
            return;
        }
        this.bGF = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.bGF.length || i < 0) {
            return null;
        }
        return this.fVN.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bGF.length;
    }

    public int oA(int i) {
        return this.bGF[i];
    }
}
