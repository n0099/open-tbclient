package com.baidu.tieba.person;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class bf implements t.b {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(az azVar) {
        this.efi = azVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        PersonFriendActivity aKM;
        bi biVar;
        boolean z2;
        PersonFriendActivity aKM2;
        int i;
        int i2;
        aKM = this.efi.aKM();
        if (aKM != null) {
            this.efi.pageNum = 0;
            this.efi.efd = true;
            biVar = this.efi.efa;
            z2 = this.efi.cgJ;
            aKM2 = this.efi.aKM();
            String uid = aKM2.getUid();
            i = this.efi.pageNum;
            i2 = this.efi.eff;
            biVar.a(z2, uid, i, i2);
        }
    }
}
