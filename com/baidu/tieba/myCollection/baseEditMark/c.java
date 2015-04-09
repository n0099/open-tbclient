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
    private i bEB;
    final /* synthetic */ a bEC;
    private int offset;
    private aa Ok = null;
    private String bED = null;
    Boolean bEE = false;

    public c(a aVar, int i) {
        this.bEC = aVar;
        this.offset = 0;
        this.bEB = null;
        this.offset = i;
        this.bEB = new i();
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
        this.bEE = boolArr[0];
        a aVar = new a();
        if (this.bEE.booleanValue()) {
            t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.my_bookmarks");
            if (bX != null) {
                publishProgress(bX.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList3 = this.bEC.bEw;
            if (arrayList3 == null) {
                this.bEC.bEw = new ArrayList();
            } else {
                arrayList4 = this.bEC.bEw;
                arrayList4.clear();
            }
            this.bEC.bEx = 0;
        }
        this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.Ok.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.bEC.bEz;
        if (z) {
            this.Ok.o("offset", String.valueOf(0));
        } else {
            this.Ok.o("offset", String.valueOf(this.offset));
        }
        this.Ok.o("rn", String.valueOf(20));
        this.bED = this.Ok.rO();
        this.bEB.parserJson(this.bED);
        if (this.Ok.sp().tq().pv()) {
            aVar.hx(this.bED);
            if (this.offset == 0) {
                arrayList = this.bEC.bEw;
                if (arrayList == null) {
                    this.bEC.bEw = new ArrayList();
                } else {
                    arrayList2 = this.bEC.bEw;
                    arrayList2.clear();
                }
                this.bEC.bEx = 0;
                if (this.bEE.booleanValue()) {
                    fC(this.bED);
                }
            }
        }
        return aVar;
    }

    private void fC(String str) {
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
        ArrayList<MarkData> hy;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            hy = this.bEC.hy(str);
            if (this.bEE.booleanValue()) {
                this.bEC.K(hy);
            } else {
                this.bEC.L(hy);
            }
        } else {
            this.bEC.K(arrayList);
        }
        this.bEC.bEA.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.bEC.bEt = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.bEC.bEt = null;
        this.bEC.bEx = aVar.getCount();
        ArrayList<MarkData> Yj = aVar.Yj();
        if (this.bEE.booleanValue()) {
            if (Yj != null && Yj.size() != 0) {
                this.bEC.K(Yj);
            }
        } else {
            this.bEC.L(Yj);
        }
        Iterator<MarkData> it = Yj.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.bEC.gZ(i2);
                i = i2;
            }
        }
        if (this.bEC.bEA != null) {
            if (this.Ok.sp().tq().pv()) {
                this.bEC.bEA.callback(0, this.bEB.getErrorString(), false);
            } else {
                this.bEC.bEA.callback(3, this.Ok.getErrorString());
            }
        }
        this.bEC.bEz = false;
    }
}
