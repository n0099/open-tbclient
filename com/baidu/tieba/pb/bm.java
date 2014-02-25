package com.baidu.tieba.pb;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(com.baidu.tieba.data.i.k()).append("/");
        str = this.a.n;
        com.baidu.tieba.util.af.c(new File(append.append(str).toString()));
        return null;
    }
}
