package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
class z extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2728a;

    private z(GuideActivity guideActivity) {
        this.f2728a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(GuideActivity guideActivity, u uVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        int[] iArr;
        iArr = this.f2728a.e;
        return iArr.length;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        arrayList = this.f2728a.f;
        if (i < arrayList.size()) {
            arrayList2 = this.f2728a.f;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            arrayList3 = this.f2728a.f;
            if (i == arrayList3.size() - 1) {
                arrayList5 = this.f2728a.f;
                ((View) arrayList5.get(i)).setOnClickListener(this.f2728a.c);
            }
            arrayList4 = this.f2728a.f;
            return arrayList4.get(i);
        }
        View view2 = new View(this.f2728a);
        view2.setBackgroundColor(-1);
        ((ViewPager) view).addView(view2, 0);
        return view2;
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.ae
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
