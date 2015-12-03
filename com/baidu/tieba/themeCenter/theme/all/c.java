package com.baidu.tieba.themeCenter.theme.all;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private int bjr;
    private SkinItemView.a dGj;
    private int dGk;
    private int dGl;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public SkinItemView dGm;
        public SkinItemView dGn;
        public SkinItemView dGo;
    }

    public c(TbPageContext<?> tbPageContext, SkinItemView.a aVar) {
        this.bjr = 0;
        this.dGk = 0;
        this.dGl = 0;
        this.mContext = tbPageContext;
        this.dGj = aVar;
        this.bjr = k.d(this.mContext.getPageActivity(), n.d.ds20);
        this.dGk = k.d(this.mContext.getPageActivity(), n.d.ds32);
        this.dGl = k.d(this.mContext.getPageActivity(), n.d.ds22);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mThemeList != null) {
            return this.mThemeList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mY */
    public com.baidu.tieba.themeCenter.theme.top.a getItem(int i) {
        if (this.mThemeList == null || this.mThemeList.size() <= 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mThemeList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.baidu.tieba.themeCenter.theme.top.a item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.all_theme_list_item, viewGroup, false);
            aVar = new a();
            aVar.dGm = (SkinItemView) view.findViewById(n.f.theme_view1);
            aVar.dGn = (SkinItemView) view.findViewById(n.f.theme_view2);
            aVar.dGo = (SkinItemView) view.findViewById(n.f.theme_view3);
            aVar.dGm.setOnItemClickCallback(this.dGj);
            aVar.dGn.setOnItemClickCallback(this.dGj);
            aVar.dGo.setOnItemClickCallback(this.dGj);
            aVar.dGm.setListenerTag(this.mContext.getUniqueId());
            aVar.dGn.setListenerTag(this.mContext.getUniqueId());
            aVar.dGo.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null && item.aFG() != null && item.aFG().size() > 0) {
            if (item.aFG().size() == 1) {
                aVar.dGm.a(item.aFG().get(0));
                aVar.dGm.setVisibility(0);
                aVar.dGn.setVisibility(8);
                aVar.dGo.setVisibility(8);
            } else if (item.aFG().size() == 2) {
                aVar.dGm.a(item.aFG().get(0));
                aVar.dGn.a(item.aFG().get(1));
                aVar.dGm.setVisibility(0);
                aVar.dGn.setVisibility(0);
                aVar.dGo.setVisibility(8);
            } else if (item.aFG().size() >= 3) {
                aVar.dGm.a(item.aFG().get(0));
                aVar.dGn.a(item.aFG().get(1));
                aVar.dGo.a(item.aFG().get(2));
                aVar.dGm.setVisibility(0);
                aVar.dGn.setVisibility(0);
                aVar.dGo.setVisibility(0);
            }
        }
        if (i == 0) {
            view.setPadding(this.dGk, this.bjr, this.dGl, 0);
        } else {
            view.setPadding(this.dGk, 0, this.dGl, 0);
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        this.mThemeList = list;
    }
}
