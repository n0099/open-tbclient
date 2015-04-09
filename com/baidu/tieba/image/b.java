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
    private aa Ok = null;
    private String buh;
    private String bur;
    private int bus;
    private int but;
    final /* synthetic */ a buu;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.buu = aVar;
        this.buh = null;
        this.bur = null;
        this.bus = 0;
        this.but = 0;
        this.bur = str2;
        this.buh = str;
        this.bus = i;
        this.but = i2;
    }

    public String getPicId() {
        return this.bur;
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
        this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.IMAGE_PB_ADDRESS);
        aa aaVar = this.Ok;
        str = this.buu.aIS;
        aaVar.o("kw", str);
        this.Ok.o("tid", this.buh);
        if (this.bur != null) {
            this.Ok.o("pic_id", this.bur);
        }
        this.Ok.o("next", String.valueOf(this.bus));
        this.Ok.o("prev", String.valueOf(this.but));
        z = this.buu.bun;
        if (!z) {
            this.Ok.o("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.buu.buk;
        BdLog.d(sb.append(z2).toString());
        z3 = this.buu.buk;
        if (!z3) {
            this.Ok.o("r", String.valueOf(1));
        }
        this.Ok.sp().tp().VW = false;
        String rO = this.Ok.rO();
        if (!this.Ok.sp().tq().pv()) {
            return null;
        }
        e eVar = new e();
        eVar.u(rO, true);
        return eVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.buu.bul = null;
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
        this.buu.bul = null;
        if (eVar != null) {
            this.buu.bum = eVar.Wc();
            this.buu.aeD = eVar.Wa();
            this.buu.bug = eVar.VZ();
            if (this.bur == null) {
                arrayList3 = this.buu.bue;
                arrayList3.clear();
                hashMap3 = this.buu.buq;
                hashMap3.clear();
            }
            LinkedList<d> Wb = eVar.Wb();
            int size = Wb.size();
            if (size <= 0) {
                this.buu.buj = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.buu.a(Wb.get(i5));
                    hs = this.buu.hs(a);
                    hashMap = this.buu.buq;
                    if (!hashMap.containsKey(hs)) {
                        arrayList2 = this.buu.bue;
                        arrayList2.add(a);
                        hashMap2 = this.buu.buq;
                        hashMap2.put(hs, a);
                    }
                }
                d dVar = Wb.get(size - 1);
                this.buu.bui = dVar.getImageID();
                i3 = this.buu.bum;
                if (i3 == dVar.getIndex()) {
                    this.buu.buj = true;
                } else {
                    this.buu.buj = false;
                }
            }
            z = this.buu.buj;
            if (z) {
                str2 = this.buu.bug;
                if (str2 != null) {
                    str3 = this.buu.bug;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bur != null) {
                            this.buu.buh = this.buh;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.buu.bup;
                        if (cVar == null) {
                            cVar2 = this.buu.bup;
                            arrayList = this.buu.bue;
                            i2 = this.buu.bum;
                            str = this.buu.aeD;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bur != null) {
            }
            cVar = this.buu.bup;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.buu.bup;
            if (cVar3 != null) {
                if (this.Ok != null) {
                    i4 = this.Ok.st();
                    str4 = this.bur == null ? this.Ok.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.buu.bup;
                cVar4.x(i4, str4);
            }
        }
    }
}
