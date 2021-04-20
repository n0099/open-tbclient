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
import d.b.i0.y1.h.d.a;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18963e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1726a> f18964f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18965g;

    /* renamed from: h  reason: collision with root package name */
    public int f18966h;
    public int i;

    /* loaded from: classes3.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18967a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18967a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18967a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18968a;

        public a(int i) {
            this.f18968a = i;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            a.C1726a c1726a;
            int i4 = this.f18968a;
            if (i4 < 0 || i4 >= MyEmotionHorizontalAdater.this.f18964f.size() || (c1726a = (a.C1726a) MyEmotionHorizontalAdater.this.f18964f.get(this.f18968a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1726a.f64160b = i;
            c1726a.f64161c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1726a> list2, TbPageContext tbPageContext) {
        this.f18963e = list;
        this.f18964f = list2;
        this.f18965g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18966h;
    }

    public final void c() {
        this.f18966h = 0;
        this.i = 0;
        for (EmotionPackageData emotionPackageData : this.f18963e) {
            if (emotionPackageData.ishasdownload) {
                this.f18966h++;
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
        return this.f18963e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f18963e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18965g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18963e.get(i), this.i);
        HListView listView = emotionGridViewHolder.f18967a.getListView();
        a.C1726a c1726a = this.f18964f.get(i);
        if (c1726a != null) {
            listView.setSelectionFromLeft(c1726a.f64160b, c1726a.f64161c);
        }
        listView.setOnScrollListener(new a(i));
        return view;
    }
}
