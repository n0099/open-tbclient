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
    private aa Oi = null;
    private String btQ;
    private String bua;
    private int bub;
    private int buc;
    final /* synthetic */ a bud;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bud = aVar;
        this.btQ = null;
        this.bua = null;
        this.bub = 0;
        this.buc = 0;
        this.bua = str2;
        this.btQ = str;
        this.bub = i;
        this.buc = i2;
    }

    public String getPicId() {
        return this.bua;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public e doInBackground(Object... objArr) {
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        aa aaVar = this.Oi;
        str = this.bud.aIK;
        aaVar.o("kw", str);
        this.Oi.o("tid", this.btQ);
        if (this.bua != null) {
            this.Oi.o("pic_id", this.bua);
        }
        this.Oi.o("next", String.valueOf(this.bub));
        this.Oi.o("prev", String.valueOf(this.buc));
        z = this.bud.btW;
        if (!z) {
            this.Oi.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bud.btT;
        BdLog.d(sb.append(z2).toString());
        z3 = this.bud.btT;
        if (!z3) {
            this.Oi.o("r", String.valueOf(1));
        }
        this.Oi.sp().tp().VU = false;
        String rO = this.Oi.rO();
        if (!this.Oi.sp().tq().pv()) {
            return null;
        }
        e eVar = new e();
        eVar.u(rO, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.bud.btU = null;
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
        String hp;
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
        this.bud.btU = null;
        if (eVar != null) {
            this.bud.btV = eVar.VP();
            this.bud.aev = eVar.VN();
            this.bud.btP = eVar.VM();
            if (this.bua == null) {
                arrayList3 = this.bud.btO;
                arrayList3.clear();
                hashMap3 = this.bud.btZ;
                hashMap3.clear();
            }
            LinkedList<d> VO = eVar.VO();
            int size = VO.size();
            if (size <= 0) {
                this.bud.btS = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bud.a(VO.get(i5));
                    hp = this.bud.hp(a);
                    hashMap = this.bud.btZ;
                    if (!hashMap.containsKey(hp)) {
                        arrayList2 = this.bud.btO;
                        arrayList2.add(a);
                        hashMap2 = this.bud.btZ;
                        hashMap2.put(hp, a);
                    }
                }
                d dVar = VO.get(size - 1);
                this.bud.btR = dVar.getImageID();
                i3 = this.bud.btV;
                if (i3 == dVar.getIndex()) {
                    this.bud.btS = true;
                } else {
                    this.bud.btS = false;
                }
            }
            z = this.bud.btS;
            if (z) {
                str2 = this.bud.btP;
                if (str2 != null) {
                    str3 = this.bud.btP;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bua != null) {
                            this.bud.btQ = this.btQ;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bud.btY;
                        if (cVar == null) {
                            cVar2 = this.bud.btY;
                            arrayList = this.bud.btO;
                            i2 = this.bud.btV;
                            str = this.bud.aev;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bua != null) {
            }
            cVar = this.bud.btY;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bud.btY;
            if (cVar3 != null) {
                if (this.Oi != null) {
                    i4 = this.Oi.st();
                    str4 = this.bua == null ? this.Oi.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bud.btY;
                cVar4.x(i4, str4);
            }
        }
    }
}
