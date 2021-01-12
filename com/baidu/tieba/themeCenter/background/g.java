package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> eSJ;
    private DressItemData mBgItem;
    private h nxt;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.eSJ = tbPageContext;
        this.mBgItem = dressItemData;
        this.nxt = new h(this.eSJ);
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
        this.nxt.f(this.mBgItem);
        this.eSJ.getLayoutMode().onModeChanged(this.nxt.getRootView());
        return this.nxt.getRootView();
    }
}
