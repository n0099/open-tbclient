package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InterestFrsData;
import com.slidingmenu.lib.R;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends BdAsyncTask<Void, Void, InterestFrsData> {
    private int a;
    private int b;
    private int c;
    private WeakReference<bj> d;

    public bi(int i, int i2, int i3, bj bjVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new WeakReference<>(bjVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public InterestFrsData a(Void... voidArr) {
        String str;
        str = bh.a;
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(str);
        baVar.a("user_type", String.valueOf(this.a));
        baVar.a("offset", String.valueOf(this.b));
        baVar.a("limit", String.valueOf(this.c));
        String m = baVar.m();
        if (baVar.d()) {
            try {
                return (InterestFrsData) new GsonBuilder().create().fromJson(m, (Class<Object>) InterestFrsData.class);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("NewUserGuideModel", "doInBackground", e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(TiebaApplication.g().c().getString(R.string.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(baVar.f() == 0 ? -1001 : baVar.f());
        interestFrsData2.setErrmsg(baVar.j());
        return interestFrsData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(InterestFrsData interestFrsData) {
        super.a((bi) interestFrsData);
        bj bjVar = this.d.get();
        if (bjVar != null) {
            if (interestFrsData.getErrno() == 0) {
                bjVar.a(interestFrsData);
            } else {
                bjVar.b(interestFrsData);
            }
        }
    }
}
