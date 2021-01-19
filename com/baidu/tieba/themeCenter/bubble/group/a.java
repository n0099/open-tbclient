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
    private TbPageContext<?> eSJ;
    private List<Object> nwG;
    com.baidu.tieba.themeCenter.bubble.all.a nxK;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.group.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0877a {
        public View ldy;
        public TextView nwI;
        public BubbleItemView nxS;
        public BubbleItemView nxT;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eSJ = tbPageContext;
        this.nxK = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nwG != null) {
            return this.nwG.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nwG == null || this.nwG.size() <= 0 || i < 0 || i >= this.nwG.size()) {
            return null;
        }
        return this.nwG.get(i);
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
        C0877a c0877a;
        Object item = getItem(i);
        if (view != null) {
            c0877a = (C0877a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0877a = new C0877a();
            c0877a.nwI = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0877a);
        } else {
            view = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0877a = new C0877a();
            c0877a.nxS = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0877a.nxT = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c0877a.ldy = view.findViewById(R.id.divider_line);
            view.setTag(c0877a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0877a.nwI.setText(item.toString());
            } else {
                List list = (List) item;
                c0877a.nxS.d((DressItemData) list.get(0));
                c0877a.nxS.setController(this.nxK);
                c0877a.nxS.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c0877a.nxT.d((DressItemData) list.get(1));
                    c0877a.nxT.setController(this.nxK);
                    c0877a.nxT.setFromBubbleGroup(true);
                } else {
                    c0877a.nxT.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0877a.ldy.setVisibility(8);
                } else {
                    c0877a.ldy.setVisibility(0);
                }
            }
        }
        this.eSJ.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void setData(List<Object> list) {
        this.nwG = list;
    }
}
