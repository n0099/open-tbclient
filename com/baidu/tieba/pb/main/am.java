package com.baidu.tieba.pb.main;

import android.os.Environment;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        String str;
        StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory()).append("/").append(TbConfig.getTempDirName()).append("/");
        str = this.a.o;
        com.baidu.tbadk.core.util.s.c(new File(append.append(str).toString()));
        return null;
    }
}
