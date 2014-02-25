package com.baidu.tieba.write;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(com.baidu.tieba.data.i.k()).append("/");
        str = this.a.E;
        com.baidu.tieba.util.af.c(new File(append.append(str).toString()));
        return null;
    }
}
