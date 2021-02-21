package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> eUY;
    private DressItemData mBgItem;
    private h nHE;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.eUY = tbPageContext;
        this.mBgItem = dressItemData;
        this.nHE = new h(this.eUY);
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
        this.nHE.f(this.mBgItem);
        this.eUY.getLayoutMode().onModeChanged(this.nHE.getRootView());
        return this.nHE.getRootView();
    }
}
