package com.baidu.tieba;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q extends android.support.v4.view.ae {
    final /* synthetic */ GuideActivity a;

    private q(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(GuideActivity guideActivity, q qVar) {
        this(guideActivity);
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        int[] iArr;
        iArr = this.a.c;
        return iArr.length;
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(View view, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Button button;
        ArrayList arrayList3;
        Button button2;
        arrayList = this.a.d;
        if (i < arrayList.size()) {
            arrayList2 = this.a.d;
            ((ViewPager) view).addView((View) arrayList2.get(i), 0);
            this.a.g = (Button) this.a.findViewById(R.id.st_button);
            button = this.a.g;
            if (button != null) {
                button2 = this.a.g;
                button2.setOnClickListener(this.a.a);
            }
            arrayList3 = this.a.d;
            return arrayList3.get(i);
        }
        View view2 = new View(this.a);
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
