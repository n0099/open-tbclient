package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.a.g {
    final /* synthetic */ MoreDiscoveryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MoreDiscoveryActivity moreDiscoveryActivity) {
        this.a = moreDiscoveryActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ah ahVar;
        ah ahVar2;
        ae aeVar;
        boolean unused = MoreDiscoveryActivity.e = true;
        ahVar = this.a.b;
        if (ahVar != null) {
            ahVar2 = this.a.b;
            aeVar = this.a.c;
            ahVar2.a(aeVar, ((Boolean) obj).booleanValue());
        }
    }
}
