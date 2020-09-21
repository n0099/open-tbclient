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
    private static String Mn;
    private static String Mo;
    private static boolean Mp;
    private static String Mq;
    private static String sUid;
    private long Mw;
    private g lMA;
    private d lMB;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Mw = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        Mn = str;
    }

    public static void setUserAgent(String str) {
        Mo = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lMA = new g();
        a(this.lMA, z);
        this.lMA.drj().setUrl(str);
        this.lMB = new d(this.lMA);
        this.lMB.d(i, i3, i4);
        return this.lMA.drk();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lMA = new g();
        a(this.lMA, z);
        this.lMA.drj().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lMA.drj().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lMA.drj().u(next.getName(), next.getValue());
            }
        }
        this.lMB = new d(this.lMA);
        this.lMB.f(i, i2, -1);
        return this.lMA.drk();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.lMA = new g();
        b(this.lMA);
        this.lMA.drj().setUrl(str);
        this.lMB = new d(this.lMA);
        return this.lMB.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.lMB != null) {
            this.lMB.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lMB != null) {
            return this.lMB.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.lMB != null) {
            this.lMB.setCancel();
        }
    }

    public g dri() {
        return this.lMA;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Mn)) {
                gVar.drj().u(SM.COOKIE, Mn);
            } else {
                gVar.drj().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.drj().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Mo)) {
                gVar.drj().u("User-Agent", Mo);
            }
            if (z) {
                gVar.drj().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.drj().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Mp) {
                gVar.drj().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.drj().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.drj().u("client_logid", String.valueOf(this.Mw));
            if (!TextUtils.isEmpty(Mq)) {
                gVar.drj().u("cuid", Mq);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
