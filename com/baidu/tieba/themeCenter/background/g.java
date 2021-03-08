package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> eWx;
    private DressItemData mBgItem;
    private h nJK;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.eWx = tbPageContext;
        this.mBgItem = dressItemData;
        this.nJK = new h(this.eWx);
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
        this.nJK.f(this.mBgItem);
        this.eWx.getLayoutMode().onModeChanged(this.nJK.getRootView());
        return this.nJK.getRootView();
    }
}
