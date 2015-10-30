package com.baidu.tieba.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private SingleMentionActivity caj;

    public s(SingleMentionActivity singleMentionActivity) {
        this.caj = singleMentionActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            al ada = this.caj.ada();
            if (ada.getView() == null) {
                View oZ = ada.oZ();
                viewGroup.addView(oZ);
                ada.acK();
                return oZ;
            }
            return ada.getView();
        }
        j adb = this.caj.adb();
        if (adb.getView() == null) {
            View oZ2 = adb.oZ();
            viewGroup.addView(oZ2);
            adb.acK();
            return oZ2;
        }
        return adb.getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
