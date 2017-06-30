package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0004a {
    final /* synthetic */ LocationModel fOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocationModel locationModel) {
        this.fOq = locationModel;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
    public void b(int i, String str, Address address) {
        LocationModel.a aVar;
        LocationModel.a aVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
            this.fOq.cg(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        aVar = this.fOq.fOk;
        if (aVar != null) {
            aVar2 = this.fOq.fOk;
            aVar2.fQ(str);
        }
    }
}
