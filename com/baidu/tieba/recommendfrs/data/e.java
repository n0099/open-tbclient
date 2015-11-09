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
    private boolean cJP;
    private List<a> cKm;
    private long cKn;
    private int cKo;
    private boolean hasMore;
    private final String tag;
    private List<Object> auO = new ArrayList();
    private boolean cKp = false;
    private boolean cKq = false;
    private boolean cKr = false;

    public e(String str) {
        this.tag = str;
        if (TextUtils.equals(this.tag, "头条")) {
            this.cJP = true;
        } else {
            this.cJP = false;
        }
    }

    public boolean aqK() {
        return this.cJP;
    }

    public void kD(int i) {
        this.cKo = i;
    }

    public int aqL() {
        return this.cKo;
    }

    public boolean aqM() {
        return this.cKq;
    }

    public boolean aqN() {
        return this.cKr;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, g gVar, boolean z2) {
        if (z) {
            this.cKr = true;
        } else {
            this.cKq = true;
        }
        if (gVar != null) {
            if (!z2) {
                this.cKp = false;
            }
            this.hasMore = gVar.getHasMore();
            List<Object> a = a(z2, gVar);
            if (z2) {
                this.auO.addAll(a);
                return;
            }
            this.auO = a;
            if (this.auO != null && this.auO.size() > 0) {
                this.cKm = gVar.aqR();
            } else {
                this.cKm = null;
            }
        }
    }

    private boolean b(FineThreadInfo fineThreadInfo) {
        int size;
        if (fineThreadInfo != null && (size = this.auO.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.auO.get(i);
                if ((obj instanceof FineThreadInfo) && fineThreadInfo.ftid == ((FineThreadInfo) obj).ftid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private List<Object> a(boolean z, g gVar) {
        List<Hot_Thread> aqS;
        ArrayList arrayList = new ArrayList();
        if (gVar == null || gVar.aqT() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : gVar.aqT()) {
            if (everydayThread.show_time != null) {
                i = everydayThread.show_time.intValue();
            }
            if (this.cJP && ((z || !arrayList.isEmpty()) && i != this.cKn)) {
                str = j.d(new Date(i * 1000));
                arrayList.add(str);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (this.cJP && StringUtils.isNull(str)) {
                    str = j.d(new Date(i * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null && (!z || !b(fineThreadInfo))) {
                        b bVar = new b();
                        bVar.a(fineThreadInfo);
                        bVar.lg(str);
                        bVar.setShowImage(gVar.aqV());
                        bVar.fR(i2 != size + (-1));
                        if (bVar.aqH() != 33) {
                            arrayList.add(bVar);
                        } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            arrayList.add(bVar);
                        }
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cKn && !this.cKp && (aqS = gVar.aqS()) != null && aqS.size() > 0) {
            this.cKp = true;
            arrayList.add(new d("text_type_title", str));
            arrayList.addAll(a(aqS, str, gVar.aqV()));
            arrayList.add(new d("text_type_check_more", str));
        }
        this.cKn = i;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Object obj = arrayList.get(arrayList.size() - 1);
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (this.cJP) {
                bVar2.fR(false);
            } else {
                bVar2.fR(true);
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

    public List<Object> aqO() {
        return this.auO;
    }

    public List<a> aqP() {
        return this.cKm;
    }
}
