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
    private List<Object> dgF;
    i dgG;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public TextView dgH;
        public BackgroundItemView dgI;
        public BackgroundItemView dgJ;
        public BackgroundItemView dgK;
        public View dgL;
    }

    public b(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dgG = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dgF != null) {
            return this.dgF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dgF == null || this.dgF.size() <= 0 || i < 0 || i >= this.dgF.size()) {
            return null;
        }
        return this.dgF.get(i);
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
            aVar.dgH = (TextView) view.findViewById(i.f.group_name);
            view.setTag(aVar);
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.dgI = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.dgJ = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.dgK = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.dgI.setListenerTag(this.mContext.getUniqueId());
            aVar.dgJ.setListenerTag(this.mContext.getUniqueId());
            aVar.dgK.setListenerTag(this.mContext.getUniqueId());
            aVar.dgL = view.findViewById(i.f.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.dgH.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.dgI.b((DressItemData) list.get(0));
                aVar.dgI.setController(this.dgG);
                if (list.size() > 2) {
                    aVar.dgJ.b((DressItemData) list.get(1));
                    aVar.dgK.b((DressItemData) list.get(2));
                    aVar.dgJ.setController(this.dgG);
                    aVar.dgK.setController(this.dgG);
                } else if (list.size() > 1) {
                    aVar.dgJ.b((DressItemData) list.get(1));
                    aVar.dgJ.setController(this.dgG);
                    aVar.dgK.hide();
                } else {
                    aVar.dgJ.hide();
                    aVar.dgK.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.dgL.setVisibility(8);
                } else {
                    aVar.dgL.setVisibility(0);
                }
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.dgF = list;
    }
}
