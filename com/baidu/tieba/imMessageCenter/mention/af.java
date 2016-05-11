package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf cyh;

    public af(bf bfVar) {
        this.cyh = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k alA = this.cyh.alA();
            if (alA.getView() == null) {
                View lg = alA.lg();
                viewGroup.addView(lg);
                return lg;
            }
            return alA.getView();
        } else if (i == 1) {
            az alw = this.cyh.alw();
            if (alw.getView() == null) {
                View lg2 = alw.lg();
                viewGroup.addView(lg2);
                return lg2;
            }
            return alw.getView();
        } else {
            j alx = this.cyh.alx();
            if (alx.getView() == null) {
                View lg3 = alx.lg();
                viewGroup.addView(lg3);
                return lg3;
            }
            return alx.getView();
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
