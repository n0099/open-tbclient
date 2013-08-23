package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendPKVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bq f1393a;
    private String b;
    private String c;
    private int d;
    private com.baidu.tieba.a.j e;

    public bt(bq bqVar, String str, String str2, int i) {
        this.f1393a = bqVar;
        setPriority(3);
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bu buVar;
        bu buVar2;
        super.b();
        buVar = this.f1393a.d;
        if (buVar != null) {
            buVar2 = this.f1393a.d;
            buVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public SendPKVoteData a(Void... voidArr) {
        this.e = new com.baidu.tieba.a.j();
        return new SendPKVoteData().parserJson(this.e.a(this.b, this.c, this.d));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendPKVoteData sendPKVoteData) {
        bu buVar;
        bu buVar2;
        super.a((Object) sendPKVoteData);
        this.f1393a.f = sendPKVoteData;
        buVar = this.f1393a.d;
        if (buVar != null) {
            buVar2 = this.f1393a.d;
            buVar2.a(sendPKVoteData);
        }
    }
}
