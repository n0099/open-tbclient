package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] dzY;
    private ArrayList<BaseFragment> ifh;

    protected abstract BaseFragment bYK();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.ifh = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment bYK = bYK();
        bYK.setArguments(bundle);
        this.ifh.add(bYK);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment bYK2 = bYK();
            bYK2.setArguments(bundle2);
            this.ifh.add(bYK2);
            this.dzY = new int[]{0, 1};
            return;
        }
        this.dzY = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.dzY.length || i < 0) {
            return null;
        }
        return this.ifh.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.dzY.length;
    }

    public int vq(int i) {
        return this.dzY[i];
    }
}
