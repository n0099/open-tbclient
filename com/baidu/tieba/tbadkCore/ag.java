package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String btC;
    private final /* synthetic */ WriteData eWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteData writeData, String str) {
        this.eWv = writeData;
        this.btC = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cw = com.baidu.tbadk.core.b.a.rP().cw("tb.pb_editor");
        if (this.eWv != null && this.eWv.hasContentToSave()) {
            cw.a(af.pB(this.btC), this.eWv.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cw.remove(af.pB(this.btC));
        return null;
    }
}
