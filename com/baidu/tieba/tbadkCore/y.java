package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bTs;
    private final /* synthetic */ WriteData fLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(WriteData writeData, String str) {
        this.fLg = writeData;
        this.bTs = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cF = com.baidu.tbadk.core.c.a.sW().cF("tb.pb_editor");
        if (this.fLg != null && this.fLg.hasContentToSave()) {
            cF.a(x.ri(this.bTs), this.fLg.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cF.remove(x.ri(this.bTs));
        return null;
    }
}
