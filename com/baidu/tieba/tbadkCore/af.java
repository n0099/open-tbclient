package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bHe;
    private final /* synthetic */ WriteData frp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteData writeData, String str) {
        this.frp = writeData;
        this.bHe = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cy = com.baidu.tbadk.core.b.a.sT().cy("tb.pb_editor");
        if (this.frp != null && this.frp.hasContentToSave()) {
            cy.a(ae.qV(this.bHe), this.frp.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cy.remove(ae.qV(this.bHe));
        return null;
    }
}
