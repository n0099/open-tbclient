package com.baidu.tieba.log;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ a a;
    private e b = null;
    private String c;

    public d(a aVar, String str) {
        this.a = aVar;
        this.c = null;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        UtilHelper.NetworkStateInfo networkStateInfo;
        boolean z;
        String str;
        String str2;
        String str3;
        this.b = new e(this.a, null);
        networkStateInfo = this.a.l;
        if (networkStateInfo != UtilHelper.NetworkStateInfo.WIFI) {
            a aVar = this.a;
            str3 = a.c;
            aVar.g(str3);
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = a.c;
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.contains(".log") && (TextUtils.isEmpty(this.c) || !this.c.equals(name))) {
                            e eVar = this.b;
                            StringBuilder sb = new StringBuilder();
                            str2 = a.c;
                            eVar.a(sb.append(str2).append("/").append(name).toString(), "c/s/logupload", true);
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.a();
        }
        this.a.q = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((d) str);
        this.a.q = null;
    }
}
