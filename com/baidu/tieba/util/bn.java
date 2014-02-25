package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public class bn extends BdAsyncTask<String, String, String> {
    final /* synthetic */ bm a;
    private String b;
    private String c;
    private boolean d;
    private boolean e;
    private boolean f;

    public bn(bm bmVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        this.a = bmVar;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
        this.f = z3;
        setParallelTag(1);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        try {
            this.a.a(this.b, this.c, this.d, this.e, this.f);
        } catch (Throwable th) {
            cb.a("", -1004, "pic cache img err: " + th.toString(), (String) null);
        }
        return null;
    }
}
