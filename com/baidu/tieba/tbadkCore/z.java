package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bBK;
    private final /* synthetic */ WriteData fBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteData writeData, String str) {
        this.fBc = writeData;
        this.bBK = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cy = com.baidu.tbadk.core.c.a.sY().cy("tb.pb_editor");
        if (this.fBc != null && this.fBc.hasContentToSave()) {
            cy.a(x.qj(this.bBK), this.fBc.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cy.remove(x.qj(this.bBK));
        return null;
    }
}
