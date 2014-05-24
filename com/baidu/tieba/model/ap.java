package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.GsonBuilder;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tieba.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Void, Void, InterestFrsData> {
    private int a;
    private int b;
    private int c;
    private WeakReference<aq> d;

    public ap(int i, int i2, int i3, aq aqVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = new WeakReference<>(aqVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public InterestFrsData doInBackground(Void... voidArr) {
        String str;
        str = ao.a;
        com.baidu.tbadk.core.util.al alVar = new com.baidu.tbadk.core.util.al(str);
        alVar.a("user_type", String.valueOf(this.a));
        alVar.a("offset", String.valueOf(this.b));
        alVar.a("limit", String.valueOf(this.c));
        String i = alVar.i();
        if (alVar.a().b().b()) {
            try {
                return (InterestFrsData) new GsonBuilder().create().fromJson(i, (Class<Object>) InterestFrsData.class);
            } catch (Exception e) {
                BdLog.e("NewUserGuideModel", "doInBackground", e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(com.baidu.tieba.ai.c().e().getString(com.baidu.tieba.y.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(alVar.d() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : alVar.d());
        interestFrsData2.setErrmsg(alVar.f());
        return interestFrsData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(InterestFrsData interestFrsData) {
        super.onPostExecute(interestFrsData);
        aq aqVar = this.d.get();
        if (aqVar != null) {
            if (interestFrsData.getErrno() == 0) {
                aqVar.a(interestFrsData);
            } else {
                aqVar.b(interestFrsData);
            }
        }
    }
}
