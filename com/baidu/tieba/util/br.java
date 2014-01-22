package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public class br extends BdAsyncTask<String, String, String> {
    private l a;

    public br(l lVar) {
        this.a = null;
        this.a = lVar;
        setParallelTag(1);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [53=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        l lVar;
        try {
            if (!this.a.p) {
                if (this.a.d == 4) {
                    if (this.a.k != null) {
                        bt.a().a(this.a.k, this.a.j);
                    }
                } else if (this.a.d == 5) {
                    DatabaseService.a(this.a.l, this.a.e);
                } else if (this.a.k != null) {
                    com.baidu.adp.lib.cache.s<String> v = com.baidu.tieba.b.a.a().v();
                    if (v != null && this.a.h) {
                        v.a(this.a.l, "gif", 315532800000L);
                    }
                    bt.a().a(this.a.k, this.a.j);
                }
            }
            this.a.j = null;
            lVar = this.a;
        } catch (Throwable th) {
            try {
                by.a("", -1004, "cache img err: " + th.toString(), this.a.m);
                this.a.j = null;
                lVar = this.a;
            } catch (Throwable th2) {
                this.a.j = null;
                this.a.m = null;
                throw th2;
            }
        }
        lVar.m = null;
        return null;
    }
}
