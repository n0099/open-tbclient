package com.baidu.tieba.person;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public class bi extends PagerAdapter {
    public List<View> a;
    final /* synthetic */ bg b;

    public bi(bg bgVar, List<View> list) {
        this.b = bgVar;
        this.a = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.a.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public void finishUpdate(View view) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.a.get(i), 0);
        return this.a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void startUpdate(View view) {
    }
}
