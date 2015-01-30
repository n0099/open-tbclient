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
    private String bri;
    private String brs;
    private int brt;
    private int bru;
    final /* synthetic */ a brv;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.brv = aVar;
        this.bri = null;
        this.brs = null;
        this.brt = 0;
        this.bru = 0;
        this.brs = str2;
        this.bri = str;
        this.brt = i;
        this.bru = i2;
    }

    public String getPicId() {
        return this.brs;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    public e doInBackground(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        ad adVar = this.AR;
        str = this.brv.aCQ;
        adVar.o("kw", str);
        this.AR.o("tid", this.bri);
        if (this.brs != null) {
            this.AR.o("pic_id", this.brs);
        }
        this.AR.o("next", String.valueOf(this.brt));
        this.AR.o("prev", String.valueOf(this.bru));
        z = this.brv.bro;
        if (!z) {
            this.AR.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.brv.brl;
        BdLog.d(sb.append(z2).toString());
        z3 = this.brv.brl;
        if (!z3) {
            this.AR.o("r", String.valueOf(1));
        }
        this.AR.oZ().qg().Kx = false;
        String oy = this.AR.oy();
        if (!this.AR.oZ().qh().ma()) {
            return null;
        }
        e eVar = new e();
        eVar.t(oy, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.brv.brm = null;
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
        String hv;
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
        this.brv.brm = null;
        if (eVar != null) {
            this.brv.brn = eVar.TV();
            this.brv.Uv = eVar.TT();
            this.brv.brh = eVar.TS();
            if (this.brs == null) {
                arrayList3 = this.brv.brg;
                arrayList3.clear();
                hashMap3 = this.brv.brr;
                hashMap3.clear();
            }
            LinkedList<d> TU = eVar.TU();
            int size = TU.size();
            if (size <= 0) {
                this.brv.brk = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.brv.a(TU.get(i5));
                    hv = this.brv.hv(a);
                    hashMap = this.brv.brr;
                    if (!hashMap.containsKey(hv)) {
                        arrayList2 = this.brv.brg;
                        arrayList2.add(a);
                        hashMap2 = this.brv.brr;
                        hashMap2.put(hv, a);
                    }
                }
                d dVar = TU.get(size - 1);
                this.brv.brj = dVar.getImageID();
                i3 = this.brv.brn;
                if (i3 == dVar.getIndex()) {
                    this.brv.brk = true;
                } else {
                    this.brv.brk = false;
                }
            }
            z = this.brv.brk;
            if (z) {
                str2 = this.brv.brh;
                if (str2 != null) {
                    str3 = this.brv.brh;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.brs != null) {
                            this.brv.bri = this.bri;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.brv.brq;
                        if (cVar == null) {
                            cVar2 = this.brv.brq;
                            arrayList = this.brv.brg;
                            i2 = this.brv.brn;
                            str = this.brv.Uv;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.brs != null) {
            }
            cVar = this.brv.brq;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.brv.brq;
            if (cVar3 != null) {
                if (this.AR != null) {
                    i4 = this.AR.pd();
                    str4 = this.brs == null ? this.AR.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.brv.brq;
                cVar4.x(i4, str4);
            }
        }
    }
}
