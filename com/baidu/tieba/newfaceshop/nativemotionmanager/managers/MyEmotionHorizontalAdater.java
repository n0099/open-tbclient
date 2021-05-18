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
import d.a.k0.y1.h.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18706e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1751a> f18707f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18708g;

    /* renamed from: h  reason: collision with root package name */
    public int f18709h;

    /* renamed from: i  reason: collision with root package name */
    public int f18710i;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18711a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18711a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18711a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18712a;

        public a(int i2) {
            this.f18712a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            a.C1751a c1751a;
            int i5 = this.f18712a;
            if (i5 < 0 || i5 >= MyEmotionHorizontalAdater.this.f18707f.size() || (c1751a = (a.C1751a) MyEmotionHorizontalAdater.this.f18707f.get(this.f18712a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1751a.f63585b = i2;
            c1751a.f63586c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1751a> list2, TbPageContext tbPageContext) {
        this.f18706e = list;
        this.f18707f = list2;
        this.f18708g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18709h;
    }

    public final void c() {
        this.f18709h = 0;
        this.f18710i = 0;
        for (EmotionPackageData emotionPackageData : this.f18706e) {
            if (emotionPackageData.ishasdownload) {
                this.f18709h++;
            } else {
                this.f18710i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18706e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f18706e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18708g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18706e.get(i2), this.f18710i);
        HListView listView = emotionGridViewHolder.f18711a.getListView();
        a.C1751a c1751a = this.f18707f.get(i2);
        if (c1751a != null) {
            listView.setSelectionFromLeft(c1751a.f63585b, c1751a.f63586c);
        }
        listView.setOnScrollListener(new a(i2));
        return view;
    }
}
