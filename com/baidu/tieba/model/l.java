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
    private com.baidu.tieba.data.at boC;
    final /* synthetic */ j boD;
    private int offset;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private String boE = null;
    Boolean boF = false;

    public l(j jVar, int i) {
        this.boD = jVar;
        this.offset = 0;
        this.boC = null;
        this.offset = i;
        this.boC = new com.baidu.tieba.data.at();
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
        this.boF = boolArr[0];
        j jVar = new j();
        if (this.boF.booleanValue()) {
            com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.my_bookmarks");
            if (bd != null) {
                publishProgress(bd.get(TbadkApplication.getCurrentAccount()));
            }
            arrayList = this.boD.boz;
            if (arrayList == null) {
                this.boD.boz = new ArrayList();
            } else {
                arrayList2 = this.boD.boz;
                arrayList2.clear();
            }
            this.boD.boA = 0;
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/post/threadstore");
        this.mNetWork.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, TbadkApplication.getCurrentAccount());
        z = this.boD.awV;
        if (z) {
            this.mNetWork.k("offset", String.valueOf(0));
        } else {
            this.mNetWork.k("offset", String.valueOf(this.offset));
        }
        this.mNetWork.k("rn", String.valueOf(20));
        this.boE = this.mNetWork.lA();
        this.boC.parserJson(this.boE);
        if (this.mNetWork.mc().nb().jq()) {
            jVar.gQ(this.boE);
            if (this.offset == 0 && this.boF.booleanValue()) {
                eS(this.boE);
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
            gR = this.boD.gR(str);
            if (this.boF.booleanValue()) {
                this.boD.z(gR);
            } else {
                this.boD.A(gR);
            }
        } else {
            this.boD.z(arrayList);
        }
        this.boD.ats.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.boD.bow = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(j jVar) {
        if (jVar == null) {
            jVar = new j();
        }
        this.boD.bow = null;
        this.boD.boA = jVar.getCount();
        ArrayList<MarkData> Tl = jVar.Tl();
        if (this.boF.booleanValue()) {
            if (Tl != null && Tl.size() != 0) {
                this.boD.z(Tl);
            }
        } else {
            this.boD.A(Tl);
        }
        Iterator<MarkData> it = Tl.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.boD.gA(i2);
                i = i2;
            }
        }
        if (this.boD.ats != null) {
            if (this.mNetWork.mc().nb().jq()) {
                this.boD.ats.callback(0, this.boC.getErrorString(), false);
            } else {
                this.boD.ats.callback(3, this.mNetWork.getErrorString());
            }
        }
        this.boD.awV = false;
    }
}
