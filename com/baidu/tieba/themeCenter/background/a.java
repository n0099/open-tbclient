package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eWx;
    private List<Object> nIW;
    d nIX;

    /* renamed from: com.baidu.tieba.themeCenter.background.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0887a {
        public View lnS;
        public TextView nIY;
        public BackgroundItemView nIZ;
        public BackgroundItemView nJa;
        public BackgroundItemView nJb;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.eWx = tbPageContext;
        this.nIX = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nIW != null) {
            return this.nIW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nIW == null || this.nIW.size() <= 0 || i < 0 || i >= this.nIW.size()) {
            return null;
        }
        return this.nIW.get(i);
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
        C0887a c0887a;
        Object item = getItem(i);
        if (view != null) {
            c0887a = (C0887a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0887a = new C0887a();
            c0887a.nIY = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0887a);
        } else {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c0887a = new C0887a();
            c0887a.nIZ = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c0887a.nJa = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c0887a.nJb = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c0887a.lnS = view.findViewById(R.id.divider_line);
            view.setTag(c0887a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0887a.nIY.setText(item.toString());
            } else {
                List list = (List) item;
                c0887a.nIZ.d((DressItemData) list.get(0));
                c0887a.nIZ.setController(this.nIX);
                if (list.size() > 2) {
                    c0887a.nJa.d((DressItemData) list.get(1));
                    c0887a.nJb.d((DressItemData) list.get(2));
                    c0887a.nJa.setController(this.nIX);
                    c0887a.nJb.setController(this.nIX);
                } else if (list.size() > 1) {
                    c0887a.nJa.d((DressItemData) list.get(1));
                    c0887a.nJa.setController(this.nIX);
                    c0887a.nJb.hide();
                } else {
                    c0887a.nJa.hide();
                    c0887a.nJb.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0887a.lnS.setVisibility(8);
                } else {
                    c0887a.lnS.setVisibility(0);
                }
            }
        }
        this.eWx.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nIW = list;
    }
}
