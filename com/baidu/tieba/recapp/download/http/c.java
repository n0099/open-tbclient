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
/* loaded from: classes26.dex */
public class c {
    private static String ME;
    private static String MF;
    private static boolean MG;
    private static String MH;
    private static String sUid;
    private long MP;
    private g mbR;
    private d mbS;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.MP = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        ME = str;
    }

    public static void setUserAgent(String str) {
        MF = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mbR = new g();
        a(this.mbR, z);
        this.mbR.duU().setUrl(str);
        this.mbS = new d(this.mbR);
        this.mbS.d(i, i3, i4);
        return this.mbR.duV();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mbR = new g();
        a(this.mbR, z);
        this.mbR.duU().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mbR.duU().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mbR.duU().u(next.getName(), next.getValue());
            }
        }
        this.mbS = new d(this.mbR);
        this.mbS.f(i, i2, -1);
        return this.mbR.duV();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mbR = new g();
        b(this.mbR);
        this.mbR.duU().setUrl(str);
        this.mbS = new d(this.mbR);
        return this.mbS.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mbS != null) {
            this.mbS.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mbS != null) {
            return this.mbS.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mbS != null) {
            this.mbS.setCancel();
        }
    }

    public g duT() {
        return this.mbR;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(ME)) {
                gVar.duU().u(SM.COOKIE, ME);
            } else {
                gVar.duU().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.duU().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MF)) {
                gVar.duU().u("User-Agent", MF);
            }
            if (z) {
                gVar.duU().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.duU().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MG) {
                gVar.duU().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.duU().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.duU().u("client_logid", String.valueOf(this.MP));
            if (!TextUtils.isEmpty(MH)) {
                gVar.duU().u("cuid", MH);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
