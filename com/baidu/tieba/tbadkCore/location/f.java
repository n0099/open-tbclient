package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.d.d {
    final /* synthetic */ d bYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.bYA = dVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        i iVar;
        i iVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ";" + address.getLatitude());
            this.bYA.aO(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        iVar = this.bYA.bYt;
        if (iVar != null) {
            iVar2 = this.bYA.bYt;
            iVar2.ft(str);
        }
    }
}
