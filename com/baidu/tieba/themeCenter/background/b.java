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
    private List<Object> deZ;
    i dfa;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public TextView dfb;
        public BackgroundItemView dfc;
        public BackgroundItemView dfd;
        public BackgroundItemView dfe;
        public View dff;
    }

    public b(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dfa = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.deZ != null) {
            return this.deZ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.deZ == null || this.deZ.size() <= 0 || i < 0 || i >= this.deZ.size()) {
            return null;
        }
        return this.deZ.get(i);
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
            aVar.dfb = (TextView) view.findViewById(i.f.group_name);
            view.setTag(aVar);
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.dfc = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.dfd = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.dfe = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.dfc.setListenerTag(this.mContext.getUniqueId());
            aVar.dfd.setListenerTag(this.mContext.getUniqueId());
            aVar.dfe.setListenerTag(this.mContext.getUniqueId());
            aVar.dff = view.findViewById(i.f.divider_line);
            view.setTag(aVar);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                aVar.dfb.setText(item.toString());
            } else {
                List list = (List) item;
                aVar.dfc.b((DressItemData) list.get(0));
                aVar.dfc.setController(this.dfa);
                if (list.size() > 2) {
                    aVar.dfd.b((DressItemData) list.get(1));
                    aVar.dfe.b((DressItemData) list.get(2));
                    aVar.dfd.setController(this.dfa);
                    aVar.dfe.setController(this.dfa);
                } else if (list.size() > 1) {
                    aVar.dfd.b((DressItemData) list.get(1));
                    aVar.dfd.setController(this.dfa);
                    aVar.dfe.hide();
                } else {
                    aVar.dfd.hide();
                    aVar.dfe.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    aVar.dff.setVisibility(8);
                } else {
                    aVar.dff.setVisibility(0);
                }
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.deZ = list;
    }
}
