package com.baidu.tieba.im.util;

import android.location.Address;
import com.baidu.tieba.im.model.RequestGroupLocModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.d.d {
    final /* synthetic */ d biY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.biY = dVar;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        g gVar;
        g gVar2;
        RequestGroupLocModel requestGroupLocModel;
        RequestGroupLocModel requestGroupLocModel2;
        RequestGroupLocModel requestGroupLocModel3;
        RequestGroupLocModel requestGroupLocModel4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.biY.biU = address.getLatitude();
                    this.biY.biT = address.getLongitude();
                    requestGroupLocModel = this.biY.biV;
                    requestGroupLocModel.setLat(String.valueOf(address.getLatitude()));
                    requestGroupLocModel2 = this.biY.biV;
                    requestGroupLocModel2.setLng(String.valueOf(address.getLongitude()));
                    requestGroupLocModel3 = this.biY.biV;
                    requestGroupLocModel3.setGroupId(0);
                    requestGroupLocModel4 = this.biY.biV;
                    requestGroupLocModel4.sendMessage();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                gVar2 = this.biY.biW;
                gVar2.Ls();
                return;
            case 4:
            case 5:
                gVar = this.biY.biW;
                gVar.Lr();
                return;
            default:
                return;
        }
    }
}
