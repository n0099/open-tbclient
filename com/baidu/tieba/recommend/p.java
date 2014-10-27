package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<String, Integer, com.baidu.tieba.data.l> {
    private com.baidu.tieba.a.e bIm;
    private String bIn;
    final /* synthetic */ o bIo;
    private int mType;

    public p(o oVar, int i, String str) {
        this.bIo = oVar;
        this.mType = i;
        this.bIn = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        q qVar;
        q qVar2;
        super.onPreExecute();
        qVar = this.bIo.bIh;
        if (qVar != null) {
            qVar2 = this.bIo.bIh;
            qVar2.abJ();
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
                this.bIm = new com.baidu.tieba.a.e(this.mType == 0);
                com.baidu.tieba.a.e eVar = this.bIm;
                String str2 = this.bIn;
                str = this.bIo.stType;
                ab = eVar.ab(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.t<String> wO = aj.wk().wO();
                if (wO != null) {
                    ab = wO.get("dailyrecommend");
                    break;
                }
            default:
                ab = null;
                break;
        }
        if (ab != null) {
            if (this.mType != 1 && this.bIm != null && this.bIm.jq()) {
                if (this.bIm.getErrorCode() == 0) {
                    if (this.mType == 0) {
                        this.bIo.hl(ab);
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
        if (this.mType == 0 && lVar.yG().size() > 0) {
            lVar.yG().get(0).bo(true);
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
            qVar = this.bIo.bIh;
            if (qVar != null) {
                if (this.mType != 1) {
                    qVar3 = this.bIo.bIh;
                    String sb = new StringBuilder(String.valueOf(this.bIm.getErrorCode())).toString();
                    lVar3 = this.bIo.bIi;
                    qVar3.a(false, sb, lVar3, this.mType, false);
                    return;
                }
                qVar2 = this.bIo.bIh;
                lVar2 = this.bIo.bIi;
                qVar2.a(false, "db no data!", lVar2, this.mType, false);
                return;
            }
            return;
        }
        boolean z2 = lVar.yG().size() > 0;
        if (this.mType == 1) {
            this.bIo.bIi = lVar;
            this.bIo.bIl = true;
        } else {
            z = this.bIo.bIl;
            if (z) {
                this.bIo.bIi = new com.baidu.tieba.data.l();
                this.bIo.bIl = false;
            }
            if (this.mType == 0) {
                this.bIo.bIi = lVar;
            } else {
                lVar4 = this.bIo.bIi;
                lVar4.a(lVar);
            }
        }
        qVar4 = this.bIo.bIh;
        if (qVar4 != null) {
            qVar5 = this.bIo.bIh;
            lVar5 = this.bIo.bIi;
            qVar5.a(true, null, lVar5, this.mType, z2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.bIm != null) {
            this.bIm.cancel();
            this.bIm = null;
        }
    }
}
