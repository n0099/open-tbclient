package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
final class bz extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tieba.util.ba a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<by> e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Integer a(Integer... numArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Integer num) {
        by byVar;
        Integer num2 = num;
        super.a((bz) num2);
        if (this.e == null || (byVar = this.e.get()) == null) {
            return;
        }
        if (this.a == null) {
            String str = this.b;
            long j = this.c;
            byVar.a();
        } else if (!this.a.c()) {
            String str2 = this.b;
            long j2 = this.c;
            byVar.a();
        } else if (num2.intValue() == 1) {
            TiebaApplication.g().f(this.b);
            byVar.a(this.b, this.c);
        } else {
            String str3 = this.b;
            long j3 = this.c;
            byVar.a();
        }
    }

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

    private Integer d() {
        try {
            if (this.c != 0 && this.b != null) {
                this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/unfavolike");
                this.a.a("fid", String.valueOf(this.c));
                this.a.a("kw", this.b);
                this.a.a("favo_type", SocialConstants.TRUE);
                this.a.a("st_type", this.d);
                this.a.e(true);
                this.a.l();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }
}
