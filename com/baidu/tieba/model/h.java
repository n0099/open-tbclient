package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1053a;
    private com.baidu.tieba.util.r b = null;
    private String c = null;
    private int d;
    private com.baidu.tieba.data.ay e;

    public h(f fVar, int i) {
        this.f1053a = fVar;
        this.d = 0;
        this.e = null;
        this.d = i;
        this.e = new com.baidu.tieba.data.ay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public f a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/post/threadstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.E());
        this.b.a("offset", String.valueOf(this.d));
        this.b.a("rn", String.valueOf(20));
        this.c = this.b.j();
        this.e.a(this.c);
        f fVar = new f();
        if (this.b.c() || this.e.a() == 0) {
            fVar.a(this.c);
            if (this.d == 0) {
                DatabaseService.k(this.c);
            }
        } else {
            this.c = DatabaseService.f();
            fVar.a(this.c);
        }
        return fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1053a.b = null;
        if (this.f1053a.f1051a != null) {
            this.f1053a.f1051a.a(0, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(f fVar) {
        String g;
        this.f1053a.b = null;
        this.f1053a.f = fVar.c();
        this.f1053a.b(fVar.b());
        if (this.f1053a.f1051a != null) {
            if (this.b.c()) {
                g = this.e.b();
            } else {
                g = this.b.g();
            }
            this.f1053a.f1051a.a(0, g);
        }
    }
}
