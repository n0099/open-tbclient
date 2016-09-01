package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ WriteData frp;
    private final /* synthetic */ String frq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteData writeData, String str) {
        this.frp = writeData;
        this.frq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cy = com.baidu.tbadk.core.b.a.sT().cy("tb.pb_editor");
        if (this.frp != null && this.frp.hasContentToSave()) {
            cy.a(ae.qT(this.frq), this.frp.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cy.remove(ae.qT(this.frq));
        return null;
    }
}
