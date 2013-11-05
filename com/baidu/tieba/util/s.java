package com.baidu.tieba.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f2459a;
    private t b = null;
    private String c;

    public s(o oVar, String str) {
        this.f2459a = oVar;
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
        this.b = new t(this.f2459a, null);
        networkStateInfo = this.f2459a.n;
        if (networkStateInfo != UtilHelper.NetworkStateInfo.WIFI) {
            o oVar = this.f2459a;
            str3 = o.d;
            oVar.d(str3);
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str = o.d;
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile()) {
                        String name = file.getName();
                        if (name.contains(".log") && (TextUtils.isEmpty(this.c) || !this.c.equals(name))) {
                            t tVar = this.b;
                            StringBuilder sb = new StringBuilder();
                            str2 = o.d;
                            tVar.a(sb.append(str2).append("/").append(name).toString(), "c/s/logupload", true);
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
        this.f2459a.t = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((s) str);
        this.f2459a.t = null;
    }
}
