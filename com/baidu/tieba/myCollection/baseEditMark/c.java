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
    private i bHx;
    final /* synthetic */ a bHy;
    private int offset;
    private aa OE = null;
    private String bHz = null;
    Boolean bHA = false;

    public c(a aVar, int i) {
        this.bHy = aVar;
        this.offset = 0;
        this.bHx = null;
        this.offset = i;
        this.bHx = new i();
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
        this.bHA = boolArr[0];
        a aVar = new a();
        if (this.bHA.booleanValue()) {
            t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.my_bookmarks");
            if (ck != null) {
                publishProgress(ck.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList3 = this.bHy.bHs;
            if (arrayList3 == null) {
                this.bHy.bHs = new ArrayList();
            } else {
                arrayList4 = this.bHy.bHs;
                arrayList4.clear();
            }
            this.bHy.bHt = 0;
        }
        this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.OE.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.bHy.bHv;
        if (z) {
            this.OE.o("offset", String.valueOf(0));
        } else {
            this.OE.o("offset", String.valueOf(this.offset));
        }
        this.OE.o("rn", String.valueOf(20));
        this.bHz = this.OE.sw();
        this.bHx.parserJson(this.bHz);
        if (this.OE.sX().tT().qa()) {
            aVar.ib(this.bHz);
            if (this.offset == 0) {
                arrayList = this.bHy.bHs;
                if (arrayList == null) {
                    this.bHy.bHs = new ArrayList();
                } else {
                    arrayList2 = this.bHy.bHs;
                    arrayList2.clear();
                }
                this.bHy.bHt = 0;
                if (this.bHA.booleanValue()) {
                    gc(this.bHz);
                }
            }
        }
        return aVar;
    }

    private void gc(String str) {
        t<String> ck;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && (ck = com.baidu.tbadk.core.b.a.rI().ck("tb.my_bookmarks")) != null) {
            ck.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> ic;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            ic = this.bHy.ic(str);
            if (this.bHA.booleanValue()) {
                this.bHy.H(ic);
            } else {
                this.bHy.I(ic);
            }
        } else {
            this.bHy.H(arrayList);
        }
        this.bHy.bHw.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bHy.bHp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.bHy.bHp = null;
        this.bHy.bHt = aVar.getCount();
        ArrayList<MarkData> ZK = aVar.ZK();
        if (this.bHA.booleanValue()) {
            if (ZK != null && ZK.size() != 0) {
                this.bHy.H(ZK);
            }
        } else {
            this.bHy.I(ZK);
        }
        Iterator<MarkData> it = ZK.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.bHy.hq(i2);
                i = i2;
            }
        }
        if (this.bHy.bHw != null) {
            if (this.OE.sX().tT().qa()) {
                this.bHy.bHw.callback(0, this.bHx.getErrorString(), false);
            } else {
                this.bHy.bHw.callback(3, this.OE.getErrorString());
            }
        }
        this.bHy.bHv = false;
    }
}
