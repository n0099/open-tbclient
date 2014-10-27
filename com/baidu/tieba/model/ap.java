package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tieba.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Void, Void, InterestFrsData> {
    private WeakReference<aq> agb;
    private int limit;
    private int offset;
    private int userType;

    public ap(int i, int i2, int i3, aq aqVar) {
        this.userType = i;
        this.offset = i2;
        this.limit = i3;
        this.agb = new WeakReference<>(aqVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public InterestFrsData doInBackground(Void... voidArr) {
        String str;
        str = ao.bpp;
        com.baidu.tbadk.core.util.ac acVar = new com.baidu.tbadk.core.util.ac(str);
        acVar.k("user_type", String.valueOf(this.userType));
        acVar.k("offset", String.valueOf(this.offset));
        acVar.k("limit", String.valueOf(this.limit));
        String lA = acVar.lA();
        if (acVar.mc().nb().jq()) {
            try {
                return (InterestFrsData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(lA, InterestFrsData.class);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(com.baidu.tieba.aj.wk().getContext().getString(com.baidu.tieba.y.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(acVar.mg() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : acVar.mg());
        interestFrsData2.setErrmsg(acVar.getErrorString());
        return interestFrsData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onPostExecute(InterestFrsData interestFrsData) {
        super.onPostExecute(interestFrsData);
        aq aqVar = this.agb.get();
        if (aqVar != null) {
            if (interestFrsData.getErrno() == 0) {
                aqVar.a(interestFrsData);
            } else {
                aqVar.b(interestFrsData);
            }
        }
    }
}
