package com.baidu.tieba.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.FineFrsPage.EverydayThread;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class e {
    private List<a> csX;
    private long csY;
    private int csZ;
    private boolean csz;
    private boolean hasMore;
    private final String tag;
    private List<Object> avS = new ArrayList();
    private boolean cta = false;
    private boolean ctb = false;

    public e(String str) {
        this.tag = str;
        if (TextUtils.equals(this.tag, "头条")) {
            this.csz = true;
        } else {
            this.csz = false;
        }
    }

    public boolean ajE() {
        return this.csz;
    }

    public void je(int i) {
        this.csZ = i;
    }

    public int ajF() {
        return this.csZ;
    }

    public boolean ajG() {
        return this.cta;
    }

    public boolean ajH() {
        return this.ctb;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, g gVar, boolean z2) {
        if (z) {
            this.ctb = true;
        } else {
            this.cta = true;
        }
        if (gVar != null) {
            this.hasMore = gVar.getHasMore();
            List<Object> a = a(z2, gVar);
            if (z2) {
                this.avS.addAll(a);
                return;
            }
            this.avS = a;
            if (this.avS != null && this.avS.size() > 0) {
                this.csX = gVar.ajL();
            } else {
                this.csX = null;
            }
        }
    }

    private boolean b(FineThreadInfo fineThreadInfo) {
        int size;
        if (fineThreadInfo != null && (size = this.avS.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.avS.get(i);
                if ((obj instanceof FineThreadInfo) && fineThreadInfo.ftid == ((FineThreadInfo) obj).ftid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private List<Object> a(boolean z, g gVar) {
        List<Hot_Thread> ajM;
        ArrayList arrayList = new ArrayList();
        if (gVar == null || gVar.ajN() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : gVar.ajN()) {
            if (everydayThread.show_time != null) {
                i = everydayThread.show_time.intValue();
            }
            if (this.csz && ((z || !arrayList.isEmpty()) && i != this.csY)) {
                str = j.d(new Date(i * 1000));
                arrayList.add(str);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (this.csz && StringUtils.isNull(str)) {
                    str = j.d(new Date(i * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null && (!z || !b(fineThreadInfo))) {
                        b bVar = new b();
                        bVar.a(fineThreadInfo);
                        bVar.jW(str);
                        bVar.eS(gVar.ajP());
                        bVar.eR(i2 != size + (-1));
                        arrayList.add(bVar);
                    }
                    i2++;
                }
            }
        }
        if (i >= this.csY && (ajM = gVar.ajM()) != null && ajM.size() > 0) {
            arrayList.add(new d("text_type_title", str));
            arrayList.addAll(a(ajM, str, gVar.ajP()));
            arrayList.add(new d("text_type_check_more", str));
        }
        this.csY = i;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Object obj = arrayList.get(arrayList.size() - 1);
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (this.csz) {
                bVar2.eR(false);
            } else {
                bVar2.eR(true);
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
                cVar.eS(z);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public List<Object> ajI() {
        return this.avS;
    }

    public List<a> ajJ() {
        return this.csX;
    }
}
