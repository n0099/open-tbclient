package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bCD;
    private final /* synthetic */ WriteData fLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteData writeData, String str) {
        this.fLg = writeData;
        this.bCD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.adp.lib.cache.o<String> cF = com.baidu.tbadk.core.c.a.sW().cF("tb.pb_editor");
        if (this.fLg != null && this.fLg.hasContentToSave()) {
            cF.a(x.rh(this.bCD), this.fLg.toDraftString(), TbConfig.APP_OVERDUR_DRAFT_BOX);
            return null;
        }
        cF.remove(x.rh(this.bCD));
        return null;
    }
}
