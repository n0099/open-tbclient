package com.baidu.tieba.write;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.a.F;
        com.baidu.tbadk.core.util.s.c(new File(append.append(str).toString()));
        return null;
    }
}
