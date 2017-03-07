package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String btO;
    private final /* synthetic */ WriteData ftg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteData writeData, String str) {
        this.ftg = writeData;
        this.btO = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cu = com.baidu.tbadk.core.c.a.to().cu("tb.pb_editor");
        if (this.ftg != null && this.ftg.hasContentToSave()) {
            cu.a(z.pJ(this.btO), this.ftg.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cu.remove(z.pJ(this.btO));
        return null;
    }
}
