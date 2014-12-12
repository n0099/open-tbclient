package com.baidu.tieba.model;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tieba.data.InterestFrsData;
import com.baidu.tieba.z;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Void, Void, InterestFrsData> {
    private WeakReference<q> anA;
    private int limit;
    private int offset;
    private int userType;

    public p(int i, int i2, int i3, q qVar) {
        this.userType = i;
        this.offset = i2;
        this.limit = i3;
        this.anA = new WeakReference<>(qVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public InterestFrsData doInBackground(Void... voidArr) {
        String str;
        str = o.btk;
        ad adVar = new ad(str);
        adVar.o(OfficalBarChatActivityConfig.USER_TYPE, String.valueOf(this.userType));
        adVar.o("offset", String.valueOf(this.offset));
        adVar.o("limit", String.valueOf(this.limit));
        String ov = adVar.ov();
        if (adVar.oW().pW().ma()) {
            try {
                return (InterestFrsData) i.objectWithJsonStr(ov, InterestFrsData.class);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(z.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(adVar.pa() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : adVar.pa());
        interestFrsData2.setErrmsg(adVar.getErrorString());
        return interestFrsData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onPostExecute(InterestFrsData interestFrsData) {
        super.onPostExecute(interestFrsData);
        q qVar = this.anA.get();
        if (qVar != null) {
            if (interestFrsData.getErrno() == 0) {
                qVar.a(interestFrsData);
            } else {
                qVar.b(interestFrsData);
            }
        }
    }
}
