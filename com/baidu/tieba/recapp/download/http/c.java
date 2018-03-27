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
    private static String ajA;
    private static String ajB;
    private static String ajC;
    private static boolean ajD;
    private static String ajE;
    private long ajH;
    private g gDe;
    private d gDf;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ajH = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        ajB = str;
    }

    public static void setUid(String str) {
        ajC = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gDe = new g();
        a(this.gDe, z);
        this.gDe.bou().setUrl(str);
        this.gDf = new d(this.gDe);
        this.gDf.m(i, i3, i4);
        return this.gDe.bov();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gDe = new g();
        a(this.gDe, z);
        this.gDe.bou().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gDe.bou().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gDe.bou().o(next.getName(), next.getValue());
            }
        }
        this.gDf = new d(this.gDe);
        this.gDf.o(i, i2, -1);
        return this.gDe.bov();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gDe = new g();
        b(this.gDe);
        this.gDe.bou().setUrl(str);
        this.gDf = new d(this.gDe);
        return this.gDf.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gDf != null) {
            this.gDf.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gDf != null) {
            return this.gDf.mU();
        }
        return false;
    }

    public void mV() {
        if (this.gDf != null) {
            this.gDf.mV();
        }
    }

    public g bot() {
        return this.gDe;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(ajA)) {
                gVar.bou().o(SM.COOKIE, ajA);
            } else {
                gVar.bou().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajC)) {
                gVar.bou().o("client_user_token", ajC);
            }
            if (!TextUtils.isEmpty(ajB)) {
                gVar.bou().o(HTTP.USER_AGENT, ajB);
            }
            if (z) {
                gVar.bou().o("Accept-Encoding", "gzip");
            } else {
                gVar.bou().o("Accept-Encoding", "");
            }
            if (ajD) {
                gVar.bou().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bou().o(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bou().o("client_logid", String.valueOf(this.ajH));
            if (!TextUtils.isEmpty(ajE)) {
                gVar.bou().o("cuid", ajE);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
