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
    private List<EmotionPackageData> bWQ;
    private List<a.C0812a> luT;
    private int luY;
    private int luZ;
    private TbPageContext mPageContext;

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0812a> list2, TbPageContext tbPageContext) {
        this.bWQ = list;
        this.luT = list2;
        this.mPageContext = tbPageContext;
        dgV();
    }

    private void dgV() {
        this.luY = 0;
        this.luZ = 0;
        for (EmotionPackageData emotionPackageData : this.bWQ) {
            if (emotionPackageData.ishasdownload) {
                this.luY++;
            } else {
                this.luZ++;
            }
        }
    }

    public int dgW() {
        return this.luY;
    }

    public void dgX() {
        dgV();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bWQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.bWQ.get(i);
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
        emotionGridViewHolder2.setData(this.bWQ.get(i), this.luZ);
        HListView listView = emotionGridViewHolder2.lvb.getListView();
        a.C0812a c0812a = this.luT.get(i);
        if (c0812a != null) {
            listView.setSelectionFromLeft(c0812a.luW, c0812a.luX);
        }
        listView.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater.1
            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2) {
            }

            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2, int i3, int i4) {
                a.C0812a c0812a2;
                if (i >= 0 && i < MyEmotionHorizontalAdater.this.luT.size() && (c0812a2 = (a.C0812a) MyEmotionHorizontalAdater.this.luT.get(i)) != null) {
                    int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
                    c0812a2.luW = i2;
                    c0812a2.luX = left;
                }
            }
        });
        return view;
    }

    /* loaded from: classes8.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionManageHorizontalView lvb;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lvb = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i) {
            if (this.lvb != null && emotionPackageData != null) {
                this.lvb.setData(emotionPackageData, i);
            }
        }
    }
}
