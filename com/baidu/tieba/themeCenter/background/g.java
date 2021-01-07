package com.baidu.tieba.themeCenter.background;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes9.dex */
public class g extends BaseAdapter {
    private TbPageContext<?> eXu;
    private DressItemData mBgItem;
    private h nBY;

    public g(TbPageContext<?> tbPageContext, DressItemData dressItemData) {
        this.eXu = tbPageContext;
        this.mBgItem = dressItemData;
        this.nBY = new h(this.eXu);
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
        this.nBY.f(this.mBgItem);
        this.eXu.getLayoutMode().onModeChanged(this.nBY.getRootView());
        return this.nBY.getRootView();
    }
}
