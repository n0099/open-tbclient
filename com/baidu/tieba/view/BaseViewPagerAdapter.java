package com.baidu.tieba.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BaseViewPagerAdapter extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<View> f1935a;

    public BaseViewPagerAdapter() {
        this.f1935a = null;
        this.f1935a = new ArrayList<>();
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.f1935a.size();
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.f1935a.get(i), 0);
        return this.f1935a.get(i);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.f1935a.get(i));
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
