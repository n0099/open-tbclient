package com.baidu.tieba.recommendfrs.indicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes.dex */
public class a extends FragmentPagerAdapter {
    private List<e> TA;
    private int mPrimaryPosition;

    public a(FragmentManager fragmentManager, List<e> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.TA = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i < 0 || i >= this.TA.size()) {
            return null;
        }
        return this.TA.get(i).ahL();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.TA.size()) {
            return 0L;
        }
        return this.TA.get(i).ahL().hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.TA.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            if (this.mPrimaryPosition != -1) {
                ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
            }
            this.mPrimaryPosition = i;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment item = getItem(i);
        if (item instanceof com.baidu.tieba.recommendfrs.b) {
            ((com.baidu.tieba.recommendfrs.b) item).clear();
        }
    }
}
