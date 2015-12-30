package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private v dMD;
    private DressItemData mBgItem;
    private TbPageContext<?> mContext;

    public u(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.mContext = tbPageContext;
        this.mBgItem = dressItemData;
        this.dMD = new v(this.mContext);
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
        this.dMD.d(this.mBgItem);
        this.mContext.getLayoutMode().k(this.dMD.getRootView());
        return this.dMD.getRootView();
    }
}
