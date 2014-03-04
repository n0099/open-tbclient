package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public final class bp extends BdAsyncTask<String, String, String> {
    private l a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    public bp(l lVar) {
        this.a = null;
        this.a = lVar;
        setParallelTag(1);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [byte[], java.lang.String] */
    private String d() {
        try {
            if (!this.a.p) {
                if (this.a.d == 4) {
                    if (this.a.k != null) {
                        br.a().a(this.a.k, this.a.j);
                    }
                } else if (this.a.d == 5) {
                    DatabaseService.a(this.a.l, this.a.e);
                } else if (this.a.k != null) {
                    com.baidu.adp.lib.cache.s<String> w = com.baidu.tieba.c.a.a().w();
                    if (w != null && this.a.h) {
                        w.a(this.a.l, "gif", 315532800000L);
                    }
                    br.a().a(this.a.k, this.a.j);
                }
            }
        } catch (Throwable th) {
            try {
                cb.a("", -1004, "cache img err: " + th.toString(), this.a.m);
            } finally {
                this.a.j = null;
                this.a.m = null;
            }
        }
        return null;
    }
}
