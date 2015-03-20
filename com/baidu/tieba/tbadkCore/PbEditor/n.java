package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class n extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ j cms;
    private final /* synthetic */ String cmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, String str) {
        this.cms = jVar;
        this.cmv = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.core.util.o.deleteFile(new File(this.cmv));
        return null;
    }
}
