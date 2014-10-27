package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tieba.data.v;
import com.baidu.tieba.data.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, w> {
    private String bkh;
    private String bkr;
    private int bks;
    private int bkt;
    final /* synthetic */ a bku;
    private ac mNetWork = null;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bku = aVar;
        this.bkh = null;
        this.bkr = null;
        this.bks = 0;
        this.bkt = 0;
        this.bkr = str2;
        this.bkh = str;
        this.bks = i;
        this.bkt = i2;
    }

    public String getPicId() {
        return this.bkr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: r */
    public w doInBackground(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        this.mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/pb/picpage");
        ac acVar = this.mNetWork;
        str = this.bku.aAn;
        acVar.k("kw", str);
        this.mNetWork.k("tid", this.bkh);
        if (this.bkr != null) {
            this.mNetWork.k("pic_id", this.bkr);
        }
        this.mNetWork.k("next", String.valueOf(this.bks));
        this.mNetWork.k("prev", String.valueOf(this.bkt));
        z = this.bku.bkn;
        if (!z) {
            this.mNetWork.k("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bku.bkk;
        BdLog.e(sb.append(z2).toString());
        z3 = this.bku.bkk;
        if (!z3) {
            this.mNetWork.k("r", String.valueOf(1));
        }
        this.mNetWork.mc().na().FT = false;
        String lA = this.mNetWork.lA();
        if (!this.mNetWork.mc().nb().jq()) {
            return null;
        }
        w wVar = new w();
        wVar.s(lA, true);
        return wVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.bku.bkl = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(w wVar) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        c cVar;
        c cVar2;
        ArrayList<String> arrayList;
        int i2;
        String str;
        String str2;
        String str3;
        int i3;
        String a;
        String gJ;
        HashMap hashMap;
        ArrayList arrayList2;
        HashMap hashMap2;
        ArrayList arrayList3;
        HashMap hashMap3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        super.onPostExecute(wVar);
        this.bku.bkl = null;
        if (wVar != null) {
            this.bku.bkm = wVar.zu();
            this.bku.NZ = wVar.zs();
            this.bku.bkg = wVar.zr();
            if (this.bkr == null) {
                arrayList3 = this.bku.bkf;
                arrayList3.clear();
                hashMap3 = this.bku.bkq;
                hashMap3.clear();
            }
            LinkedList<v> zt = wVar.zt();
            int size = zt.size();
            if (size <= 0) {
                this.bku.bkj = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bku.a(zt.get(i5));
                    gJ = this.bku.gJ(a);
                    hashMap = this.bku.bkq;
                    if (!hashMap.containsKey(gJ)) {
                        arrayList2 = this.bku.bkf;
                        arrayList2.add(a);
                        hashMap2 = this.bku.bkq;
                        hashMap2.put(gJ, a);
                    }
                }
                v vVar = zt.get(size - 1);
                this.bku.bki = vVar.zq();
                i3 = this.bku.bkm;
                if (i3 == vVar.getIndex()) {
                    this.bku.bkj = true;
                } else {
                    this.bku.bkj = false;
                }
            }
            z = this.bku.bkj;
            if (z) {
                str2 = this.bku.bkg;
                if (str2 != null) {
                    str3 = this.bku.bkg;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bkr != null) {
                            this.bku.bkh = this.bkh;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bku.bkp;
                        if (cVar == null) {
                            cVar2 = this.bku.bkp;
                            arrayList = this.bku.bkf;
                            i2 = this.bku.bkm;
                            str = this.bku.NZ;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bkr != null) {
            }
            cVar = this.bku.bkp;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bku.bkp;
            if (cVar3 != null) {
                if (this.mNetWork != null) {
                    i4 = this.mNetWork.mg();
                    str4 = this.bkr == null ? this.mNetWork.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bku.bkp;
                cVar4.n(i4, str4);
            }
        }
    }
}
