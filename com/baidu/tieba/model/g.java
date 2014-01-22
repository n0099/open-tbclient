package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.cv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ e a;
    private com.baidu.tieba.util.ax b;
    private boolean c;
    private String d;
    private String e;

    private g(e eVar) {
        this.a = eVar;
        this.b = null;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        try {
            if (this.d != null) {
                this.b = new com.baidu.tieba.util.ax();
                if (this.c) {
                    this.b.a(com.baidu.tieba.data.h.a + "c/c/user/follow");
                } else {
                    this.b.a(com.baidu.tieba.data.h.a + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.d);
                this.b.e(true);
                this.b.m();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void a(String str) {
        super.a((g) str);
        this.a.a = null;
        if (this.b != null) {
            cv cvVar = new cv();
            cvVar.a(this.b.d());
            cvVar.a(this.b.j());
            cvVar.b(this.c);
            cvVar.b(this.e);
            com.baidu.tieba.im.messageCenter.e.a().e(cvVar);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.a = null;
        gVar = this.a.b;
        if (gVar != null) {
            gVar2 = this.a.b;
            gVar2.a(false);
        }
    }
}
