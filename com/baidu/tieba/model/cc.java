package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendAloneVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc extends BdAsyncTask<Void, Void, SendAloneVoteData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f1933a;
    private String b;
    private int c;
    private com.baidu.tieba.a.k d;

    public cc(cb cbVar, String str, int i) {
        this.f1933a = cbVar;
        setPriority(3);
        this.b = str;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        cd cdVar;
        cd cdVar2;
        super.b();
        cdVar = this.f1933a.c;
        if (cdVar != null) {
            cdVar2 = this.f1933a.c;
            cdVar2.a();
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
        cd cdVar;
        cd cdVar2;
        super.a((cc) sendAloneVoteData);
        this.f1933a.e = sendAloneVoteData;
        cdVar = this.f1933a.c;
        if (cdVar != null) {
            cdVar2 = this.f1933a.c;
            cdVar2.a(sendAloneVoteData);
        }
    }
}
