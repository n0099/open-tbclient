package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.de;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ d a;
    private com.baidu.tieba.util.ba b;
    private boolean c;
    private String d;
    private String e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Integer... numArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        super.a((e) str);
        this.a.a = null;
        if (this.b != null) {
            de deVar = new de();
            deVar.a(this.b.c());
            deVar.a(this.b.i());
            deVar.b(this.c);
            deVar.b(this.e);
            com.baidu.tieba.im.messageCenter.d.a().e(deVar);
        }
    }

    private e(d dVar) {
        this.a = dVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(d dVar, byte b) {
        this(dVar);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public final void a2(String str) {
        this.d = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    private String d() {
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
                this.b.l();
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
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
