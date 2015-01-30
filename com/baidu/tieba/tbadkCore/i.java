package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, e, Void> {
    final /* synthetic */ e bTT;
    FRSPageRequestMessage bUa;
    private final WeakReference<BaseActivity> bUb;
    private int btR;
    private String mName;

    public i(e eVar, BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.bTT = eVar;
        this.mName = null;
        this.btR = 3;
        this.bUb = new WeakReference<>(baseActivity);
        this.bUa = fRSPageRequestMessage;
        this.mName = str;
        this.btR = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        x xVar;
        x xVar2;
        xVar = this.bTT.bTK;
        if (xVar != null) {
            xVar2 = this.bTT.bTK;
            xVar2.eL(this.btR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.bTT.bTP;
            if (z && d.aeH().ia(this.mName)) {
                if (!d.aeH().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.aeH().getForumModel().aeN().getSignData().setIsSigned(0);
                }
                publishProgress(d.aeH().getForumModel());
            }
            this.bTT.bum = System.currentTimeMillis();
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
    public void onProgressUpdate(e... eVarArr) {
        x xVar;
        x xVar2;
        xVar = this.bTT.bTK;
        if (xVar != null) {
            xVar2 = this.bTT.bTK;
            xVar2.d(eVarArr.length > 0 ? eVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.bUa.setUpdateType(this.btR);
        FRSPageRequestMessage fRSPageRequestMessage = this.bUa;
        z = this.bTT.bTP;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.bUb != null && this.bUb.get() != null) {
            this.bUb.get().sendMessage(this.bUa);
        }
        this.bTT.bTN = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        x xVar;
        x xVar2;
        super.cancel(true);
        xVar = this.bTT.bTK;
        if (xVar != null) {
            xVar2 = this.bTT.bTK;
            xVar2.a(this.btR, true, null);
        }
    }
}
