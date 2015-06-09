package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.d.d {
    final /* synthetic */ e ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.ctN = eVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        j jVar;
        j jVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ";" + address.getLatitude());
            this.ctN.bb(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        jVar = this.ctN.ctG;
        if (jVar != null) {
            jVar2 = this.ctN.ctG;
            jVar2.gh(str);
        }
    }
}
