package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.newfaceshop.nativemotionmanager.managers.a;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.EmotionManageHorizontalView;
import java.util.List;
/* loaded from: classes8.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {
    private List<EmotionPackageData> ccu;
    private List<a.C0820a> lFn;
    private int lFs;
    private int lFt;
    private TbPageContext mPageContext;

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0820a> list2, TbPageContext tbPageContext) {
        this.ccu = list;
        this.lFn = list2;
        this.mPageContext = tbPageContext;
        djm();
    }

    private void djm() {
        this.lFs = 0;
        this.lFt = 0;
        for (EmotionPackageData emotionPackageData : this.ccu) {
            if (emotionPackageData.ishasdownload) {
                this.lFs++;
            } else {
                this.lFt++;
            }
        }
    }

    public int djn() {
        return this.lFs;
    }

    public void djo() {
        djm();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ccu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.ccu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder = null;
        if (view == null) {
            view = new EmotionManageHorizontalView(this.mPageContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        }
        EmotionGridViewHolder emotionGridViewHolder2 = emotionGridViewHolder == null ? (EmotionGridViewHolder) view.getTag() : emotionGridViewHolder;
        emotionGridViewHolder2.setData(this.ccu.get(i), this.lFt);
        HListView listView = emotionGridViewHolder2.lFv.getListView();
        a.C0820a c0820a = this.lFn.get(i);
        if (c0820a != null) {
            listView.setSelectionFromLeft(c0820a.lFq, c0820a.lFr);
        }
        listView.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater.1
            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2) {
            }

            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2, int i3, int i4) {
                a.C0820a c0820a2;
                if (i >= 0 && i < MyEmotionHorizontalAdater.this.lFn.size() && (c0820a2 = (a.C0820a) MyEmotionHorizontalAdater.this.lFn.get(i)) != null) {
                    int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
                    c0820a2.lFq = i2;
                    c0820a2.lFr = left;
                }
            }
        });
        return view;
    }

    /* loaded from: classes8.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionManageHorizontalView lFv;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lFv = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i) {
            if (this.lFv != null && emotionPackageData != null) {
                this.lFv.setData(emotionPackageData, i);
            }
        }
    }
}
