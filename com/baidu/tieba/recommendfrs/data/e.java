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
    private List<a> cIQ;
    private long cIR;
    private int cIS;
    private boolean cIt;
    private boolean hasMore;
    private final String tag;
    private List<Object> awa = new ArrayList();
    private boolean cIT = false;
    private boolean cIU = false;
    private boolean cIV = false;

    public e(String str) {
        this.tag = str;
        if (TextUtils.equals(this.tag, "头条")) {
            this.cIt = true;
        } else {
            this.cIt = false;
        }
    }

    public boolean aqe() {
        return this.cIt;
    }

    public void kp(int i) {
        this.cIS = i;
    }

    public int aqf() {
        return this.cIS;
    }

    public boolean aqg() {
        return this.cIU;
    }

    public boolean aqh() {
        return this.cIV;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, g gVar, boolean z2) {
        if (z) {
            this.cIV = true;
        } else {
            this.cIU = true;
        }
        if (gVar != null) {
            if (!z2) {
                this.cIT = false;
            }
            this.hasMore = gVar.getHasMore();
            List<Object> a = a(z2, gVar);
            if (z2) {
                this.awa.addAll(a);
                return;
            }
            this.awa = a;
            if (this.awa != null && this.awa.size() > 0) {
                this.cIQ = gVar.aql();
            } else {
                this.cIQ = null;
            }
        }
    }

    private boolean b(FineThreadInfo fineThreadInfo) {
        int size;
        if (fineThreadInfo != null && (size = this.awa.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.awa.get(i);
                if ((obj instanceof FineThreadInfo) && fineThreadInfo.ftid == ((FineThreadInfo) obj).ftid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private List<Object> a(boolean z, g gVar) {
        List<Hot_Thread> aqm;
        ArrayList arrayList = new ArrayList();
        if (gVar == null || gVar.aqn() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : gVar.aqn()) {
            if (everydayThread.show_time != null) {
                i = everydayThread.show_time.intValue();
            }
            if (this.cIt && ((z || !arrayList.isEmpty()) && i != this.cIR)) {
                str = j.d(new Date(i * 1000));
                arrayList.add(str);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (this.cIt && StringUtils.isNull(str)) {
                    str = j.d(new Date(i * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null && (!z || !b(fineThreadInfo))) {
                        b bVar = new b();
                        bVar.a(fineThreadInfo);
                        bVar.lc(str);
                        bVar.setShowImage(gVar.aqp());
                        bVar.fO(i2 != size + (-1));
                        if (bVar.aqb() != 33) {
                            arrayList.add(bVar);
                        } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            arrayList.add(bVar);
                        }
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cIR && !this.cIT && (aqm = gVar.aqm()) != null && aqm.size() > 0) {
            this.cIT = true;
            arrayList.add(new d("text_type_title", str));
            arrayList.addAll(a(aqm, str, gVar.aqp()));
            arrayList.add(new d("text_type_check_more", str));
        }
        this.cIR = i;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Object obj = arrayList.get(arrayList.size() - 1);
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (this.cIt) {
                bVar2.fO(false);
            } else {
                bVar2.fO(true);
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

    public List<Object> aqi() {
        return this.awa;
    }

    public List<a> aqj() {
        return this.cIQ;
    }
}
