package com.baidu.tieba.themeCenter.bubble.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.all.BubbleItemView;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private List<List<DressItemData>> dEm;
    com.baidu.tieba.themeCenter.bubble.all.a dFt;
    private TbPageContext<?> mContext;

    /* loaded from: classes.dex */
    public static class a {
        public BubbleItemView dFA;
        public BubbleItemView dFB;
        public View mEmptyView;
    }

    public d(TbPageContext<?> tbPageContext, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mContext = tbPageContext;
        this.dFt = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dEm != null) {
            return this.dEm.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mV */
    public List<DressItemData> getItem(int i) {
        if (this.dEm == null || this.dEm.size() <= 0 || i < 0 || i >= this.dEm.size()) {
            return null;
        }
        return this.dEm.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.bubble_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(n.f.top_white_line);
            aVar.dFA = (BubbleItemView) view.findViewById(n.f.bg_view1);
            aVar.dFB = (BubbleItemView) view.findViewById(n.f.bg_view2);
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dFA.c(item.get(0));
            aVar.dFA.setController(this.dFt);
            if (item.size() > 1) {
                aVar.dFB.c(item.get(1));
                aVar.dFB.setController(this.dFt);
            } else {
                aVar.dFB.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<List<DressItemData>> list) {
        this.dEm = list;
    }
}
