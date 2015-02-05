package com.baidu.tieba.tbadkCore.PbEditor;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends PagerAdapter {
    private ArrayList<View> Ym;
    final /* synthetic */ PrivilegeTabContentView bWG;

    public an(PrivilegeTabContentView privilegeTabContentView, ArrayList<View> arrayList) {
        this.bWG = privilegeTabContentView;
        this.Ym = new ArrayList<>();
        this.Ym = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Ym.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.Ym.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.Ym.get(i);
        viewGroup.addView(view);
        return view;
    }
}
