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
    private List<Object> nGq;
    com.baidu.tieba.themeCenter.bubble.all.a nHu;

    /* renamed from: com.baidu.tieba.themeCenter.bubble.group.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0880a {
        public View llB;
        public TextView nGs;
        public BubbleItemView nHC;
        public BubbleItemView nHD;
    }

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.eUY = tbPageContext;
        this.nHu = aVar;
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
        C0880a c0880a;
        Object item = getItem(i);
        if (view != null) {
            c0880a = (C0880a) view.getTag();
        } else if (getItemViewType(i) == 0) {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.background_group_header, viewGroup, false);
            c0880a = new C0880a();
            c0880a.nGs = (TextView) view.findViewById(R.id.group_name);
            view.setTag(c0880a);
        } else {
            view = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.bubble_row, viewGroup, false);
            c0880a = new C0880a();
            c0880a.nHC = (BubbleItemView) view.findViewById(R.id.bg_view1);
            c0880a.nHD = (BubbleItemView) view.findViewById(R.id.bg_view2);
            c0880a.llB = view.findViewById(R.id.divider_line);
            view.setTag(c0880a);
        }
        if (item != null) {
            if (getItemViewType(i) == 0) {
                c0880a.nGs.setText(item.toString());
            } else {
                List list = (List) item;
                c0880a.nHC.d((DressItemData) list.get(0));
                c0880a.nHC.setController(this.nHu);
                c0880a.nHC.setFromBubbleGroup(true);
                if (list.size() > 1) {
                    c0880a.nHD.d((DressItemData) list.get(1));
                    c0880a.nHD.setController(this.nHu);
                    c0880a.nHD.setFromBubbleGroup(true);
                } else {
                    c0880a.nHD.hide();
                }
                if (getItem(i + 1) instanceof List) {
                    c0880a.llB.setVisibility(8);
                } else {
                    c0880a.llB.setVisibility(0);
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
