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
import d.a.j0.y1.h.d.a;
import java.util.List;
/* loaded from: classes3.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f19418e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1686a> f19419f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19420g;

    /* renamed from: h  reason: collision with root package name */
    public int f19421h;

    /* renamed from: i  reason: collision with root package name */
    public int f19422i;

    /* loaded from: classes3.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f19423a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f19423a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f19423a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19424a;

        public a(int i2) {
            this.f19424a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            a.C1686a c1686a;
            int i5 = this.f19424a;
            if (i5 < 0 || i5 >= MyEmotionHorizontalAdater.this.f19419f.size() || (c1686a = (a.C1686a) MyEmotionHorizontalAdater.this.f19419f.get(this.f19424a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1686a.f62861b = i2;
            c1686a.f62862c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1686a> list2, TbPageContext tbPageContext) {
        this.f19418e = list;
        this.f19419f = list2;
        this.f19420g = tbPageContext;
        c();
    }

    public int b() {
        return this.f19421h;
    }

    public final void c() {
        this.f19421h = 0;
        this.f19422i = 0;
        for (EmotionPackageData emotionPackageData : this.f19418e) {
            if (emotionPackageData.ishasdownload) {
                this.f19421h++;
            } else {
                this.f19422i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f19418e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f19418e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f19420g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f19418e.get(i2), this.f19422i);
        HListView listView = emotionGridViewHolder.f19423a.getListView();
        a.C1686a c1686a = this.f19419f.get(i2);
        if (c1686a != null) {
            listView.setSelectionFromLeft(c1686a.f62861b, c1686a.f62862c);
        }
        listView.setOnScrollListener(new a(i2));
        return view;
    }
}
