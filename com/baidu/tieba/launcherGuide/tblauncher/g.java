package com.baidu.tieba.launcherGuide.tblauncher;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
class g extends PagerAdapter {
    final /* synthetic */ GuideActivity bxO;

    private g(GuideActivity guideActivity) {
        this.bxO = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(GuideActivity guideActivity, g gVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        ArrayList arrayList;
        arrayList = this.bxO.bxE;
        return arrayList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        arrayList = this.bxO.bxE;
        if (i < arrayList.size()) {
            arrayList2 = this.bxO.bxE;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            arrayList3 = this.bxO.bxE;
            if (i == arrayList3.size() - 1) {
                arrayList5 = this.bxO.bxE;
                ((View) arrayList5.get(i)).setOnClickListener(this.bxO.bxL);
            }
            arrayList4 = this.bxO.bxE;
            return arrayList4.get(i);
        }
        View view2 = new View(this.bxO.getPageContext().getPageActivity());
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
