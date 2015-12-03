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
        public TextView XE;
        public View aFP;
        public HeadImageView dFX;
        public View dca;
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
    /* renamed from: mX */
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.dressup_item_view, viewGroup, false);
            a aVar2 = new a();
            aVar2.dFX = (HeadImageView) view.findViewById(n.f.dress_icon);
            aVar2.dFX.setDefaultResource(n.e.img_default_100);
            aVar2.dFX.setDefaultBgResource(n.c.cp_bg_line_c);
            aVar2.XE = (TextView) view.findViewById(n.f.dress_desc_view);
            aVar2.dca = view.findViewById(n.f.tip_view);
            aVar2.aFP = view.findViewById(n.f.divider_line);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        if (item != null) {
            aVar.dFX.d(item.getIconUrl(), 10, false);
            aVar.XE.setText(item.getName());
            if (item.getUpdateTime() - com.baidu.tbadk.core.sharedPref.b.tZ().getLong("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                aVar.dca.setVisibility(0);
            } else {
                aVar.dca.setVisibility(4);
            }
            if (i == getCount() - 1) {
                aVar.aFP.setVisibility(8);
            } else {
                aVar.aFP.setVisibility(0);
            }
        }
        this.mContext.getLayoutMode().k(view);
        return view;
    }

    public void setData(List<j> list) {
        this.mThemeList = list;
    }
}
