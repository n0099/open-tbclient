package com.baidu.tieba.write.write;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.fQG.aAx;
        com.baidu.tbadk.core.util.l.p(new File(append.append(str).toString()));
        return null;
    }
}
