package com.baidu.tieba.neighbors;

import android.location.Address;
/* loaded from: classes.dex */
class e implements com.baidu.adp.lib.d.d {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NeighborsActivity neighborsActivity) {
        this.buj = neighborsActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        this.buj.closeLoadingDialog();
        if (i == 0 && address != null) {
            this.buj.btS = String.valueOf(address.getLatitude());
            this.buj.btT = String.valueOf(address.getLongitude());
            this.buj.dT(true);
            return;
        }
        this.buj.VQ();
    }
}
