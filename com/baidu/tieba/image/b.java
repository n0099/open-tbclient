package com.baidu.tieba.image;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, e> {
    private aa OE = null;
    private String bwP;
    private String bwZ;
    private int bxa;
    private int bxb;
    final /* synthetic */ a bxc;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bxc = aVar;
        this.bwP = null;
        this.bwZ = null;
        this.bxa = 0;
        this.bxb = 0;
        this.bwZ = str2;
        this.bwP = str;
        this.bxa = i;
        this.bxb = i2;
    }

    public String getPicId() {
        return this.bwZ;
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
        this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        aa aaVar = this.OE;
        str = this.bxc.aLb;
        aaVar.o("kw", str);
        this.OE.o("tid", this.bwP);
        if (this.bwZ != null) {
            this.OE.o("pic_id", this.bwZ);
        }
        this.OE.o("next", String.valueOf(this.bxa));
        this.OE.o("prev", String.valueOf(this.bxb));
        z = this.bxc.bwV;
        if (!z) {
            this.OE.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bxc.bwS;
        BdLog.d(sb.append(z2).toString());
        z3 = this.bxc.bwS;
        if (!z3) {
            this.OE.o("r", String.valueOf(1));
        }
        this.OE.sX().tS().WD = false;
        String sw = this.OE.sw();
        if (!this.OE.sX().tT().qa()) {
            return null;
        }
        e eVar = new e();
        eVar.u(sw, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bxc.bwT = null;
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
        String hV;
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
        this.bxc.bwT = null;
        if (eVar != null) {
            this.bxc.bwU = eVar.Xu();
            this.bxc.afH = eVar.Xs();
            this.bxc.bwO = eVar.Xr();
            if (this.bwZ == null) {
                arrayList3 = this.bxc.bwN;
                arrayList3.clear();
                hashMap3 = this.bxc.bwY;
                hashMap3.clear();
            }
            LinkedList<d> Xt = eVar.Xt();
            int size = Xt.size();
            if (size <= 0) {
                this.bxc.bwR = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bxc.a(Xt.get(i5));
                    hV = this.bxc.hV(a);
                    hashMap = this.bxc.bwY;
                    if (!hashMap.containsKey(hV)) {
                        arrayList2 = this.bxc.bwN;
                        arrayList2.add(a);
                        hashMap2 = this.bxc.bwY;
                        hashMap2.put(hV, a);
                    }
                }
                d dVar = Xt.get(size - 1);
                this.bxc.bwQ = dVar.getImageID();
                i3 = this.bxc.bwU;
                if (i3 == dVar.getIndex()) {
                    this.bxc.bwR = true;
                } else {
                    this.bxc.bwR = false;
                }
            }
            z = this.bxc.bwR;
            if (z) {
                str2 = this.bxc.bwO;
                if (str2 != null) {
                    str3 = this.bxc.bwO;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bwZ != null) {
                            this.bxc.bwP = this.bwP;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bxc.bwX;
                        if (cVar == null) {
                            cVar2 = this.bxc.bwX;
                            arrayList = this.bxc.bwN;
                            i2 = this.bxc.bwU;
                            str = this.bxc.afH;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bwZ != null) {
            }
            cVar = this.bxc.bwX;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bxc.bwX;
            if (cVar3 != null) {
                if (this.OE != null) {
                    i4 = this.OE.tb();
                    str4 = this.bwZ == null ? this.OE.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bxc.bwX;
                cVar4.y(i4, str4);
            }
        }
    }
}
