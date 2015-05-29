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
    private i bHw;
    final /* synthetic */ a bHx;
    private int offset;
    private aa OE = null;
    private String bHy = null;
    Boolean bHz = false;

    public c(a aVar, int i) {
        this.bHx = aVar;
        this.offset = 0;
        this.bHw = null;
        this.offset = i;
        this.bHw = new i();
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
        this.bHz = boolArr[0];
        a aVar = new a();
        if (this.bHz.booleanValue()) {
            t<String> ck = com.baidu.tbadk.core.b.a.rI().ck("tb.my_bookmarks");
            if (ck != null) {
                publishProgress(ck.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList3 = this.bHx.bHr;
            if (arrayList3 == null) {
                this.bHx.bHr = new ArrayList();
            } else {
                arrayList4 = this.bHx.bHr;
                arrayList4.clear();
            }
            this.bHx.bHs = 0;
        }
        this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.OE.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.bHx.bHu;
        if (z) {
            this.OE.o("offset", String.valueOf(0));
        } else {
            this.OE.o("offset", String.valueOf(this.offset));
        }
        this.OE.o("rn", String.valueOf(20));
        this.bHy = this.OE.sw();
        this.bHw.parserJson(this.bHy);
        if (this.OE.sX().tT().qa()) {
            aVar.ib(this.bHy);
            if (this.offset == 0) {
                arrayList = this.bHx.bHr;
                if (arrayList == null) {
                    this.bHx.bHr = new ArrayList();
                } else {
                    arrayList2 = this.bHx.bHr;
                    arrayList2.clear();
                }
                this.bHx.bHs = 0;
                if (this.bHz.booleanValue()) {
                    gc(this.bHy);
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
            ic = this.bHx.ic(str);
            if (this.bHz.booleanValue()) {
                this.bHx.H(ic);
            } else {
                this.bHx.I(ic);
            }
        } else {
            this.bHx.H(arrayList);
        }
        this.bHx.bHv.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bHx.bHo = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.bHx.bHo = null;
        this.bHx.bHs = aVar.getCount();
        ArrayList<MarkData> ZJ = aVar.ZJ();
        if (this.bHz.booleanValue()) {
            if (ZJ != null && ZJ.size() != 0) {
                this.bHx.H(ZJ);
            }
        } else {
            this.bHx.I(ZJ);
        }
        Iterator<MarkData> it = ZJ.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.bHx.hq(i2);
                i = i2;
            }
        }
        if (this.bHx.bHv != null) {
            if (this.OE.sX().tT().qa()) {
                this.bHx.bHv.callback(0, this.bHw.getErrorString(), false);
            } else {
                this.bHx.bHv.callback(3, this.OE.getErrorString());
            }
        }
        this.bHx.bHu = false;
    }
}
