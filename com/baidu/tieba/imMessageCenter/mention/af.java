package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf dsf;

    public af(bf bfVar) {
        this.dsf = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k azo = this.dsf.azo();
            if (azo.getView() == null) {
                View mb = azo.mb();
                viewGroup.addView(mb);
                return mb;
            }
            return azo.getView();
        } else if (i == 1) {
            az azk = this.dsf.azk();
            if (azk.getView() == null) {
                View mb2 = azk.mb();
                viewGroup.addView(mb2);
                return mb2;
            }
            return azk.getView();
        } else {
            j azl = this.dsf.azl();
            if (azl.getView() == null) {
                View mb3 = azl.mb();
                viewGroup.addView(mb3);
                return mb3;
            }
            return azl.getView();
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
