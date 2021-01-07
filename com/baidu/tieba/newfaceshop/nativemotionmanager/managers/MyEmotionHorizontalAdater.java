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
/* loaded from: classes9.dex */
public class MyEmotionHorizontalAdater extends BaseAdapter {
    private List<EmotionPackageData> cbD;
    private int lzE;
    private int lzF;
    private List<a.C0829a> lzz;
    private TbPageContext mPageContext;

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0829a> list2, TbPageContext tbPageContext) {
        this.cbD = list;
        this.lzz = list2;
        this.mPageContext = tbPageContext;
        dkN();
    }

    private void dkN() {
        this.lzE = 0;
        this.lzF = 0;
        for (EmotionPackageData emotionPackageData : this.cbD) {
            if (emotionPackageData.ishasdownload) {
                this.lzE++;
            } else {
                this.lzF++;
            }
        }
    }

    public int dkO() {
        return this.lzE;
    }

    public void dkP() {
        dkN();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cbD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.cbD.get(i);
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
        emotionGridViewHolder2.setData(this.cbD.get(i), this.lzF);
        HListView listView = emotionGridViewHolder2.lzH.getListView();
        a.C0829a c0829a = this.lzz.get(i);
        if (c0829a != null) {
            listView.setSelectionFromLeft(c0829a.lzC, c0829a.lzD);
        }
        listView.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater.1
            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2) {
            }

            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2, int i3, int i4) {
                a.C0829a c0829a2;
                if (i >= 0 && i < MyEmotionHorizontalAdater.this.lzz.size() && (c0829a2 = (a.C0829a) MyEmotionHorizontalAdater.this.lzz.get(i)) != null) {
                    int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
                    c0829a2.lzC = i2;
                    c0829a2.lzD = left;
                }
            }
        });
        return view;
    }

    /* loaded from: classes9.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionManageHorizontalView lzH;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lzH = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i) {
            if (this.lzH != null && emotionPackageData != null) {
                this.lzH.setData(emotionPackageData, i);
            }
        }
    }
}
