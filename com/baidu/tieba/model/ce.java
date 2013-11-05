package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendPKVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends BdAsyncTask<Void, Void, SendPKVoteData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f1934a;
    private String b;
    private String c;
    private int d;
    private com.baidu.tieba.a.l e;

    public ce(cb cbVar, String str, String str2, int i) {
        this.f1934a = cbVar;
        setPriority(3);
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        cf cfVar;
        cf cfVar2;
        super.b();
        cfVar = this.f1934a.d;
        if (cfVar != null) {
            cfVar2 = this.f1934a.d;
            cfVar2.a();
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
        this.e = new com.baidu.tieba.a.l();
        return new SendPKVoteData().parserJson(this.e.a(this.b, this.c, this.d));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendPKVoteData sendPKVoteData) {
        cf cfVar;
        cf cfVar2;
        super.a((ce) sendPKVoteData);
        this.f1934a.f = sendPKVoteData;
        cfVar = this.f1934a.d;
        if (cfVar != null) {
            cfVar2 = this.f1934a.d;
            cfVar2.a(sendPKVoteData);
        }
    }
}
