package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        af afVar;
        af afVar2;
        if (j != 0) {
            if (j == -1) {
                afVar2 = this.a.m;
                if (afVar2.f()) {
                    return;
                }
                this.a.p();
            } else if (j == -2) {
                afVar = this.a.m;
                if (afVar.e()) {
                    return;
                }
                this.a.o();
            }
        }
    }
}
