package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements AdapterView.OnItemClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        dh dhVar;
        dh dhVar2;
        if (j == -1) {
            dhVar2 = this.a.h;
            if (dhVar2.b()) {
                return;
            }
            this.a.c(2);
        } else if (j == -2) {
            dhVar = this.a.h;
            if (dhVar.a()) {
                return;
            }
            this.a.c(1);
        }
    }
}
