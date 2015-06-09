package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, u, Void> {
    private int bGv;
    final /* synthetic */ e coD;
    FRSPageRequestMessage coK;
    private final WeakReference<BaseActivity> coL;
    private String mName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.coD.cov;
        if (aaVar != null) {
            aaVar2 = this.coD.cov;
            aaVar2.eU(this.bGv);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.coD.coA;
            if (z && d.amp().jo(this.mName)) {
                if (!d.amp().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.amp().getResponseData().aas().getSignData().setIsSigned(0);
                }
                publishProgress(d.amp().getResponseData());
            }
            this.coD.aFu = System.currentTimeMillis();
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(u... uVarArr) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.coD.cov;
        if (aaVar != null) {
            aaVar2 = this.coD.cov;
            aaVar2.b(uVarArr.length > 0 ? uVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.coK.setUpdateType(this.bGv);
        FRSPageRequestMessage fRSPageRequestMessage = this.coK;
        z = this.coD.coA;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.coL != null && this.coL.get() != null) {
            this.coL.get().sendMessage(this.coK);
        }
        this.coD.coy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        aa aaVar;
        aa aaVar2;
        super.cancel(true);
        aaVar = this.coD.cov;
        if (aaVar != null) {
            aaVar2 = this.coD.cov;
            aaVar2.a(this.bGv, true, null);
        }
    }
}
