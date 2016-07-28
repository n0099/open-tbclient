package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf dgz;

    public af(bf bfVar) {
        this.dgz = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k auB = this.dgz.auB();
            if (auB.getView() == null) {
                View lg = auB.lg();
                viewGroup.addView(lg);
                return lg;
            }
            return auB.getView();
        } else if (i == 1) {
            az aux = this.dgz.aux();
            if (aux.getView() == null) {
                View lg2 = aux.lg();
                viewGroup.addView(lg2);
                return lg2;
            }
            return aux.getView();
        } else {
            j auy = this.dgz.auy();
            if (auy.getView() == null) {
                View lg3 = auy.lg();
                viewGroup.addView(lg3);
                return lg3;
            }
            return auy.getView();
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
