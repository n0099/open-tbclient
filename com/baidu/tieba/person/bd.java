package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class bd implements View.OnClickListener {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar) {
        this.efi = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        bi biVar;
        z = this.efi.efe;
        if (!z) {
            az azVar = this.efi;
            biVar = this.efi.efa;
            azVar.pageNum = biVar.getData().getPage().pC() + 1;
            this.efi.efe = true;
            this.efi.aBV();
        }
    }
}
