package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import com.baidu.tbadk.core.BaseFragment;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public abstract class BasePersonInfoAdapter extends FragmentPagerAdapter {
    private int[] fwa;
    private ArrayList<BaseFragment> kmX;

    protected abstract BaseFragment cNJ();

    public BasePersonInfoAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity.getSupportFragmentManager());
        this.kmX = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("page_type", 0);
        BaseFragment cNJ = cNJ();
        cNJ.setArguments(bundle);
        this.kmX.add(cNJ);
        if (!z) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("page_type", 1);
            BaseFragment cNJ2 = cNJ();
            cNJ2.setArguments(bundle2);
            this.kmX.add(cNJ2);
            this.fwa = new int[]{0, 1};
            return;
        }
        this.fwa = new int[]{0};
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i >= this.fwa.length || i < 0) {
            return null;
        }
        return this.kmX.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.fwa.length;
    }

    public int yb(int i) {
        return this.fwa[i];
    }
}
