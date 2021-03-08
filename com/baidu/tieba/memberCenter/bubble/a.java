package com.baidu.tieba.memberCenter.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<BubbleChooseActivity> iWY;
    private boolean lne;
    private int mBottom;
    private List<BubbleListData.BubbleData> mData = new ArrayList();
    private int mTop;

    public void tT(boolean z) {
        this.lne = z;
    }

    public a(TbPageContext<BubbleChooseActivity> tbPageContext) {
        this.iWY = tbPageContext;
        this.mBottom = (int) this.iWY.getResources().getDimension(R.dimen.ds30);
        this.mTop = (int) this.iWY.getResources().getDimension(R.dimen.ds30);
    }

    public List<BubbleListData.BubbleData> cSp() {
        return this.mData;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Es */
    public BubbleListData.BubbleData getItem(int i) {
        if (this.mData == null || (i < 0 && i >= this.mData.size())) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BubbleView bubbleView;
        if (view == null) {
            BubbleView bubbleView2 = new BubbleView(this.iWY.getPageActivity());
            bubbleView = bubbleView2;
            view = bubbleView2;
        } else {
            bubbleView = (BubbleView) view;
        }
        if (i == 0 || i == 1) {
            bubbleView.setPadding(0, this.mTop, 0, 0);
        }
        if (getCount() % 2 == 0) {
            if (i == getCount() - 1 || i == getCount() - 2) {
                bubbleView.setPadding(0, bubbleView.getPaddingTop(), 0, this.mBottom);
            }
        } else if (i == getCount() - 1) {
            bubbleView.setPadding(0, bubbleView.getPaddingTop(), 0, this.mBottom);
        }
        BubbleListData.BubbleData item = getItem(i);
        if (item != null) {
            bubbleView.setShowName(true);
            bubbleView.setData(item, this.lne);
        }
        bubbleView.D(this.iWY);
        return view;
    }

    public void setData(List<BubbleListData.BubbleData> list) {
        this.mData.clear();
        BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
        bubbleData.setBcode(0);
        this.mData.add(bubbleData);
        this.mData.addAll(list);
        notifyDataSetChanged();
    }
}
