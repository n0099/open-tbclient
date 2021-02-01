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
    private List<a.C0813a> lCX;
    private int lDc;
    private int lDd;
    private TbPageContext mPageContext;

    public MyEmotionHorizontalAdater(List<EmotionPackageData> list, List<a.C0813a> list2, TbPageContext tbPageContext) {
        this.caS = list;
        this.lCX = list2;
        this.mPageContext = tbPageContext;
        diW();
    }

    private void diW() {
        this.lDc = 0;
        this.lDd = 0;
        for (EmotionPackageData emotionPackageData : this.caS) {
            if (emotionPackageData.ishasdownload) {
                this.lDc++;
            } else {
                this.lDd++;
            }
        }
    }

    public int diX() {
        return this.lDc;
    }

    public void diY() {
        diW();
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
        emotionGridViewHolder2.setData(this.caS.get(i), this.lDd);
        HListView listView = emotionGridViewHolder2.lDf.getListView();
        a.C0813a c0813a = this.lCX.get(i);
        if (c0813a != null) {
            listView.setSelectionFromLeft(c0813a.lDa, c0813a.lDb);
        }
        listView.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.managers.MyEmotionHorizontalAdater.1
            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2) {
            }

            @Override // com.baidu.tieba.horizonalList.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i2, int i3, int i4) {
                a.C0813a c0813a2;
                if (i >= 0 && i < MyEmotionHorizontalAdater.this.lCX.size() && (c0813a2 = (a.C0813a) MyEmotionHorizontalAdater.this.lCX.get(i)) != null) {
                    int left = absHListView.getChildCount() > 0 ? absHListView.getChildAt(0).getLeft() : 0;
                    c0813a2.lDa = i2;
                    c0813a2.lDb = left;
                }
            }
        });
        return view;
    }

    /* loaded from: classes9.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private EmotionManageHorizontalView lDf;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lDf = (EmotionManageHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData, int i) {
            if (this.lDf != null && emotionPackageData != null) {
                this.lDf.setData(emotionPackageData, i);
            }
        }
    }
}
