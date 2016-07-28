package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bvQ;
    private final /* synthetic */ WriteData fjx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteData writeData, String str) {
        this.fjx = writeData;
        this.bvQ = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cw = com.baidu.tbadk.core.b.a.rO().cw("tb.pb_editor");
        if (this.fjx != null && this.fjx.hasContentToSave()) {
            cw.a(af.ql(this.bvQ), this.fjx.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cw.remove(af.ql(this.bvQ));
        return null;
    }
}
