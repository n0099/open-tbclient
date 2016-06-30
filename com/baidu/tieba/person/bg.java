package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bg implements BdListView.e {
    final /* synthetic */ az efi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(az azVar) {
        this.efi = azVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        boolean z;
        bi biVar;
        z = this.efi.efe;
        if (!z) {
            this.efi.efd = false;
            az azVar = this.efi;
            biVar = this.efi.efa;
            azVar.pageNum = biVar.getData().getPage().pC() + 1;
            this.efi.efe = true;
            this.efi.aBV();
        }
    }
}
