package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog u;
        this.a.ah = i;
        this.a.w = j;
        if (j != -1 && j != -2 && j != -3) {
            u = this.a.u();
            if (u != null) {
                this.a.f();
            }
        }
        return true;
    }
}
