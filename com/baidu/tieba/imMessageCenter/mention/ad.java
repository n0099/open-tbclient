package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ad extends PagerAdapter {
    private bd cih;

    public ad(bd bdVar) {
        this.cih = bdVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k aeP = this.cih.aeP();
            if (aeP.getView() == null) {
                View oE = aeP.oE();
                viewGroup.addView(oE);
                return oE;
            }
            return aeP.getView();
        } else if (i == 1) {
            ax aeL = this.cih.aeL();
            if (aeL.getView() == null) {
                View oE2 = aeL.oE();
                viewGroup.addView(oE2);
                return oE2;
            }
            return aeL.getView();
        } else {
            j aeM = this.cih.aeM();
            if (aeM.getView() == null) {
                View oE3 = aeM.oE();
                viewGroup.addView(oE3);
                return oE3;
            }
            return aeM.getView();
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
