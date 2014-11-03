package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, com.baidu.tieba.data.l> {
    private com.baidu.tieba.a.e bIA;
    private String bIB;
    final /* synthetic */ o bIC;
    private int mType;

    public p(o oVar, int i, String str) {
        this.bIC = oVar;
        this.mType = i;
        this.bIB = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        q qVar;
        q qVar2;
        super.onPreExecute();
        qVar = this.bIC.bIv;
        if (qVar != null) {
            qVar2 = this.bIC.bIv;
            qVar2.abM();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public com.baidu.tieba.data.l doInBackground(String... strArr) {
        String str;
        String ab;
        switch (this.mType) {
            case 0:
            case 2:
                this.bIA = new com.baidu.tieba.a.e(this.mType == 0);
                com.baidu.tieba.a.e eVar = this.bIA;
                String str2 = this.bIB;
                str = this.bIC.stType;
                ab = eVar.ab(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.t<String> wQ = aj.wm().wQ();
                if (wQ != null) {
                    ab = wQ.get("dailyrecommend");
                    break;
                }
            default:
                ab = null;
                break;
        }
        if (ab != null) {
            if (this.mType != 1 && this.bIA != null && this.bIA.jq()) {
                if (this.bIA.getErrorCode() == 0) {
                    if (this.mType == 0) {
                        this.bIC.hl(ab);
                    }
                    return hn(ab);
                }
            } else if (this.mType == 1) {
                return hn(ab);
            }
        }
        return null;
    }

    private com.baidu.tieba.data.l hn(String str) {
        com.baidu.tieba.data.l lVar = new com.baidu.tieba.data.l();
        lVar.parserJson(str);
        if (this.mType == 0 && lVar.yI().size() > 0) {
            lVar.yI().get(0).bo(true);
        }
        return lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(com.baidu.tieba.data.l lVar) {
        q qVar;
        q qVar2;
        com.baidu.tieba.data.l lVar2;
        q qVar3;
        com.baidu.tieba.data.l lVar3;
        boolean z;
        com.baidu.tieba.data.l lVar4;
        q qVar4;
        q qVar5;
        com.baidu.tieba.data.l lVar5;
        super.onPostExecute(lVar);
        if (lVar == null) {
            qVar = this.bIC.bIv;
            if (qVar != null) {
                if (this.mType != 1) {
                    qVar3 = this.bIC.bIv;
                    String sb = new StringBuilder(String.valueOf(this.bIA.getErrorCode())).toString();
                    lVar3 = this.bIC.bIw;
                    qVar3.a(false, sb, lVar3, this.mType, false);
                    return;
                }
                qVar2 = this.bIC.bIv;
                lVar2 = this.bIC.bIw;
                qVar2.a(false, "db no data!", lVar2, this.mType, false);
                return;
            }
            return;
        }
        boolean z2 = lVar.yI().size() > 0;
        if (this.mType == 1) {
            this.bIC.bIw = lVar;
            this.bIC.bIz = true;
        } else {
            z = this.bIC.bIz;
            if (z) {
                this.bIC.bIw = new com.baidu.tieba.data.l();
                this.bIC.bIz = false;
            }
            if (this.mType == 0) {
                this.bIC.bIw = lVar;
            } else {
                lVar4 = this.bIC.bIw;
                lVar4.a(lVar);
            }
        }
        qVar4 = this.bIC.bIv;
        if (qVar4 != null) {
            qVar5 = this.bIC.bIv;
            lVar5 = this.bIC.bIw;
            qVar5.a(true, null, lVar5, this.mType, z2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.bIA != null) {
            this.bIA.cancel();
            this.bIA = null;
        }
    }
}
