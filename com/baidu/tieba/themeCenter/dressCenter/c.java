package com.baidu.tieba.themeCenter.dressCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private TbPageContext<?> mContext;
    private List<j> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public TextView Yh;
        public View aHp;
        public HeadImageView dNz;
        public View dhH;
    }

    public c(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
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
    /* renamed from: nz */
    public j getItem(int i) {
        if (this.mThemeList == null || this.mThemeList.size() <= 0 || i < 0 || i >= this.mThemeList.size()) {
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
        j item = getItem(i);
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.dressup_item_view, viewGroup, false);
            a aVar2 = new a();
            aVar2.dNz = (HeadImageView) view.findViewById(n.g.dress_icon);
            aVar2.dNz.setDefaultResource(n.f.img_default_100);
            aVar2.dNz.setDefaultBgResource(n.d.cp_bg_line_c);
            aVar2.Yh = (TextView) view.findViewById(n.g.dress_desc_view);
            aVar2.dhH = view.findViewById(n.g.tip_view);
            aVar2.aHp = view.findViewById(n.g.divider_line);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        if (item != null) {
            aVar.dNz.d(item.getIconUrl(), 10, false);
            aVar.Yh.setText(item.getName());
            if (item.getUpdateTime() - com.baidu.tbadk.core.sharedPref.b.tJ().getLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                aVar.dhH.setVisibility(0);
            } else {
                aVar.dhH.setVisibility(4);
            }
            if (i == getCount() - 1) {
                aVar.aHp.setVisibility(8);
            } else {
                aVar.aHp.setVisibility(0);
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<j> list) {
        this.mThemeList = list;
    }
}
