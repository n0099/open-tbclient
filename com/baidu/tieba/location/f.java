package com.baidu.tieba.location;

import android.location.Address;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.d.d {
    final /* synthetic */ d blV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.blV = dVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        i iVar;
        i iVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ";" + address.getLatitude());
            this.blV.ax(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        iVar = this.blV.blO;
        if (iVar != null) {
            iVar2 = this.blV.blO;
            iVar2.eY(str);
        }
    }
}
