package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendPKVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1361a;
    private String b;
    private String c;
    private int d;
    private com.baidu.tieba.a.k e;

    public bu(br brVar, String str, String str2, int i) {
        this.f1361a = brVar;
        setPriority(3);
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bv bvVar;
        bv bvVar2;
        super.b();
        bvVar = this.f1361a.d;
        if (bvVar != null) {
            bvVar2 = this.f1361a.d;
            bvVar2.a();
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
        this.e = new com.baidu.tieba.a.k();
        return new SendPKVoteData().parserJson(this.e.a(this.b, this.c, this.d));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendPKVoteData sendPKVoteData) {
        bv bvVar;
        bv bvVar2;
        super.a((Object) sendPKVoteData);
        this.f1361a.f = sendPKVoteData;
        bvVar = this.f1361a.d;
        if (bvVar != null) {
            bvVar2 = this.f1361a.d;
            bvVar2.a(sendPKVoteData);
        }
    }
}
