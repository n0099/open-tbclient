package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class y extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ u bUm;
    private final /* synthetic */ String bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, String str) {
        this.bUm = uVar;
        this.bUo = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.core.util.s.deleteFile(new File(this.bUo));
        return null;
    }
}
