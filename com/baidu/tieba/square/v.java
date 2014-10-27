package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends BaseAdapter implements com.baidu.tieba.view.s {
    private w bMA;
    private ArrayList<ak> bMB = new ArrayList<>();

    public v(Context context) {
        this.bMA = null;
        this.bMA = new w(context);
    }

    public void setData(ArrayList<ak> arrayList) {
        this.bMB = arrayList;
        this.bMA.K(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.bMB == null || this.bMB.size() <= 1) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.bMA;
    }

    @Override // com.baidu.tieba.view.s
    public void adn() {
        if (this.bMA != null) {
            this.bMA.adn();
        }
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        if (this.bMA != null) {
            this.bMA.g(this.bMA, 0, 0);
        }
    }
}
