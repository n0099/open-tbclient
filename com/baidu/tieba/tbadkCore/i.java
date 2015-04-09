package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, u, Void> {
    private int bDz;
    final /* synthetic */ e ckC;
    FRSPageRequestMessage ckJ;
    private final WeakReference<BaseActivity> ckK;
    private String mName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.ckC.cku;
        if (aaVar != null) {
            aaVar2 = this.ckC.cku;
            aaVar2.eG(this.bDz);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.ckC.ckz;
            if (z && d.akD().iv(this.mName)) {
                if (!d.akD().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.akD().getResponseData().Za().getSignData().setIsSigned(0);
                }
                publishProgress(d.akD().getResponseData());
            }
            this.ckC.aDr = System.currentTimeMillis();
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
        aaVar = this.ckC.cku;
        if (aaVar != null) {
            aaVar2 = this.ckC.cku;
            aaVar2.b(uVarArr.length > 0 ? uVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.ckJ.setUpdateType(this.bDz);
        FRSPageRequestMessage fRSPageRequestMessage = this.ckJ;
        z = this.ckC.ckz;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.ckK != null && this.ckK.get() != null) {
            this.ckK.get().sendMessage(this.ckJ);
        }
        this.ckC.ckx = null;
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
        aaVar = this.ckC.cku;
        if (aaVar != null) {
            aaVar2 = this.ckC.cku;
            aaVar2.a(this.bDz, true, null);
        }
    }
}
