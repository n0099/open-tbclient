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
    private List<List<DressItemData>> dEm;
    i dEn;
    private TbPageContext<?> mContext;

    public n(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.dEn = iVar;
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(n.f.top_white_line);
            aVar.dEp = (BackgroundItemView) view.findViewById(n.f.bg_view1);
            aVar.dEq = (BackgroundItemView) view.findViewById(n.f.bg_view2);
            aVar.dEr = (BackgroundItemView) view.findViewById(n.f.bg_view3);
            aVar.dEp.setListenerTag(this.mContext.getUniqueId());
            aVar.dEq.setListenerTag(this.mContext.getUniqueId());
            aVar.dEr.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.dEp.c(item.get(0));
            aVar.dEp.setController(this.dEn);
            if (item.size() > 2) {
                aVar.dEq.c(item.get(1));
                aVar.dEr.c(item.get(2));
                aVar.dEq.setController(this.dEn);
                aVar.dEr.setController(this.dEn);
            } else if (item.size() > 1) {
                aVar.dEq.c(item.get(1));
                aVar.dEq.setController(this.dEn);
                aVar.dEr.hide();
            } else {
                aVar.dEq.hide();
                aVar.dEr.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public BackgroundItemView dEp;
        public BackgroundItemView dEq;
        public BackgroundItemView dEr;
        public View mEmptyView;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.dEm = list;
    }
}
