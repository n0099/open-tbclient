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
import d.a.o0.z1.h.d.a;
import java.util.List;
/* loaded from: classes5.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18778e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1828a> f18779f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18780g;

    /* renamed from: h  reason: collision with root package name */
    public int f18781h;

    /* renamed from: i  reason: collision with root package name */
    public int f18782i;

    /* loaded from: classes5.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18783a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18783a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18783a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18784a;

        public a(int i2) {
            this.f18784a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            a.C1828a c1828a;
            int i5 = this.f18784a;
            if (i5 < 0 || i5 >= MyEmotionHorizontalAdater.this.f18779f.size() || (c1828a = (a.C1828a) MyEmotionHorizontalAdater.this.f18779f.get(this.f18784a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1828a.f67592b = i2;
            c1828a.f67593c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1828a> list2, TbPageContext tbPageContext) {
        this.f18778e = list;
        this.f18779f = list2;
        this.f18780g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18781h;
    }

    public final void c() {
        this.f18781h = 0;
        this.f18782i = 0;
        for (EmotionPackageData emotionPackageData : this.f18778e) {
            if (emotionPackageData.ishasdownload) {
                this.f18781h++;
            } else {
                this.f18782i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18778e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f18778e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18780g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18778e.get(i2), this.f18782i);
        HListView listView = emotionGridViewHolder.f18783a.getListView();
        a.C1828a c1828a = this.f18779f.get(i2);
        if (c1828a != null) {
            listView.setSelectionFromLeft(c1828a.f67592b, c1828a.f67593c);
        }
        listView.setOnScrollListener(new a(i2));
        return view;
    }
}
