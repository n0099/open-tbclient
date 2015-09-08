package com.baidu.tieba.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.FineFrsPage.EverydayThread;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class e {
    private boolean cAS;
    private List<a> cBp;
    private long cBq;
    private int cBr;
    private boolean hasMore;
    private final String tag;
    private List<Object> axA = new ArrayList();
    private boolean cBs = false;
    private boolean cBt = false;
    private boolean cBu = false;

    public e(String str) {
        this.tag = str;
        if (TextUtils.equals(this.tag, "头条")) {
            this.cAS = true;
        } else {
            this.cAS = false;
        }
    }

    public boolean anK() {
        return this.cAS;
    }

    public void jO(int i) {
        this.cBr = i;
    }

    public int anL() {
        return this.cBr;
    }

    public boolean anM() {
        return this.cBt;
    }

    public boolean anN() {
        return this.cBu;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, g gVar, boolean z2) {
        if (z) {
            this.cBu = true;
        } else {
            this.cBt = true;
        }
        if (gVar != null) {
            if (!z2) {
                this.cBs = false;
            }
            this.hasMore = gVar.getHasMore();
            List<Object> a = a(z2, gVar);
            if (z2) {
                this.axA.addAll(a);
                return;
            }
            this.axA = a;
            if (this.axA != null && this.axA.size() > 0) {
                this.cBp = gVar.anR();
            } else {
                this.cBp = null;
            }
        }
    }

    private boolean b(FineThreadInfo fineThreadInfo) {
        int size;
        if (fineThreadInfo != null && (size = this.axA.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.axA.get(i);
                if ((obj instanceof FineThreadInfo) && fineThreadInfo.ftid == ((FineThreadInfo) obj).ftid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private List<Object> a(boolean z, g gVar) {
        List<Hot_Thread> anS;
        ArrayList arrayList = new ArrayList();
        if (gVar == null || gVar.anT() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : gVar.anT()) {
            if (everydayThread.show_time != null) {
                i = everydayThread.show_time.intValue();
            }
            if (this.cAS && ((z || !arrayList.isEmpty()) && i != this.cBq)) {
                str = j.d(new Date(i * 1000));
                arrayList.add(str);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (this.cAS && StringUtils.isNull(str)) {
                    str = j.d(new Date(i * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null && (!z || !b(fineThreadInfo))) {
                        b bVar = new b();
                        bVar.a(fineThreadInfo);
                        bVar.kB(str);
                        bVar.setShowImage(gVar.anV());
                        bVar.fD(i2 != size + (-1));
                        if (bVar.anH() != 33) {
                            arrayList.add(bVar);
                        } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            arrayList.add(bVar);
                        }
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cBq && !this.cBs && (anS = gVar.anS()) != null && anS.size() > 0) {
            this.cBs = true;
            arrayList.add(new d("text_type_title", str));
            arrayList.addAll(a(anS, str, gVar.anV()));
            arrayList.add(new d("text_type_check_more", str));
        }
        this.cBq = i;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Object obj = arrayList.get(arrayList.size() - 1);
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (this.cAS) {
                bVar2.fD(false);
            } else {
                bVar2.fD(true);
            }
        }
        return arrayList;
    }

    private List<c> a(List<Hot_Thread> list, String str, boolean z) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Hot_Thread hot_Thread : list) {
            if (hot_Thread != null) {
                c cVar = new c(hot_Thread, str);
                cVar.setShowImage(z);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public List<Object> anO() {
        return this.axA;
    }

    public List<a> anP() {
        return this.cBp;
    }
}
