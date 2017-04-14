package com.baidu.tieba.tbadkCore.location;

import android.location.Address;
import com.baidu.adp.lib.d.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0004a {
    final /* synthetic */ LocationModel fxU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocationModel locationModel) {
        this.fxU = locationModel;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0004a
    public void b(int i, String str, Address address) {
        LocationModel.a aVar;
        LocationModel.a aVar2;
        if (i == 0 && address != null) {
            BdLog.i("mGetLonAndLatCallback address:" + address.getLongitude() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + address.getLatitude());
            this.fxU.cd(String.valueOf(address.getLongitude()), String.valueOf(address.getLatitude()));
            return;
        }
        BdLog.i("mGetLonAndLatCallback error!");
        aVar = this.fxU.fxO;
        if (aVar != null) {
            aVar2 = this.fxU.fxO;
            aVar2.fB(str);
        }
    }
}
