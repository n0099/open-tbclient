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
    private TbPageContext<?> eXu;
    private List<Object> nBk;
    d nBl;

    /* renamed from: com.baidu.tieba.themeCenter.background.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0893a {
        public View lie;
        public TextView nBm;
        public BackgroundItemView nBn;
        public BackgroundItemView nBo;
        public BackgroundItemView nBp;
    }

    public a(TbPageContext<?> tbPageContext, d dVar) {
        this.eXu = tbPageContext;
        this.nBl = dVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nBk != null) {
            return this.nBk.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nBk == null || this.nBk.size() <= 0 || i < 0 || i >= this.nBk.size()) {
            return null;
        }
        return this.nBk.get(i);
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
        C0893a c0893a;
        Object item = getItem(i);
        if (view != null) {
            c0893a = (C0893a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0893a = new C0893a();
            c0893a.nBm = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0893a);
        } else {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_row, viewGroup, false);
            c0893a = new C0893a();
            c0893a.nBn = (BackgroundItemView) view.findViewById(R.id.bg_view1);
            c0893a.nBo = (BackgroundItemView) view.findViewById(R.id.bg_view2);
            c0893a.nBp = (BackgroundItemView) view.findViewById(R.id.bg_view3);
            c0893a.lie = view.findViewById(R.id.divider_line);
            view.setTag(c0893a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0893a.nBm.setText(item.toString());
            } else {
                List list = (List) item;
                c0893a.nBn.d((DressItemData) list.get(0));
                c0893a.nBn.setController(this.nBl);
                if (list.size() > 2) {
                    c0893a.nBo.d((DressItemData) list.get(1));
                    c0893a.nBp.d((DressItemData) list.get(2));
                    c0893a.nBo.setController(this.nBl);
                    c0893a.nBp.setController(this.nBl);
                } else if (list.size() > 1) {
                    c0893a.nBo.d((DressItemData) list.get(1));
                    c0893a.nBo.setController(this.nBl);
                    c0893a.nBp.hide();
                } else {
                    c0893a.nBo.hide();
                    c0893a.nBp.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0893a.lie.setVisibility(8);
                } else {
                    c0893a.lie.setVisibility(0);
                }
            }
        }
        this.eXu.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nBk = list;
    }
}
