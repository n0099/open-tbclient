package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bi extends BdAsyncTask<Void, Void, InterestFrsData> {
    private int a;
    private int b;
    private int c;
    private WeakReference<bj> d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ InterestFrsData a(Void... voidArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(InterestFrsData interestFrsData) {
        InterestFrsData interestFrsData2 = interestFrsData;
        super.a((bi) interestFrsData2);
        bj bjVar = this.d.get();
        if (bjVar != null) {
            if (interestFrsData2.getErrno() == 0) {
                bjVar.a(interestFrsData2);
            } else {
                bjVar.a();
            }
        }
    }

    public bi(int i, int i2, int i3, bj bjVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new WeakReference<>(bjVar);
        setPriority(3);
    }

    private InterestFrsData d() {
        String str;
        str = bh.a;
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(str);
        baVar.a("user_type", String.valueOf(this.a));
        baVar.a("offset", String.valueOf(this.b));
        baVar.a("limit", String.valueOf(this.c));
        String l = baVar.l();
        if (baVar.c()) {
            try {
                return (InterestFrsData) new GsonBuilder().create().fromJson(l, (Class<Object>) InterestFrsData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("NewUserGuideModel", "doInBackground", e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(TiebaApplication.g().c().getString(R.string.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(baVar.e() == 0 ? -1001 : baVar.e());
        interestFrsData2.setErrmsg(baVar.i());
        return interestFrsData2;
    }
}
