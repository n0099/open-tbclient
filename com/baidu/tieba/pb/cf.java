package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements AdapterView.OnItemClickListener {
    final /* synthetic */ SubPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(SubPbActivity subPbActivity) {
        this.a = subPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        df dfVar;
        df dfVar2;
        if (j == -1) {
            dfVar2 = this.a.g;
            if (dfVar2.b()) {
                return;
            }
            this.a.a(2);
        } else if (j == -2) {
            dfVar = this.a.g;
            if (dfVar.a()) {
                return;
            }
            this.a.a(1);
        }
    }
}
