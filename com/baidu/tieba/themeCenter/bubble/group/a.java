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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private TbPageContext<?> eWx;
    private List<Object> nIW;
    com.baidu.tieba.themeCenter.bubble.all.a nKa;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.group.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0888a {
        public View lnS;
        public TextView nIY;
        public BubbleItemView nKi;
        public BubbleItemView nKj;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eWx = tbPageContext;
        this.nKa = aVar;
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
        C0888a c0888a;
        Object item = getItem(i);
        if (view != null) {
            c0888a = (C0888a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0888a = new C0888a();
            c0888a.nIY = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0888a);
        } else {
            view = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0888a = new C0888a();
            c0888a.nKi = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0888a.nKj = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c0888a.lnS = view.findViewById(R.id.divider_line);
            view.setTag(c0888a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0888a.nIY.setText(item.toString());
            } else {
                List list = (List) item;
                c0888a.nKi.d((DressItemData) list.get(0));
                c0888a.nKi.setController(this.nKa);
                c0888a.nKi.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c0888a.nKj.d((DressItemData) list.get(1));
                    c0888a.nKj.setController(this.nKa);
                    c0888a.nKj.setFromBubbleGroup(true);
                } else {
                    c0888a.nKj.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0888a.lnS.setVisibility(8);
                } else {
                    c0888a.lnS.setVisibility(0);
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
