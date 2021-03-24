package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView;
import d.b.i0.x1.h.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f19285e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1666a> f19286f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19287g;

    /* renamed from: h  reason: collision with root package name */
    public int f19288h;
    public int i;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f19289a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f19289a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f19289a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19290a;

        public a(int i) {
            this.f19290a = i;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            a.C1666a c1666a;
            int i4 = this.f19290a;
            if (i4 < 0 || i4 >= MyEmotionHorizontalAdater.this.f19286f.size() || (c1666a = (a.C1666a) MyEmotionHorizontalAdater.this.f19286f.get(this.f19290a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1666a.f62474b = i;
            c1666a.f62475c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1666a> list2, TbPageContext tbPageContext) {
        this.f19285e = list;
        this.f19286f = list2;
        this.f19287g = tbPageContext;
        c();
    }

    public int b() {
        return this.f19288h;
    }

    public final void c() {
        this.f19288h = 0;
        this.i = 0;
        for (EmotionPackageData emotionPackageData : this.f19285e) {
            if (emotionPackageData.ishasdownload) {
                this.f19288h++;
            } else {
                this.i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19285e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f19285e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f19287g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f19285e.get(i), this.i);
        HListView listView = emotionGridViewHolder.f19289a.getListView();
        a.C1666a c1666a = this.f19286f.get(i);
        if (c1666a != null) {
            listView.setSelectionFromLeft(c1666a.f62474b, c1666a.f62475c);
        }
        listView.setOnScrollListener(new a(i));
        return view;
    }
}
