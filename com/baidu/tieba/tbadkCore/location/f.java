package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.e.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0005a {
    final /* synthetic */ d euV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.euV = dVar;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0005a
    public void b(int i, String str, Address address) {
        d.a aVar;
        d.a aVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
            this.euV.bL(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        aVar = this.euV.euO;
        if (aVar != null) {
            aVar2 = this.euV.euO;
            aVar2.fz(str);
        }
    }
}
