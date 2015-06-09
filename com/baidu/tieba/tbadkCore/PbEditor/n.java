package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class n extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ j cqI;
    private final /* synthetic */ String cqL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, String str) {
        this.cqI = jVar;
        this.cqL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.core.util.o.deleteFile(new File(this.cqL));
        return null;
    }
}
