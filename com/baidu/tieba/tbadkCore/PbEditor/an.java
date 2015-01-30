package com.baidu.tieba.tbadkCore.PbEditor;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends PagerAdapter {
    private ArrayList<View> Yp;
    final /* synthetic */ PrivilegeTabContentView bWH;

    public an(PrivilegeTabContentView privilegeTabContentView, ArrayList<View> arrayList) {
        this.bWH = privilegeTabContentView;
        this.Yp = new ArrayList<>();
        this.Yp = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Yp.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.Yp.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.Yp.get(i);
        viewGroup.addView(view);
        return view;
    }
}
