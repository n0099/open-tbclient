package com.baidu.tieba.mention;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private SingleMentionActivity caK;

    public s(SingleMentionActivity singleMentionActivity) {
        this.caK = singleMentionActivity;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            al adv = this.caK.adv();
            if (adv.getView() == null) {
                View pa = adv.pa();
                viewGroup.addView(pa);
                adv.adf();
                return pa;
            }
            return adv.getView();
        }
        j adw = this.caK.adw();
        if (adw.getView() == null) {
            View pa2 = adw.pa();
            viewGroup.addView(pa2);
            adw.adf();
            return pa2;
        }
        return adw.getView();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
