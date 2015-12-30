package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<Object> dLQ;
    i dLR;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public View cta;
        public TextView dLS;
        public BackgroundItemView dLT;
        public BackgroundItemView dLU;
        public BackgroundItemView dLV;
    }

    public b(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dLR = iVar;
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.background_row, viewGroup, false);
            aVar = new a();
            aVar.dLT = (BackgroundItemView) view.findViewById(n.g.bg_view1);
            aVar.dLU = (BackgroundItemView) view.findViewById(n.g.bg_view2);
            aVar.dLV = (BackgroundItemView) view.findViewById(n.g.bg_view3);
            aVar.dLT.setListenerTag(this.mContext.getUniqueId());
            aVar.dLU.setListenerTag(this.mContext.getUniqueId());
            aVar.dLV.setListenerTag(this.mContext.getUniqueId());
            aVar.cta = view.findViewById(n.g.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.dLS.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.dLT.c((DressItemData) list.get(0));
                aVar.dLT.setController(this.dLR);
                if (list.size() > 2) {
                    aVar.dLU.c((DressItemData) list.get(1));
                    aVar.dLV.c((DressItemData) list.get(2));
                    aVar.dLU.setController(this.dLR);
                    aVar.dLV.setController(this.dLR);
                } else if (list.size() > 1) {
                    aVar.dLU.c((DressItemData) list.get(1));
                    aVar.dLU.setController(this.dLR);
                    aVar.dLV.hide();
                } else {
                    aVar.dLU.hide();
                    aVar.dLV.hide();
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
