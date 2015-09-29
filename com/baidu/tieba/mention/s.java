package com.baidu.tieba.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private SingleMentionActivity bZY;

    public s(SingleMentionActivity singleMentionActivity) {
        this.bZY = singleMentionActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            al ade = this.bZY.ade();
            if (ade.getView() == null) {
                View oZ = ade.oZ();
                viewGroup.addView(oZ);
                ade.acO();
                return oZ;
            }
            return ade.getView();
        }
        j adf = this.bZY.adf();
        if (adf.getView() == null) {
            View oZ2 = adf.oZ();
            viewGroup.addView(oZ2);
            adf.acO();
            return oZ2;
        }
        return adf.getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
