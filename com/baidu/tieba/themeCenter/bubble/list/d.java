package com.baidu.tieba.themeCenter.bubble.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private List<List<DressItemData>> dLQ;
    com.baidu.tieba.themeCenter.bubble.all.a dMV;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public BubbleItemView dNc;
        public BubbleItemView dNd;
        public View mEmptyView;
    }

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mContext = tbPageContext;
        this.dMV = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dLQ != null) {
            return this.dLQ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nx */
    public List<DressItemData> getItem(int i) {
        if (this.dLQ == null || this.dLQ.size() <= 0 || i < 0 || i >= this.dLQ.size()) {
            return null;
        }
        return this.dLQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.bubble_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(n.g.top_white_line);
            aVar.dNc = (BubbleItemView) view.findViewById(n.g.bg_view1);
            aVar.dNd = (BubbleItemView) view.findViewById(n.g.bg_view2);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dNc.c(item.get(0));
            aVar.dNc.setController(this.dMV);
            if (item.size() > 1) {
                aVar.dNd.c(item.get(1));
                aVar.dNd.setController(this.dMV);
            } else {
                aVar.dNd.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.dLQ = list;
    }
}
