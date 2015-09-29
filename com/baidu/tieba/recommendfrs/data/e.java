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
    private boolean cHU;
    private List<a> cIr;
    private long cIs;
    private int cIt;
    private boolean hasMore;
    private final String tag;
    private List<Object> avZ = new ArrayList();
    private boolean cIu = false;
    private boolean cIv = false;
    private boolean cIw = false;

    public e(String str) {
        this.tag = str;
        if (TextUtils.equals(this.tag, "头条")) {
            this.cHU = true;
        } else {
            this.cHU = false;
        }
    }

    public boolean aqc() {
        return this.cHU;
    }

    public void kn(int i) {
        this.cIt = i;
    }

    public int aqd() {
        return this.cIt;
    }

    public boolean aqe() {
        return this.cIv;
    }

    public boolean aqf() {
        return this.cIw;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, g gVar, boolean z2) {
        if (z) {
            this.cIw = true;
        } else {
            this.cIv = true;
        }
        if (gVar != null) {
            if (!z2) {
                this.cIu = false;
            }
            this.hasMore = gVar.getHasMore();
            List<Object> a = a(z2, gVar);
            if (z2) {
                this.avZ.addAll(a);
                return;
            }
            this.avZ = a;
            if (this.avZ != null && this.avZ.size() > 0) {
                this.cIr = gVar.aqj();
            } else {
                this.cIr = null;
            }
        }
    }

    private boolean b(FineThreadInfo fineThreadInfo) {
        int size;
        if (fineThreadInfo != null && (size = this.avZ.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.avZ.get(i);
                if ((obj instanceof FineThreadInfo) && fineThreadInfo.ftid == ((FineThreadInfo) obj).ftid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private List<Object> a(boolean z, g gVar) {
        List<Hot_Thread> aqk;
        ArrayList arrayList = new ArrayList();
        if (gVar == null || gVar.aql() == null) {
            return arrayList;
        }
        String str = null;
        int i = 0;
        for (EverydayThread everydayThread : gVar.aql()) {
            if (everydayThread.show_time != null) {
                i = everydayThread.show_time.intValue();
            }
            if (this.cHU && ((z || !arrayList.isEmpty()) && i != this.cIs)) {
                str = j.d(new Date(i * 1000));
                arrayList.add(str);
            }
            List<FineThreadInfo> list = everydayThread.fine_thread_list;
            if (list != null) {
                if (this.cHU && StringUtils.isNull(str)) {
                    str = j.d(new Date(i * 1000));
                }
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    FineThreadInfo fineThreadInfo = list.get(i2);
                    if (fineThreadInfo != null && (!z || !b(fineThreadInfo))) {
                        b bVar = new b();
                        bVar.a(fineThreadInfo);
                        bVar.kZ(str);
                        bVar.setShowImage(gVar.aqn());
                        bVar.fO(i2 != size + (-1));
                        if (bVar.apZ() != 33) {
                            arrayList.add(bVar);
                        } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            arrayList.add(bVar);
                        }
                    }
                    i2++;
                }
            }
        }
        if (i >= this.cIs && !this.cIu && (aqk = gVar.aqk()) != null && aqk.size() > 0) {
            this.cIu = true;
            arrayList.add(new d("text_type_title", str));
            arrayList.addAll(a(aqk, str, gVar.aqn()));
            arrayList.add(new d("text_type_check_more", str));
        }
        this.cIs = i;
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Object obj = arrayList.get(arrayList.size() - 1);
        if (obj instanceof b) {
            b bVar2 = (b) obj;
            if (this.cHU) {
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

    public List<Object> aqg() {
        return this.avZ;
    }

    public List<a> aqh() {
        return this.cIr;
    }
}
