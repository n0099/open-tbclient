package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tieba.util.ba a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<by> e;

    public bz(String str, long j, String str2, by byVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(byVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/unfavolike");
                this.a.a("fid", String.valueOf(this.c));
                this.a.a("kw", this.b);
                this.a.a("favo_type", SocialConstants.TRUE);
                this.a.a("st_type", this.d);
                this.a.e(true);
                this.a.m();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
        by byVar;
        super.a((bz) num);
        if (this.e != null && (byVar = this.e.get()) != null) {
            if (this.a != null) {
                if (this.a.d()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.g().f(this.b);
                        byVar.a(this.b, this.c);
                        return;
                    }
                    byVar.b(this.b, this.c);
                    return;
                }
                byVar.b(this.b, this.c);
                return;
            }
            byVar.b(this.b, this.c);
        }
    }
}
