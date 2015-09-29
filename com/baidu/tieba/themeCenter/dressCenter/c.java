package com.baidu.tieba.themeCenter.dressCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private TbPageContext<?> mContext;
    private List<j> mThemeList;

    /* loaded from: classes.dex */
    public static class a {
        public TextView WM;
        public View aDN;
        public View cBv;
        public HeadImageView dfJ;
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
    /* renamed from: lw */
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.dressup_item_view, viewGroup, false);
            a aVar2 = new a();
            aVar2.dfJ = (HeadImageView) view.findViewById(i.f.dress_icon);
            aVar2.dfJ.setDefaultResource(i.e.img_default_100);
            aVar2.dfJ.setDefaultBgResource(i.c.cp_bg_line_c);
            aVar2.WM = (TextView) view.findViewById(i.f.dress_desc_view);
            aVar2.cBv = view.findViewById(i.f.tip_view);
            aVar2.aDN = view.findViewById(i.f.divider_line);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        if (item != null) {
            aVar.dfJ.d(item.getIconUrl(), 10, false);
            aVar.WM.setText(item.getName());
            if (item.getUpdateTime() - com.baidu.tbadk.core.sharedPref.b.tu().getLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                aVar.cBv.setVisibility(0);
            } else {
                aVar.cBv.setVisibility(4);
            }
            if (i == getCount() - 1) {
                aVar.aDN.setVisibility(8);
            } else {
                aVar.aDN.setVisibility(0);
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<j> list) {
        this.mThemeList = list;
    }
}
