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
    private ad AO = null;
    private String brh;
    private String brr;
    private int brs;
    private int brt;
    final /* synthetic */ a bru;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bru = aVar;
        this.brh = null;
        this.brr = null;
        this.brs = 0;
        this.brt = 0;
        this.brr = str2;
        this.brh = str;
        this.brs = i;
        this.brt = i2;
    }

    public String getPicId() {
        return this.brr;
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
        this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        ad adVar = this.AO;
        str = this.bru.aCN;
        adVar.o("kw", str);
        this.AO.o("tid", this.brh);
        if (this.brr != null) {
            this.AO.o("pic_id", this.brr);
        }
        this.AO.o("next", String.valueOf(this.brs));
        this.AO.o("prev", String.valueOf(this.brt));
        z = this.bru.brn;
        if (!z) {
            this.AO.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bru.brk;
        BdLog.d(sb.append(z2).toString());
        z3 = this.bru.brk;
        if (!z3) {
            this.AO.o("r", String.valueOf(1));
        }
        this.AO.oS().pZ().Ku = false;
        String or = this.AO.or();
        if (!this.AO.oS().qa().lT()) {
            return null;
        }
        e eVar = new e();
        eVar.t(or, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.bru.brl = null;
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
        String hs;
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
        this.bru.brl = null;
        if (eVar != null) {
            this.bru.brm = eVar.TQ();
            this.bru.Us = eVar.TO();
            this.bru.brg = eVar.TN();
            if (this.brr == null) {
                arrayList3 = this.bru.brf;
                arrayList3.clear();
                hashMap3 = this.bru.brq;
                hashMap3.clear();
            }
            LinkedList<d> TP = eVar.TP();
            int size = TP.size();
            if (size <= 0) {
                this.bru.brj = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bru.a(TP.get(i5));
                    hs = this.bru.hs(a);
                    hashMap = this.bru.brq;
                    if (!hashMap.containsKey(hs)) {
                        arrayList2 = this.bru.brf;
                        arrayList2.add(a);
                        hashMap2 = this.bru.brq;
                        hashMap2.put(hs, a);
                    }
                }
                d dVar = TP.get(size - 1);
                this.bru.bri = dVar.getImageID();
                i3 = this.bru.brm;
                if (i3 == dVar.getIndex()) {
                    this.bru.brj = true;
                } else {
                    this.bru.brj = false;
                }
            }
            z = this.bru.brj;
            if (z) {
                str2 = this.bru.brg;
                if (str2 != null) {
                    str3 = this.bru.brg;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.brr != null) {
                            this.bru.brh = this.brh;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bru.brp;
                        if (cVar == null) {
                            cVar2 = this.bru.brp;
                            arrayList = this.bru.brf;
                            i2 = this.bru.brm;
                            str = this.bru.Us;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.brr != null) {
            }
            cVar = this.bru.brp;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bru.brp;
            if (cVar3 != null) {
                if (this.AO != null) {
                    i4 = this.AO.oW();
                    str4 = this.brr == null ? this.AO.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bru.brp;
                cVar4.x(i4, str4);
            }
        }
    }
}
