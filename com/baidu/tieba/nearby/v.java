package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1179a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NearbyPbActivity nearbyPbActivity) {
        this.f1179a = nearbyPbActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ae aeVar;
        ae aeVar2;
        if (j != 0) {
            if (j == -1) {
                aeVar2 = this.f1179a.l;
                if (aeVar2.f()) {
                    return;
                }
                this.f1179a.q();
            } else if (j == -2) {
                aeVar = this.f1179a.l;
                if (aeVar.e()) {
                    return;
                }
                this.f1179a.p();
            }
        }
    }
}
