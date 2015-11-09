package com.baidu.tieba.themeCenter.theme.top;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private SkinItemView.a dia;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public SkinItemView did;
        public SkinItemView die;
        public SkinItemView dif;
        public TextView djd;
    }

    public c(TbPageContext<?> tbPageContext, SkinItemView.a aVar) {
        this.mContext = tbPageContext;
        this.dia = aVar;
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
    /* renamed from: lN */
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.category_theme_list_item, viewGroup, false);
            aVar = new a();
            aVar.djd = (TextView) view.findViewById(i.f.category_view);
            aVar.did = (SkinItemView) view.findViewById(i.f.theme_view1);
            aVar.die = (SkinItemView) view.findViewById(i.f.theme_view2);
            aVar.dif = (SkinItemView) view.findViewById(i.f.theme_view3);
            aVar.did.setOnItemClickCallback(this.dia);
            aVar.die.setOnItemClickCallback(this.dia);
            aVar.dif.setOnItemClickCallback(this.dia);
            aVar.did.setListenerTag(this.mContext.getUniqueId());
            aVar.die.setListenerTag(this.mContext.getUniqueId());
            aVar.dif.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null && item.aAv() != null && item.aAv().size() > 0) {
            aVar.djd.setText(item.aAu());
            if (item.aAv().size() == 1) {
                aVar.did.a(item.aAv().get(0));
                aVar.did.setVisibility(0);
                aVar.die.setVisibility(8);
                aVar.dif.setVisibility(8);
            } else if (item.aAv().size() == 2) {
                aVar.did.a(item.aAv().get(0));
                aVar.die.a(item.aAv().get(1));
                aVar.did.setVisibility(0);
                aVar.die.setVisibility(0);
                aVar.dif.setVisibility(8);
            } else if (item.aAv().size() >= 3) {
                aVar.did.a(item.aAv().get(0));
                aVar.die.a(item.aAv().get(1));
                aVar.dif.a(item.aAv().get(2));
                aVar.did.setVisibility(0);
                aVar.die.setVisibility(0);
                aVar.dif.setVisibility(0);
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        this.mThemeList = list;
    }
}
