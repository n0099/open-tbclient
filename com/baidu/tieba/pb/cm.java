package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements AdapterView.OnItemClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        dm dmVar;
        dm dmVar2;
        if (j == -1) {
            dmVar2 = this.a.h;
            if (dmVar2.b()) {
                return;
            }
            this.a.c(2);
        } else if (j == -2) {
            dmVar = this.a.h;
            if (dmVar.a()) {
                return;
            }
            this.a.c(1);
        }
    }
}
