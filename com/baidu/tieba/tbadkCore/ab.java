package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String btG;
    private final /* synthetic */ WriteData fuQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteData writeData, String str) {
        this.fuQ = writeData;
        this.btG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.c.a.tM().cB("tb.pb_editor");
        if (this.fuQ != null && this.fuQ.hasContentToSave()) {
            cB.a(z.qa(this.btG), this.fuQ.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cB.remove(z.qa(this.btG));
        return null;
    }
}
