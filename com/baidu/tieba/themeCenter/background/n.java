package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    i deA;
    private List<List<DressItemData>> dez;
    private TbPageContext<?> mContext;

    public n(TbPageContext<?> tbPageContext, i iVar) {
        this.mContext = tbPageContext;
        this.deA = iVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dez != null) {
            return this.dez.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lv */
    public List<DressItemData> getItem(int i) {
        if (this.dez == null || this.dez.size() <= 0 || i < 0 || i >= this.dez.size()) {
            return null;
        }
        return this.dez.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.background_row, viewGroup, false);
            aVar = new a();
            aVar.mEmptyView = view.findViewById(i.f.top_white_line);
            aVar.deC = (BackgroundItemView) view.findViewById(i.f.bg_view1);
            aVar.deD = (BackgroundItemView) view.findViewById(i.f.bg_view2);
            aVar.deE = (BackgroundItemView) view.findViewById(i.f.bg_view3);
            aVar.deC.setListenerTag(this.mContext.getUniqueId());
            aVar.deD.setListenerTag(this.mContext.getUniqueId());
            aVar.deE.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null) {
            if (i == 0) {
                aVar.mEmptyView.setVisibility(0);
            } else {
                aVar.mEmptyView.setVisibility(8);
            }
            aVar.deC.b(item.get(0));
            aVar.deC.setController(this.deA);
            if (item.size() > 2) {
                aVar.deD.b(item.get(1));
                aVar.deE.b(item.get(2));
                aVar.deD.setController(this.deA);
                aVar.deE.setController(this.deA);
            } else if (item.size() > 1) {
                aVar.deD.b(item.get(1));
                aVar.deD.setController(this.deA);
                aVar.deE.hide();
            } else {
                aVar.deD.hide();
                aVar.deE.hide();
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public BackgroundItemView deC;
        public BackgroundItemView deD;
        public BackgroundItemView deE;
        public View mEmptyView;

        public a() {
        }
    }

    public void setData(List<List<DressItemData>> list) {
        this.dez = list;
    }
}
