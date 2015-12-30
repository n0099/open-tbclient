package com.baidu.tieba.themeCenter.bubble.group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<Object> dLQ;
    com.baidu.tieba.themeCenter.bubble.all.a dMV;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public View cta;
        public TextView dLS;
        public BubbleItemView dNc;
        public BubbleItemView dNd;
    }

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
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

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dLQ == null || this.dLQ.size() <= 0 || i < 0 || i >= this.dLQ.size()) {
            return null;
        }
        return this.dLQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (!(getItem(i) instanceof List)) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        Object item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.background_group_header, viewGroup, false);
            aVar = new a();
            aVar.dLS = (TextView) view.findViewById(n.g.group_name);
            view.setTag(aVar);
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.bubble_row, viewGroup, false);
            aVar = new a();
            aVar.dNc = (BubbleItemView) view.findViewById(n.g.bg_view1);
            aVar.dNd = (BubbleItemView) view.findViewById(n.g.bg_view2);
            aVar.cta = view.findViewById(n.g.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.dLS.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.dNc.c((DressItemData) list.get(0));
                aVar.dNc.setController(this.dMV);
                if (list.size() > 1) {
                    aVar.dNd.c((DressItemData) list.get(1));
                    aVar.dNd.setController(this.dMV);
                } else {
                    aVar.dNd.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.cta.setVisibility(8);
                } else {
                    aVar.cta.setVisibility(0);
                }
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.dLQ = list;
    }
}
