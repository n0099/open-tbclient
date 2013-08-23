package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendAloneVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bq f1392a;
    private String b;
    private int c;
    private com.baidu.tieba.a.i d;

    public br(bq bqVar, String str, int i) {
        this.f1392a = bqVar;
        setPriority(3);
        this.b = str;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bs bsVar;
        bs bsVar2;
        super.b();
        bsVar = this.f1392a.c;
        if (bsVar != null) {
            bsVar2 = this.f1392a.c;
            bsVar2.a();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.d != null) {
            this.d.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public SendAloneVoteData a(Void... voidArr) {
        this.d = new com.baidu.tieba.a.i();
        return new SendAloneVoteData().parserJson(this.d.a(this.b, this.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendAloneVoteData sendAloneVoteData) {
        bs bsVar;
        bs bsVar2;
        super.a((Object) sendAloneVoteData);
        this.f1392a.e = sendAloneVoteData;
        bsVar = this.f1392a.c;
        if (bsVar != null) {
            bsVar2 = this.f1392a.c;
            bsVar2.a(sendAloneVoteData);
        }
    }
}
