package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Boolean, String, a> {
    private i bEo;
    final /* synthetic */ a bEp;
    private int offset;
    private aa Oi = null;
    private String bEq = null;
    Boolean bEr = false;

    public c(a aVar, int i) {
        this.bEp = aVar;
        this.offset = 0;
        this.bEo = null;
        this.offset = i;
        this.bEo = new i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public a doInBackground(Boolean... boolArr) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        this.bEr = boolArr[0];
        a aVar = new a();
        if (this.bEr.booleanValue()) {
            t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.my_bookmarks");
            if (bX != null) {
                publishProgress(bX.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList3 = this.bEp.bEj;
            if (arrayList3 == null) {
                this.bEp.bEj = new ArrayList();
            } else {
                arrayList4 = this.bEp.bEj;
                arrayList4.clear();
            }
            this.bEp.bEk = 0;
        }
        this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.Oi.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.bEp.bEm;
        if (z) {
            this.Oi.o("offset", String.valueOf(0));
        } else {
            this.Oi.o("offset", String.valueOf(this.offset));
        }
        this.Oi.o("rn", String.valueOf(20));
        this.bEq = this.Oi.rO();
        this.bEo.parserJson(this.bEq);
        if (this.Oi.sp().tq().pv()) {
            aVar.hu(this.bEq);
            if (this.offset == 0) {
                arrayList = this.bEp.bEj;
                if (arrayList == null) {
                    this.bEp.bEj = new ArrayList();
                } else {
                    arrayList2 = this.bEp.bEj;
                    arrayList2.clear();
                }
                this.bEp.bEk = 0;
                if (this.bEr.booleanValue()) {
                    fz(this.bEq);
                }
            }
        }
        return aVar;
    }

    private void fz(String str) {
        t<String> bX;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && (bX = com.baidu.tbadk.core.b.a.rc().bX("tb.my_bookmarks")) != null) {
            bX.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: q */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> hv;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            hv = this.bEp.hv(str);
            if (this.bEr.booleanValue()) {
                this.bEp.I(hv);
            } else {
                this.bEp.J(hv);
            }
        } else {
            this.bEp.I(arrayList);
        }
        this.bEp.bEn.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.bEp.bEg = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.bEp.bEg = null;
        this.bEp.bEk = aVar.getCount();
        ArrayList<MarkData> XX = aVar.XX();
        if (this.bEr.booleanValue()) {
            if (XX != null && XX.size() != 0) {
                this.bEp.I(XX);
            }
        } else {
            this.bEp.J(XX);
        }
        Iterator<MarkData> it = XX.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.bEp.gX(i2);
                i = i2;
            }
        }
        if (this.bEp.bEn != null) {
            if (this.Oi.sp().tq().pv()) {
                this.bEp.bEn.callback(0, this.bEo.getErrorString(), false);
            } else {
                this.bEp.bEn.callback(3, this.Oi.getErrorString());
            }
        }
        this.bEp.bEm = false;
    }
}
