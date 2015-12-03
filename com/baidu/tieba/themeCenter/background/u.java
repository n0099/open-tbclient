package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private v dFb;
    private DressItemData mBgItem;
    private TbPageContext<?> mContext;

    public u(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.mContext = tbPageContext;
        this.mBgItem = dressItemData;
        this.dFb = new v(this.mContext);
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
        this.dFb.d(this.mBgItem);
        this.mContext.getLayoutMode().k(this.dFb.getRootView());
        return this.dFb.getRootView();
    }
}
