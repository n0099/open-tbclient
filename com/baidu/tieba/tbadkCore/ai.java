package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ WriteData fjx;
    private final /* synthetic */ String fjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteData writeData, String str) {
        this.fjx = writeData;
        this.fjy = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cw = com.baidu.tbadk.core.b.a.rO().cw("tb.pb_editor");
        if (this.fjx != null && this.fjx.hasContentToSave()) {
            cw.a(af.qj(this.fjy), this.fjx.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cw.remove(af.qj(this.fjy));
        return null;
    }
}
