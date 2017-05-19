package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ WriteData ftl;
    private final /* synthetic */ String ftm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteData writeData, String str) {
        this.ftl = writeData;
        this.ftm = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cz = com.baidu.tbadk.core.c.a.sZ().cz("tb.pb_editor");
        if (this.ftl != null && this.ftl.hasContentToSave()) {
            cz.a(x.pU(this.ftm), this.ftl.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cz.remove(x.pU(this.ftm));
        return null;
    }
}
