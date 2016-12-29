package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bde;
    private final /* synthetic */ WriteData ffp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteData writeData, String str) {
        this.ffp = writeData;
        this.bde = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cD = com.baidu.tbadk.core.b.a.sX().cD("tb.pb_editor");
        if (this.ffp != null && this.ffp.hasContentToSave()) {
            cD.a(ac.qh(this.bde), this.ffp.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cD.remove(ac.qh(this.bde));
        return null;
    }
}
