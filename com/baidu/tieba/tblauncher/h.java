package com.baidu.tieba.tblauncher;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
class h extends PagerAdapter {
    final /* synthetic */ GuideActivity bOC;

    private h(GuideActivity guideActivity) {
        this.bOC = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(GuideActivity guideActivity, h hVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        ArrayList arrayList;
        arrayList = this.bOC.bOp;
        return arrayList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        arrayList = this.bOC.bOp;
        if (i < arrayList.size()) {
            arrayList2 = this.bOC.bOp;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            arrayList3 = this.bOC.bOp;
            if (i == arrayList3.size() - 1) {
                arrayList5 = this.bOC.bOp;
                ((View) arrayList5.get(i)).setOnClickListener(this.bOC.bOz);
            }
            arrayList4 = this.bOC.bOp;
            return arrayList4.get(i);
        }
        View view2 = new View(this.bOC);
        view2.setBackgroundColor(-1);
        ((ViewPager) view).addView(view2, 0);
        return view2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
