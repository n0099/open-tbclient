package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements AdapterView.OnItemClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Cdo cdo;
        Cdo cdo2;
        if (j == -1) {
            cdo2 = this.a.h;
            if (cdo2.b()) {
                return;
            }
            this.a.c(2);
        } else if (j == -2) {
            cdo = this.a.h;
            if (cdo.a()) {
                return;
            }
            this.a.c(1);
        }
    }
}
