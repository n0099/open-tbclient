package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0003a {
    final /* synthetic */ d ddg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ddg = dVar;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        d.a aVar;
        d.a aVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ";" + address.getLatitude());
            this.ddg.be(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        aVar = this.ddg.dcZ;
        if (aVar != null) {
            aVar2 = this.ddg.dcZ;
            aVar2.fd(str);
        }
    }
}
