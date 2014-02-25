package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.de;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ d a;
    private com.baidu.tieba.util.ba b;
    private boolean c;
    private String d;
    private String e;

    private e(d dVar) {
        this.a = dVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, e eVar) {
        this(dVar);
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
                this.b = new com.baidu.tieba.util.ba();
                if (this.c) {
                    this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/user/follow");
                } else {
                    this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/user/unfollow");
                }
                this.b.a("portrait", this.d);
                this.b.e(true);
                this.b.m();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void a(String str) {
        super.a((e) str);
        this.a.a = null;
        if (this.b != null) {
            de deVar = new de();
            deVar.a(this.b.d());
            deVar.a(this.b.j());
            deVar.b(this.c);
            deVar.b(this.e);
            com.baidu.tieba.im.messageCenter.e.a().e(deVar);
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
