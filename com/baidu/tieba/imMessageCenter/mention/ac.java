package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ac extends PagerAdapter {
    private bc ceg;

    public ac(bc bcVar) {
        this.ceg = bcVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k adH = this.ceg.adH();
            if (adH.getView() == null) {
                View pg = adH.pg();
                viewGroup.addView(pg);
                return pg;
            }
            return adH.getView();
        } else if (i == 1) {
            aw adD = this.ceg.adD();
            if (adD.getView() == null) {
                View pg2 = adD.pg();
                viewGroup.addView(pg2);
                return pg2;
            }
            return adD.getView();
        } else {
            j adE = this.ceg.adE();
            if (adE.getView() == null) {
                View pg3 = adE.pg();
                viewGroup.addView(pg3);
                return pg3;
            }
            return adE.getView();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
