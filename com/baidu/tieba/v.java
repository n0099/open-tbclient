package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v extends android.support.v4.view.ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1933a;

    private v(GuideActivity guideActivity) {
        this.f1933a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(GuideActivity guideActivity, v vVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        int[] iArr;
        iArr = this.f1933a.c;
        return iArr.length;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        arrayList = this.f1933a.d;
        if (i < arrayList.size()) {
            arrayList2 = this.f1933a.d;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            arrayList3 = this.f1933a.d;
            if (i == arrayList3.size() - 1) {
                arrayList5 = this.f1933a.d;
                ((View) arrayList5.get(i)).setOnClickListener(this.f1933a.f854a);
            }
            arrayList4 = this.f1933a.d;
            return arrayList4.get(i);
        }
        View view2 = new View(this.f1933a);
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
