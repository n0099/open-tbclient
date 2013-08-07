package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.SendAloneVoteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1358a;
    private String b;
    private int c;
    private com.baidu.tieba.a.j d;

    public bs(br brVar, String str, int i) {
        this.f1358a = brVar;
        setPriority(3);
        this.b = str;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        bt btVar;
        bt btVar2;
        super.b();
        btVar = this.f1358a.c;
        if (btVar != null) {
            btVar2 = this.f1358a.c;
            btVar2.a();
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
        this.d = new com.baidu.tieba.a.j();
        return new SendAloneVoteData().parserJson(this.d.a(this.b, this.c));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(SendAloneVoteData sendAloneVoteData) {
        bt btVar;
        bt btVar2;
        super.a((Object) sendAloneVoteData);
        this.f1358a.e = sendAloneVoteData;
        btVar = this.f1358a.c;
        if (btVar != null) {
            btVar2 = this.f1358a.c;
            btVar2.a(sendAloneVoteData);
        }
    }
}
