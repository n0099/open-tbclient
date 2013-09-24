package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendPKVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends BdAsyncTask<Void, Void, SendPKVoteData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1430a;
    private String b;
    private String c;
    private int d;
    private com.baidu.tieba.a.l e;

    public bv(bs bsVar, String str, String str2, int i) {
        this.f1430a = bsVar;
        setPriority(3);
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bw bwVar;
        bw bwVar2;
        super.b();
        bwVar = this.f1430a.d;
        if (bwVar != null) {
            bwVar2 = this.f1430a.d;
            bwVar2.a();
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
        bw bwVar;
        bw bwVar2;
        super.a((bv) sendPKVoteData);
        this.f1430a.f = sendPKVoteData;
        bwVar = this.f1430a.d;
        if (bwVar != null) {
            bwVar2 = this.f1430a.d;
            bwVar2.a(sendPKVoteData);
        }
    }
}
