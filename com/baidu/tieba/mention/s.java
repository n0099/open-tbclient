package com.baidu.tieba.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private SingleMentionActivity bVG;

    public s(SingleMentionActivity singleMentionActivity) {
        this.bVG = singleMentionActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            ak abH = this.bVG.abH();
            if (abH.getView() == null) {
                View pb = abH.pb();
                viewGroup.addView(pb);
                abH.abv();
                return pb;
            }
            return abH.getView();
        }
        j abI = this.bVG.abI();
        if (abI.getView() == null) {
            View pb2 = abI.pb();
            viewGroup.addView(pb2);
            abI.abv();
            return pb2;
        }
        return abI.getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
