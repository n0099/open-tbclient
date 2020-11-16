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
/* loaded from: classes25.dex */
public class c {
    private static String MF;
    private static String MG;
    private static boolean MH;
    private static String MI;
    private static String sUid;
    private long MQ;
    private g muD;
    private d muE;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.MQ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        MF = str;
    }

    public static void setUserAgent(String str) {
        MG = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.muD = new g();
        a(this.muD, z);
        this.muD.dAd().setUrl(str);
        this.muE = new d(this.muD);
        this.muE.d(i, i3, i4);
        return this.muD.dAe();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.muD = new g();
        a(this.muD, z);
        this.muD.dAd().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.muD.dAd().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.muD.dAd().u(next.getName(), next.getValue());
            }
        }
        this.muE = new d(this.muD);
        this.muE.f(i, i2, -1);
        return this.muD.dAe();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.muD = new g();
        b(this.muD);
        this.muD.dAd().setUrl(str);
        this.muE = new d(this.muD);
        return this.muE.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.muE != null) {
            this.muE.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.muE != null) {
            return this.muE.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.muE != null) {
            this.muE.setCancel();
        }
    }

    public g dAc() {
        return this.muD;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MF)) {
                gVar.dAd().u(SM.COOKIE, MF);
            } else {
                gVar.dAd().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dAd().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MG)) {
                gVar.dAd().u("User-Agent", MG);
            }
            if (z) {
                gVar.dAd().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dAd().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MH) {
                gVar.dAd().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dAd().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dAd().u("client_logid", String.valueOf(this.MQ));
            if (!TextUtils.isEmpty(MI)) {
                gVar.dAd().u("cuid", MI);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
