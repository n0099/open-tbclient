package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf ddD;

    public af(bf bfVar) {
        this.ddD = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k atP = this.ddD.atP();
            if (atP.getView() == null) {
                View lk = atP.lk();
                viewGroup.addView(lk);
                return lk;
            }
            return atP.getView();
        } else if (i == 1) {
            az atL = this.ddD.atL();
            if (atL.getView() == null) {
                View lk2 = atL.lk();
                viewGroup.addView(lk2);
                return lk2;
            }
            return atL.getView();
        } else {
            j atM = this.ddD.atM();
            if (atM.getView() == null) {
                View lk3 = atM.lk();
                viewGroup.addView(lk3);
                return lk3;
            }
            return atM.getView();
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
