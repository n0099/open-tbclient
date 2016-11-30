package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf dzh;

    public af(bf bfVar) {
        this.dzh = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k aBI = this.dzh.aBI();
            if (aBI.getView() == null) {
                View me = aBI.me();
                viewGroup.addView(me);
                return me;
            }
            return aBI.getView();
        } else if (i == 1) {
            az aBE = this.dzh.aBE();
            if (aBE.getView() == null) {
                View me2 = aBE.me();
                viewGroup.addView(me2);
                return me2;
            }
            return aBE.getView();
        } else {
            j aBF = this.dzh.aBF();
            if (aBF.getView() == null) {
                View me3 = aBF.me();
                viewGroup.addView(me3);
                return me3;
            }
            return aBF.getView();
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
