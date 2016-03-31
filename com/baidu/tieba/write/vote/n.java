package com.baidu.tieba.write.vote;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ WriteVoteActivity eKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(WriteVoteActivity writeVoteActivity) {
        this.eKX = writeVoteActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.eKX.eGM;
        com.baidu.tbadk.core.util.m.p(new File(append.append(str).toString()));
        return null;
    }
}
