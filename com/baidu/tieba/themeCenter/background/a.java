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
    private List<Object> nGQ;
    d nGR;

    /* renamed from: com.baidu.tieba.themeCenter.background.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0881a {
        public View llP;
        public TextView nGS;
        public BackgroundItemView nGT;
        public BackgroundItemView nGU;
        public BackgroundItemView nGV;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.eUY = tbPageContext;
        this.nGR = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nGQ != null) {
            return this.nGQ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nGQ == null || this.nGQ.size() <= 0 || i < 0 || i >= this.nGQ.size()) {
            return null;
        }
        return this.nGQ.get(i);
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
        C0881a c0881a;
        Object item = getItem(i);
        if (view != null) {
            c0881a = (C0881a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0881a = new C0881a();
            c0881a.nGS = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0881a);
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c0881a = new C0881a();
            c0881a.nGT = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c0881a.nGU = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c0881a.nGV = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c0881a.llP = view.findViewById(R.id.divider_line);
            view.setTag(c0881a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0881a.nGS.setText(item.toString());
            } else {
                List list = (List) item;
                c0881a.nGT.d((DressItemData) list.get(0));
                c0881a.nGT.setController(this.nGR);
                if (list.size() > 2) {
                    c0881a.nGU.d((DressItemData) list.get(1));
                    c0881a.nGV.d((DressItemData) list.get(2));
                    c0881a.nGU.setController(this.nGR);
                    c0881a.nGV.setController(this.nGR);
                } else if (list.size() > 1) {
                    c0881a.nGU.d((DressItemData) list.get(1));
                    c0881a.nGU.setController(this.nGR);
                    c0881a.nGV.hide();
                } else {
                    c0881a.nGU.hide();
                    c0881a.nGV.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0881a.llP.setVisibility(8);
                } else {
                    c0881a.llP.setVisibility(0);
                }
            }
        }
        this.eUY.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nGQ = list;
    }
}
