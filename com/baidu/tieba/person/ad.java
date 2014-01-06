package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MoreDiscoveryActivity a;

    private ad(MoreDiscoveryActivity moreDiscoveryActivity) {
        this.a = moreDiscoveryActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(MoreDiscoveryActivity moreDiscoveryActivity, ac acVar) {
        this(moreDiscoveryActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && oVar.u() == -124) {
            this.a.a(oVar);
        }
    }
}
