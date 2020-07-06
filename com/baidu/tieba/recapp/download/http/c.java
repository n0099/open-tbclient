package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    private static String Lv;
    private static String Lw;
    private static boolean Lx;
    private static String Ly;
    private static String sUid;
    private long LG;
    private g lfE;
    private d lfF;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.LG = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bK(String str) {
        Lv = str;
    }

    public static void setUserAgent(String str) {
        Lw = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lfE = new g();
        a(this.lfE, z);
        this.lfE.cZi().setUrl(str);
        this.lfF = new d(this.lfE);
        this.lfF.d(i, i3, i4);
        return this.lfE.cZj();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lfE = new g();
        a(this.lfE, z);
        this.lfE.cZi().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lfE.cZi().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lfE.cZi().s(next.getName(), next.getValue());
            }
        }
        this.lfF = new d(this.lfE);
        this.lfF.f(i, i2, -1);
        return this.lfE.cZj();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.lfE = new g();
        b(this.lfE);
        this.lfE.cZi().setUrl(str);
        this.lfF = new d(this.lfE);
        return this.lfF.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.lfF != null) {
            this.lfF.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lfF != null) {
            return this.lfF.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.lfF != null) {
            this.lfF.setCancel();
        }
    }

    public g cZh() {
        return this.lfE;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Lv)) {
                gVar.cZi().s(SM.COOKIE, Lv);
            } else {
                gVar.cZi().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cZi().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Lw)) {
                gVar.cZi().s("User-Agent", Lw);
            }
            if (z) {
                gVar.cZi().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cZi().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Lx) {
                gVar.cZi().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cZi().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cZi().s("client_logid", String.valueOf(this.LG));
            if (!TextUtils.isEmpty(Ly)) {
                gVar.cZi().s("cuid", Ly);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
