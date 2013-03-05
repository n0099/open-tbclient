package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k extends android.support.v4.view.k {
    final /* synthetic */ GuideActivity a;

    private k(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(GuideActivity guideActivity, k kVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.k
    public int getCount() {
        int[] iArr;
        iArr = this.a.b;
        return iArr.length;
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Button button;
        ArrayList arrayList3;
        Button button2;
        arrayList = this.a.c;
        if (i < arrayList.size()) {
            arrayList2 = this.a.c;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            this.a.f = (Button) this.a.findViewById(R.id.st_button);
            button = this.a.f;
            if (button != null) {
                button2 = this.a.f;
                button2.setOnClickListener(this.a.a);
            }
            arrayList3 = this.a.c;
            return arrayList3.get(i);
        }
        View view2 = new View(this.a);
        view2.setBackgroundColor(-1);
        ((ViewPager) view).addView(view2, 0);
        return view2;
    }

    @Override // android.support.v4.view.k
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.k
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
