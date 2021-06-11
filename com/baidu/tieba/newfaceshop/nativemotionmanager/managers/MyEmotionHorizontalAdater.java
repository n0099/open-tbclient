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
    public List<EmotionPackageData> f18696e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1824a> f18697f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f18698g;

    /* renamed from: h  reason: collision with root package name */
    public int f18699h;

    /* renamed from: i  reason: collision with root package name */
    public int f18700i;

    /* loaded from: classes4.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EmotionManageHorizontalView f18701a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18701a = (EmotionManageHorizontalView) view;
        }

        public void c(EmotionPackageData emotionPackageData, int i2) {
            EmotionManageHorizontalView emotionManageHorizontalView = this.f18701a;
            if (emotionManageHorizontalView == null || emotionPackageData == null) {
                return;
            }
            emotionManageHorizontalView.setData(emotionPackageData, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements AbsHListView.i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f18702a;

        public a(int i2) {
            this.f18702a = i2;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void a(AbsHListView absHListView, int i2, int i3, int i4) {
            a.C1824a c1824a;
            int i5 = this.f18702a;
            if (i5 < 0 || i5 >= MyEmotionHorizontalAdater.this.f18697f.size() || (c1824a = (a.C1824a) MyEmotionHorizontalAdater.this.f18697f.get(this.f18702a)) == null) {
                return;
            }
            int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
            c1824a.f67467b = i2;
            c1824a.f67468c = left;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.i
        public void b(AbsHListView absHListView, int i2) {
        }
    }

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C1824a> list2, TbPageContext tbPageContext) {
        this.f18696e = list;
        this.f18697f = list2;
        this.f18698g = tbPageContext;
        c();
    }

    public int b() {
        return this.f18699h;
    }

    public final void c() {
        this.f18699h = 0;
        this.f18700i = 0;
        for (EmotionPackageData emotionPackageData : this.f18696e) {
            if (emotionPackageData.ishasdownload) {
                this.f18699h++;
            } else {
                this.f18700i++;
            }
        }
    }

    public void d() {
        c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18696e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f18696e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.f18698g);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.c(this.f18696e.get(i2), this.f18700i);
        HListView listView = emotionGridViewHolder.f18701a.getListView();
        a.C1824a c1824a = this.f18697f.get(i2);
        if (c1824a != null) {
            listView.setSelectionFromLeft(c1824a.f67467b, c1824a.f67468c);
        }
        listView.setOnScrollListener(new a(i2));
        return view;
    }
}
