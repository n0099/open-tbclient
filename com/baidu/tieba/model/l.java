package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Boolean, String, j> {
    private com.baidu.tieba.data.at boo;
    final /* synthetic */ j bop;
    private int offset;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private String boq = null;
    Boolean bor = false;

    public l(j jVar, int i) {
        this.bop = jVar;
        this.offset = 0;
        this.boo = null;
        this.offset = i;
        this.boo = new com.baidu.tieba.data.at();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public j doInBackground(Boolean... boolArr) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        this.bor = boolArr[0];
        j jVar = new j();
        if (this.bor.booleanValue()) {
            com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_bookmarks");
            if (bd != null) {
                publishProgress(bd.get(TbadkApplication.getCurrentAccount()));
            }
            arrayList = this.bop.bol;
            if (arrayList == null) {
                this.bop.bol = new ArrayList();
            } else {
                arrayList2 = this.bop.bol;
                arrayList2.clear();
            }
            this.bop.bom = 0;
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/post/threadstore");
        this.mNetWork.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, TbadkApplication.getCurrentAccount());
        z = this.bop.awM;
        if (z) {
            this.mNetWork.k("offset", String.valueOf(0));
        } else {
            this.mNetWork.k("offset", String.valueOf(this.offset));
        }
        this.mNetWork.k("rn", String.valueOf(20));
        this.boq = this.mNetWork.lA();
        this.boo.parserJson(this.boq);
        if (this.mNetWork.mc().nb().jq()) {
            jVar.gQ(this.boq);
            if (this.offset == 0 && this.bor.booleanValue()) {
                eS(this.boq);
            }
        }
        return jVar;
    }

    private void eS(String str) {
        com.baidu.adp.lib.cache.t<String> bd;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_bookmarks")) != null) {
            bd.a(currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> gR;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            gR = this.bop.gR(str);
            if (this.bor.booleanValue()) {
                this.bop.y(gR);
            } else {
                this.bop.z(gR);
            }
        } else {
            this.bop.y(arrayList);
        }
        this.bop.atj.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.bop.boi = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        this.bop.boi = null;
        this.bop.bom = jVar.getCount();
        ArrayList<MarkData> Ti = jVar.Ti();
        if (this.bor.booleanValue()) {
            this.bop.y(Ti);
        } else {
            this.bop.z(Ti);
        }
        Iterator<MarkData> it = Ti.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.bop.gA(i2);
                i = i2;
            }
        }
        if (this.bop.atj != null) {
            if (this.mNetWork.mc().nb().jq()) {
                this.bop.atj.callback(0, this.boo.getErrorString(), false);
            } else {
                this.bop.atj.callback(3, this.mNetWork.getErrorString());
            }
        }
        this.bop.awM = false;
    }
}
