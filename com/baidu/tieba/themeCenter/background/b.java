package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    i deA;
    private List<Object> dez;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public TextView deB;
        public BackgroundItemView deC;
        public BackgroundItemView deD;
        public BackgroundItemView deE;
        public View deF;
    }

    public b(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.deA = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dez != null) {
            return this.dez.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dez == null || this.dez.size() <= 0 || i < 0 || i >= this.dez.size()) {
            return null;
        }
        return this.dez.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_group_header, viewGroup, false);
            aVar = new a();
            aVar.deB = (TextView) view.findViewById(i.f.group_name);
            view.setTag(aVar);
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.deC = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.deD = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.deE = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.deC.setListenerTag(this.mContext.getUniqueId());
            aVar.deD.setListenerTag(this.mContext.getUniqueId());
            aVar.deE.setListenerTag(this.mContext.getUniqueId());
            aVar.deF = view.findViewById(i.f.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.deB.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.deC.b((DressItemData) list.get(0));
                aVar.deC.setController(this.deA);
                if (list.size() > 2) {
                    aVar.deD.b((DressItemData) list.get(1));
                    aVar.deE.b((DressItemData) list.get(2));
                    aVar.deD.setController(this.deA);
                    aVar.deE.setController(this.deA);
                } else if (list.size() > 1) {
                    aVar.deD.b((DressItemData) list.get(1));
                    aVar.deD.setController(this.deA);
                    aVar.deE.hide();
                } else {
                    aVar.deD.hide();
                    aVar.deE.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.deF.setVisibility(8);
                } else {
                    aVar.deF.setVisibility(0);
                }
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.dez = list;
    }
}
