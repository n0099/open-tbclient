package com.baidu.tieba.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private SingleMentionActivity bWm;

    public s(SingleMentionActivity singleMentionActivity) {
        this.bWm = singleMentionActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            ak abM = this.bWm.abM();
            if (abM.getView() == null) {
                View oY = abM.oY();
                viewGroup.addView(oY);
                abM.abA();
                return oY;
            }
            return abM.getView();
        }
        j abN = this.bWm.abN();
        if (abN.getView() == null) {
            View oY2 = abN.oY();
            viewGroup.addView(oY2);
            abN.abA();
            return oY2;
        }
        return abN.getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
