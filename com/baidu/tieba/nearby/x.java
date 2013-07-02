package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog o;
        this.a.v = i;
        if (j != -1 && j != -2) {
            o = this.a.o();
            if (o != null) {
                this.a.j();
            }
        }
        return true;
    }
}
