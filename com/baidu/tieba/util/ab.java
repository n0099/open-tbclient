package com.baidu.tieba.util;

import android.location.Address;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.adp.lib.c.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f2576a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f2576a = aaVar;
    }

    @Override // com.baidu.adp.lib.c.d
    public void a(int i, String str, Address address) {
        ad adVar;
        ad adVar2;
        com.baidu.tieba.im.model.z zVar;
        com.baidu.tieba.im.model.z zVar2;
        com.baidu.tieba.im.model.z zVar3;
        com.baidu.tieba.im.model.z zVar4;
        switch (i) {
            case 0:
                if (address != null) {
                    this.f2576a.b = address.getLatitude();
                    this.f2576a.f2575a = address.getLongitude();
                    zVar = this.f2576a.c;
                    zVar.b(String.valueOf(address.getLatitude()));
                    zVar2 = this.f2576a.c;
                    zVar2.a(String.valueOf(address.getLongitude()));
                    zVar3 = this.f2576a.c;
                    zVar3.a(0);
                    zVar4 = this.f2576a.c;
                    zVar4.a();
                    return;
                }
                return;
            case 1:
            case 2:
            case 3:
                adVar2 = this.f2576a.d;
                adVar2.b();
                return;
            case 4:
            case 5:
                adVar = this.f2576a.d;
                adVar.a();
                return;
            default:
                return;
        }
    }
}
