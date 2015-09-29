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
    private SkinItemView.a dfU;
    private TbPageContext<?> mContext;
    private List<com.baidu.tieba.themeCenter.theme.top.a> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public SkinItemView dfX;
        public SkinItemView dfY;
        public SkinItemView dfZ;
        public TextView dgX;
    }

    public c(TbPageContext<?> tbPageContext, SkinItemView.a aVar) {
        this.mContext = tbPageContext;
        this.dfU = aVar;
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
    /* renamed from: lx */
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
            aVar.dgX = (TextView) view.findViewById(i.f.category_view);
            aVar.dfX = (SkinItemView) view.findViewById(i.f.theme_view1);
            aVar.dfY = (SkinItemView) view.findViewById(i.f.theme_view2);
            aVar.dfZ = (SkinItemView) view.findViewById(i.f.theme_view3);
            aVar.dfX.setOnItemClickCallback(this.dfU);
            aVar.dfY.setOnItemClickCallback(this.dfU);
            aVar.dfZ.setOnItemClickCallback(this.dfU);
            aVar.dfX.setListenerTag(this.mContext.getUniqueId());
            aVar.dfY.setListenerTag(this.mContext.getUniqueId());
            aVar.dfZ.setListenerTag(this.mContext.getUniqueId());
            view.setTag(aVar);
        }
        if (item != null && item.azz() != null && item.azz().size() > 0) {
            aVar.dgX.setText(item.azy());
            if (item.azz().size() == 1) {
                aVar.dfX.a(item.azz().get(0));
                aVar.dfX.setVisibility(0);
                aVar.dfY.setVisibility(8);
                aVar.dfZ.setVisibility(8);
            } else if (item.azz().size() == 2) {
                aVar.dfX.a(item.azz().get(0));
                aVar.dfY.a(item.azz().get(1));
                aVar.dfX.setVisibility(0);
                aVar.dfY.setVisibility(0);
                aVar.dfZ.setVisibility(8);
            } else if (item.azz().size() >= 3) {
                aVar.dfX.a(item.azz().get(0));
                aVar.dfY.a(item.azz().get(1));
                aVar.dfZ.a(item.azz().get(2));
                aVar.dfX.setVisibility(0);
                aVar.dfY.setVisibility(0);
                aVar.dfZ.setVisibility(0);
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        this.mThemeList = list;
    }
}
