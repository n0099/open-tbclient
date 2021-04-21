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
import d.b.j0.y1.h.d.a;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18971e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1749a> f18972f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18973g;

    /* renamed from: h  reason: collision with root package name */
    public int f18974h;
    public int i;

    /* loaded from: classes3.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18975a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18975a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18975a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18976a;

        public a(int i) {
            this.f18976a = i;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            a.C1749a c1749a;
            int i4 = this.f18976a;
            if (i4 < 0 || i4 >= MyEmotionHorizontalAdater.this.f18972f.size() || (c1749a = (a.C1749a) MyEmotionHorizontalAdater.this.f18972f.get(this.f18976a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1749a.f64581b = i;
            c1749a.f64582c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1749a> list2, TbPageContext tbPageContext) {
        this.f18971e = list;
        this.f18972f = list2;
        this.f18973g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18974h;
    }

    public final void c() {
        this.f18974h = 0;
        this.i = 0;
        for (EmotionPackageData emotionPackageData : this.f18971e) {
            if (emotionPackageData.ishasdownload) {
                this.f18974h++;
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
        return this.f18971e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f18971e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18973g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18971e.get(i), this.i);
        HListView listView = emotionGridViewHolder.f18975a.getListView();
        a.C1749a c1749a = this.f18972f.get(i);
        if (c1749a != null) {
            listView.setSelectionFromLeft(c1749a.f64581b, c1749a.f64582c);
        }
        listView.setOnScrollListener(new a(i));
        return view;
    }
}
