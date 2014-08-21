package com.baidu.tieba.mention;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(al alVar) {
        this.a = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.a.r;
        com.baidu.tbadk.core.util.s.c(new File(append.append(str).toString()));
        return null;
    }
}
