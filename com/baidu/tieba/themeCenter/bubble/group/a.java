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
    private TbPageContext<?> eUY;
    private List<Object> nGQ;
    com.baidu.tieba.themeCenter.bubble.all.a nHU;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.group.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0882a {
        public View llP;
        public TextView nGS;
        public BubbleItemView nIc;
        public BubbleItemView nId;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eUY = tbPageContext;
        this.nHU = aVar;
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
        C0882a c0882a;
        Object item = getItem(i);
        if (view != null) {
            c0882a = (C0882a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0882a = new C0882a();
            c0882a.nGS = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0882a);
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0882a = new C0882a();
            c0882a.nIc = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0882a.nId = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c0882a.llP = view.findViewById(R.id.divider_line);
            view.setTag(c0882a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0882a.nGS.setText(item.toString());
            } else {
                List list = (List) item;
                c0882a.nIc.d((DressItemData) list.get(0));
                c0882a.nIc.setController(this.nHU);
                c0882a.nIc.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c0882a.nId.d((DressItemData) list.get(1));
                    c0882a.nId.setController(this.nHU);
                    c0882a.nId.setFromBubbleGroup(true);
                } else {
                    c0882a.nId.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0882a.llP.setVisibility(8);
                } else {
                    c0882a.llP.setVisibility(0);
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
