package com.baidu.tieba.themeCenter.theme.all;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private int bci;
    private SkinItemView.a dgu;
    private int dgv;
    private int dgw;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public SkinItemView dgx;
        public SkinItemView dgy;
        public SkinItemView dgz;
    }

    public c(TbPageContext<?> tbPageContext, SkinItemView.a aVar) {
        this.bci = 0;
        this.dgv = 0;
        this.dgw = 0;
        this.mContext = tbPageContext;
        this.dgu = aVar;
        this.bci = k.d(this.mContext.getPageActivity(), i.d.ds20);
        this.dgv = k.d(this.mContext.getPageActivity(), i.d.ds32);
        this.dgw = k.d(this.mContext.getPageActivity(), i.d.ds22);
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
    /* renamed from: lz */
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.all_theme_list_item, viewGroup, false);
            aVar = new a();
            aVar.dgx = (SkinItemView) view.findViewById(i.f.theme_view1);
            aVar.dgy = (SkinItemView) view.findViewById(i.f.theme_view2);
            aVar.dgz = (SkinItemView) view.findViewById(i.f.theme_view3);
            aVar.dgx.setOnItemClickCallback(this.dgu);
            aVar.dgy.setOnItemClickCallback(this.dgu);
            aVar.dgz.setOnItemClickCallback(this.dgu);
            aVar.dgx.setListenerTag(this.mContext.getUniqueId());
            aVar.dgy.setListenerTag(this.mContext.getUniqueId());
            aVar.dgz.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null && item.azJ() != null && item.azJ().size() > 0) {
            if (item.azJ().size() == 1) {
                aVar.dgx.a(item.azJ().get(0));
                aVar.dgx.setVisibility(0);
                aVar.dgy.setVisibility(8);
                aVar.dgz.setVisibility(8);
            } else if (item.azJ().size() == 2) {
                aVar.dgx.a(item.azJ().get(0));
                aVar.dgy.a(item.azJ().get(1));
                aVar.dgx.setVisibility(0);
                aVar.dgy.setVisibility(0);
                aVar.dgz.setVisibility(8);
            } else if (item.azJ().size() >= 3) {
                aVar.dgx.a(item.azJ().get(0));
                aVar.dgy.a(item.azJ().get(1));
                aVar.dgz.a(item.azJ().get(2));
                aVar.dgx.setVisibility(0);
                aVar.dgy.setVisibility(0);
                aVar.dgz.setVisibility(0);
            }
        }
        if (i == 0) {
            view.setPadding(this.dgv, this.bci, this.dgw, 0);
        } else {
            view.setPadding(this.dgv, 0, this.dgw, 0);
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        this.mThemeList = list;
    }
}
