package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String ajG;
    private static String ajH;
    private static String ajI;
    private static boolean ajJ;
    private static String ajK;
    private long ajN;
    private g gDd;
    private d gDe;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajN = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        ajH = str;
    }

    public static void setUid(String str) {
        ajI = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gDd = new g();
        a(this.gDd, z);
        this.gDd.bou().setUrl(str);
        this.gDe = new d(this.gDd);
        this.gDe.m(i, i3, i4);
        return this.gDd.bov();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gDd = new g();
        a(this.gDd, z);
        this.gDd.bou().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gDd.bou().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gDd.bou().o(next.getName(), next.getValue());
            }
        }
        this.gDe = new d(this.gDd);
        this.gDe.o(i, i2, -1);
        return this.gDd.bov();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gDd = new g();
        b(this.gDd);
        this.gDd.bou().setUrl(str);
        this.gDe = new d(this.gDd);
        return this.gDe.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gDe != null) {
            this.gDe.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gDe != null) {
            return this.gDe.mU();
        }
        return false;
    }

    public void mV() {
        if (this.gDe != null) {
            this.gDe.mV();
        }
    }

    public g bot() {
        return this.gDd;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(ajG)) {
                gVar.bou().o(SM.COOKIE, ajG);
            } else {
                gVar.bou().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajI)) {
                gVar.bou().o("client_user_token", ajI);
            }
            if (!TextUtils.isEmpty(ajH)) {
                gVar.bou().o(HTTP.USER_AGENT, ajH);
            }
            if (z) {
                gVar.bou().o("Accept-Encoding", "gzip");
            } else {
                gVar.bou().o("Accept-Encoding", "");
            }
            if (ajJ) {
                gVar.bou().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bou().o(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bou().o("client_logid", String.valueOf(this.ajN));
            if (!TextUtils.isEmpty(ajK)) {
                gVar.bou().o("cuid", ajK);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
