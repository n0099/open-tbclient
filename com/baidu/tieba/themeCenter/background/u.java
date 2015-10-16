package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private v dfP;
    private DressItemData mBgItem;
    private TbPageContext<?> mContext;

    public u(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.mContext = tbPageContext;
        this.mBgItem = dressItemData;
        this.dfP = new v(this.mContext);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        this.dfP.c(this.mBgItem);
        this.mContext.getLayoutMode().k(this.dfP.getRootView());
        return this.dfP.getRootView();
    }
}
