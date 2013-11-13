package com.baidu.tieba.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f2476a;
    private ac b = null;
    private String c;

    public ab(y yVar, String str) {
        this.f2476a = yVar;
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
        this.b = new ac(this.f2476a, null);
        networkStateInfo = this.f2476a.n;
        if (networkStateInfo != UtilHelper.NetworkStateInfo.WIFI) {
            y yVar = this.f2476a;
            str3 = y.d;
            yVar.d(str3);
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = y.d;
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.contains(".log") && (TextUtils.isEmpty(this.c) || !this.c.equals(name))) {
                            ac acVar = this.b;
                            StringBuilder sb = new StringBuilder();
                            str2 = y.d;
                            acVar.a(sb.append(str2).append("/").append(name).toString(), "c/s/logupload", true);
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
        this.f2476a.t = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((ab) str);
        this.f2476a.t = null;
    }
}
