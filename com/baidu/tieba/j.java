package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
/* loaded from: classes.dex */
class j extends android.support.v4.view.k {
    final /* synthetic */ GuideActivity a;

    private j(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(GuideActivity guideActivity, j jVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.k
    public int getCount() {
        int[] iArr;
        iArr = this.a.d;
        return iArr.length;
    }

    @Override // android.support.v4.view.k
    public Object instantiateItem(View view, int i) {
        Button button;
        Button button2;
        ((ViewPager) view).addView((View) this.a.a.get(i), 0);
        this.a.f = (Button) this.a.findViewById(R.id.st_button);
        button = this.a.f;
        if (button != null) {
            button2 = this.a.f;
            button2.setOnClickListener(this.a.c);
        }
        return this.a.a.get(i);
    }

    @Override // android.support.v4.view.k
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.a.a.get(i));
    }

    @Override // android.support.v4.view.k
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
