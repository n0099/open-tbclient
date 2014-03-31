package com.baidu.tieba.tbluncher;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class h extends PagerAdapter {
    final /* synthetic */ GuideActivity a;

    private h(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(GuideActivity guideActivity, byte b) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        int[] iArr;
        iArr = this.a.f;
        return iArr.length + 1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        arrayList = this.a.g;
        if (i < arrayList.size()) {
            arrayList2 = this.a.g;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            arrayList3 = this.a.g;
            if (i == arrayList3.size() - 1) {
                arrayList5 = this.a.g;
                ((View) arrayList5.get(i)).setOnClickListener(this.a.b);
            }
            arrayList4 = this.a.g;
            return arrayList4.get(i);
        }
        View view2 = new View(this.a);
        view2.setBackgroundColor(-1);
        ((ViewPager) view).addView(view2, 0);
        return view2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
