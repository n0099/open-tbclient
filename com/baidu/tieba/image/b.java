package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, e> {
    private ad AR = null;
    private String bpK;
    private String bpU;
    private int bpV;
    private int bpW;
    final /* synthetic */ a bpX;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bpX = aVar;
        this.bpK = null;
        this.bpU = null;
        this.bpV = 0;
        this.bpW = 0;
        this.bpU = str2;
        this.bpK = str;
        this.bpV = i;
        this.bpW = i2;
    }

    public String getPicId() {
        return this.bpU;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public e doInBackground(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        ad adVar = this.AR;
        str = this.bpX.aBP;
        adVar.o("kw", str);
        this.AR.o("tid", this.bpK);
        if (this.bpU != null) {
            this.AR.o("pic_id", this.bpU);
        }
        this.AR.o("next", String.valueOf(this.bpV));
        this.AR.o("prev", String.valueOf(this.bpW));
        z = this.bpX.bpQ;
        if (!z) {
            this.AR.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bpX.bpN;
        BdLog.d(sb.append(z2).toString());
        z3 = this.bpX.bpN;
        if (!z3) {
            this.AR.o("r", String.valueOf(1));
        }
        this.AR.oW().pV().Ke = false;
        String ov = this.AR.ov();
        if (!this.AR.oW().pW().ma()) {
            return null;
        }
        e eVar = new e();
        eVar.t(ov, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.AR != null) {
            this.AR.dL();
        }
        this.bpX.bpO = null;
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
    public void onPostExecute(e eVar) {
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
        String ho;
        HashMap hashMap;
        ArrayList arrayList2;
        HashMap hashMap2;
        ArrayList arrayList3;
        HashMap hashMap3;
        c cVar3;
        int i4;
        String str4;
        c cVar4;
        super.onPostExecute(eVar);
        this.bpX.bpO = null;
        if (eVar != null) {
            this.bpX.bpP = eVar.Tz();
            this.bpX.TQ = eVar.Tx();
            this.bpX.bpJ = eVar.Tw();
            if (this.bpU == null) {
                arrayList3 = this.bpX.bpI;
                arrayList3.clear();
                hashMap3 = this.bpX.bpT;
                hashMap3.clear();
            }
            LinkedList<d> Ty = eVar.Ty();
            int size = Ty.size();
            if (size <= 0) {
                this.bpX.bpM = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bpX.a(Ty.get(i5));
                    ho = this.bpX.ho(a);
                    hashMap = this.bpX.bpT;
                    if (!hashMap.containsKey(ho)) {
                        arrayList2 = this.bpX.bpI;
                        arrayList2.add(a);
                        hashMap2 = this.bpX.bpT;
                        hashMap2.put(ho, a);
                    }
                }
                d dVar = Ty.get(size - 1);
                this.bpX.bpL = dVar.getImageID();
                i3 = this.bpX.bpP;
                if (i3 == dVar.getIndex()) {
                    this.bpX.bpM = true;
                } else {
                    this.bpX.bpM = false;
                }
            }
            z = this.bpX.bpM;
            if (z) {
                str2 = this.bpX.bpJ;
                if (str2 != null) {
                    str3 = this.bpX.bpJ;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bpU != null) {
                            this.bpX.bpK = this.bpK;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bpX.bpS;
                        if (cVar == null) {
                            cVar2 = this.bpX.bpS;
                            arrayList = this.bpX.bpI;
                            i2 = this.bpX.bpP;
                            str = this.bpX.TQ;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bpU != null) {
            }
            cVar = this.bpX.bpS;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bpX.bpS;
            if (cVar3 != null) {
                if (this.AR != null) {
                    i4 = this.AR.pa();
                    str4 = this.bpU == null ? this.AR.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bpX.bpS;
                cVar4.x(i4, str4);
            }
        }
    }
}
