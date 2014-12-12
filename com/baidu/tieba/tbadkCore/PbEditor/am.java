package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private final int XH;
    private ap bUN;
    final /* synthetic */ PrivilegeTabContentView bUO;
    private final int count;

    public am(PrivilegeTabContentView privilegeTabContentView, Context context, int i, int i2, ap apVar) {
        this.bUO = privilegeTabContentView;
        this.count = i;
        this.XH = i2;
        this.bUN = apVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.count;
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
        return this.bUN.getView(this.XH + i, view, viewGroup);
    }
}
