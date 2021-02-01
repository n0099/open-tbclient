package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eUY;
    private List<Object> nGq;
    d nGr;

    /* renamed from: com.baidu.tieba.themeCenter.background.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0879a {
        public View llB;
        public TextView nGs;
        public BackgroundItemView nGt;
        public BackgroundItemView nGu;
        public BackgroundItemView nGv;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.eUY = tbPageContext;
        this.nGr = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGq != null) {
            return this.nGq.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nGq == null || this.nGq.size() <= 0 || i < 0 || i >= this.nGq.size()) {
            return null;
        }
        return this.nGq.get(i);
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
        C0879a c0879a;
        Object item = getItem(i);
        if (view != null) {
            c0879a = (C0879a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0879a = new C0879a();
            c0879a.nGs = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0879a);
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c0879a = new C0879a();
            c0879a.nGt = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c0879a.nGu = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c0879a.nGv = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c0879a.llB = view.findViewById(R.id.divider_line);
            view.setTag(c0879a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0879a.nGs.setText(item.toString());
            } else {
                List list = (List) item;
                c0879a.nGt.d((DressItemData) list.get(0));
                c0879a.nGt.setController(this.nGr);
                if (list.size() > 2) {
                    c0879a.nGu.d((DressItemData) list.get(1));
                    c0879a.nGv.d((DressItemData) list.get(2));
                    c0879a.nGu.setController(this.nGr);
                    c0879a.nGv.setController(this.nGr);
                } else if (list.size() > 1) {
                    c0879a.nGu.d((DressItemData) list.get(1));
                    c0879a.nGu.setController(this.nGr);
                    c0879a.nGv.hide();
                } else {
                    c0879a.nGu.hide();
                    c0879a.nGv.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0879a.llB.setVisibility(8);
                } else {
                    c0879a.llB.setVisibility(0);
                }
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nGq = list;
    }
}
