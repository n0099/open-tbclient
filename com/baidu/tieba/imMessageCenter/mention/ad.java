package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ad extends PagerAdapter {
    private bd cmH;

    public ad(bd bdVar) {
        this.cmH = bdVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k ahY = this.cmH.ahY();
            if (ahY.getView() == null) {
                View pa = ahY.pa();
                viewGroup.addView(pa);
                return pa;
            }
            return ahY.getView();
        } else if (i == 1) {
            ax ahU = this.cmH.ahU();
            if (ahU.getView() == null) {
                View pa2 = ahU.pa();
                viewGroup.addView(pa2);
                return pa2;
            }
            return ahU.getView();
        } else {
            j ahV = this.cmH.ahV();
            if (ahV.getView() == null) {
                View pa3 = ahV.pa();
                viewGroup.addView(pa3);
                return pa3;
            }
            return ahV.getView();
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
