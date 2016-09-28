package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String baD;
    private final /* synthetic */ WriteData ftX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteData writeData, String str) {
        this.ftX = writeData;
        this.baD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cA = com.baidu.tbadk.core.b.a.ti().cA("tb.pb_editor");
        if (this.ftX != null && this.ftX.hasContentToSave()) {
            cA.a(ae.rj(this.baD), this.ftX.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cA.remove(ae.rj(this.baD));
        return null;
    }
}
