package com.baidu.tieba.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BaseViewPagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1816a;

    public BaseViewPagerAdapter() {
        this.f1816a = null;
        this.f1816a = new ArrayList();
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f1816a.size();
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.f1816a.get(i), 0);
        return this.f1816a.get(i);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.f1816a.get(i));
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
