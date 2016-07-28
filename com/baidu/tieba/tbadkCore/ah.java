package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aKw;
    private final /* synthetic */ WriteData fjx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteData writeData, String str) {
        this.fjx = writeData;
        this.aKw = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cw = com.baidu.tbadk.core.b.a.rO().cw("tb.pb_editor");
        if (this.fjx != null && this.fjx.hasContentToSave()) {
            cw.a(af.qk(this.aKw), this.fjx.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cw.remove(af.qk(this.aKw));
        return null;
    }
}
