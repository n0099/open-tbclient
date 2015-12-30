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
    private int bni;
    private SkinItemView.a dNK;
    private int dNL;
    private int dNM;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public SkinItemView dNN;
        public SkinItemView dNO;
        public SkinItemView dNP;
    }

    public c(TbPageContext<?> tbPageContext, SkinItemView.a aVar) {
        this.bni = 0;
        this.dNL = 0;
        this.dNM = 0;
        this.mContext = tbPageContext;
        this.dNK = aVar;
        this.bni = k.d(this.mContext.getPageActivity(), n.e.ds20);
        this.dNL = k.d(this.mContext.getPageActivity(), n.e.ds32);
        this.dNM = k.d(this.mContext.getPageActivity(), n.e.ds22);
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
    /* renamed from: nA */
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.all_theme_list_item, viewGroup, false);
            aVar = new a();
            aVar.dNN = (SkinItemView) view.findViewById(n.g.theme_view1);
            aVar.dNO = (SkinItemView) view.findViewById(n.g.theme_view2);
            aVar.dNP = (SkinItemView) view.findViewById(n.g.theme_view3);
            aVar.dNN.setOnItemClickCallback(this.dNK);
            aVar.dNO.setOnItemClickCallback(this.dNK);
            aVar.dNP.setOnItemClickCallback(this.dNK);
            aVar.dNN.setListenerTag(this.mContext.getUniqueId());
            aVar.dNO.setListenerTag(this.mContext.getUniqueId());
            aVar.dNP.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null && item.aHV() != null && item.aHV().size() > 0) {
            if (item.aHV().size() == 1) {
                aVar.dNN.a(item.aHV().get(0));
                aVar.dNN.setVisibility(0);
                aVar.dNO.setVisibility(8);
                aVar.dNP.setVisibility(8);
            } else if (item.aHV().size() == 2) {
                aVar.dNN.a(item.aHV().get(0));
                aVar.dNO.a(item.aHV().get(1));
                aVar.dNN.setVisibility(0);
                aVar.dNO.setVisibility(0);
                aVar.dNP.setVisibility(8);
            } else if (item.aHV().size() >= 3) {
                aVar.dNN.a(item.aHV().get(0));
                aVar.dNO.a(item.aHV().get(1));
                aVar.dNP.a(item.aHV().get(2));
                aVar.dNN.setVisibility(0);
                aVar.dNO.setVisibility(0);
                aVar.dNP.setVisibility(0);
            }
        }
        if (i == 0) {
            view.setPadding(this.dNL, this.bni, this.dNM, 0);
        } else {
            view.setPadding(this.dNL, 0, this.dNM, 0);
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        this.mThemeList = list;
    }
}
