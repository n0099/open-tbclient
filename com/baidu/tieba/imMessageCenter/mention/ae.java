package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class ae extends PagerAdapter {
    private be cxj;

    public ae(be beVar) {
        this.cxj = beVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k als = this.cxj.als();
            if (als.getView() == null) {
                View oT = als.oT();
                viewGroup.addView(oT);
                return oT;
            }
            return als.getView();
        } else if (i == 1) {
            ay alo = this.cxj.alo();
            if (alo.getView() == null) {
                View oT2 = alo.oT();
                viewGroup.addView(oT2);
                return oT2;
            }
            return alo.getView();
        } else {
            j alp = this.cxj.alp();
            if (alp.getView() == null) {
                View oT3 = alp.oT();
                viewGroup.addView(oT3);
                return oT3;
            }
            return alp.getView();
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
