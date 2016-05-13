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
            k alC = this.cyh.alC();
            if (alC.getView() == null) {
                View lg = alC.lg();
                viewGroup.addView(lg);
                return lg;
            }
            return alC.getView();
        } else if (i == 1) {
            az aly = this.cyh.aly();
            if (aly.getView() == null) {
                View lg2 = aly.lg();
                viewGroup.addView(lg2);
                return lg2;
            }
            return aly.getView();
        } else {
            j alz = this.cyh.alz();
            if (alz.getView() == null) {
                View lg3 = alz.lg();
                viewGroup.addView(lg3);
                return lg3;
            }
            return alz.getView();
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
