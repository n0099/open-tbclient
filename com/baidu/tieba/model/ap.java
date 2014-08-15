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
        com.baidu.tbadk.core.util.ae aeVar = new com.baidu.tbadk.core.util.ae(str);
        aeVar.a("user_type", String.valueOf(this.a));
        aeVar.a("offset", String.valueOf(this.b));
        aeVar.a("limit", String.valueOf(this.c));
        String h = aeVar.h();
        if (aeVar.a().b().b()) {
            try {
                return (InterestFrsData) new GsonBuilder().create().fromJson(h, (Class<Object>) InterestFrsData.class);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(com.baidu.tieba.ai.c().e().getString(com.baidu.tieba.x.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(aeVar.c() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : aeVar.c());
        interestFrsData2.setErrmsg(aeVar.e());
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
