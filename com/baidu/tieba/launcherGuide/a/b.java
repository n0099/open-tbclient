package com.baidu.tieba.launcherGuide.a;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.y;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, InterestFrsData> {
    private WeakReference<c> awC;
    private int limit;
    private int offset;
    private int userType;

    public b(int i, int i2, int i3, c cVar) {
        this.userType = i;
        this.offset = i2;
        this.limit = i3;
        this.awC = new WeakReference<>(cVar);
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public InterestFrsData doInBackground(Void... voidArr) {
        String str;
        str = a.bxy;
        aa aaVar = new aa(str);
        aaVar.o(OfficalBarChatActivityConfig.USER_TYPE, String.valueOf(this.userType));
        aaVar.o("offset", String.valueOf(this.offset));
        aaVar.o("limit", String.valueOf(this.limit));
        String rO = aaVar.rO();
        if (aaVar.sp().tq().pv()) {
            try {
                return (InterestFrsData) i.objectWithJsonStr(rO, InterestFrsData.class);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                InterestFrsData interestFrsData = new InterestFrsData();
                interestFrsData.setErrno(-1000);
                interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(y.neterror));
                return interestFrsData;
            }
        }
        InterestFrsData interestFrsData2 = new InterestFrsData();
        interestFrsData2.setErrno(aaVar.st() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : aaVar.st());
        interestFrsData2.setErrmsg(aaVar.getErrorString());
        return interestFrsData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onPostExecute(InterestFrsData interestFrsData) {
        super.onPostExecute(interestFrsData);
        c cVar = this.awC.get();
        if (cVar != null) {
            if (interestFrsData.getErrno() == 0) {
                cVar.a(interestFrsData);
            } else {
                cVar.b(interestFrsData);
            }
        }
    }
}
