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
    private List<EmotionPackageData> caS;
    private List<a.C0814a> lDl;
    private int lDq;
    private int lDr;
    private TbPageContext mPageContext;

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0814a> list2, TbPageContext tbPageContext) {
        this.caS = list;
        this.lDl = list2;
        this.mPageContext = tbPageContext;
        djd();
    }

    private void djd() {
        this.lDq = 0;
        this.lDr = 0;
        for (EmotionPackageData emotionPackageData : this.caS) {
            if (emotionPackageData.ishasdownload) {
                this.lDq++;
            } else {
                this.lDr++;
            }
        }
    }

    public int dje() {
        return this.lDq;
    }

    public void djf() {
        djd();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.caS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caS.get(i);
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
        emotionGridViewHolder2.setData(this.caS.get(i), this.lDr);
        HListView listView = emotionGridViewHolder2.lDt.getListView();
        a.C0814a c0814a = this.lDl.get(i);
        if (c0814a != null) {
            listView.setSelectionFromLeft(c0814a.lDo, c0814a.lDp);
        }
        listView.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater.1
            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2) {
            }

            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2, int i3, int i4) {
                a.C0814a c0814a2;
                if (i >= 0 && i < MyEmotionHorizontalAdater.this.lDl.size() && (c0814a2 = (a.C0814a) MyEmotionHorizontalAdater.this.lDl.get(i)) != null) {
                    int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
                    c0814a2.lDo = i2;
                    c0814a2.lDp = left;
                }
            }
        });
        return view;
    }

    /* loaded from: classes9.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionManageHorizontalView lDt;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lDt = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i) {
            if (this.lDt != null && emotionPackageData != null) {
                this.lDt.setData(emotionPackageData, i);
            }
        }
    }
}
