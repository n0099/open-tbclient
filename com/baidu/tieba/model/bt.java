package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendAloneVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends BdAsyncTask<Void, Void, SendAloneVoteData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1429a;
    private String b;
    private int c;
    private com.baidu.tieba.a.k d;

    public bt(bs bsVar, String str, int i) {
        this.f1429a = bsVar;
        setPriority(3);
        this.b = str;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bu buVar;
        bu buVar2;
        super.b();
        buVar = this.f1429a.c;
        if (buVar != null) {
            buVar2 = this.f1429a.c;
            buVar2.a();
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
        this.d = new com.baidu.tieba.a.k();
        return new SendAloneVoteData().parserJson(this.d.a(this.b, this.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendAloneVoteData sendAloneVoteData) {
        bu buVar;
        bu buVar2;
        super.a((bt) sendAloneVoteData);
        this.f1429a.e = sendAloneVoteData;
        buVar = this.f1429a.c;
        if (buVar != null) {
            buVar2 = this.f1429a.c;
            buVar2.a(sendAloneVoteData);
        }
    }
}
