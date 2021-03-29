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
/* loaded from: classes3.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f19286e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1667a> f19287f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19288g;

    /* renamed from: h  reason: collision with root package name */
    public int f19289h;
    public int i;

    /* loaded from: classes3.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f19290a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f19290a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f19290a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19291a;

        public a(int i) {
            this.f19291a = i;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i, int i2, int i3) {
            a.C1667a c1667a;
            int i4 = this.f19291a;
            if (i4 < 0 || i4 >= MyEmotionHorizontalAdater.this.f19287f.size() || (c1667a = (a.C1667a) MyEmotionHorizontalAdater.this.f19287f.get(this.f19291a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1667a.f62475b = i;
            c1667a.f62476c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1667a> list2, TbPageContext tbPageContext) {
        this.f19286e = list;
        this.f19287f = list2;
        this.f19288g = tbPageContext;
        c();
    }

    public int b() {
        return this.f19289h;
    }

    public final void c() {
        this.f19289h = 0;
        this.i = 0;
        for (EmotionPackageData emotionPackageData : this.f19286e) {
            if (emotionPackageData.ishasdownload) {
                this.f19289h++;
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
        return this.f19286e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f19286e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f19288g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f19286e.get(i), this.i);
        HListView listView = emotionGridViewHolder.f19290a.getListView();
        a.C1667a c1667a = this.f19287f.get(i);
        if (c1667a != null) {
            listView.setSelectionFromLeft(c1667a.f62475b, c1667a.f62476c);
        }
        listView.setOnScrollListener(new a(i));
        return view;
    }
}
