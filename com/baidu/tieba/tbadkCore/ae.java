package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bKg;
    private final /* synthetic */ WriteData fBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteData writeData, String str) {
        this.fBk = writeData;
        this.bKg = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cC = com.baidu.tbadk.core.b.a.tm().cC("tb.pb_editor");
        if (this.fBk != null && this.fBk.hasContentToSave()) {
            cC.a(ad.rE(this.bKg), this.fBk.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cC.remove(ad.rE(this.bKg));
        return null;
    }
}
