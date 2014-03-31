package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ap extends BdAsyncTask<Void, Void, InterestFrsData> {
    private int a;
    private int b;
    private int c;
    private WeakReference<aq> d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ InterestFrsData a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(InterestFrsData interestFrsData) {
        InterestFrsData interestFrsData2 = interestFrsData;
        super.a((ap) interestFrsData2);
        aq aqVar = this.d.get();
        if (aqVar != null) {
            if (interestFrsData2.getErrno() == 0) {
                aqVar.a(interestFrsData2);
            } else {
                aqVar.a();
            }
        }
    }

    public ap(int i, int i2, int i3, aq aqVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new WeakReference<>(aqVar);
        setPriority(3);
    }

    private InterestFrsData a() {
        String str;
        str = ao.a;
        com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(str);
        akVar.a("user_type", String.valueOf(this.a));
        akVar.a("offset", String.valueOf(this.b));
        akVar.a("limit", String.valueOf(this.c));
        String i = akVar.i();
        if (akVar.a().b().b()) {
            try {
                return (InterestFrsData) new GsonBuilder().create().fromJson(i, (Class<Object>) InterestFrsData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("NewUserGuideModel", "doInBackground", e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                com.baidu.tieba.r.c();
                interestFrsData.setErrmsg(com.baidu.tieba.r.e().getString(com.baidu.tieba.a.k.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(akVar.d() == 0 ? -1001 : akVar.d());
        interestFrsData2.setErrmsg(akVar.f());
        return interestFrsData2;
    }
}
