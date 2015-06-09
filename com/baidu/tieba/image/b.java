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
    private String bwQ;
    private String bxa;
    private int bxb;
    private int bxc;
    final /* synthetic */ a bxd;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bxd = aVar;
        this.bwQ = null;
        this.bxa = null;
        this.bxb = 0;
        this.bxc = 0;
        this.bxa = str2;
        this.bwQ = str;
        this.bxb = i;
        this.bxc = i2;
    }

    public String getPicId() {
        return this.bxa;
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
        str = this.bxd.aLc;
        aaVar.o("kw", str);
        this.OE.o("tid", this.bwQ);
        if (this.bxa != null) {
            this.OE.o("pic_id", this.bxa);
        }
        this.OE.o("next", String.valueOf(this.bxb));
        this.OE.o("prev", String.valueOf(this.bxc));
        z = this.bxd.bwW;
        if (!z) {
            this.OE.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bxd.bwT;
        BdLog.d(sb.append(z2).toString());
        z3 = this.bxd.bwT;
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
        this.bxd.bwU = null;
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
        this.bxd.bwU = null;
        if (eVar != null) {
            this.bxd.bwV = eVar.Xv();
            this.bxd.afH = eVar.Xt();
            this.bxd.bwP = eVar.Xs();
            if (this.bxa == null) {
                arrayList3 = this.bxd.bwO;
                arrayList3.clear();
                hashMap3 = this.bxd.bwZ;
                hashMap3.clear();
            }
            LinkedList<d> Xu = eVar.Xu();
            int size = Xu.size();
            if (size <= 0) {
                this.bxd.bwS = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bxd.a(Xu.get(i5));
                    hV = this.bxd.hV(a);
                    hashMap = this.bxd.bwZ;
                    if (!hashMap.containsKey(hV)) {
                        arrayList2 = this.bxd.bwO;
                        arrayList2.add(a);
                        hashMap2 = this.bxd.bwZ;
                        hashMap2.put(hV, a);
                    }
                }
                d dVar = Xu.get(size - 1);
                this.bxd.bwR = dVar.getImageID();
                i3 = this.bxd.bwV;
                if (i3 == dVar.getIndex()) {
                    this.bxd.bwS = true;
                } else {
                    this.bxd.bwS = false;
                }
            }
            z = this.bxd.bwS;
            if (z) {
                str2 = this.bxd.bwP;
                if (str2 != null) {
                    str3 = this.bxd.bwP;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bxa != null) {
                            this.bxd.bwQ = this.bwQ;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bxd.bwY;
                        if (cVar == null) {
                            cVar2 = this.bxd.bwY;
                            arrayList = this.bxd.bwO;
                            i2 = this.bxd.bwV;
                            str = this.bxd.afH;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bxa != null) {
            }
            cVar = this.bxd.bwY;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bxd.bwY;
            if (cVar3 != null) {
                if (this.OE != null) {
                    i4 = this.OE.tb();
                    str4 = this.bxa == null ? this.OE.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bxd.bwY;
                cVar4.y(i4, str4);
            }
        }
    }
}
