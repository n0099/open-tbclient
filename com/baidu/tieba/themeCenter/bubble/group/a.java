package com.baidu.tieba.themeCenter.bubble.group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eXu;
    private List<Object> nBk;
    com.baidu.tieba.themeCenter.bubble.all.a nCo;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.group.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0894a {
        public View lie;
        public TextView nBm;
        public BubbleItemView nCw;
        public BubbleItemView nCx;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eXu = tbPageContext;
        this.nCo = aVar;
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
        C0894a c0894a;
        Object item = getItem(i);
        if (view != null) {
            c0894a = (C0894a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0894a = new C0894a();
            c0894a.nBm = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0894a);
        } else {
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0894a = new C0894a();
            c0894a.nCw = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0894a.nCx = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c0894a.lie = view.findViewById(R.id.divider_line);
            view.setTag(c0894a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0894a.nBm.setText(item.toString());
            } else {
                List list = (List) item;
                c0894a.nCw.d((DressItemData) list.get(0));
                c0894a.nCw.setController(this.nCo);
                c0894a.nCw.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c0894a.nCx.d((DressItemData) list.get(1));
                    c0894a.nCx.setController(this.nCo);
                    c0894a.nCx.setFromBubbleGroup(true);
                } else {
                    c0894a.nCx.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0894a.lie.setVisibility(8);
                } else {
                    c0894a.lie.setVisibility(0);
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
