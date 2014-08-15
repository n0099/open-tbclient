package com.baidu.tieba.neighbors;

import android.location.Address;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.c.d {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        this.a.closeLoadingDialog();
        if (i == 0 && address != null) {
            this.a.a = String.valueOf(address.getLatitude());
            this.a.b = String.valueOf(address.getLongitude());
            this.a.b(true);
            return;
        }
        this.a.showToast(str);
        this.a.f();
    }
}
