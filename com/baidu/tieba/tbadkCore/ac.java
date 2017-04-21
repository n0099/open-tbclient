package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ WriteData fxg;
    private final /* synthetic */ String fxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteData writeData, String str) {
        this.fxg = writeData;
        this.fxh = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cB = com.baidu.tbadk.core.c.a.tM().cB("tb.pb_editor");
        if (this.fxg != null && this.fxg.hasContentToSave()) {
            cB.a(z.qa(this.fxh), this.fxg.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cB.remove(z.qa(this.fxh));
        return null;
    }
}
