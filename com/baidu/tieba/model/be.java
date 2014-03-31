package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class be extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.ak a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<bd> e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Integer a(Integer... numArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Integer num) {
        bd bdVar;
        Integer num2 = num;
        super.a((be) num2);
        if (this.e == null || (bdVar = this.e.get()) == null) {
            return;
        }
        if (this.a == null) {
            String str = this.b;
            long j = this.c;
            bdVar.a();
        } else if (!this.a.a().b().b()) {
            String str2 = this.b;
            long j2 = this.c;
            bdVar.a();
        } else if (num2.intValue() == 1) {
            com.baidu.tieba.r.c().f(this.b);
            bdVar.a(this.b, this.c);
        } else {
            String str3 = this.b;
            long j3 = this.c;
            bdVar.a();
        }
    }

    public be(String str, long j, String str2, bd bdVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(bdVar);
        this.d = str2;
        setPriority(3);
    }

    private Integer a() {
        try {
            if (this.c != 0 && this.b != null) {
                this.a = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/unfavolike");
                this.a.a("fid", String.valueOf(this.c));
                this.a.a("kw", this.b);
                this.a.a("favo_type", "1");
                this.a.a("st_type", this.d);
                this.a.a().a().a = true;
                this.a.i();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }
}
