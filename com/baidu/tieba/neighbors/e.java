package com.baidu.tieba.neighbors;

import android.location.Address;
/* loaded from: classes.dex */
class e implements com.baidu.adp.lib.d.d {
    final /* synthetic */ NeighborsActivity btV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NeighborsActivity neighborsActivity) {
        this.btV = neighborsActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        this.btV.closeLoadingDialog();
        if (i == 0 && address != null) {
            this.btV.btE = String.valueOf(address.getLatitude());
            this.btV.btF = String.valueOf(address.getLongitude());
            this.btV.dT(true);
            return;
        }
        this.btV.VN();
    }
}
