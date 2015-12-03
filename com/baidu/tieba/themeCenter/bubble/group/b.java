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
    private List<Object> dEm;
    com.baidu.tieba.themeCenter.bubble.all.a dFt;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public View coX;
        public TextView dEo;
        public BubbleItemView dFA;
        public BubbleItemView dFB;
    }

    public b(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mContext = tbPageContext;
        this.dFt = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dEm != null) {
            return this.dEm.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dEm == null || this.dEm.size() <= 0 || i < 0 || i >= this.dEm.size()) {
            return null;
        }
        return this.dEm.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.background_group_header, viewGroup, false);
            aVar = new a();
            aVar.dEo = (TextView) view.findViewById(n.f.group_name);
            view.setTag(aVar);
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.bubble_row, viewGroup, false);
            aVar = new a();
            aVar.dFA = (BubbleItemView) view.findViewById(n.f.bg_view1);
            aVar.dFB = (BubbleItemView) view.findViewById(n.f.bg_view2);
            aVar.coX = view.findViewById(n.f.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.dEo.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.dFA.c((DressItemData) list.get(0));
                aVar.dFA.setController(this.dFt);
                if (list.size() > 1) {
                    aVar.dFB.c((DressItemData) list.get(1));
                    aVar.dFB.setController(this.dFt);
                } else {
                    aVar.dFB.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.coX.setVisibility(8);
                } else {
                    aVar.coX.setVisibility(0);
                }
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.dEm = list;
    }
}
