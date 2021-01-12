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
    private TbPageContext<?> eSJ;
    private List<Object> nwF;
    d nwG;

    /* renamed from: com.baidu.tieba.themeCenter.background.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0876a {
        public View ldy;
        public TextView nwH;
        public BackgroundItemView nwI;
        public BackgroundItemView nwJ;
        public BackgroundItemView nwK;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.eSJ = tbPageContext;
        this.nwG = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nwF != null) {
            return this.nwF.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nwF == null || this.nwF.size() <= 0 || i < 0 || i >= this.nwF.size()) {
            return null;
        }
        return this.nwF.get(i);
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
        C0876a c0876a;
        Object item = getItem(i);
        if (view != null) {
            c0876a = (C0876a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0876a = new C0876a();
            c0876a.nwH = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0876a);
        } else {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c0876a = new C0876a();
            c0876a.nwI = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c0876a.nwJ = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c0876a.nwK = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c0876a.ldy = view.findViewById(R.id.divider_line);
            view.setTag(c0876a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0876a.nwH.setText(item.toString());
            } else {
                List list = (List) item;
                c0876a.nwI.d((DressItemData) list.get(0));
                c0876a.nwI.setController(this.nwG);
                if (list.size() > 2) {
                    c0876a.nwJ.d((DressItemData) list.get(1));
                    c0876a.nwK.d((DressItemData) list.get(2));
                    c0876a.nwJ.setController(this.nwG);
                    c0876a.nwK.setController(this.nwG);
                } else if (list.size() > 1) {
                    c0876a.nwJ.d((DressItemData) list.get(1));
                    c0876a.nwJ.setController(this.nwG);
                    c0876a.nwK.hide();
                } else {
                    c0876a.nwJ.hide();
                    c0876a.nwK.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0876a.ldy.setVisibility(8);
                } else {
                    c0876a.ldy.setVisibility(0);
                }
            }
        }
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nwF = list;
    }
}
