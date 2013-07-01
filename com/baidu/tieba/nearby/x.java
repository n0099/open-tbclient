package com.baidu.tieba.nearby;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1181a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NearbyPbActivity nearbyPbActivity) {
        this.f1181a = nearbyPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog o;
        this.f1181a.v = i;
        if (j != -1 && j != -2) {
            o = this.f1181a.o();
            if (o != null) {
                this.f1181a.j();
            }
        }
        return true;
    }
}
