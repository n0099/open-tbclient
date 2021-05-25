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
import d.a.n0.z1.h.d.a;
import java.util.List;
/* loaded from: classes4.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18620e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1766a> f18621f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18622g;

    /* renamed from: h  reason: collision with root package name */
    public int f18623h;

    /* renamed from: i  reason: collision with root package name */
    public int f18624i;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18625a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18625a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18625a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18626a;

        public a(int i2) {
            this.f18626a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            a.C1766a c1766a;
            int i5 = this.f18626a;
            if (i5 < 0 || i5 >= MyEmotionHorizontalAdater.this.f18621f.size() || (c1766a = (a.C1766a) MyEmotionHorizontalAdater.this.f18621f.get(this.f18626a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1766a.f63749b = i2;
            c1766a.f63750c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1766a> list2, TbPageContext tbPageContext) {
        this.f18620e = list;
        this.f18621f = list2;
        this.f18622g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18623h;
    }

    public final void c() {
        this.f18623h = 0;
        this.f18624i = 0;
        for (EmotionPackageData emotionPackageData : this.f18620e) {
            if (emotionPackageData.ishasdownload) {
                this.f18623h++;
            } else {
                this.f18624i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18620e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f18620e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18622g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18620e.get(i2), this.f18624i);
        HListView listView = emotionGridViewHolder.f18625a.getListView();
        a.C1766a c1766a = this.f18621f.get(i2);
        if (c1766a != null) {
            listView.setSelectionFromLeft(c1766a.f63749b, c1766a.f63750c);
        }
        listView.setOnScrollListener(new a(i2));
        return view;
    }
}
