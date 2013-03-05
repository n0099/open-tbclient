package com.baidu.tieba.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BaseViewPagerAdapter extends android.support.v4.view.k {
    private ArrayList a;

    public BaseViewPagerAdapter() {
        this.a = null;
        this.a = new ArrayList();
    }

    public void a(ArrayList arrayList) {
        if (arrayList != null) {
            this.a = arrayList;
        }
    }

    @Override // android.support.v4.view.k
    public int getCount() {
        return this.a.size();
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.a.get(i), 0);
        return this.a.get(i);
    }

    @Override // android.support.v4.view.k
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.a.get(i));
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
