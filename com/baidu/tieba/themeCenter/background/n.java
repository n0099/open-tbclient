package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private List<List<DressItemData>> dLQ;
    i dLR;
    private TbPageContext<?> mContext;

    public n(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dLR = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dLQ != null) {
            return this.dLQ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nx */
    public List<DressItemData> getItem(int i) {
        if (this.dLQ == null || this.dLQ.size() <= 0 || i < 0 || i >= this.dLQ.size()) {
            return null;
        }
        return this.dLQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        List<DressItemData> item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(n.g.top_white_line);
            aVar.dLT = (BackgroundItemView) view.findViewById(n.g.bg_view1);
            aVar.dLU = (BackgroundItemView) view.findViewById(n.g.bg_view2);
            aVar.dLV = (BackgroundItemView) view.findViewById(n.g.bg_view3);
            aVar.dLT.setListenerTag(this.mContext.getUniqueId());
            aVar.dLU.setListenerTag(this.mContext.getUniqueId());
            aVar.dLV.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dLT.c(item.get(0));
            aVar.dLT.setController(this.dLR);
            if (item.size() > 2) {
                aVar.dLU.c(item.get(1));
                aVar.dLV.c(item.get(2));
                aVar.dLU.setController(this.dLR);
                aVar.dLV.setController(this.dLR);
            } else if (item.size() > 1) {
                aVar.dLU.c(item.get(1));
                aVar.dLU.setController(this.dLR);
                aVar.dLV.hide();
            } else {
                aVar.dLU.hide();
                aVar.dLV.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public BackgroundItemView dLT;
        public BackgroundItemView dLU;
        public BackgroundItemView dLV;
        public View mEmptyView;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.dLQ = list;
    }
}
