package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ WriteData ffp;
    private final /* synthetic */ String ffq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteData writeData, String str) {
        this.ffp = writeData;
        this.ffq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cD = com.baidu.tbadk.core.b.a.sX().cD("tb.pb_editor");
        if (this.ffp != null && this.ffp.hasContentToSave()) {
            cD.a(ac.qg(this.ffq), this.ffp.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cD.remove(ac.qg(this.ffq));
        return null;
    }
}
