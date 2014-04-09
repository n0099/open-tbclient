package com.baidu.tieba.person;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public final class aj extends PagerAdapter {
    public List<View> a;
    final /* synthetic */ ag b;

    public aj(ag agVar, List<View> list) {
        this.b = agVar;
        this.a = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView(this.a.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void finishUpdate(View view) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView(this.a.get(i), 0);
        return this.a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Parcelable saveState() {
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void startUpdate(View view) {
    }
}
