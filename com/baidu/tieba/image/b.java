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
    private String bkF;
    private int bkG;
    private int bkH;
    final /* synthetic */ a bkI;
    private String bkv;
    private ac mNetWork = null;

    public b(a aVar, String str, String str2, int i, int i2) {
        this.bkI = aVar;
        this.bkv = null;
        this.bkF = null;
        this.bkG = 0;
        this.bkH = 0;
        this.bkF = str2;
        this.bkv = str;
        this.bkG = i;
        this.bkH = i2;
    }

    public String getPicId() {
        return this.bkF;
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
        str = this.bkI.aAx;
        acVar.k("kw", str);
        this.mNetWork.k("tid", this.bkv);
        if (this.bkF != null) {
            this.mNetWork.k("pic_id", this.bkF);
        }
        this.mNetWork.k("next", String.valueOf(this.bkG));
        this.mNetWork.k("prev", String.valueOf(this.bkH));
        z = this.bkI.bkB;
        if (!z) {
            this.mNetWork.k("not_see_lz", String.valueOf(1));
        }
        StringBuilder sb = new StringBuilder("mIsReserver=");
        z2 = this.bkI.bky;
        BdLog.e(sb.append(z2).toString());
        z3 = this.bkI.bky;
        if (!z3) {
            this.mNetWork.k("r", String.valueOf(1));
        }
        this.mNetWork.mc().na().FU = false;
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
        this.bkI.bkz = null;
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
        this.bkI.bkz = null;
        if (wVar != null) {
            this.bkI.bkA = wVar.zw();
            this.bkI.Od = wVar.zu();
            this.bkI.bku = wVar.zt();
            if (this.bkF == null) {
                arrayList3 = this.bkI.bkt;
                arrayList3.clear();
                hashMap3 = this.bkI.bkE;
                hashMap3.clear();
            }
            LinkedList<v> zv = wVar.zv();
            int size = zv.size();
            if (size <= 0) {
                this.bkI.bkx = true;
            } else {
                for (int i5 = 0; i5 < size; i5++) {
                    a = this.bkI.a(zv.get(i5));
                    gJ = this.bkI.gJ(a);
                    hashMap = this.bkI.bkE;
                    if (!hashMap.containsKey(gJ)) {
                        arrayList2 = this.bkI.bkt;
                        arrayList2.add(a);
                        hashMap2 = this.bkI.bkE;
                        hashMap2.put(gJ, a);
                    }
                }
                v vVar = zv.get(size - 1);
                this.bkI.bkw = vVar.zs();
                i3 = this.bkI.bkA;
                if (i3 == vVar.getIndex()) {
                    this.bkI.bkx = true;
                } else {
                    this.bkI.bkx = false;
                }
            }
            z = this.bkI.bkx;
            if (z) {
                str2 = this.bkI.bku;
                if (str2 != null) {
                    str3 = this.bkI.bku;
                    if (str3.length() > 0) {
                        z2 = true;
                        if (this.bkF != null) {
                            this.bkI.bkv = this.bkv;
                            z3 = true;
                            i = 0;
                        } else {
                            z3 = false;
                            i = -1;
                        }
                        cVar = this.bkI.bkD;
                        if (cVar == null) {
                            cVar2 = this.bkI.bkD;
                            arrayList = this.bkI.bkt;
                            i2 = this.bkI.bkA;
                            str = this.bkI.Od;
                            cVar2.a(arrayList, i, i2, z2, str, z3);
                            return;
                        }
                        return;
                    }
                }
            }
            z2 = false;
            if (this.bkF != null) {
            }
            cVar = this.bkI.bkD;
            if (cVar == null) {
            }
        } else {
            cVar3 = this.bkI.bkD;
            if (cVar3 != null) {
                if (this.mNetWork != null) {
                    i4 = this.mNetWork.mg();
                    str4 = this.bkF == null ? this.mNetWork.getErrorString() : null;
                } else {
                    i4 = -1;
                    str4 = null;
                }
                cVar4 = this.bkI.bkD;
                cVar4.n(i4, str4);
            }
        }
    }
}
