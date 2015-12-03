package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0003a {
    final /* synthetic */ d dBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.dBr = dVar;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        d.a aVar;
        d.a aVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ";" + address.getLatitude());
            this.dBr.bh(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        aVar = this.dBr.dBk;
        if (aVar != null) {
            aVar2 = this.dBr.dBk;
            aVar2.fs(str);
        }
    }
}
