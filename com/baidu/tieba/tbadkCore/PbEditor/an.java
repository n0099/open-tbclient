package com.baidu.tieba.tbadkCore.PbEditor;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends PagerAdapter {
    private ArrayList<View> XJ;
    final /* synthetic */ PrivilegeTabContentView bUO;

    public an(PrivilegeTabContentView privilegeTabContentView, ArrayList<View> arrayList) {
        this.bUO = privilegeTabContentView;
        this.XJ = new ArrayList<>();
        this.XJ = arrayList;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.XJ.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.XJ.get(i));
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.XJ.get(i);
        viewGroup.addView(view);
        return view;
    }
}
