package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends BaseAdapter implements com.baidu.tieba.view.s {
    private w bMP;
    private ArrayList<ak> bMQ = new ArrayList<>();

    public v(Context context) {
        this.bMP = null;
        this.bMP = new w(context);
    }

    public void setData(ArrayList<ak> arrayList) {
        this.bMQ = arrayList;
        this.bMP.L(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.bMQ == null || this.bMQ.size() <= 1) ? 0 : 1;
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
        return this.bMP;
    }

    @Override // com.baidu.tieba.view.s
    public void adq() {
        if (this.bMP != null) {
            this.bMP.adq();
        }
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        if (this.bMP != null) {
            this.bMP.g(this.bMP, 0, 0);
        }
    }
}
