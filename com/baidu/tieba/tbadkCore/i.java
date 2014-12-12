package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, e, Void> {
    final /* synthetic */ e bSf;
    FRSPageRequestMessage bSm;
    private final WeakReference<BaseActivity> bSn;
    private int bsu;
    private String mName;

    public i(e eVar, BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.bSf = eVar;
        this.mName = null;
        this.bsu = 3;
        this.bSn = new WeakReference<>(baseActivity);
        this.bSm = fRSPageRequestMessage;
        this.mName = str;
        this.bsu = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        x xVar;
        x xVar2;
        xVar = this.bSf.bRW;
        if (xVar != null) {
            xVar2 = this.bSf.bRW;
            xVar2.eF(this.bsu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.bSf.bSb;
            if (z && d.aed().hT(this.mName)) {
                if (!d.aed().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.aed().getForumModel().aej().getSignData().setIsSigned(0);
                }
                publishProgress(d.aed().getForumModel());
            }
            this.bSf.bsO = System.currentTimeMillis();
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
        xVar = this.bSf.bRW;
        if (xVar != null) {
            xVar2 = this.bSf.bRW;
            xVar2.d(eVarArr.length > 0 ? eVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.bSm.setUpdateType(this.bsu);
        FRSPageRequestMessage fRSPageRequestMessage = this.bSm;
        z = this.bSf.bSb;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.bSn != null && this.bSn.get() != null) {
            this.bSn.get().sendMessage(this.bSm);
        }
        this.bSf.bRZ = null;
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
        xVar = this.bSf.bRW;
        if (xVar != null) {
            xVar2 = this.bSf.bRW;
            xVar2.a(this.bsu, true, null);
        }
    }
}
