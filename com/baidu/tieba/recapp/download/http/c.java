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
    private g gCO;
    private d gCP;

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
        this.gCO = new g();
        a(this.gCO, z);
        this.gCO.bot().setUrl(str);
        this.gCP = new d(this.gCO);
        this.gCP.m(i, i3, i4);
        return this.gCO.bou();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gCO = new g();
        a(this.gCO, z);
        this.gCO.bot().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gCO.bot().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gCO.bot().o(next.getName(), next.getValue());
            }
        }
        this.gCP = new d(this.gCO);
        this.gCP.o(i, i2, -1);
        return this.gCO.bou();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gCO = new g();
        b(this.gCO);
        this.gCO.bot().setUrl(str);
        this.gCP = new d(this.gCO);
        return this.gCP.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gCP != null) {
            this.gCP.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gCP != null) {
            return this.gCP.mU();
        }
        return false;
    }

    public void mV() {
        if (this.gCP != null) {
            this.gCP.mV();
        }
    }

    public g bos() {
        return this.gCO;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(ajA)) {
                gVar.bot().o(SM.COOKIE, ajA);
            } else {
                gVar.bot().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ajC)) {
                gVar.bot().o("client_user_token", ajC);
            }
            if (!TextUtils.isEmpty(ajB)) {
                gVar.bot().o(HTTP.USER_AGENT, ajB);
            }
            if (z) {
                gVar.bot().o("Accept-Encoding", "gzip");
            } else {
                gVar.bot().o("Accept-Encoding", "");
            }
            if (ajD) {
                gVar.bot().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bot().o(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bot().o("client_logid", String.valueOf(this.ajH));
            if (!TextUtils.isEmpty(ajE)) {
                gVar.bot().o("cuid", ajE);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
