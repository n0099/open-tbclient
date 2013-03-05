package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog n;
        this.a.w = i;
        if (j != -1 && j != -2) {
            n = this.a.n();
            if (n != null) {
                this.a.f();
            }
        }
        return true;
    }
}
