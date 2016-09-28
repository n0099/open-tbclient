package com.baidu.tieba.imMessageCenter.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class af extends PagerAdapter {
    private bf dtC;

    public af(bf bfVar) {
        this.dtC = bfVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            k azM = this.dtC.azM();
            if (azM.getView() == null) {
                View mb = azM.mb();
                viewGroup.addView(mb);
                return mb;
            }
            return azM.getView();
        } else if (i == 1) {
            az azI = this.dtC.azI();
            if (azI.getView() == null) {
                View mb2 = azI.mb();
                viewGroup.addView(mb2);
                return mb2;
            }
            return azI.getView();
        } else {
            j azJ = this.dtC.azJ();
            if (azJ.getView() == null) {
                View mb3 = azJ.mb();
                viewGroup.addView(mb3);
                return mb3;
            }
            return azJ.getView();
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
